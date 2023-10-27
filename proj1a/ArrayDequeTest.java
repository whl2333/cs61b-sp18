public class ArrayDequeTest {
    public static void main(String[] args)
    {
        ArrayDeque<Integer> array = new ArrayDeque<>();
        System.out.println(array.nextfirst);
        System.out.println(array.nextlast);
        for(int i=0;i<10;i++)
        {
            array.addLast(i);
        }
        System.out.println(array.nextfirst);
        System.out.println(array.nextlast);
        array.PrintDeque();
    }
}
