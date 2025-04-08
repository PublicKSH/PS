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