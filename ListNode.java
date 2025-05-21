public class ListNode{
    // Private fields and setters/getters are not needed for linked lists/list nodes since the 'next' property is
    // being accessed so much; having these would make code overly verbose (node.val opposed to node.getVal()).
    // Class if finished. One possible change is to use Object or Generics to allow ListNodes with values other than int.
    public Integer val;
    public ListNode next;

    public ListNode(){}//default constructor

    public ListNode(int val) {//constructor with one value
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public String toString(){ //toString in array fashion
        if(next != null){
            return val + ", " + next;//calls toString on next node, until next = null.
        }
        return val + "";
    }

    public String toStringFull(){//toString with next values specified.
        if (next != null) {
            return "val: " + val + " next: " + next.toStringFull();
        }
        return "val: " + val + " next: " + null;
    }
}