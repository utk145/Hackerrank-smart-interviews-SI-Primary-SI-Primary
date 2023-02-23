# https://www.hackerrank.com/contests/smart-interviews/challenges/si-finding-cuberoot/problem



def cubeRoot(n,lo,hi):
    while(lo < hi):
        mid = (lo+hi)//2
        if mid * mid * mid == n :
            return mid
        elif mid * mid * mid < n :
            return cubeRoot(n,mid,hi)
        else:
            return cubeRoot(n,lo,mid)

def cubeRootNegative(n, lo, hi):
    while (lo < hi):
        mid = (lo + hi) // 2
        if mid * mid * mid == n:
            return mid
        elif mid * mid * mid < n:
            return cubeRootNegative(n, mid, hi)
        else:
            return cubeRootNegative(n, lo, mid)

if __name__ == "__main__":
    
    for i in range(int(input())):
        n=int(input())
        if n==1:
            print("1")
        elif n==-1:
            print("-1")
        elif n>1:
            lo = 0
            hi = n
            print(cubeRoot(n,lo,hi))
        elif n <-1:
            lo = n
            hi = 0
            print(cubeRootNegative(n, lo, hi))