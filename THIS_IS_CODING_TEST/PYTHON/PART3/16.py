# todo: 다시 풀기
# 배울것 -> dfs를 사용한 2차원 배열에서의 조합(combination)

n, m = map(int, input().split())
# 기본 맵
baseMap = [[0]*m for _ in range(n)]
# 벽을 새울 맵
wallMap = [[0]*m for _ in range(n)]
for i in range(n):
    baseMap[i] = list(map(int,input().split()))


# part 1. Map 에 벽 새우기

# part 3. n x m Map의 안전한 방 개수 구하기
def getSafeRoom(Map, n, m):
    safeRoomNum = 0
    for i in range(n):
        for j in range(m):
            if Map[i][j] == 0:
                safeRoomNum += 1
    return safeRoomNum

# n x m Map에 바이러스 퍼트리기고 퍼트린 Map return
def virus(tempMap, x,y):
    if x <= -1 or y <= -1 or x >= n or y >= m:
        return False
    if tempMap[x][y] == 1:
        return False
    if tempMap[x][y] == 0:
        tempMap[x][y] = 2
        virus(tempMap,x-1,y)
        virus(tempMap,x+1,y)
        virus(tempMap,x,y-1)
        virus(tempMap,x,y+1)
        return True
    return False

result = 0

# dfs를 통한 2차원 배열 조합
def dfs(count):
    global result
    if count == 3:
        # 벽 새운 맵 초기화
        for i in range(n):
            for j in range(m):
                wallMap[i][j] = baseMap[i][j]
        # 바이러스 전파 시작
        for x in range(n):
            for y in range(m):
                if wallMap[x][y] == 2:
                    virus(wallMap,x-1,y)
                    virus(wallMap,x+1,y)
                    virus(wallMap,x,y-1)
                    virus(wallMap,x,y+1)
        
        # 안전 영역 계산
        result = max(result, getSafeRoom(wallMap, n, m))
        # 종료
        return

    # 빈 공간에 울타리 설치
    for i in range(n):
        for j in range(m):
            if baseMap[i][j] == 0:
                baseMap[i][j] = 1
                count += 1
                dfs(count)
                baseMap[i][j] = 0
                count -= 1
    
# part 1. 임의의 3개의 벽 새우기 (dfs 활용)
# part 2. 바이러스 퍼트리기
# part 3. 안전 영역 구하기 (최대 크기 갱신시 업데이트)

dfs(0)

print(result)