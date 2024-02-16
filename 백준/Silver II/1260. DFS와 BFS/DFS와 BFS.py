from queue import Queue

N, M, V = map(int, input().split())

list = [[] for i in range(N+1)]
visitied = [False] * (N + 1)
visitied2 = [False] * (N + 1)
visitStack = []
visitList = []


def DFS(num):
    if visitied[num] is True:
        return
    visitied[num] = True
    visitStack.append(num)
    for i in list[num]:
        DFS(i)

def BFS(num):
    visitied2[num] = True
    que = Queue()
    que.put(num)

    while que.qsize() > 0:
        next = que.get()
        visitList.append(next)
        for i in list[next]:
            if visitied2[i] is not True:
                visitied2[i] = True
                que.put(i)

    
for i in range(1, M+1):
    a, b = map(int, input().split())
    list[a].append(b)
    list[b].append(a)

for i in range(len(list)):
    list[i].sort()

DFS(V)
print(*visitStack)

BFS(V)
print(*visitList)