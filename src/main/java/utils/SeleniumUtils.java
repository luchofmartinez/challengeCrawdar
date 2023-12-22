package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class SeleniumUtils {
    public static void printPantalla(WebDriver driver, String nombreArchivo) {
        File screenshotFile = ((org.openqa.selenium.TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(screenshotFile, new File(nombreArchivo));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
