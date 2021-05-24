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
            print("\n"+function+table)
            with open(os.getenv("path_to_results")+language+"/results_"+language+".csv") as csv_file:
                fieldnames = ['Request Number', 'Time Taken']
                csv_reader = csv.DictReader(csv_file)
                line_count = 1
                print("Opening output file...")
                f = open(os.getenv("path_to_results")+language+"/RawValues/"+table+"/"+function+table+"_values_"+language+".csv", "w", newline='')
                csv_writer = csv.DictWriter(f, fieldnames=fieldnames)
                csv_writer.writeheader()
                f.close()

                print("Reading Rows...")
                f = open(os.getenv("path_to_results")+language+"/RawValues/"+table+"/"+function+table+"_values_"+language+".csv", "w", newline='')
                csv_writer = csv.DictWriter(f, fieldnames=fieldnames)
                csv_writer.writeheader()
                for row in csv_reader:
                    if function+table in row["label"]:
                        csv_writer.writerow({'Request Number': line_count, 'Time Taken': row["elapsed"]})
                        line_count += 1
                f.close()
print("Done")