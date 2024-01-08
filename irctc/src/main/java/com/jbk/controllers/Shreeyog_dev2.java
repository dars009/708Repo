package com.jbk.controllers;

public class Shreeyog_dev2 {

	class Employee {
		float salary = 40000;
	}

	class Programmer extends Employee {
		int bonus = 10000;

		public void main(String args[]) {
			Programmer p = new Programmer();
			System.out.println("Programmer salary is:" + p.salary);
			System.out.println("Bonus of Programmer is:" + p.bonus);
		}
	}
}
