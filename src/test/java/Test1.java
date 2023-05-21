import org.openqa.selenium.By ;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;
public class Test1 {
    @Test
    public void testAddRemoveElements() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        WebElement Button = driver.findElement(By.id("login-button"));
        WebElement Username = driver.findElement(By.id("user-name"));
        WebElement Password = driver.findElement(By.id("password"));
        Username.clear();
        Username.click();
        Username.sendKeys("standard_user");
        Password.clear();
        Password.click();
        Password.sendKeys("secret_sauce");
        Button.click();
        WebElement AddToBasket = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        AddToBasket.click();
        WebElement Basket = driver.findElement(By.id("shopping_cart_container"));
        Basket.click();
        WebElement NameLabel = driver.findElement(By.id("item_4_title_link"));
        Assert.assertEquals(NameLabel.getText(),"Sauce Labs Backpack");
        WebElement CostLabel = driver.findElement(By.cssSelector("[class=inventory_item_price]"));
        Assert.assertEquals(CostLabel.getText(), "$29.99");
        WebElement CheckButton = driver.findElement(By.cssSelector("[name=checkout]"));
        CheckButton.click();
        WebElement First_Name = driver.findElement(By.cssSelector("[name=firstName]"));
        WebElement Last_Name = driver.findElement(By.cssSelector("[name=lastName]"));
        WebElement ZipCode = driver.findElement(By.cssSelector("[name=postalCode]"));
        First_Name.clear();
        First_Name.sendKeys("Aboba");
        Last_Name.clear();
        Last_Name.sendKeys("Negus");
        ZipCode.clear();
        ZipCode.sendKeys("1234567");
        WebElement ContinueButton = driver.findElement(By.cssSelector("[name=continue]"));
        ContinueButton.click();
        WebElement EndButton = driver.findElement(By.xpath("//button[text()='Finish']"));
        EndButton.click();
        WebElement SuccessFull = driver.findElement(By.tagName("h2"));
        Assert.assertEquals(SuccessFull.getText(),"Thank you for your order!");
        WebElement GoHomeButton = driver.findElement(By.cssSelector("[name=back-to-products]"));
        GoHomeButton.click();
        driver.quit();
    }
}