import connexion
import six
import mariadb
import os
import sys

from swagger_server.models.character import Character  # noqa: E501
from swagger_server.models.character_list import CharacterList  # noqa: E501
from swagger_server import util
from flask import Response

USERNAME = os.getenv('DB_USR', 'root')
PASSWORD = os.getenv('DB_PWD', 'root')
HOST = os.getenv('DB_HOST', 'localhost')
PORT = os.getenv('DB_PORT', 3306)

try:
    pool = mariadb.ConnectionPool(
        user = USERNAME,
        password = PASSWORD,
        host = HOST,
        port = PORT,
        pool_name = "connPoolCharacters",
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
        

def add_character(body):  # noqa: E501
    """Add a character to the database

     # noqa: E501

    :param body: Character object to be added to the database
    :type body: dict | bytes

    :rtype: None
    """
    if connexion.request.is_json:
        body = Character.from_dict(connexion.request.get_json())  # noqa: E501
        try:
            conn, cur = get_conn()
            cur.callproc("starwars.addCharacter",
            (   body.name, body.height, body.mass, body.hair_color, body.skin_color, body.eye_color,
                body.birth_year, body.gender, body.homeworld, body.species ))
            if(cur.rowcount == 1):
                cur.execute("SELECT * FROM starwars.characters WHERE name = ?;", (body.name,))
                query_response = cur.fetchone()
                print(query_response)
                res = {
                    "name" : f"{query_response[1]}",
                    "height" : f"{query_response[2]}",
                    "mass" : f"{query_response[3]}",
                    "hair_color" : f"{query_response[4]}",
                    "skin_color" : f"{query_response[5]}",
                    "eye_color" : f"{query_response[6]}",
                    "birth_year" : f"{query_response[7]}",
                    "gender" : f"{query_response[8]}",
                    "homeworld" : f"{query_response[9]}",
                    "species" : f"{query_response[10]}"
                }
                return Response(f"{res}", status=200, mimetype='application/json')
            return Response("{'status': 404}", status=404, mimetype='application/json')
        except mariadb.Error as e:
            return catch_error(e)
        finally:
            if conn:
                cur.close()
                conn.close()


def delete_character(name):  # noqa: E501
    """Delete a character from the database

     # noqa: E501

    :param name: 
    :type name: str

    :rtype: None
    """
    try:
        conn, cur = get_conn()
        cur.callproc("starwars.deleteCharacter", (name,))
        if(cur.rowcount >= 1):
            return Response("{'status':200}", status=200, mimetype='application/json')
        return Response("{'status':404}", status=404, mimetype='application/json')
    except mariadb.Error as e:
        return catch_error(e)
    finally:
        if conn:
            cur.close()
            conn.close()


def get_character(name):  # noqa: E501
    """Get a character from the database

     # noqa: E501

    :param name: 
    :type name: str

    :rtype: Character
    """
    try:
        conn, cur = get_conn()
        cur.callproc("starwars.getCharacter", (name,))
        x = cur.fetchone()
        if(x is not None and x[0] == name):
            return Response("{'name':\"" + name + "\"}", status=200, mimetype='application/json')
        return Response("{'status':404}", status=404, mimetype='application/json')
    except mariadb.Error as e:
        return catch_error(e)
    finally:
        if conn:
            cur.close()
            conn.close()


def get_mass(mass):  # noqa: E501
    """Get a list of all charcaters with mass greater than or equal to the specified mass value

     # noqa: E501

    :param mass: 
    :type mass: int

    :rtype: CharacterList
    """
    try:
        conn, cur = get_conn()
        cur.callproc("starwars.getMass", (mass,))
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


def update_character(body):  # noqa: E501
    """Update an existing Character object

     # noqa: E501

    :param body: Character object to be updated
    :type body: dict | bytes

    :rtype: None
    """
    if connexion.request.is_json:
        body = Character.from_dict(connexion.request.get_json())  # noqa: E501
        try:
            conn, cur = get_conn()
            cur.callproc("starwars.updateCharacter",
            (   body.name, body.height, body.mass, body.hair_color, body.skin_color, body.eye_color,
                body.birth_year, body.gender, body.homeworld, body.species ))
            if(cur.rowcount == 1):
                cur.execute("SELECT * FROM starwars.characters WHERE name = ?;", (body.name,))
                query_response = cur.fetchone()
                print(query_response)
                res = {
                    "name" : f"{query_response[1]}",
                    "height" : f"{query_response[2]}",
                    "mass" : f"{query_response[3]}",
                    "hair_color" : f"{query_response[4]}",
                    "skin_color" : f"{query_response[5]}",
                    "eye_color" : f"{query_response[6]}",
                    "birth_year" : f"{query_response[7]}",
                    "gender" : f"{query_response[8]}",
                    "homeworld" : f"{query_response[9]}",
                    "species" : f"{query_response[10]}"
                }
                return Response(f"{res}", status=200, mimetype='application/json')
            return Response("{'status': 404}, {'message':'name not found or has already been updated'}", status=404, mimetype='application/json')
        except mariadb.Error as e:
            return catch_error(e)
        finally:
            if conn:
                cur.close()
                conn.close()
