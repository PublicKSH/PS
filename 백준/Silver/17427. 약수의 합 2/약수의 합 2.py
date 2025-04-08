n = int(input())

result = 0
for i in range(1, n+1): # n의 제곱근을 정수화 시켜준 후 + 1
    result += (n//i)*i
        
print(result)