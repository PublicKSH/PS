n, m, k = map(int, input().split())

data = list(map(int, input().split()))

data.sort()
first = data[n-1] # 가장 큰수
second = data[n-2] # 두번째로 큰수

#가장 큰수가 더해지는 수
count = int(m/(k+1)) * k
count += m % (k+1)

result = 0
result += first * count
result += second * (m-count)



"""
while True:
    for i in range(k):
        if m == 0:
            break
        result += first
        m -= 1
    if m == 0:
        break
    result += second
    m -= 1
"""
print(result)