public class LinkedList<T>{
    
            class Node<T> {
            public T data;
            public Node<T> next;
            public Node () {
                data = null;
                next = null;
            }
            public Node (T val) {
                data = val;
                next = null;
            }

            public T getData() {
                return data;
            }

            public void setData(T data) {
                this.data = data;
            }

            public Node<T> getNext() {
                return next;
            }

            public void setNext(Node<T> next) {
                this.next = next;
            }

        }
    
    private Node<T> head;
    private Node<T> current;
    int size;
    
    public LinkedList () {
        head = current = null;
        size = 0 ;
    }
    public boolean empty () {
        return head == null;
    }
    public int size ()
    {
        return size;
    }
    
    public boolean last () {
        return current.next == null;
    }
    public boolean full () {
            return false;
    }
    public void findFirst () {
            current = head;
    }
    public void findNext () {
            current = current.next;
    }
    public T retrieve () {
            return current.data;
    }
    public void update (T val) {
            current.data = val;
    }
    
   public void insert(T val) {
    Node<T> newNode = new Node<T>(val);

    if (empty()) {
        head = current = newNode;
    } 
    else if (current == null) {
        Node<T> temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = newNode;
        current = newNode;
    } 
    else {
        newNode.next = current.next;
        current.next = newNode;
        current = newNode;
    }

    size++;
}

   
    public void remove () {
            if (current == head) {
                    head = head.next;
            }
            else {
                    Node<T> tmp = head;

                    while (tmp.next != current)
                            tmp = tmp.next;

                    tmp.next = current.next;
            }

            if (current.next == null)
                    current = head;
            else
                    current = current.next;
            size --;
    }
    public void print()
    {
        if ( head == null)
            System.out.println("Empty data");
        else
        {
            Node<T> tmp = head;
            while ( tmp != null)
            {
                System.out.print(tmp.data + "  ");
                tmp = tmp.next;
            }
            
        }
        System.out.println("");
    }
    
}
