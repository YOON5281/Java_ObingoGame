package game;

public class Othello_check {
	public int[] range(Omok_Kan[][] board, Omok_Color color ,int row, int col, int dir) {
	
	
		Omok_Color dol = color;
		switch( dir ) {
		
		case 0://우측으로
			if( col < 7 && !board[row][col+1].getCkrColor().equals(Omok_Color.Blank) && !dol.equals(board[row][col+1].getCkrColor())) {
				int i = row;
				int j = col;
				while( j < 7 && !dol.equals(board[i][j+1].getCkrColor()) && !board[i][j+1].getCkrColor().equals(Omok_Color.Blank) ) {
					++j;
				}
				if( j == 7 || board[i][j+1].getCkrColor().equals(Omok_Color.Blank) ) {
					return new int[] {row, col};
				}else {
					return new int[] {i, j + 1};
				}	
			}else {
				return new int[] {row, col};
			}
			
		case 1://우측하단으로
			if( row < 7 && col < 7 && !board[row+1][col+1].getCkrColor().equals(Omok_Color.Blank) && !dol.equals(board[row+1][col+1].getCkrColor())) {
				int i = row;
				int j = col;
				while( i < 7 && j < 7 && !dol.equals(board[i+1][j+1].getCkrColor()) && !board[i+1][j+1].getCkrColor().equals(Omok_Color.Blank)) {
					++i;
					++j;
					}
				if( j == 7 || i ==7 || board[i+1][j+1].getCkrColor().equals(Omok_Color.Blank) ) {
					return new int[] {row, col};
				}else {
					return new int[] {i + 1, j + 1};
				}	
			}else {
				return new int[] {row, col};
			}
			
		case 2://하단으로
			if( row < 7 && !board[row+1][col].getCkrColor().equals(Omok_Color.Blank) && !dol.equals(board[row+1][col].getCkrColor())) {
				int i = row;
				int j = col;
				while( i < 7 && !dol.equals(board[i+1][j].getCkrColor()) && !board[i+1][j].getCkrColor().equals(Omok_Color.Blank) ) {
					++i;
					}
				if( i ==7 || board[i+1][j].getCkrColor().equals(Omok_Color.Blank) ) {
					return new int[] {row, col};
				}else {
					return new int[] {i + 1, j};
				}	
			}else {
				return new int[] {row, col};
			}
			
		case 3://좌측하단로
			if( row < 7 && col > 0 && !board[row+1][col-1].getCkrColor().equals(Omok_Color.Blank) && !dol.equals(board[row+1][col-1].getCkrColor())) {
				int i = row;
				int j = col;
				while( i < 7 && j > 0 && !dol.equals(board[i+1][j-1].getCkrColor()) && !board[i+1][j-1].getCkrColor().equals(Omok_Color.Blank)) {
					++i;
					--j;
					}
				if( i == 7 || j == 0 || board[i+1][j-1].getCkrColor().equals(Omok_Color.Blank) ) {
					return new int[] {row, col};
				}else {
					return new int[] {i + 1, j - 1};
				}	
			}else {
				return new int[] {row, col};
			}
		
		case 4://좌측으로
			if(col > 0 && !board[row][col-1].getCkrColor().equals(Omok_Color.Blank) && !dol.equals(board[row][col-1].getCkrColor())) {
				int i = row;
				int j = col;
				while( j > 0 && !dol.equals(board[i][j-1].getCkrColor()) && !board[i][j-1].getCkrColor().equals(Omok_Color.Blank)) {
					--j;
					}
				if( j == 0 || board[i][j-1].getCkrColor().equals(Omok_Color.Blank) ) {
					System.out.println(j);
					System.out.println("ㅁㄴㅇㄻㄴㅇㄹ");
					return new int[] {row, col};
				}else {
					return new int[] {i, j - 1};
				}	
			}else {
				return new int[] {row, col};
			}
			
		case 5://좌측상단으로
			if( row > 0 && col > 0 && !board[row-1][col-1].getCkrColor().equals(Omok_Color.Blank) && !dol.equals(board[row-1][col-1].getCkrColor())) {
				int i = row;
				int j = col;
				while( i > 0  && j > 0 && !dol.equals(board[i-1][j-1].getCkrColor()) && !board[i-1][j-1].getCkrColor().equals(Omok_Color.Blank)) {
					--i;
					--j;
					}
				if( i == 0 || j == 0 || board[i-1][j-1].getCkrColor().equals(Omok_Color.Blank)) {
					break;
				}else {
					return new int[] {i - 1, j - 1};
				}	
			}else {
				return new int[] {row, col};
			}
			
		case 6://상단으로
			if( row > 0  && !board[row-1][col].getCkrColor().equals(Omok_Color.Blank) && !dol.equals(board[row-1][col].getCkrColor())) {
				int i = row;
				int j = col;
				while( i > 0 && !dol.equals(board[i-1][j].getCkrColor()) && !board[i-1][j].getCkrColor().equals(Omok_Color.Blank)) {
					--i;
					}
				if( i == 0 || board[i-1][j].getCkrColor().equals(Omok_Color.Blank) ) {
					return new int[] {row, col};
				}else {
					return new int[] {i - 1, j};
				}	
			}else {
				return new int[] {row, col};
			}
		
		case 7://우측상단으로
			if( row > 0 && col < 7  && !board[row-1][col+1].getCkrColor().equals(Omok_Color.Blank) && !dol.equals(board[row-1][col+1].getCkrColor())) {
				int i = row;
				int j = col;
				while( i > 0 && j < 7 && !dol.equals(board[i-1][j+1].getCkrColor()) && !board[i-1][j+1].getCkrColor().equals(Omok_Color.Blank)) {
					--i;
					++j;
					}
				if( i == 0 || j == 7 || board[i-1][j+1].getCkrColor().equals(Omok_Color.Blank) ) {
					return new int[] {row, col};
				}else {
					return new int[] {i - 1, j + 1};
				}	
			}else {
				return new int[] {row, col};
			}
		
		}
		return new int[] {row, col};
	}
	
	public boolean check(Omok_Kan[][] board, Omok_Color color, int row, int col) {
		int[] dol = new int[2];
		for(int i = 0 ; i < 8; i++) {
			dol = range(board, color,  row, col, i);
			if(dol[0] != row || dol[1] != col) {
				return true;
			}
		}
		return false;
	}
	
	public boolean checkall(Omok_Kan[][] board, Omok_Color color) {
		int[] dol = new int[2];
		for( int i = 0 ; i < 8; i++ ) {
			for(int j = 0; j < 8; j++) {
				for(int k = 0; k < 8; k ++) {
					if(!board[i][j].getfilled()) { 
						dol = range(board, color, i, j, k);
						if(dol[0] != i || dol[1] != j) {
							return true;
						}
					}
				}
			}		
		}
		return false;
	}
	
	public int[] Win(Omok_Kan[][] board) {
		int cnt1 = 0;
		int cnt2 = 0;
				
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j ++) {
				if(board[i][j].getCkrColor().equals(Omok_Color.Black)) {
					cnt1++;
				}else if(board[i][j].getCkrColor().equals(Omok_Color.White)) {
					cnt2++;
				}
			}
		}
		if(cnt1 > cnt2) {
			return new int[] {cnt1, cnt2, 1};
		}else if(cnt1 < cnt2) {
			return new int[] {cnt1, cnt2, 2};
		}else if(cnt1 == cnt2) {
			return new int[] {cnt1, cnt2, 0};
		}else {
			return new int[] {cnt1, cnt2, 3};
		}
	}
}
