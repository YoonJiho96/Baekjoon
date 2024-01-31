import sys
input = sys.stdin.readline
n, m = map(int, input().split())

arr = [[0 for i in range(n+1)] for j in range(n+1)]
sums = [[0 for i in range(n+1)] for j in range(n+1)]

for i in range(1, n+1):
    inputs = list(map(int, input().split()))
    for j in range(1, n+1):
        arr[i][j] = inputs.pop(0)

for i in range(1, n+1):
    for j in range(1, n+1):
        sums[i][j] = sums[i][j-1] + sums[i-1][j] - sums[i-1][j-1] + arr[i][j]

for i in range(m):
    x1, y1, x2, y2 = map(int, input().split())
    print(sums[x2][y2] - sums[x1-1][y2] - sums[x2][y1-1] + sums[x1-1][y1-1]) 