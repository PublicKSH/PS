n, k = map(int, input().split())
array = list(map(int, input().split()))

array = sorted(array, reverse=True)

print(array[k-1])