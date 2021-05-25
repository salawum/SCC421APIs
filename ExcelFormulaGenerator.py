column_number = "F"

for x in range(100):
    if x == 0:
        print(f"=AVERAGE({column_number}{((x+1) + (x*1000)) + 1}:{column_number}{(x+1)*100}1)")
    else:
        print(f"=AVERAGE({column_number}{(x*100)}2:{column_number}{(x+1)*100}1)")