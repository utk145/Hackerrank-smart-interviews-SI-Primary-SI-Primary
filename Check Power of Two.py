# https://www.hackerrank.com/contests/smart-interviews/challenges/si-check-power-of-two/problem



t=int(input())
for i in range(t):
    n=int(input())
    if(n&(n-1)==0):
        print(True)
    else:
        print(False)







