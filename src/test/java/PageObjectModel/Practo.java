package PageObjectModel;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Java_utils.ScreenShots;
import Testcase.Alltestcase;

public class Practo {
	public static Map<String ,String> Doctors_Details =new HashMap<String,String>();
	public static List<String> surgeriesList=new ArrayList<String>();
	
	public WebDriver driver;

	public Practo(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
					
}
	//LOCATORS...
	
	@FindBy(xpath = "//*[text()='Find Doctors']") WebElement Find_Doctor;
	@FindBy(xpath = "(//*[@class='c-omni-searchbox c-omni-searchbox--large'])[1]") WebElement location;
	@FindBy(xpath= "(//*[@class='c-omni-searchbox c-omni-searchbox--large'])[2]") WebElement Search_Doctor;
	@FindBy(xpath = "(//*[@class='c-omni-suggestion-item__content__title'])[1]") WebElement clickOnDentist;
	@FindBy(xpath = "//*[contains(@data-qa-id,'doctor_review_count_section')]") WebElement Patient_Stories;
	@FindBy(xpath = "//li[contains(@aria-label,'Patient Stories')]") List<WebElement> Stories_Lists;
	@FindBy(xpath = "//*[contains(@data-qa-id,'years_of_experience_section')]") WebElement Experience;
	
	@FindBy(xpath = "(//li[contains(@aria-label,'Years of experience')])")List< WebElement> Experience_Lists;
	@FindBy(xpath = "//span[contains(@aria-label,'Click to view all filters')]") WebElement Allfilter;
	@FindBy(xpath = "(//*[contains(@for,'Fees')])") List<WebElement> FeesCheckBox;
	@FindBy(xpath = "(//*[contains(@for,'Availability')])") List<WebElement> Availability;
	@FindBy(xpath = "//*[contains(@data-qa-id,'sort_by_selected')]") WebElement sorted_By;
	@FindBy(xpath = "((//*[contains(@data-qa-id,'sort_by_list')])//li)")List< WebElement> Sorted_ByList;
	@FindBy(xpath = "(//*[contains(@class,'doctor-name')])")
	public List<WebElement> Doctor_Name;
//	@FindBy(xpath = "(//*[contains(@class,'doctor-name')])[2]") WebElement Doctor_2;
//	@FindBy(xpath = "(//*[contains(@class,'doctor-name')])[3]") WebElement Doctor_3;
//	@FindBy(xpath = "(//*[contains(@class,'doctor-name')])[4]") WebElement Doctor_4;
//	@FindBy(xpath = "(//*[contains(@class,'doctor-name')])[5]") WebElement Doctor_5;
	@FindBy(xpath = "//*[(@class='c-profile__title u-bold u-d-inlineblock')]") WebElement Doctors_Name;
	@FindBy(xpath = "//*[contains(@class,'c-profile--qualification')]")
	public WebElement Doctors_Qualification;
	@FindBy(xpath = "//*[text()='Surgeries']") WebElement ClickOnSurgeries;
	@FindBy(xpath = "//*[@class='mt-12px AilmentItem-module_itemText__XvCHL']") List<WebElement> Surgeries_List;
	@FindBy(xpath = "//span[@class='nav-interact']") WebElement For_corporates;
	@FindBy(xpath = "//*[text()='Health & Wellness Plans']") WebElement Health_Wellness;
	@FindBy(xpath = "(//input[@name='name'])[1]") WebElement Name;
	@FindBy(xpath = "(//input[@id='organizationName'])[1]") WebElement Organisation_Name;
	@FindBy(xpath = "(//input[@id='contactNumber'])[1]") WebElement Contact_id;
	@FindBy(xpath = "(//input[@id='officialEmailId'])[1]") WebElement Official_Email;
	@FindBy(xpath = "(//select[@id='organizationSize'])[1]") WebElement Organisation_size;
	@FindBy(xpath = "(//select[@id='interestedIn'])[1]") WebElement IntrestedIn;
	@FindBy(xpath = "(//*[text()='Schedule a demo'])[1]")
	public  WebElement Submit_Buttton;
	@FindBy(xpath = "//*[text()='THANK YOU']") 
	public WebElement Thankyou;
	@FindBy(xpath = "//*[text()='Popular Surgeries']") WebElement Popular_Surgeries;
	@FindBy(xpath = "(//*[@type='submit'])[2]")
	public WebElement Enables_button;
	

	public void clickOnFindDoctor()
	{
		Find_Doctor.click();
	}
	
	public void clickOnLocation()
	{
		location.click();
	
	}
	public void inputBangalore( String Location )
	{	 location.clear();
		 location.sendKeys(Location);
		
	}
	public void searchDoctor(String Doctor)
	{
		Search_Doctor.sendKeys(Doctor);
	}
	 public void clickondoctor()
	 {	
	 JavascriptExecutor js=(JavascriptExecutor)driver;
	 js.executeScript("arguments[0].click();",clickOnDentist);
	 }
 
	 public void clickOnPatientStorie()
	 {
		Patient_Stories.click();
		
	 }
	
