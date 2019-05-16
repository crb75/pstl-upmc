package q;

public class C{
	private A a;
	private B b;

	public C(){
		a = new A(3);
		b = new B(6);
	}

	public int mc(){
		System.out.printl(""+a.ma2());
		b.mb();
		return a.ma2();
	}
}