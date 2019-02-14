import math

n = int(input())
points = [tuple(map(int, input().split())) for _ in range(n)]
points.sort()

def ed(i1, i2):
    x1, y1 = points[i1]
    x2, y2 = points[i2]
    return math.sqrt((x1 - x2) ** 2 + (y1 - y2) ** 2)

bd = [[-1] * n for _ in range(n)]
bd[0][0] = 0
for i in range(1, n):
    bd[0][i] = bd[0][i - 1] + ed(i - 1, i)

for i in range(1, n):
    for j in range(i, n):
        if j - i <= 1:
            bd[i][j] = min(bd[k][i] + ed(k, j) for k in range(0, i))
        else:
            bd[i][j] = bd[i][j - 1] + ed(j - 1, j)

print(bd[n - 1][n - 1])