import csv
import os
from dotenv import load_dotenv
load_dotenv()

languages = ["C#", "Go", "Java", "Javascript", "Python"]
number_of_endpoints = 16


def AggregateElapsedTime(cur_val, elapsed):
    elapsed += cur_val
    return elapsed


def GetElapsedTime(row, column_substring, column):
    if column_substring in row[column]:
        return int(row["elapsed"])
    else:
        return 0


def GetMaxValue(cur_val, max_num):
    if cur_val > max_num:
        max_num = cur_val
    return max_num


def WriteAndPrint(content):
    f.write(content+"\n")
    print(content)


def PrintCharacterStats():
    WriteAndPrint("********** Characters **********")
    WriteAndPrint(f'Total number of requests per endpoint: {line_count/number_of_endpoints}')
    WriteAndPrint(f'Total time for addCharacter requests: {add_character_elapsed_total} ms')
    WriteAndPrint(f'Total time for putCharacter requests: {put_character_elapsed_total} ms')
    WriteAndPrint(f'Total time for getCharacter requests: {get_character_elapsed_total} ms')
    WriteAndPrint(f'Total time for deleteCharacter requests: {delete_character_elapsed_total} ms')
    WriteAndPrint(f'Total time for getMass requests: {get_mass_elapsed_total} ms')
    WriteAndPrint("")
    WriteAndPrint(f'Average time per addCharacter request: {add_character_elapsed_total/(line_count/number_of_endpoints)} ms')
    WriteAndPrint(f'Average time per putCharacter request: {put_character_elapsed_total/(line_count/number_of_endpoints)} ms')
    WriteAndPrint(f'Average time per getCharacter request: {get_character_elapsed_total/(line_count/number_of_endpoints)} ms')
    WriteAndPrint(f'Average time per deleteCharacter request: {delete_character_elapsed_total/(line_count/number_of_endpoints)} ms')
    WriteAndPrint(f'Average time per getMass request: {get_mass_elapsed_total/(line_count/number_of_endpoints)} ms')
    WriteAndPrint("")
    WriteAndPrint(f'Max time for addCharacter requests: {max_character_add} ms')
    WriteAndPrint(f'Max time for putCharacter requests: {max_character_put} ms')
    WriteAndPrint(f'Max time for getCharacter requests: {max_character_get} ms')
    WriteAndPrint(f'Max time for deleteCharacter requests: {max_character_delete} ms')
    WriteAndPrint(f'Max time for getMass requests: {max_get_mass} ms')
    WriteAndPrint("\n")


def PrintPlanetStats():
    WriteAndPrint("********** Planets **********")
    WriteAndPrint(f'Total number of requests per endpoint: {line_count/number_of_endpoints}')
    WriteAndPrint(f'Total time for addPlanet requests: {add_planet_elapsed_total} ms')
    WriteAndPrint(f'Total time for putPlanet requests: {put_planet_elapsed_total} ms')
    WriteAndPrint(f'Total time for getPlanet requests: {get_planet_elapsed_total} ms')
    WriteAndPrint(f'Total time for deletePlanet requests: {delete_planet_elapsed_total} ms')
    WriteAndPrint(f'Total time for getTerrain requests: {get_terrain_elapsed_total} ms')
    WriteAndPrint(f'Total time for getUninhabited requests: {get_uninhabited_elapsed_total} ms')
    WriteAndPrint("")
    WriteAndPrint(f'Average time per addPlanet request: {add_planet_elapsed_total/(line_count/number_of_endpoints)} ms')
    WriteAndPrint(f'Average time per putPlanet request: {put_planet_elapsed_total/(line_count/number_of_endpoints)} ms')
    WriteAndPrint(f'Average time per getPlanet request: {get_planet_elapsed_total/(line_count/number_of_endpoints)} ms')
    WriteAndPrint(f'Average time per deletePlanet request: {delete_planet_elapsed_total/(line_count/number_of_endpoints)} ms')
    WriteAndPrint(f'Average time per getTerrain request: {get_terrain_elapsed_total/(line_count/number_of_endpoints)} ms')
    WriteAndPrint(f'Average time per getUninhabited request: {get_uninhabited_elapsed_total/(line_count/number_of_endpoints)} ms')
    WriteAndPrint("")
    WriteAndPrint(f'Max time for addPlanet requests: {max_planet_add} ms')
    WriteAndPrint(f'Max time for putPlanet requests: {max_planet_put} ms')
    WriteAndPrint(f'Max time for getPlanet requests: {max_planet_get} ms')
    WriteAndPrint(f'Max time for deletePlanet requests: {max_planet_delete} ms')
    WriteAndPrint(f'Max time for getTerrain requests: {max_get_terrain} ms')
    WriteAndPrint(f'Max time for getUninhabited requests: {max_get_uninhabited} ms')
    WriteAndPrint("\n")


