package utils;

import static java.lang.String.format;
import static java.lang.System.currentTimeMillis;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import static utils.DriverManager.getDriverManager;

import java.io.File;

public class ScreenshotUtil {

    @SneakyThrows
    public static void getScreenshot() {
        File screenshot = ((TakesScreenshot) getDriverManager().getDriver())
                .getScreenshotAs(OutputType.FILE);
//
//        Point point = pageElement.getLocation();
//        int width = pageElement.getSize().getWidth();
//        int height = pageElement.getSize().getHeight();
//
//        BufferedImage fullImg = read(screenshot);
//        BufferedImage elementScreenshot = fullImg.getSubimage(point.getX(), point.getY(), width, height);
//        ImageIO.write(elementScreenshot, "png", screenshot);

        File screenshotLocation = new File(format("src/test/resources/screenshots/%s/screen%s.png",
                 currentTimeMillis()));
        FileUtils.copyFile(screenshot, screenshotLocation);
    }

}
