# m x n 행렬 을 90 도로 돌리는 행렬
def turnRight90Matrix(matrix):
    n = len(matrix[0])
    m = len(matrix)
    newMatrix = [[0] * m for _ in range(n)]
    for i in range(m):
        for j in range(n):
            newMatrix[j][m-1-i] = matrix[i][j]
    return newMatrix

def checkUnlock(newLock, m, n):
    for i in range(n):
        for j in range(n):
            if newLock[i+m-1][j+m-1] != 1:
                return False 
    return True
            
            
def solution(key, lock):
    m = len(key)
    n = len(lock)

    for _ in range(4):
        key = turnRight90Matrix(key)
        for x in range(n+m-1):
            for y in range(n+m-1):
                newLock = [[0]*(2*m-2+n) for _ in range(2*m-2+n)]
    
                # 열쇠 중앙 부분에 기존 키 넣기
                for i in range(n):
                    for j in range(n):
                        newLock[i+m-1][j+m-1] = lock[i][j]

                # 자물쇠 + 열쇠
                for a in range(m):
                    for b in range(m):
                        newLock[x+a][y+b] += key[a][b]
                        
                # 자물쇠가 잘 풀렸는지 확인
                if checkUnlock(newLock, m, n):
                    return True
                
    return False