/*
 * 4th Year Project
 * (Will come up with a better name later)
 *
 * OpenAPI spec version: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * Planet
 */
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2021-05-04T14:46:54.785Z[GMT]")public class Planet   {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("rotation_period")
  private BigDecimal rotationPeriod = null;

  @JsonProperty("orbital_period")
  private BigDecimal orbitalPeriod = null;

  @JsonProperty("diameter")
  private Integer diameter = null;

  @JsonProperty("climate")
  private String climate = null;

  @JsonProperty("gravity")
  private String gravity = null;

  @JsonProperty("terrain")
  private String terrain = null;

  @JsonProperty("surface_water")
  private BigDecimal surfaceWater = null;

  @JsonProperty("population")
  private Integer population = null;

  public Planet name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
   **/
  @JsonProperty("name")
  @Schema(example = "Alderaan", required = true, description = "")
  @NotNull
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Planet rotationPeriod(BigDecimal rotationPeriod) {
    this.rotationPeriod = rotationPeriod;
    return this;
  }

  /**
   * Get rotationPeriod
   * @return rotationPeriod
   **/
  @JsonProperty("rotation_period")
  @Schema(example = "24", description = "")
  @Valid
  public BigDecimal getRotationPeriod() {
    return rotationPeriod;
  }

  public void setRotationPeriod(BigDecimal rotationPeriod) {
    this.rotationPeriod = rotationPeriod;
  }

  public Planet orbitalPeriod(BigDecimal orbitalPeriod) {
    this.orbitalPeriod = orbitalPeriod;
    return this;
  }

  /**
   * Get orbitalPeriod
   * @return orbitalPeriod
   **/
  @JsonProperty("orbital_period")
  @Schema(example = "364", description = "")
  @Valid
  public BigDecimal getOrbitalPeriod() {
    return orbitalPeriod;
  }

  public void setOrbitalPeriod(BigDecimal orbitalPeriod) {
    this.orbitalPeriod = orbitalPeriod;
  }

  public Planet diameter(Integer diameter) {
    this.diameter = diameter;
    return this;
  }

  /**
   * Get diameter
   * @return diameter
   **/
  @JsonProperty("diameter")
  @Schema(example = "12500", description = "")
  public Integer getDiameter() {
    return diameter;
  }

  public void setDiameter(Integer diameter) {
    this.diameter = diameter;
  }

  public Planet climate(String climate) {
    this.climate = climate;
    return this;
  }

  /**
   * Get climate
   * @return climate
   **/
  @JsonProperty("climate")
  @Schema(example = "temperate", description = "")
  public String getClimate() {
    return climate;
  }

  public void setClimate(String climate) {
    this.climate = climate;
  }

  public Planet gravity(String gravity) {
    this.gravity = gravity;
    return this;
  }

  /**
   * Get gravity
   * @return gravity
   **/
  @JsonProperty("gravity")
  @Schema(example = "1 standard", description = "")
  public String getGravity() {
    return gravity;
  }

  public void setGravity(String gravity) {
    this.gravity = gravity;
  }

  public Planet terrain(String terrain) {
    this.terrain = terrain;
    return this;
  }

  /**
   * Get terrain
   * @return terrain
   **/
  @JsonProperty("terrain")
  @Schema(example = "grasslands, mountains", description = "")
  public String getTerrain() {
    return terrain;
  }

  public void setTerrain(String terrain) {
    this.terrain = terrain;
  }

  public Planet surfaceWater(BigDecimal surfaceWater) {
    this.surfaceWater = surfaceWater;
    return this;
  }

  /**
   * Get surfaceWater
   * @return surfaceWater
   **/
  @JsonProperty("surface_water")
  @Schema(example = "40", description = "")
  @Valid
  public BigDecimal getSurfaceWater() {
    return surfaceWater;
  }

  public void setSurfaceWater(BigDecimal surfaceWater) {
    this.surfaceWater = surfaceWater;
  }

  public Planet population(Integer population) {
    this.population = population;
    return this;
  }

  /**
   * Get population
   * @return population
   **/
  @JsonProperty("population")
  @Schema(example = "2000000000", description = "")
  public Integer getPopulation() {
    return population;
  }

  public void setPopulation(Integer population) {
    this.population = population;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Planet planet = (Planet) o;
    return Objects.equals(this.name, planet.name) &&
        Objects.equals(this.rotationPeriod, planet.rotationPeriod) &&
        Objects.equals(this.orbitalPeriod, planet.orbitalPeriod) &&
        Objects.equals(this.diameter, planet.diameter) &&
        Objects.equals(this.climate, planet.climate) &&
        Objects.equals(this.gravity, planet.gravity) &&
        Objects.equals(this.terrain, planet.terrain) &&
        Objects.equals(this.surfaceWater, planet.surfaceWater) &&
        Objects.equals(this.population, planet.population);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, rotationPeriod, orbitalPeriod, diameter, climate, gravity, terrain, surfaceWater, population);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Planet {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    rotationPeriod: ").append(toIndentedString(rotationPeriod)).append("\n");
    sb.append("    orbitalPeriod: ").append(toIndentedString(orbitalPeriod)).append("\n");
    sb.append("    diameter: ").append(toIndentedString(diameter)).append("\n");
    sb.append("    climate: ").append(toIndentedString(climate)).append("\n");
    sb.append("    gravity: ").append(toIndentedString(gravity)).append("\n");
    sb.append("    terrain: ").append(toIndentedString(terrain)).append("\n");
    sb.append("    surfaceWater: ").append(toIndentedString(surfaceWater)).append("\n");
    sb.append("    population: ").append(toIndentedString(population)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}