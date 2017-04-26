package cn.nullxiao.main;

public class Main {
	private static int col = 2;
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		if(col >= 12){
			col = 12;
		}
		Main.col = col;
	}
	public static void main(String[] args) {
		CreateFrame.create(col);
	}
}
