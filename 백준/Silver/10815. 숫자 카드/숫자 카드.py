n = int(input())
arrN = list(map(int, input().split()))
m = int(input())
arrM = list(map(int, input().split()))

def binary_search(arr, num, start, end):
    if start > end:
        return None
    else:
        mid = (start + end)//2
        if arr[mid] == num:
            return mid
        elif arr[mid] > num:
            return binary_search(arr, num, start, mid-1)
        else:
            return binary_search(arr, num, mid+1, end)


arrN.sort()
for num in arrM:
    if binary_search(arrN, num, 0, len(arrN)-1) != None:
        print(1, end=' ')
    else:
        print(0, end=' ')