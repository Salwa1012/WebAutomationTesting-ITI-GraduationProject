package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductReviewPage extends PageBase{
    public ProductReviewPage(WebDriver driver) {
        super(driver);
    }
        private By reviewNameTxt = By.xpath("//*[@id=\"input-name\"]");
        private By reviewText = By.xpath("//*[@id=\"input-review\"]");
        private By rating4RdoBtn = By.xpath("//input[@type='radio' and @value=4]");
        private By submitReviewBtn = By.xpath("//*[@id=\"button-review\"]");
        public By reviewNotification = By.xpath("//*[@id=\"form-review\"]/div[2]");
         public By  successMessage = By.cssSelector(".alert.alert-success.alert-dismissible");

        public void AddProductReview(String reviewName , String reviewMessage){
            type(reviewNameTxt, reviewName);
            type(reviewText, reviewMessage);
            click(rating4RdoBtn);
            click(submitReviewBtn);
        }


    public void AddProductReviewMissingText(){
        click(rating4RdoBtn);
        click(submitReviewBtn);
    }

    public String getReviewSubmissionMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
        return driver.findElement(successMessage).getText();
    }




}
