package algorithm;

/**
 * 二叉树数据结构的遍历
 *
 */
public class TreeDemo {

    /**
     * 左序遍历
     * @param tree
     */
    public static void leftTraval(MyTree tree) {

        if (tree == null){
            return;
        }

        if (tree.left != null){
            leftTraval(tree.left);
        }

        tree.showValue();

        if (tree.right != null) {
            leftTraval(tree.right);
        }
    }

    /**
     * 中序遍历
     * @param tree
     */
    public static void midTraval(MyTree tree) {
        if (tree == null) {
            return;
        }

        tree.showValue();

        if (tree.left != null) {
            midTraval(tree.left);
        }

        if (tree.right != null) {
            midTraval(tree.right);
        }
    }

    /**
     * 右序遍历
     * @param tree
     */
    public static void rightTraval(MyTree tree) {
        if (tree == null) {
            return;
        }

        if (tree.right != null){
            rightTraval(tree.right);
        }

        tree.showValue();

        if (tree.left != null) {
            rightTraval(tree.left);
        }
    }
    public static void main(String[] args) {
        MyTree<String> root = new MyTree<>("root");
        MyTree<String> left = new MyTree<>("left1");
        MyTree<String> left1 = new MyTree<>("left1left");
        MyTree<String> left2 = new MyTree<>("left1right");
        left.addLeft(left1);
        left.addRight(left2);


        MyTree<String> right1 = new MyTree<>("right1left");
        MyTree<String> right2 = new MyTree<>("right1right");
        MyTree<String> right = new MyTree<>("right1");
        right.addLeft(right1);
        right.addRight(right2);

        root.addLeft(left);
        root.addRight(right);

        System.out.println("====== Left Traval =====");
        leftTraval(root);
        System.out.println("====== Mid Traval =====");
        midTraval(root);
        System.out.println("====== Right Traval =====");
        rightTraval(root);
    }
}



class MyTree<T> {
    T value;
    MyTree left = null;
    MyTree right = null;

    public MyTree(T value){
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public MyTree addLeft(MyTree left) {
        this.left = left;
        return left;
    }

    public MyTree addRight(MyTree right) {
        this.right = right;
        return right;
    }

    public MyTree delLeft() {
        MyTree temp = left;
        this.left = null;
        return temp;
    }

    public MyTree delRight() {
        MyTree temp = right;
        this.right = null;
        return temp;

    }


    public void showValue() {
        System.out.println(value);
    }
}
