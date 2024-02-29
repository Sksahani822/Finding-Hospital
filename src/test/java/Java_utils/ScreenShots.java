package Java_utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShots {
	public static String screenshot(WebDriver driver,String filename) throws IOException
	{
		TakesScreenshot ss=(TakesScreenshot)driver;
	    File scr= ss.getScreenshotAs(OutputType.FILE);
	    File trg=new File("C:\\Users\\2304013\\eclipse-workspace\\Hackathon_Project\\ScreenShots\\"+filename+".png");
	    FileUtils.copyFile(scr, trg);	
	    return trg.getAbsolutePath();
	}

}
