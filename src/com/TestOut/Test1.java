package com.TestOut;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Test1 {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions move;



@BeforeSuite
    public void SetUp() {

    System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
    driver = new ChromeDriver();
    wait = new WebDriverWait(driver, 40);
    move = new Actions(driver);


    driver.manage().window().maximize();
    driver.manage().deleteAllCookies();
    driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);


    JavascriptExecutor js = (JavascriptExecutor) driver;



    driver.get("http://testoutlivecontent.blob.core.windows.net/netpro2018v5-en-us/en-us/sims/typescriptv1/netpro2018v5/simstartup_webpack.html?package=netpro2018v5windowspackage&sim=ipademail_np5&dev=true&automation=true");
    driver.findElement(By.id("wpDesktop.DesktopIcon15")).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("siMailContactsCalendars")));
}
        @Test
        public void PortCheck()

    {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("siMailContactsCalendars")));
        driver.findElement(By.id("siMailContactsCalendars")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Maggie Brown']")));
        driver.findElement(By.xpath("//*[text()='Maggie Brown']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("siAccount")));

        driver.findElement(By.id("siAccount")).click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("siAdvanced")));

        driver.findElement(By.id("siAdvanced")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("siUseSSL.Grid.tbOnOff.Grid.SwitchRoot.Canvas.SwitchThumb.Grid.Border.Grid.Background")));

        WebElement slider = driver.findElement(By.id("siUseSSL.Grid.tbOnOff.Grid.SwitchRoot.Canvas.SwitchThumb.Grid.Border.Grid.Background"));

        move.dragAndDropBy(slider, 10, 0).perform();

        var port = driver.findElement(By.id("tbServerPort")).getAttribute("value");
        Assert.assertTrue(port.equals("993"), "The port is incorrect!");
    }
    @Test
        void checkScores() throws InterruptedException {

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnAccount.grid.contentPresenter.TextBlock")));
            driver.findElement(By.id("btnAccount.grid.contentPresenter.TextBlock")).click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnDone.grid.contentPresenter.TextBlock")));
            driver.findElement(By.id("btnDone.grid.contentPresenter.TextBlock")).click();



        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("siWiFi")));
        driver.findElement(By.id("siWiFi")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='CorpNet']")));
        driver.findElement(By.xpath("//*[text()='CorpNet']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Password']")));
        driver.findElement(By.xpath("//*[@type='password']")).sendKeys("@CorpNetWeRSecure!&");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Join']")));
        driver.findElement(By.xpath("//*[text()='Join']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("bDone.Grid.contentPresenter.TextBlock")));
        driver.findElement(By.id("bDone.Grid.contentPresenter.TextBlock")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("_ifrmreport_")));
        WebElement frame = driver.findElement(By.id("_ifrmreport_"));
        driver.switchTo().frame(frame);

        var scores = driver.findElement(By.id("reportDiv")).getText();

        Assert.assertTrue(scores.contains("Your Score: 1 of 1 (100%)"), "The scores are incorrect!");

    }

    @AfterSuite
        void quite() {
            driver.quit();
    }
}




