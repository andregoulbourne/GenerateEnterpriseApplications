package com.andre;

import org.junit.Before;
import org.junit.Test;

import com.andre.Driver;

public class DriverTest {
	
	Driver driver;
	
	@Before
	public void setup() {
		this.driver = new Driver();
	}
	
	@Test
	public void testSwitchInputedWith1() {
		Driver.run();
		
	}
	
	@Test
	public void testSwitchInputedWith2() {
		
	}
	
	

}
