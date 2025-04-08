result = 0
N, T = map(int, input().split())
carrotList = []
checkEatCarrot = [False for _ in range(N)]
for i in range(N):
    wi, pi = map(int, input().split())
    carrotList.append((wi, pi))

sortedList = sorted(carrotList, key= lambda x : (x[1],x[0]), reverse=True)

# 마지막날부터 당근을 먹습니다
# k 는 list의 index
k = 0
for i in range(T-1,T-N-1,-1):
    result += sortedList[k][0] + sortedList[k][1] * i
    k += 1


print(result)