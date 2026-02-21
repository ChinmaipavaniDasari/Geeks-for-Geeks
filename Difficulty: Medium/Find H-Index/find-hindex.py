class Solution:
    def hIndex(self, citations):
        #code here
        import bisect
        citations.sort()
        lth=len(citations)
        l=0
        r=max(citations)+1
        while l<r:
            m=l+(r-l)//2
            ix=bisect.bisect_left(citations,m)
            if lth-ix>=m:
                l=m+1
            else:
                r=m
        return l-1