import csv
import os
from dotenv import load_dotenv
load_dotenv()

languages = ["C#", "Go", "Java", "Javascript", "Python"]
process_metric = ["CPU", "Memory"]

for language in languages:
    print("\n"+language)
    for metric in process_metric:
        print("\n"+metric)
        with open(os.getenv("path_to_results")+language+"/resultsProcesses_"+language+".csv") as csv_file:
            fieldnames = ['Completetion Percentage', 'Value']
            csv_reader = csv.DictReader(csv_file)
            line_count = 1
            print("Opening output file...")
            f = open(os.getenv("path_to_results")+language+"/RawProcessValues/"+metric+"_values_"+language+".csv", "w", newline='')
            csv_writer = csv.DictWriter(f, fieldnames=fieldnames)
            csv_writer.writeheader()
            f.close()

            print("Reading Rows...")
            f = open(os.getenv("path_to_results")+language+"/RawProcessValues/"+metric+"_values_"+language+".csv", "w", newline='')
            csv_writer = csv.DictWriter(f, fieldnames=fieldnames)
            csv_writer.writeheader()
            for row in csv_reader:
                if metric in row["label"]:
                    csv_writer.writerow({'Completetion Percentage': line_count, 'Value': int(row["elapsed"])/1000})
                    line_count += 1
            f.close()
print("Done")