	 public void clickOnStoriesList()
	 {
		 	Random rnd = new Random();
	        int i = rnd.nextInt(Stories_Lists.size());
	        Stories_Lists.get(i).click();      
	 }
	
	 public void clickOnExperienceList()
	 {
		 	Random rnd = new Random();
	        int i = rnd.nextInt(Experience_Lists.size());
	        Experience_Lists.get(i).click();
	 }
	 public void clickOnAllfilter()
	 {
		 Allfilter.click();
	 }
	 public void clickOnFeesCheckBox()
	 {
		 	Random rnd = new Random();
	        int i = rnd.nextInt( FeesCheckBox.size());
	        FeesCheckBox.get(i).click();
		 
	 }
	 public void clickOnAvailability()
	 {
		 	Random rnd = new Random();
	        int i = rnd.nextInt( Availability.size());
	        Availability.get(i).click();
	        
	 }
	 public void clickOnSortedBy()
	 {
		sorted_By.click(); 
	 }
	 public void clickOnSortedByList()
	 {
		 	Random rnd = new Random();
	        int i = rnd.nextInt( Sorted_ByList.size());
	        Sorted_ByList.get(i).click();	 
	 }

	 public void switchwindowdefault()
	 {
		 Set <String> winId =driver.getWindowHandles();
			List<String> winList=new ArrayList(winId);
			driver.switchTo().window(winList.get(0));
	 }
	 public void switchNextwindow()
	 {
		 Set <String> winId =driver.getWindowHandles();
			List<String> winList=new ArrayList(winId);
			driver.switchTo().window(winList.get(1));
	 }
	 public String gettingDoctorName()
	 {
		 return Doctors_Name.getText();
	 }
	 public String gettingDoctorsQualifications()
	 {
		 return Doctors_Qualification.getText();
	 }
	 public void clickOnSuergeries()
	 {
		ClickOnSurgeries.click(); 
	 }
	 public void clickOnExperience()
	 {
		 Experience.click();
	 }
	 public List<String> gettingSurgeriesList()
	 { 
			for(int i=0;i<Surgeries_List.size();i++)
			{
				surgeriesList.add(Surgeries_List.get(i).getText());
				System.out.println((i+1)+"."+Surgeries_List.get(i).getText());
				
			}
			return surgeriesList;
			
	 }
	 public void clickOnForCorporate()
	 {
		 For_corporates.click();
	 }
	 public void clickOnHealthWellness()
	 {
		 Health_Wellness.click();
	 }
	 public void sendingname(String name)
	 {
		 Name.sendKeys(name);
	 }
	 public void sendingOrganization_name(String Organizationname )
	 {
		 Organisation_Name.sendKeys(Organizationname);
	 }
	 
	 public void sendcontactId(String contact_id)
	 {
		 Contact_id.sendKeys(contact_id);
	 }
	 public void sendEmail(String Email)
	 {
		 Official_Email.sendKeys(Email);
	 }
	 public void selectOrganisationSize()
	 {
		 Select selectOption= new Select(Organisation_size);
			selectOption.selectByValue("<=500");
	 }
	 public void selectintrestin()
	 {
		 Select intrestin=new Select(IntrestedIn);
			intrestin.selectByValue("Taking a demo");
	 }
	 public void clearContactId()
	 {
		 Contact_id.clear();
	 }
	 public void clearEmail()
	 {
		 Official_Email.clear();
	 }
	 public void clickOnsubmit()
	 {
		 Submit_Buttton.click();
	 }
	 
	public String gettingThankyou()
	{
		return Thankyou.getText();
	}
	public void closeWindow()
	{
		driver.close();
	}
	public  boolean  IsEnabled()
	{
	  return Submit_Buttton.isEnabled();
	}
	 
	public void ScrollToPopularSurferies()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",Popular_Surgeries);
	}
	
	public void waitSleep() throws Exception
	{
		Thread.sleep(3000);
	}
	
	
	public Map<String, String> extractDoctorsDetails() throws Exception {
	
		
				for(int i=0;i<5;i++)
				{
					String drName = Doctor_Name.get(i).getText();
					WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(3));
					wait.until(ExpectedConditions.visibilityOf(Doctor_Name.get(i)));
					JavascriptExecutor js=(JavascriptExecutor)driver;
					js.executeScript("arguments[0].scrollIntoView();",Doctor_Name.get(i));
					Alltestcase.path=ScreenShots.screenshot(driver, "Doctors["+i+"");
					js.executeScript("arguments[0].click();", Doctor_Name.get(i));
					Set<String> tabs = driver.getWindowHandles();
					String parentTab = driver.getWindowHandle();
				for (String child : tabs) {	
				if(!parentTab.equals(child)) 
				{
				driver.switchTo().window(child);
				}
				}
				String doctorDetail = Doctors_Qualification.getText();
				Doctors_Details.put(drName, doctorDetail);
				driver.close();
				driver.switchTo().window(parentTab);
			}
			return Doctors_Details;
		}
	public void Exit()
	{
		driver.quit();
	}
}


