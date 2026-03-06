class Solution:
    def minWindow(self, s, p):
        # code here
        def check(a,b):
            for i in b:
                if i not in a or b[i]>a[i]:
                    return False
            return True
        h={}
        b={}
        for i in p:
            b[i]=b.get(i,0)+1
        l=0
        r=""
        v=""
        for i in range(len(s)):
            v+=s[i]
            h[s[i]]=h.get(s[i],0)+1
            while check(h,b):
                if  i-l+1<len(r) or len(r)==0:
                    r=s[l:i+1]
                h[s[l]]-=1
                l+=1
        return r
        