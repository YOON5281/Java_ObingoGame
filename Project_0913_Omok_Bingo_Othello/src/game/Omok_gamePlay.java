package game;

import java.util.Scanner;

public class Omok_gamePlay {

	public void play(int n) {
		Omok_Player p1 = new Omok_Player(Omok_Color.White);
		Omok_Player p2 = new Omok_Player(Omok_Color.Black);
		Omok_Board board = new Omok_Board(n);
		Scanner sc = new Scanner(System.in);
		

		int x, y, condition;
		
		while(true) {
			//콘솔에 오목판 출력
			System.out.println(board);
			
			//입력 받기
			System.out.print("x : ");
			x = sc.nextInt();
			System.out.print("y : ");
			y = sc.nextInt();
			
			
			if(p1.getTurn()) {	
				//빈 칸에 돌을 맞게 뒀다면 턴 바꾸기
				if(p1.place(board, x, y)) {
					p1.setTurn(false);
					p2.setTurn(true);
				}
				
				//돌이 5개 연속인지 확인
				condition = check(board.getBoard(), x, y);
				
				//돌이 5개 이상 연속으로 있다면 p1 승리
				if(condition >= 5) {
					System.out.println(board);
					System.out.println("p1 승리");
					break;
				}
			} else {				
				if(p2.place(board, x, y)) {
					p2.setTurn(false);
					p1.setTurn(true);					
				}
				
				condition = check(board.getBoard(), x, y);
				
				if(condition >= 5) {
					System.out.println(board);
					System.out.println("p2 승리");
					break;
				}
			}
			
			
			
			
		}	
	}//play()
	
	public int check_Omock(Omok_Kan[][] board) {
		int cnt = 1;
		outer :for( int i = 0; i < 19; i++) {
			
			for(int j = 0 ; j < 19; j++) {
				
				Enum dol = board[i][j].getCkrColor();
				
				if(dol.equals(Omok_Color.Blank)) {
					continue;
				}else {
					if(j < 18 && dol.equals(board[i][j+1].getCkrColor())) {//우측으로
						int row = i;
						int col = j;
						while(col < 18 && dol.equals(board[row][++col].getCkrColor())) {
							cnt += 1;
						}
						if(cnt >=5) {
							break outer;
						}else {
							cnt = 1;
						}
					
						
					}
					if(i < 18 && dol.equals(board[i+1][j].getCkrColor())) {//아래로
						int row = i;
						int col = j;
						while(row < 18 && dol.equals(board[++row][col].getCkrColor())) {
							cnt += 1;
						}
						if(cnt >=5) {
							break outer;
						}else {
							cnt = 1;
						}
						
					}
					if(i < 18 && j > 0 && dol.equals(board[i+1][j-1].getCkrColor())) {//좌측아래로
						int row = i;
						int col = j;
						while(row < 18 && col > 0 && dol.equals(board[++row][--col].getCkrColor())) {
							cnt += 1;
						}
						if(cnt >=5) {
							break outer;
						}else {
							System.out.println((i+1)+ "," + (j+1));
							System.out.println(cnt);
							cnt = 1;
						}
				
					}
					if(i < 18 && j < 18 && dol.equals(board[i+1][j+1].getCkrColor())) {//우측아래로
						int row = i;
						int col = j;
						while(row < 18 && col < 18 && dol.equals(board[++row][++col].getCkrColor())) {
							cnt += 1;
						}
						if(cnt >=5) {
							break outer;
						}else {
							cnt = 1;
						}
					}
				}			
			}			
		}
		return cnt;
	}
		
	
	
	public int check(Omok_Kan[][] board, int row, int col) {
		int cnt = 1;
		outer : for(int i = row-1; i <= row+1; i++) {
			
			for(int j = col-1; j <= col+1; j++) {
				
				if(checkBounds(i, j, board)) {
					continue;
				} 
				if(board[i][j].getCkrColor().equals(Omok_Color.Blank)) {
					continue;
				}
				if(i == row && j == col) {
					continue;
				}
				int rowDir = i - row;
				int colDir = j - col;
				int newRow = i + rowDir;
				int newCol = j + colDir;
				
				while(true) {
					if(checkBounds(newRow, newCol, board)) {
						break;
					}
					if(board[row][col].getCkrColor().equals(board[newRow][newCol].getCkrColor())) {
						cnt++;
						newRow += rowDir;
						newCol += colDir;
					} else {
						break;
					}
				}
				
				newRow = row;
				newCol = col;
				rowDir *= -1;
				colDir *= -1;
				
				while(true) {
					if(checkBounds(newRow, newCol, board)) {
						break;
					}
					if(board[row][col].getCkrColor().equals(board[newRow][newCol].getCkrColor())) {
						cnt++;
						newRow += rowDir;
						newCol += colDir;
					} else {
						break;
					}
				}
				
				if(cnt >= 5) {
					break outer;
				}
			}
		}
		return cnt;
	}
	
	private boolean checkBounds(int row, int col, Omok_Kan[][] board) {
		return row < 0 || col < 0 || row > board.length || col > board[0].length;
	}
	
}






