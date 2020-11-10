import java.util.Stack;

public class Program {
    public static void main(String[] args) {
        Stack<Integer> stack=new Stack<>();
        stack.add(2);
        stack.add(8);
        stack.add(3);
        stack.add(98);

        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        Integer inti=stack.peek();
        inti--;
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack);
    }
}
