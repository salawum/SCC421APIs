'use strict';

var utils = require('../utils/writer.js');
var Characters = require('../service/CharactersService');

module.exports.addCharacter = function addCharacter (req, res, next, body) {
  Characters.addCharacter(body)
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

module.exports.deleteCharacter = function deleteCharacter (req, res, next, name) {
  Characters.deleteCharacter(name)
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

module.exports.getCharacter = function getCharacter (req, res, next, name) {
  Characters.getCharacter(name)
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

module.exports.getMass = function getMass (req, res, next, mass) {
  Characters.getMass(mass)
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

module.exports.updateCharacter = function updateCharacter (req, res, next, body) {
  Characters.updateCharacter(body)
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
