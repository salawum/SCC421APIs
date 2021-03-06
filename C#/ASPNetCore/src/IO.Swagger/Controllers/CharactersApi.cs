/*
 * 4th Year Project
 *
 * (Will come up with a better name later)
 *
 * OpenAPI spec version: 1.0.0
 * 
 * Generated by: https://github.com/swagger-api/swagger-codegen.git
 */
using System;
using System.Collections.Generic;
using Microsoft.AspNetCore.Mvc;
using Swashbuckle.AspNetCore.Annotations;
using Swashbuckle.AspNetCore.SwaggerGen;
using Newtonsoft.Json;
using System.ComponentModel.DataAnnotations;
using IO.Swagger.Attributes;

using Microsoft.AspNetCore.Authorization;
using IO.Swagger.Models;

using MySqlConnector;
using System.Data;
using System.Threading.Tasks;

namespace IO.Swagger.Controllers
{
    /// <summary>
    /// 
    /// </summary>
    [ApiController]
    public class CharactersApiController : ControllerBase
    {
        /// <summary>
        /// Add a character to the database
        /// </summary>
        /// <param name="body">Character object to be added to the database</param>
        /// <response code="200">Successfully added character</response>
        /// <response code="400">Bad Request</response>
        /// <response code="404">Character not found</response>
        /// <response code="409">Conflict with existing data</response>

        [HttpPost]
        [Route("/character")]
        [ValidateModelState]
        [SwaggerOperation("AddCharacter")]
        public async virtual Task<IActionResult> AddCharacter([FromBody]Character body)
        {
            try {
                using var conn = new MySqlConnection(HelperFunctions.getConnString());
                using var cmd = new MySqlCommand("addCharacter", conn) {
                    CommandType = CommandType.StoredProcedure
                };

                cmd.Parameters.AddWithValue("@c_name", body.Name);
                cmd.Parameters.AddWithValue("@c_height", body.Height);
                cmd.Parameters.AddWithValue("@c_mass", body.Mass);
                cmd.Parameters.AddWithValue("@c_hair_color", body.HairColor);
                cmd.Parameters.AddWithValue("@c_skin_color", body.SkinColor);
                cmd.Parameters.AddWithValue("@c_eye_color", body.EyeColor);
                cmd.Parameters.AddWithValue("@c_birth_year", body.BirthYear);
                cmd.Parameters.AddWithValue("@c_gender", body.Gender);
                cmd.Parameters.AddWithValue("@c_homeworld", body.Homeworld);
                cmd.Parameters.AddWithValue("@c_species", body.Species);

                await conn.OpenAsync();
                MySqlDataReader rdr = await cmd.ExecuteReaderAsync();
                return StatusCode(200, body);
            } catch(Exception ex) {
                return HelperFunctions.ErrorStatusCode(ex);
            }
        }

        /// <summary>
        /// Delete a character from the database
        /// </summary>
        /// <param name="name"></param>
        /// <response code="200">Successfully deleted Character object from the database</response>
        /// <response code="400">Invalid name supplied</response>
        /// <response code="404">Character not found</response>
        [HttpDelete]
        [Route("/character/{name}")]
        [ValidateModelState]
        [SwaggerOperation("DeleteCharacter")]
        public async virtual Task<IActionResult> DeleteCharacter([FromRoute][Required]string name)
        {
            try {
                using var conn = new MySqlConnection(HelperFunctions.getConnString());
                using var cmd = new MySqlCommand("deleteCharacter", conn) {
                    CommandType = CommandType.StoredProcedure
                };

                cmd.Parameters.AddWithValue("@c_name", name);

                await conn.OpenAsync();
                MySqlDataReader rdr = await cmd.ExecuteReaderAsync();
                if(rdr.RecordsAffected >= 1) {
                    return StatusCode(200);
                }
                return StatusCode(404);
            } catch(Exception ex) {
                return HelperFunctions.ErrorStatusCode(ex);
            }
        }

