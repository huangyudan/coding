
# 找出一个字符串中，最大的重复子串
# 如，abcabc -> abc   11111 -> 1    1212ab -> 1212ab  12ab12 -> 12ab
# 解题思路，找出最小的那一个字串（穷举长度为1, 2, 3, ...的字串）

class Solution(object):
    def main(s):
        n = len(s)
        min_sub = s
        for j in range(1,len(s)+1):
            base = s[0:j]
            i = len(base)
            conbine = base * (n//i) + base[:n%i]
            if ( conbine == s):
                if (len(base)<len(min_sub)):
                    min_sub = base
        return min_sub



if __name__ == '__main__':
    s = input()
    print(Solution.main(s))