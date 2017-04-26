package cn.nullxiao.main;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CreateMsg {
	private static final String  LV0 = "LV 0 你可能是个gay！！！";
	private static final String LV1 = "LV 1 色狼 你离gay只有一步之遥";
	private static final String LV2 = "LV 2  你离gay有三步之遥";
	private static final String LV20 = "LV 20 我真是看错你了你个大色狼";
	private static final String LV90 = "LV 90 你个大色狼 看你都干了些什么";
	private static final String LV100 = "LV 100 你个变态色魔狂 没救了";
	public static void Create(JFrame f,int i){
		switch (i) {
		case 2:
			JOptionPane.showMessageDialog(f, LV0);
			break;
		case 3:
		case 4:
			JOptionPane.showMessageDialog(f, LV1);
			break;
		case 5:
		case 6:
			JOptionPane.showMessageDialog(f, LV2);
			break;
		case 7:
		case 8:
			JOptionPane.showMessageDialog(f, LV20);
			break;
		case 9 :
		case 10 :
			JOptionPane.showMessageDialog(f, LV90);
			break;
		default:
			JOptionPane.showMessageDialog(f, LV100);
			break;
		}
	}
}
