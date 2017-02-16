package Singleton;
/**
 * 
 * @author Claudius
 * 创建单例模式，下面为双重检测方法。
 * SingleTon被定义为volatile 是因为在15 行赋值的过程中，可能会出现赋值一般然后被别的函数拿去用
 */
public class SingleTon {
	private SingleTon () {}
	private static volatile SingleTon Single ;
	
	public  static SingleTon getSingleTon(){
		if (Single ==null) {
			synchronized (SingleTon.class) {
				if (Single!=null) {
					Single= new SingleTon();
				}
			}
		}
		return Single;
	}
}
/**
 * 
 * @author Claudius
 * 使用静态内部类创建单例模式，使用了类的加载过程中的线程安全性。
 */
class SingleTon2{
	private SingleTon2 () {}
	/**
	 * 
	 * @author Claudius
	 * 这个类持有单例模式
	 */
	private static class Inner{
		private static  final SingleTon2 single =new SingleTon2();
	}
	/**
	 * 
	 * @return
	 * 返回单例
	 */
	public static final SingleTon2 getSingleTon2() {
		return Inner.single;
	}
}













