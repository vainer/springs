package vainerv.tutorial.spring.mongos.misc;

import org.testng.annotations.Test;

import java.util.Arrays;

public class UtilTest {
	
	@Test
	public void tesdtReverseWords() {
		String str = "this is java";
		char[] charArray = str.toCharArray();
		System.out.println(Arrays.toString(charArray));
		System.out.println(reverseWord(charArray));
	}
	
	public static char[] reverseWord(char[] values) {
		int origArrayLength = values.length;
		char[] result = new char[origArrayLength];
		for (int i = origArrayLength - 1, j = 0; i >= 0 ; i--) {
			result[j] = values[i];
			j++;			
		}
		return result;
	}
	
	
	
	
	@Test
	public void testReverseWordByRange() {
		String title = "this is some";
		char[] reverseWordByRange = reverseWordByRange(title.toCharArray(), title.length() - 5, title.length() - 1);
		System.out.println(Arrays.toString(reverseWordByRange));		
	}
	
	
	public static char[] reverseWordByRange(char[] values, int fromIndex, int toIntex) {
		char[] result = new char[toIntex - fromIndex];
		for (int i = toIntex, j = 0; i > fromIndex ; i--) {
			result[j] = values[i];
			j++;			
		}
		return result;
	}
	
	
	@Test
	public void testReverseWords() {
		char[] array = "this is test".toCharArray();
		System.out.println(Arrays.toString(array));
		char[] reverseWords = reverseWords(array);
		System.out.println(Arrays.toString(reverseWords));
	}
	
	
	
	public static char[] reverseWords(char[] array) {
		int origArrayLength = array.length;
		char[] result = new char[origArrayLength];
		
  	int currentToIndex = origArrayLength - 1;
		for (int i = origArrayLength - 1, k = 0; i >=0; i--) {
			if (array[i] == ' ' || i == 0) {
				int j = (i !=0) ? i+1 : i;
				for ( ; j <= currentToIndex; j++) {
					result[k] = array[j]; 
							k++;
				}
				
				if (i != 0) {
					result[k] = array[i];					
					k++;
				}
				currentToIndex = i-1;
			}
		}
		return result;
	}
 
}
