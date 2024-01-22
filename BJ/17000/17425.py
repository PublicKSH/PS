# n = int(input())
# list = []
# for _ in range(n):
#     list.append(int(input()))

# # n 은 max 값
# maxNum = max(list)
# arr = [1] * (maxNum+1)
# arr[0] = 0
# sumArr = [0] * (maxNum+1)
# for i in range(2, maxNum+1):
#     j = 1
#     while (i * j) <=maxNum:
#         arr[i*j] += i
#         j += 1

# for i in range(1, maxNum+1):
#     sumArr[i] = sumArr[i-1] + arr[i]

# for i in list:
#     print(i, sumArr[i])

n = int(input())
list = []
for _ in range(n):
    list.append(int(input()))

# n 은 max 값
maxNum = max(list)
arr = [1] * (maxNum+1)
sumArr = [0] * (maxNum+1)
for i in range(2, maxNum+1):
    j = 1
    while (i * j) <=maxNum:
        arr[i*j] += i
        j += 1

for i in range(1, maxNum+1):
    sumArr[i] = sumArr[i-1] + arr[i]

for i in list:
    print(sumArr[i])