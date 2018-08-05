#到达终点的最小步数 leetcode原题 754 https://leetcode.com/problems/reach-a-number/solution/
# 分情况讨论：到target与到abs(target)的情况是一样的
# 1. total = 1+2+...+k，求total刚好大于等于n的k，可知到达target至少要用k步，此时超出d=total-k
# 2. 如果d为偶数，则只需将d/2步反向即可，k步即可到达target
# 3. 如果d为奇数，则k步不可能到达，因为任何反转都会改变偶数距离，不可能消去d，则再走一步判断d+k+1是否为偶数
# 4. 如果为偶数，说明k+1步可到
# 5. 如果d+k+1为奇数，且已知d为奇数，说明k+1为偶数，不可能在k+1步走到，再走一步，d+k+1+k+2必为偶数，k+2步可到

class Solution(object):
    def reachNumber(self, target):
        target = abs(target)
        k = 0
        while target > 0:
            k += 1
            target -= k

        return k if target % 2 == 0 else k + 1 + k%2

if __name__ == '__main__':
    s = input()
    s1 = Solution()
    print(s1.solution(s))