import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void delete(int data) {
        if (head == null) {
            return;
        }

        if (head.data == data) {
            head = head.next;
        } else {
            Node current = head;
            Node prev = null;
            while (current != null && current.data != data) {
                prev = current;
                current = current.next;
            }
            if (current != null) {
                prev.next = current.next;
            }
        }
    }

    public void update(int oldData, int newData) {
        Node current = head;
        while (current != null) {
            if (current.data == oldData) {
                current.data = newData;
                break;
            }
            current = current.next;
        }
    }

    public boolean search(int data) {
        Node current = head;
        while (current != null) {
            if (current.data == data) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
}

 class LinkedOperation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList list = new LinkedList();

        char choice;
        do {
            System.out.println("\nEnter your choice:");
            System.out.println("1. Insert an element");
            System.out.println("2. Display the linked list");
            System.out.println("3. Delete an element");
            System.out.println("4. Update an element");
            System.out.println("5. Search for an element");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Enter the element to insert:");
                    int element = scanner.nextInt();
                    list.insert(element);
                    break;
                case 2:
                    System.out.println("Linked List:");
                    list.display();
                    break;
                case 3:
                    System.out.println("Enter the element to delete:");
                    int deleteElement = scanner.nextInt();
                    list.delete(deleteElement);
                    break;
                case 4:
                    System.out.println("Enter the element to update:");
                    int oldData = scanner.nextInt();
                    System.out.println("Enter the new value:");
                    int newData = scanner.nextInt();
                    list.update(oldData, newData);
                    break;
                case 5:
                    System.out.println("Enter the element to search:");
                    int searchData = scanner.nextInt();
                    if (list.search(searchData)) {
                        System.out.println(searchData + " found in the linked list.");
                    } else {
                        System.out.println(searchData + " not found in the linked list.");
                    }
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

            System.out.println("\nDo you want to continue? (y/n)");
            choice = scanner.next().charAt(0);
        } while (choice == 'y' || choice == 'Y');

        scanner.close();
    }
}

