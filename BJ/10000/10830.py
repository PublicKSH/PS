n, b = map(int, input().split())
matrix = [[0] * n for _ in range(n)]

for i in range(n):
    inputList = list(map(int, input().split()))
    matrix[i] = inputList

print(matrix)