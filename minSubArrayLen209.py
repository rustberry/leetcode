class Solution:
    def minSubArrayLen(self, s: int, nums: List[int]) -> int:
        sum = 0
        N = len(nums)
        l = N + 1
        start = 0
        
        for end in range(N):
            sum += nums[end]
            tempLen = end - start + 1
            
            while sum >= s:
                if tempLen < l:
                    l = tempLen  # 19:04
                    # print("start is", start, "end is", end)

                sum -= nums[start]
                start += 1

                tempLen = end - start + 1
        
        
        if l - 1 == N:
            return 0
        return l