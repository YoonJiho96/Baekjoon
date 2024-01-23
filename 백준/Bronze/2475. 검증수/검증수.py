inputs = list(map(int, input().split()))
sum = 0
for num in inputs:
    sum += num**2
print(sum%10)