/*
    类型要满足拥有可比较性
 */

public class BST<E extends Comparable<E>> {

    private class Node {
        public E e;
        public Node left;
        public Node right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // 向二分搜索树中添加新的元素e
    public void add(E e) {
        root = add(root, e);
    }

    // 向以node为根的二分搜索树中插入元素E，递归算法
    // 返回插入新节点后二分搜索树的根
    private Node add(Node node, E e) {
        // 递归终点
        if (node == null) {
            size++;
            return new Node(e);
        }

        // 递归插入
        if (e.compareTo(node.e) < 0)
            node.left = add(node.left, e);
        else if (e.compareTo(node.e) > 0)
            node.right = add(node.right, e);

        return node;
    }

    // 看二分搜索树是否包含元素e
    public boolean contains(E e) {

        return contains(root, e);
    }

    // 看以node为跟的二分搜索树是否包含元素e，递归
    private boolean contains(Node node, E e) {

        // 终点
        if (node == null)
            return false;

        if (e.compareTo(node.e) == 0)
            return true;
        else if (e.compareTo(node.e) < 0)
            return contains(node.left, e);
        else
            return contains(node.right, e);
    }
}
