package cn.nullxiao.main;
import java.util.Random;

public class CreateColor {
	private static Random random = new Random();
	private static int colorSame;
	private static int colorDifferent;
	public static Integer[] Create(int level){
		colorSame = random.nextInt(0XFFFFFF);
		if(random.nextInt(8) % 2 == 0){
			colorDifferent = colorSame + level;
		}else {
			colorDifferent = colorSame - level;
		}
		return new Integer[]{colorDifferent, colorSame};
	}
}
