# https://www.hackerrank.com/contests/smart-interviews/challenges/si-find-first-repeating-character/problem



t=int(input())
for i in range(t):
    s=input()
    for i in s:
        if s.count(i)>1:
            print(i)
            break
    else:
        print('.')
            
    