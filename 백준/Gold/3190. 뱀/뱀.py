n = int(input())
k = int(input())

# board 좌측 끝 : [1, 1]
# board 초기화 및 사과 위치 입력
board = [[0]*(n+1) for _ in range(n+1)]
for i in range(k):
    x,y = map(int, input().split())
    board[x][y] = 2

# 뱀의 방향 변환 횟수
l = int(input())
turnList = []
for i in range(l):
    time, direction = input().split()
    time = int(time)
    turnList.append((time, direction))

# 뱀의 방향 (동, 남, 서, 북) => 오른쪽으로 90 도 회전을 위해서
dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

# 초기 상태 값 새팅
hx, hy = 1, 1 # 뱀 머리 위치
snakePoint = [(1,1)] # 뱀 위치
board[1][1] = 1
time =0
direction = 0
turnIndex = 0 # 회전할 정보
while True:
    nx = hx + dx[direction]
    ny = hy + dy[direction]

    # 다음위치로 진행할 수 있는 경우
    if 1 <= nx and nx <= n and 1 <= ny and ny <= n and board[nx][ny] != 1:
        if board[nx][ny] == 2:
            # 사과가 있는 경우
            board[nx][ny] = 1
            snakePoint.append((nx,ny))
        else:
            # 사과가 없는경우
            board[nx][ny] = 1
            snakePoint.append((nx,ny))
            tx, ty = snakePoint.pop(0)
            board[tx][ty] = 0
        # 시간 증가, 뱀의 머리 이동
        time += 1
        hx, hy = nx, ny
    # 다음위치로 진행할 수 없는 경우
    else:
        time += 1
        break

    # 방향 전환 진행
    if turnIndex < l and time == turnList[turnIndex][0]:
        # 회전할 시간인지 확인
        if turnList[turnIndex][1] == 'L':
            direction = (direction -1) % 4
        if turnList[turnIndex][1] == 'D':
            direction = (direction +1) % 4
        turnIndex += 1

print(time)
    
    