n = int(input())
rgb = [[0 for _ in range(1000)] for _ in range(3)]
r,g,b = map(int, input().split())
rgb[0][0] = r
rgb[1][0] = g
rgb[2][0] = b
for i in range(1, n):
    r,g,b = map(int, input().split())
    rgb[0][i] = min(rgb[1][i-1], rgb[2][i-1]) + r
    rgb[1][i] = min(rgb[2][i-1], rgb[0][i-1]) + g
    rgb[2][i] = min(rgb[1][i-1], rgb[0][i-1]) + b

print(min(
rgb[0][n-1],
rgb[1][n-1],
rgb[2][n-1],
))