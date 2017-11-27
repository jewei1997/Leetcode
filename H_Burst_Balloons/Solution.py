import operator

class Solution(object):

    # burstBalloons in nums from i to j and return the max number of max coins
    # attainable from bursting these balloons
    # def burstBalloons (self, nums, i, j):

    def get_from_memo (self, memo, i, j):
        return 1 if j < i else memo[i][j]

    def fill_memo (self, nums, memo, pair_len):
        if pair_len == 0:
            for pop_last in range(len(nums)):
                left = nums[pop_last-1] if pop_last > 0 else 1
                curr = nums[pop_last]
                right = nums[pop_last+1] if pop_last < len(nums)-1 else 1
                memo[pop_last][pop_last + pair_len] = left * curr * right
            return memo
        for sub_start in range(len(nums)-pair_len):
            for pop_last in range(sub_start, sub_start+pair_len):
                max_coins_before = self.get_from_memo(memo, 0, pop_last - 1)
                max_coins_after = self.get_from_memo(memo, pop_last+1, len(nums)-1)
                memo[pop_last][pop_last+pair_len] = max_coins_before * nums[pop_last] * max_coins_after
        return memo

    def maxCoins(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        memo = [[0 for j in range(len(nums))] for i in range(len(nums))]
        print "memo = ",
        print memo
        self.fill_memo (nums, memo, 0)
        print "memo after 0 = ",
        print memo
        self.fill_memo (nums, memo, 1)
        print "memo after 1 = ",
        print memo
        # for pair_len in range(len(nums)):
        #     self.fill_memo (nums, memo, pair_len)
        print memo

x = Solution()
x.maxCoins([3, 1, 5, 8])
