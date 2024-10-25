# 두숫자중에 큰수부터 더한다
T = int(input())
for test_case in range(1, T + 1):
    a,b,n = map(int, input().split())
    result = 0
    while(True):
        sum = min(a,b) + max(a,b)
        result += 1
        if (sum > n):
            print(result)
            break
        else:
            if a<b:
                a = sum
            else:
                b = sum
            
