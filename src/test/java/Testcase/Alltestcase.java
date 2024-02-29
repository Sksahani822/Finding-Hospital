package Testcase;
import java.io.IOException;
import java.time.Duration;
import java.util.Map;

import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import BaseTest.BasePackage;
import Java_utils.ExcelOutput;
import Java_utils.ScreenShots;
import PageObjectModel.Practo;

public class Alltestcase extends BasePackage {
	public static String path;
	
	  @Test(priority = 0)
	 void TC_001_verifyCurrenturl() throws IOException
	 {   
		 logger.info("****************TC_001_verifyCurrenturl is Started..************************");
		 String currentUrl="https://www.practo.com/";
		 String Url=driver.getCurrentUrl();
		 Assert.assertEquals(currentUrl, Url);
		 path=ScreenShots.screenshot(driver, "Homepage");
		 logger.info("Current URL is verified");
		 logger.info("****************TC_001_verifyCurrenturl is Finished..************************");
	 }
	 
	
	@Test(priority = 1)
	void TC_002_getting_DoctorList () throws Exception
	{	
		logger.info("****************TC_002_getting_DoctorList is Started..************************");
		Practo pr=new Practo(driver);
		pr.clickOnFindDoctor();
		path=ScreenShots.screenshot(driver, "HomeForHealth");
		logger.info("ScreenShot captured for HomeForHealth");
		pr.clickOnLocation();
		pr.inputBangalore("Bangalore");
		pr.searchDoctor("Dentist");
		pr.waitSleep();
		pr.clickondoctor();
		logger.info("Searched the Doctor successfully...");
		pr.clickOnPatientStorie();
		pr.clickOnStoriesList();
		pr.waitSleep();
		pr.clickOnExperience();
		pr.clickOnExperienceList();
		pr.waitSleep();
		pr.clickOnAllfilter();
		pr.clickOnFeesCheckBox();
		pr.waitSleep();
		pr.clickOnAllfilter();
		pr.clickOnAvailability();
		pr.waitSleep();
		path=ScreenShots.screenshot(driver, "HomeForHealth");
		pr.clickOnSortedBy();
		pr.clickOnSortedByList();
		pr.waitSleep();
		//Getting Doctors Details...
		Map<String,String> details = pr.extractDoctorsDetails();
		logger.info(" Doctor details has been stored in String details ");
		for(Map.Entry<String,String> entry:details.entrySet())
		{
			System.out.println(entry.getKey()+": "+entry.getValue());
		}
		
		
		
		
		logger.info("****************TC_002_getting_DoctorList is Started..************************");
	}

	@Test(priority = 6)
	void TC_007_surgeries() throws Exception
	{	
		logger.info("********************TC_007_surgeries is started..***************************");
		Practo pr=new Practo(driver);
		pr.clickOnSuergeries();
		pr.ScrollToPopularSurferies();
		logger.info("Surgeries list is displayed successfully");
		path=ScreenShots.screenshot(driver, "PopularSurgeries");
		pr.gettingSurgeriesList();
		logger.info("********************TC_007_surgeries is Finished..***************************");
		
	}
	
	@Test(priority=7)
	void TC_008_passingInvalidEmail() throws Exception
	{
		logger.info("*********************TC_008_passingInvalidEmail is Started...***********************");
		Practo pr=new Practo(driver);
		pr.clickOnForCorporate();
		pr.clickOnHealthWellness();
		pr.sendingname("Sachin");
		pr.sendingOrganization_name("HealthCare");
		pr.sendcontactId("9999999999");
		pr.clearEmail();
		pr.sendEmail("Sachingmail.com");
		pr.selectOrganisationSize();
		pr.selectintrestin();
		path=ScreenShots.screenshot(driver, "ForCoporates");
		pr.clickOnsubmit();
		logger.info(" with invalid Email is entered");
		Assert.assertEquals(pr.Submit_Buttton.isEnabled(),false,"Disbled" );
		logger.info("Verification of Submit button is completed");
		logger.info("*********************TC_008_passingInvalidEmail is Finished...***********************");
	}
	
	
		@Test(priority=8)
	void TC_009_passingInvalidPhoneNumber() throws Exception
	{
		logger.info("*********************TC_009_passingInvalidPhoneNumber is Started...***********************");
		driver.navigate().refresh();	
		Practo pr=new Practo(driver);

		pr.sendingname("Sachin");

		pr.sendingOrganization_name("HealthCare");
		

		pr.clearContactId();

		pr.sendcontactId("99999999");
		

		pr.clearEmail();

		pr.sendEmail("Sachin@gmail.com");

		pr.selectOrganisationSize();

		pr.selectintrestin();

		pr.clickOnsubmit();
		logger.info("Details with invalid PhoneNumber is entered");
		path=ScreenShots.screenshot(driver, "ForCorporates2");
		Assert.assertEquals(pr.Submit_Buttton.isEnabled(),false,"Diabled" );	
		logger.info("verification of submit button is completed");
		logger.info("*********************TC_009_passingInvalidPhoneNumber is Finished...***********************");
		
	}
	
	@Test (priority=9)
	void TC_010_printingThankyou() throws Exception
	{
		logger.info("*********************TC_010_printingThankyou is Started...***********************");
		Practo pr=new Practo(driver);
		driver.navigate().refresh();


		pr.sendingname("Sachin");

		pr.sendingOrganization_name("HealthCare");
		

		pr.sendcontactId("9999999999");

		pr.sendEmail("Sachin@gmail.com");
		

		pr.selectOrganisationSize();

		pr.selectintrestin();

		Assert.assertEquals(pr.Enables_button.isEnabled(),true );
		pr.clickOnsubmit();
		logger.info("Details Filled Successfully");
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofMinutes(1));
		wait.until(ExpectedConditions.visibilityOf(pr.Thankyou));
		if (pr.Thankyou.isDisplayed())
		{
			path=ScreenShots.screenshot(driver, "ThankYou");	
		}	
		System.out.println(pr.gettingThankyou());
		logger.info("Thankyou messeage is printed successfully");
		logger.info("************TC_010_printingThankyou is Finished*****************");
		ExcelOutput.Excelutils(Practo.Doctors_Details,Practo.surgeriesList);
		logger.info(".....Complete program is Executed Successfully.....");
		pr.Exit();
	}
}
