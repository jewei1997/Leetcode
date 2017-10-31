# finished in 15 mins - accepted on first try
#
# Given a non-empty integer array, find the minimum number of moves required to
# make all array elements equal, where a move is incrementing a selected element
# by 1 or decrementing a selected element by 1.
#
# You may assume the array's length is at most 10,000.
class Solution(object):
    def minMoves2(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        nums.sort()
        midpoint = 0
        if (len(nums) % 2 == 0):
            midpoint = (nums[(len(nums)/2) - 1] + nums[len(nums)/2])/2
        else:
            midpoint = nums[len(nums)/2]
        total_difference = 0
        for i in range(len(nums)):
            total_difference += abs(nums[i] - midpoint)
        return total_difference
x = Solution()
print x.minMoves2([1,2,3])
