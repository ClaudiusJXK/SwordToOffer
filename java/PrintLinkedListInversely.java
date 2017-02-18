//PrintLinkedListInversely
/**
*从尾到头打印一个链表
*@autor Claudius
*/
Public class PrintLinkedListInversely(){
	public static void main(String [] args){
		
	}
	/**
	*
	* 通过递归调用，先处理后续结点，然后栈返回时再处理当前结点
	*/
	public void print(LList list){
		if(list.nextLList==null){
			print(list.nextLList)
		}
		system.out.println(list.key)
	}
}
Class LList{
	public int key;
	public LList nextLList;
}