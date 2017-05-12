package calc;

import java.util.HashMap;

import javax.swing.text.html.MinimalHTMLWriter;

public class Calc {

	Stack<Character> operator = new Stack<Character>();
	Stack<Integer> operand = new Stack<Integer>();

	public void toPostfix(String temp_exp) throws StackException {
		// TODO Auto-generated method stub

		for (int i = 0; i < temp_exp.length(); i++) {
			char c = temp_exp.charAt(i);
			System.out.println("몇번째 도는지 확인 :" + i);
			switch (c) {
			case '+':
				toCompare(c);
				break;
			case '-':
				toCompare(c);
				break;
			case '*':
				toCompare(c);
				break;
			case '/':
				toCompare(c);
				break;
			case '(':
				toCompare(c);
				break;
			case ')':
				toCompare(c);
				break;
			default:
				int temp_c = Character.getNumericValue(c);
				System.out.println("숫자 입력했다.");
				operand.push(temp_c);
			}
		}
		sum_calc();

	}

	private void sum_calc() throws StackException {
		// TODO Auto-generated method stub
		int sum = 0;
		while (operator.size() != 0) {
			char temp;
			temp = operator.pop();
			sum = midium_calc(temp);
		}
		System.out.println(sum);
	}

	public void toCompare(char c) throws StackException {
		HashMap<Character, Integer> compare = new HashMap<Character, Integer>();
		compare.put('(', 0);
		compare.put(')', 0);
		compare.put('+', 1);
		compare.put('-', 1);
		compare.put('/', 2);
		compare.put('*', 2);
		int NewCount = compare.get(c);
		System.out.println("값을 확인하자 :" + NewCount);
		if (NewCount == 0) {
			System.out.println("정상적으로 확인");
			if (c == ')') {
				char s;
				while (true) {
					s = operator.pop();
					if (s == '(') {
						break;
					} else {
						System.out.println(s);
						midium_calc(s);
					}
				}
			} else {
				System.out.println(c + "을 넣어놨어!!!");
				operator.push(c);
			}

		} else {
			if (operator.size() == 0) {
				operator.push(c);
				System.out.println("처음 연산자를 정상적으로 입력하였습니다.");
			} else {
				char temp = operator.pop();
				System.out.println("비교 연산자 : " + temp);

				int count = compare.get(temp);

				System.out.println("값 비교 : " + count);
				System.out.println("값 비교 2 : " + NewCount);

				if (count < NewCount) {
					operator.push(temp);
					operator.push(c);
					System.out.println("Stack에 정상적으로 입력했습니다.");
				} else {
					operator.push(c);
					midium_calc(temp);
					System.out.println("Stack 연산 처리가 정상적으로 되었습니다.");

				}
			}

		}
	}

	private int midium_calc(char temp) {
		// TODO Auto-generated method stub
		int op1 = 0, op2;

		try {
			op2 = operand.pop();
			op1 = operand.pop();

			switch (temp) {
			case '+':
				op1 += op2;
				operand.add(op1);
				break;
			case '-':
				op1 -= op2;
				operand.add(op1);
				break;
			case '*':
				op1 *= op2;
				operand.add(op1);
				break;
			case '/':
				op1 /= op2;
				operand.add(op1);
				break;
			}
			System.out.println("중간 계산 결과 : " + op1);
		} catch (StackException e) {
			e.printStackTrace();
		}
		return op1;
	}

}
