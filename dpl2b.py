import copy, itertools, sys

v, e = map(int, input().split())
cost = [[float('inf')] * v for _ in range(v)]
count = [0] * v
total = 0

for _ in range(e):
    s, t, d = map(int, input().split())
    total += d
    cost[s][t] = min(cost[s][t], d)
    cost[t][s] = cost[s][t]
    count[s] += 1
    count[t] += 1

odds = [i for i in range(v) if count[i] % 2 != 0]
size = len(odds)
if size == 0:
    print(total)
    sys.exit(0)

wf = copy.deepcopy(cost)
for k, i, j in itertools.product(range(v), repeat=3):
    wf[i][j] = min(wf[i][j], wf[i][k] + wf[k][j])


dp = [float('inf')] * (2 ** size)
dp[0] = total

for x in range(2 ** size):
    for y, z in itertools.product(range(size), repeat=2):
        if y == z: continue
        if x & (1 << y) == 0 and x & (1 << z) == 0:
            p = x | (1 << y) | (1 << z)
            dp[p] = min(dp[p], dp[x] + wf[odds[y]][odds[z]])

print(dp[-1])