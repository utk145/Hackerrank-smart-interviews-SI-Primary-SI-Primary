# https://www.hackerrank.com/contests/smart-interviews/challenges/si-trailing-zeros


''' We need to comeup with  a logic which gives us the answer without worrying about calculating  the value of n! '''
# we are interested in finding no of times factors of 10 are coming
''' occurences of 2 > occurences of 5
therefore, no of zeros = occurences of 5

10! ==>  10/5  + 10/(5^2)  = 2 + 0 = 2
100! ==>  100/5 + 100/(5^2) + 100/(5^3) = 20+4+0 = 24 trailing zeros
 
'''


def trailingZeros(n):
    ans=0
    power=5
    while((n/power)>0):
        ans += n//power   
        power=power*5
    return ans


t=int(input())
for i in range(t):
    n=int(input())
    print(trailingZeros(n))

