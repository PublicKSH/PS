# todo : 이분탐색 다시 풀기

# 1. dp 사용
n = int(input())
array = list(map(int, input().split()))
dp = [1] * n

# LIS
# for i in range(n):
#     for j in range(i):
#         if array[i] < array[j]:
#             dp[i] = max(dp[i] ,dp[j] + 1)

# print(dp)
# print(n - max(dp))

# LDS
# for i in range(n-1, -1, -1):
#     for j in range(n-1 ,i , -1):
#         if array[i] > array[j]:
#             dp[i] = max(dp[i] ,dp[j] + 1)

# print(dp)
# print(n - max(dp))

# 2. 이분 탐색 사용 (미완)
# 이분 탐색을 통해 LIS를 유지하기 위해 숫자가 들어갈 위치를 탐색
# def binarySearchForLIS(lisList, target, start, end):
#     while  (start < end):
#         mid = (start + end) // 2
#         if lisList[mid] < target:
#             start = mid + 1
#         else:
#             end = mid -1
#     return end

# # 뒤집기 필수
# array = array[::-1]
# lis = []
# lis.append(array[0])
# for i in range(1, n):
#     if lis[len(lis)-1] < array[i]:
#         lis.append(array[i])
#     else:
#         index = binarySearchForLIS(lis, array[i], 0, len(lis))
#         lis[index] = array[i]
# print(n - len(lis))