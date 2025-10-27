package utils;

import org.openqa.selenium.WebElement;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

   public class Utility {

        public static void printElementInfo(String name, WebElement element) {
            String marker = "------------------------------";
            System.out.println(marker);
            System.out.println("Element meta-data: " + name);
            System.out.println(marker);
            System.out.println("WebElement object:: " + element);
            System.out.println("Outer HTML:: " + element.getAttribute("outerHTML"));
            System.out.println("Inner HTML:: " + element.getAttribute("innerHTML"));
            System.out.println("Text:: " + element.getText());
            System.out.println("Value::" + element.getAttribute("value"));
            System.out.println("Tag:: " + element.getTagName());
            System.out.println("Displayed?:: " + element.isDisplayed());
            System.out.println("Selected?:: " + element.isSelected());
            System.out.println("Enabled?:: " + element.isEnabled());
            System.out.println(marker);
        }
        public static double extractPriceFromText(String rawPriceText){

            System.out.println("Raw price text:" + rawPriceText);

            //Keeping only numbers and dots. Replacing the rest with space
            String cleanedPrice = rawPriceText.replaceAll("[^0-9.]"," ").trim();

            cleanedPrice = cleanedPrice.replace(",", ".");
            try{
                return Double.parseDouble(cleanedPrice);
            }   catch (NumberFormatException e){
            //Taking the first number
                 System.out.println("Error message: "+ e.getMessage());
            return 0.0;
        }}

       public static void clearDownloadFolder(String downloadPath) {
           try {
               File folder = new File(downloadPath);

               //  Crear la carpeta si no existe
               if (!folder.exists()) {
                   folder.mkdirs();
                   System.out.println("Carpeta creada: " + downloadPath);
                   return; // como estaba vacía, no hay archivos que borrar
               }

               //  Borrar todos los archivos dentro de la carpeta
               Files.walk(folder.toPath())
                       .map(Path::toFile)
                       .filter(File::isFile)
                       .forEach(File::delete);

               System.out.println("Carpeta limpiada: " + downloadPath);

           } catch (Exception e) {
               System.out.println("Error clearing download folder: " + e.getMessage());
           }
       }

        public static boolean waitForNewFile(File folder, int timeoutInSeconds, int originalFileCount) {

            System.out.println("originalFileCount:"+originalFileCount);
            int elapsed = 0;
            while (elapsed < timeoutInSeconds) {
                File[] files = folder.listFiles();
                if (files != null && files.length > originalFileCount) {
                    System.out.println("new file count:"+files.length);
                    return true; // New file appeared
                }
                try {
                    Thread.sleep(1000); // poll every 1 second
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                elapsed++;
            }
            return false; // timeout reached
        }

        public static boolean compareDates(String date1, String format1,String date2, String format2){

            try {
                //"MM/dd/yyyy"   "dd/MM/yyyy"
                DateTimeFormatter date1Formatter = DateTimeFormatter.ofPattern(format1);
                LocalDate date1LocalDate = LocalDate.parse(date1,date1Formatter);

                //"yyyy-MM-dd" "yyyy-dd-MM"
                DateTimeFormatter date2Formatter = DateTimeFormatter.ofPattern(format2);
                LocalDate date2LocalDate = LocalDate.parse(date2, date2Formatter);

                return date1LocalDate.equals(date2LocalDate);
            }catch (Exception e){
                System.out.println("Error parsing dates: "+e.getMessage());
                return false;
            }

        }

    }