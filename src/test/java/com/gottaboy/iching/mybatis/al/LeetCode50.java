package com.gottaboy.iching.mybatis.al;

import org.assertj.core.util.Strings;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLOutput;
import java.util.*;

@SpringBootTest
public class LeetCode50 {

    @Test
    public void printA() {
        System.out.println("test start");
    }

//    https://leetcode.com/problems/reverse-integer/
//    https://mp.weixin.qq.com/s/Qab0M7_Ax8_MZIzYYjhjXw
    @Test
    public void doReverseInteger(){
        System.out.println(reverseInteger(12223333));
        System.out.println(reverseInteger(-12223333));
        System.out.println(reverseInteger((1l << 31)));
    }

    private long reverseInteger(long x) {
        boolean flag = true;
        if(x < 0) {
            flag = false;
            x = -x;
        }
        long ret = 0;
        long bit = 0;
        while (x > 0) {
            bit = x % 10;
            ret = ret * 10 + bit;
            x /= 10;
        }
        if(ret >= 1l << 31 && flag || ret > 1l << 31){
            return 0;
        }
        if(flag){
            return ret;
        }
        return 0-ret;
    }


    @Test
    public void doThreeSum() {
        int[] nums = {1,3,4,-1,-3,-4,-6,8,3,6,9};
        System.out.println(threeSum(nums).toString());
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++){
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            int target = 0 - nums[i];
            while (j < k){
                int sum = nums[j] + nums[k];
                if(sum < target){
                    j = j + 1;
                    continue;
                }
                if(sum > target){
                    k = k - 1;
                    continue;
                }
                List<Integer> item = new ArrayList<>();
                item.add(nums[i]);
                if(nums[k] > nums[j]){
                    item.add(nums[j]);
                    item.add(nums[k]);
                } else {
                    item.add(nums[k]);
                    item.add(nums[j]);
                }
                list.add(item);

                j += 1;
                while (j < k && nums[j] == nums[j-1]){
                    j++;
                }

                k -= 1;
                while (j < k && nums[k] == nums[k+1]){
                    k--;
                }
            }
        }
        return list;
    }

    @Test
    public void doLengthOfLongestSubstring() {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    private int lengthOfLongestSubstring(String s) {
        if(s == null){
            return 0;
        }
        char[] chars = s.toCharArray();
        int l = 0;
        int r = 0;
        int ret = 0;
        Map<Character, Integer> visited = new HashMap(chars.length);
        for (;r < chars.length; r++){
            if(visited.containsKey(chars[r]) && visited.get(chars[r]) >= l){
                l = visited.get(chars[r]) + 1;
            }
            visited.put(chars[r], r);
            ret = Math.max(ret, r - l + 1);
        }
        return ret;
    }


    @Test
    public void doTwoSum() {
        int[] nums = {2, 7, 11, 15};
        System.out.println(twoSum(nums, 9));
    }

    private int[] twoSum(int[] nums, int target) {
        int[] ret = new int[2];
        Map<Integer,Integer> visited = new HashMap<>();
        for(int i = 0;i < nums.length; i++){
            if(visited.containsKey(target - nums[i])){
                ret[0] = visited.get(target - nums[i]);
                ret[1] = i;
                return ret;
            }
            visited.put(nums[i], i);
        }
        return ret;
    }

    class Node {
        int value;
        Node next;
        private Node(int value){
            this.value = value;
        }
    }

    @Test
    public void twoSum2(){
        Node head1 = new Node(2);
        head1.next = new Node(4);
        head1.next.next = new Node(3);

        Node head2 = new Node(5);
        head2.next = new Node(6);
        head2.next.next = new Node(4);

        Node result = null;

        Node l1 = head1;
        Node l2 = head2;
        boolean exceed = false;
        while (l1 != null && l2 != null){
            int ret = l1.value + l2.value;
            if (exceed) ret++;
            if (ret > 9) {
                ret -= 10;
                exceed = true;
            }else {
                exceed = false;
            }
            System.out.println(ret);
            if(result == null){
                result = new Node(ret);
            }else {
                result.next = new Node(ret);
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        if(l1 == null){
            l1 = l2;
        }
        while (l1 != null){
            int ret = l1.value;
            if (exceed) ret++;
            if (ret > 9) {
                ret -= 10;
                exceed = true;
            }else {
                exceed = false;
            }
            System.out.println(ret);
            if(result == null){
                result = new Node(ret);
            }else {
                result.next = new Node(ret);
            }
            l1 = l1.next;
        }
    }

    @Test
    public void doMatch(){
        System.out.println(isMatch("aab","c*a*b"));
    }

    public boolean isMatch(String s, String p) {
        char[] chars = s.toCharArray();
        char[] charp = p.toCharArray();
        return matching(chars,charp,0,0);
    }

    private boolean matching(char[] s, char[] p, int i,int j) {
        if(i >= s.length && j >= p.length){
            return true;
        }
        if(i >= s.length && j < p.length){
            return false;
        }
        if(i < s.length && j >= p.length){
            return false;
        }
        // 当前位置是否匹配
        boolean flag = s[i] == p[j] || p[j] == '.';
        // 判断p[j+1]是否是*，如果是那么说明p[j]可以跳过匹配
        if (j+1 < p.length && p[j+1] == '*'){
            // 两种情况，一种是跳过p[j]，另一种是p[j]继续匹配
            return matching(s, p, i, j+2) || (flag && matching(s, p, i+1, j));
        } else {
            // 如果没有*，只有一种可能
            return flag && matching(s, p, i+1, j+1);
        }
    }

    /**
     * https://mp.weixin.qq.com/s/67uf7pRxXh7Iwm7MMpqJoA
     * bruteForce
     */
    @Test
    public void bruteForce(){
        String str = "abdcedefg";
        String pattern = "dce";
        System.out.println(bruteForce(str,pattern));
    }

    private boolean bruteForce(String str, String pattern){
        int pLength = pattern.length();
        int sLength = str.length();
        for(int i = 0; i < sLength - pLength + 1; i++) {
            int count = 0;
            String currentStr = str.substring(i,i + pLength);
            for(int j = 0; j < pattern.length(); j++) {
                if(currentStr.charAt(j) == pattern.charAt(j)){
                    count++;
                }
            }
            if(count == pLength){
                return true;
            }
        }
        return false;
    }


    /**
     * rabinKarp
     * https://mp.weixin.qq.com/s/67uf7pRxXh7Iwm7MMpqJoA
     */
    @Test
    public void rabinKarp(){
        String str = "aacdesadsdfer";
        String pattern = "adsd";
        System.out.println("第一次出现的位置：" + rabinKarp(str, pattern));
    }

    private int rabinKarp(String str, String pattern){
        int pLength = pattern.length();
        int sLength = str.length();
        int pHash = hash(pattern);
        int sHash = hash(str.substring(0, pLength));
        for(int i = 0; i < sLength - pLength + 1; i++) {
            if(sHash == pHash && compareStr(str, i, pattern)){
                return i;
            }
            if(i < sLength - pLength) {
                sHash = nextHash(str, i, sHash, pLength);
            }
        }
        return -1;
    }

    private int nextHash(String str, int i, int sHash, int pLength) {
        sHash -= str.charAt(i) - 'a';
        sHash += str.charAt(i + pLength) - 'a';
        return sHash;
    }

    private boolean compareStr(String str, int i, String pattern) {
        return pattern.equals(str.substring(i , i + pattern.length()));
    }

    private int hash(String pattern) {
        int hashCode = 0;
        for(int i = 0; i < pattern.length(); i++) {
            hashCode += pattern.charAt(i) - 'a';
        }
        return hashCode;
    }

    /**
     * boyerMooore
     *
     * Bob boyer  and JStrother Moore
     * 坏字符，好后缀
     * https://mp.weixin.qq.com/s/2RlyDBo-Ql-1Ofh8tMyikg
     */
    @Test
    public void boyerMooore(){
        String str = "GTTATAGCTGGTAGCGGCGAA";
        String pattern = "GTAGCGGCG";
        System.out.println("第一次出现的位置：" + boyerMooore(str, pattern));
    }

    private int boyerMooore(String str, String pattern) {
        int pLength = pattern.length();
        int sLength = str.length();
        int start = 0;
        while(start <= sLength - pLength) {
            int i;
            for(i = pLength - 1; i >= 0; i++) {
                if(str.charAt(start + i) != pattern.charAt(i)) {
                    break;
                }
            }
            if(i < 0) {
                return start;
            }
            int chartIndex = findPatternSubStr(pattern, i, str.charAt(start + i));
            int offset = chartIndex >= 0 ? i - chartIndex : i + 1;
            start += offset;
        }
        return -1;
    }

    private int findPatternSubStr(String pattern, int index, char badChar) {
        for(int i = index - 1; i >= 0; i--) {
            if(pattern.charAt(i) == badChar) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Knuth-Morris-Pratt
     * https://mp.weixin.qq.com/s/xUixZq8_8J6uivx6t6ViwQ
     */
    @Test
    public void knuthMorrisPratt(){
        String str = "GTTATAGCTGGTAGCGGCGAA";
        String pattern = "GTAGCGGCG";
        System.out.println("第一次出现的位置：" + knuthMorrisPratt(str, pattern));
    }

    private String knuthMorrisPratt(String str, String pattern) {
        return "";
    }


}
