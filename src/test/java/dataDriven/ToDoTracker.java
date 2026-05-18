package dataDriven;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.io.*;
import java.time.Duration;
import java.text.SimpleDateFormat;
public class ToDoTracker {
 
    public static void main(String[] args) throws Exception {
 
        FileInputStream fis = new FileInputStream("C:\\Users\\2484173\\eclipse-workspace\\TODOTrackerAutomation\\TestData\\Hackathon.xlsx");
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("Sheet1");
        DataFormatter formatter = new DataFormatter();
 
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://springexplorers.vercel.app/");
 
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
 
            Row row = sheet.getRow(i);
 
            String taskName   = formatter.formatCellValue(row.getCell(0));
            String date   = formatter.formatCellValue(row.getCell(1));
            if(DateUtil.isCellDateFormatted(row.getCell(1))) {
            	SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
            	 date=sdf.format(row.getCell(1).getDateCellValue());
            }
            String startTime  = formatter.formatCellValue(row.getCell(2));
            String hours      = formatter.formatCellValue(row.getCell(3));
            String minutes    = formatter.formatCellValue(row.getCell(4));
            String seconds    = formatter.formatCellValue(row.getCell(5));
            String priority   = formatter.formatCellValue(row.getCell(6));
            String expected   = formatter.formatCellValue(row.getCell(7));
 
            // ----- Fill form -----
            driver.findElement(By.id("taskInput")).clear();
            driver.findElement(By.id("taskInput")).sendKeys(taskName);
            
            driver.findElement(By.id("dateInput")).clear();
			driver.findElement(By.id("dateInput")).sendKeys(date);
 
            driver.findElement(By.id("startTimeInput")).clear();
            driver.findElement(By.id("startTimeInput")).sendKeys(startTime);
 
            driver.findElement(By.id("hoursInput")).clear();
            driver.findElement(By.id("hoursInput")).sendKeys(hours);
 
            driver.findElement(By.id("minutesInput")).clear();
            driver.findElement(By.id("minutesInput")).sendKeys(minutes);
 
            driver.findElement(By.id("secondsInput")).clear();
            driver.findElement(By.id("secondsInput")).sendKeys(seconds);
 
            new Select(driver.findElement(By.id("priorityInput")))
                    .selectByVisibleText(priority);
 
            driver.findElement(By.id("addBtn")).click();
 
            // ----- Capture Result -----
            String actual = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[2]/label")).getText();
 
            row.createCell(8).setCellValue(actual);
 
            if (actual.equalsIgnoreCase(expected)) {
                row.createCell(9).setCellValue("PASS");
            } else {
                row.createCell(9).setCellValue("FAIL");
            }
 
            Thread.sleep(1000);
        }
 
        fis.close();
        FileOutputStream fos = new FileOutputStream("C:\\Users\\2484173\\eclipse-workspace\\TODOTrackerAutomation\\TestData\\Hackathon.xlsx");
        workbook.write(fos);
 
        fos.close();
        workbook.close();
        //driver.quit();
 
        System.out.println("✅ Execution completed without Excel cell errors");
    }
}