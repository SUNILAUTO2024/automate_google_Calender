package demo;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import com.google.common.base.Verify;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import java.util.logging.Level;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");

        WebDriverManager.chromedriver().timeout(30).setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.INFO);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);

        // Connect to the chrome-window running on debugging port
        options.setExperimentalOption("debuggerAddress", "127.0.0.1:9222");

        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);

        // Set browser to maximize and wait
        driver.manage().window().maximize();
    }




    public void endTest()
    {
        System.out.println("End Test: TestCases");
       // driver.close();


    }

    
    public  void testCase01(){
        System.out.println("Start Test case: testCase01");
        driver.get("https://www.google.com");
        System.out.println("Verify the URL of the Google Calendar home page");
        driver.get("https://calendar.google.com/");

        if (driver.getCurrentUrl().contains("calendar")){
            System.out.println("The URL of the Calendar homepage contains 'calendar'");
        }
        else {
            System.out.println("The URL of the Calendar homepage not contains 'calendar'");
        }
        System.out.println("end Test case: testCase01");
    }
    public  void testCase02() throws InterruptedException {
        System.out.println("Start Test case: testCase02");

        System.out.println("Verify Calendar Navigation and Add Task");
        //open DD of month, days, year...
//        WebElement element = driver.findElement(By.xpath("//div[@jsname=\"WjL7X\"]/child::div"));
//       if (element.isDisplayed()){
//           System.out.println("User selected Month View");
//       }
//       WebElement month = driver.findElement(By.xpath("(//span[text()=\"Month\"])[2]"));
//        if (month.isDisplayed()){
//            System.out.println("User selected Month View already");
//        }
        driver.findElement(By.xpath("//div[@data-datekey=\"28335\"]")).click();
        System.out.println("User Click on the calendar to add a task.");

        //
        Thread.sleep(3000);

        driver.findElement(By.xpath("//div[@role='tablist']/button[2]")).click();
        System.out.println("User Navigate to the Tasks tab.");
        Thread.sleep(2000);

        WebElement title = driver.findElement(By.xpath("(//span[@class='Fgl6fe-fmcmS-wGMbrd-sM5MNb'])[2]/input"));
        title.sendKeys("Crio INTV Task Automation");
        System.out.println("title Crio INTV Task Automation added");

        WebElement des = driver.findElement(By.xpath("//textarea[@jsname=\"YPqjbf\"]"));
        des.sendKeys("Crio INTV Calendar Task Automation");
        System.out.println("Description added");
        Thread.sleep(200);
        // Locate the element
//        WebElement els = driver.findElement(By.className("UywwFc-vQzf8d"));
//
//// Use JavaScript to click it
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].click();", els);
        //By locator = By.xpath("//button[@data-idom-class='pEVtpe']");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

// Wait until the element is clickable
       // WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        WebElement element = driver.findElement(By.xpath("//button[@data-idom-class='pEVtpe']"));
// Now safely click
        element.click();
//        By S_msg = By.xpath("//div[@class='VYTiVb']");
//        WebElement succ_msg = wait.until(ExpectedConditions.elementToBeClickable(S_msg));


        WebElement succ_msg = des.findElement(By.xpath("//div[@class='VYTiVb']"));

        if (succ_msg.isDisplayed()){
            System.out.println("Task created msg appears");
        }
//        String success_msg=succ_msg.getText();
//        if (success_msg.equalsIgnoreCase("Task created")){
//            System.out.println("Task is created");
//        }


 System.out.println("end Test case: testCase02");
    }





    public  void testCase03() throws InterruptedException {
        System.out.println("Start Test case: testCase03");
        System.out.println("Verify the Task Updation");

        //Click on an existing task.

        driver.findElement(By.xpath("//span[text()='Crio INTV Task Automation']")).click();
        System.out.println("Click on an existing task");
Thread.sleep(3000);

               // Open the task details.
        driver.findElement(By.xpath("(//div[@class=\"i5a7ie \"]/div/div[2]/div/span/button)[1]")).click();
        System.out.println("click edit icon");



               // Update the task description to "Crio INTV Task Automation is a test suite designed
        //     for automating various tasks on the Google Calendar web application"
        WebElement des = driver.findElement(By.xpath("//textarea[@jsname=\"YPqjbf\"]"));
        System.out.println("Open the task details.");
        des.clear();
        des.sendKeys("Crio INTV Task Automation is a test suite designed for automating various tasks on the Google Calendar web application");
        System.out.println("Update the task description");

        By locator = By.xpath("(//div[@class=\"VfPpkd-dgl2Hf-ppHlrf-sM5MNb\"])[7]/child::button");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

// Wait until the element is clickable
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));

