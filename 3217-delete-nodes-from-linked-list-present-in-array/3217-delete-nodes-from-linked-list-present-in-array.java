/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        ListNode res = new ListNode();
        ListNode resCur = res;
        ListNode cur = head;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        
        while (cur != null) {
            if (!set.contains(cur.val)) {
                resCur.next = new ListNode(cur.val);
                resCur = resCur.next;
            }
            cur = cur.next;
        }
        
        return res.next;
    }
}