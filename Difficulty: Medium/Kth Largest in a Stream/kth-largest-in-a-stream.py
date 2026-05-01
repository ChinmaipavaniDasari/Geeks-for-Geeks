class Solution:
    def kthLargest(self, arr, k):
        # code here 
        ret=[]
        import heapq
        hp=[]
        for ve in arr:
            heapq.heappush(hp,ve)
            if len(hp)>k:
                heapq.heappop(hp)
            ret.append(-1)
            if len(hp)==k:
                ret[-1]=hp[0]
        return ret