package com.xwoder;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyArrayList<Integer> arrayList1 = new MyArrayList<Integer>();
		
		arrayList1.add(10);
		arrayList1.add(20);
		arrayList1.add(30);
		arrayList1.add(40);
		arrayList1.add(50);
		System.out.println(arrayList1);
		
		arrayList1.remove(2);
		System.out.println(arrayList1);
		
		arrayList1.remove(2);
		System.out.println(arrayList1);
		
		arrayList1.remove(arrayList1.size() - 1);
		System.out.println(arrayList1);
		
		arrayList1.add(-10, 1);
		System.out.println(arrayList1);
		
		arrayList1.add(-20, arrayList1.size());
		System.out.println(arrayList1);
		
		arrayList1.add(20, arrayList1.size() - 1);
		System.out.println(arrayList1);
		
		
		System.out.println("----------");
		arrayList1.clear();
		System.out.println(arrayList1);
		
		for (int i = 0; i < 10; i++) {
			try {
				arrayList1.add((i + 1) * 10);
				System.out.println(arrayList1);
			} catch (Exception e) {
				break;
			}
		}
		
		System.out.println("----------");
		
		MyArrayList<Integer> arrayList2 = new MyArrayList<Integer>();
		for (int i = 0; i < 16; i++) {
			arrayList2.add((i + 1) * 10);
			System.out.println(arrayList2);
		}
		
		System.out.println("----------");
		
		MyArrayList<Person> arrayList3 = new MyArrayList<Person>();
		Person p1 = new Person("P1", 10);
		Person p2 = new Person("P2", 20);
		Person p3 = new Person("P3", 30);
		arrayList3.add(p1);
		arrayList3.add(p2);
		arrayList3.add(null);
		arrayList3.add(p3);
		System.out.println(arrayList3);
		
		p1 = null;
		p2 = null;
		p3 = null;
		
		arrayList3.remove(1);
		System.gc();
		
		arrayList3.clear();
		System.gc();
	}

}
