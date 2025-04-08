import sys
input = sys.stdin.readline

def promising(i):  # i행에 배치한 퀸 대해서 문제 없는지 확인
    for k in range(i):
        if row[i] == row[k] or abs(row[i] - row[k]) == i - k:  # 같은 열이거나 같은 대각선
            return False
    return True
    
def backtracking(i):
    global result
    if i == N:  # 모든 행에 문제 없이 퀸을 배치했을 때
        result += 1
        return
    for j in range(N):
        if check[j]:  # 이미 퀸이 놓인 column
            continue
        row[i] = j  # i행 j열에 퀸 놓음
        if promising(i):
            check[j] = True  # j열 퀸 배치 체크
            backtracking(i + 1) # 다음 행에 대해 수행
            check[j] = False  # j열 퀸 배치 해제

N = int(input())
row = [0] * N  # board[n] = m은 n행 m열에 퀸을 놓았음을 의미한다
check = [False] * N
result = 0

backtracking(0)

print(result)