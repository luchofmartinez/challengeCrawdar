package frontend;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;

public class CrawdarChallengeTest_BasePage
{
    static WebDriver webDriver;
    static ExtentTest test;
    static ExtentSparkReporter report;
    static ExtentReports extent;

    public void inicializarReporte(String page){
        report = new ExtentSparkReporter(System.getProperty("user.dir") + "/reportes/reporte"+page+".html");
        report.config().setDocumentTitle("Crawdar Report ");
        report.config().setReportName("Automation report");
        report.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(report);
    }
}
