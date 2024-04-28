import sys
input = sys.stdin.readline

n = int(input())
results = [0] * 10001
for i in range(n):
    num = int(input())
    results[num] += 1
for i in range(1, 10001):
    for j in range(results[i]):
        print(i)