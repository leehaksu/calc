package calc;

import java.util.Scanner;

public class CalcMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calc calc=new Calc();

		System.out.print("계산할 식을 넣어 주세요 :");
		Scanner sc = new Scanner(System.in);
		String exp = sc.nextLine();
		String temp_exp = exp.replaceAll(" ", "");
		try {
			calc.toPostfix(temp_exp);
		} catch (StackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	

}
