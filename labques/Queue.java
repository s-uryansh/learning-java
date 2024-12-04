//QUEUE DONE USING ARRAYS

package labques;
import java.util.Scanner;

/**
 *
 * @author surya
 */
public class Queue {
    int[] queue;
    int front, rear, size;
    int capacity;

    public Queue(int capacity) {
        //"this" is used here for current object within constructor
        this.capacity = capacity;
        this.queue = new int[capacity];
        this.front = this.rear = -1;
        this.size = 0;
    }

    //To add/push element in queue (checks if queue is full if yes return the queue full statement else contiunes with adding part
    public void push(int element) {
        if (isFull()) {
            System.out.println("\nQueue is full. Cannot insert element.\n");
            return;
        }
        if (isEmpty()) {
            front = rear = 0;  //front is index for the first element in queue
        } else {
            rear = (rear + 1) % capacity;//Rear is an index for the last element inserted into the queue
        }
        queue[rear] = element;
        size++;
    }

    //To del/pop element from queue
    public int pop() {
        if (isEmpty()) {
            System.out.println("\nQueue is empty. Cannot delete element.\n");
            return -1;
        }
        int element = queue[front];
        if (front == rear) {
            front = rear = -1;
        } else {
            front = (front + 1) % capacity;
        }
        size--;
        return element;
    }

    //Displaying elements in queue
    public void print() {
        if (isEmpty()) {
            System.out.println("\nQueue is empty.\n");
            return;
        }
        int temp = front;
        for (int i = 0; i < size; i++) {
            System.out.print(queue[temp] + " ");
            temp = (temp + 1) % capacity;
        }
        System.out.println();
    }

    //Helper funcs to check for full or empty
    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //Main function
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter the queue size: ");
        int capacity = scanner.nextInt();
        Queue queue = new Queue(capacity);

        //Created kind of UI 
        while (true) {
            System.out.println("1 Insert element");
            System.out.println("2 Delete element");
            System.out.println("3 Display queue");
            System.out.println("4 Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            //checking choice and performing assigned function
            switch (choice) {
                case 1:
                    System.out.print("Enter the element to insert: ");
                    int element = scanner.nextInt();
                    queue.push(element);
                    break;
                case 2:
                    int deletedElement = queue.pop();
                    if (deletedElement != -1) {
                        System.out.println("\nDeleted element: " + deletedElement + "\n");
                    }
                    break;
                case 3:
                    queue.print();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("\nInvalid choice. Please try again.\n");
            }
        }
    }
}

