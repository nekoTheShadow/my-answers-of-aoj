import itertools, collections

n, v = map(int, input().split())
a = list(map(int, input().split()))
b = list(map(int, input().split()))
c = list(map(int, input().split()))
d = list(map(int, input().split()))

t1 = collections.Counter(map(sum, itertools.product(a, b)))
t2 = collections.Counter(map(sum, itertools.product(c, d)))

ans = sum(t1[x] * t2[v - x] for x in t1)
print(ans)