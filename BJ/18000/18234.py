# # 첫번째 풀이 => 시간초과
# # N <= T 이라는 조건이 있어서 가능
# # 마지막날 부터 먹어 치운다 -> 마지막날에 가장 큰 맛을 기준으로 한개씩 먹으면 최대의 맛을 보장할 수 있다.
# # 마지막날에 먹은 당근을 제외하고 영양제를 한번 안준 값을 기준으로 다시 순위를 매긴다
# # 첫번째 풀이의 경우 시간 복잡도가 정렬 * T로 매우 높음
# result = 0
# N, T = map(int, input().split())
# carrotList = []
# checkEatCarrot = [False for _ in range(N)]
# for i in range(N):
#     wi, pi = map(int, input().split())
#     carrotList.append((wi, pi, i))
#     # i의 경우 이미 훔친 당근을 표시하기 위함

# # 마지막날부터 당근을 먹습니다
# for i in range(T-1,T-N-1,-1):
#     sortedList = sorted(carrotList, key= lambda x : x[1]*(i)+x[0], reverse=True)
#     # 이미 훔쳐 먹은 당근의 경우 => 
#     k = 0
#     while(True):
#         if(checkEatCarrot[sortedList[k][2]] != False):
#             k += 1
#         else:    
#             checkEatCarrot[sortedList[k][2]] = True
#             result += sortedList[k][0] + sortedList[k][1] * i
#             # N <= T 라서 반드시 반복분을 빠져 나감
#             break
        
# print(result)

# 두번째 풀이 -> 계산식을 두들기니 먹고 다시 계산할 필요는 없었다
# 졸릴떈 쉬도록 하자

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