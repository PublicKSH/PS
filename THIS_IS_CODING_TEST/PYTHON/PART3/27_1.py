
l = [1,1,2,2,2,2,3,3,4,4,4,4,5,6,7,8,9,10,10]
n, x= len(l), 2

def find_first(array, target, start, end):
    if start > end:
        return None
    mid = (start + end) // 2
    if (mid == 0 or target > array[mid-1]) and array[mid] == target:
        return mid
    elif array[mid] >= target:
        return find_first(array, target, start, mid - 1)
    else:
        return find_first(array, target, mid+1, end)
    
def find_last(array, target, start, end):
    if start > end:
        return None
    mid = (start + end) // 2
    if (mid == (n-1) or target < array[mid+1]) and array[mid] == target:
        return mid
    elif array[mid] > target:
        return find_last(array, target, start, mid - 1)
    else:
        return find_last(array, target, mid+1, end)
    
print(find_first(l,x,0,n-1))
print(find_last(l,x,0,n-1))