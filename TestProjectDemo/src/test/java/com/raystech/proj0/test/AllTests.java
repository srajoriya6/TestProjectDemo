package com.raystech.proj0.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import junit.framework.TestSuite;

@RunWith(Suite.class)
@SuiteClasses({ CollegeServiceTestcase.class })
public class AllTests {
	public static TestSuite getSuite() {
		TestSuite suite = new TestSuite("Test All");
		// suite.addTestSuite(CollegeServiceTestcase.class);
		// suite.addTestSuite((UserServiceTestcase.class);
		return suite;
	}

	/*public static void main(String[] args) {
		System.out.println("Start suite");
		junit.textui.TestRunner.run(getSuite());
		System.out.println("END SUITE");
	}*/

}
