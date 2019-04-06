class Solution:
    def fourSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        res = []
        nums.sort()
        for a in range(len(nums) - 3):
            if a > 0 and nums[a] == nums[a-1]:
                continue
            b = a + 1
            while b < len(nums) - 2:
                if b - 1> a and nums[b] == nums[b-1]:
                    b += 1
                    continue
                c = b + 1
                d = len(nums) - 1
                while c < d:
                    s = nums[a] + nums[b] + nums[c] + nums[d]
                    if s < target:
                        c += 1
                    elif s > target:
                        d -= 1
                    else:
                        res.append([nums[a], nums[b], nums[c], nums[d]])
                        while c < d and nums[c] == nums[c+1]:
                            c += 1
                        while c < d and nums[d] == nums[d-1]:
                            d -= 1
                        c += 1
                        d -= 1
                b += 1
        return res