# https://www.hackerrank.com/contests/smart-interviews/challenges/si-flip-bits/problem



def count(n):
    c=0
    while(n):
        c += n&1
        n>>=1
    return c

def  flipped(a,b):
    return count(a^b)


for _ in range(int(input())):
    a,b=map(int,input().split())
    print(flipped(a,b))