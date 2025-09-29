package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.model.Report;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import config.DriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.util.Date;

public class ExtentManager {

    public static ExtentReports extent;

    public static ExtentReports createInstance(String fileName) {
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(fileName);

        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle(fileName);
        htmlReporter.config().setEncoding("UTF-8");
        htmlReporter.config().setReportName(fileName);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Organization", "RosaTest");
        return extent;
    }
    public static String getReportPathWithClassName(String className){
        String baseDir = System.getProperty("user.dir");
        String reportDir = baseDir +"/reports";
        File directory = new File(reportDir);
        if (!directory.exists()){
            directory.mkdir();
        }
        return reportDir + "/" + className +"_"+ new Date().getTime() + ".html";
    }

    public static String screenshotName;
    public static void captureScreenshot(){
        File srcFile = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
        Date date = new Date();
        screenshotName = date.toString().replace(":","_").replace(" ","_") + ".jpg";
        try{
            FileUtils.copyFile(srcFile,
                    new File(System.getProperty("user.dir")+"\\reports\\"+screenshotName));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private static boolean alreadyCleared = false;
    public static void clearReportsFolderOnce(){
        if(!alreadyCleared){
            File folder = new File(System.getProperty("user.dir")+"\\reports\\");
            if(folder.exists() && folder.isDirectory()){
                for (File file : folder.listFiles()){
                    file.delete();
                }
            }
            alreadyCleared = true;
        }

    }
}
