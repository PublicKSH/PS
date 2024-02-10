n = int(input())
room = [[] for _ in range(n)]
tempRoom = [["X"]*n for _ in range(n)]
for i in range(n):
    room[i] = list(input().split())
# 초기 선생님 위치 저장
teacherPoint =[]
for i in range(n):
    for j in range(n):
        if room[i][j] == 'T':
            teacherPoint.append((i,j))

result = False

def monitorStudent(x, y):
    # 동
    for i in range(y, n):
        if tempRoom[x][i] == 'O':
            break
        if tempRoom[x][i] == 'S':
            # print('동 teacher: ', x, y,'student: ', x, i)
            return False
    # 남
    for i in range(x, n):
        if tempRoom[i][y] == 'O':
            break
        if tempRoom[i][y] == 'S':
            # print('남 teacher: ', x, y,'student: ', x, i)
            return False
    # 서 
    for i in range(y, -1, -1):
        if tempRoom[x][i] == 'O':
            break
        if tempRoom[x][i] == 'S':
            # print('서 teacher: ', x, y,'student: ', x, i)
            return False
    # 북
    for i in range(x, -1, -1):
        if tempRoom[i][y] == 'O':
            break
        if tempRoom[i][y] == 'S':
            # print('북 teacher: ', x, y,'student: ', x, i)
            return False
        
    # 아무것도 발견하지 못하는 경우
    return True

# 방을 새우는 경우 조합 (dfs 사용)
def dfs(count):
    global result
    if count == 3:
        for i in range(n):
            for j in range(n):
                tempRoom[i][j] = room[i][j]

        tempResult = True
        # 선생님들 감시 범위 확장
        for point in teacherPoint:
            if not monitorStudent(point[0], point[1]):
                # 학생이 들켰다면 
                tempResult = False
        # 학생이 한번이라도 들키지 않았다면
        if tempResult:
            result = True
        
        return
    
    # 빈 공간에 방해물 설치
    for i in range(n):
        for j in range(n):
            if room[i][j] == 'X':
                room[i][j] = 'O'
                count += 1
                dfs(count)
                room[i][j] = 'X'
                count -= 1

dfs(0)

if result:
    print('YES')
else:
    print('NO')