        /// <summary>
        /// Get a character from the database
        /// </summary>
        /// <param name="name"></param>
        /// <response code="200">Successfully found Character object</response>
        /// <response code="400">Invalid name supplied</response>
        /// <response code="404">Character not found</response>
        [HttpGet]
        [Route("/character/{name}")]
        [ValidateModelState]
        [SwaggerOperation("GetCharacter")]
        [SwaggerResponse(statusCode: 200, type: typeof(Character), description: "Successfully found Character object")]
        public async virtual Task<IActionResult> GetCharacter([FromRoute][Required]string name)
        {
            try {
                using var conn = new MySqlConnection(HelperFunctions.getConnString());
                using var cmd = new MySqlCommand("getCharacter", conn) {
                    CommandType = CommandType.StoredProcedure
                };

                cmd.Parameters.AddWithValue("@c_name", name);

                await conn.OpenAsync();
                MySqlDataReader rdr = await cmd.ExecuteReaderAsync();
                while(await rdr.ReadAsync()) {
                    object[] res = new object[rdr.FieldCount];
                    rdr.GetValues(res);
                    string body =
                        "{name: " + res[1] + ", " +
                        "height: " + res[2] + ", " +
                        "mass: " + res[3] + ", " +
                        "hair_color: " + res[4] + ", " +
                        "skin_color: " + res[5] + ", " +
                        "eye_color: " + res[6] + ", " +
                        "birth_year: " + res[7] + ", " +
                        "gender: " + res[8] + ", " +
                        "homeworld: " + res[9] + ", " +
                        "species: " + res[10] + "}";
                    Console.WriteLine(body);
                    if(rdr.GetValues(res) > 0) {
                        return StatusCode(200, JsonConvert.SerializeObject(body));
                    }
                }
                return StatusCode(404);
            } catch(Exception ex) {
                return HelperFunctions.ErrorStatusCode(ex);
            }
        }

        /// <summary>
        /// Get a list of all charcaters with mass greater than or equal to the specified mass value
        /// </summary>
        /// <param name="mass"></param>
        /// <response code="200">Successfully found character(s) with suitable mass</response>
        /// <response code="400">Invalid mass supplied</response>
        /// <response code="404">Character(s) not found</response>
        [HttpGet]
        [Route("/character/mass/{mass}")]
        [ValidateModelState]
        [SwaggerOperation("GetMass")]
        [SwaggerResponse(statusCode: 200, type: typeof(CharacterList), description: "Successfully found character(s) with suitable mass")]
        public async virtual Task<IActionResult> GetMass([FromRoute][Required]int? mass)
        {
            try {
                using var conn = new MySqlConnection(HelperFunctions.getConnString());
                using var cmd = new MySqlCommand("getMass", conn) {
                    CommandType = CommandType.StoredProcedure
                };

                cmd.Parameters.AddWithValue("@c_mass", mass);

                await conn.OpenAsync();
                MySqlDataReader rdr = await cmd.ExecuteReaderAsync();
                string body = String.Empty;
                while(await rdr.ReadAsync()) {
                    object[] res = new object[rdr.FieldCount];
                    rdr.GetValues(res);
                    string name = "{name: " + res[0] + "},";
                    Console.WriteLine(name);
                    body += " "+name;
                }
                if(body.Length > 0) {
                    return StatusCode(200, JsonConvert.SerializeObject("[" + body.Substring(0, body.Length - 1) + " ]"));
                }
                return StatusCode(404);
            } catch(Exception ex) {
                return HelperFunctions.ErrorStatusCode(ex);
            }
        }

        /// <summary>
        /// Update an existing Character object
        /// </summary>
        /// <param name="body">Character object to be updated</param>
        /// <response code="200">Successfully updated character</response>
        /// <response code="400">Bad Request</response>
        /// <response code="404">Character not found</response>
        /// <response code="409">Conflict with existing data</response>
        [HttpPut]
        [Route("/character")]
        [ValidateModelState]
        [SwaggerOperation("UpdateCharacter")]
        public async virtual Task<IActionResult> UpdateCharacter([FromBody]Character body)
        {
            try {
                using var conn = new MySqlConnection(HelperFunctions.getConnString());
                using var cmd = new MySqlCommand("updateCharacter", conn) {
                    CommandType = CommandType.StoredProcedure
                };

                cmd.Parameters.AddWithValue("@c_name", body.Name);
                cmd.Parameters.AddWithValue("@c_height", body.Height);
                cmd.Parameters.AddWithValue("@c_mass", body.Mass);
                cmd.Parameters.AddWithValue("@c_hair_color", body.HairColor);
                cmd.Parameters.AddWithValue("@c_skin_color", body.SkinColor);
                cmd.Parameters.AddWithValue("@c_eye_color", body.EyeColor);
                cmd.Parameters.AddWithValue("@c_birth_year", body.BirthYear);
                cmd.Parameters.AddWithValue("@c_gender", body.Gender);
                cmd.Parameters.AddWithValue("@c_homeworld", body.Homeworld);
                cmd.Parameters.AddWithValue("@c_species", body.Species);

                await conn.OpenAsync();
                MySqlDataReader rdr = await cmd.ExecuteReaderAsync();
                if(rdr.RecordsAffected >= 1) { 
                    return StatusCode(200, body);
                }
                return StatusCode(404);
            } catch(Exception ex) {
                return HelperFunctions.ErrorStatusCode(ex);
            }
        }
    }
}
