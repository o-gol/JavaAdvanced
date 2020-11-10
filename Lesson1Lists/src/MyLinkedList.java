import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;

public class MyLinkedList {
    private  Node head;
    private  int size;

    public String headNode(){
        if(head==null){
            return "null";
        }
        return head.getValue().toString();
    }



    public static class Node{
        private Object value;
        private Node nextNode;

        public Node() {
        }

        public Node(Object value) {
            this.value = value;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public Node getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }


    }







    void remove(int num){
        Node temp=head;
        if (num==0){head=temp.getNextNode();size--;return;}
        //try {

        if (head!=null&&num<size){
            for (int i = 0; i < num-1; i++) {
                temp=temp.getNextNode();
            }
            temp.setNextNode(temp.getNextNode().getNextNode());
        this.size--;
        }else {
            throw new NullPointerException(){

            };
        }
//        }catch (Exception massage){
//            System.out.println(massage);
//        }

    }

//void remove(int num){
//        int corentIndex=0;
//        Node temp=head;
//        while (temp!=null){
//            if((corentIndex+1)==num){
//                temp.setNextNode(temp.nextNode.nextNode);
//                size--;
//                return;
//            }else {
//                temp=temp.getNextNode();
//                corentIndex++;
//            }
//        }
//
//
//
//
//
//    }
//

    void add(Object value ){
        if(head==null){
            //head=new Node(value);
            head=new Node();
            System.out.println(head.getValue());
            head.setValue(value);
            System.out.println(head.getValue());
        }else{
            Node temp=head;
            while(temp.nextNode!=null){
                temp=temp.nextNode;
            }
            //temp.nextNode=new Node(value);
            temp.nextNode=new Node();
            temp.nextNode.setValue(value);
//            temp.value=value;
        }
        size++;
    }

    @Override
    public String toString() {
        //int sizeTemp=0;

        Object[] object= new Object[size];
        if(head!=null){
            Node temp=head;
            //System.out.println(head.getValue());
            for (int i = 0; i <size ; i++) {
                object[i]=temp.getValue();
                temp=temp.nextNode;
            }
//            while(head.getValue()!=null){
//                object[sizeTemp]= head.getValue();
//                sizeTemp++;
//            }
        }
        return Arrays.toString(object);


    }
}
