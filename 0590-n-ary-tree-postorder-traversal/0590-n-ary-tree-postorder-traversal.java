/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> postorder(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        if(root==null){
            return list; 
        }
        help(list,root);
        list.add(root.val);
        return list;
    }
    public void help(ArrayList<Integer> list,Node root){
        List<Node> li = new ArrayList<>();
        li = root.children;
        for(int i=0;i<li.size();i++){
            if(li.get(i)==null){
                continue;
            }
            help(list,li.get(i));
            list.add(li.get(i).val);
        }
    }
}