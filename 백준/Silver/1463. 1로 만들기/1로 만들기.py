T = int(input())

lst = [0, 0, 1, 1] + [0] * (T-3)

for i in range(4, T+1):
    lst[i] = lst[i-1] + 1
    if i%2 == 0:
        lst[i] = min(lst[i], lst[i//2]+1)
    if i%3 == 0:
        lst[i] = min(lst[i], lst[i//3]+1)
print(lst[T])