import static java.lang.System.nanoTime;

public class LinkedListRunner {
    public static void main(String[] args) { //This all works, which is pretty damn cool.
        ListNode node = new ListNode(0);
        ListNode head = node; //SAME OBJECT (when running code without toString, memory address is the same (@5f184fc6))
        //head refers to the head of the node for later access (such as returning the entire node, whereas returning node
        //would only return the final value in the list).

        node.next = new ListNode(10); //change next value
        node = node.next; //get to next value

        System.out.println("Node toString(): " + node);

        node = node.next;

        System.out.println("Node toString() after traversing to next: " + node);
        System.out.println("Head toString(): " + head);
        System.out.println("Head toStringFull(): " + head.toStringFull());

        MyLinkedList listNodes = new MyLinkedList(head); //turn nodes into a LinkedList
        System.out.println("\nNode toString() as LinkedList: " + listNodes);
        System.out.println("Node as LinkedList getSize(): " + listNodes.getSize());

        ListNode newNode = new ListNode();
        ListNode newHead = newNode;
        int[] arr = {1, 2, 3, 4, 5};

        for(int i = 0; i < arr.length; i++){
            newNode.next = new ListNode(arr[i]);
            newNode = newNode.next;
        }
        System.out.println("\ntoString of node after copying array to node: " + newHead.next);

        /////////////////////////////

        long time = nanoTime();
        MyLinkedList list = new MyLinkedList(new Integer[]{1, 2, 3});//list instantiation

        System.out.println("\nINITIAL LIST: " + list);//toString
        System.out.println("Initial List toStringFull(): " + list.toStringFull());
        System.out.println("Initial Size: " + list.getSize());//size

        int get = list.get(1); //get
        System.out.println("\nget(1): " + get);
        System.out.println("List After get(1): " + list);//list stays the same, as it should
        System.out.println("Size After get(1): " + list.getSize());

        get = list.getFirst();
        System.out.println("\ngetFirst(): " + get);
        System.out.println("List After getFirst(): " + list);//list stays the same, as it should
        System.out.println("Size After getFirst(): " + list.getSize());

        //System.out.println(list.get(4));//get with exception thrown

        list.set(2, 5); //set
        System.out.println("\nList After set(2, 5): " + list);//index 2 changes to 5
        System.out.println("Size After set(2, 5): " + list.getSize());

        //list.set(5, 2);//set with exception thrown

        list.add(10);
        System.out.println("\nList After add(10): " + list);
        System.out.println("Size After add(10): " + list.getSize());//size after adding a value

        list.add(1, 8);
        System.out.println("\nList After add(1, 8): " + list); //expected: 1, 8, 2, 5, 10
        System.out.println("Size After add(1, 8): " + list.getSize());

        list.remove(1);
        System.out.println("\nList After remove(1): " + list);//expected: 1, 2, 5, 10
        System.out.println("Size After remove(1): " + list.getSize());

        list.clear();
        System.out.println("\nList After clear(): " + list);
        System.out.println("Size after clear(): " + list.getSize());

        System.out.println(nanoTime() - time);
    }
}