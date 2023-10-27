public class ArrayDeque<unkowntype>{
    private unkowntype[] deque;
    private int size;
    public int nextfirst;
    public int nextlast;
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
            unkowntype[] newdeque = (unkowntype[])new Object[MAXLEN*2];
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

    public void addLast(unkowntype item)
    {
        if (isFull())
        {
            unkowntype[] newdeque = (unkowntype[])new Object[2*MAXLEN];

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
        return deque[nextfirst];
    }

    public unkowntype removeLast()
    {
        nextlast = (MAXLEN+nextlast-1)%MAXLEN;
        size--;
        return deque[nextlast];
    }

    public unkowntype get(int index)
    {
        if (index<0||index>=size||size==0) return null;
        unkowntype res = null;
        for(int i=1;i<=size;i++)
        {
            if(i==index+1)
            {
                res = deque[(nextfirst+i)%MAXLEN];
                break;
            }
        }
        return res;
    }
}