def PrintSpeciesStats():
    WriteAndPrint("********** Species **********")
    WriteAndPrint(f'Total number of requests per endpoint: {line_count/number_of_endpoints}')
    WriteAndPrint(f'Total time for addSpecies requests: {add_species_elapsed_total} ms')
    WriteAndPrint(f'Total time for putSpecies requests: {put_species_elapsed_total} ms')
    WriteAndPrint(f'Total time for getSpecies requests: {get_species_elapsed_total} ms')
    WriteAndPrint(f'Total time for deleteSpecies requests: {delete_species_elapsed_total} ms')
    WriteAndPrint(f'Total time for getEyeColor requests: {get_eye_color__elapsed_total} ms')
    WriteAndPrint("")
    WriteAndPrint(f'Average time per addSpecies request: {add_species_elapsed_total/(line_count/number_of_endpoints)} ms')
    WriteAndPrint(f'Average time per putSpecies request: {put_species_elapsed_total/(line_count/number_of_endpoints)} ms')
    WriteAndPrint(f'Average time per getSpecies request: {get_species_elapsed_total/(line_count/number_of_endpoints)} ms')
    WriteAndPrint(f'Average time per deleteSpecies request: {delete_species_elapsed_total/(line_count/number_of_endpoints)} ms')
    WriteAndPrint(f'Average time per getEyeColor request: {get_eye_color__elapsed_total/(line_count/number_of_endpoints)} ms')
    WriteAndPrint("")
    WriteAndPrint(f'Max time for addSpecies requests: {max_species_add} ms')
    WriteAndPrint(f'Max time for putSpecies requests: {max_species_put} ms')
    WriteAndPrint(f'Max time for getSpecies requests: {max_species_get} ms')
    WriteAndPrint(f'Max time for deleteSpecies requests: {max_species_delete} ms')
    WriteAndPrint(f'Max time for getEyeColor requests: {max_get_eye_color} ms')
    WriteAndPrint("\n")


def MiscStats():
    WriteAndPrint("********** Misc **********")
    total_time = character_elapsed + planet_elapsed + species_elapsed
    WriteAndPrint(f'Total time taken: {total_time} ms')
    WriteAndPrint(f'Average total completion time: {total_time/3} ms')


