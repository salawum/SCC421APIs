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
	"database/sql"
	"encoding/json"
	"net/http"
	"strconv"
	"strings"

	_ "github.com/go-sql-driver/mysql"
)

func AddCharacter(w http.ResponseWriter, r *http.Request) {
	db, err := sql.Open("mysql", GetDBString())
	db.SetMaxOpenConns(100)
	if err != nil {
		panic(err)
	}
	defer db.Close()

	w.Header().Set("Content-Type", "application/json; charset=UTF-8")
	var c Character
	json.NewDecoder(r.Body).Decode(&c)
	if err != nil {
		http.Error(w, err.Error(), http.StatusBadRequest)
		return
	}

	res, err := db.Query("CALL addCharacter(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
		c.Name, c.Height, c.Mass, c.HairColor, c.SkinColor, c.EyeColor,
		c.BirthYear, c.Gender, c.Homeworld, c.Species)
	if err != nil {
		res_writer, msg, code := HandleError(w, string(err.Error()))
		defer res.Close()
		http.Error(res_writer, msg, code)
		return
	}
	defer res.Close()
	w.WriteHeader(http.StatusOK)
	json.NewEncoder(w).Encode(c)
}

func DeleteCharacter(w http.ResponseWriter, r *http.Request) {
	db, err := sql.Open("mysql", GetDBString())
	db.SetMaxOpenConns(100)
	if err != nil {
		panic(err)
	}
	defer db.Close()

	w.Header().Set("Content-Type", "application/json; charset=UTF-8")
	name := strings.ReplaceAll(r.RequestURI, "/character/", "")

	res, err := db.Exec("CALL deleteCharacter(?)", name)
	if err != nil {
		res_writer, msg, code := HandleError(w, string(err.Error()))
		http.Error(res_writer, msg, code)
		return
	} else {
		if affected, err := res.RowsAffected(); err != nil {
			res_writer, msg, code := HandleError(w, string(err.Error()))
			http.Error(res_writer, msg, code)
			return
		} else if affected == 0 {
			http.Error(w, "Character not found", 404)
			return
		}
	}

	w.WriteHeader(http.StatusOK)
}

func GetCharacter(w http.ResponseWriter, r *http.Request) {
	db, err := sql.Open("mysql", GetDBString())
	db.SetMaxOpenConns(100)
	if err != nil {
		panic(err)
	}
	defer db.Close()

	w.Header().Set("Content-Type", "application/json; charset=UTF-8")
	name := strings.ReplaceAll(r.RequestURI, "/character/", "")

	res, err := db.Query("CALL getCharacter(?)", name)
	if err != nil {
		res_writer, msg, code := HandleError(w, string(err.Error()))
		defer res.Close()
		http.Error(res_writer, msg, code)
		return
	} else {
		if res.Next() {
			var character Character
			var id int
			err = res.Scan(
				&id, &character.Name, &character.Height, &character.Mass, &character.HairColor, &character.SkinColor, &character.EyeColor,
				&character.BirthYear, &character.Gender, &character.Homeworld, &character.Species)
			if err != nil {
				res_writer, msg, code := HandleError(w, string(err.Error()))
				defer res.Close()
				http.Error(res_writer, msg, code)
				return
			}
			w.WriteHeader(http.StatusOK)
			json.NewEncoder(w).Encode(character)
			return
		} else {
			defer res.Close()
			http.Error(w, "Character not found", 404)
			return
		}
	}
}

func GetMass(w http.ResponseWriter, r *http.Request) {
	db, err := sql.Open("mysql", GetDBString())
	db.SetMaxOpenConns(100)
	if err != nil {
		panic(err)
	}
	defer db.Close()

	w.Header().Set("Content-Type", "application/json; charset=UTF-8")
	mass, err := strconv.Atoi(strings.ReplaceAll(r.RequestURI, "/character/mass/", ""))
	if err != nil {
		println(err.Error())
		http.Error(w, "Invalid mass value", 400)
		return
	}

	res, err := db.Query("CALL getMass(?)", mass)
	if err != nil {
		res_writer, msg, code := HandleError(w, string(err.Error()))
		defer res.Close()
		http.Error(res_writer, msg, code)
		return
	} else {
		var c_list []string
		for res.Next() {
			var name string
			err = res.Scan(&name)
			if err != nil {
				defer res.Close()
				println(err.Error())
			} else if name != "" {
				c_list = append(c_list, name)
			}
		}
		if len(c_list) != 0 {
			defer res.Close()
			w.WriteHeader(http.StatusOK)
			json.NewEncoder(w).Encode(c_list)
			return
		}
		defer res.Close()
		http.Error(w, "No characters found with specified mass", 404)
		return
	}
}

func UpdateCharacter(w http.ResponseWriter, r *http.Request) {
	db, err := sql.Open("mysql", GetDBString())
	db.SetMaxOpenConns(100)
	if err != nil {
		panic(err)
	}
	defer db.Close()

	w.Header().Set("Content-Type", "application/json; charset=UTF-8")
	var c Character
	json.NewDecoder(r.Body).Decode(&c)
	if err != nil {
		http.Error(w, err.Error(), http.StatusBadRequest)
		return
	}

	res, err := db.Exec("CALL updateCharacter(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
		c.Name, c.Height, c.Mass, c.HairColor, c.SkinColor, c.EyeColor,
		c.BirthYear, c.Gender, c.Homeworld, c.Species)
	if err != nil {
		res_writer, msg, code := HandleError(w, string(err.Error()))
		http.Error(res_writer, msg, code)
	} else {
		if affected, err := res.RowsAffected(); err != nil {
			res_writer, msg, code := HandleError(w, string(err.Error()))
			http.Error(res_writer, msg, code)
		} else {
			if affected == 0 {
				http.Error(w, "Character not found or has already been updated", 404)
				return
			}
			w.WriteHeader(http.StatusOK)
			json.NewEncoder(w).Encode(c)
			return
		}
	}
}
