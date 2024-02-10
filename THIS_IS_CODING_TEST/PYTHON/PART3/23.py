import sys
input = sys.stdin.readline

n = int(input())
studentList = []
for i in range(n):
    student, ko ,en, ma = input().split()
    ko = int(ko)
    en = int(en)
    ma = int(ma)
    studentList.append([student ,ko ,en ,ma])

studentList.sort(key= lambda x : (-x[1], x[2], -x[3], x[0]))

for i in studentList:
    print(i[0])