array = [5, 7, 9, 0, 3, 1, 6, 2, 4, 8]

def quickSort(array, start, end):
    if start >= end:
        return
    pivot = start
    left = start +1
    right = end

    while left <= right:
        while left <= end and array[left] <= array[pivot]:
            left = left + 1
        while right > start and array[right] > array[pivot]:
            right = right - 1
        if left > right:
            array[right], array[pivot] = array[pivot], array[right]
        else:
            array[left], array[right] = array[right], array[left]
    
    
    quickSort(array, start, right - 1)
    quickSort(array, right +1, end)
quickSort(array, 0, len(array)-1)
print(array)