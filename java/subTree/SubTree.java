package subTree;
/**
 * 判断一个二叉树是不是另一个二叉树的子树
 * @author Claudius
 *
 */

public class SubTree {
	/**
	 * 判断一个二叉树当前结点是不是与son根节点是否相同，若相同则进行子树比较
	 * @param father
	 * @param son
	 * @return
	 */
	public boolean compareTree(BinaryTreeNode father,BinaryTreeNode son){
		/**
		 * 如果son为空，则直接返回true
		 */
		if (son == null ) {
			return true;
		}
		/**
		 * 如果son不为空但是father为空，则直接返回falase
		 */
		if (father == null) {
			return false;
		}
		/**
		 * 如果二者值相等，则进行子树比较，否则将father的leftson与rightson与son继续进行递归比较
		 */
		if (father.value == son.value) {
			/**
			 * 子树比较
			 */
			if (compareSubTree(father, son)) {
				return true; 
			}
		}
		/**
		 * 满足一个就正确
		 */
		boolean left= compareTree(father.leftSon, son);
		if (left) {
			return true;
		}
		boolean right = compareTree(father.rightSon, son);
		if(right)
			return true;
		return false;
	}
	/**
	 * 子树比较，遍历两个根节点相同的树，看子树是不是在父树上
	 * @param father
	 * @param son
	 * @return
	 */
	public boolean compareSubTree(BinaryTreeNode father,BinaryTreeNode son){
		/**
		 * 子树遍历到最后结点，无论父树是否为空，都为true
		 */
		if (son==null) {
			return true;
		}else if (father == null) {           //子树不为空，但是父树为空，返回false
			return false;
		} else {
			if (father.value == son.value) {  //如果二者相等，则继续比较其左右子树
				boolean left = compareSubTree(father.leftSon, son.leftSon);
				if (!left) {                  //左子树不等，直接返回false
					return false;
				}
				boolean right =compareSubTree(father.rightSon, son.rightSon);
				if (right) {                  //左右子树均相等，返回true
					return true;
				}
			}
			return false;                    // 二者值不等,false
		}
	}
	public static void main(String [] args) {
		SubTree tree = new SubTree();
		BinaryTreeNode father = new BinaryTreeNode(8); 
		BinaryTreeNode fatherSon2 = new BinaryTreeNode(8);
		BinaryTreeNode fatherSon3 = new BinaryTreeNode(7);
		father.leftSon= fatherSon2;
		father.rightSon = fatherSon3;
		BinaryTreeNode fatherSon4 = new BinaryTreeNode(9);
		BinaryTreeNode fatherSon5 = new BinaryTreeNode(2);
		fatherSon2.leftSon = fatherSon4;
		fatherSon2.rightSon = fatherSon5;
		BinaryTreeNode fatherSon6 = new BinaryTreeNode(4);
		BinaryTreeNode fatherSon7 = new BinaryTreeNode(7);
		fatherSon5.leftSon = fatherSon6;
		fatherSon5.rightSon = fatherSon7;
		BinaryTreeNode son = new BinaryTreeNode(8);
		son.leftSon = new BinaryTreeNode(9);
		son.rightSon = new BinaryTreeNode(2);
		
		System.out.println(tree.compareTree(father, son));
	}
}
