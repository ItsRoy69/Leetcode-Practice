// Include the class Node definition here

public class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node ptr = head;
        
        // Step 1: Insert cloned nodes
        while (ptr != null) {
            Node newNode = new Node(ptr.val);
            newNode.next = ptr.next;
            ptr.next = newNode;
            ptr = newNode.next;
        }
        
        ptr = head;
        
        // Step 2: Connect random pointers of cloned nodes
        while (ptr != null) {
            ptr.next.random = (ptr.random != null) ? ptr.random.next : null;
            ptr = ptr.next

.next;
        }
        
        Node ptr_old_list = head;
        Node ptr_new_list = head.next;
        Node head_old = head.next;
        
        // Step 3: Separate original and cloned lists
        while (ptr_old_list != null) {
            ptr_old_list.next = ptr_old_list.next.next;
            ptr_new_list.next = (ptr_new_list.next != null) ? ptr_new_list.next.next : null;
            ptr_old_list = ptr_old_list.next;
            ptr_new_list = ptr_new_list.next;
        }
        
        return head_old;
    }
}