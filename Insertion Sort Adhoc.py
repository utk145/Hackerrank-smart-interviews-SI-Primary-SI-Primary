# https://www.hackerrank.com/contests/smart-interviews/challenges/si-insertion-sort/problem



def insertionSort(a): 
    for i in range(1, len(a)):
        key = a[i] 
        j = i-1
        while j >=0 and key < a[j] : 
            a[j+1] = a[j] 
            j -= 1
        print(j+1, end=" ")
        a[j+1] = key
    print()



n = int(input())
for _ in range(n):
    m=int(input())
    a=list(map(int,input().split()))[:m]
    insertionSort(a)