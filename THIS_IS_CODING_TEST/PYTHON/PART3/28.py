
n = int(input())
l = list(map(int, input().split()))

def binary(array, start, end):
    if start > end:
        return None
    mid = (start + end) // 2
    if array[mid] == mid:
        return mid
    elif array[mid] > mid:
        return binary(array, start, mid - 1)
    else:
        return binary(array,  mid+1, end)
    