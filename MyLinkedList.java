public class MyLinkedList{
    private ListNode node;//ListNode to append and modify values
    private final ListNode head;//reference to head of node
    private int size;//list size

    public MyLinkedList(){
        node = new ListNode();
        head = node;
    }

    public MyLinkedList(Integer[] values){//LinkedList from array. WORKING.
        node = new ListNode(values[0]);//instantiate node
        head = node;//instantiate head
        size = values.length;

        for(int i = 1; i < values.length; i++){
            node.next = new ListNode(values[i]);
            node = node.next;
        }
    }

    public MyLinkedList(ListNode newNode){//LinkedList from ListNodes. WORKING.
        this.node = newNode;//instantiate node
        this.head = this.node;//instantiate head

        while(newNode.next != null){//set list size
            size++;
            newNode = newNode.next;
        }
        size++;
    }

    public void set(int index, int value) throws IndexOutOfBoundsException{//traverse to index, then change value at index. WORKING.
        if(index >= size || index < 0){
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }
        traverse(index);
        node.val = value;
    }

    public int get(int index) throws IndexOutOfBoundsException{//traverse to index, then return value at index. WORKING.
        if(index >= size || index < 0){
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }
        traverse(index);
        return node.val;
    }

    public int getFirst(){
        return head.val;
    }

    public void add(int value){//add value to the end of the list. WORKING.
        traverse(size - 1); //maybe?
        node.next = new ListNode(value); //node = node.next? next line
        size++;
    }

    public void add(int index, int value) throws IndexOutOfBoundsException{//traverse to index, then add value at index. WORKING.
        if(index > size || index < 0){
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }

        else if(index == size){//if add index is at the end of the list
            add(value);
        }

        else{
            add(value);
            traverse(index);

            for(int i = size - 1; i > index; i--){
                set(i, get(i - 1));
                node = node.next;
            }
            set(index, value);
        }
    }

    public void remove(int index) throws IndexOutOfBoundsException{
        //traverses to index, pushing every element after index back one space, then setting the last value to null, effectively removing an index. WORKING.
        if(index >= size || index < 0){
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }

        size--;
        traverse(index);

        for(int i = index; i < size; i++){
            node.val = node.next.val;
            node = node.next;
        }
        traverse(size - 1);
        node.next = null;
    }

    public void clear(){// clears the list. WORKING, TECHNICALLY.
        node = head;
        node.next = null;
        node.val = null;
        size = 0;
    }//list can never be [], as even a null node will have size initialized as 0 (and next as null, of course).

    public int getSize(){//return LinkedList size. WORKING.
        node = head;
        size = 1;

        while(node.next != null){
            size++;
            node = node.next;
        }
        return size;
    }

    private void traverse(int index){//HELPER METHOD: traverses list from index 0 to a specified index. WORKING.
        node = head;//get to start of list(index 0) to avoid NullPointerExceptions
        // (ex: if node at index 2 with size 4, going to index 3 would result in 4 iterations, throwing an error as a result).
        for(int i = 0; i < index; i++){
            node = node.next;
        }
    }

    public String toString(){//WORKING.
        return "[" + head + "]";
    }

    public String toStringFull(){//WORKING.
        return "[" + head.toStringFull() + "]";
    }
}