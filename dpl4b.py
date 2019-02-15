import itertools, collections, bisect

n, k, l, r = map(int, input().split())
a = list(map(int, input().split()))

t = [list(sorted(map(sum, itertools.combinations(a[:n//2], x)))) for x in range(k + 1)]
ans = 0
for k1 in range(k + 1):
    k2 = k - k1
    for v in map(sum, itertools.combinations(a[n//2:], k1)):
        ans += bisect.bisect_right(t[k2], r - v) - bisect.bisect_right(t[k2], l - v - 1)

print(ans)