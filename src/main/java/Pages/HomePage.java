package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase{

    public HomePage(WebDriver driver) {
        super(driver);
    }
    //Define Element h6 Dashboard
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6")
    WebElement Dashboard ;

    // Function to get the Page title
    public  String getTitle()
    {
        return Dashboard.getText();
    }
}
