array = [5, 7, 9, 0, 3, 1, 6, 2, 4, 8]
arrayTest = [] + []
def quickSort(array):
    if len(array) <= 1:
        return array
    pivot = array[0]
    tail = array[1:]

    leftSide = [x for x in tail if x <= pivot]
    rightSide = [x for x in tail if x > pivot]

    return quickSort(leftSide) + [pivot] + quickSort(rightSide)

print(quickSort(array))