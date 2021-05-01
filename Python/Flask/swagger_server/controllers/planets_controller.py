import connexion
import six
import mariadb
import os
import sys

from swagger_server.models.planet import Planet  # noqa: E501
from swagger_server.models.planet_list import PlanetList  # noqa: E501
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
        pool_name = "connPoolPlanets",
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


def add_planet(body):  # noqa: E501
    """Add a planet to the database

     # noqa: E501

    :param body: Planet object to be added to the database
    :type body: dict | bytes

    :rtype: None
    """
    if connexion.request.is_json:
        body = Planet.from_dict(connexion.request.get_json())  # noqa: E501
        try:
            conn, cur = get_conn()
            cur.callproc("starwars.addPlanet",
            (   body.name, body.rotation_period, body.orbital_period, body.diameter, body.climate, body.gravity,
                body.terrain, body.surface_water, body.population ))
            if(cur.rowcount == 1):
                cur.execute("SELECT * FROM starwars.planets WHERE name = ?;", (body.name,))
                query_response = cur.fetchone()
                print(query_response)
                res = {
                    "name" : f"{query_response[1]}",
                    "rotation_period" : f"{query_response[2]}",
                    "orbital_period" : f"{query_response[3]}",
                    "diameter" : f"{query_response[4]}",
                    "climate" : f"{query_response[5]}",
                    "gravity" : f"{query_response[6]}",
                    "terrain" : f"{query_response[7]}",
                    "surface_water" : f"{query_response[8]}",
                    "population" : f"{query_response[9]}"
                }
                return Response(f"{res}", status=200, mimetype='application/json')
            return Response("{'status': 404}", status=404, mimetype='application/json')
        except mariadb.Error as e:
            return catch_error(e)
        finally:
            if conn:
                cur.close()
                conn.close()


def delete_planet(name):  # noqa: E501
    """Delete a planet from the database

     # noqa: E501

    :param name: 
    :type name: str

    :rtype: None
    """
    try:
        conn, cur = get_conn()
        cur.callproc("starwars.deletePlanet", (name,))
        if(cur.rowcount >= 1):
            return Response("{'status':200}", status=200, mimetype='application/json')
        return Response("{'status':404}", status=404, mimetype='application/json')
    except mariadb.Error as e:
        return catch_error(e)
    finally:
        if conn:
            cur.close()
            conn.close()


def get_planet(name):  # noqa: E501
    """Get a planet from the database

     # noqa: E501

    :param name: 
    :type name: str

    :rtype: Planet
    """
    try:
        conn, cur = get_conn()
        cur.callproc("starwars.getPlanet", (name,))
        query_response = cur.fetchone()
        if(query_response is not None and query_response[1] == name):
            print(query_response)
            res = {
                "name" : f"{query_response[1]}",
                "rotation_period" : f"{query_response[2]}",
                "orbital_period" : f"{query_response[3]}",
                "diameter" : f"{query_response[4]}",
                "climate" : f"{query_response[5]}",
                "gravity" : f"{query_response[6]}",
                "terrain" : f"{query_response[7]}",
                "surface_water" : f"{query_response[8]}",
                "population" : f"{query_response[9]}"
            }
            return Response(f"{res}", status=200, mimetype='application/json')
        return Response("{'status':404}", status=404, mimetype='application/json')
    except mariadb.Error as e:
        return catch_error(e)
    finally:
        if conn:
            cur.close()
            conn.close()


def get_terrain(terrain):  # noqa: E501
    """Get a list of planets with the specified terrain type

     # noqa: E501

    :param terrain: 
    :type terrain: str

    :rtype: PlanetList
    """
    try:
        conn, cur = get_conn()
        cur.callproc("starwars.getTerrain", (terrain,))
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


def get_uninhabited():  # noqa: E501
    """Get a list of planets that are uninhabited

     # noqa: E501


    :rtype: PlanetList
    """
    try:
        conn, cur = get_conn()
        cur.callproc("starwars.getUninhabited")
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


def update_planet(body):  # noqa: E501
    """Update an existing planet

     # noqa: E501

    :param body: Planet object to be updated
    :type body: dict | bytes

    :rtype: None
    """
    if connexion.request.is_json:
        body = Planet.from_dict(connexion.request.get_json())  # noqa: E501
        try:
            conn, cur = get_conn()
            cur.callproc("starwars.updatePlanet",
            (   body.name, body.rotation_period, body.orbital_period, body.diameter, body.climate, body.gravity,
                body.terrain, body.surface_water, body.population ))
            if(cur.rowcount == 1):
                cur.execute("SELECT * FROM starwars.planets WHERE name = ?;", (body.name,))
                query_response = cur.fetchone()
                print(query_response)
                res = {
                    "name" : f"{query_response[1]}",
                    "rotation_period" : f"{query_response[2]}",
                    "orbital_period" : f"{query_response[3]}",
                    "diameter" : f"{query_response[4]}",
                    "climate" : f"{query_response[5]}",
                    "gravity" : f"{query_response[6]}",
                    "terrain" : f"{query_response[7]}",
                    "surface_water" : f"{query_response[8]}",
                    "population" : f"{query_response[9]}"
                }
                return Response(f"{res}", status=200, mimetype='application/json')
            return Response("{'status': 404}, {'message':'name not found or has already been updated'}", status=404, mimetype='application/json')
        except mariadb.Error as e:
            return catch_error(e)
        finally:
            if conn:
                cur.close()
                conn.close()
