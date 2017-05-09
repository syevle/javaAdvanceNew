package javaPractice.java8.Java_Best_Practices_Java8.lamda.Example3.waypractice;

import java.util.List;

public class RoboContactAnon {

	public void phoneContacts(List<Person> pl, MyTest<Person, Person> aTest) {
		for (Person p : pl) {
			if (aTest.test(p, p)) {
				roboCall(p);
			}
		}
	}

	public void roboCall(Person p) {
		System.out.println("Calling " + p.getSurName() + " " + p.getSurName() + " age ");
	}

}
