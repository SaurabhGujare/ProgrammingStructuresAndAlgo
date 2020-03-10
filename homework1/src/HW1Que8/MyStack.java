/*
 * a)  Create file “input.txt” with this data
 * b)  Read input.data into an an ArrayList.
 * c)  Create myStack with LinkedList implementation
 * d)  Write Node data structure of your input data
 * e)  myStack must support all Stack operations of stack
 * f) Write a Test program to test your linked implementation of myStack:
    —push 3 elements into stack
    —pop 3 element into stack
    —push all elements into stack
    —pop all element into stack
    —push all elements into stack
    —print stack with the goal:
         i) reverse order ii) original order as first read into array list
 * g) Compile and Run your program
 * h) what is Stack LinkedList time-complexity?
 * Time Complexity: O(N) = 1
 * Saurabh Gujare
 * NUID. 001424874
 * */
package HW1Que8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.exit;

public class MyStack {

    private Node first = null;

    private class Node{
        String id;
        String firstName;
        String lastName;
        String course;
        Node next;
    }

    MyStack(){
        this.first = null;
    }

    public boolean isEmpty() { return first == null; }

    public void push(String item){
        Node oldFirst = first;
        first = new Node();
        String[] splited = item.split("\\s+");
        first.id = splited[0];
        first.firstName = splited[1];
        first.lastName = splited[2];
        first.course = "";
        for(int i=3;i<splited.length;i++)
            first.course += splited[i]+" ";
        first.next = oldFirst;
    }

    public String pop(){
        String item = first.id+"  "+first.firstName+" "+first.lastName+" "+first.course;
        first = first.next;
        return item;
    }

    public String peek(){
        if (!isEmpty()) {
            return first.id+"  "+first.firstName+" "+first.lastName+" "+first.course;
        }
        else {
            System.out.println("Stack is empty");
            return "Stack is empty";
        }
    }

    public void display()
    {
        // check for stack underflow
        if (first == null) {
            System.out.printf("\nStack is Empty");
            //exit(1);
            return;
        }
        else {
            Node oldFirst = first;
            System.out.println("\nDisplay Stack: \n");
            while (oldFirst != null) {

                // print node data
                System.out.println("   "+ oldFirst.id+"  "+oldFirst.firstName+" "+oldFirst.lastName+" "+oldFirst.course+"  ");
                System.out.println("| ------------------------------------------  |");

                // assign temp link to temp
                oldFirst = oldFirst.next;
            }
        }
    }

    public static ArrayList<String> getInputFileData(String filePath) throws FileNotFoundException {
        /* Get data from input.txt and store in an ArrayList*/
        Scanner s = new Scanner(new File(filePath)).useDelimiter("\n");
        ArrayList<String> list = new ArrayList<String>();
        while (s.hasNext()){
            list.add(s.next());
        }
        String[] splited = list.get(1).split("\\s+");
        s.close();
        return list;

    }

    public void printReverseStack(){
        // check for stack underflow
        if (first == null) {
            System.out.printf("\nStack is Empty");
            //exit(1);
            return;
        }
        else {

            MyStack myReveseStack  = new MyStack();
            while(!this.isEmpty()){
                myReveseStack.push(this.pop());
            }

            myReveseStack.display();
        }

    }

    public static void main(String[] args) {

        String filePath = "input.txt";
        try {
            ArrayList<String> studentList = getInputFileData(filePath);
            MyStack mystack = new MyStack();
            System.out.println(studentList);

            //push 3 element into stack
            System.out.println("\n\n# Push 3 elements into stack");
            mystack.push(studentList.get(1));
            mystack.push(studentList.get(2));
            mystack.push(studentList.get(3));
            mystack.display();

            //pop 3 element into stack
            System.out.println("\n\n# Pop 3 elements from stack");
            mystack.pop();
            mystack.pop();
            mystack.pop();
            mystack.display();

            //push all elements into stack
            System.out.println("\n\n# Push all elements into stack");
            for(int i=1;i<studentList.size();i++){
                mystack.push(studentList.get(i));
            }
            mystack.display();

            //pop all element from stack
            System.out.println("\n\n# Pop all element from stack");
            while(!mystack.isEmpty()) {
                mystack.pop();
            }
            mystack.display();

            //print stack with the goal:

            // i) reverse order
            for(int i=1;i<studentList.size();i++){
                mystack.push(studentList.get(i));
            }
            System.out.println("\n\n# print stack with the goal: i) reverse order");
            mystack.printReverseStack();

            // ii) original order as first read into array list
            for(int i=1;i<studentList.size();i++){
                mystack.push(studentList.get(i));
            }
            System.out.println("\n\n# print stack with the goal: ii) original order as first read into array list");
            mystack.display();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println(filePath+" file not found");
        }

    }

}
