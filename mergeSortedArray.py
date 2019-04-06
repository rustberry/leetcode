class Solution:
    def merge(self, nums1, m, nums2, n):
        """
        :type nums1: List[int]
        :type m: int
        :type nums2: List[int]
        :type n: int
        :rtype: void Do not return anything, modify nums1 in-place instead.
        """
        m -= 1
        n -= 1
        index = -1
        while m >= 0 and n >= 0:
            if nums1[m] >= nums2[n]:
                nums1[index] = nums1[m]
                m -= 1
            else:
                nums1[index] = nums2[n]
                n -= 1
            index -= 1
        
        print("after loop m:", m, 'n:', n, 'index', index)
        print('nums1: ', nums1, 'nums2: ', nums2)
        if n < 0:
            while m >= 0:
                nums1[index] = nums1[m]
                m -= 1
                index -= 1
        else:
            while n >= 0:
                nums1[index] = nums2[n]
                n -= 1
                index -= 1