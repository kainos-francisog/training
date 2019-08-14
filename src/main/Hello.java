package main;

import main.data.Employee;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Hello {

	static Logger log = Logger.getLogger("");

	private static void setupLog() {
		try{
			log.setLevel(Level.INFO);
			Handler h = new FileHandler("%h/Hello-%g.log", 1000, 5, true);
			log.addHandler(h);
		} catch (IOException e) {
			System.err.println("IOException opening log file: " + e);
		}
	}

	public static void main(String[] args) {

		setupLog();

		Employee emp1 = new Employee(10);
		Employee emp2 = new Employee(12);


		emp1.setNumber(10);
		emp1.setName("Jeremy Smyth");
		emp1.setSalary(15000f);

		emp2.setNumber(12);
		emp2.setName("Matthew O'Reilly");
		emp2.setSalary(10000f);

    System.out.println(emp1);
    System.out.println(emp2);
	}

}
