earthMoonConvertWeight = 0.167

while(True):
    inputFloat = float(input())
    if inputFloat == -1:
        break
    print(f"Objects weighing {inputFloat:.2f} on Earth will weigh {inputFloat*earthMoonConvertWeight:.2f} on the moon." )