public class DoublyLL {
    public static class Node{
        int data;
        Node next;
        Node prev;

        public Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        } 
    }

    public static Node head;
    public static Node tail;
    public static int size;

    //addFirst
    public void addFirst(int data){
        //create a new node
        Node newNode = new Node(data);
        size++;

        if(head==null){
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    //add last
    public void addLast(int data){
        //create a new node
        Node newNode = new Node(data);
        size++;

        if(head==null){
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;

        tail = newNode;

    }

    //print
    public void print(){
        // if(head==null){
        //     System.out.println("LL is empty");
        // }

        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+"<->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    //remove first
    public static int removeFirst(){
        if(head==null){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }

        if(size==1){
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        int val = head.data;
        head = head.next;
        head.prev = null;
        size--;
        return val;
    }

    //remove last
    public static int removeLast(){
        if(head==null){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }

        if(size==1){
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        int i = 0;
        Node previousNode = head;
        while(i<size-2){
           previousNode = previousNode.next;
           i++; 
        }
        int val = tail.data;
        previousNode.next = null;
        tail.prev = null;
        tail = previousNode;
        size--;
        return val;
    }

    //reverse a dll
    public static void reverseDLL(){
        Node curr = head;
        Node prev = null;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr= next;
        }
        head = prev;
    }
    public static void main(String args[]){
        DoublyLL dll = new DoublyLL();
        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);
        dll.addLast(7);
        dll.print();

        System.out.println("Size:"+dll.size);

        // System.out.println(dll.removeFirst());
        // System.out.println(dll.removeLast());
        // dll.print();
        // System.out.println("Size: "+dll.size);

        dll.reverseDLL();
        dll.print();
    }
}
