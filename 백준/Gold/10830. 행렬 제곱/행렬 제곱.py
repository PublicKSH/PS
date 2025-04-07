# todo: 다시 풀기
import sys
input = sys.stdin.readline

n, b = map(int, input().split())
matrix = [[0] * n for _ in range(n)]

for i in range(n):  
    matrix[i] = list(map(int, input().split()))

# 조건 : 행렬 A,B의 크기는 n x n 
def multiplyMatric(matrixA, matrixB):
    newMatrix = [[0] * n for _ in range(n)]
    for i in range(n):
        for j in range(n):
            sum = 0
            for k in range(n):
                sum += ( matrixA[i][k] * matrixB[k][j] )
            newMatrix[i][j] = sum%1000
            
    return newMatrix

# 분할정복
def power(a, b):
    if b == 1:  # b의 값이 1이 될 때까지 재귀
        return a
    else:
        tmp = power(a, b // 2)  # a^(b // 2)
        if b % 2 == 0:
            return multiplyMatric(tmp, tmp)  # b가 짝수인 경우
        else:
            return multiplyMatric(multiplyMatric(tmp, tmp), a)  # b가 홀수인 경우
reusltMatrix = power(matrix, b)
# for i in range(b-1):
#     reusltMatrix = multiplyMatric(reusltMatrix, matrix)

for i in range(n):
    for j in range(n):
        print(reusltMatrix[i][j] % 1000, end=' ')
    print()
