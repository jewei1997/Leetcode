# Given a non-empty array of integers, return the k most frequent elements.
#
# For example,
# Given [1,1,1,2,2,3] and k = 2, return [1,2].
# very easy - finished in 10 mins

import operator
class Solution(object):
    def topKFrequent(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        dict_ = {}
        for num in nums:
            if (dict_.has_key(num)):
                dict_[num] += 1
            else:
                dict_[num] = 1
        sorted_by_vals = list(reversed(sorted(dict_.items(), key=operator.itemgetter(1))))
        freq_list = list(map(lambda (x,y) : x, sorted_by_vals))
        return freq_list[0:k]


x = Solution()
x.topKFrequent([1,1,1,2,2,3], 2)
