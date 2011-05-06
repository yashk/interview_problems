import java.util.ArrayList;
import java.util.List;

public class Greplin {

	public static void main(String[] args) {
		String input = "FourscoreandsevenyearsagoourfaathersbroughtforthonthiscontainentanewnationconceivedinzLibertyanddedicatedtothepropositionthatallmenarecreatedequalNowweareengagedinagreahtcivilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
		String input1="I like racecars that go fast";
		String input2 = "Yashodhan";
		//System.out.println(substring(input, 4));
		System.out.println(longestPalindromeSubtring(input));
	}

	private static String longestPalindromeSubtring(String input) {
		for (int i = input.length() - 1; i > 0; i--) {
			List<String> subStringsOfLengthI = substring(input, i);
			//System.out.println(subStringsOfLengthI);
			for (String subString : subStringsOfLengthI) {
				System.out.print(".");
				if (isPalindrome(subString)) {
					return subString;
				}
			}
		}
		
		return "no substring is palindrome";
	}

	static boolean isPalindrome(String input) {
		String reverse = reverse(input);
		return reverse.equals(input);
	}

	private static String reverse(String input) {
		StringBuilder builder = new StringBuilder(input);
		return builder.reverse().toString();
	}

	private static List<String> substring(String input, int subStringlength) {
		int inputLength = input.length();
		List<String> result = new ArrayList<String>();
		for (int i = 0; i < (inputLength - subStringlength) + 1; i++) {
			result.add(input.substring(i,subStringlength+i));
		}

		return result;
	}

}
