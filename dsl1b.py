class WeightedUnionFindTree(object):
    def __init__(self, n):
        self.parents = list(range(n))
        self.ranks = [0] * n
        self.weights = [0] * n
    

    def find(self, x):
        if self.parents[x] == x: return x
        
        y = self.find(self.parents[x])
        self.weights[x] += self.weights[self.parents[x]]
        self.parents[x] = y
        return y
    

    def union(self, x, y, w):
        rx = self.find(x)
        ry = self.find(y)

        if self.ranks[rx] < self.ranks[ry]:
            self.parents[rx] = ry
            self.weights[rx] = w - self.weights[x] + self.weights[y]
        else:
            self.parents[ry] = rx
            self.weights[ry] = -w - self.weights[y] + self.weights[x]
            if self.ranks[rx] == self.ranks[ry]: self.ranks[rx] += 1
        

    def weight(self, x):
        return self.weights[x]


if __name__ == '__main__':
    n, q = map(int, input().split())
    wuft = WeightedUnionFindTree(n)
    answers = []
    for _ in range(q):
        tokens = list(map(int, input().split()))
        if tokens[0] == 0:
            c, x, y, z = tokens
            wuft.union(x, y, z)
        else:
            c, x, y = tokens
            answers.append(wuft.weight(x) - wuft.weight(y) if wuft.find(x) == wuft.find(y) else '?')
    
    for answer in answers: print(answer)