# https://www.hackerrank.com/contests/smart-interviews/challenges/si-words-vowels-and-consonants/problem


def wordVowCons(s,noSpaceInString,word_length,s_len,vowelcount,consonantcount):
    mydict = {}
    #vowelS = 'aeiou'
    for ch in noSpaceInString:
        try:
            mydict[ch] += 1
        except KeyError:
            mydict[ch] = 1

    for key,value in mydict.items():
        if key == 'a':
            vowelcount += value
        elif key == 'e':
            vowelcount += value
        elif key == 'i':
            vowelcount += value
        elif key == 'o':
            vowelcount += value
        elif key == 'u':
            vowelcount += value

    consonantcount = s_len - vowelcount

    print(str(word_length) + " " + str(vowelcount) + " " + str(consonantcount))

if __name__ == "__main__":
    m=int(input())
    for i in range(m):
        s=input()#.split()
        word_length = len(s.split())
        noSpaceInString=s.replace(" ","").lower()
        s_len = len(noSpaceInString)
        vowelcount = 0
        consonantcount = 0
        #s=''.join(s)
        wordVowCons(s,noSpaceInString,word_length,s_len,vowelcount,consonantcount)
        #print()