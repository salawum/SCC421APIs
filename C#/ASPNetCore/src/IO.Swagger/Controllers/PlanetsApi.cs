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

namespace IO.Swagger.Controllers
{ 
    /// <summary>
    /// 
    /// </summary>
    [ApiController]
    public class PlanetsApiController : ControllerBase
    { 
        /// <summary>
        /// Add a planet to the database
        /// </summary>
        /// <param name="body">Planet object to be added to the database</param>
        /// <response code="200">Successfully added Planet object to the database</response>
        /// <response code="400">Bad Request</response>
        /// <response code="404">Planet not found</response>
        /// <response code="409">Conflict with existing data</response>
        [HttpPost]
        [Route("/planet")]
        [ValidateModelState]
        [SwaggerOperation("AddPlanet")]
        public virtual IActionResult AddPlanet([FromBody]Planet body)
        { 
            //TODO: Uncomment the next line to return response 200 or use other options such as return this.NotFound(), return this.BadRequest(..), ...
            // return StatusCode(200);

            //TODO: Uncomment the next line to return response 400 or use other options such as return this.NotFound(), return this.BadRequest(..), ...
            // return StatusCode(400);

            //TODO: Uncomment the next line to return response 404 or use other options such as return this.NotFound(), return this.BadRequest(..), ...
            // return StatusCode(404);

            //TODO: Uncomment the next line to return response 409 or use other options such as return this.NotFound(), return this.BadRequest(..), ...
            // return StatusCode(409);

            throw new NotImplementedException();
        }

        /// <summary>
        /// Delete a planet from the database
        /// </summary>
        /// <param name="name"></param>
        /// <response code="200">Successfully deleted Planet object from the database</response>
        /// <response code="400">Invalid name supplied</response>
        /// <response code="404">Planet not found</response>
        [HttpDelete]
        [Route("/planet/{name}")]
        [ValidateModelState]
        [SwaggerOperation("DeletePlanet")]
        public virtual IActionResult DeletePlanet([FromRoute][Required]string name)
        { 
            //TODO: Uncomment the next line to return response 200 or use other options such as return this.NotFound(), return this.BadRequest(..), ...
            // return StatusCode(200);

            //TODO: Uncomment the next line to return response 400 or use other options such as return this.NotFound(), return this.BadRequest(..), ...
            // return StatusCode(400);

            //TODO: Uncomment the next line to return response 404 or use other options such as return this.NotFound(), return this.BadRequest(..), ...
            // return StatusCode(404);

            throw new NotImplementedException();
        }

        /// <summary>
        /// Get a planet from the database
        /// </summary>
        /// <param name="name"></param>
        /// <response code="200">Successfully found Planet object</response>
        /// <response code="400">Invalid name supplied</response>
        /// <response code="404">Planet not found</response>
        [HttpGet]
        [Route("/planet/{name}")]
        [ValidateModelState]
        [SwaggerOperation("GetPlanet")]
        [SwaggerResponse(statusCode: 200, type: typeof(Planet), description: "Successfully found Planet object")]
        public virtual IActionResult GetPlanet([FromRoute][Required]string name)
        { 
            //TODO: Uncomment the next line to return response 200 or use other options such as return this.NotFound(), return this.BadRequest(..), ...
            // return StatusCode(200, default(Planet));

            //TODO: Uncomment the next line to return response 400 or use other options such as return this.NotFound(), return this.BadRequest(..), ...
            // return StatusCode(400);

            //TODO: Uncomment the next line to return response 404 or use other options such as return this.NotFound(), return this.BadRequest(..), ...
            // return StatusCode(404);
            string exampleJson = null;
            exampleJson = "{\n  \"orbital_period\" : 364,\n  \"surface_water\" : 40,\n  \"diameter\" : 12500,\n  \"gravity\" : \"1 standard\",\n  \"name\" : \"Alderaan\",\n  \"climate\" : \"temperate\",\n  \"rotation_period\" : 24,\n  \"terrain\" : \"grasslands, mountains\",\n  \"population\" : 2000000000\n}";
            
                        var example = exampleJson != null
                        ? JsonConvert.DeserializeObject<Planet>(exampleJson)
                        : default(Planet);            //TODO: Change the data returned
            return new ObjectResult(example);
        }

