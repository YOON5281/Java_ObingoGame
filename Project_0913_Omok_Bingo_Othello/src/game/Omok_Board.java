package game;

public class Omok_Board {
	private Omok_Kan[][] board;

	public Omok_Board(int n) {
		board = new Omok_Kan[n][n];
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				board[i][j] = new Omok_Kan();
			}
		}
	}
	
	public Omok_Kan[][] getBoard() {
		return board;
	}
	
	public void Omok_resetBoard() {
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				board[i][j] = new Omok_Kan();
			}
		}
	}
	
	public boolean placeKan(int x, int y, Enum ckrColor) {
		try {
			if(!board[x][y].getfilled()) {
				board[x][y].setCkrColor(ckrColor);
				board[x][y].setFilled(true);
				return true;
			}
			System.out.println("�̹� ���� �ֽ��ϴ�");
		} catch (IndexOutOfBoundsException e) {
			System.out.println("�ε��� �Ѿ");
		}
		return false;
	}
	
	public boolean setKan(int x, int y, Enum ckrColor) {
		try {
				board[x][y].setCkrColor(ckrColor);
				board[x][y].setFilled(true);
				return true;
	
		} catch (IndexOutOfBoundsException e) {
			System.out.println("�ε��� �Ѿ");
		}
		return false;
	}
	
	@Override
	public String toString() {
		String result = "";
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				result += board[i][j] + " ";
			}
			result += "\n";
		}
		return result;
	}
	
}
