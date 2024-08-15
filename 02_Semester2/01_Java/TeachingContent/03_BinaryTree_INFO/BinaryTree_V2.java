import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A BinaryTree consists of "nodes"--each "node" is itself a BinaryTree.
 * Each node has a parent (unless it is the root), may have a left child,
 * and may have a right child. This class implements loop-free binary trees,
 * allowing shared subtrees.
 * 
 * @author David Matuszek
 * @version Jan 25, 2004
 * @param <V> The type of values contained in this BinaryTree.
 */
public class BinaryTree<V> {
    /**
     * The value (data) in this node of the binary tree; may be of
     * any object type.
     */
    public V value;
    private BinaryTree<V> leftChild;
    private BinaryTree<V> rightChild;

    /**
     * Constructor for BinaryTree.
     * 
     * @param value The value to be placed in the root.
     * @param leftChild The left child of the root (may be null).
     * @param rightChild The right child of the root (may be null).
     */
    public BinaryTree(V value, BinaryTree<V> leftChild, BinaryTree<V> rightChild) {
        this.value = value;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    /**
     * Constructor for a BinaryTree leaf node (that is, with no children).
     * 
     * @param value The value to be placed in the root.
     */
    public BinaryTree(V value) {
        this(value, null, null);
    }

    
    /**
     * Getter method for the value in this BinaryTree node.
     * 
     * @return The value in this node.
     */
    public V getValue() {
        return value;
    }
    
    /**
     * Getter method for left child of this BinaryTree node.
     * 
     * @return The left child (<code>null</code> if no left child).
     */
    public BinaryTree<V> getLeftChild() {
        return leftChild;
    }
    
    /**
     * Getter method for right child of this BinaryTree node.
     * 
     * @return The right child (<code>null</code> if no right child).
     */
    public BinaryTree<V> getRightChild() {
        return rightChild;
    }

    /**
     * Sets the left child of this BinaryTree node to be the
     * given subtree. If the node previously had a left child,
     * it is discarded. Throws an <code>IllegalArgumentException</code>
     * if the operation would cause a loop in the binary tree.
     * 
     * @param subtree The node to be added as the new left child.
     * @throws IllegalArgumentException If the operation would cause
     *         a loop in the binary tree.
     */
    public void setLeftChild(BinaryTree<V> subtree) throws IllegalArgumentException {
        if (contains(subtree, this)) {
            throw new IllegalArgumentException(
                "Subtree " + this +" already contains " + subtree);
        }
        leftChild = subtree;
    }

    /**
     * Sets the right child of this BinaryTree node to be the
     * given subtree. If the node previously had a right child,
     * it is discarded. Throws an <code>IllegalArgumentException</code>
     * if the operation would cause a loop in the binary tree.
     * 
     * @param subtree The node to be added as the new right child.
     * @throws IllegalArgumentException If the operation would cause
     *         a loop in the binary tree.
     */
    public void setRightChild(BinaryTree<V> subtree) throws IllegalArgumentException {
        if (contains(subtree, this)) {
            throw new IllegalArgumentException(
                    "Subtree " + this +" already contains " + subtree);
        }
        rightChild = subtree;
    }

    /**
     * Sets the value in this BinaryTree node.
     * 
     * @param value The new value.
     */
    public void setValue(V value) {
        this.value = value;
    }
    
    /**
     * Tests whether this node is a leaf node.
     * 
     * @return <code>true</code> if this BinaryTree node has no children.
     */
    public boolean isLeaf() {
        return leftChild == null && rightChild == null;
    }
    
    /**
     * Tests whether this BinaryTree is equal to the given object.
     * To be considered equal, the object must be a BinaryTree,
     * and the two binary trees must have equal values in their
     * roots, equal left subtrees, and equal right subtrees.
     * 
     * @return <code>true</code> if the binary trees are equal.
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object o) {
        if (o == null || !(o instanceof BinaryTree)) {
            return false;
        }
        BinaryTree<?> otherTree = (BinaryTree<?>) o;
        return equals(value, otherTree.value)
            && equals(leftChild, otherTree.getLeftChild())
            && equals(rightChild, otherTree.getRightChild());
    }
    
    /**
     * Tests whether its two arguments are equal.
     * This method simply checks for <code>null</code> before
     * calling <code>equals(Object)</code> so as to avoid possible
     * <code>NullPointerException</code>s.
     * 
     * @param x The first object to be tested.
     * @param y The second object to be tested.
     * @return <code>true</code> if the two objects are equal.
     */
    private boolean equals(Object x, Object y) {
        if (x == null) return y == null;
        return x.equals(y);
    }

    /**
     * Tests whether the <code>tree</code> argument contains within
     * itself the <code>targetNode</code> argument.
     * 
     * @param tree The root of the binary tree to search.
     * @param targetNode The node to be searched for.
     * @return <code>true</code> if the <code>targetNode</code> argument can
     *        be found within the binary tree rooted at <code>tree</code>.
     */
    protected static boolean contains(BinaryTree tree,
                                      BinaryTree targetNode) {
        if (tree == null)
            return false;
        if (tree == targetNode)
            return true;
        return contains(tree.getLeftChild(), targetNode)
            || contains(tree.getRightChild(), targetNode);
    }
    
    /**
     * Returns a String representation of this BinaryTree.
     * 
     * @see java.lang.Object#toString()
     * @return A String representation of this BinaryTree.
     */
    @Override
    public String toString() {
        if (isLeaf()) {
            return value.toString();
        }
        else {
            String root, left = "null", right = "null";
            root = value.toString();
            if (getLeftChild() != null) {
                left = getLeftChild().toString();
            }
            if (getRightChild() != null) {
                right = getRightChild().toString();
            }
            return root + " (" + left + ", " + right + ")";
        }
    }
    
    /**
     * Computes a hash code for the complete binary tree rooted
     * at this BinaryTree node.
     * 
     * @return A hash code for the binary tree with this root.
     * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        int result = value.hashCode();
        if (leftChild != null) {
            result += 3 * leftChild.hashCode();
        }
        if (rightChild != null) {
            result += 7 * rightChild.hashCode();
        }
        return result;
    }
    
    /**
     * Prints the binary tree rooted at this BinaryTree node.
     */
    public void print() {
        print(this, 0);
    }
    
    private void print(BinaryTree<V> root, int indent) {
        for (int i = 0; i < indent; i++) {
            System.out.print("   ");
        }
        if (root == null) {
            System.out.println("null");
            return;
        }
        System.out.println(root.value);
        if (root.isLeaf()) return;
        print(root.leftChild, indent + 1);
        print(root.rightChild, indent + 1);
    }
    
//-------------------------- Methods added for Assignment 3, CIT 594-2008
    
    /**
     * Returns the leftmost descendant of this binary tree. That is, return the
     * leaf that is the left child of the left child of ... the left child of
     * this binary tree. If this binary tree has no left child, return this
     * binary tree.
     * 
     * @return The leftmost descendant of this BinaryTree.
     */
    public BinaryTree<V> leftmostDescendant() {
        if (this.leftChild == null) return this;
        else return leftChild.leftmostDescendant();
    }

    /**
     * Returns the rightmost descendant of this binary tree. That is, return the
     * leaf that is the right child of the right child of ... the right child of
     * this binary tree. If this binary tree has no right child, return this
     * binary tree.
     * 
     * @return The rightmost descendant of this BinaryTree.
     */
    public BinaryTree<V> rightmostDescendant() {
        if (this.rightChild == null) return this;
        else return rightChild.rightmostDescendant();
    }

    /**
     * Returns the total number of nodes in this binary tree (include the root
     * in the count).
     * 
     * @return The number of nodes in this BinaryTree.
     */
    public int numberOfNodes() {
        int leftCount = this.leftChild == null ? 0 : leftChild.numberOfNodes();
        int rightCount = this.rightChild == null ? 0 : rightChild.numberOfNodes();
        return 1 + leftCount + rightCount;
    }

    /**
     * Returns the depth of this binary tree. The depth of a binary tree is the
     * length of the longest path from this node to a leaf. The depth of a
     * binary tree with no descendants (that is, just a leaf) is zero.
     * 
     * @return The depth of this BinaryTree.
     */
    public int depth() {
        int leftDepth = this.leftChild == null ? 0 : leftChild.depth() + 1;
        int rightDepth = this.rightChild == null ? 0 : rightChild.depth() + 1;
        return Math.max(leftDepth, rightDepth);
    }

    /**
     * Returns true if and only if some node in this binary tree contains a
     * value that is equal to the parameter.
     * 
     * @param value The value to be searched for.
     * @return <code>true</code> if this BinaryTree contains an equal value.
     */
    public boolean containsEqualValue(V value) {
        if (this.value == null && value == null) return true;
        if (this.value != null && this.value.equals(value)) return true;
        if (leftChild != null && leftChild.containsEqualValue(value)) return true;
        if (rightChild != null && rightChild.containsEqualValue(value)) return true;
        return false;
    }

    /**
     * Returns true if and only if some node in this binary tree contains the same
     * object (not just an equal object) as the one given for the value parameter.
     * 
     * @param value The value to be searched for.
     * @return <code>true</code> if this BinaryTree contains the identical value.
     */
    public boolean containsSameValue(V value) {
        if (this.value == null && value == null) return true;
        if (this.value != null && this.value == value) return true;
        if (leftChild != null && leftChild.containsSameValue(value)) return true;
        if (rightChild != null && rightChild.containsSameValue(value)) return true;
        return false;
    }

    /**
     * Returns a Set of all the leaves of this binary tree. 
     * 
     * @return The leaves of this BinaryTree.
     */
    public Set<BinaryTree<V>> leaves() {
        Set<BinaryTree<V>> set = new HashSet<BinaryTree<V>>();
        if (this.isLeaf()) {
            set.add(this);
        }
        if (leftChild != null) {
            set.addAll(leftChild.leaves());
        }
        if (rightChild != null) {
            set.addAll(rightChild.leaves());
        }
        return set;
    }

    /**
     * Returns a Set of the values (of type V) in this binary tree.
     * 
     * @return The values in this BinaryTree.
     */
    public Set<V> valuesOf() {
        Set<V> values = new HashSet<V>();
        values.add(this.value);
        if (leftChild != null) {
            values.addAll(leftChild.valuesOf());
        }
        if (rightChild != null) {
            values.addAll(rightChild.valuesOf());
        }
        return values;
    }

    /**
     * Returns a List of the values (of type V) in the leaves of this binary tree,
     * in left-to-right order.
     * 
     * @return The values in the leaves of this BinaryTree.
     */
    public List<V> fringe() {
        List<V> values = new ArrayList<V>();
        if (this.isLeaf()) {
            values.add(this.value);
            return values;
        }
        if (leftChild != null) {
            values.addAll(leftChild.fringe());
        }
        if (rightChild != null) {
            values.addAll(rightChild.fringe());
        }
        return values;
    }

    /**
     * Returns a new BinaryTree equal to (but not the same as) this binary tree.
     * Every node in this new BinaryTree will be created by the copy method; values
     * will be identical (==) to values in the given binary tree.
     * 
     * @return An exact copy of this BinaryTree; the values in the new BinaryTree
     *         are == to the values in this BinaryTree.
     */
    public BinaryTree<V> copy() {
        BinaryTree<V> left =  null, right = null;
        if (this.leftChild != null) {
            left = this.leftChild.copy();
        }
        if (this.rightChild != null) {
            right = this.rightChild.copy();
        }
        return new BinaryTree(this.value, left, right);
    }

    /**
     * Returns a new binary tree which is the mirror image of the binary tree whose
     * root is at this binary tree. That is, for every node in the new binary tree,
     * its children are in reverse order (left child becomes right child, right
     * child becomes left child).
     * 
     * @return A mirror image copy of this BinaryTree; values in the new BinaryTree
     *         are == to the values in this BinaryTree.
     */
    public BinaryTree<V> reverse() {
        BinaryTree<V> left =  null, right = null;
        if (this.leftChild != null) {
            left = this.leftChild.reverse();
        }
        if (this.rightChild != null) {
            right = this.rightChild.reverse();
        }
        return new BinaryTree(this.value, right, left);
    }

    /**
     * Rearranges the binary tree rooted at this binary tree to be the mirror image
     * of its original structure. No new BinaryTree nodes are created in this
     * process.
     */
    public void reverseInPlace() {
        if (this.leftChild != null) {
            leftChild.reverseInPlace();
        }
        if (this.rightChild != null) {
            rightChild.reverseInPlace();
        }
        BinaryTree<V> temp = this.leftChild;
        this.setLeftChild(this.rightChild);
        this.setRightChild(temp);
    }
}
