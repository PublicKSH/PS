n = int(input())
countA = 0
countB = 0

f = [0] * (n+1)
f[1] = f[2] = 1
for i in range(3, n+1): 
    countB += 1
    f[i] = f[i - 1] + f[i - 2];  # 코드2
count = [0] * (n+1)
print(f[n], countB)