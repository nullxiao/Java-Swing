package cn.nullxiao.main;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
public class CreateFrame{
	private static JFrame mainFrame;
	private static JButton mainButton[][];
	private static int col;
	private static GridLayout mainGLayout;
	private static Color colorSame;
	private static Color colorDifferent;
	private static int randomPositionX;
	private static int randomPositionY;
	private static int lv = 2;
	private static int hvgap = 10;
	private static boolean  t = true;
	public static void create(int col){
		CreateFrame.col = col;
		init();
		setView();
	}
	private static void init() {
		mainFrame = new JFrame("This is a javaswing test");
		mainButton = new JButton[col][col];
		mainGLayout = new GridLayout(col, col, hvgap+col, hvgap+col);
		Integer temp[] = CreateColor.Create(new Random().nextInt(20) + 15);
		colorSame = new Color(temp[1]);
		colorDifferent = new Color(temp[0]);
		randomPositionX = new Random().nextInt(col);
		randomPositionY = new Random().nextInt(col);
	}
	private static void setView() {
		for (int i = 0; i < mainButton.length; i++) {
			for (int j = 0; j < mainButton[0].length; j++) {
				mainButton[i][j] = new JButton(i+","+j);
				mainButton[i][j].setBorder(BorderFactory.createLineBorder(new Color(0x0033bb)));
				mainButton[i][j].setOpaque(true);
				if(i == randomPositionX && j == randomPositionY){
					mainButton[i][j].setBackground(colorDifferent);
				}else{
					mainButton[i][j].setBackground(colorSame);
				}
				mainButton[i][j].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						Integer x = new Integer(((JButton)(e.getSource())).getText().split(",")[0]);
						Integer y = new Integer(((JButton)(e.getSource())).getText().split(",")[1]);
						if(check(x, y)){
							lv++;
							CreateFrame.mainFrame.dispose();
							new Main().setCol(new Main().getCol() + 1);
							Main.main(null);
						}else{
							CreateMsg.Create(CreateFrame.mainFrame, lv);
							CreateFrame.mainFrame.dispose();
							new Main().setCol(2);
							Main.main(null);
							lv=2;
						}
					}
				});
				mainFrame.add(mainButton[i][j]);
			}
		}
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setLayout(mainGLayout);
		setMainFrameSize();
		mainFrame.setResizable(false);
		mainFrame.setVisible(true);
		if(t){
			JOptionPane.showMessageDialog(mainFrame, "玩法[点击与其他颜色不同的标签]");
			t = false;
		}
	}
	private static boolean check(Integer x, Integer y) {
		Color tempColor = mainButton[x][y].getBackground();
		int bool = 0;
		for (int i = 0; i < mainButton.length; i++) {
			for (int j = 0; j < mainButton[0].length; j++) {
				if(tempColor == mainButton[i][j].getBackground()){
					bool++;
				}
			}
		}
		if(bool == 1){
			return true;
		}
		return false;
	}
	private static void setMainFrameSize() {
		if(col <= 7){
			mainFrame.setSize(150*col, 135*col);
		}else{
			mainFrame.setSize(1024, 800);
		}
	}
}



