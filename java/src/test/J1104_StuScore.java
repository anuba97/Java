package test;

import java.util.Scanner;

public class J1104_StuScore {

	public static void main(String[] args) {

		String[] title = { "이름", "국어", "영어", "수학", "총합", "평균", "등수" };
		int[][] score = new int[10][3];
		String[] name = new String[10];
		int[] total = new int[10];
		double[] avg = new double[10];
		int[] rank = new int[10];
		int checkNo = 0;
		String check = "";
		int count = 0;
		int choice = 0;
		int r_count = 0;
		int flag = 0;

		Scanner scan = new Scanner(System.in);
		loop: while (true) {
			System.out.println("[[학생 성적 처리기]]");
			System.out.println("1.성적 입력");
			System.out.println("2.성적 출력");
			System.out.println("3.성적 수정");
			System.out.println("4.등수 기입");
			System.out.println("0.종료");
			System.out.println("--------------------------");
			System.out.println("원하는 항목의 번호를 입력하세요.");
			System.out.println();

			choice = scan.nextInt();

			switch (choice) {
			case 1:
				System.out.println("[[성적입력]]");

				while (count < 10) {
					System.out.println((count + 1) + "번째이름(0.취소)");
					check = scan.next();
					if (check.equals("0")) {
						System.out.println("이전화면으로 돌아갑니다.");
						break;
					} // if

					name[count] = check;

					for (int j = 0; j < 3; j++) {
						System.out.printf("%s점수를 넣으시요", title[j + 1]);
						score[count][j] = scan.nextInt();
						total[count] = score[count][0] + score[count][1] + score[count][2];
						avg[count] = total[count] / 3.0;

					} // for
					count++;
				} // while
				break;
			case 2:
				System.out.println("[[성적 출력]]");
				System.out.printf("이름\t국어\t영어\t수학\t총합\t평균\t등수\n");
				System.out.println("---------------------------------------------");
				for (int i = 0; i < count; i++) {
					System.out.printf("%s \t %d \t %d \t %d \t %d \t %.2f\t%d\n", name[i], score[i][0], score[i][1],
							score[i][2], total[i], avg[i], rank[i]);
				} // for
				break;
			case 3:
				System.out.println("[[ 성적 수정 ]]");
				System.out.println("수정할 학생의 이름을 입력하세요");
				check = scan.next();
				for (int i = 0; i < count; i++) {
					if (check.equals(name[i])) {
						System.out.printf("%s의학생이 검색되었습니다", name[i]);
						System.out.println();
						checkNo = i;
						flag = 1;
						break;
					} // if
				} // for
				if (flag == 0) {
					System.out.println("해당학생 이름이 없습니다, 다시 확인하세요");
				}
				flag = 0;
				System.out.printf("[%s의 학생성적수정]\n", name[checkNo]);
				System.out.println("[[1.국어 수정]");
				System.out.println("[[2.영어 수정]]");
				System.out.println("[[3.수학 수정]]");
				System.out.println("[[0.취소]]");
				System.out.println("----------------------------");
				System.out.println("수정할 과목을 선택하세요");
				choice = scan.nextInt();

				if (choice == 0) {
					System.out.println("이전페이지로...");
				}
				System.out.printf("현재 %s점수: %d\n", title[choice], score[checkNo][choice - 1]);
				System.out.printf("바꿀 %s점수: ", title[choice]);
				score[checkNo][choice - 1] = scan.nextInt();
				total[checkNo] = score[checkNo][0] + score[checkNo][1] + score[checkNo][2];
				avg[checkNo] = total[checkNo] / 3.0;
				System.out.printf("%s점수가 %d로바뀌였습니다.", title[choice], score[checkNo][choice - 1]);

				break;
			case 4:
				System.out.println("[[등수 기입]]");
				for (int i = 0; i < count; i++) {
					r_count = 1;
					for (int j = 0; j < count; j++) {
						if (total[i] < total[j]) {
							r_count++;
						} // if
					} // for
					rank[i] = r_count;
				} // for
				System.out.println("등수처리 완료");
				System.out.println();
				break;

			case 0:
				System.out.println("시스템을 종료합니다");
				System.out.println();
				break loop;

			}// switch
		} // while
		System.out.println("종료되었습니다");
	}// main
}// class
