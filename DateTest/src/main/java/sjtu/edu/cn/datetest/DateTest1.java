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
public class DateTest1 {
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
    public void testFunctionA1() throws Exception {
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='下一天是哪一天？'])[1]/following::input[1]")).click();
        sleep(100);
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='计算'])[3]/following::button[3]")).click();
        sleep(100);
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='计算'])[3]/following::button[4]")).click();
        sleep(100);
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='计算'])[3]/following::button[4]")).click();
        sleep(100);
        // ERROR: Caught exception [ERROR: Unsupported command [doubleClick | xpath=(.//*[normalize-space(text()) and normalize-space(.)='计算'])[3]/following::button[4] | ]]
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='计算'])[3]/following::button[4]")).click();
        sleep(100);
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='六'])[1]/following::div[18]")).click();
        sleep(100);
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='下一天是哪一天？'])[1]/following::span[4]")).click();
        sleep(100);
        String text1 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[1]/div[2]/span")).getText();
        sleep(100);
        System.out.println(text1);
        TestCase.assertEquals("2020 年 4 月 16 日", text1);
    }

    @Test
    public void testFunctionA2() throws Exception {
        driver.findElement(By.xpath("//div[@id='app']/div/div")).click();
        sleep(100);
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='下一天是哪一天？'])[1]/following::input[1]")).click();
        sleep(100);
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='六'])[1]/following::span[17]")).click();
        sleep(100);
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='下一天是哪一天？'])[1]/following::span[4]")).click();
        sleep(100);
        String text2 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[1]/div[2]/span")).getText();
        sleep(100);
        System.out.println(text2);
        TestCase.assertEquals("2019 年 1 月 16 日", text2);
    }

    @Test
    public void testFunctionA3() throws Exception {
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='计算'])[1]/preceding::div[3]")).click();
        sleep(100);
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='下一天是哪一天？'])[1]/following::input[1]")).click();
        sleep(100);
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='计算'])[3]/following::button[3]")).click();
        sleep(100);
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='六'])[1]/following::span[32]")).click();
        sleep(100);
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='下一天是哪一天？'])[1]/following::button[1]")).click();
        sleep(100);
        String text3 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[1]/div[2]/span")).getText();
        sleep(100);
        System.out.println(text3);
        TestCase.assertEquals("2020 年 1 月 30 日", text3);
    }

    @Test
    public void testFunctionA4() throws Exception {
        driver.findElement(By.xpath("//div[@id='app']/div/div")).click();
        sleep(100);
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='下一天是哪一天？'])[1]/following::input[1]")).click();
        sleep(100);
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='计算'])[3]/following::button[3]")).click();
        sleep(100);
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='六'])[1]/following::span[31]")).click();
        sleep(100);
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='下一天是哪一天？'])[1]/following::button[1]")).click();
        sleep(100);
        String text4 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[1]/div[2]/span")).getText();
        sleep(100);
        System.out.println(text4);
        TestCase.assertEquals("2020 年 1 月 29 日", text4);
    }

    @Test
    public void testFunctionA5() throws Exception {
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='下一天是哪一天？'])[1]/following::input[1]")).click();
        sleep(100);
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='计算'])[3]/following::button[3]")).click();
        sleep(100);
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='计算'])[3]/following::button[4]")).click();
        sleep(100);
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='计算'])[3]/following::button[4]")).click();
        sleep(100);
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='计算'])[3]/following::button[4]")).click();
        sleep(100);
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='六'])[1]/following::span[33]")).click();
        sleep(100);
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='下一天是哪一天？'])[1]/following::button[1]")).click();
        sleep(100);
        String text5 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[1]/div[2]/span")).getText();
        sleep(100);
        System.out.println(text5);
        TestCase.assertEquals("2020 年 5 月 1 日", text5);
    }

    @Test
    public void testFunctionA6() throws Exception {
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='计算'])[1]/preceding::div[3]")).click();
        sleep(100);
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='下一天是哪一天？'])[1]/following::input[1]")).click();
        sleep(100);
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='计算'])[3]/following::button[3]")).click();
        sleep(100);
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='计算'])[3]/following::button[4]")).click();
        sleep(100);
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='计算'])[3]/following::button[4]")).click();
        sleep(100);
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='计算'])[3]/following::button[4]")).click();
        sleep(100);
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='六'])[1]/following::span[32]")).click();
        sleep(100);
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='下一天是哪一天？'])[1]/following::button[1]")).click();
        sleep(100);
        String text6 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[1]/div[2]/span")).getText();
        sleep(100);
        System.out.println(text6);
        TestCase.assertEquals("2020 年 4 月 30 日", text6);
    }

    @Test
    public void testFunctionA7() throws Exception {
        driver.findElement(By.xpath("//div[@id='app']/div/div")).click();
        sleep(100);
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='下一天是哪一天？'])[1]/following::input[1]")).click();
        sleep(100);
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='计算'])[3]/following::button[3]")).click();
        sleep(100);
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='六'])[1]/following::span[33]")).click();
        sleep(100);
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='下一天是哪一天？'])[1]/following::span[4]")).click();
        sleep(100);
        String text7 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[1]/div[2]/span")).getText();
        sleep(100);
        System.out.println(text7);
        TestCase.assertEquals("2020 年 1 月 31 日", text7);
    }

    @Test
    public void testFunctionA8() throws Exception {
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='下一天是哪一天？'])[1]/following::input[1]")).click();
        sleep(100);
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='下一天是哪一天？'])[1]/following::input[1]")).click();
        sleep(100);
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='计算'])[3]/following::button[3]")).click();
        sleep(100);
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='六'])[1]/following::span[34]")).click();
        sleep(100);
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='下一天是哪一天？'])[1]/following::span[4]")).click();
        sleep(100);
        String text8 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[1]/div[2]/span")).getText();
        sleep(100);
        System.out.println(text8);
        TestCase.assertEquals("2020 年 2 月 1 日", text8);
    }

    @Test
    public void testFunctionA9() throws Exception {
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='下一天是哪一天？'])[1]/following::input[1]")).click();
        sleep(100);
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='计算'])[3]/following::button[3]")).click();
        sleep(100);
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='计算'])[3]/following::button[4]")).click();
        sleep(100);
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='六'])[1]/following::span[34]")).click();
        sleep(100);
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='下一天是哪一天？'])[1]/following::button[1]")).click();
        String text9 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[1]/div[2]/span")).getText();
        sleep(100);
        System.out.println(text9);
        TestCase.assertEquals("2020 年 2 月 29 日", text9);
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
