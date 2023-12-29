package Libraries;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.WebDriver;
/**
 * java specific generic method
 * @author hp
 *
 */
public class javaUtility {
	
	WebDriver driver=null;
	/**
	 * this method use for random numbers
	 * @param name
	 * @return
	 */
	public int getRandom() 
	{
		Random r=new Random();
		int num=r.nextInt();
		return num;	
	}
	/**
	 * Methode for date format.
	 * @return
	 */
	public String getsystemdate()
	{
		Date d=new Date();
		SimpleDateFormat fo=new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		String date=fo.format(d);
		return date;
	}
}
