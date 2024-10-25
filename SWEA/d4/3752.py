# T = int(input())


# resultSet = set()
# def dfs(depth, maxDepth, sum, arr):
#     global resultSet
#     resultSet.add(sum)
#     if (depth == maxDepth +1):
#         return
#     else:
#        dfs(depth+1, maxDepth, sum + arr[depth], arr)
#        dfs(depth+1, maxDepth, sum, arr)

# # 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
# for test_case in range(1, T + 1):
#     n = int(input())
#     scoreList = list(map(int,input().split()))
#     resultSet = set()
#     dfs(0, n-1, 0, scoreList)
#     print(f"#{test_case} {len(resultSet)}")

T = int(input())

resultSet = set()
def dfs(depth, maxDepth, sum, arr):
    global resultSet
    resultSet.add(sum)
    if (depth == maxDepth +1):
        return
    else:
       dfs(depth+1, maxDepth, sum + arr[depth], arr)
       dfs(depth+1, maxDepth, sum, arr)

# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    n = int(input())
    scoreList = list(map(int,input().split()))
    resultSet = set()
    dfs(0, n-1, 0, scoreList)
    print(f"#{test_case} {len(resultSet)}")