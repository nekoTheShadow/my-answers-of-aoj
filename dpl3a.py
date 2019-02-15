import itertools

h, w = map(int, input().split())
c = [list(map(int, input().split())) for _ in range(h)]

dp = [[0] * w for _ in range(h)]
for i in range(h): 
    if c[i][0] == 0: dp[i][0] = 1
for j in range(w):
    if c[0][j] == 0: dp[0][j] = 1

for i, j in itertools.product(range(h - 1), range(w - 1)):
    if c[i + 1][j + 1] == 0:
        dp[i + 1][j + 1] = min(dp[i][j], dp[i][j + 1], dp[i + 1][j]) + 1

answer = max(map(max, dp)) ** 2
print(answer)