package com.example.javatopics.linkedList;

/*
* Linked List Implementation
* Linked List Traversal
* Mid Of Linked List
* Deletion At Beginning
* Deletion in the Middle
* Deletion At END
* Reverse a Linked List
* Total Nodes In Linked List
* Detect If List is Cyclic Or Not
* Making List Cyclic
* Check if Two Linked List are identical
* Merge Two Sorted Linked List
* Flattening Of Linked List
 */
public class LinkedListImpl {

    private static int count;
    static{
        count =0;
    }
    public static Node linkedListCreation (Node head,int element) {
        if(head == null)
            return new Node(element);
        else{
            Node temp = head;
            while(temp.next!=null){
                temp = temp.next;
            }
            temp.next = new Node(element);
        }
        return head;
    }
     static void linkedListTraversal (Node head) {
        if(head== null)
            return;
        else{
            Node temp = head;
            while(temp!=null){
                System.out.print(temp.data + " ");
                temp= temp.next;
            }
        }
    }
    private static int midNode (Node head) {
        if(head == null)
            return -1;
        Node slow_ptr = head;
        Node fast_ptr = head;

        while(fast_ptr.next!=null){
            slow_ptr= slow_ptr.next;
            fast_ptr= fast_ptr.next.next;
        }
        return slow_ptr.data;
    }
    private static Node  deleteNode (Node head ,int element) {
        if(checkIfElementPresent(head ,element)){
            if(head.data == element){
                head = head.next;
                return head;
            }else{
                Node temp = head;
                Node prev = null;
                while(temp!=null && temp.data!=element){
                    prev = temp;
                    temp= temp.next;
                }
                prev.next= temp.next;
            }
        }else{
            System.out.println("Node with " + element + " Not Present : ");
        }
        return head;
    }
    private static boolean checkIfElementPresent (Node head ,int element) {
        if(head== null)
            return false;
        Node temp = head;
        while(temp!=null){
            if(temp.data== element){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
    private static Node reverseLinkedList (Node head) {
        Node curr =head;
        Node prev= null;
        Node next = null;

       while(curr!=null){
           next = curr.next;
           curr.next =prev;
           prev =curr;
           curr= next;
       }
        return prev;
    }
    private static int nodesCountInList (Node head) {
        if(head== null){
            return 0;
        }else{
            Node temp = head;
            while(temp!=null){
                count++;
                temp=temp.next;
            }
        }
        return count;
    }
    private static boolean checkIfListIsCyclic (Node head) {
        if(head== null || head.next== null)
            return false;
        Node slow_ptr = head;
        Node fast_ptr = head;
        while(fast_ptr!=null){
            slow_ptr=slow_ptr.next;
            fast_ptr=fast_ptr.next.next;

            if(slow_ptr== fast_ptr)
                return true;
        }
        return false;
    }
    private static boolean checkIfTwoLinkedListsAreIdentical (Node head2, Node head3) {
        if(head2== null && head3==null)
            return true;
        if(!sizeSameForTwoLists(head2,head3)){
            return false;
        }
        Node temp2 =head2;
        Node temp3 =head3;

        while(temp2!=null && temp3!=null){
            if(temp2.data!= temp3.data)
                return false;
            temp2=temp2.next;
            temp3=temp3.next;
        }
        return true;
    }

    private static boolean sizeSameForTwoLists (Node head2, Node head3) {
        Node temp2 =head2;
        Node temp3 =head3;

        int firstListSize=0;
        int secondListSize=0;

        while(temp2!=null){
            firstListSize++;
            temp2=temp2.next;
        }
        while(temp3!=null){
            secondListSize++;
            temp3=temp3.next;
        }
        if(firstListSize==secondListSize)
            return true;
        return false;
    }
    private static Node mergeTwoSortedLinkedList (Node newHead,Node head1, Node head2) {
        if(head1==null && head2== null)
            return null;

        Node temp1= head1;
        Node temp2=head2;

        int firstNodeSize=0,secondNodeSize=0;

        while(head1!=null){
            firstNodeSize++;
            head1=head1.next;
        }
        while(head2!=null){
            secondNodeSize++;
            head2=head2.next;
        }
        int i=0,j=0;
        while(i<firstNodeSize && j<secondNodeSize){
            if(temp1.data< temp2.data){
                newHead = linkedListCreation(newHead, temp1.data);
                temp1=temp1.next;
                i++;
            }else{
                newHead = linkedListCreation(newHead, temp2.data);
                temp2=temp2.next;
                j++;
            }
        }
        while (i<firstNodeSize){
            newHead = linkedListCreation(newHead, temp1.data);
            temp1=temp1.next;
            i++;
        }
        while (j<secondNodeSize){
            newHead = linkedListCreation(newHead, temp2.data);
            temp2=temp2.next;
            j++;
        }

        return newHead;
    }

    public static void main(String[] args){
        Node head = null;
        int arr[] = {1,4,5,6,7};
        for(int i=0;i<arr.length;i++){
            head = linkedListCreation(head,arr[i]);
        }
        System.out.println();
        System.out.println("Linked List Traversal : ");
        linkedListTraversal(head);
        System.out.println();
        System.out.println("Mid Node Of Linked List ");
        System.out.println(midNode(head));
        System.out.println("Deletion In Linked List");
        head = deleteNode(head,15);
        System.out.println("Linked List Traversal : ");
        linkedListTraversal(head);
        /*In first Iteration reversal of node does not take place
        but reversal of node direction start from the second iteration*/
        head = reverseLinkedList(head);
        System.out.println();
        System.out.println("Linked List Reversal :");
        linkedListTraversal(head);
        System.out.println();
        System.out.println("Total No of Nodes In Linked List : ");
        System.out.println(nodesCountInList(head));
        System.out.println("Test If List is Cyclic :");

        Node head1 = new Node(10);
        head1.next = new Node(20);
        head1.next.next = new Node(30);
        head1.next.next.next = new Node(40);
        head1.next.next.next.next = new Node(50);
        head1.next.next.next.next.next = new Node(60);

        head1.next.next.next.next.next.next = head1;
        // Declare Two Pointers Slow and fast and while iteration if fast_ptr == slow_ptr , it is cyclic
        System.out.println(checkIfListIsCyclic(head1));


        System.out.println();

        // Create first linked list: 3 -> 2 -> 1
        Node head2 = new Node(3);
        head2.next = new Node(2);
        head2.next.next = new Node(1);

        // Create second linked list: 3 -> 2 -> 1
        Node head3 = new Node(3);
        head3.next = new Node(2);
        head3.next.next = new Node(1);

        System.out.println("Check If Two Linked List are identical : ");
        System.out.println(checkIfTwoLinkedListsAreIdentical(head2,head3));
        System.out.println();

        Node head4 = new Node(5);
        head4.next = new Node(10);
        head4.next.next = new Node(15);

        Node head5 = new Node(2);
        head5.next = new Node(3);
        head5.next.next = new Node(20);
        System.out.println("Merge Two Linked List  : ");
        Node head6 = null;
        head6= mergeTwoSortedLinkedList(head6,head4,head5);
        System.out.println("Linked List Traversal :");
        linkedListTraversal(head6);
        System.out.println();
    }
}
