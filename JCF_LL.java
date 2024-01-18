import java.util.LinkedList;
public class LL_framework {
    public static void main(String args[]){
       //create
        LinkedList<Integer> ll = new LinkedList<>();

        //add
        ll.add(1);
        ll.addFirst(0);
        ll.addLast(2);
        //0->1->2

        //print
        System.out.println(ll);
        

        //remove
        ll.removeFirst();
        ll.removeLast();
        System.out.println(ll);
    }
}
