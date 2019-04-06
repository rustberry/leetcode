class Solution:
    def twoSum(self, numbers, target):
        """
        :type numbers: List[int]
        :type target: int
        :rtype: List[int]
        """
        if len(numbers) < 2:
            return []
        elif len(numbers) == 2:
            return [1, 2]
            
        for i in range(len(numbers)):
            l = i
            r = len(numbers) - 1
            while l <= r:
                j = (l + r) // 2
                s = numbers[i] + numbers[j]
                if s > target:
                    r = j - 1
                elif s < target:
                    l = j + 1
                else:
                    if i == j:
                        numbers.remove(numbers[j])
                        j = numbers.index(numbers[j]) + 1
                    return [i+1, j+1]