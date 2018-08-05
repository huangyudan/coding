

# 找出一个数组A中的的一个子数组B的长度，使得
# 当0<i<len(B)-1时, 有B[0]<B[1]<...<B[i]<...<B[-2]<B[-1]
# 解题思路，穷举所有可能的低谷所在的位置，找出最大的那一个子数组
# [4,3,2,5,3,1,4,8] 输出5 在index=5的值为1做山谷时取得


class Solution(object):
    def main(self,nums):
        if len(nums)<=2:
            return len(nums)
        res = 0
        for k in range(1,len(nums)):
            left = k-1
            right = k+1
            count = 1
            while (left>=0):
                if (nums[left]>=nums[left+1]):
                    left -= 1
                    count += 1
                else:
                    break
            while (right<=len(nums)-1):
                if (nums[right]>=nums[right-1]):
                    right += 1
                    count += 1
                else:
                    break
            if (count>res):
                res = count
        return res


if __name__ == '__main__':
    input = input()
    nums = list(map(int, input.lstrip("[").rstrip(']').split(",")))
    s1 = Solution()
    print(s1.main(nums))