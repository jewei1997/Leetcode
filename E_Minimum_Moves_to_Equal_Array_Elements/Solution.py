# finished in 15 mins - accepted first time
class Solution(object):
    def minMoves(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        nums.sort()
        running_diff = 0
        total_increments = 0
        for i in range(1,len(nums)):
            total_increments += (nums[i] - nums[i-1]) + running_diff
            running_diff += nums[i] - nums[i-1]
        return total_increments
x = Solution()
print x.minMoves([1,2,3])
