import sys
sys.stdin = open("TEST_TXT/4_4.txt", "r")

n, m = map(int, input().split())

# 가본 좌표 체크
d = [[0] * m for _ in range(n)]

# 캐릭터 좌표, 방향
x, y, direction = map(int, input().split())

# 방문한 땅 위치
count = 0

# 최초 위치 체크 d[x][y] 및 방문한 땅 개수 증가
d[x][y] = 1 
count += 1

# map
array = []
for i in range(n):
    array.append(list(map(int, input().split())))

# 방향 전환 함수
def turnDirectionCounterClockWise90Percent(nowDirection):
    if (nowDirection == 0):
        return 3
    else:
        return nowDirection - 1

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]


turnCount = 0

while (True):
    # 1. 왼쪽 방향으로 회전
    direction = turnDirectionCounterClockWise90Percent(direction)
    turnCount += 1
    print("direction", direction)
    nX = x + dx[direction]
    nY = y + dy[direction]
    # 방향 전환 횟수

    # 갈 수 있는지 체크
    if (d[nX][nY] != 1 and array[nX][nY] != 1):
        print("갈 수 있습니다.")
        x = nX
        y = nY
        d[nX][nY] = 1
        count += 1
        turnCount = 0
        continue
    else:
        print("갈 수 없습니다.")
        if (turnCount == 3):
            # 바라보는 방향을 유지한 채로 뒤로 이동
            # 뒤가 바다면 종료
            nX = x - dx[direction]
            nY = y - dy[direction]
            if array[nX][nY] == 0:
                x = nX
                y = nY
            else:
                break
            turnCount = 0

        
print(count)