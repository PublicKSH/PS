n = 1260
count = 0

coin_types = [500, 100, 50, 10]

for coin in coin_types:
    count += n//coin
    n %= coin

"""
//연산자 : 나누기 연산 후 소수점 이하의 수를 버리고, 정수 부분의 수만 구함
향샹전 코드
for coin in coin_types:
    count += (int)(n/coin)
    n = (n%coin)
"""
print(count)