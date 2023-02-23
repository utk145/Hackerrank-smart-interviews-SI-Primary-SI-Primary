# https://www.hackerrank.com/contests/smart-interviews/challenges/si-swap-bits/problem


t=int(input())
for _ in range(t):
    n=int(input())
    s=bin(n)[2:]
    if(len(s)%2!=0):
        s='0'+s
    l=list(s)
    for i in range(0,len(s)-1,2):
        l[i],l[i+1]=l[i+1],l[i]
    s=""
    for i in l:
        s+=i
    print(int(s,2))    
        


