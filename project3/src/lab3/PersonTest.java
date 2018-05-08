package lab3;

public class PersonTest {
	public static void main(String[] args) {
		Person a;
		a = new Person("Chad", 92);
		System.out.println(a.getName());
		System.out.println(a.getAge());
		int length = a.getNameLength();
		System.out.println(length);
	}
}
