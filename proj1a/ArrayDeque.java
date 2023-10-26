public class ArrayDeque<unkowntype>{
    private unkowntype[] deque;
    private int size;
    private int nextfirst;
    private int nextlast;
    private int MAXLEN=8;
    
    public ArrayDeque()
    {
        deque = (unkowntype[])new Object[MAXLEN];
        nextfirst = 0;
        nextlast = 0;
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
    public void addFirst(unkowntype item)
    {
        if (isFull())
        {
            unkowntype[] newdeque = (unkowntype[])new Object[MAXLEN+1];
            for(int i=1;i<=size;i++)
            {
                newdeque[(nextfirst+i)%(MAXLEN+1)] = deque[(nextfirst+i)%MAXLEN];
            }
            MAXLEN = MAXLEN+1;
            nextlast = (nextfirst+size+1)%MAXLEN;
            deque = null;
            deque = newdeque;
        }
        deque[nextfirst] = item;
        nextfirst = (nextfirst-1+MAXLEN)%MAXLEN;
        size++;
    }

    public void addLast(unkowntype item)
    {
        if (isFull())
        {
            unkowntype[] newdeque = (unkowntype[])new Object[MAXLEN+1];
            for(int i=1;i<=size;i++)
            {
                newdeque[(nextfirst+i)%(MAXLEN+1)] = deque[(nextfirst+i)%MAXLEN];
            }
            MAXLEN = MAXLEN+1;
            nextlast = (nextfirst+size+1)%MAXLEN;
            deque = null;
            deque = newdeque;
        }
        deque[nextlast] = item;
        nextlast = (nextlast+1+MAXLEN)%MAXLEN;
        size++;
    }

    public boolean isEmpty()
    {
        if (size == 0) return true;
        return false;
    }

    public int size()
    {
        return size;
    }

    public void PrintDeque()
    {
        for(int i=1;i<=size;i++)
        {
            System.out.print(deque[(nextfirst+i)%MAXLEN]);
            System.out.print(' ');
        }
    }

    public unkowntype removeFirst()
    {
        nextfirst = (nextfirst+1)%MAXLEN;
        size--;
    }

    public unkowntype removeLast()
    {
        nextlast = (MAXLEN+nextlast-1)%MAXLEN;
        size--;
    }

    public unkowntype get(int index)
    {
        if (index<0||index>=size||size==0) return null;
        for(int i=1;i<=size;i++)
        {
            if(i==index+1)
            {
                return deque[(nextfirst+i)%MAXLEN];
            }
        }
    }
}