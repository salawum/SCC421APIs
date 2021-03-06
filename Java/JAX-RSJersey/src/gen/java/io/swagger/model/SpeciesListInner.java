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
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * SpeciesListInner
 */
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2021-05-04T14:46:54.785Z[GMT]")public class SpeciesListInner   {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("classification")
  private String classification = null;

  @JsonProperty("designation")
  private String designation = null;

  @JsonProperty("average_height")
  private Integer averageHeight = null;

  @JsonProperty("skin_colors")
  private String skinColors = null;

  @JsonProperty("hair_colors")
  private String hairColors = null;

  @JsonProperty("eye_colors")
  private String eyeColors = null;

  @JsonProperty("average_lifespan")
  private Integer averageLifespan = null;

  @JsonProperty("language")
  private String language = null;

  @JsonProperty("homeworld")
  private String homeworld = null;

  public SpeciesListInner name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
   **/
  @JsonProperty("name")
  @Schema(example = "Human", required = true, description = "")
  @NotNull
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public SpeciesListInner classification(String classification) {
    this.classification = classification;
    return this;
  }

  /**
   * Get classification
   * @return classification
   **/
  @JsonProperty("classification")
  @Schema(example = "mammal", description = "")
  public String getClassification() {
    return classification;
  }

  public void setClassification(String classification) {
    this.classification = classification;
  }

  public SpeciesListInner designation(String designation) {
    this.designation = designation;
    return this;
  }

  /**
   * Get designation
   * @return designation
   **/
  @JsonProperty("designation")
  @Schema(example = "sentient", description = "")
  public String getDesignation() {
    return designation;
  }

  public void setDesignation(String designation) {
    this.designation = designation;
  }

  public SpeciesListInner averageHeight(Integer averageHeight) {
    this.averageHeight = averageHeight;
    return this;
  }

  /**
   * Get averageHeight
   * @return averageHeight
   **/
  @JsonProperty("average_height")
  @Schema(example = "180", description = "")
  public Integer getAverageHeight() {
    return averageHeight;
  }

  public void setAverageHeight(Integer averageHeight) {
    this.averageHeight = averageHeight;
  }

  public SpeciesListInner skinColors(String skinColors) {
    this.skinColors = skinColors;
    return this;
  }

  /**
   * Get skinColors
   * @return skinColors
   **/
  @JsonProperty("skin_colors")
  @Schema(example = "caucasian, black, asian, hispanic", description = "")
  public String getSkinColors() {
    return skinColors;
  }

  public void setSkinColors(String skinColors) {
    this.skinColors = skinColors;
  }

  public SpeciesListInner hairColors(String hairColors) {
    this.hairColors = hairColors;
    return this;
  }

  /**
   * Get hairColors
   * @return hairColors
   **/
  @JsonProperty("hair_colors")
  @Schema(example = "blonde, brown, black, red", description = "")
  public String getHairColors() {
    return hairColors;
  }

  public void setHairColors(String hairColors) {
    this.hairColors = hairColors;
  }

  public SpeciesListInner eyeColors(String eyeColors) {
    this.eyeColors = eyeColors;
    return this;
  }

  /**
   * Get eyeColors
   * @return eyeColors
   **/
  @JsonProperty("eye_colors")
  @Schema(example = "brown, blue, green, hazel, grey, amber", description = "")
  public String getEyeColors() {
    return eyeColors;
  }

  public void setEyeColors(String eyeColors) {
    this.eyeColors = eyeColors;
  }

  public SpeciesListInner averageLifespan(Integer averageLifespan) {
    this.averageLifespan = averageLifespan;
    return this;
  }

  /**
   * Get averageLifespan
   * @return averageLifespan
   **/
  @JsonProperty("average_lifespan")
  @Schema(example = "120", description = "")
  public Integer getAverageLifespan() {
    return averageLifespan;
  }

  public void setAverageLifespan(Integer averageLifespan) {
    this.averageLifespan = averageLifespan;
  }

  public SpeciesListInner language(String language) {
    this.language = language;
    return this;
  }

  /**
   * Get language
   * @return language
   **/
  @JsonProperty("language")
  @Schema(example = "Galactic Basic", description = "")
  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public SpeciesListInner homeworld(String homeworld) {
    this.homeworld = homeworld;
    return this;
  }

  /**
   * Get homeworld
   * @return homeworld
   **/
  @JsonProperty("homeworld")
  @Schema(example = "Coruscant", description = "")
  public String getHomeworld() {
    return homeworld;
  }

  public void setHomeworld(String homeworld) {
    this.homeworld = homeworld;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SpeciesListInner speciesListInner = (SpeciesListInner) o;
    return Objects.equals(this.name, speciesListInner.name) &&
        Objects.equals(this.classification, speciesListInner.classification) &&
        Objects.equals(this.designation, speciesListInner.designation) &&
        Objects.equals(this.averageHeight, speciesListInner.averageHeight) &&
        Objects.equals(this.skinColors, speciesListInner.skinColors) &&
        Objects.equals(this.hairColors, speciesListInner.hairColors) &&
        Objects.equals(this.eyeColors, speciesListInner.eyeColors) &&
        Objects.equals(this.averageLifespan, speciesListInner.averageLifespan) &&
        Objects.equals(this.language, speciesListInner.language) &&
        Objects.equals(this.homeworld, speciesListInner.homeworld);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, classification, designation, averageHeight, skinColors, hairColors, eyeColors, averageLifespan, language, homeworld);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SpeciesListInner {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    classification: ").append(toIndentedString(classification)).append("\n");
    sb.append("    designation: ").append(toIndentedString(designation)).append("\n");
    sb.append("    averageHeight: ").append(toIndentedString(averageHeight)).append("\n");
    sb.append("    skinColors: ").append(toIndentedString(skinColors)).append("\n");
    sb.append("    hairColors: ").append(toIndentedString(hairColors)).append("\n");
    sb.append("    eyeColors: ").append(toIndentedString(eyeColors)).append("\n");
    sb.append("    averageLifespan: ").append(toIndentedString(averageLifespan)).append("\n");
    sb.append("    language: ").append(toIndentedString(language)).append("\n");
    sb.append("    homeworld: ").append(toIndentedString(homeworld)).append("\n");
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
