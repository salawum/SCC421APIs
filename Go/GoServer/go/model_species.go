/*
 * 4th Year Project
 *
 * (Will come up with a better name later)
 *
 * API version: 1.0.0
 * Generated by: Swagger Codegen (https://github.com/swagger-api/swagger-codegen.git)
 */
package swagger

type Species struct {

	Name string `json:"name"`

	Classification string `json:"classification,omitempty"`

	Designation string `json:"designation,omitempty"`

	AverageHeight int32 `json:"average_height,omitempty"`

	SkinColors string `json:"skin_colors,omitempty"`

	HairColors string `json:"hair_colors,omitempty"`

	EyeColors string `json:"eye_colors,omitempty"`

	AverageLifespan int32 `json:"average_lifespan,omitempty"`

	Language string `json:"language,omitempty"`

	Homeworld string `json:"homeworld,omitempty"`
}