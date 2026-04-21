class Solution:
	def minSteps(self, m, n, d):
		# Code here
		from math import gcd
        
        if d in (m, n):
            return 1
        if d > max(m, n) or d % gcd(m, n) != 0:
            return -1
        
        def solve(size_a: int, size_b: int, target: int) -> int:
            curr_a = curr_b = steps = 0
            while curr_a != target and curr_b != target:
                if curr_a == 0:
                    curr_a = size_a
                    steps += 1
                if curr_b == size_b:
                    curr_b = 0
                    steps += 1
                pour_size = min(curr_a, size_b - curr_b)
                curr_b += pour_size
                curr_a -= pour_size
                steps += 1
            return steps
        
        return min(solve(m, n, d), solve(n, m, d))