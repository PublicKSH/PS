import sys
sys.stdin = open("TEST_TXT/7_5.txt", "r")

n = int(input())
inventoryList = list(map(int, input().split()))
inventoryList = sorted(inventoryList)
m = int(input())
targetList = list(map(int, input().split()))

def binarySearch(array, target, start, end):
    while start <= end:
        mid = (start + end)//2
        if array[mid] == target:
            return 'Yes'
        elif array[mid] > target:
            end = mid - 1
        else:
            start = mid + 1
    return 'No'


for i in range(m):
    print(binarySearch(inventoryList, targetList[i], 0, len(inventoryList)), end=' ')