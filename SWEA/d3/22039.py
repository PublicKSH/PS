T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.

for test_case in range(1, T + 1):
    # 초기화
    N = int(input())  
    if N%3 == 1:
        print("impossible")
    if N%3 == 0:
        print("BBA" * (N//3))
    if N%3 == 2:
        print("BA" + "BBA" * (N//3))