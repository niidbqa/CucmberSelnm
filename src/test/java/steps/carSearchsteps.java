package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class carSearchsteps {
	public static WebDriver driver;
	
	@Before
	public void setUp(){
		// chmod 777 /Users/basildzewu/Documents/workspace/Selenium/CucumberSelenium/src/main/resources/executables/chromedriver
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "/src/main/resources/executables/chromedriver");
		driver = new ChromeDriver();
	}
	
	@After
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {
            byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshotBytes, "target/cucumber/image/png");
        }

        if (driver != null) {
            driver.quit();
        }

    }
	
	@Given("^I am on the home page https://www\\.carsguide\\.com\\.au/ of carsguide website$")
	public void i_am_on_the_home_page_https_www_carsguide_com_au_of_carsguide_website() throws Throwable {
		driver.get("https://www.carsguide.com.au");
	}

	@When("^I move to Car for Sale Menu$")
	public void i_move_to_Car_for_Sale_Menu() throws Throwable {
	    WebElement menu = driver.findElement(By.linkText("Cars For Sale"));
		new Actions(driver).moveToElement(menu).perform();
	}
	
	@Then("^I click on Search Cars$")
	public void i_click_on_Search_Cars() throws Throwable {
		driver.findElement(By.linkText("Search Cars")).click();
	}

	
	@Then("^I select Make as \"([^\"]*)\"$")
	public void i_select_Make_as(String make) throws Throwable {
	    new Select(driver.findElement(By.id("makes"))).selectByVisibleText(make);
	}

	@Then("^I select Model as \"([^\"]*)\"$")
	public void i_select_Model_as(String model) throws Throwable {
		new Select(driver.findElement(By.id("models"))).selectByVisibleText(model);
	}

	@Then("^I select location as \"([^\"]*)\"$")
	public void i_select_location_as(String location) throws Throwable {
		new Select(driver.findElement(By.id("locations"))).selectByVisibleText(location);
	}

	@Then("^I select price as \"([^\"]*)\"$")
	public void i_select_price_as(String price) throws Throwable {
		new Select(driver.findElement(By.id("price-max"))).selectByVisibleText(price);
	}


	
	@Then("^I click on Find My Next Car button$")
	public void i_click_on_Find_My_Next_Car_button() throws Throwable {
		driver.findElement(By.id("search-submit")).click();
	    Thread.sleep(1000);
	}
	


	@Then("^I should see list of searched cars from \"([^\"]*)\"$")
	public void i_should_see_list_of_searched_cars(String cars) throws Throwable {
	    Assert.assertTrue(driver.findElement(By.className("carListing--textHeading")).getText().contains(cars));
	}
	
	@Then("^the page title should be \"([^\"]*)\"$")
	public void the_page_title_should_be(String expected) throws Throwable {
	   Assert.assertEquals(expected, driver.getTitle());
	}
	


}
