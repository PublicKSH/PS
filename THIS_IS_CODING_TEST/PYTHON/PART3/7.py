s = input()
leftS = s[0: int(len(s)/2)]
rightS = s[int(len(s)/2):]
intLeftS = [int(char) for char in leftS]
intRightS = [int(char) for char in rightS]

if sum(intLeftS) == sum(intRightS):
    print('LUCKY')
else:
    print("READY")