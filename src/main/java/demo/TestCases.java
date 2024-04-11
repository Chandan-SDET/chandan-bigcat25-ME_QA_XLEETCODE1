package demo;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import java.util.logging.Level;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");

        WebDriverManager.chromedriver().timeout(30).setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);

        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);

        // Set browser to maximize and wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01(){
        System.out.println("Start Test case: testCase01");
        driver.get("https://www.google.com");
        driver.get("https://leetcode.com/");
        String url= driver.getCurrentUrl();
        if(url.contains("leetcode"))
        {
            System.out.println("testcase is passed as url contains leetcode");
        }
        else{
            System.out.println("testcase is failed as url does not contain leetcode");

        }

        System.out.println("end Test case: testCase01");
    }

    public  void testCase02(){
        System.out.println("Start Test case: testCase02");
        // driver.get("https://www.google.com");
        driver.get("https://leetcode.com/");
        WebElement ques= driver.findElement(By.xpath("//p[text()='View Questions ']"));
        ques.click();

        String purl= driver.getCurrentUrl();
        if(purl.contains("problemset"))
        {
            System.out.println("testcase is passed as url contains problemset");
        }
        else{
            System.out.println("testcase is failed as url does not contain problemset");

        }
        WebElement ele;
        String title;
        for(int i=3; i<8;i++)
          {
            ele=driver.findElement(By.xpath("(//div[@role='row'])["+i+"]"));
            title=ele.findElement(By.tagName("a")).getText();
            System.out.println(title);

          }
        System.out.println("end Test case: testCase02");
    }


    public  void testCase03(){
        System.out.println("Start Test case: testCase03");
        // driver.get("https://www.google.com");
        driver.get("https://leetcode.com/");
        WebElement ques= driver.findElement(By.xpath("//p[text()='View Questions ']"));
        ques.click();

       
        WebElement ele=driver.findElement(By.xpath("(//div[@role='row'])[3]"));
        ele.click();
        String url= driver.getCurrentUrl();
        if(url.contains("two-sum"))
        {
            System.out.println("testcase is passed as url contains two-sum");
        }
        else{
            System.out.println("testcase is failed as url does not contain two-sum");

        }

       
        System.out.println("end Test case: testCase03");
    }

    public  void testCase04(){
        System.out.println("Start Test case: testCase04");
         driver.get("https://www.google.com");
        driver.get("https://leetcode.com/");
        WebElement ques= driver.findElement(By.xpath("//p[text()='View Questions ']"));
        ques.click();

       
        WebElement ele=driver.findElement(By.xpath("(//div[@role='row'])[3]"));
        ele.click();
        WebElement ele1=driver.findElement(By.id("submissions_tab"));
        ele1.click();
        
        WebElement ele2=driver.findElement(By.xpath("//a[text()='Register or Sign In']"));
        String sin=ele2.getText();
        System.out.println(sin);
        if(sin.contains("Register or Sign In"))
        {
            System.out.println(" The test case is passed The 'Register or Sign In' button is displayed");

        }
        else{

            System.out.println(" The test case is failed The 'Register or Sign In' button is not displayed");

        }
      

       
        System.out.println("end Test case: testCase04");
    }




}
