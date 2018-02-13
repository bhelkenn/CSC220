import java.util.Scanner;
public class HW3 {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        for (int i = 0; i < 5; i++) {
        	list.add();
        }
        list.print();
        
        //add TA
        String name = "Alvin";
        String relation = "TA";
        int household = 1;
        list.addCustom(name, relation, household);
        
        //confirm he's there
        list.print();
        
        //remove TA
        list.remove("Alvin");
        
        //confirm he's gone
        list.print();
    }
    public static class Node {
        public String name;
        public String relation;
        public int household;
        public Node next;
        
        public Node() {
            name = "";
            relation = "";
            household = 0;
            next = null;
        }
        public Node(String name, String relation, int household) {
            this.name = name;
            this.relation = relation;
            this.household = household;
        }
    }
    
    public static class LinkedList {
        private Node head;
        private int listCount;
        
        //creating a new LinkedList
        public LinkedList() {
            head = new Node();
            listCount = 0;
        }
        //adding a new, custom person to the beginning of the list
        public void add() {
            System.out.println("Add a new person:");
            Scanner read = new Scanner(System.in);
            
            //collect data
        	System.out.print("Name: ");
        	String name = read.next();
            System.out.print("Relation: ");
        	String relation = read.next();
            System.out.print("Household: ");
        	int household = read.nextInt();
        	
            //create node and populate
            Node person = new Node(name, relation, household);
            
            //set new Node's pointer to take over for header
            person.next = head.next;
            //adjust header to become the front of the list again
            head.next = person;
            
            //increment list size
            listCount++;
        }
        //adding a prebuilt person to the beginning of the list
        public void addCustom(String name, String relation, int household) {
            //create node and populate
            Node person = new Node(name, relation, household);
            
            //set new Node's pointer to take over for header
            person.next = head.next;
            //adjust header to become the front of the list again
            head.next = person;
            
            //increment list size
            listCount++;
        }
        
        //deleting a person from the list
        public boolean remove(String name) {
            if (listCount == 0) {
                System.out.println("There is nothing to remove.");
                return false;
            }
            else if (listCount == 1) {
                if (head.next.name.equals(name)) {
                    head = head.next;
                    return true;
                }
                else {
                    System.out.println(name + " is not present.");
                    return false;
                }
            }
            else {
                Node current = head.next;
                Node prev = head;
                
                while (current != null) {
                    if (current.name.equals(name)) {
                        prev.next = current.next;
                        current.next = null;
                        return true;
                    }
                    else
                    	current = current.next;
                }
                //if after iterating through the list the name isn't found:
                System.out.println(name + " is not present.");
                return false;
            }
        }
        
        //searching to see if a given person is in the list
        public boolean isInList(String name) {
            if (listCount == 0) {
                System.out.println("There is nothing in this list.");
                return false;
            }
            else {
                Node current = head;
                while (current != null) {
                    if (current.name.equals(name))
                        return true;
                    else
                    	current = current.next;
                }
                //if after iterating through the list the name isn't found:
                System.out.println(name + " is not present.");
                return false;
            }
        }
        
        //printing the entire list of people
        public void print() {
            if (listCount == 0) {
                System.out.println("There is nothing in this list.");
            }
            else {
                Node current = head.next;
                while (current != null) {
                    System.out.println("Name: " + current.name);
                    System.out.println("Relation: " + current.relation);
                    System.out.println("Household size: " + current.household);
                    System.out.println();
                    current = current.next;
                }
            }
        }
        
        //computing the total number of gifts to buy
        public int gifts() {
            if (listCount == 0) {
                System.out.println("There is nothing in this list.");
                return 0;
            }
            else {
                Node current = head.next;
                int count = 0;
                while (current != null) {
                    count += current.household;
                    current = current.next;
                }
                return count;
            }
        }
    }
}