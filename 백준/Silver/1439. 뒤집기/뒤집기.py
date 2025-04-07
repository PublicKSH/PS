# 1. 문자열 압축 0011001  => 0101 0,1 중에 더 적은 숫자 출력
# import sys
# input = sys.stdin.readline

s = input()
count0 = 0
count1 = 0

if s[0] == '0':
    count1+=1
else:
    count0+=1

for i in range(1, len(s)):
    if s[i] != s[i-1]:
        if s[i] == '0':
            count1+=1       
        else:       
            count0+=1       

print(min(count0, count1))