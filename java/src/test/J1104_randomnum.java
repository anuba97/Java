package test;

import java.util.Scanner;

public class J1104_randomnum {
	public static void main(String[] args) {
		// 1-100까지 랜덤숫자 맞추기 게임
		// user 입력한 값도 출력을 하시오.
		// [출력]
		// 1.랜덤숫자
		// 2.총 도전횟수
		// 3.입력한 숫자

		int[] num = new int[10];
		int count = 0;
		int r_num = (int) (Math.random() * 100);
		int[] num2=new int[10];

		Scanner scan = new Scanner(System.in);

		while (count < 10) {
			System.out.println("번호를 입력하세요");
			num[count] = scan.nextInt();
			if (r_num == num[count]) {
				System.out.println("맞췄습니다!");
				System.out.println("RD.N: " + r_num);
				System.out.println("my: " + num[count]);
				System.out.println("count: " + (count+1));
				break;

			} else if (r_num < num[count]) {
				System.out.println("down");
			} else {
				System.out.println("up");
			} // if
			count++;
			
		} // while
		for(int i=0;i<count;i++) {
			System.out.print("history: ");
			System.out.printf("%d \n",num[i]);
		}
		

	}// main
}// class