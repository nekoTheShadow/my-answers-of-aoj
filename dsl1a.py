class UnionFindTree(object):
    def __init__(self, n):
        self.parents = list(range(n))
        self.ranks = [0] * n
    

    def find(self, x):
        if self.parents[x] == x: return x

        self.parents[x] = self.find(self.parents[x])
        return self.parents[x]
    

    def union(self, x, y):
        x = self.find(x)
        y = self.find(y)
        if x == y: return
        
        if self.ranks[x] < self.ranks[y]:
            self.parents[x] = self.parents[y]
        else:
            self.parents[y] = self.parents[x]
            if self.ranks[x] == self.ranks[y]: self.ranks[x] += 1


if __name__ == '__main__':
    n, q = map(int, input().split())
    uft = UnionFindTree(n)
    answers = []
    for _ in range(q):
        com, x, y = map(int, input().split())
        if com == 0:
            uft.union(x, y)
        else:
            answers.append(1 if uft.find(x) == uft.find(y) else 0)

    for answer in answers: print(answer)
