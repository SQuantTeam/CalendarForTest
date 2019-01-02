package sjtu.edu.cn.datetest;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


/**
 * ui test generation 2
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DateTest2 {
    private WebDriver driver;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");//指定驱动路径
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://10.0.1.240:8088/#/hp");
    }

    @Test
    public void testFunction1() throws Exception {
//        function 1 test
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='下一天是哪一天？'])[1]/following::input[1]")).click();
        sleep(200);
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='六'])[1]/following::span[5]")).click();
        sleep(200);
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='下一天是哪一天？'])[1]/following::span[4]")).click();
        sleep(200);
        String text = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[1]/div[2]/span")).getText();
        sleep(200);
        System.out.println(text);
        TestCase.assertEquals("2019 年 1 月 4 日", text);
    }

    public static void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
//            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
