# https://www.hackerrank.com/contests/smart-interviews/challenges/si-binary-representation/problem


def Binary(num):
    if num>1:
        Binary(int(num/2))
    print(num%2,end="")    

t=int(input()) 
for i in range(t):
    n=int(input())
    Binary(n)
    print()



