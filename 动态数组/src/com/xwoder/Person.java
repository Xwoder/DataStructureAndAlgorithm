/**
 * 
 */
package com.xwoder;

/**
 * @author Xwoder
 *
 */
public class Person {

	private String name;
	private int age;

	/**
	 * @param name
	 * @param age
	 */
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	@SuppressWarnings("deprecation")
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
		System.out.println(this + ", Person.finalize()");
	}
	
	@Override
	public boolean equals(Object obj) {
		Person p = (Person) obj;
		if (age == p.age && name == p.name) {
			return true;
		} else {
			return false;
		}
	}
}
