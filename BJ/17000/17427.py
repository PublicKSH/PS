# 1. 시간초과
# n = int(input())

# result = [0] * (n)
# for i in range(1, n+1):
#     print(i)
#     for j in range(1, i+1):
#         if i%j != 0:
#             continue
#         result[i-1] = result[i-1] + j

# print(sum(result))

# 2. n 이하의 자연수 중에서 i 를 약수로 갖는 수의 개수는 N/i 개이다
n = int(input())

result = 0
for i in range(1, n+1): # n의 제곱근을 정수화 시켜준 후 + 1
    result += (n//i)*i
        
print(result)