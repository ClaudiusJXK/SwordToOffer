package rebuildBinaryTree;
/**
 * 根据前序遍历结果与中序遍历结果，重建二叉树（结果中不包含重复数字）。
 * @author Claudius
 *
 */
public class RebuildTree {
	/**
	 * 重建二叉树函数
	 * @param pre 前序遍历结果
	 * @param middle 中序遍历结果
	 * @return
	 */
	public Tree build(String pre,String middle){
		int length=pre.length();
		if (length>1) {              //节点数大于1个时
			Tree root =new Tree();
			root.setValue(Integer.parseInt(pre.substring(0,1)));
			int index =middle.lastIndexOf(pre.substring(0,1)); //当前根节点位于中序遍历中的位置
			if(index==0){                  //当前根节点位于中序遍历结果的首位，那么在middle中根节点之后、pre中根节点之后的数字属于右子树
				root.setLeft(null);
				root.setRight(build(pre.substring(index+1),middle.substring(index+1)));
			}else if(index==length-1) {    //当前根节点位于中序遍历结果的末位，那么再middle中根节点之前、pre中根节点之后的数字属于左子树
				root.setLeft(build(pre.substring(1, index+1), middle.substring(0,index)));
				root.setRight(null);
			}else {                       //当前根节点位于中序遍历结果的中间
				root.setLeft(build(pre.substring(1, index+1), middle.substring(0,index)));
				root.setRight(build(pre.substring(index+1),middle.substring(index+1)));
			}
			return root;
		}else if (length ==1) {//节点数为1时
			Tree root =new Tree();
			root.setValue(Integer.parseInt(pre.substring(0,1)));
			return root;
		}
		return null;//节点数为0时
	}
	/**
	 * 前序遍历打印
	 * @param root 二叉树根节点
	 */
	public void prePrint (Tree root) {
		if (root!=null) {
			System.out.print(root.getValue());
			prePrint(root.getLeft());
			prePrint(root.getRight());
		}
	}
	/**
	 * 后序遍历打印
	 * @param root 二叉树根节点
	 */
	public void midPrint(Tree root) {
		if (root!=null) {
			midPrint(root.getLeft());
			System.out.print(root.getValue());
			midPrint(root.getRight());
		}
	}
	
	public static  void main(String args []) {
		RebuildTree re=new RebuildTree();
		String pre="12473568";
		String mid="47215386";
		Tree outTree =re.build(pre, mid);
		re.prePrint(outTree);
		System.out.println();
  		re.midPrint(outTree);
		
	}
}





















