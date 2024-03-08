import sys
sys.setrecursionlimit(10**7)
input = sys.stdin.readline

# N : 정점, M : 간선 갯수
N, M = map(int, input().split())

list = [[] for _ in range(N+1)]
visit = [False] * (N+1)


for i in range(M):
    u, v = map(int, input().split())
    list[u].append(v)
    list[v].append(u)
    
def DFS(v):
    visit[v] = True
    for i in list[v]:
        if visit[i] is False:
            visit[i] = True
            DFS(i)
            
count = 0

for i in range(1, N+1):
    if visit[i] is False:
        count+=1
        DFS(i)
print(count)
