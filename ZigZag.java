// import java.util.LinkedList;
public class ZigZag {
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        } 
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data){
        Node newNode = new Node(data);
        size++;

        if(head==null){
            head = tail = newNode;
        }

        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data){  //O(1)
        //step 1- create a node
        Node newNode = new Node(data);
        size++;

        if(head==null){
            head=tail=newNode;
            return;
        }

        //step 2- tail next= newNode
        tail.next = newNode;

        //step 3- tail = newNode
        tail = newNode;


    }

    public void printLL(){
        if(head==null){
            System.out.println("LL is empty");
            return;
        }

        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }

        System.out.println("null");
    }

    public void zigZag(){
        //find mid
        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        Node mid=slow;

        //reverse 2nd half
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr=next;
        }
        Node LH = head;
        Node RH = prev;

        //alternate merging
        Node nextL;
        Node nextR;

        while(LH !=null && RH != null){
            nextL = LH.next;
            LH.next = RH;
            nextR = RH.next;
            RH.next = nextL;

            RH = nextR;
            LH = nextL;
        }
    }
    public static void main(String args[]){
        ZigZag ll = new ZigZag();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.printLL();

        ll.zigZag();

        ll.printLL();

    }
}
