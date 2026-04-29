class Solution:
    def minSwaps(self, arr):
        # code here
        total = sum(arr)
        if total<2:
            return total-1
        curr = sum(arr[:total])
        ans = total-curr
        n = len(arr)
        # print(ans, curr, total, n)
        for i in range(1, n-total+1):
            curr -= arr[i-1]
            curr += arr[i+total-1]
            # print(curr)
            ans = min(ans, total-curr)
            
        return ans