class SegmentTree(object):
    def __init__(self, n):
        t = 0
        while 2 ** t < n: t += 1

        self.n = 2 ** t
        self.inf = 2 ** 31 - 1
        self.tree = [self.inf] * (2 * self.n - 1)
    
    def update(self, i, x):
        i += self.n - 1
        self.tree[i] = x
        while i > 0:
            i = (i - 1) // 2
            self.tree[i] = min(self.tree[i * 2 + 1], self.tree[i * 2 + 2])
    
    def query(self, a, b):
        return self._query(a, b, 0, 0, self.n)
    
    def _query(self, a, b, k, l, r):
        if r <= a or b <= l: return self.inf
        if a <= l and r <= b: return self.tree[k]
        
        c = self._query(a, b, k * 2 + 1, l, (l + r) // 2)
        d = self._query(a, b, k * 2 + 2, (l + r) // 2, r)
        return min(c, d)
        
if __name__ == '__main__':
    n, q = map(int, input().split())
    st = SegmentTree(n)
    answers = []
    for _ in range(q):
        com, x, y = map(int, input().split())
        if com == 0:
            st.update(x, y)
        else:
            answers.append(st.query(x, y + 1))

    for answer in answers: print(answer)
