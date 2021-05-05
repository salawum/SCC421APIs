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
 * Character
 */
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2021-05-04T14:46:54.785Z[GMT]")public class Character   {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("height")
  private Integer height = null;

  @JsonProperty("mass")
  private BigDecimal mass = null;

  @JsonProperty("hair_color")
  private String hairColor = null;

  @JsonProperty("skin_color")
  private String skinColor = null;

  @JsonProperty("eye_color")
  private String eyeColor = null;

  @JsonProperty("birth_year")
  private String birthYear = null;

  @JsonProperty("gender")
  private String gender = null;

  @JsonProperty("homeworld")
  private String homeworld = null;

  @JsonProperty("species")
  private String species = null;

  public Character name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
   **/
  @JsonProperty("name")
  @Schema(example = "Luke Skywalker", required = true, description = "")
  @NotNull
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Character height(Integer height) {
    this.height = height;
    return this;
  }

  /**
   * Get height
   * @return height
   **/
  @JsonProperty("height")
  @Schema(example = "172", description = "")
  public Integer getHeight() {
    return height;
  }

  public void setHeight(Integer height) {
    this.height = height;
  }

  public Character mass(BigDecimal mass) {
    this.mass = mass;
    return this;
  }

  /**
   * Get mass
   * @return mass
   **/
  @JsonProperty("mass")
  @Schema(example = "77", description = "")
  @Valid
  public BigDecimal getMass() {
    return mass;
  }

  public void setMass(BigDecimal mass) {
    this.mass = mass;
  }

  public Character hairColor(String hairColor) {
    this.hairColor = hairColor;
    return this;
  }

  /**
   * Get hairColor
   * @return hairColor
   **/
  @JsonProperty("hair_color")
  @Schema(example = "blonde", description = "")
  public String getHairColor() {
    return hairColor;
  }

  public void setHairColor(String hairColor) {
    this.hairColor = hairColor;
  }

  public Character skinColor(String skinColor) {
    this.skinColor = skinColor;
    return this;
  }

  /**
   * Get skinColor
   * @return skinColor
   **/
  @JsonProperty("skin_color")
  @Schema(example = "fair", description = "")
  public String getSkinColor() {
    return skinColor;
  }

  public void setSkinColor(String skinColor) {
    this.skinColor = skinColor;
  }

  public Character eyeColor(String eyeColor) {
    this.eyeColor = eyeColor;
    return this;
  }

  /**
   * Get eyeColor
   * @return eyeColor
   **/
  @JsonProperty("eye_color")
  @Schema(example = "blue", description = "")
  public String getEyeColor() {
    return eyeColor;
  }

  public void setEyeColor(String eyeColor) {
    this.eyeColor = eyeColor;
  }

  public Character birthYear(String birthYear) {
    this.birthYear = birthYear;
    return this;
  }

  /**
   * Get birthYear
   * @return birthYear
   **/
  @JsonProperty("birth_year")
  @Schema(example = "19BBY", description = "")
  public String getBirthYear() {
    return birthYear;
  }

  public void setBirthYear(String birthYear) {
    this.birthYear = birthYear;
  }

  public Character gender(String gender) {
    this.gender = gender;
    return this;
  }

  /**
   * Get gender
   * @return gender
   **/
  @JsonProperty("gender")
  @Schema(example = "male", description = "")
  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public Character homeworld(String homeworld) {
    this.homeworld = homeworld;
    return this;
  }

  /**
   * Get homeworld
   * @return homeworld
   **/
  @JsonProperty("homeworld")
  @Schema(example = "Tatooine", description = "")
  public String getHomeworld() {
    return homeworld;
  }

  public void setHomeworld(String homeworld) {
    this.homeworld = homeworld;
  }

  public Character species(String species) {
    this.species = species;
    return this;
  }

  /**
   * Get species
   * @return species
   **/
  @JsonProperty("species")
  @Schema(example = "Human", description = "")
  public String getSpecies() {
    return species;
  }

  public void setSpecies(String species) {
    this.species = species;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Character character = (Character) o;
    return Objects.equals(this.name, character.name) &&
        Objects.equals(this.height, character.height) &&
        Objects.equals(this.mass, character.mass) &&
        Objects.equals(this.hairColor, character.hairColor) &&
        Objects.equals(this.skinColor, character.skinColor) &&
        Objects.equals(this.eyeColor, character.eyeColor) &&
        Objects.equals(this.birthYear, character.birthYear) &&
        Objects.equals(this.gender, character.gender) &&
        Objects.equals(this.homeworld, character.homeworld) &&
        Objects.equals(this.species, character.species);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, height, mass, hairColor, skinColor, eyeColor, birthYear, gender, homeworld, species);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Character {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    height: ").append(toIndentedString(height)).append("\n");
    sb.append("    mass: ").append(toIndentedString(mass)).append("\n");
    sb.append("    hairColor: ").append(toIndentedString(hairColor)).append("\n");
    sb.append("    skinColor: ").append(toIndentedString(skinColor)).append("\n");
    sb.append("    eyeColor: ").append(toIndentedString(eyeColor)).append("\n");
    sb.append("    birthYear: ").append(toIndentedString(birthYear)).append("\n");
    sb.append("    gender: ").append(toIndentedString(gender)).append("\n");
    sb.append("    homeworld: ").append(toIndentedString(homeworld)).append("\n");
    sb.append("    species: ").append(toIndentedString(species)).append("\n");
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
