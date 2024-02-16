# 1. 첫번째 시도 -> 시간 초과
# 2. 두번째 시도 -> 퀸을 놓을 수 있는 위치인지 직선 기준으로 찾음
# 3. 세번째 시도 -> 인터넷 답지 (borad를 1차원 배열로 두는것이 정답)
n = int(input())
board = [[0]* n for _ in range(n)]
result = 0
# row, col에 퀸을 놓을 수 있는지 확인
# def check(row, col):
#     # 위쪽 행/ 왼쪽 열에 퀸이 있는지 확인
#     # 왼쪽 위 대각선, 오른쪽 위 대각선에 퀸이 있는지 확인
#     for i in range(row):
#         for j in range(n):
#             if i == row or j == col or abs(row-i) == abs(col - j):
#                 if board[i][j] == 1:
#                     return False      
#     return True
def check(row, col):
    for i in range(row):
        if board[i][col] == 1:
            return False
    i, j = row - 1, col - 1
    while 0 <= i and 0 <= j:
        if board[i][j] == 1:
            return False
        i -= 1
        j -= 1

    i, j = row - 1, col + 1
    while 0 <= i and j < n:
        if board[i][j] == 1:
            return False
        i -= 1
        j += 1
    return True
def dfs(row):
    global result
    if row == n: 
    # 제일 아래 열까지 도달하는데 성공한 경우
        result += 1
        return 1
    else:
        for i in range(n):
            if check(row, i):
                board[row][i] = 1
                dfs(row+1)
                board[row][i] = 0


dfs(0)
print(result)