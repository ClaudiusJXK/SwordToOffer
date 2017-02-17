package arrayQuery;
/**
 * 
 * @author Claudius
 * 二维数组，每一行都是递增，每一列也为递增，快速判断一个数是否在该二维数组中
 */
public class Query {
	public static void main(String args[]) {
		int [][]array={{0,2,4,6,8,10},{1,3,5,7,9,11},{2,4,6,8,10,12},{3,5,7,9,11,13}};
		int num = 19;
		Query qq=new Query();
		System.out.println(qq.query(array, num));
	}
	/**
	 * 查询该二维数组中是否包含该整数
	 * @param array 二维数组
	 * @param num   整数
	 * @return 若存在，则true，否则false
	 */
	public boolean query(int [][] array,int num ) {
		int ROW_Number=array.length-1;
		int Column_Number=array[0].length-1;
		/**
		 * 从数组右上角开始判断
		 */
		for (int row=0,column=Column_Number;row<=ROW_Number&&column>=0; ) {
			/**
			 * 如果该数小于右上角的值，则最右侧一列都被排除
			 */
			if (num<array[row][column]) {
				column--;
			}
			/**
			 * 如果该数不小于右上角的值，则判断该值与右上角值是否相等，否则该行都小于改数值，将该行排除，行数加1
			 */
			else {
				if (num==array[row][column]) {
					return true;
				}
				row++;
			}
		}
		return false;
	}
}
