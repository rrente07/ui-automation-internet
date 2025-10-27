package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
public class WebDriverFactory{
    public static WebDriver createDriver(BrowserType type){

        WebDriver driver;

        switch (type){
            case FIREFOX :
                //we set up the configurations
                driver = new FirefoxDriver();
                break;
            case CHROME:

            default:
                ChromeOptions options = new ChromeOptions();
                File downloadDir = new File(Configuration.DOWNLOAD_PATH);
                if (!downloadDir.exists()) {
                    downloadDir.mkdirs();
                }
                Map<String,Object> prefs = new HashMap<>();
                prefs.put("download.default_directory", Configuration.DOWNLOAD_PATH);
                prefs.put("download.prompt_for_download",false);
                prefs.put("safebrowsing.enabled",true);
                options.setExperimentalOption("prefs",prefs);

                // Detect if we are running in Jenkins (enviroments headless)
                boolean isJenkins = System.getenv("JENKINS_HOME") != null;

                if(isJenkins){
                    options.addArguments("--headless=new");           // usa "new" para la nueva implementación de headless
                    options.addArguments("--no-sandbox");             // recomendado para entornos Linux sin GUI
                    options.addArguments("--disable-dev-shm-usage");  // evita errores por recursos compartidos
                    options.addArguments("--window-size=1920,1080");  // asegura tamaño suficiente para tests visuales
                    options.addArguments("--remote-allow-origins=*"); // si ves errores con políticas de seguridad
                }else{
                    options.addArguments("--start-maximized"); // útil en ejecución local
                }

                driver = new ChromeDriver(options);
                break;

        }

        DriverManager.setDriver(driver);
        return driver;

    }
}
