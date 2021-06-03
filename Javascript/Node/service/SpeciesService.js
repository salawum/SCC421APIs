'use strict';
const mariadb = require('mariadb');
require('dotenv').config()
const pool = mariadb.createPool({
  host: process.env.DB_HOST, 
  user: process.env.DB_USER, 
  password: process.env.DB_PWD,
  connectionLimit: 5
});


exports.addSpecies = function(body) {
  return new Promise(async function(resolve, reject) {
    let conn;
    try{
      conn = await pool.getConnection();
      const res = await conn.query(
        "CALL starwars.addSpecies(?,?,?,?,?,?,?,?,?,?);",
        [ body.name, body.classification, body.designation, body.average_height, body.skin_colors,
          body.hair_colours, body.eye_colors, body.average_lifespan, body.language, body.homeworld ]
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
 * Delete a species from the database
 *
 * name String 
 * no response value expected for this operation
 **/
exports.deleteSpecies = function(name) {
  return new Promise(async function(resolve, reject) {
    let conn;
    try{
      conn = await pool.getConnection();
      const res = await conn.query(
        "CALL starwars.deleteSpecies(?);",
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
 * Get a list of species with the specified eye color
 *
 * eye_color String 
 * returns SpeciesList
 **/
exports.getEyeColor = function(eye_color) {
  return new Promise(async function(resolve, reject) {
    let conn;
    try{
      conn = await pool.getConnection();
      const res = await conn.query(
        "CALL starwars.getEyeColor(?);",
        [eye_color]
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
 * Get a species from the database
 *
 * name String 
 * returns Species
 **/
exports.getSpecies = function(name) {
  return new Promise(async function(resolve, reject) {
    let conn;
    try{
      conn = await pool.getConnection();
      const res = await conn.query(
        "CALL starwars.getSpecies(?);",
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
 * Update an existing species
 *
 * body Species Species object to be updated
 * no response value expected for this operation
 **/
exports.updateSpecies = function(body) {
  return new Promise(async function(resolve, reject) {
    let conn;
    try{
      conn = await pool.getConnection();
      const res = await conn.query(
        "CALL starwars.updateSpecies(?,?,?,?,?,?,?,?,?,?);",
        [ body.name, body.classification, body.designation, body.average_height, body.skin_colors,
          body.hair_colours, body.eye_colors, body.average_lifespan, body.language, body.homeworld ]
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

