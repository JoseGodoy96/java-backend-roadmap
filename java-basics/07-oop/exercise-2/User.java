public class User {
	
	String 	name;
	int 	age;

	User(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public void hello() {
		System.out.println(name + " - " + age);
	}
}
