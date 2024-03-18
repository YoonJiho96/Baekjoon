import sys
input = sys.stdin.readline
n = int(input())

inputs = list()
for i in range(n):
    inputs.append((int(input()), i))
sortedList = sorted(inputs)
answer = list()
for i in range(n):
    answer.append(sortedList[i][1] - i)
print(max(answer) + 1)