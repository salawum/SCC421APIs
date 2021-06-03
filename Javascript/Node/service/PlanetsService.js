'use strict';
const mariadb = require('mariadb');
require('dotenv').config()
const pool = mariadb.createPool({
  host: process.env.DB_HOST, 
  user: process.env.DB_USER, 
  password: process.env.DB_PWD,
  connectionLimit: 5
});


exports.addPlanet = function(body) {
  return new Promise(async function(resolve, reject) {
    let conn;
    try{
      conn = await pool.getConnection();
      const res = await conn.query(
        "CALL starwars.addPlanet(?,?,?,?,?,?,?,?,?);",
        [ body.name, body.rotation_period, body.rotation_period, body.diameter, body.climate,
          body.gravity, body.terrain, body.surface_water, body.population ]
      );
      console.log(res);
      resolve(res);
    }catch (err) {
      console.log(err)
      reject(err);
    }finally {
      if (conn) {
        conn.end();
      }
    }
  });
}


exports.deletePlanet = function(name) {
  return new Promise(async function(resolve, reject) {
    let conn;
    try{
      conn = await pool.getConnection();
      const res = await conn.query(
        "CALL starwars.deletePlanet(?);",
        [name]
      );
      console.log(res);
      resolve(res);
    }catch (err) {
      console.log(err)
      reject(err);
    }finally {
      if (conn) {
        conn.end();
      }
    }
  });
}


/**
 * Get a planet from the database
 *
 * name String 
 * returns Planet
 **/
exports.getPlanet = function(name) {
  return new Promise(async function(resolve, reject) {
    let conn;
    try{
      conn = await pool.getConnection();
      const res = await conn.query(
        "CALL starwars.getPlanet(?);",
        [name]
      );
      console.log(res); // { affectedRows: 1, insertId: 1, warningStatus: 0 }
      resolve(res);
    }catch (err) {
      console.log(err)
      reject(err);
    }finally {
      if (conn) {
        conn.end();
      }
    }
  });
}


/**
 * Get a list of planets with the specified terrain type
 *
 * terrain String 
 * returns PlanetList
 **/
exports.getTerrain = function(terrain) {
  return new Promise(async function(resolve, reject) {
    let conn;
    try{
      conn = await pool.getConnection();
      const res = await conn.query(
        "CALL starwars.getTerrain(?);",
        [terrain]
      );
      console.log(res); // { affectedRows: 1, insertId: 1, warningStatus: 0 }
      resolve(res);
    }catch (err) {
      console.log(err)
      reject(err);
    }finally {
      if (conn) {
        conn.end();
      }
    }
  });
}


/**
 * Get a list of planets that are uninhabited
 *
 * returns PlanetList
 **/
exports.getUninhabited = function() {
  return new Promise(async function(resolve, reject) {
    let conn;
    try{
      conn = await pool.getConnection();
      const res = await conn.query(
        "CALL starwars.getUninhabited;"
      );
      console.log(res); // { affectedRows: 1, insertId: 1, warningStatus: 0 }
      resolve(res);
    }catch (err) {
      console.log(err)
      reject(err);
    }finally {
      if (conn) {
        conn.end();
      }
    }
  });
}


/**
 * Update an existing planet
 *
 * body Planet Planet object to be updated
 * no response value expected for this operation
 **/
exports.updatePlanet = function(body) {
  return new Promise(async function(resolve, reject) {
    let conn;
    try{
      conn = await pool.getConnection();
      const res = await conn.query(
        "CALL starwars.updatePlanet(?,?,?,?,?,?,?,?,?);",
        [ body.name, body.rotation_period, body.rotation_period, body.diameter, body.climate,
          body.gravity, body.terrain, body.surface_water, body.population ]
      );
      console.log(res); // { affectedRows: 1, insertId: 1, warningStatus: 0 }
      resolve(res);
    }catch (err) {
      console.log(err)
      reject(err);
    }finally {
      if (conn) {
        conn.end();
      }
    }
  });
}

