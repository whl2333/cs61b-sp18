public class ArrayDequeTest {
    public static void main(String[] args)
    {
        ArrayDeque<Integer> array = new ArrayDeque<>();
        array.addLast(0);
        array.addLast(1);
        array.get(0);
        array.get(1);
        array.removeFirst();
        array.PrintDeque();
    }
}
