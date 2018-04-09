package web;

import facades.ItemFacade;
import model.Item;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import static org.junit.Assert.*;

public class IndexControllerTest {

    private static WebDriver webDriver;

    @Before
    public void beforeAll() {
        System.setProperty("webdriver.chrome.driver", "/Users/andrejsakal/Downloads/chromedriver");
        webDriver = new ChromeDriver();
        webDriver.get("http://localhost:8080/sel/");
        webDriver.manage().window().maximize();
    }

    @Test
    public void addItem() {
        for (int i = 0; i < 10; i++) {
            Item item = new Item("ItemName {"+i+"}", "ItemDescr", (14*i));
            webDriver.findElement(By.id("input_firstName")).sendKeys(item.getName());
            webDriver.findElement(By.id("input_firstName")).sendKeys(item.getName());
        }
    }

    @Test
    public void addCustomer() {
    }
}