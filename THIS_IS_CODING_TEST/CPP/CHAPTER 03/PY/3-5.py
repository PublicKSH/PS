n, k = map(int, input().split())

count = 0

#단순하게 푸는 예시(책)

#n 이 k 이상이라면 k로 계속 나누기
while n >= k:
    if (n % k != 0):
        n -= 1
        count += 1
    #k로 나누기
    n //= k
    count += 1

while n > 1:
    n -= 1
    count += 1

"""
#내가 푼 답안
while n != 1:
    if (n % k == 0):
        n = n/k
        count += 1
    else:
        n -= 1
        count += 1
"""
print(count)
