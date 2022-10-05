package game;

import java.util.Scanner;

public class Bingo_Algorithm {
	
	public int[][] initialize(int[][] arr, int n) {
		//	초기화 
		
		
		for( int i =0 ; i < n ; i++) {
			
			for(int j = 0 ; j < n ; j++) {
				
				arr[i][j] = 0;
				System.out.print(arr[i][j] + " ");
				
			}
			System.out.println();
		}
		return arr;
	
		
	}
	
	public int[][] Bingo_Algorithm(int n1, int n2, int n, int userCount,int[][] arr) {
		
		System.out.println("3줄이면 빙고 " );
		
		
		try {
			if(userCount % 2 ==1 ) {
				System.out.println("User1 차례입니다");
				}else {
				System.out.println("User2 차례입니다");
				}
			
		
			if(arr[n1][n2] == 0) {
			
			if(userCount % 2 ==1 ) {				
				arr[n1][n2] = 1;
			}else {
				arr[n1][n2] = 2;
			}
			
			}else {
				return arr;
			}
		} catch (Exception e) {
			System.out.println("올바른 수를 넣어주세요 ");
		}
		
		
		for( int i =0 ; i < n ; i++) {
			
			for(int j = 0 ; j < n ; j++) {
				
				System.out.print(arr[i][j] + " ");
						
			}
			
			System.out.println();
		}

		return arr;
	}//Bingo_Algortyhm
	
	public int userCount_check(int n1, int n2, int userCount,int[][] arr) {
		
		if(arr[n1][n2] != 0) {
			
			userCount--;		
				System.out.println("이미 있는 칸입니다.");
			}
		
		return userCount;
	}
	
	
	public int[] Bingo_Check(int n1, int n2, int n,int userCount,int[][] arr) {
		
		//빙고판정
		
		int[] bingo = new int[2];
		
		int ld_cnt = 0;
		int ld_cnt2 = 0;
		int rd_cnt = 0;
		int rd_cnt2= 0;		
		
		
		
		//가로 일치
		
		outer : for( int i =0 ; i < n ; i++) {
		
		int h_cnt = 0;
		int h_cnt2 = 0;
			
			for(int j = 0 ; j < n ; j++) {
				
				if(arr[i][j] == 1) h_cnt++;
				if(arr[i][j] == 2) h_cnt2++;
				
				
				if(h_cnt == n) {
					bingo[0]++;
					continue outer;
				}
				if(h_cnt2 == n) {
					bingo[1]++;
					continue outer;
				}
			}		
			
		}
	
		//세로 일치 
		outer : for( int i =0 ; i < n ; i++) {
			
		int v_cnt = 0;
		int v_cnt2 = 0;
					
			for(int j = 0 ; j < n ; j++) {
				
				if(arr[j][i] == 1) v_cnt++;
				if(arr[j][i] == 2) v_cnt2++;
//				System.out.print(v_cnt  + " ");
				
				if(v_cnt == n) {
					bingo[0]++;
					continue outer;
				}
				if(v_cnt2 == n) {
					bingo[1]++;
					continue outer;
				}
			}		
			
		}
//		System.out.println();
		
		// 왼쪽 대각선 일치
		
		for( int i = 0 ; i < n ; i++) {
			if(arr[i][i] == 1) {
				ld_cnt++;
				}
			if(arr[i][i] == 2) {
				ld_cnt2++;
			}
			if(ld_cnt == n) bingo[0]++;
			if(ld_cnt2 == n) bingo[1]++;
		}
		
		//오른쪽 대각선 일치
		
		
		outer : for (int i = 0 ;  i < n ; i++) {
			for (int j = 0 ;  j < n ; j++) {
				if(i+j == (n - 1) && arr[i][j] == 1 ) {
				rd_cnt++;
				}
				if(i+j == (n - 1) && arr[i][j] == 2 ) {
					rd_cnt2++;
				}
				
				if(rd_cnt == n) {
					bingo[0]++;
					continue outer;
				}
				if(rd_cnt2 == n) {
					bingo[1]++;
					continue outer;
				}
				
			}
		}
				
//		System.out.println("User1 빙고 : " + bingo[0]);
//		System.out.println("User2 빙고 : " + bingo[1]);
		

		return bingo;
		
	}//Bingo_Check
}
