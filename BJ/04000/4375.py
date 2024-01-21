while True:
    try:
        n = int(input())
    except:
        break
    onlyOneNumber = 1
    while onlyOneNumber % n != 0:
        onlyOneNumber = onlyOneNumber * 10 + 1
    print(len(str(onlyOneNumber)))