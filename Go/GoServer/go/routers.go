/*
 * 4th Year Project
 *
 * (Will come up with a better name later)
 *
 * API version: 1.0.0
 * Generated by: Swagger Codegen (https://github.com/swagger-api/swagger-codegen.git)
 */
package swagger

import (
	"fmt"
	"net/http"
	"os"
	"strings"

	"github.com/gorilla/mux"
	"github.com/joho/godotenv"
)

type Route struct {
	Name        string
	Method      string
	Pattern     string
	HandlerFunc http.HandlerFunc
}

type Routes []Route

func GetDBString() string {
	godotenv.Load()
	return os.Getenv("DB_USER") + ":" + os.Getenv("DB_PWD") + "@tcp(" + os.Getenv("DB_HOST") + ":" + os.Getenv("DB_PORT") + ")/" + os.Getenv("DB_DATABASE")
}

func HandleError(w http.ResponseWriter, err string) (http.ResponseWriter, string, int) {
	println(err)
	var errorCode []string = strings.Split(err, ": ")
	switch errorCode[0] {
	case "Error 1062":
		return w, "\"" + errorCode[0] + "\": \"" + errorCode[1] + "\"", http.StatusConflict
	case "Error 1452":
		return w, "\"" + errorCode[0] + "\": \"" + errorCode[1] + "\"", http.StatusConflict
	case "Error 1046":
		return w, "\"" + errorCode[0] + "\": \"" + errorCode[1] + "\"", http.StatusNotFound
	default:
		return w, "\"" + errorCode[0] + "\": \"" + errorCode[1] + "\"", http.StatusBadRequest
	}
}

func NewRouter() *mux.Router {
	router := mux.NewRouter().StrictSlash(true)
	for _, route := range routes {
		var handler http.Handler
		handler = route.HandlerFunc
		handler = Logger(handler, route.Name)

		router.
			Methods(route.Method).
			Path(route.Pattern).
			Name(route.Name).
			Handler(handler)
	}

	return router
}

func Index(w http.ResponseWriter, r *http.Request) {
	fmt.Fprintf(w, "Hello World!")
}

var routes = Routes{
	Route{
		"Index",
		"GET",
		"/",
		Index,
	},

	Route{
		"AddCharacter",
		strings.ToUpper("Post"),
		"/character",
		AddCharacter,
	},

	Route{
		"DeleteCharacter",
		strings.ToUpper("Delete"),
		"/character/{name}",
		DeleteCharacter,
	},

	Route{
		"GetCharacter",
		strings.ToUpper("Get"),
		"/character/{name}",
		GetCharacter,
	},

	Route{
		"GetMass",
		strings.ToUpper("Get"),
		"/character/mass/{mass}",
		GetMass,
	},

	Route{
		"UpdateCharacter",
		strings.ToUpper("Put"),
		"/character",
		UpdateCharacter,
	},

	Route{
		"AddPlanet",
		strings.ToUpper("Post"),
		"/planet",
		AddPlanet,
	},

	Route{
		"DeletePlanet",
		strings.ToUpper("Delete"),
		"/planet/{name}",
		DeletePlanet,
	},

	Route{
		"GetPlanet",
		strings.ToUpper("Get"),
		"/planet/{name}",
		GetPlanet,
	},

	Route{
		"GetTerrain",
		strings.ToUpper("Get"),
		"/planet/terrain/{terrain}",
		GetTerrain,
	},

	Route{
		"GetUninhabited",
		strings.ToUpper("Get"),
		"/planet/uninhabited",
		GetUninhabited,
	},

	Route{
		"UpdatePlanet",
		strings.ToUpper("Put"),
		"/planet",
		UpdatePlanet,
	},

	Route{
		"AddSpecies",
		strings.ToUpper("Post"),
		"/species",
		AddSpecies,
	},

	Route{
		"DeleteSpecies",
		strings.ToUpper("Delete"),
		"/species/{name}",
		DeleteSpecies,
	},

	Route{
		"GetEyeColor",
		strings.ToUpper("Get"),
		"/species/eye/{eye_color}",
		GetEyeColor,
	},

	Route{
		"GetSpecies",
		strings.ToUpper("Get"),
		"/species/{name}",
		GetSpecies,
	},

	Route{
		"UpdateSpecies",
		strings.ToUpper("Put"),
		"/species",
		UpdateSpecies,
	},
}
