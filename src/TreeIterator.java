import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class TreeIterator {
    public static class Node {
        Integer val;
        Node left;
        Node right;

        public Node(int val){
            this.val = val;
        }
    }

    Node root = null;
    int cur = 0;
    List<Node> list = new LinkedList<>();
    public TreeIterator(Node root) {
        this.root = root;
        addToList(root);
    }

    public void addToList(Node root){
        try{
            if (root==null) return;
            addToList(root.left);
            list.add(root);
            addToList(root.right);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /*
      4
    3   5
    => 3,4,5
  TreeIterator iter = new TreeIterator(Node(4));
  iter.next(); //Node(3)
  iter.next(); //Node(4)
  iter.next(); //Node(5)
  iter.next(); //null
  */
    public Node next() {
        if (cur>=list.size()){
            return null;
        }
        return list.get(cur++);
    }

    public static void main(String[] args) {
        Node node1 = new Node(4);
        Node node2 = new Node(3);
        Node node3 = new Node(5);
        node1.left = node2;
        node1.right = node3;
        TreeIterator iter = new TreeIterator(node1);
        System.out.println(iter.next().val);
        System.out.println(iter.next().val);
        System.out.println(iter.next().val);
        System.out.println(iter.next());
    }

    //可以用辅助成员变量或数据结构
}
