package com.gottaboy.iching.mybatis.al;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

class MinStack {
    private final static Logger logger = LoggerFactory.getLogger(MinStack.class);

    Deque<Integer> xStack;
    Deque<Integer> minStack;

    public MinStack() {
        xStack = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        xStack.push(x);
        minStack.push(Math.min(minStack.peek(), x));
    }

    public void pop() {
        xStack.pop();
        minStack.pop();
    }

    public int top() {
        return xStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack s = new MinStack();
        s.push(-2);
        s.push(0);
        s.push(-3);
        System.out.println(s.getMin());
        s.pop();
        Queue<Integer> q = new LinkedList();
        System.out.println(s.top());
        System.out.println(s.getMin());
        System.out.println(isValid("{}({})[]"));
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
        System.out.println(evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
//        logger.info("trap: {}", trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        logger.info("trap: {}", trap(new int[]{4,2,0,3,2,5}));
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < tokens.length; i++){
            if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")){
                int num2 = stack.pop();
                int num1 = stack.pop();
                if(tokens[i].equals("+")){
                    stack.push(num1 + num2);
                }
                if(tokens[i].equals("-")){
                    stack.push(num1 - num2);
                }
                if(tokens[i].equals("*")){
                    stack.push(num1 * num2);
                }
                if(tokens[i].equals("/")){
                    stack.push(num1 / num2);
                }
            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }

    public static int trap(int[] height) {
        int ans = 0, current = 0;
        Deque<Integer> stack = new LinkedList<>();
        while (current < height.length) {
            while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty())
                    break;
                int distance = current - stack.peek() - 1;
                int bounded_height = Math.min(height[current], height[stack.peek()]) - height[top];
                ans += distance * bounded_height;
            }
            stack.push(current++);
        }
        return ans;
    }

    public int trap2(int[] height) {
        int ans = 0;
        int size = height.length;
        for (int i = 1; i < size - 1; i++) {
            int max_left = 0, max_right = 0;
            for (int j = i; j >= 0; j--) { //Search the left part for max bar size
                max_left = Math.max(max_left, height[j]);
            }
            for (int j = i; j < size; j++) { //Search the right part for max bar size
                max_right = Math.max(max_right, height[j]);
            }
            ans += Math.min(max_left, max_right) - height[i];
        }
        return ans;
    }

    public static int trap1(int[] height) {
        int length = height.length;
        int[] ans = new int[length];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            int temperature = height[i];
            while (!stack.isEmpty() && temperature > height[stack.peek()]) {
                int prevIndex = stack.pop();
                ans[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        int sum = 0;
        for(int i = 0; i < ans.length; i++){
            if(ans[i] > 0){
                int temp = height[i] * (ans[i] - 1);
                for(int j = i+1; j < i + ans[i];j++){
                    temp -= height[j];
                }
                sum += temp;
            }
        }
        return sum;
    }

    public static int[] dailyTemperatures(int[] T) {
        int length = T.length;
        int[] ans = new int[length];
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < length; i++) {
            int temperature = T[i];
            while (!stack.isEmpty() && temperature > T[stack.peek()]) {
                int prevIndex = stack.pop();
                ans[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return ans;
    }

    private static void dailyTemperatures1(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(int i = arr.length-2; i >= 0; i--){
            int temp = arr[i];
            int count = 0;
            int flag = 0;
            int j = i+1;
            for(; j < arr.length; j++){
                if(temp < arr[j]){
                    flag = 1;
                    count++;
                    break;
                }
                count++;
            }
            if(j == arr.length && flag == 0){
                stack.push(0);
            }else {
                stack.push(count);
            }
        }
//        while (!stack.empty()){
//            stack.pop();
//            System.out.println(stack.pop());
//        }
        for(int i = 0; i < arr.length; i++){
            arr[i] = stack.pop();
        }
    }

    public static boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < chars.length; i++){
            if(chars[i] == '{' || chars[i] == '(' || chars[i] == '['){
                stack.push(chars[i]);
            }
            if(chars[i] == '}' || chars[i] == ')' || chars[i] == ']'){
                if(stack.empty()){
                   return false;
                }
                char ch = stack.peek();
                boolean isFlag = false;
                if(chars[i] == '}' && ch == '{'){
                    isFlag = true;
                }
                if(chars[i] == ')' && ch == '('){
                    isFlag = true;
                }
                if(chars[i] == ']' && ch == '['){
                    isFlag = true;
                }
                if(!isFlag){
                    break;
                }else {
                    stack.pop();
                }
            }
        }
        return stack.size() > 0 ? false : true;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */