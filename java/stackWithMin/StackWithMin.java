package stackWithMin;

public class StackWithMin {
	private Node top;
	public int  getMin() {
		if (top!=null) {
			return top.min;
		}else {
			return Integer.MIN_VALUE;
		}
	}
	public void add(int value){
		Node node = new Node(value);
		if (top == null) {
			top = node;
			top.min = node.value;
		}else {
			top.next = node;
			node.pre = top;
			if (node.value<top.min) {
				node.min = node.value;
			}else {
				node.min = top.min;
			}
			top = node;
		}
	}
	public Node pop() {
		if (top == null) {
			return null;
		}else {
			Node node = top;
			top = top.pre;
			return node;
		}
	}
	public static void main(String [] args) {
		StackWithMin stackWithMin = new StackWithMin();
		for(int i =1;i<10;i++){
			stackWithMin.add(i);
		}
		for(int i =1;i<10;i++){
			System.out.println(stackWithMin.pop().value);
			System.out.println(stackWithMin.getMin());
		}
	}
}
