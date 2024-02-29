package StepDefinition;

import java.io.IOException;
import java.time.Duration;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import BaseTest.BasePackage;
import PageObjectModel.Practo;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Step_Definition {  
	public static WebDriver driver;
	String currentUrl;
	String Url;
	static String path;
	Practo pr=new Practo(driver);
	public Logger logger = LogManager.getLogger(this.getClass());
	
	 
	@Given("the user should navigate to practo website")
	public void the_user_should_navigate_to_practo_website() throws IOException {
		logger.info("***************Verification of Url is Started************");
		driver=new ChromeDriver();
		driver.get("https://www.practo.com/");
		driver.manage().window().maximize();
		path=BasePackage.screenshot(driver,"Homepage");
	}

	@When("the user should get current Url")
	public void the_user_should_get_current_url() {
		  Url=driver.getCurrentUrl();
	}

	@Then("the user should check the current Url is matches with ExpectedUrl")
	public void the_user_should_check_the_current_url_is_matches_with_expected_url() {
		currentUrl="https://www.practo.com/";
		 Assert.assertEquals(currentUrl, Url);
		 logger.info("******************Url is verified successfully**************");
	}

	@Given("user should click on Find  Doctor")
	public void user_should_click_on_find_doctor() throws Exception {
		
	  pr.clickOnFindDoctor(); 
	}

	@When("the user should select the location and Doctor")
	public void the_user_should_select_the_location_and_doctor() throws Exception {
			pr.inputBangalore("Bangalore");
			pr.searchDoctor("Dentist");
			pr.waitSleep();
			pr.clickondoctor(); 
			logger.info("******************Searching of Doctor is done successfully**************");
	}

	@Then("user should select the Patient Stories")
	public void user_should_select_the_patient_stories() throws Exception {
		pr.clickOnPatientStorie();
		pr.clickOnStoriesList();
		pr.waitSleep();
	}

	@Then("user should select the Experience")
	public void user_should_select_the_experience() throws Exception {
		pr.clickOnExperience();
		pr.clickOnExperienceList();
		pr.waitSleep();
	}

	@Then("user should select the All Filters")
	public void user_should_select_the_all_filters() throws Exception {
		pr.clickOnAllfilter();
		pr.clickOnFeesCheckBox();
		pr.waitSleep();
		pr.clickOnAllfilter();
		pr.clickOnAvailability();
		pr.waitSleep();
	}

	@Then("user should select the sorted by relevence")
	public void user_should_select_the_sorted_by_relevence() throws Exception {
		pr.clickOnSortedBy();
		pr.clickOnSortedByList();
		pr.waitSleep();
		path=BasePackage.screenshot(driver,"AppliedFilters");
		logger.info("******************Filteration of Doctor in done successfully**************");
	}
	
	@Then("the user should get the doctors details which is displayed")
	public void the_user_should_get_the_doctors_details_which_is_displayed() throws Exception {
		
		Map<String,String> details = pr.extractDoctorsDetails();
		for(Map.Entry<String,String> entry:details.entrySet())
		{
			System.out.println(entry.getKey()+": "+entry.getValue());
		}
		logger.info("******************Doctors details is printed successfully**************");
	}

	@Given("the user sould click on the surgeries link")
	public void the_user_sould_click_on_the_surgeries_link() {
		pr.clickOnSuergeries();
		
		
	}

	@When("the user should scrolldown till surgeries list")
	public void the_user_should_scrolldown_till_surgeries_list() {
		pr.ScrollToPopularSurferies();
	}

	@Then("the user should take the surgeries List")
	public void the_user_should_take_the_surgeries_list() throws IOException {
		System.out.println("Surgeries List -"+pr.gettingSurgeriesList());
		path=BasePackage.screenshot(driver,"Surgerieslist");
		logger.info("******************Surgeries List is printed successfully**************");
	}
//VerifyButton
	@Given("the user should click on the For Corporate")
	public void the_user_should_click_on_the_for_corporate() {
		pr.clickOnForCorporate();
	}

	@When("the user should select the Health and Wellness Plan")
	public void the_user_should_select_the_health_and_wellness_plan() {
		pr.clickOnHealthWellness();
	}

	@Then("the user should fill the required detail with in valid Email")
	public void the_user_should_fill_the_required_detail_with_in_valid_email() throws IOException {
		pr.sendingname("Sachin");
		pr.sendingOrganization_name("HealthCare");
		pr.sendcontactId("9999999999");
		pr.clearEmail();
		pr.sendEmail("Sachingmail.com");
		pr.selectOrganisationSize();
		pr.selectintrestin();
		pr.clickOnsubmit();
		Assert.assertEquals(pr.Submit_Buttton.isEnabled(),false,"Disabled" );
		path=BasePackage.screenshot(driver,"InvalidEmail");
		logger.info("******************Health and wellness form is filled withn invalid E-mail successfully**************");
	}

	@Given("the user should refresh the page")
	public void the_user_should_refresh_the_page() {
		driver.navigate().refresh();
	}

	@When("the user should fill the required detail with invalid PhoneNumber")
	public void the_user_should_fill_the_required_detail_with_invalid_phone_number() throws IOException {
		pr.sendingname("Sachin");
		pr.sendingOrganization_name("HealthCare");		
		pr.clearContactId();
		pr.sendcontactId("99999999");
		pr.clearEmail();
		pr.sendEmail("Sachin@gmail.com");
		pr.selectOrganisationSize();
		pr.selectintrestin();
		pr.clickOnsubmit();
		Assert.assertEquals(pr.Submit_Buttton.isEnabled(),false,"Disabled" );
		path=BasePackage.screenshot(driver,"Invalidphoneno");
		logger.info("******************Health and wellness form is filled withn invalid PhoneNumber successfully**************");
	}
	@Given("the user should refresh the page for valid details")
	public void the_user_should_refresh_the_page_for_valid_details() {
		driver.navigate().refresh();
	}

	@Then("the user should fill the required detail with in valid Details")
	public void the_user_should_fill_the_required_detail_with_in_valid_details() throws IOException {
		pr.sendingname("Sachin");
		pr.sendingOrganization_name("HealthCare");
		pr.sendcontactId("9999999999");
		pr.sendEmail("Sachin@gmail.com");
		pr.selectOrganisationSize();
		pr.selectintrestin();
		Assert.assertEquals(pr.Enables_button.isEnabled(),true );
		path=BasePackage.screenshot(driver,"Validbutton");
		logger.info("******************Health and wellness form is filled withn valid details successfully**************");
	}

	@Then("the user should click on the Schedule to demo  button and get Thankyou message")
	public void the_user_should_click_on_the_schedule_to_demo_button() throws IOException {
		pr.clickOnsubmit();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofMinutes(1));
		wait.until(ExpectedConditions.visibilityOf(pr.Thankyou));
		if (pr.Thankyou.isDisplayed())
		{
			System.out.println(pr.gettingThankyou());	
			path=BasePackage.screenshot(driver,"Thankyoumsg");
		}
		logger.info("******************Thank you message is printed successfully**************");	
		logger.info("******************Execution is Done Successfully**************");
		driver.quit();
	}
	
		}