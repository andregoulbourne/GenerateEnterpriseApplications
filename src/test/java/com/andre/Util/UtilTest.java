package com.andre.Util;

import static com.andre.util.Util.util;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class UtilTest {
	
	@Test
	public void testUtilMethod_firstLetterToLower() {
		String exspectedResult= "andre";
		String result = util.firstLetterToLower("andre");
		assertEquals(exspectedResult, result);
		assertEquals("andre", util.firstLetterToLower("andre"));
		
	}
	
	@Test
	public void testUtilMethod_firstLetterToCapital() {
		String exspectedResult= "andre";
		String result = util.firstLetterToLower("andre");
		assertEquals(exspectedResult, result);
		assertEquals("andre", util.firstLetterToCapital("andre"));
		
	}
	
	
	
	@Test
	public void testUtilMethod_arrayToStringList() {
		String exspectedResult= "\"id\",\"name\"";
		List<String> names = Arrays.asList("id", "name");
		String result = util.arrayToStringList(names);
		assertEquals(exspectedResult, result);
		
	}
	
	@Test
	public void testUtilMethod_scanInList() {
		util.setStrings();
		List<String> strings = Arrays.asList("red", "green", "blue");
		util.scanListInputs();
		assertEquals(strings, util.getStrings() );
	}
	
	@Test
	public void testUtilMethod_scanInList_helperFunction() {
		List<String> strings = Arrays.asList("red", "green", "blue");
		assertEquals(strings, util.makeList());
	}
	
	@Test
	public void testScanInt() {
		System.out.println("Enter a something other that a number, then 12");
		int number = util.scanInt();
		assertEquals(12,number);
	}
	

	@Test
	public void testScanDouble() {
		System.out.println("Enter a something other that a number, then 12.0");
		double number = util.scanDouble();
		System.out.println(number);
		assertTrue(number == 12.0);
	}
	
	@Test
	public void testScanString() {
		System.out.println("Enter an empty string or white space, then andrea");
		String name = util.scanString();
		assertEquals("andrea", name);
	}
	
	@Test
	public void containsWhiteSpace() {
		assertTrue(util.containsWhiteSpace("fhkahf ajfakh"));
		assertFalse(util.containsWhiteSpace("afhakh"));
	}
	
	@Test
	public void getRidOfWhiteSpaceAbsoluteTest() {
		assertEquals(util.getRidOfWhiteSpaceAbsolute("Whats up"),"Whatsup");
		assertEquals(util.getRidOfWhiteSpaceAbsolute("Whatsup"),"Whatsup");
	}
	
	@Test
	public void testMakeListFromString() {
		List<String> list = Arrays.asList("int", "String");
		assertEquals(list, util.makeListFromString("int,String"));
		List<String> list2 = Arrays.asList("int", "String happy");
		assertEquals(list2, util.makeListFromString("int,String happy"));
		List<String> list3 = Arrays.asList("1","01-30-3983","false","Best appointment ever");
		assertEquals(list3, util.makeListFromString("1,01-30-3983,false,Best appointment ever"));
	}
	
	@Test
	public void testputQuotesAndANumber() {
		assertEquals("\"myHera1\",\"cool1\"",util.putQuotesAndANumber("myHera,cool",1));
	}
	
	@Test
	public void testCutTheLastCharacter() {
		assertEquals("he", util.cutLastCharacter("he "));
	}
	
	@Test
	public void testIsALetter() {
		assertTrue(util.isALetter('A'));
		assertTrue(util.isALetter('b'));
		assertFalse(util.isALetter('1'));
	}
	
	@Test
	public void testIsAComma() {
		assertTrue(util.isAComma(','));
		assertFalse(util.isAComma('b'));
		assertFalse(util.isAComma('1'));
	}
	
	@Test
	public void testIsANumber() {
		assertFalse(util.isANumber('A'));
		assertFalse(util.isANumber('b'));
		assertTrue(util.isANumber('1'));
	}
	
	@Test
	public void testIsACommaOrNumberOrLetter() {
		assertTrue(util.isANumberOrCommaOrLetter('A'));
		assertTrue(util.isANumberOrCommaOrLetter('b'));
		assertTrue(util.isANumberOrCommaOrLetter('1'));
		assertTrue(util.isANumberOrCommaOrLetter(','));
	}
	
	@Test
	public void getRidOfWhiteSpaceTest() {
		assertEquals("Whatsup", util.getRidOfWhiteSpace("Whatsup"));
		assertEquals("What sup", util.getRidOfWhiteSpace("     What sup            "));
		assertEquals("Whats", util.getRidOfWhiteSpace("     Whats  "));
		assertEquals("What sup it",util.getRidOfWhiteSpace(" What sup it "));
		assertEquals("What sup it 123,",util.getRidOfWhiteSpace(" What sup it 123,"));
		
	}

}
