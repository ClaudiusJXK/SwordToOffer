package replaceSpace;
/**
 * 
 * @author Claudius
 *将字符串中的空格全部替换为%20
 */
public class RepalceSpace {
	public static  void main(String[]args) {
		RepalceSpace rr=new RepalceSpace();
		System.out.println(rr.replace("ad aa  asd aw www   wwr"));
	}
	public String replace (String str) {
		String []strings=str.split(" ");
		int length =strings.length;
		StringBuilder newString =new StringBuilder();
		for(int i=0;i<length;i++){
			if (strings[i]!=" ") {
				newString.append(strings[i]).append("%20");
			}
			else {
				newString.append("%20");
			}
		}
		return newString.toString();

	}
}
