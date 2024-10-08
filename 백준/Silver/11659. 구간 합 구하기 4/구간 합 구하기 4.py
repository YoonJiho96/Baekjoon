import sys
input = sys.stdin.readline
n, m = map(int, input().split())

inputs = [0] + list(map(int, input().split()))

arr = [0] * (n+1)

for i in range(1, n+1):
    arr[i] = arr[i-1] + inputs[i]

for i in range(m):
    a, b = map(int, input().split())
    print(arr[b] - arr[a-1])