        /// <summary>
        /// Get a list of planets with the specified terrain type
        /// </summary>
        /// <param name="terrain"></param>
        /// <response code="200">Successfully found planet(s)</response>
        /// <response code="400">Invalid terrain supplied</response>
        /// <response code="404">Planet(s) not found</response>
        [HttpGet]
        [Route("/planet/terrain/{terrain}")]
        [ValidateModelState]
        [SwaggerOperation("GetTerrain")]
        [SwaggerResponse(statusCode: 200, type: typeof(PlanetList), description: "Successfully found planet(s)")]
        public virtual IActionResult GetTerrain([FromRoute][Required]string terrain)
        { 
            //TODO: Uncomment the next line to return response 200 or use other options such as return this.NotFound(), return this.BadRequest(..), ...
            // return StatusCode(200, default(PlanetList));

            //TODO: Uncomment the next line to return response 400 or use other options such as return this.NotFound(), return this.BadRequest(..), ...
            // return StatusCode(400);

            //TODO: Uncomment the next line to return response 404 or use other options such as return this.NotFound(), return this.BadRequest(..), ...
            // return StatusCode(404);
            string exampleJson = null;
            exampleJson = "[ {\n  \"orbital_period\" : 364,\n  \"surface_water\" : 40,\n  \"diameter\" : 12500,\n  \"gravity\" : \"1 standard\",\n  \"name\" : \"Alderaan\",\n  \"climate\" : \"temperate\",\n  \"rotation_period\" : 24,\n  \"terrain\" : \"grasslands, mountains\",\n  \"population\" : 2000000000\n}, {\n  \"orbital_period\" : 364,\n  \"surface_water\" : 40,\n  \"diameter\" : 12500,\n  \"gravity\" : \"1 standard\",\n  \"name\" : \"Alderaan\",\n  \"climate\" : \"temperate\",\n  \"rotation_period\" : 24,\n  \"terrain\" : \"grasslands, mountains\",\n  \"population\" : 2000000000\n} ]";
            
                        var example = exampleJson != null
                        ? JsonConvert.DeserializeObject<PlanetList>(exampleJson)
                        : default(PlanetList);            //TODO: Change the data returned
            return new ObjectResult(example);
        }

        /// <summary>
        /// Get a list of planets that are uninhabited
        /// </summary>
        /// <response code="200">Successfully found planet(s)</response>
        /// <response code="404">Planet(s) not found</response>
        [HttpGet]
        [Route("/planet/uninhabited")]
        [ValidateModelState]
        [SwaggerOperation("GetUninhabited")]
        [SwaggerResponse(statusCode: 200, type: typeof(PlanetList), description: "Successfully found planet(s)")]
        public virtual IActionResult GetUninhabited()
        { 
            //TODO: Uncomment the next line to return response 200 or use other options such as return this.NotFound(), return this.BadRequest(..), ...
            // return StatusCode(200, default(PlanetList));

            //TODO: Uncomment the next line to return response 404 or use other options such as return this.NotFound(), return this.BadRequest(..), ...
            // return StatusCode(404);
            string exampleJson = null;
            exampleJson = "[ {\n  \"orbital_period\" : 364,\n  \"surface_water\" : 40,\n  \"diameter\" : 12500,\n  \"gravity\" : \"1 standard\",\n  \"name\" : \"Alderaan\",\n  \"climate\" : \"temperate\",\n  \"rotation_period\" : 24,\n  \"terrain\" : \"grasslands, mountains\",\n  \"population\" : 2000000000\n}, {\n  \"orbital_period\" : 364,\n  \"surface_water\" : 40,\n  \"diameter\" : 12500,\n  \"gravity\" : \"1 standard\",\n  \"name\" : \"Alderaan\",\n  \"climate\" : \"temperate\",\n  \"rotation_period\" : 24,\n  \"terrain\" : \"grasslands, mountains\",\n  \"population\" : 2000000000\n} ]";
            
                        var example = exampleJson != null
                        ? JsonConvert.DeserializeObject<PlanetList>(exampleJson)
                        : default(PlanetList);            //TODO: Change the data returned
            return new ObjectResult(example);
        }

        /// <summary>
        /// Update an existing planet
        /// </summary>
        /// <param name="body">Planet object to be updated</param>
        /// <response code="200">Successfully updated Planet object</response>
        /// <response code="400">Bad Request</response>
        /// <response code="404">Planet not found</response>
        /// <response code="409">Conflict with existing data</response>
        [HttpPut]
        [Route("/planet")]
        [ValidateModelState]
        [SwaggerOperation("UpdatePlanet")]
        public virtual IActionResult UpdatePlanet([FromBody]Planet body)
        { 
            //TODO: Uncomment the next line to return response 200 or use other options such as return this.NotFound(), return this.BadRequest(..), ...
            // return StatusCode(200);

            //TODO: Uncomment the next line to return response 400 or use other options such as return this.NotFound(), return this.BadRequest(..), ...
            // return StatusCode(400);

            //TODO: Uncomment the next line to return response 404 or use other options such as return this.NotFound(), return this.BadRequest(..), ...
            // return StatusCode(404);

            //TODO: Uncomment the next line to return response 409 or use other options such as return this.NotFound(), return this.BadRequest(..), ...
            // return StatusCode(409);

            throw new NotImplementedException();
        }
    }
}