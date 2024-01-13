import sys
sys.stdin = open("TEST_TXT/7_8.txt", "r")

n, m = map(int, input().split())
array = list(map(int, input().split()))
array = sorted(array)

def getLeftRiceCake(length):
    sum = 0
    for i in range(len(array)-1,0,-1):
        if length < array[i]:
            sum += array[i] - length
        else:
            break
    return sum


start = 0
end = max(array)
result = 0
while (start <= end):
    mid = (start + end) // 2

    leftRiceCake = getLeftRiceCake(mid)
    if leftRiceCake == m:
      result = mid
      break
    elif leftRiceCake > m:
        start = mid + 1
    else:
        end = mid - 1

print(result)