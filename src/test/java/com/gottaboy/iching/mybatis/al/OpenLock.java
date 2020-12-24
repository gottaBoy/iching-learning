package com.gottaboy.iching.mybatis.al;

import java.util.*;

public class OpenLock {
    public static void main(String[] args) {
//        System.out.println(openLock(new String[]{"0201","0101","0102","1212","2002"},"0202"));
        System.out.println(openLock(new String[]{"8888"},"0009"));
    }
    public static int openLock(String[] deadends, String target) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Set<String> deaded = new HashSet<>();
        for(String item : deadends){
            deaded.add(item);
        }
        int count = 0;
        queue.offer("0000");
        visited.add("0000");
        while (!queue.isEmpty()){
            int len = queue.size();
            //遍历队列中的密码值
            for (int i = 0; i < len; i++) {
                String item = queue.poll();
                if(deaded.contains(item)){
                    continue;
                }
                if(item.equals(target)){
                    return count;
                }
                // 对四个锁分别进行一次左旋或者右旋，得到新的状态
                for (int j = 0; j < 4; j++) {
                    // 左旋产生新状态
                    String left = leftRotate(item, j);
                    if (!visited.contains(left)) {
                        // 不是加入q1或q2，而是加入temp
                        queue.offer(left);
                        visited.add(left);
                    }
                    // 右旋产生新状态
                    String right = rightRotate(item, j);
                    if (!visited.contains(right)) {
                        queue.offer(right);
                        visited.add(right);
                    }
                }
            }
            count++;
        }
        return -1;
    }

    /**
     * str是一个长度为4的字符串，每一个位置代表一个锁当前对准的字符，
     * 对指定的那个锁左旋一下，得到一个新的状态
     * @param str
     * @param idx
     * @return
     */
    private static String leftRotate(String str, int idx) {
        char[] arr = str.toCharArray();
        // 1->2  2->3  9->0
        if (arr[idx] == '9')
            arr[idx] = '0';
        else arr[idx] += 1;
        return new String(arr);
    }

    /**
     * str是一个长度为4的字符串，每一个位置代表一个锁当前对准的字符，
     * 对指定的那个锁右旋一下，得到一个新的状态
     * @param str
     * @param idx
     * @return
     */
    private static String rightRotate(String str, int idx) {
        char[] arr = str.toCharArray();
        // 2->1  3->2  0->9
        if (arr[idx] == '0')
            arr[idx] = '9';
        else arr[idx] -= 1;
        return new String(arr);
    }
}
