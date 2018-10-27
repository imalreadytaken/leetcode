package interview.bytedance;

public class FindCommonAncestor {

    public Node getCommonAncestor(Node n1, Node n2, Node root) throws Exception {
        if(root == null)
            throw new Exception("Node not in the tree");
        if(n1.val == root.val || n2.val == root.val)
            return root;
        if(n1.val > root.val && n2.val > root.val)
            return getCommonAncestor(n1, n2, root.right);
        if(n1.val < root.val && n2.val < root.val)
            return getCommonAncestor(n1, n2, root.left);
        return root;
    }

    class Node{
        int val;
        Node left;
        Node right;
    }

}
