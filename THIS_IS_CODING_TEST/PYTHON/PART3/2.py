s = input()

result = 0
for i in range(len(s)):
    if s[i] == 0:
        continue
    if s[i] != 0:
        # 최초 입력
        if result == 0:
            result = int(s[i])
        else:
            result *= int(s[i])

print(result)