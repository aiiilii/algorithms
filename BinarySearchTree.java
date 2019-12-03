import java.util.Queue;
import java.util.LinkedList;

public class BinarySearchTree {

    public static class TreeNode {

        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
            // left = null;
            // right = null;
        }
    }

    public static TreeNode insert(TreeNode root, int data) {
        if (root == null) {
            TreeNode newNode = new TreeNode(data);
            root = newNode;
        } else if (data <= root.data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }
        return root;
    }

    public static TreeNode delete(TreeNode root, int data) {
        if (root == null) {
            return null;
        }
        else if (data < root.data) {
            root.left = delete(root.left, data);
        } else if (data > root.data) {
            root.right = delete(root.right, data);
        } else { // (data == root.data)
            if (root.left == null && root.right == null) {
                // root = null;
                return null;
            } else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode temp = findMinNode(root.right);
                root.data = temp.data;
                root.right = delete(root.right, temp.data);
            }
        }
        return root;
    }

    public static TreeNode findMinNode(TreeNode root) {
        if (root == null) {
            return null;
        }
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static TreeNode findMaxNode(TreeNode root) {
        if (root == null) {
            return null;
        }
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }

    public static boolean search(TreeNode root, int data) {
        if (root == null) {
            return false;
        } else if (root.data == data) {
            return true;
        } else if (data < root.data) {
            return search(root.left, data);
        } else {
            return search(root.right, data);
        }
    }

    public static int findMin(TreeNode root) throws Exception{
        if (root == null) {
            throw new Exception("Tree is empty");
        } else if (root.left == null) {
            return root.data;
        }
        return findMin(root.left);
    }

    public static int findMax(TreeNode root) throws Exception{
        if (root == null) {
            throw new Exception("Tree is empty");
        } else if (root.right == null) {
            return root.data;
        }
        return findMax(root.right);
    }

    public static int findHeight(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void levelOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            System.out.println(current.data + " ");
            if (current.left != null) {
                queue.add(current.left);
            } 
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    public static void preorder(TreeNode root) {
        if (root == null) return;
        System.out.println(root.data);
        preorder(root.left);
        preorder(root.right);
    }

    public static void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }

    public static void postorder(TreeNode root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.println(root.data);
    }

    /**
     * The two functions below does not use recursion and can use contant time to find out whether this tree is a binary search tree
     * Since the isBSTUtil function takes in a minValue and a maxValue, when we call this function, 
     * we may not want to insert a minValue and a maxValue all the time, we have the isBST function that returns 
     * the result of the isBSTUtil function and has int minvalue and int max value already as parameters.
     * This solution does not allow duplicates
     * Time complexity, O(n)
     * 
     * @param root root node of a tree
     * @return whether this tree is a binary search tree
     */
    public static boolean isBST(TreeNode root) {
        return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean isBSTUtil(TreeNode root, int minValue, int maxValue) {
        if (root == null) return true;
        if (root.data > minValue && root.data < maxValue && isBSTUtil(root.left, minValue, root.data) 
            && isBSTUtil(root.right, root.data, maxValue)) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * The three functions below uses recursion to check whether the given tree is a binary search tree
     * Allows duplicates
     * Time complexity, O(n^2)
     * 
     * @param root root node of a tree
     * @return whether the tree is a binary search tree
     */
    public static boolean isBinarySearchTree(TreeNode root) {
        if (root == null) return true;
        if (isSubtreeLesser(root.left, root.data) && isSubtreeGreater(root.right, root.data) && isBinarySearchTree(root.left) && isBinarySearchTree(root.right)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Given a subtree, all the nodes inside the subtree has to be lesser than the given data(which is the root.node.data)
     * 
     * @param root Tree's root node
     * @param data The int value in root node(parent node of the subtree to be compared, thus all number in the subtree should be lesser than the root.node.data)
     * @return whether this tree is lesser than the given data(root.node.data)
     */
    public static boolean isSubtreeLesser(TreeNode root, int data) {
        if (root == null) return true;
        if (root.data <= data && isSubtreeLesser(root.left, data) && isSubtreeLesser(root.right, data)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isSubtreeGreater(TreeNode root, int data) {
        if (root == null) return true;
        if (root.data > data && isSubtreeGreater(root.left, data) && isSubtreeGreater(root.right, data)) {
            return true;
        } else {
            return false;
        }
    }

    public static TreeNode find(TreeNode root, int data) {
        if (root == null) {
            return null;
        } else if (root.data == data) {
            return root;
        } else if (data > root.data) {
            return find(root.right, data);
        } else { // (data < root.data)
            return find(root.left, data);
        }  
    }

    public static TreeNode getSuccessor(TreeNode root, int data) {
        TreeNode current = find(root, data);
        if (current == null) {
            return null;
        }
        // Case 1: Node has right subtree
        if (current.right != null) {
            return findMinNode(current.right);
            // or
            // TreeNode temp = current.right;
            // while (temp.left != null) {
            //     temp = temp.left;
            // return temp;
            // see the function for findMinNode()
        } 
        // Case 2: No right subtree
        else { // (current.right == null)
            TreeNode successor = null;
            TreeNode ancestor = root;
            while (ancestor != current) {
                if (current.data < ancestor.data) {
                    successor = ancestor; // so far this is the deepest node for which current node is in left
                    ancestor = ancestor.left;
                } else {
                    ancestor = ancestor.right;
                    // if never into the if statement, successor is null;
                }
            }
            return successor;
        }
    }

    public static int getSuccessorValue(TreeNode root, int data) throws Exception{
        TreeNode temp = getSuccessor(root, data);
        if (temp == null) {
            throw new Exception("Cannot find current node");
        }
        return temp.data;
    }

    public static void main(String[] args) {
        TreeNode node = insert(null, 20);

        node = insert(node, 5);
        node = insert(node, 37);
        node = insert(node, 58);
        node = insert(node, 13);
        node = insert(node, 2);

        node = delete(node, 37);

        
        System.out.println(search(node, 37));
        System.out.println(findHeight(node));

        try {
            System.out.println(findMax(node));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        levelOrder(node);
        preorder(node);
        inorder(node);
        postorder(node);   
        
        System.out.println(isBST(node));

        System.out.println(getSuccessor(node, 13));

        // TreeNode node = insert(null, 2);

        // node = insert(node, 1);
        // node = insert(node, 3);

        // System.out.println(findHeight(node));
    }

}