public class ArrayDequeTest {
    public static void main(String[] args)
    {
        ArrayDeque<Integer> array = new ArrayDeque<>();
        for (int i=0;i<8;i++)
        {
            array.addLast(i);
        }
        int res1 = array.removeFirst();
        int res2 = array.removeLast();
        System.out.println(res1);
        System.out.println(res2);
        System.out.println(array.get(0));
//        array.removeLast();
        array.printDeque();

//        LinkedListDeque<Integer> deque = new LinkedListDeque<>();
//        System.out.println(deque.getRecursive(0));
//        System.out.println(deque.getRecursive(3));
//        System.out.println(deque.getRecursive(5));
//        deque.printDeque();
    }
}
