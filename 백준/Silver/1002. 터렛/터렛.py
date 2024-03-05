import sys
input = sys.stdin.readline

t = int(input())

for i in range(t):
    result = 0
    x1, y1, r1, x2, y2, r2 = list(map(int, input().split()))
    dst = (x2-x1)**2 + (y2-y1)**2
    rSum = (r1+r2)**2
    rMinus = (r1-r2)**2

    if dst == 0 and r1 == r2:
        result = -1
    elif dst == rSum or dst == rMinus:
        result = 1
    elif rMinus < dst < rSum:
        result = 2
    elif dst > rSum or dst < rMinus or (dst == 0 and (r1 != r2)):
        result = 0
    print(result)