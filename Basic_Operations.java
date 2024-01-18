public class LL {
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

    //methods
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

    public void add(int idx, int data){
        if(idx==0){
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;

        
        while(i < idx-1){
            temp = temp.next;
            i++;
        }

        // i = idx-1; temp = prev
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public static int removeFirst(){
        if(size==0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }else if(size==1){
            int val = head.data;
            head = tail = null;
            size=0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public static int removeLast(){
        if(size==0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }else if(size==1){
            int val = head.data;
            head = tail = null;
            size=0;
            return val;
        }
        int i=0;
        //prev : i = size-2;
        Node prev = head;
        while(i<size-2){
            prev = prev.next;
            i++;
        }

        int val = prev.next.data;
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    public static int linearSearch(int key){
        Node temp = head;
        int i =  0;
        while(temp!=null){
            if(temp.data==key){
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }

    public  int helper(Node head, int key){  //O(n)
        if(head==null){
            return -1;
        }

        if(head.data==key){
            return 0;
        }

        int idx = helper(head.next,key);
        if(idx==-1){
            return -1;
        }
        
        return idx+1;
    }
    public int recSearch(int key){
        return helper(head,key);

        // return -1;
    }

    public static void reverse(){  //O(n)
        Node prev  = null;
        Node curr = tail= head;
        Node next;

        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;
    } 

    public void deleteNthfromEnd(int n){
        //calculate size of ll
        int sz = 0;
        Node temp = head;
        while(temp!=null){
            temp = temp.next;
            sz++;
        }

        if(n==sz){
            head = head.next;  //remove first
            return;
        }

        //sz - n
        int i = 1;
        int iToFind = sz-n;
        Node prev = head;
        while(i<iToFind){
            prev = prev.next;
            i++;
        }

        prev.next = prev.next.next;
        return;
    }

    //Slow-fast Approach
    public Node findMid(Node head){ //helper fn for palindrome
        Node slow = head;
        Node fast = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next; //+1
            fast = fast.next.next;  //+2
        }
        return slow; // slow is my midNode
    }

    //to check palindrome
    public boolean checkPalindrome(){
        if(head==null || head.next==null){ // base case
            return true;
        }
        //step1 - find mid node
        Node midNode = findMid(head);

        //step2 - reverse 2nd half
        Node prev = null;
        Node curr = midNode;
        Node next;

        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node right = prev; // right-half ka head
        Node left = head;

        //step3 - check if left half == right half
        while(right != null){
            if(left.data != right.data){
                return false;
            }
            left  = left.next;
            right = right.next;
        }

        return true;
    }

    public static boolean detectCycle(){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow==fast){ // cycle detects
                return true;
            }
        }

        return false;
    }

    public static void removeCycle(){
        //detect cycle
        Node slow=head;
        Node fast=head;
        boolean cycle = false;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                cycle = true;
                break;
            }
        }
        if(cycle==false){
            return;
        }
        
        //find meeting point
        slow = head;
        Node prev = null;
        while(slow != fast){
            prev = fast;
            slow = slow.next;
            fast = fast.next.next;
        }
        //remove cycle,i.e., last node.next=null
        prev.next=null;
    }

    public static void main(String args[]){
        head = new Node(1);
        Node temp = new Node(2);
        head.next = temp;
        head.next.next = new Node(3);
        head.next.next.next = temp;
        //1->2->3->2

        System.out.println(detectCycle());
        removeCycle();
        System.out.println(detectCycle());

    }
}

