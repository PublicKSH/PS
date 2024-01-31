n, m, k = map(int, input().split())
data = list(map(int, input().split()))

data.sort()
first = data[n-1]
second = data[n-2]

count = 0
result = 0
while True:
    for i in range(k):
        if count == m:
            break
        result += first
        count += 1
    if count == m: break
    result += second
    count += 1

print(result)