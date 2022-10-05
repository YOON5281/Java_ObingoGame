package game;

public class Omok_Player {
	private boolean turn;
	private Enum ckrColor;
	
	public Omok_Player(Enum ckrColor) {
		this.ckrColor = ckrColor;
		if(this.ckrColor.equals(Omok_Color.White)) {
			turn = true;
		} else {
			turn = false;
		}
	}
	
	public boolean place(Omok_Board b, int x, int y) {
		return b.placeKan(x, y, ckrColor);
	}
	
	public boolean set(Omok_Board b, int x, int y) {
		return b.setKan(x, y, ckrColor);
	}
	
	public boolean getTurn() {
		return turn;
	}
	
	public void setTurn(boolean turn) {
		this.turn = turn;
	}
	
}
