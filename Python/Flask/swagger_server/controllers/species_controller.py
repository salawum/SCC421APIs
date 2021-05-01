import connexion
import six
import mariadb
import os
import sys

from swagger_server.models.species import Species  # noqa: E501
from swagger_server.models.species_list import SpeciesList  # noqa: E501
from swagger_server import util
from flask import Response

USERNAME = os.getenv('DB_USER', 'root')
PASSWORD = os.getenv('DB_PWD', 'root')
HOST = os.getenv('DB_HOST', 'localhost')
PORT = os.getenv('DB_PORT', 3306)

try:
    pool = mariadb.ConnectionPool(
        user = USERNAME,
        password = PASSWORD,
        host = HOST,
        port = PORT,
        pool_name = "connPoolSpecies",
        pool_size = 5,

    )
except mariadb.Error as e:
    print(f"Error connecting opening connection from pool: {e}")
    sys.exit(1)


def get_conn():
    conn = pool.get_connection()
    conn.autocommit = True
    cur = conn.cursor()
    return conn, cur


def catch_error(e):
    err = {"error": f"{e}"}
    print(err)
    if("Duplicate entry" in err["error"]):
        return Response(f"{err}", status=409, mimetype='application/json')
    elif("Invalid cursor or not connected" in err["error"]):
        return Response(f"{err}", status=500, mimetype='application/json')
    return Response(f"{err}", status=400, mimetype='application/json')


def add_species(body):  # noqa: E501
    """Add a species to the database

     # noqa: E501

    :param body: Species object to be added to the database
    :type body: dict | bytes

    :rtype: None
    """
    if connexion.request.is_json:
        body = Species.from_dict(connexion.request.get_json())  # noqa: E501
        try:
            conn, cur = get_conn()
            cur.callproc("starwars.addSpecies",
            (   body.name, body.classification, body.designation, body.average_height, body.skin_colors, body.hair_colours,
                body.eye_colors, body.average_lifespan, body.language, body.homeworld ))
            if(cur.rowcount == 1):
                cur.execute("SELECT * FROM starwars.species WHERE name = ?;", (body.name,))
                query_response = cur.fetchone()
                print(query_response)
                res = {
                    "name" : f"{query_response[1]}",
                    "classification" : f"{query_response[2]}",
                    "designation" : f"{query_response[3]}",
                    "average_height" : f"{query_response[4]}",
                    "skin_colors" : f"{query_response[5]}",
                    "hair_colours" : f"{query_response[6]}",
                    "eye_colors" : f"{query_response[7]}",
                    "average_lifespan" : f"{query_response[8]}",
                    "language" : f"{query_response[9]}",
                    "homeworld" : f"{query_response[10]}"
                }
                return Response(f"{res}", status=200, mimetype='application/json')
            return Response("{'status': 404}", status=404, mimetype='application/json')
        except mariadb.Error as e:
            return catch_error(e)
        finally:
            if conn:
                cur.close()
                conn.close()


def delete_species(name):  # noqa: E501
    """Delete a species from the database

     # noqa: E501

    :param name: 
    :type name: str

    :rtype: None
    """
    try:
        conn, cur = get_conn()
        cur.callproc("starwars.deleteSpecies", (name,))
        if(cur.rowcount >= 1):
            return Response("{'status':200}", status=200, mimetype='application/json')
        return Response("{'status':404}", status=404, mimetype='application/json')
    except mariadb.Error as e:
        return catch_error(e)
    finally:
        if conn:
            cur.close()
            conn.close()


def get_eye_color(eye_color):  # noqa: E501
    """Get a list of species with the specified eye color

     # noqa: E501

    :param eye_color: 
    :type eye_color: str

    :rtype: SpeciesList
    """
    try:
        conn, cur = get_conn()
        cur.callproc("starwars.getEyeColor", (eye_color,))
        x = cur.fetchall()
        if(x is not None):
            names = []
            for name in x:
                names.append({"name": name[0]})
            if(names != []):
                return Response(f"{names}", status=200, mimetype='application/json')
        return Response("{'status':404}", status=404, mimetype='application/json')
    except mariadb.Error as e:
        return catch_error(e)
    finally:
        if conn:
            cur.close()
            conn.close()


def get_species(name):  # noqa: E501
    """Get a species from the database

     # noqa: E501

    :param name: 
    :type name: str

    :rtype: Species
    """
    try:
        conn, cur = get_conn()
        cur.callproc("starwars.getSpecies", (name,))
        query_response = cur.fetchone()
        if(query_response is not None and query_response[1] == name):
            print(query_response)
            res = {
                "name" : f"{query_response[1]}",
                "classification" : f"{query_response[2]}",
                "designation" : f"{query_response[3]}",
                "average_height" : f"{query_response[4]}",
                "skin_colors" : f"{query_response[5]}",
                "hair_colours" : f"{query_response[6]}",
                "eye_colors" : f"{query_response[7]}",
                "average_lifespan" : f"{query_response[8]}",
                "language" : f"{query_response[9]}",
                "homeworld" : f"{query_response[10]}"
            }
            return Response(f"{res}", status=200, mimetype='application/json')
        return Response("{'status':404}", status=404, mimetype='application/json')
    except mariadb.Error as e:
        return catch_error(e)
    finally:
        if conn:
            cur.close()
            conn.close()


def update_species(body):  # noqa: E501
    """Update an existing species

     # noqa: E501

    :param body: Species object to be updated
    :type body: dict | bytes

    :rtype: None
    """
    if connexion.request.is_json:
        body = Species.from_dict(connexion.request.get_json())  # noqa: E501
        try:
            conn, cur = get_conn()
            cur.callproc("starwars.updateSpecies",
            (   body.name, body.classification, body.designation, body.average_height, body.skin_colors, body.hair_colours,
                body.eye_colors, body.average_lifespan, body.language, body.homeworld ))
            if(cur.rowcount == 1):
                cur.execute("SELECT * FROM starwars.species WHERE name = ?;", (body.name,))
                query_response = cur.fetchone()
                print(query_response)
                res = {
                    "name" : f"{query_response[1]}",
                    "classification" : f"{query_response[2]}",
                    "designation" : f"{query_response[3]}",
                    "average_height" : f"{query_response[4]}",
                    "skin_colors" : f"{query_response[5]}",
                    "hair_colours" : f"{query_response[6]}",
                    "eye_colors" : f"{query_response[7]}",
                    "average_lifespan" : f"{query_response[8]}",
                    "language" : f"{query_response[9]}",
                    "homeworld" : f"{query_response[10]}"
                }
                return Response(f"{res}", status=200, mimetype='application/json')
            return Response("{'status': 404}, {'message':'name not found or has already been updated'}", status=404, mimetype='application/json')
        except mariadb.Error as e:
            return catch_error(e)
        finally:
            if conn:
                cur.close()
                conn.close()
