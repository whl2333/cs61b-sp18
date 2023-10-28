import javax.swing.*;

public class ArrayDeque<T>{
    private T[] deque;
    private int size;
    private int nextfirst;
    private int nextlast;
    private int MAXLEN=8;
    
    public ArrayDeque()
    {
        deque = (T[])new Object[MAXLEN];
        nextfirst = 0;
        nextlast = 1;
        size = 0;
    }
    private boolean isFull()
    {
        if (size == MAXLEN)
        {
            return true;
        }
        return false;
    }

    public void addFirst(T item)
    {
        if (isFull())
        {
            T[] newdeque = (T[])new Object[MAXLEN*2];
            for(int i=1;i<=size-nextfirst-1;i++)
            {
                newdeque[(MAXLEN+nextfirst+i)%(2*MAXLEN)] = deque[(nextfirst+i)%MAXLEN];
            }
            for(int i=0;i<=nextfirst;i++){
                newdeque[i]=deque[i];
            }
            nextfirst = MAXLEN+nextfirst;
            MAXLEN = MAXLEN*2;
            deque = newdeque;
        }
        deque[nextfirst] = item;
        nextfirst = (nextfirst-1+MAXLEN)%MAXLEN;
        size++;
    }

    public void addLast(T item)
    {
        if (isFull())
        {
            T[] newdeque = (T[])new Object[2*MAXLEN];

            for(int i=0;i<=size-nextlast-1;i++)
            {
                newdeque[(nextlast+MAXLEN+i)%(2*MAXLEN)] = deque[(nextlast+i)%MAXLEN];
            }
            for(int i=0;i<nextlast;i++){
                newdeque[i] = deque[i];
            }
            nextfirst = nextlast+MAXLEN-1;
            MAXLEN = 2*MAXLEN;
            deque = newdeque;
        }
        deque[nextlast] = item;
        nextlast = (nextlast+1+MAXLEN)%MAXLEN;
        size++;
    }

    public boolean isEmpty()
    {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public int size()
    {
        return size;
    }

    public void printDeque()
    {
        for(int i=1;i<=size;i++)
        {
            if (deque[nextfirst]==null){
                System.out.print(deque[(nextfirst+i)%MAXLEN]);
                System.out.print(' ');
            }
            else{
                System.out.print(deque[(nextfirst+i-1)%MAXLEN]);
                System.out.print(' ');
            }
        }
    }

    public T removeFirst()
    {
        if (isEmpty()) {
            return null;
        }
        nextfirst = (nextfirst+1)%MAXLEN;
        T res = deque[nextfirst];
        size--;
        deque[nextfirst]=null;
        return res;
    }

    public T removeLast()
    {
        if (isEmpty()){
            return null;
        }
        nextlast = (MAXLEN+nextlast-1)%MAXLEN;
        T res = deque[nextlast];
        deque[nextlast]=null;
        size--;
        return res;
    }

    public T get(int index)
    {
        if (index<0||index>=size||size==0) return null;
        T res = null;
        for(int i=1;i<=size;i++)
        {
            if(i==index+1)
            {
                res = deque[(nextfirst + i) % MAXLEN];
                break;
            }
        }
        return res;
    }
}