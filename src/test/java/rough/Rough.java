package rough;

public class Rough {
	
	public static void main(String[] args) {
		// Math.random() * (max - min + 1) + min
		int fourDigit=(int)(Math.random()*(9999-1000+1)+1000);
		System.out.println(fourDigit);
	}

}
