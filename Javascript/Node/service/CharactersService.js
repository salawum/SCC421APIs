'use strict';
const mariadb = require('mariadb');
require('dotenv').config()
const pool = mariadb.createPool({
  host: process.env.DB_HOST, 
  user: process.env.DB_USER, 
  password: process.env.DB_PWD,
  connectionLimit: 5
});


exports.addCharacter = function(body){
  return new Promise(async function(resolve, reject){
    let conn;
    try{
      conn = await pool.getConnection();
      const res = await conn.query(
        "CALL starwars.addCharacter(?,?,?,?,?,?,?,?,?,?);",
        [ body.name, body.height, body.mass, body.hair_color, body.skin_color, body.eye_color,
          body.birth_year, body.gender, body.homeworld, body.species ]
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
 * Delete a character from the database
 *
 * name String 
 * no response value expected for this operation
 **/
exports.deleteCharacter = function(name) {
  return new Promise(async function(resolve, reject){
    let conn;
    try{
      conn = await pool.getConnection();
      const res = await conn.query(
        "CALL starwars.deleteCharacter(?);",
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
 * Get a character from the database
 *
 * name String 
 * returns Character
 **/
exports.getCharacter = function(name) {
  return new Promise(async function(resolve, reject) {
    let conn;
    try{
      conn = await pool.getConnection();
      const res = await conn.query(
        "CALL starwars.getCharacter(?);",
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
 * Get a list of all charcaters with mass greater than or equal to the specified mass value
 *
 * mass Integer 
 * returns CharacterList
 **/
exports.getMass = function(mass) {
  return new Promise(async function(resolve, reject) {
    let conn;
    try{
      conn = await pool.getConnection();
      const res = await conn.query(
        "CALL starwars.getMass(?);",
        [mass]
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
 * Update an existing Character object
 *
 * body Character Character object to be updated
 * no response value expected for this operation
 **/
exports.updateCharacter = function(body) {
  return new Promise(async function(resolve, reject) {
    let conn;
    try{
      conn = await pool.getConnection();
      const res = await conn.query(
        "CALL starwars.updateCharacter(?,?,?,?,?,?,?,?,?,?);",
        [ body.name, body.height, body.mass, body.hair_color, body.skin_color, body.eye_color,
          body.birth_year, body.gender, body.homeworld, body.species, body.name ]
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