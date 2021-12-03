package test;

import base.BasePage;
import org.example.BaseTest;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.apache.log4j.Logger;
import org.opentest4j.AssertionFailedError;

import java.util.concurrent.TimeUnit;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Order(0)
public class HomePage extends BaseTest {
    BasePage basePage = new BasePage();
    private static String elementToBeRemoved;
    private static String silinecekElementPath;
    private static Logger log = Logger.getLogger(HomePage.class);


    @Test
    @Order(0)
    public void mainPageTest() {
        log.info("Loglama Başladı");
        log.info("Gittigidiyor anasayfası açıldı.");
        Assertions.assertEquals("https://www.gittigidiyor.com/",driver.getCurrentUrl(),"Gittigidiyor anasayfası açılmadı");
        log.info("Gittigidiyor anasayfasına girildiği doğrulandı");
        //Assertions.assertEquals
        AssertionFailedError errorHandle = new AssertionFailedError();
        boolean a = errorHandle.isActualDefined();

    }
    @Test
    @Order(1)
    public void loginTest() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        basePage.hoverElement(getGirisYapButton());
        log.info("Giriş yap butonuna fare getirildi");
        basePage.click(getGirisYapMenuButton());
        log.info("Giriş yap butonuna tıklandıç");
        basePage.sendKeys(getUserNameField(),getUserName());
        basePage.sendKeys(getPasswordField(),getPassword());
        basePage.click(getConfirmGirisYapButton());
        log.info("Kullanıcı bilgileri girildi ve giriş yapıldı");
        Assertions.assertTrue(driver.findElement(getHesabımTitle()).getText().contains("Hesabım"),"Login yapılmadı");
        log.info("Giriş kontrolü başarılı.");
    }
    @Test
    @Order(2)
    public void searchProd() {
        basePage.findElement(getSearchBox()).sendKeys("kalem" + Keys.ENTER);
        log.info("Arama butonuna kalem yazılarak arama yapıldı");
        basePage.scrollTo(0,3000);

        Assertions.assertTrue(driver.findElement(getIsItemFound()).getText().contains("kalem")&&driver.findElement(getIsItemFound()).getText().contains("ürün bulundu"),"kalem ürün araması yapılamadı");
        log.info("Kalem araması başarıyla yapıldı.");
    }
    @Test
    @Order(3)
    public void addFavourites() throws InterruptedException {

        int numberOfElementLiked = driver.findElements(getElementsAlreadyLiked()).size();
        elementToBeRemoved = basePage.addRandomsToFavourite(getElementsToBeLiked());
        log.info("4 adet ürünü favoriye ekleme işlemi yapıldı");
        TimeUnit.SECONDS.sleep(2);
        int updatedNumberOfElementLiked = driver.findElements(getElementsAlreadyLiked()).size();
        int newNumberOfElementLiked = updatedNumberOfElementLiked-numberOfElementLiked;

        Assertions.assertTrue(newNumberOfElementLiked==4,"4 adet ürün eklenmedi, onun yerine "+ newNumberOfElementLiked+" adet ürün eklendi.");
        log.info("4 adet ürünü favoriye ekleme işlemi yapıldı");
    }
    @Test
    @Order(4)
    public void returnToMainPage() {
        log.info("Anasayfaya geri dönüldü");
        driver.navigate().back();
        Assertions.assertEquals("https://www.gittigidiyor.com/",driver.getCurrentUrl(),"Anasayfaya dönülemedi.");
        log.info("Anasayfaya geri dönme başarılı");
    }

    @Test
    @Order(5)
    public void addProdToCart() throws InterruptedException {
        log.info("Arama butonuna çanta yazılarak arama yapıldı");
        basePage.findElement(getSearchBox()).sendKeys("çanta" + Keys.ENTER);
        TimeUnit.SECONDS.sleep(2);
        basePage.scrollToBottom();
        Assertions.assertTrue(driver.findElement(getIsItemFound()).getText().contains("çanta")&&driver.findElement(getIsItemFound()).getText().contains("ürün bulundu"),"çanta ürün araması yapılamadı");
        log.info("Çanta araması başarıyla yapıldı");
        basePage.click(driver.findElements(getElementToBeBought()).get(6));
        basePage.getJSExecutor().executeScript("arguments[0].scrollIntoView(true);",driver.findElement(getAddToBasket()));


        int itemCounterOnCart;
        try {
            itemCounterOnCart=Integer.parseInt(driver.findElement(getBasketItemCountOnMenu()).getText());
        }
        catch (Exception e)
        {
            itemCounterOnCart=0;
        }
        basePage.click(By.id("add-to-basket"));
        log.info("7.ürün sepete eklendi");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getBasketItemCountOnMenu()));
        Assertions.assertTrue(Integer.parseInt(driver.findElement(getBasketItemCountOnMenu()).getText())==(itemCounterOnCart+1),"Sepete ürün eklenmedi veya yeni çeşit ürün eklenmedi");
        log.info("Sepete ürün ekleme işlemi başarılı");
        TimeUnit.SECONDS.sleep(3);
    }

    @Test
    @Order(6)
    public void goToCart() throws InterruptedException {
        basePage.click(getSepetimButton());
        log.info("Sepetim butonuna tıklandı");
        TimeUnit.SECONDS.sleep(2);
        Assertions.assertEquals("https://www.gittigidiyor.com/sepetim",driver.getCurrentUrl(),"Sepet sayfası açılmadı");
        log.info("Sepet sayfası açıldı.");
    }
    @Test
    @Order(7)
    public void increaseItem() {
        Select select = new Select(driver.findElement(getItemCountOnCart()));
        int currentItemCount = Integer.parseInt(select.getFirstSelectedOption().getText());
        currentItemCount++;
        System.out.println(currentItemCount);
        try {
            select.selectByVisibleText(String.valueOf(currentItemCount));
        }
        catch (Exception e)
        {
            System.out.println("Ürün sayısı maximuma ulaştığı için daha arttırılamaz");
        }

        Assertions.assertEquals(String.valueOf(currentItemCount),select.getFirstSelectedOption().getText(),"Ürün sayısı arttırılamadı.");
    }

    @Test
    @Order(8)
    public void goToPayment() {
        basePage.click(getAlisverisiTamamlaButton());
        boolean isNull=false;
        try {
            Assertions.assertNotNull(driver.findElement(getSummaryField()),"Ödeme sayfası açılamadı.");
        }
        catch (Exception e) {
            isNull=true;
        }
        Assertions.assertFalse(isNull,"Ödeme sayfası açılamadı.");
    }
    @Test
    @Order(9)
    public void saveAddress() throws InterruptedException {
        basePage.click(getAdresKaydetButton());
        boolean isNull=false;
        try {
            Assertions.assertNotNull(driver.findElement(getErrorField()),"Kaydet tuşuna basılamadı veya hata mesajları gözükmedi.");
        }
        catch (Exception e) {
            isNull=true;
        }
        Assertions.assertFalse(isNull,"Kaydet tuşuna basılamadı veya hata mesajları gözükmedi.");

        TimeUnit.SECONDS.sleep(2);
    }
    @Test
    @Order(10)
    public void editCart() {
        basePage.click(getSepetDuzenleButton());
        Assertions.assertEquals("https://www.gittigidiyor.com/sepetim",driver.getCurrentUrl(),"Sepet sayfası açılmadı");
    }
    @Test
    @Order(11)
    public void addProductFromFav() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        int oldSizeOfCart = driver.findElements(getControlCart()).size();
        int sizeOfCart;
        try {
            driver.findElement(getAddFavItemToCart()).click();
        }
        catch (Exception e) {

        }
        finally {
            sizeOfCart = driver.findElements(getControlCart()).size();
        }
        Assertions.assertTrue(sizeOfCart==(oldSizeOfCart+1),"Sepete favorilerden ürün eklenme işlemi yapılamadı.");
        TimeUnit.SECONDS.sleep(2);
    }
    @Test
    @Order(12)
    public void seeAllFav() {
        driver.navigate().to("https://www.gittigidiyor.com/hesabim/izlediklerim");
        Assertions.assertEquals("https://www.gittigidiyor.com/hesabim/izlediklerim",driver.getCurrentUrl(),"İzlediklerim sayfası açılmadı.");
    }
    @Test
    @Order(13)
    public void deleteFavItem() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);

        silinecekElementPath = "//td[following-sibling::td[contains(.,'"+elementToBeRemoved+"')]]";
        try {
            basePage.click(By.xpath(silinecekElementPath));
        }
        catch (TimeoutException e)
        {
            System.out.println("silinmesi gereken eleman bulunamadı, diğer sayfalara düşmüş olabilir."+silinecekElementPath);
        }

        TimeUnit.SECONDS.sleep(3);
        boolean isNull=false;
        try {
            basePage.click(getDeleteItemFromFav());
            Assertions.assertNotNull(driver.findElement(getRemovedText()),"Ürün silindi mesajı alınamadı. Ürün silinemedi.");
        }
        catch (Exception e)
        {
            isNull=true;
        }
        Assertions.assertFalse(isNull,"Ürün silindi mesajı alınamadı. Ürün silinemedi.");
    }
    @Test
    @Order(14)
    public void newTab() throws InterruptedException {

        String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN);
        driver.findElement(getAnaSayfaTitle()).sendKeys(selectLinkOpeninNewTab);
        TimeUnit.SECONDS.sleep(3);

        Assertions.assertTrue(driver.getWindowHandles().size()==2,"Yeni sekme açılamadı");
        basePage.switchTo();
        TimeUnit.SECONDS.sleep(3);

    }
    @Test
    @Order(15)
    public void logout() {
        basePage.hoverElement(getHesabımTitle());
        basePage.click(getCikisButton());

        boolean isNull=false;
        try {
            Assertions.assertNotNull(driver.findElement(getGirisYapButton()),"Çıkış yapılamadı, çünkü giriş yap butonu mevcut.");
        }
        catch (Exception e) {
            isNull=true;
        }
        Assertions.assertFalse(isNull,"Çıkış yapılamadı, çünkü giriş yap butonu mevcut.");

    }
    @Test
    @Order(16)
    public void closeTab() {
        int oldTabCount = driver.getWindowHandles().size();
        driver.close();
        Assertions.assertTrue(driver.getWindowHandles().size()==(oldTabCount-1),"Mevcut tab sayısı değişmedi.");

    }
}
