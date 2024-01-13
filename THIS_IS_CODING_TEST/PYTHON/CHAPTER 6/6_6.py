# 모든 원소의 값이 0보다 크거나 같다
array = [7, 5, 9, 0, 3, 1, 6, 2, 4, 8, 3, 1, 6, 2, 4, 8]

count = [0] * (max(array) + 1)

for i in range(len(array)):
    count[array[i]] += 1

for i in range(len(count)):
    print(i, ':', count[i])