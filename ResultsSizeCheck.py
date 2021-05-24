import csv
import os
from dotenv import load_dotenv
load_dotenv()

languages = ["C#", "Go", "Java", "Javascript", "Python"]
tables = ["Character", "Planet", "Species"]
functions = ["Add", "Put", "Get", "Delete"]

for language in languages:
    print("\n"+language)
    for table in tables:
        print(table)
        for function in functions:
            with open(os.getenv("path_to_results")+language+"/RawValues/"+table+"/"+function+table+"_values_"+language+".csv","r") as f:
                print(language+": "+function+table+" - "+str(len(f.readlines())))