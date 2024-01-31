n = int(input())
xList = list(map(int, input().split()))
xList.sort()

print(xList)

result = 0
partyMemberLength = 0
for x in xList:
    # x 는 공포도
    partyMemberLength += 1
    if x <= partyMemberLength:
        result += 1
        partyMemberLength = 0

print(result)