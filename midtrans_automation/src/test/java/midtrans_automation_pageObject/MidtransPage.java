package midtrans_automation_pageObject;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MidtransPage {

    private static final Logger LOG = LoggerFactory.getLogger(MidtransPage.class);
    public static By homePageHeader =By.xpath("//a[text()='Coco']");
    public static By midTranstitle =By.xpath("//span[text()='Rp ']/parent::div/parent::*/div[1]");
    public static By productAmount = By.xpath("//div[@class='price']/span[2]");
    public static By amountCurrency = By.xpath("//div[@class='price']/span[1]");
    public static By buyNow = By.xpath("//a[@class='btn buy']");
    public static By midtransSubHeader = By.xpath("//div[@class='desc']/span");
    public static By transactionSuccessStatus = By.xpath("//div[@class='trans-status trans-success']/span[1]");
}
