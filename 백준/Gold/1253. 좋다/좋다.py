import sys
open = sys.stdin.readline

n = int(input())

inputs = list(map(int, input().split()))
inputs.sort()

count = 0
for i, goal in enumerate(inputs):
    start = 0
    end = n-1
    while start < end:
        sum = inputs[start] + inputs[end]
        if sum == goal:
            if start != i and end != i:
                count += 1
                break
            elif start == i:
                start += 1
            elif end == i:
                end -= 1
        elif sum > goal:
            end -= 1
        elif sum < goal:
            start += 1
print(count)