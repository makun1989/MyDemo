
public class TestLoader {
	public static void main(String[] args){
		ClassLoader classLoader=TestLoader.class.getClassLoader();
		System.out.println(classLoader);
		ClassLoader parentLoader=classLoader.getParent();
		System.out.println(parentLoader);
		ClassLoader ppLoader=parentLoader.getParent();
		System.out.println(ppLoader);
	}
}