for language in languages:
    print("\n"+language)
    with open(os.getenv("path_to_results")+language+"/results_"+language+".csv") as csv_file:
        csv_reader = csv.DictReader(csv_file)
        line_count = 0

        add_character_elapsed_total = put_character_elapsed_total = get_character_elapsed_total = delete_character_elapsed_total = get_mass_elapsed_total = 0
        add_planet_elapsed_total = put_planet_elapsed_total = get_planet_elapsed_total = delete_planet_elapsed_total = get_terrain_elapsed_total = get_uninhabited_elapsed_total = 0
        add_species_elapsed_total = put_species_elapsed_total = get_species_elapsed_total = delete_species_elapsed_total = get_eye_color__elapsed_total = 0
        character_elapsed = planet_elapsed = species_elapsed = 0
        
        max_character_add = max_character_put = max_character_get = max_character_delete = max_get_mass = 0
        max_planet_add = max_planet_put = max_planet_get = max_planet_delete = max_get_terrain = max_get_uninhabited = 0
        max_species_add = max_species_put = max_species_get = max_species_delete = max_get_eye_color = 0

        print("Reading Rows...")
        for row in csv_reader:
            if line_count == 0:
                line_count += 1
                continue
            # Characters
            # Total Elapsed Time
            add_character_elapsed_total = AggregateElapsedTime(GetElapsedTime(row, "AddCharacter", "label"), add_character_elapsed_total)
            put_character_elapsed_total = AggregateElapsedTime(GetElapsedTime(row, "PutCharacter", "label"), put_character_elapsed_total)
            get_character_elapsed_total = AggregateElapsedTime(GetElapsedTime(row, "GetCharacter", "label"), get_character_elapsed_total)
            delete_character_elapsed_total = AggregateElapsedTime(GetElapsedTime(row, "DeleteCharacter", "label"), delete_character_elapsed_total)
            get_mass_elapsed_total = AggregateElapsedTime(GetElapsedTime(row, "GetMass", "label"), get_mass_elapsed_total)

            # Max Elapsed Time
            max_character_add = GetMaxValue(GetElapsedTime(row, "AddCharacter", "label"), max_character_add)
            max_character_put = GetMaxValue(GetElapsedTime(row, "PutCharacter", "label"), max_character_put)
            max_character_get = GetMaxValue(GetElapsedTime(row, "GetCharacter", "label"), max_character_get)
            max_character_delete = GetMaxValue(GetElapsedTime(row, "DeleteCharacter", "label"), max_character_delete)
            max_get_mass = GetMaxValue(GetElapsedTime(row, "GetMass", "label"), max_get_mass)

            # Planets
            # Total Elapsed Time
            add_planet_elapsed_total = AggregateElapsedTime(GetElapsedTime(row, "AddPlanet", "label"), add_planet_elapsed_total)
            put_planet_elapsed_total = AggregateElapsedTime(GetElapsedTime(row, "PutPlanet", "label"), put_planet_elapsed_total)
            get_planet_elapsed_total = AggregateElapsedTime(GetElapsedTime(row, "GetPlanet", "label"), get_planet_elapsed_total)
            delete_planet_elapsed_total = AggregateElapsedTime(GetElapsedTime(row, "DeletePlanet", "label"), delete_planet_elapsed_total)
            get_terrain_elapsed_total = AggregateElapsedTime(GetElapsedTime(row, "GetTerrain", "label"), get_terrain_elapsed_total)
            get_uninhabited_elapsed_total = AggregateElapsedTime(GetElapsedTime(row, "GetUninhabited", "label"), get_uninhabited_elapsed_total)

            # Max Elapsed Time
            max_planet_add = GetMaxValue(GetElapsedTime(row, "AddPlanet", "label"), max_planet_add)
            max_planet_put = GetMaxValue(GetElapsedTime(row, "PutPlanet", "label"), max_planet_put)
            max_planet_get = GetMaxValue(GetElapsedTime(row, "GetPlanet", "label"), max_planet_get)
            max_planet_delete = GetMaxValue(GetElapsedTime(row, "DeletePlanet", "label"), max_planet_delete)
            max_get_terrain = GetMaxValue(GetElapsedTime(row, "GetTerrain", "label"), max_get_terrain)
            max_get_uninhabited = GetMaxValue(GetElapsedTime(row, "GetUninhabited", "label"), max_get_uninhabited)

            # Species
            # Total Elapsed Time
            add_species_elapsed_total = AggregateElapsedTime(GetElapsedTime(row, "AddSpecies", "label"), add_species_elapsed_total)
            put_species_elapsed_total = AggregateElapsedTime(GetElapsedTime(row, "PutSpecies", "label"), put_species_elapsed_total)
            get_species_elapsed_total = AggregateElapsedTime(GetElapsedTime(row, "GetSpecies", "label"), get_species_elapsed_total)
            delete_species_elapsed_total = AggregateElapsedTime(GetElapsedTime(row, "DeleteSpecies", "label"), delete_species_elapsed_total)
            get_eye_color__elapsed_total = AggregateElapsedTime(GetElapsedTime(row, "GetEyeColor", "label"), get_eye_color__elapsed_total)

            # Max Elapsed Time
            max_species_add = GetMaxValue(GetElapsedTime(row, "AddSpecies", "label"), max_species_add)
            max_species_put = GetMaxValue(GetElapsedTime(row, "PutSpecies", "label"), max_species_put)
            max_species_get = GetMaxValue(GetElapsedTime(row, "GetSpecies", "label"), max_species_get)
            max_species_delete = GetMaxValue(GetElapsedTime(row, "DeleteSpecies", "label"), max_species_delete)
            max_get_eye_color = GetMaxValue(GetElapsedTime(row, "GetEyeColor", "label"), max_get_eye_color)
            
            line_count += 1

    character_elapsed = add_character_elapsed_total + put_character_elapsed_total + get_character_elapsed_total + delete_character_elapsed_total + get_mass_elapsed_total
    planet_elapsed = add_planet_elapsed_total + put_planet_elapsed_total + get_planet_elapsed_total + delete_planet_elapsed_total + get_terrain_elapsed_total + get_uninhabited_elapsed_total
    species_elapsed = add_species_elapsed_total + put_species_elapsed_total + get_species_elapsed_total + delete_species_elapsed_total + get_eye_color__elapsed_total

    f = open(os.getenv("path_to_results")+language+"/output_"+language+".txt", "w")
    WriteAndPrint(language)  
    PrintCharacterStats()
    PrintPlanetStats()
    PrintSpeciesStats()
    MiscStats()
    f.close()