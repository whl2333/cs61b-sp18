public class ArrayDequeTest {
    public static void main(String[] args)
    {
        ArrayDeque<Integer> array = new ArrayDeque<>();
//        for (int i=1;i<=10;i++)
//        {
//            array.addFirst(i);
//        }
        array.addLast(0);
        array.removeLast();
//
//        array.removeLast();
        array.printDeque();
    }
}
