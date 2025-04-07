array = []
sum = 0
for i in range(5):
    num = int(input())
    array.append(num)
    sum += num

array = sorted(array)
print(int(sum / 5))
print(array[2])