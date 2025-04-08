totalPrice = int(input())
n = int(input())

sum = 0
for i in range(n):
    price, amount = (map(int, input().split()))
    sum += price*amount


print('Yes' if totalPrice == sum else 'No')