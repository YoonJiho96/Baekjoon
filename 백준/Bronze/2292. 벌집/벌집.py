n = int(input())

num = 1
cnt = 1
while num<n:
    cnt += 1
    num += (6*(cnt-1))
print(cnt)