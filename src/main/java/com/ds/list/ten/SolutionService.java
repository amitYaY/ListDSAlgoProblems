package com.ds.list.ten;

import java.util.LinkedList;

public class SolutionService {

	// private static String input = " 2- (1 + 2) "; // -1

	// private static String input = "(1+(4+5+2)-3)+(6+8)"; // 23

	// private static String input = "1 + 1"; // 2

	// private static String input = " 22-12 + 22 "; // 32

	// private static String input = "( +48 + -48)"; // 0

	// private static String input = "(1)"; // 1

	// private static String input = "-2+ 1";
	
//	  private static String input =
//	  "(9568+(9040-(380+(2042-(7115)+(6294)-(4395-(5183+9744+(7746-(1099+2718))-(9370-(8561+(9302)-"
//	  +
//	  "(7632+(8451-(1759+(7760))-(3377+5363+9093+(8332-(4492-(1151+(1165-8833+(775+(3749)+9399))+9112+(6273+"
//	  +
//	  "(7285-(6112-(668-(7756-4316-(582+1835-(6644+690+1204-(7197+(7897))+(7009-(7262))-7782-(7858+(7644+(9461+(2224)-"
//	  +
//	  "(7531-1095-(891+1022)+2197-(9855)))+(6663-(7417-(6158-(3610))+(1481))-(4182+(4761)))+(5017))+(9990)+(6218)))-"
//	  +
//	  "(2904)+(5631)-(8888)+3401+(3569))+(1135))-(3695-(7713+(3479)-(9813+(8171+(8616-8026+(4634-(6973))-(9761-(623-4782)+(2514)+(6233)))))+"
//	  +
//	  "(6140))-(6641)-8611+(8389)+8074-(4412))-(3703)+(9688+(9513))))-(4987)))+(9647)))))))))-(2299))-(4785))))))";
	
	// private static String input = "1-(+1+1)";
	
	private static String input = "(5017)+ (3701)";

	public static void main(String[] args) {
		SolutionService service = new SolutionService();
		int result = service.calculate(input.trim());
		System.out.println("Stack: " + stack + " Result: " + result);
	}

	private static LinkedList<String> stack = new LinkedList<>();

	public int calculate(String s) {

		char[] chars = s.toCharArray();
		boolean lastDigit = false;
		boolean lastAirthmeticSign = false;
		for (int i = chars.length - 1; i >= 0; i--) {
			String temp = String.valueOf(chars[i]).trim();
			if (!temp.isEmpty()) {
				if ("(".equals(temp)) {
					if (lastAirthmeticSign) {
						String tempSign = stack.pop();
						temp = tempSign + stack.pop();
						stack.push(temp);
						lastDigit = false;
						lastAirthmeticSign = false;
					}
					evaluateParanthesis();
				} else {
					if ("+".equals(temp) || "-".equals(temp)) {
						if (lastAirthmeticSign) {
							String tempSign = stack.pop();
							if ("-".equals(tempSign) && "+".equals(temp)) {
								temp = tempSign;
							} else if ("-".equals(tempSign) && "-".equals(temp)) {
								temp = "+";
							}
						} else {
							if (i == 0) {
								temp = temp + stack.pop();
							}
						}
						lastAirthmeticSign = true;
						lastDigit = false;
					} else {
						try {
							Integer.parseInt(temp);
							if (lastDigit) {
								temp = temp + stack.pop();
							}
							lastDigit = true;
							lastAirthmeticSign = false;
						} catch (NumberFormatException ex) {
							lastDigit = false;
							lastAirthmeticSign = false;
						}
					}

					stack.push(temp);

				}
			}

		}
		return finalExecution();
	}

	private void evaluateParanthesis() {
		String sign = stack.peek();
		while (true) {
			int a = Integer.valueOf(stack.pop());
			String opr = stack.pop();
			if (")".equals(opr)) {
				stack.push(String.valueOf(a));
				break;
			}
			int b = Integer.valueOf(stack.pop());
			int result = operation(a, b, opr);
			sign = stack.peek();
			if (")".equals(sign)) {
				stack.poll();
				stack.push(String.valueOf(result));
				break;
			}
			stack.push(String.valueOf(result));
		}
	}

	private int finalExecution() {
		if (stack.size() > 1) {
			String sign = stack.peek();
			while (sign != null) {
				int a = Integer.valueOf(stack.pop());
				String opr = stack.pop();
				int b = Integer.valueOf(stack.pop());
				int res = operation(a, b, opr);
				sign = stack.peek();
				stack.push(String.valueOf(res));
			}
		}
		return Integer.parseInt(stack.pop());
	}

	private int operation(int a, int b, String sign) {
		int result = 0;
		if ("+".equals(sign)) {
			result = a + b;
		} else if ("-".equals(sign)) {
			result = a - b;
		}
		return result;
	}

}
