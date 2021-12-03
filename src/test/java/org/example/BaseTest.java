package org.example;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.log4j.PropertyConfigurator;

public class BaseTest
{
    protected static WebDriver driver;
    protected static WebDriverWait wait;

    private final String userName = "testertester528890";
    private final String password = "test123test";
    private static final String driverPath = "src/test/resources/chromedriver.exe";
    private static final String mainUrl = "https://www.gittigidiyor.com/";
    private final By girisYapButton = By.cssSelector("div[class='gekhq4-6 hnYHyk'][title='Giriş Yap']");
    private final By girisYapMenuButton = By.cssSelector("a[data-cy='header-login-button']");
    private final By userNameField = By.id("L-UserNameField");
    private final By passwordField = By.id("L-PasswordField");
    private final By confirmGirisYapButton = By.id("gg-login-enter");
    private final By hesabımTitle = By.cssSelector("div[title='Hesabım']");
    private final By searchBox = By.name("k");
    private final By isItemFound = By.cssSelector("div[class='m96g9g-1 gKNIBK']");
    private final By elementsAlreadyLiked = By.cssSelector("div[class='ndodpt-1 bgCibU sc-1n49x8z-13 dchmcc']");
    private final By elementsToBeLiked = By.cssSelector("div[class='ndodpt-1 bgCibU sc-1n49x8z-13 ceCTui']");
    private final By elementToBeBought = By.cssSelector("div[class='sc-533kbx-0 sc-1v2q8t1-0 iCRwxx ixSZpI sc-1n49x8z-12 bhlHZl']");
    private final By addToBasket = By.id("add-to-basket");
    private final By basketItemCountOnMenu = By.cssSelector("span[class='notify-user basket-item-count']");
    private final By sepetimButton = By.xpath("//*[contains(text(),'Sepetim')]");
    private final By itemCountOnCart = By.cssSelector("select[class='amount']");
    private final By alisverisiTamamlaButton = By.cssSelector("input[value='Alışverişi Tamamla']");
    private final By summaryField = By.id("shopping-total-info");
    private final By adresKaydetButton = By.cssSelector("button[value='Kaydet']");
    private final By errorField = By.cssSelector("div[class='gg-input gg-input-select invalid']");
    private final By sepetDuzenleButton = By.cssSelector("a[class='header-link pl10'][title='Sepeti Düzenle']");
    private final By addFavItemToCart = By.cssSelector("a[class='gg-ui-btn-default btn-add-to-basket']");
    private final By controlCart = By.cssSelector("select[class='amount']");
    private final By deleteItemFromFav = By.cssSelector("button[class='delete-watch-products robot-delete-all-button']");
    private final By removedText = By.xpath("//*[contains(text(),'Tebrikler. Ürünler izlediklerim listesinden çıkartıldı.')]");
    private final By anaSayfaTitle = By.cssSelector("a[title='GittiGidiyor']");
    private final By cikisButton = By.cssSelector("a[title='Çıkış']");

    @BeforeAll
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver",driverPath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        driver = new ChromeDriver(options);
        driver.get(mainUrl);
        wait = new WebDriverWait(driver,20);
        PropertyConfigurator.configure("src/test/resources/log4j.properties");
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }


    protected String getUserName() {
        return userName;
    }

    protected String getPassword() {
        return password;
    }

    protected By getGirisYapButton() {
        return girisYapButton;
    }

    protected By getGirisYapMenuButton() {
        return girisYapMenuButton;
    }

    protected By getUserNameField() {
        return userNameField;
    }

    protected By getPasswordField() {
        return passwordField;
    }

    protected By getConfirmGirisYapButton() {
        return confirmGirisYapButton;
    }

    protected By getHesabımTitle() {
        return hesabımTitle;
    }

    protected By getSearchBox() {
        return searchBox;
    }

    protected By getIsItemFound() {
        return isItemFound;
    }

    protected By getElementsAlreadyLiked() {
        return elementsAlreadyLiked;
    }

    protected By getElementsToBeLiked() {
        return elementsToBeLiked;
    }

    protected By getElementToBeBought() {
        return elementToBeBought;
    }

    protected By getAddToBasket() {
        return addToBasket;
    }

    protected By getBasketItemCountOnMenu() {
        return basketItemCountOnMenu;
    }

    protected By getSepetimButton() {
        return sepetimButton;
    }

    protected By getItemCountOnCart() {
        return itemCountOnCart;
    }

    protected By getAlisverisiTamamlaButton() {
        return alisverisiTamamlaButton;
    }

    protected By getAdresKaydetButton() {
        return adresKaydetButton;
    }

    protected By getSepetDuzenleButton() {
        return sepetDuzenleButton;
    }

    protected By getAddFavItemToCart() {
        return addFavItemToCart;
    }

    protected By getDeleteItemFromFav() {
        return deleteItemFromFav;
    }

    protected By getAnaSayfaTitle() {
        return anaSayfaTitle;
    }

    protected By getCikisButton() {
        return cikisButton;
    }

    protected By getSummaryField() {
        return summaryField;
    }

    protected By getErrorField() {
        return errorField;
    }

    protected By getControlCart() {
        return controlCart;
    }

    protected By getRemovedText() {
        return removedText;
    }
}
