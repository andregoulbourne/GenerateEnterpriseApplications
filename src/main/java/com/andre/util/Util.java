package com.andre.util;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Util {

	public static final Util util = new Util();

	public String firstLetterToLower(String entity) {
		if (entity.length() == 0) {
			System.out.println("This entity is to short it has to be greaterthan zero");
		}
		String result = "";
		for (int i = 0; i < entity.length(); i++) {
			if (i == 0) {
				result += (entity.charAt(i) + "").toLowerCase();
			} else {
				result += entity.charAt(i);
			}
		}
		return result;
	}

	public String firstLetterToCapital(String entity) {
		if (entity.length() == 0) {
			System.out.println("This entity is to short it has to be greaterthan zero");
		}
		String result = "";
		for (int i = 0; i < entity.length(); i++) {
			if (i == 0) {
				result += (entity.charAt(i) + "").toUpperCase();
			} else {
				result += entity.charAt(i);
			}
		}
		return result;
	}

	public String arrayToStringList(List<String> list) {
		String intermediateResult = "";
		for (String string : list) {
			intermediateResult += "\"" + string + "\",";
		}
		String result = "";
		for (int i = 0; i < intermediateResult.length() - 1; i++) {
			result += intermediateResult.charAt(i);
		}
		return result;
	}

	private List<String> strings;

	public int scanInt() {
		try {
		Scanner in = new Scanner(System.in);
		int number = in.nextInt();
		return number;
		} catch(InputMismatchException e) {
			System.out.println("Sorry, Invalid input");
			System.out.println("Try again");
		}
		return scanInt();
	}

	public double scanDouble() {
		try {
			Scanner in = new Scanner(System.in);
			double number = in.nextDouble();
			return number;
			} catch(InputMismatchException e) {
				System.out.println("Sorry, Invalid input");
				System.out.println("Try again");
			}
			return scanDouble();
	}

	public String scanString() {
			Scanner in = new Scanner(System.in);
			String string = in.nextLine();
			return getRidOfWhiteSpace(string);
	}

	public void setStrings() {
		this.strings = new ArrayList<String>();
	}

	public List<String> getStrings() {
		return strings;
	}

	public void scanListInputs() {
		System.out.println("Enter 1 to add to the list, 2 once you finished and 3 to start over");
		List<String> newListString = new ArrayList<String>(strings);
		int a = scanInt();
		if (a == 1) {
			System.out.println("Enter a string to place in the list");
			String string = scanString();
			newListString.add(string);
			System.out.println(newListString);
			this.strings = newListString;
			scanListInputs();
		} else if (a == 2) {
			System.out.println("The list you made is " + newListString);
			return;
		} else if (a == 3) {
			setStrings();
			System.out.println("Now the list is "+ strings);
			scanListInputs();
		} else {
			System.out.println("Invalid Input");
			scanListInputs();
		}

	}

	public List<String> makeList() {
		setStrings();
		scanListInputs();
		return getStrings();
	}
	
	public boolean containsWhiteSpace(String string) {
		if(string.contains(" ")) return true;
		else return false;
	}
	
	private String result = "";
	private String whiteSpace = " ";
	private char whiteSpaceCharacter = whiteSpace.charAt(0);
	
	public String getRidOfWhiteSpaceAbsolute(String string) {
		if(containsWhiteSpace(string)) {
			for(int i=0; i<string.length(); i++) {
				if(string.charAt(i) != whiteSpaceCharacter) result+=string.charAt(i);
			}
		} else {
			return string;
		}
		
		return result;
	}
	
	public String getRidOfWhiteSpace(String string) {
		if(containsWhiteSpace(string)) {
			boolean flag = false;
			int count_whitespace = 0;
			for(int i=0; i<string.length(); i++) {
				if(isANumberOrCommaOrLetter(string.charAt(i)) && flag == false) {
					flag = true;
					count_whitespace = 0;
				}
				if(count_whitespace > 1 && flag) break;
				if(whiteSpaceCharacter == string.charAt(i) && flag) count_whitespace +=1;
				if(flag && isANumberOrCommaOrLetter(string.charAt(i)) || count_whitespace == 1) {
					result += string.charAt(i);
					if(count_whitespace != 0 && isANumberOrCommaOrLetter(string.charAt(i))) count_whitespace = 0;
				}	
			}
			
		} else {
			return string;
		}
		String myAnswer = result;
		result = "";
		if(myAnswer.charAt(myAnswer.length()-1)==whiteSpaceCharacter) return cutLastCharacter(myAnswer);
		return myAnswer;
	}
	
	public boolean isALetter(char a) {
		String key = "abcdefghijklmnopqrstuvwxyz";
		String string = ""+a;
		if(key.contains(string.toLowerCase())) return true;
		return false;
	}
	
	public boolean isANumber(char a) {
		String key = "0123456789";
		String string = ""+a;
		if(key.contains(string)) return true;
		return false;
	}
	
	public boolean isAComma(char a) {
		if(a == ',') return true;
		return false;
	}
	
	public boolean isANumberOrCommaOrLetter(char a) {
		if(isALetter(a)) return true;
		if(isANumber(a)) return true;
		if(isAComma(a)) return true;
		return false;
	}
	
	public List<String> makeListFromString(String string){
		List<String> list = new ArrayList<String>();
		String result="";
		for(int i=0; i<string.length(); i++) {
			if(string.charAt(i) == ',') {
				list.add(result);
				result="";
			} else {
				result+=string.charAt(i);
				if(i == string.length() - 1) list.add(result);
			}
		}
		
		return list;
	}
	
	public String putQuotesAndANumber(String string, int number) {
		String result ="\"";
		for(int i = 0; i<string.length();i++) {
			if(string.charAt(i)==',') {
				result+= number+"\",\"";
			} else result += string.charAt(i);
		}
		result += number+"\"";
		return result;
	}
	
	
	public String cutLastCharacter(String string) {
		String result = "";
		for(int i=0; i<string.length()-1; i++) {
			result+=string.charAt(i);
		}
		return result;
	}
}
