N, M = map(int, input().split())

arrive = False
list = [[] for i in range (N)]
visited = [False] * N

for i in range(M):
    a, b = map(int, input().split())
    list[a].append(b)
    list[b].append(a)

def DFS(now, depth):
    global arrive
    if depth == 5 or arrive:
        arrive = True
        return 1
    visited[now] = True
    for i in list[now]:
        if visited[i] is False:
            DFS(i, depth+1)
    visited[now] = False


for i in range(N):
    DFS(i, 1)
    if arrive:
        break

if arrive:
    print(1)
else:
    print(0)
