package pkg3.dto;

public class CalculatorRun {
	public static void main(String[] args) {
		
		
		Calculator c = new SSMCalculator();
		
		System.out.println(c.plus(90000000, 3000000));
		System.out.println(c.minus(1, 30));
		System.out.println(c.multi(7000, 123));
		System.out.println(c.div(5555, 444));
		System.out.println(c.mod(1234, 56));
		System.out.println(c.pow(2, 16));
		System.out.println(c.areaOfCircle(5.7));
		System.out.println(c.toBinary(100));
		System.out.println(c.toHexadecimal(100));
		
	}

}
