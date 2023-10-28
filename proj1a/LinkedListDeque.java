public class LinkedListDeque<T> {

    public class LinkedList{
        public T val;
        public LinkedList prev;
        public LinkedList next;
        public LinkedList(T val, LinkedList prev, LinkedList next)
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

    public void addFirst(T item){
        LinkedList curhead = sentinelfront.next;
        LinkedList newhead = new LinkedList(item,sentinelfront,curhead);
        curhead.prev = newhead;
        sentinelfront.next = newhead;
        size++;
    }

    public void addLast(T item)
    {
        LinkedList curtail = sentinelrear.prev;
        LinkedList newtail = new LinkedList(item,curtail,sentinelrear);
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

    public T removeFirst()
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
            T result = curhead.val;
            curhead = null;
            size--;
            return result;
        }
    }

    public T removeLast(){
        if(this.isEmpty()) return null;
        else{
            LinkedList curtail = sentinelrear.prev;
            LinkedList newtail = sentinelrear.prev.prev;
            newtail.next = sentinelrear;
            sentinelrear.prev = newtail;
            T result = curtail.val;
            curtail = null; //回收内存
            size--;
            return result;
        }
    }

    public T get(int index){
        if (this.isEmpty() || index<0 ||index>this.size()-1) return null;
        LinkedList p = sentinelfront.next;
        while(index!=0)
        {
            p=p.next;
            index--;
        }
        return p.val;
    }

    /**To help getRecursive works*/
    private T getTargetNode(LinkedList cur,int index)
    {
        if (index<0||index>this.size()-1||this.isEmpty()) {
            return null;
        }
        if (index==0)
        {
            return cur.val;
        }
        return getTargetNode(cur.next,index-1);
    }

    /**Recursive implementation of get(index) operation*/
    public T getRecursive(int index)
    {
        return getTargetNode(this.sentinelfront.next,index);
    }
}
