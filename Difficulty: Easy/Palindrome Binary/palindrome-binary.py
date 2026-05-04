class Solution:
    def isBinaryPalindrome(self, n):
        # code here
        def binary_over(n, new_list):
            if n==0:
                new_list.append(1)
                return new_list
            if n== 1:
                new_list.append(1)
                return new_list
            if n %2==0:
                new_list.append(0)
            else:
                new_list.append(1)
            return binary_over(n//2, new_list)
        result = binary_over(n,[])
        j =0
        for i in range(len(result)-1,-1,-1):
            if result[i] == result[j]:
                j+=1
            else:
                return False
        return True