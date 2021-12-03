package base;

import org.example.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class BasePage extends BaseTest {

    public WebElement findElement(By by){
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        return driver.findElement(by);
    }

    public List<WebElement> findElements (By by) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        return driver.findElements(by);
    }

    public JavascriptExecutor getJSExecutor() {
        return (JavascriptExecutor) driver;
    }

    public void scrollTo(int x, int y) {
        String jsStmt = String.format("window.scrollTo(%d, %d);", x, y);
        getJSExecutor().executeScript(jsStmt, true);
    }
    public void scrollToBottom() {

        getJSExecutor().executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void hoverElement(By by) {
        Actions action = new Actions(driver);
        action.moveToElement(findElement(by)).build().perform();
    }

    public WebElement randomElement(By by) {

        int random = (int) (Math.random()*driver.findElements(by).size());

        return driver.findElements(by).get(random);
    }
    public String addRandomsToFavourite(By by) throws InterruptedException {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i=0; i<driver.findElements(by).size(); i++) {
            list.add(i);
        }
        Collections.shuffle(list);
        WebElement element = null;
        String textOfThirdAddedElement = null;
        int totalElementSize=driver.findElements(By.name("like")).size();
        for (int i=0; i<4; i++) {
            wait.until(ExpectedConditions.elementToBeClickable(by));
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
            TimeUnit.SECONDS.sleep(2);

            if(i==2)
            {
                element=driver.findElements(by).get(list.get(i));
                for (int j = 0; j<totalElementSize; j++) {
                    if (element.getAttribute("id").equals(driver.findElements(By.name("like")).get(j).getAttribute("id")))
                    {
                        textOfThirdAddedElement=element.getText();
                        break;
                    }
                    else
                    {

                    }
                }
            }
            else
            {

            }
            getJSExecutor().executeScript("arguments[0].scrollIntoView(true);",driver.findElements(by).get(list.get(i)));
            driver.findElements(by).get(list.get(i)).click();

        }
        return textOfThirdAddedElement;
    }






    /*public WebElement randomElements(By by) {
        //wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        List<WebElement> elements = new ArrayList<WebElement>();
        for (int i = 0; i < 4; i++) {
            int random = (int) (Math.random()*driver.findElements(by).size());
            elements.add(driver.findElement(by).get(random));
        }

        return driver.findElements(by).get(random);
    }*/

    public void switchTo() {

        String currentWindow = driver.getWindowHandle();

        Set<String> windowsHandles = driver.getWindowHandles();
        for (String pencere : windowsHandles){
            if(!currentWindow.equals(pencere)){
                driver.switchTo().window(pencere);
            }
        }

    }

    public void click(By by) {
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        wait.until(ExpectedConditions.elementToBeClickable(by));
        findElement(by).click();
    }

    public void click (WebElement wb) {
        wait.until(ExpectedConditions.elementToBeClickable(wb));
        wb.click();
    }

    public void sendKeys (By by, String text) {
        findElement(by).sendKeys(text);
    }
    public void sendKeys (WebElement wb, String text) {
        wb.sendKeys(text);
    }
}
