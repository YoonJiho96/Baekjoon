def isIn(pPos, pInfo):
    dst = (pInfo[0]-pPos[0])**2 + (pInfo[1] - pPos[1])**2
    if dst >= pInfo[2] ** 2:
        return False
    else:
        return True

num = int(input())
for i in range(num):
    inp = list(map(int, input().split()))
    start = inp[0:2]
    end = inp[2:4]
    
    rst = 0
    
    cnt = int(input())
    for j in range(cnt):
        pInfo = list(map(int, input().split()))
        if (isIn(start, pInfo) ^ isIn(end, pInfo)):
            rst += 1
    print(rst)
    