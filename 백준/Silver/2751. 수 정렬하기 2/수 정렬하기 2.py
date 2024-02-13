import sys
n = int(input())
inputs = list(map(int, sys.stdin.read().split()))
inputs.sort()
print("\n".join(map(str, inputs)))