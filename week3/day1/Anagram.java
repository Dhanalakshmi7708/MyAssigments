package week3.day1;

import java.util.Arrays;

public class Anagram {

	public static void main(String[] args) {
		// define the strings
 
		String text1 = "stops";
		String text2 = "potss";

		if (text1.length() != text2.length()) {

			System.out.println("Lengths mismatch, therefore the strings are not an Anagram");
		}

		char[] CharArray1 = text1.toCharArray();
		char[] CharArray2 = text2.toCharArray();

		Arrays.sort(CharArray1);
		Arrays.sort(CharArray2);

		if (Arrays.equals(CharArray1, CharArray2)) {

			System.out.println("The given strings are Anagram");

		}

		else {
			System.out.println("The given strings are not an Anagram");
		}

	}

}
