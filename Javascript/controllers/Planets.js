'use strict';

var utils = require('../utils/writer.js');
var Planets = require('../service/PlanetsService');

module.exports.addPlanet = function addPlanet (req, res, next, body) {
  Planets.addPlanet(body)
    .then(function (response) {
      utils.writeJson(res, response, 200);    
    })
    .catch(function (response) {
      switch(response.code) {
        case 'ER_NO_DB_ERROR':
          utils.writeJson(res, response, 404);
          break;
        case 'ER_NO_REFERENCED_ROW_2':
        case 'ER_DUP_ENTRY':
          utils.writeJson(res, response, 409);
          break;
        default:
          console.log(response.code)
          utils.writeJson(res, response, 400);
      }
    });
};

module.exports.deletePlanet = function deletePlanet (req, res, next, name) {
  Planets.deletePlanet(name)
    .then(function (response) {
      if(response.affectedRows >= 1){
        utils.writeJson(res, response, 200);
      }else{
        utils.writeJson(res, response, 404);
      }
    })
    .catch(function (response) {
      utils.writeJson(res, response, 400);
    });
};

module.exports.getPlanet = function getPlanet (req, res, next, name) {
  Planets.getPlanet(name)
    .then(function (response) {
      if(response[0].length > 0){
        utils.writeJson(res, response, 200);
      }else{
        utils.writeJson(res, response, 404);
      }
    })
    .catch(function (response) {
      utils.writeJson(res, response, 400);
    });
};

module.exports.getTerrain = function getTerrain (req, res, next, terrain) {
  Planets.getTerrain(terrain)
    .then(function (response) {
      if(response[0].length > 0){
        utils.writeJson(res, response, 200);
      }else{
        utils.writeJson(res, response, 404);
      }
    })
    .catch(function (response) {
      utils.writeJson(res, response, 400);
    });
};

module.exports.getUninhabited = function getUninhabited (req, res, next) {
  Planets.getUninhabited()
    .then(function (response) {
      if(response[0].length > 0){
        utils.writeJson(res, response, 200);
      }else{
        utils.writeJson(res, response, 404);
      }
    })
    .catch(function (response) {
      utils.writeJson(res, response, 400);
    });
};

module.exports.updatePlanet = function updatePlanet (req, res, next, body) {
  Planets.updatePlanet(body)
    .then(function (response) {
      if(response.affectedRows >= 1){
        utils.writeJson(res, response, 200);
      }else{
        utils.writeJson(res, response, 404);
      }
    })
    .catch(function (response) {
      if(response.code == 'ER_NO_REFERENCED_ROW_2'){
        utils.writeJson(res, response, 409);
      }else{
        utils.writeJson(res, response, 400);
      }
    });
};
