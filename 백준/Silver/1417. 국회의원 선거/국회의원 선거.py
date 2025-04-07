# 최대 n = 50, 득표수는 100 이하, 최대값 찾는 연산 O(n) 이므로 총 연산이 50 * 50(100 과 0 사이의 간격을 매꾸기 위해 50번의 연산) = 2500 번이므로
# 최대값을 찾고 1번에 주는 연산인 그리디로 진행

n = int(input())
arr = [0 for _ in range(n)]
result = 0
for i in range(n):
    arr[i] = int(input())

maxIndex = arr.index(max(arr))
while(maxIndex != 0):
    arr[maxIndex] -= 1
    arr[0] += 1
    result += 1
    maxIndex = arr.index(max(arr))

# 만약 max랑 같은 값이 있다면 result + 1
for i in range(1,n):
    if(arr[0] == arr[i]):
        result += 1
        break

print(result)
