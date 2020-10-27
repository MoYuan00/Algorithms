package 分治法;

/**
 * 二叉查找树
 * @author Rnti
 *
 * @param <T>
 */
public class BinarySearchTree<T extends Comparable<T>>{
	/**
	 * 定义树的结点数据结构
	 * @author Rnti
	 *
	 * @param <T>
	 */
	public static class TreeNode<T>{
		public T data = null;
		TreeNode(T data){this.data = data;}
		public TreeNode<T> lChild = null, rChild = null, parent = null;
	}
	private TreeNode<T> treeHead = null;
	/**
	 * 将k添加到树上
	 * @param k
	 * @return
	 */
	public boolean add(T k) {
		TreeNode<T> p = treeHead;
		TreeNode<T> pre = null;
		int cmp = 0;
		while(p != null) {
			cmp = p.data.compareTo(k);
			if(cmp == 0) return false;// if k equals data of p, can not add into this tree. because key is unique all the node of tree
			pre = p;
			if(cmp > 0) {// p > k. if data of p bigger than k, next we goto left area
				p = p.lChild;
			}else {
				p = p.rChild;
			}
		}
		p = new TreeNode<T>(k);// 创建新节点
		// 这里只能用p的父节点来添加p, p = new Node，并不能改变原有树中结点指向(p only is a point copy, not ref of c++)
		if(pre == null) {// 如果父节点为null，表明树为null
			this.treeHead = p;
			return true;
		}
		if(cmp > 0) {
			pre.lChild = p;
			p.parent = pre;
		}else {
			pre.rChild = p;
			p.parent = pre;
		}
		return true;
	}
	/**
	 * 获取到k的最后左下的结点
	 * @param k
	 * @return
	 */
	private TreeNode<T> getLastLeftChild(TreeNode<T> k){
		while(k.lChild != null)
			k = k.lChild;
		return k;
	}
	/**
	 * 获取到k的最后右下的结点
	 * @param k
	 * @return
	 */
	private TreeNode<T> getLastRightChild(TreeNode<T> k){
		while(k.rChild != null)
			k = k.rChild;
		return k;
	}
	/**
	 * 删除结点k
	 * @param k
	 * @return
	 */
	private boolean del(TreeNode<T> k) {
		if(k == null) throw new RuntimeException("待删除结点k为null");
		// 1. 既有左孩子又有右孩子
		if(k.lChild != null && k.rChild != null) {
			TreeNode<T> p = getLastLeftChild(k.rChild);// 获取k结点的直接后继
			T t = k.data;// 交换k和p的值
			k.data = p.data;
			p.data = t;
			k = p;// （接下来删除p即可）
		}
		// 2. 只有左孩子或者右孩子
		if(k.lChild != null || k.rChild != null) {
			if(k.lChild != null) {// 只有左孩子，直接将此节点删除，然后父节点链接左孩子即可
				k.parent = k.lChild;
				k.lChild = null;
			}else {
				k.parent = k.rChild;// 同左孩子，链接右孩子即可
				k.rChild = null;
			}
		}else {
		// 3. 如果左右孩子都没有（为叶子结点）直接删除（将指向k的父节点指针指为null即可）
			if(k.parent.lChild.data.compareTo(k.data) == 0) k.parent.lChild = null;
			else k.parent.rChild = null;
		}
		return true;
	}
	/**
	 * 删除树中key为k的结点
	 * @param k
	 * @return
	 */
	public boolean del(T k) {
		return this.del(this.get(k));
	}
	/**
	 * 获取到key为k的结点
	 * @param k
	 * @return 返回结点 or null
	 */
	public TreeNode<T> get(T k) {
		TreeNode<T> t = treeHead;
		int cmp = 0;
		while(t != null) {
			cmp = t.data.compareTo(k);
			if(cmp == 0) return t;
			if(cmp > 0) t = t.lChild;
			else t = t.rChild;
		}
		return t;
 	}
	/**
	 * inordal traversal(中序遍历)
	 * @param p
	 */
	private void dfs_(TreeNode<T> p) {
		if(p == null) return;
		dfs_(p.lChild);
		System.out.print(p.data.toString() + ",");
		dfs_(p.rChild);
	}
	/**
	 * 有序显示二叉查找树
	 */
	public void show() {
		System.out.print("{");
		dfs_(this.treeHead);
		System.out.println("}");
	}
	
	public static void main(String[] args) {
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		bst.add(5);
		bst.add(3);
		bst.add(7);
		bst.show();
		
		bst.del(3);
		bst.show();
		
		bst.add(6);
		bst.add(4);
		bst.add(8);
		bst.show();
		
		bst.del(4);
		bst.del(7);
		bst.show();
	}
}