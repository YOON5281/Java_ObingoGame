package game;

public class Omok_Kan {
	private boolean filled;
	private Enum ckrColor;
	
	public Omok_Kan() {
		filled = false;
		ckrColor = Omok_Color.Blank;
	}
	
	public void setFilled(boolean filled) {
		this.filled = filled;
	}
	
	public void setCkrColor(Enum ckrColor) {
		this.ckrColor = ckrColor;
	}
	
	public Enum getCkrColor() {
		return ckrColor;
	}
	
	public boolean getfilled() {
		return filled;
	}
	
	@Override
	public String toString() {
		if(ckrColor.equals(Omok_Color.White)) {
			return "\u25CB";
		} else if(ckrColor.equals(Omok_Color.Black)) {
			return "\u25CF";
		} else {
			return "\u25A1";
		}
	}
}



