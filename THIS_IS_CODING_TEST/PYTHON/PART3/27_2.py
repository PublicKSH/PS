from bisect import bisect_left, bisect_right

l = [1,1,2,2,2,2,3,3,4,4,4,4,5,6,7,8,9,10,10]
n, x= len(l), 2

print(bisect_left(l,x))
print(bisect_right(l,x))