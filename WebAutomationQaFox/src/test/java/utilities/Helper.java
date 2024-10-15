package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Helper {

    public static void captureScreenshot(WebDriver driver, String screenshotName) throws IOException {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Path dest = Paths.get("./Screenshots", screenshotName + ".png");
        Files.createDirectories(dest.getParent());
        Files.copy(screenshot.toPath(), dest);



    }

}
