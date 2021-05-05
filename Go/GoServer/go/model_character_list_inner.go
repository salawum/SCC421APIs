/*
 * 4th Year Project
 *
 * (Will come up with a better name later)
 *
 * API version: 1.0.0
 * Generated by: Swagger Codegen (https://github.com/swagger-api/swagger-codegen.git)
 */
package swagger

type CharacterListInner struct {

	Name string `json:"name"`

	Height int32 `json:"height,omitempty"`

	Mass float64 `json:"mass,omitempty"`

	HairColor string `json:"hair_color,omitempty"`

	SkinColor string `json:"skin_color,omitempty"`

	EyeColor string `json:"eye_color,omitempty"`

	BirthYear string `json:"birth_year,omitempty"`

	Gender string `json:"gender,omitempty"`

	Homeworld string `json:"homeworld,omitempty"`

	Species string `json:"species,omitempty"`
}
