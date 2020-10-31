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
	 public static By orderSummaryHeading = By.xpath("//div[(@id = 'application')]//p[@class='text-page-title-content']");
	 public static By amountOrderSummary = By.xpath("//span[@class='text-amount-amount']");
	 public static By continueBtn = By.xpath("//span[contains(text(),'Continue')]");
	 public static By crossicon = By.xpath("//a[@class='header-back']");
	 public static By selectPaymentHeading = By.xpath("//p[contains(text(),'Select Payment')]");
	 public static By backChevron = By.xpath("//span[@class='sprite header-prev']");
	 public static By creditDebitCard = By.xpath("//*[contains(text(),'Credit/Debit Card')]");
	 public static By goPay = By.xpath("//div[contains(text(),'GoPay')][1]");
	 public static By cardNumber = By.name("cardnumber");
	 public static By expiryDate = By.xpath("//div[contains(@class,'card-container')][2]/div[2]");
	 public static By cVV = By.xpath("//div[contains(@class,'card-container')][2]/div[3]");
	 public static By payNow = By.xpath("//span[contains(text(),'Pay Now')]");
	 public static By passwordOtp = By.xpath("//input[@id='PaRes']");
	 public static By submitOtp = By.name("ok");
	 public static By transactionStatusFail = By.xpath("//div[contains(@class,'text-failed')][1]/span");
}
