public class Deque {

}
public class ArrayDeque<unkowntype> implements Deque<unkowntype>{
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
        for(int i=1;i<=size;i++)
        {
            if(i==index+1)
            {
                return deque[(nextfirst+i)%MAXLEN];
            }
        }
    }
}

public class LinkedListDeque<unkowntype> implements Deque<unkowntype>{

    public class LinkedList{
        public unkowntype val;
        public LinkedList prev;
        public LinkedList next;
        public LinkedList(unkowntype val, LinkedList prev, LinkedList next)
        {
            this.val = val;
            this.prev = prev;
            this.next= next;
        } //这里不加this会导致赋值失败！！！
    }

    private LinkedList sentinelfront;
    private LinkedList sentinelrear;
    private int size;

    public LinkedListDeque()
    {
        sentinelfront = new LinkedList(null,null,null);
        sentinelrear = new LinkedList(null,sentinelfront,null);
        sentinelfront.next = sentinelrear;
        size = 0;
    }

    public void addFirst(unkowntype T){
        LinkedList curhead = sentinelfront.next;
        LinkedList newhead = new LinkedList(T,sentinelfront,curhead);
        curhead.prev = newhead;
        sentinelfront.next = newhead;
        size++;
    }

    public void addLast(unkowntype T)
    {
        LinkedList curtail = sentinelrear.prev;
        LinkedList newtail = new LinkedList(T,curtail,sentinelrear);
        sentinelrear.prev = newtail;
        curtail.next = newtail;
        size++;
    }

    public boolean isEmpty()
    {
        if (sentinelfront.next == sentinelrear) return true;
        return false;
    }

    public int size()
    {
        return size;
    }

    public void printDeque()
    {
        if (isEmpty() == false) {
            LinkedList p = sentinelfront.next;
            while (p!= sentinelrear) {
                System.out.print(p.val);
                System.out.print(' ');
                p = p.next;
            }
        }
    }

    public unkowntype removeFirst()
    {
        if (this.isEmpty())
        {
            return null;
        }
        else{
            LinkedList curhead = sentinelfront.next;
            LinkedList newhead = sentinelfront.next.next;
            newhead.prev = sentinelfront;
            sentinelfront.next = newhead;
            unkowntype result = curhead.val;
            curhead = null;
            size--;
            return result;
        }
    }

    public unkowntype removeLast(){
        if(this.isEmpty()) return null;
        else{
            LinkedList curtail = sentinelrear.prev;
            LinkedList newtail = sentinelrear.prev.prev;
            newtail.next = sentinelrear;
            sentinelrear.prev = newtail;
            unkowntype result = curtail.val;
            curtail = null; //回收内存
            size--;
            return result;
        }
    }

    public unkowntype get(int index){
        if (this.isEmpty() || index<0 ||index>this.size()-1) return null;
        LinkedList p = sentinelfront.next;
        while(index!=0)
        {
            p=p.next;
            index--;
        }
        return p.val;
    }

    public unkowntype getRecursive(int index,LinkedList head)
    {
        if (index<0||index>this.size()-1||this.isEmpty()) {
            return null;
        }
        if (index == 0)
        {
            return head.val;
        }
        return getRecursive(index-1,head.next);
    }
}
