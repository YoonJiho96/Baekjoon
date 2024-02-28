import sys
input = sys.stdin.readline

def fact(n):
    num = 1
    for i in range(1, n+1):
        num *= i
    return num

t = int(input())

for i in range(t):
    n, m = map(int, input().split())

    result = fact(m) // (fact(m-n) * fact(n))
    print(result)