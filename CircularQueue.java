import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.File;
import java.util.Scanner;

/**
 * Created by kevin on 2/24/2018.
 */
public class CircularQueue {
    private QueueNode head;
    private QueueNode tail;
    private int size;

    public CircularQueue() {
        head = null;
        size = 0;
    }


    public void del() {
        if(head == null) {
            return;
        }
        head = head.next;

        size--;
    }


    public void in(int data) {
        if(head == null) {
            head = new QueueNode(null, data);
            tail = head;
        }
        else {
            QueueNode currentNode = head;
            while(currentNode != tail) {
                currentNode = currentNode.next;
            }
            QueueNode newNode = new QueueNode(null, data);
            currentNode.next = newNode;
            tail = newNode;
        }
        size++;
    }


  
    public void print() {
        QueueNode currentNode = head;
        while(currentNode != tail) {
            System.out.print(currentNode.Data() + " ");
            currentNode = currentNode.next;
        }
        System.out.print(tail.Data() + " ");
        System.out.println();
    }
    public int size() {
        //returns number of links
        return size;
    }


    public String[] readFile(String inFile) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inFile));

            String line = null;
            String[] val = null;
            while ((line = reader.readLine()) != null) {
                val = line.split(" ");
            }
            reader.close();
            return val;
        }
        catch(java.io.IOException e) {
            System.out.println("Either the file was not found, or something went wrong. Please try again.");
            System.exit(0);
        }
        return null;
    }
    public void execute(String[] target) {

        CircularQueue circ = new CircularQueue();
        int key;

        System.out.println("\nInput read from file: ");
        for(int i = 0; i < target.length; i ++) {
            System.out.print(target[i] + " ");
        }
        System.out.println("\n");
        try {
            //maximum size of queue specified by user
            int maxSize = Integer.parseInt(target[0]);


            for (int i = 1; i < target.length; i++) {

                //System.out.println(target[i])
                if (target[i].endsWith(".in")) {

                    try {
                        //regex deletes nondigits
                        key = Integer.parseInt(target[i].replaceAll("\\D+", ""));
                        if (circ.size() >= maxSize) {

                            System.out.println("\nCommand '" + target[i] + "' rejected. Reason: OVERFLOW. Size of (" + maxSize + ") exceeded. Please remove some items.");

                        } else {
                            System.out.print("\nCommand '" + target[i] + "' successful. \nQueue before operation: ");
                            if(circ.size() > 0) {
                                circ.print();
                            }
                            else {
                                System.out.println("The queue is empty!");
                            }
                            circ.in(key);
                            System.out.print("Queue after operation: ");
                            circ.print();

                        }
                    }
                    catch(NumberFormatException e) {
                        System.out.println("FATAL ERROR: You can only push integers into the queue. The command '" + target[i] + "' is not a valid command. Please modify your input file and try again.");
                        System.exit(0);
                    }

                } else if (target[i].contains("del")) {
                    if (circ.size() > 0) {
                        System.out.print("\nCommand '" + target[i] + "' successful. \nQueue before operation: ");
                        if(circ.size() > 0) {
                            circ.print();
                        }
                        else {
                            System.out.println("The queue is empty!");
                        }
                        circ.del();
                        System.out.print("Queue after operation: ");
                        if (circ.size() > 0) {
                            circ.print();
                        } else {
                            System.out.println("The queue is empty!");
                        }

                    } else {

                        System.out.println("\nCommand '" + target[i] + "' rejected. Reason: You can't delete if you have nothing in the queue!");
                    }
                } else {

                    System.out.println("\nCommand '" + target[i] + "' rejected. Reason: \nNot a valid command.");
                }
            }

            System.out.println("\nEnd of command list. Your queue: ");
            if (circ.size() > 0) {
                circ.print();
            } else {
                System.out.println("The queue is empty!");
            }
        }
        catch(NumberFormatException e) {
            System.out.println("FATAL ERROR: The first entry in the file must be a number that specifies the size of your queue. Please modify your input file and try again.");
        }



    }
    public static void main(String[] args) {

        CircularQueue run = new CircularQueue();

        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter a file name.");
        String userIn = scan.nextLine();

        run.execute(run.readFile(userIn));


    }
}
