# 그리디
a,b = map(int, input().split())

# 1. B를 A로 바꾸자 why? 키우는건 끝이 없지만 작아지는건 한계가 존재
# 1의 자리가 1일 때만 81 -> 8 의 연산 수행 가능
# 그외엔 /2만 가능, 마지막에 1 이 되면 종료

result = 0
while b != 1:
    result += 1
    if b%10 == 1:
        b = int(b/10)
    else:
        b = b/2
    if (b==a):
        break

    if (b < a):
        break

if (b == a):
    print(result+1)
else:
    print(-1)


# 위에는 혼자 푼식
# 아레와 같이 bfs도 가능
# from collections import deque
# a,b = map(int,input().split())
# q = deque()
# q.append((a,1))
# r = 0

# while(q):
#     n,t = q.popleft()
#     if n > b:
#         continue
#     if n == b:
#         print(t)
#         break
#     q.append((int(str(n)+"1"),t+1))
#     q.append((n*2,t+1))
# else:
#     print(-1)
