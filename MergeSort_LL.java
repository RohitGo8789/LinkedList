public class MergeSort {
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

    public void addFirst(int data){  // O(1)
        //step 1- create a new node
        Node newNode =  new Node(data);
        size++;

        if(head==null){
            head = tail = newNode;
        }

        //step 2 - newNode next = head
        newNode.next = head; //link

        //step 3 - head = newNode
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

    public void printLL(){  //O(n)
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

    private Node getMid(Node head){
        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow; //mid node
    }

    private Node merge(Node head1, Node head2){
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;

        while(head1 != null && head2 != null){
            if(head1.data <= head2.data){
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }else{
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }

        while(head1 != null){
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }

        while(head2 != null){
             temp.next = head2;
             head2 = head2.next;
             temp = temp.next;
        }

        return mergedLL.next;
    }

    public Node mergeSort(Node head){
        if(head == null || head.next == null){
            return head;
        }

        //find mid
        Node mid = getMid(head);

        //left and right MS
        Node rightHead = mid.next;
        mid.next = null;
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        //merge
        return merge(newLeft, newRight);
    }



    
    public static void main(String args[]){
        MergeSort ll = new MergeSort();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.addFirst(5);
        ll.addLast(8);
        //5->4->3->2->1
        ll.printLL();

        ll.head = ll.mergeSort(ll.head);

        ll.printLL();
    }
}
