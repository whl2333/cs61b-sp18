public class ArrayDequeTest {
    public static void main(String[] args)
    {
        ArrayDeque<Integer> array = new ArrayDeque<>();
        for (int i=0;i<8;i++)
        {
            array.addFirst(i);
        }
        System.out.println(array.get(0));
//        array.removeLast();
        array.printDeque();
    }
}