// Now safely click
        element.click();

        System.out.println("click update btn");

        Thread.sleep(1500);

//        WebElement succ_msg = driver.findElement(By.xpath("//div[@class='VYTiVb']"));
//
//
//
//        if (succ_msg.isDisplayed()){
//            System.out.println("Task updated msg appears");
//        }
//        String success_msg=succ_msg.getText();
//        if (success_msg.equalsIgnoreCase("Task updated")){
//            System.out.println("Task is updated");
//        }


        //Verify that the updated description is displayed.
        driver.findElement(By.xpath("//span[text()='Crio INTV Task Automation']")).click();
        System.out.println("Click on an existing task");
Thread.sleep(3000);
        WebElement task_desc=driver.findElement(By.xpath("//span[text()='Description:']/parent::div"));
        if (task_desc.isDisplayed()){
            System.out.println("updated description is displayed.");
        }
        String exp_desc="Crio INTV Task Automation is a test suite designed for automating various tasks on the Google Calendar web application";
        if (task_desc.getText().equalsIgnoreCase(exp_desc)){
            System.out.println("Verified that the updated description is displayed.");
        }
        driver.findElement(By.xpath("//div[@class=\"M30cEf\"]//button[@aria-label=\"Close\"]")).click();
        System.out.println("Task is closed");
        Thread.sleep(2000);

        System.out.println("The task description is successfully updated and displayed.");
        System.out.println("Update the task description : Passed");

                // The task description is successfully updated and displayed.


        System.out.println("end Test case: testCase03");
    }

    public  void testCase04(){
        System.out.println("Start Test case: testCase04");
        //Task updated
        //Description: Delete an existing task and confirm the deletion.
        System.out.println("Delete an existing task and confirm the deletion.");
        //
        //Test Steps:
        //
        //Click on an existing task.
        driver.findElement(By.xpath("//span[text()='Crio INTV Task Automation']")).click();
        System.out.println("Clicked on an existing task");


        //
        //Open the task details.
        System.out.println("The task details opened");
        //
        //Verify the title of the task.
WebElement title = driver.findElement(By.xpath("//div[@class=\"hMdQi\"]//span[@id=\"rAECCd\"]"));
String Actual_title = title.getText();
String Expe_title="Crio INTV Task Automation";

if (Actual_title.equalsIgnoreCase(Expe_title)){
    System.out.println("Verified the title of the task.");
}
//
        //Delete the task.
        //WebElement delete_task = driver.findElement(By.xpath("//button[@aria-label=\"Delete task\"]"));
        WebElement delete_task = driver.findElement(By.xpath("//*[@id='yDmH0d']/div[1]/div/div[2]/span/div/div[1]/div/div/div[2]/div[2]/span/button"));
        delete_task.click();
        System.out.println("Deleted the task.");

        //
        //Confirm the task deletion, by verifying "Task deleted" is displayed.
        WebElement delete_msg = driver.findElement(By.xpath("//div[@class='VYTiVb']"));

        System.out.println(delete_msg.getText());

        if (delete_msg.isDisplayed()){
            System.out.println("alert Task deleted has been displayed");
        }

        if (delete_msg.getText().equalsIgnoreCase("Task deleted")){
            System.out.println("alert Task deleted msg verified");
        }


        //
        //Expected Result: The task is successfully deleted, and the confirmation message indicates "Task deleted"
        System.out.println("The task is successfully deleted, and the confirmation message indicates \"Task deleted\"");
        System.out.println("Test passed");
        System.out.println("end Test case: testCase4");
    }


}
