import java.util.BitSet;

public class NextBinaryInteger {

	public static void main(String[] args) {
		generateAllBinaryStringsInLexOrder(10);
	}

	private static void generateAllBinaryStringsInLexOrder(int n) {
		BitSet bitSet = new BitSet(n);
		BitSet allOnes = new BitSet();
		allOnes.set(0, n);
		int i = 0;
		while (!bitSet.equals(allOnes)) {
			System.out.println(bitSet.toString());
			i = n-1;
			while (bitSet.get(i)) {
				bitSet.set(i, false);
				i--;
			}
			
			bitSet.set(i);
			
		}
	}

}
