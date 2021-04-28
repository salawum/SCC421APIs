'use strict';

var utils = require('../utils/writer.js');
var Species = require('../service/SpeciesService');

module.exports.addSpecies = function addSpecies (req, res, next, body) {
  Species.addSpecies(body)
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

module.exports.deleteSpecies = function deleteSpecies (req, res, next, name) {
  Species.deleteSpecies(name)
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

module.exports.getEyeColor = function getEyeColor (req, res, next, eye_color) {
  Species.getEyeColor(eye_color)
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

module.exports.getSpecies = function getSpecies (req, res, next, name) {
  Species.getSpecies(name)
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

module.exports.updateSpecies = function updateSpecies (req, res, next, body) {
  Species.updateSpecies(body)
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
