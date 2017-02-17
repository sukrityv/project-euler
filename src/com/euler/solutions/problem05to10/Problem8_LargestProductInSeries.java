package com.euler.solutions.problem05to10;

/**
 * The four adjacent digits in the 1000-digit number that have the greatest product are 9 × 9 × 8 × 9 = 5832.
 * Find the thirteen adjacent digits in the 1000-digit number that have the greatest product. What is the value of this product?
 * 
 * @author sukrityv
 *
 */
public class Problem8_LargestProductInSeries {

	public static void main(String[] args) {

		String inputStr = "7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450";
		int seriesLength = 13;
		
		long startTime = System.currentTimeMillis();

		//newMethod(inputStr); -> Shraddha
		
		System.out.println("Result: " + getProduct(inputStr, seriesLength));

		long endTime = System.currentTimeMillis();
		System.out.println("That took " + (endTime - startTime) + " milliseconds");
	}
	
	static long getProduct(String inputStr, int n) {

		long result = 0;
		int index = 1;

		String[] array = inputStr.split("");

		for (int i = 1; i < array.length - n; i++) {
			long temp = 1;
			for (int j = i; j < i + n; j++) {
				temp *= Long.valueOf(array[j]);
			}
			if (temp > result) {
				result = temp;
				index = i;
			}
		}

		System.out.println("Index: " + index);

		return result;
	}
	
	
	static void newMethod(String thousandDigitNumber) {

        int beginInd=0;
        int endInd=13;
        long long13digitNum=0;
        long currProduct=0;
        long largestProdOf13=0;

        while(endInd<=1000)
        {
            String extract13digits=thousandDigitNumber.substring(beginInd,endInd);

            if(extract13digits.indexOf('0') < 0) {
                long13digitNum = Long.parseLong(extract13digits);
                currProduct = MultiplyDigits(long13digitNum);
                if (currProduct > largestProdOf13) {
                    largestProdOf13 = currProduct;
                    System.out.println("Index: " + beginInd);
                    System.out.println("Qualifying Numbers: " + extract13digits);

                }
            }
            beginInd++;
            endInd++;
        }
        System.out.println("Result: " +largestProdOf13);
    }

    public static long MultiplyDigits(long number)
    {
        long digit=1;
        long product=1;

        while(number>0)
        {

            digit=number%10;
            product=product*digit;
            number = number/10;
        }
        return product;
    }
	
}
