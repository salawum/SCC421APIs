import csv


path_to_results = "C:/apache-jmeter-5.4.1/results/SCC421/resultsProcesses.csv"
path_to_output_file = "C:/apache-jmeter-5.4.1/results/SCC421/outputProcesses.txt"


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


def PrintMemoryStats():
    WriteAndPrint("********** Memory (%) **********")
    WriteAndPrint(f'Average memory used percentage: {(memory_elapsed_total/1000)/mem_lines}%')
    WriteAndPrint(f'Max memory usage percentage: {max_memory/1000}%')


def PrintCPUStats():
    WriteAndPrint("\n********** CPU (%) **********")
    WriteAndPrint(f'Average CPU usage percentage: {(cpu_elapsed_total/1000)/cpu_lines}%')
    WriteAndPrint(f'Max CPU usage percentage: {max_cpu/1000}%')


def PrintNetworkStats():
    WriteAndPrint("\n********** Network (bytes) **********")
    WriteAndPrint(f'Total network bytes received: {network_elapsed_total} bytes')
    WriteAndPrint(f'Max network bytes received: {max_network} bytes')

with open(path_to_results) as csv_file:
    csv_reader = csv.DictReader(csv_file)
    line_count = 0

    memory_elapsed_total = cpu_elapsed_total = network_elapsed_total = 0   
    max_memory = max_cpu = max_network = 0
    mem_lines = cpu_lines = net_lines = 0

    for row in csv_reader:
        if line_count == 0:
            line_count += 1
            continue
        if "Memory" in row["label"]:
            mem_lines += 1
        elif "CPU" in row["label"]:
            cpu_lines += 1
        elif "Network" in row["label"]:
            net_lines += 1

        # Total Elapsed Time
        memory_elapsed_total = AggregateElapsedTime(GetElapsedTime(row, "Memory", "label"), memory_elapsed_total)
        cpu_elapsed_total = AggregateElapsedTime(GetElapsedTime(row, "CPU", "label"), cpu_elapsed_total)
        network_elapsed_total = AggregateElapsedTime(GetElapsedTime(row, "Network", "label"), network_elapsed_total)

        # Max Elapsed Time
        max_memory = GetMaxValue(GetElapsedTime(row, "Memory", "label"), max_memory)
        max_cpu = GetMaxValue(GetElapsedTime(row, "CPU", "label"), max_cpu)
        max_network = GetMaxValue(GetElapsedTime(row, "Network", "label"), max_network)
        
        line_count += 1

f = open(path_to_output_file, "w")   
PrintMemoryStats()
PrintCPUStats()
PrintNetworkStats()
f.close()