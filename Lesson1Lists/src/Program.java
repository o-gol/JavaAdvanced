import java.util.ArrayList;
import java.util.LinkedList;

public class Program {
    public static void main(String[] args) {
        ArrayList arrayList;
        LinkedList linkedList;

        MyLinkedList myLinkedList=new MyLinkedList();
        //System.out.println(myLinkedList.headNode());
        myLinkedList.add(10);
        //System.out.println(myLinkedList.headNode());
        myLinkedList.add(2);
        //System.out.println(myLinkedList.headNode());
        myLinkedList.add(45);
        myLinkedList.add(56);
        myLinkedList.add(67);
        myLinkedList.add(77);
        myLinkedList.add(45);
        myLinkedList.add(91);
        //System.out.println(myLinkedList.headNode());
        System.out.println(myLinkedList.toString());
        //System.out.println(myLinkedList.headNode());
        myLinkedList.remove(0);
        System.out.println(myLinkedList.toString());
        myLinkedList.remove(0);
        System.out.println(myLinkedList.toString());
        myLinkedList.remove(11);
        System.out.println(myLinkedList.toString());


    }

}
