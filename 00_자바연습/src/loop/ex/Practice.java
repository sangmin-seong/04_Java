package loop.ex;

import java.util.Scanner;

public class Practice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean repeat = true;

        while (repeat) {
            System.out.print("첫 번째 숫자 입력: ");
            int num1 = sc.nextInt();

            System.out.print("두 번째 숫자 입력: ");
            int num2 = sc.nextInt();

            System.out.print("+, -, *, /, % 중 연산자를 선택하세요: ");
            char operator = sc.next().charAt(0);

            double result = 0;

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;

                case '-':
                    result = num1 - num2;
                    break;

                case '*':
                    result = num1 * num2;
                    break;

                case '/':
                    if (num2 != 0) {
                        result = (double) num1 / num2;
                    } else {
                        System.out.println("0으로 나눌 수 없습니다.");
                        break;
                    }
                    break;

                case '%':
                    if (num2 != 0) {
                        result = num1 % num2;
                    } else {
                        System.out.println("0으로 나눌 수 없습니다.");
                        break;
                    }
                    break;

                default:
                    System.out.println("잘못된 연산자입니다.");
                    break;
            }

            System.out.println("결과: " + result);

            System.out.print("계속해서 계산하시겠습니까? (Y/N): ");
            char choice = sc.next().charAt(0);
            if (choice != 'Y'&& choice != 'y') {
                repeat = false;
            }
        }

        System.out.println("프로그램을 종료합니다.");
        sc.close();
    }
}