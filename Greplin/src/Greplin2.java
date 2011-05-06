
public class Greplin2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//System.out.println(isPrime(7919l));
		//System.out.println(sumOfPrimeDivisors(12));
		long fibNo = 0;
		System.out.println(fibNo=generatedFibo());
		System.out.println(isPrime(fibNo));
		System.out.println(sumOfPrimeDivisors(fibNo+1));
	}

	
	public static boolean isPrime(long input){
		if(input==2 || input==3) return true;
		if(input%2 == 0) return false;
		
		for(int i=3;i<=Math.sqrt(input);i=i+2){
			if(input%i==0){
				return false;
			}
		}
		
		return true;
	}
	
	public static long sumOfPrimeDivisors(long input){
		long sum=0;
		
		for(long i=2;i<=input/2;i++){
			if(isPrime(i) && input%i ==0){
				sum=sum+i;
			}
		}
		
		return sum;
	}
	
	public static long generatedFibo(){
		long first = 1;
		long second =1;
        long next =0;		
		while(true){
			next = first+second;
			if(next > 227000l && isPrime(next)){
				return next;
			}
			System.out.print(".");
			first = second;
			second = next;
		}
		
	}
}
