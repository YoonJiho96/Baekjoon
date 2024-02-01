import sys
input = sys.stdin.readline

s, p = map(int, input().split())

str = list(input())

a, c, g, t = map(int, input().split())

start = 0
end = p
result = 0

strings = str
temp = list(str[start:end])
wordDict = {"A": temp.count("A"), "C": temp.count("C"), "G": temp.count("G"), "T": temp.count("T")}

if wordDict["A"] >= a and wordDict["C"] >= c and wordDict["G"] >= g and wordDict["T"] >= t:
    result += 1

while end < s:
    wordDict[strings[end]] += 1
    wordDict[strings[start]] -= 1

    if wordDict["A"] >= a and wordDict["C"] >= c and wordDict["G"] >= g and wordDict["T"] >= t:
        result += 1

    start += 1
    end += 1
print(result)