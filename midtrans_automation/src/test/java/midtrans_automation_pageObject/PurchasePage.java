package midtrans_automation_pageObject;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PurchasePage {
	
	 private static final Logger LOG = LoggerFactory.getLogger(MidtransPage.class);
	 public static By shopingCardLayover =By.xpath("//*[@class = 'cart-content buying']");
	 public static By shopingCardHeading = By.xpath("//span[contains(text(),'Shopping Cart')]");
	 public static By cardItemCount= By.xpath("//span[contains(text(),'Shopping Cart')]/following::span[1]");
	 public static By productName= By.xpath("//td[contains(text(),'Midtrans Pillow')]");
	 public static By totalAmount = By.xpath("//td[@class='amount']");
	 public static By customerDetailsHeading = By.xpath("//*[(@class = 'cart-head')][2]");
	 public static By nameOfCustomer = By.xpath("//*[(@class = 'cart-head')][2]/following::div[@class='cart-section']//tr[1]/td[1]");
	 public static By emailOfCustomer = By.xpath("//*[(@class = 'cart-head')][2]/following::div[@class='cart-section']//tr[2]/td[1]");
	 public static By mobileOfCustomer = By.xpath("//*[(@class = 'cart-head')]2]/following::div[@class='cart-section']//tr[3]/td[1]");
	 public static By cityOfCustomer = By.xpath("//*[(@class = 'cart-head')][2]/following::div[@class='cart-section']//tr[4]/td[1]");
	 public static By addressOfCustomer = By.xpath("//*[(@class = 'cart-head')][2]/following::div[@class='cart-section']//tr[5]/td[1]");
	 public static By postalCode = By.xpath("//*[(@class = 'cart-head')][2]/following::div[@class='cart-section']//tr[6]/td[1]");
	 public static By checkOutBtn = By.xpath("//*[(@class = 'cart-checkout')]");
	 public static By cancelBtn = By.xpath("//*[(@class = 'cancel-btn')]");
}
