import csv
import os
from dotenv import load_dotenv
load_dotenv()

language = "Python"
metric = "Memory"


def GetMaxValue(cur_val, max_num):
    if cur_val > max_num:
        max_num = cur_val
    return max_num


print("\n"+language)
print(metric)
print("\nMaximum Value")
for i in range(101):
    with open(os.getenv("path_to_results")+language+"/RawProcessValues/"+metric+"_values_"+language+".csv") as csv_file:
        csv_reader = csv.DictReader(csv_file)
        total = 0
        maxVal = 0
        for row in csv_reader:
            if int(row["Completetion Percentage"]) == i:
                maxVal = GetMaxValue(maxVal, float(row["Value"]))
                total += float(row["Value"])
        print(f'{maxVal}')