class Solution:
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        dict = {v: index for index, v in enumerate(nums)}
        for i in range(len(nums)):
            complement = target - nums[i]
            elm = dict.get(complement)
            if elm is not None and elm != i:  # complement in dict
                return [i, elm]
        
        """
        r1 = 0
        r2 = 0
        if len(nums) == 2:
            return [0, 1]
        sn = sorted(nums)
        # print('sorted', sn)
        
        for i in range(len(sn)-1):
            if i > 0 and sn[i] == sn[i-1]:
                continue
            r = len(sn) - 1
            l = i
            # j = (r - i) // 2
            while l <= r:
                j = (r + l) // 2
                print('init\tl', l, 'r', r, 'j', j)
                s = sn[i] + sn[j]
                print('s', s)
                if s < target:
                    l = j + 1
                elif s > target:
                    r = j - 1
                else:
                    r1 = sn[i]
                    r2 = sn[j]
                    print('r1', r1, 'r2', r2, 'i', i, 'j', j)
                    i = nums.index(r1)
                    j = nums.index(r2)
                    print('i', i, 'j', j)
                    if i == j:
                        nums.remove(r1)
                        j = nums.index(r1) + 1
                    res = [i, j]
                    return res
            """
    
        """
        r1 = 0
        r2 = 0
        if len(nums) == 2:
            return [0, 1]
        sn = sorted(nums)
        print('sorted', sn)

        for i in range(len(sn)-1):
            if i > 0 and sn[i] == sn[i-1]:
                continue
            r = len(sn) - 1
            while i < r:
                s = sn[i] + sn[r]
                if s == target:
                    r1 = sn[i]
                    r2 = sn[r]
                    break
                elif s > target:
                    r -= 1
                    continue
                else:
                    break
                break

        i = nums.index(r1)
        j = nums.index(r2)
        if i == j:
            nums.remove(r1)
            j = nums.index(r1) + 1
        res = [i, j]
        return res
        """