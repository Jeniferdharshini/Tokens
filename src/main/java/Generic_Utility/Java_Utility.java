package Generic_Utility;

import java.util.Random;

public class Java_Utility {
	public int getRanDomNum()
	{
		Random ran=new Random();
		int ranNum = ran.nextInt(10000);
		return ranNum;
		
	}

}
