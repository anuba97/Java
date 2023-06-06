package test;

import java.util.Scanner;

public class J1104_lotto {

	public static void main(String[] args) {
		// 1. 45개의 배열을 만들기
		int[] lotto = new int[45];
		int[] input = new int[6];
		int count = 0;
		int[] l_no=new int[6];
		int num=0;
		Scanner scan = new Scanner(System.in);

		// 2. 1-45숫자를 배열에 넣기
		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = i+1;
		}//for

		// 3. 랜덤숫자를 섞기
		int r_num = 0, temp = 0;
		for (int i = 0; i < 500; i++) {
			r_num = (int) (Math.random() * 45);
			temp = lotto[0];
			lotto[0] = lotto[r_num];
			lotto[r_num] = temp;
		}//for
		
		// 4. 6개 숫자 넣기
		while (count<6) {
			System.out.println("번호를 넣으세요");
			input[count]=scan.nextInt();
			count++;
		}//while
	
//		 5. 당첨번호 6개 숫자 출력
		System.out.println("[[당첨번호 확인]]");
		for (int i = 0; i < 6; i++) {
			System.out.printf("%d ",lotto[i]);
		}
		System.out.println();
		// 6. 내 번호 6개 출력
		System.out.println("[[내 당첨번호 확인]]");
		for (int i = 0; i < 6; i++) {
			System.out.printf("%d ",input[i]);
		}
		System.out.println();
		// 7. 당첨번호 개수 확인
        for(int i=0;i<6;i++) {
        	for(int j=0;j<6;j++) {
        		if(lotto[i]==input[j]) {
        			l_no[num]=input[j];
        			num++;
        			break;
        		}//if
        	}//for
        }//for
		// 8. 당첨번호,개수 출력
        System.out.println("[[당첨된 번호와 갯수]]");
        System.out.println("당첨번호 갯수"+num);
        if(num==0) {
        	System.out.println("당첨번호 없음");
        }else {
        	for (int i = 0; i < num; i++) {
    			
    			System.out.printf("%d ",l_no[i]);
    		    
    	    }//for
        }//if
	}//main
}//class
