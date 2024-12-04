/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment2;

/**
 *
 * @author surya
 */
public class BalancedBrackets {
    //=================STACK IMPLEMENTATION FROM Q3=================//
                //print statements such as "stack is full or empty is commented //
                //because that is not the output we seek//
    int[] stack;
    int[] min_stack;
    int top_index;
    int min_top_index;
    
    public BalancedBrackets() {
        stack = new int[10];
        min_stack = new int[10];
        top_index = -1;
        min_top_index = -1;
    }
    
            //creating functions for stack (push , pop , top , getMin)
    
    
        //void push(val) pushes the element val onto the stack//
    public void push(int val){
        if (top_index == stack.length - 1){
            //checking if stack is full with help of top_index
      //  System.out.println("Stack is full");
        return;
    }
        stack[++top_index] = val;
        if(min_top_index == -1 || val <= min_stack[min_top_index]){
            //checks if min stack is empty
            //min_stack is a separate stack that keeps track of the minimum values in the main stack
            min_stack[++min_top_index] = val;
        }
    }
    
        //void pop() removes the element on the top of the stack.
    public void pop() {
        if (top_index == -1) {
            //checks if top index is empty
          //  System.out.println("Stack is empty");
            return;
        }
        if (stack[top_index] == min_stack[min_top_index]) {
            min_top_index--;
        }
        top_index--;
    }
    
        //int peek() returns the element at the top of the stack but does not remove
    public int top() {
    if (top_index == -1) {
       // System.out.println("Stack is empty");
        return -1;
    }
    return stack[top_index];
}

        //int peek() returns the element at the top of the stack but does not remove.
    public int peek() {
        if (top_index == -1) {
         //   System.out.println("Stack is empty");
            return -1;
        }
        return stack[top_index];
    }

        //int getMin() retrieves the minimum element in the stack
    public int getMin() {
    if (top_index == -1) {
        //System.out.println("Stack is empty");
        return -1;
    }
    return min_stack[min_top_index];
}
    
    //================================================================//
    
    
    //Checking if brackets are balance or not//
    public boolean isBalanced(String input) {
        BalancedBrackets stack = new BalancedBrackets();
        for (char c : input.toCharArray()) {
            //Going through input string per char
            if (c == '(' || c == '{' || c == '[') {
                //if opening bracket is encountered it is pushed in stack
                stack.push((int) c);
            } else if (c == ')' || c == '}' || c == ']') {
                //if no matching opening bracket is found return false (-1)
                if (stack.top() == -1) {
                    return false; // Unbalanced, no matching opening bracket
                }
                int top = stack.top();
                if ((c == ')' && top != '(') || (c == '}' && top != '{') || (c == ']' && top != '[')) {
                    //if current closing bracket is not the closing bracket of bracket on top return false
                    return false; // Unbalanced, mismatched brackets
                }
                //if brackets matches (POP)
                stack.pop();
            }
        }
        return stack.top() == -1; // Balanced if stack is empty
    }
    
    public static void main(String[] args) {
        BalancedBrackets checker = new BalancedBrackets();
        System.out.println(checker.isBalanced("{[()]}")); // This should give true
        System.out.println(checker.isBalanced("{[(])}")); // This should give false
        System.out.println(checker.isBalanced("{{[[(())]]}}")); // This should give true
    }
    
    
}
