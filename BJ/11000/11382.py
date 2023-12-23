import math

h, m = map(int, input().split())
cookingTime = int(input())
cookingHour = math.floor(cookingTime / 60)
cookingMinute = cookingTime % 60

resultMinute = (m + cookingMinute) % 60
resultHour = math.floor((h + cookingHour + math.floor((m + cookingMinute) / 60)))

if resultHour >= 24:
    resultHour -= 24
print(resultHour, resultMinute)