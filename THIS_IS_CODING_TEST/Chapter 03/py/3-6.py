n, k = map(int, input().split())

count = 0

#한꺼번에 나누어 지는 수로 뺀후 나누기 -> 이렇게 하면 1씩 빼는 것 보다 반복문 순회가 적다

while True:
    target = (n//k) * k
    count += (n - target)
    n = target

    if n<k:
        break
    #K로 나누기
    count += 1
    n //= k

# 마지막으로 남은 수에 대하여 1씩 빼기
count += (n-1)
print(count)
