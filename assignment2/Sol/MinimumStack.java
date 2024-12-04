/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment2;
/**
 *
 * @author surya
 */
public class MinimumStack {
    int[] stack;
    int[] min_stack;
    int top_index;
    int min_top_index;
    
    public static void main(String[] args) {
        MinimumStack stack = new MinimumStack();

        // Push elements onto the stack
        stack.push(5);
        stack.push(10);
        stack.push(3);
        stack.push(8);
        stack.push(6);

        //getting minimum element
        System.out.println("Minimum element: " + stack.getMin());
        //getting element on top
        System.out.println("Top element: " + stack.peek());
        //popping 2 elements
        stack.pop();
        stack.pop();
        //printing min element after pop
        System.out.println("Minimum element after popping: " + stack.getMin());
        //top element after pop
        System.out.println("Top element after popping: " + stack.peek());
    }

    public MinimumStack() {
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
        System.out.println("Stack is full");
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
            System.out.println("Stack is empty");
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
        System.out.println("Stack is empty");
        return -1;
    }
    return stack[top_index];
}

        //int peek() returns the element at the top of the stack but does not remove.
    public int peek() {
        if (top_index == -1) {
            System.out.println("Stack is empty");
            return -1;
        }
        return stack[top_index];
    }

        //int getMin() retrieves the minimum element in the stack
    public int getMin() {
    if (top_index == -1) {
        System.out.println("Stack is empty");
        return -1;
    }
    return min_stack[min_top_index];
}
}

