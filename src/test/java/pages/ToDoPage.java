//package pages;
//
//import org.openqa.selenium.*;
//import org.openqa.selenium.support.ui.*;
//
//public class ToDoPage {
//
//    WebDriver driver;
//    WebDriverWait wait;
//
//    public ToDoPage(WebDriver driver, WebDriverWait wait) {
//        this.driver = driver;
//        this.wait = wait;
//    }
//
//    // =========================
//    // LOCATORS
//    // =========================
//    By taskInput = By.id("taskInput");
//    By addBtn = By.id("addBtn");
//    By calcBtn = By.id("calcBtn");
//
////    By editBtn = By.xpath("//*[@id='taskList']/li[1]/div/i[1]");
////    By completeBtn = By.xpath("//*[@id='taskList']/li[1]/div/i[2]");
////    By deleteBtn = By.xpath("//*[@id='taskList']/li[1]/div/i[3]");
//    By editBtn = By.xpath("(//i[contains(@class,'fa-edit')])[1]");
//    By completeBtn = By.xpath("(//i[contains(@class,'fa-check')])[1]");
//    By deleteBtn = By.xpath("(//i[contains(@class,'fa-trash')])[1]");
//
//
//    // =========================
//    // ACTION METHODS
//    // =========================
//
//    public void enterTask(String name) {
//        wait.until(ExpectedConditions.visibilityOfElementLocated(taskInput)).clear();
//        driver.findElement(taskInput).sendKeys(name);
//    }
//
//    public void setDate() {
//        ((JavascriptExecutor) driver)
//                .executeScript("document.getElementById('dateInput').value='2026-05-10'");
//    }
//
//    public void setTime() {
//        ((JavascriptExecutor) driver)
//                .executeScript("document.getElementById('startTimeInput').value='10:00'");
//    }
//
//    public void setDuration() {
//        driver.findElement(By.id("hoursInput")).clear();
//        driver.findElement(By.id("minutesInput")).clear();
//        driver.findElement(By.id("secondsInput")).clear();
//
//        driver.findElement(By.id("hoursInput")).sendKeys("1");
//        driver.findElement(By.id("minutesInput")).sendKeys("10");
//        driver.findElement(By.id("secondsInput")).sendKeys("5");
//    }
//
//    public void selectPriority(String value) {
//        new Select(driver.findElement(By.id("priorityInput")))
//                .selectByVisibleText(value);
//    }
//
//    public void clickAdd() {
//        driver.findElement(addBtn).click();
//    }
//
//    public void clickEdit() {
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.xpath("//ul[@id='taskList']/li")
//        ));
//
//        wait.until(ExpectedConditions.elementToBeClickable(editBtn)).click();
//    }
//
//
//    public void clickComplete() {
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.xpath("//ul[@id='taskList']/li")
//        ));
//
//        wait.until(ExpectedConditions.elementToBeClickable(completeBtn)).click();
//    }
//
//    public void clickDelete() {
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.xpath("//ul[@id='taskList']/li")
//        ));
//
//        wait.until(ExpectedConditions.elementToBeClickable(deleteBtn)).click();
//    }
//
//    public void calculateTotal() {
//        driver.findElement(calcBtn).click();
//    }
//
//    public String getTotal() {
//        return driver.findElement(By.id("totalDuration")).getAttribute("value");
//    }
//}

//package pages;
//
//import org.openqa.selenium.*;
//import org.openqa.selenium.support.ui.*;
//
//public class ToDoPage {
//
//    WebDriver driver;
//    WebDriverWait wait;
//
//    public ToDoPage(WebDriver driver, WebDriverWait wait) {
//        this.driver = driver;
//        this.wait = wait;
//    }
//
//    By taskInput = By.id("taskInput");
//    By addBtn = By.id("addBtn");
//    By calcBtn = By.id("calcBtn");
//
//    By editBtn = By.xpath("(//i[contains(@class,'fa-edit')])[1]");
//    By completeBtn = By.xpath("(//i[contains(@class,'fa-check')])[1]");
//    By deleteBtn = By.xpath("(//i[contains(@class,'fa-trash')])[1]");
//
//    public void enterTask(String name) {
//        System.out.println("Entering Task: " + name);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(taskInput)).clear();
//        driver.findElement(taskInput).sendKeys(name);
//    }
//
//    public void setDate() {
//        System.out.println("Setting Date...");
//        ((JavascriptExecutor) driver)
//                .executeScript("document.getElementById('dateInput').value='2026-05-10'");
//    }
//
//    public void setTime() {
//        System.out.println("Setting Time...");
//        ((JavascriptExecutor) driver)
//                .executeScript("document.getElementById('startTimeInput').value='10:00'");
//    }
//
//    public void setDuration(String h, String m, String s) {
//        System.out.println("Setting Duration: " + h + "h " + m + "m " + s + "s");
//
//        driver.findElement(By.id("hoursInput")).clear();
//        driver.findElement(By.id("minutesInput")).clear();
//        driver.findElement(By.id("secondsInput")).clear();
//
//        driver.findElement(By.id("hoursInput")).sendKeys(h);
//        driver.findElement(By.id("minutesInput")).sendKeys(m);
//        driver.findElement(By.id("secondsInput")).sendKeys(s);
//    }
//
//    public void selectPriority(String value) {
//        System.out.println("Selecting Priority: " + value);
//        new Select(driver.findElement(By.id("priorityInput")))
//                .selectByVisibleText(value);
//    }
//
//    public void clickAdd() {
//        System.out.println("➕ Clicking Add Task...");
//        driver.findElement(addBtn).click();
//    }
//
//    public void clickEdit() {
//        System.out.println("Clicking Edit...");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='taskList']/li")));
//        wait.until(ExpectedConditions.elementToBeClickable(editBtn)).click();
//    }
//
//    public void clickComplete() {
//        System.out.println("Marking Task as Complete...");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='taskList']/li")));
//        wait.until(ExpectedConditions.elementToBeClickable(completeBtn)).click();
//    }
//
//    public void clickDelete() {
//        System.out.println("Deleting Task...");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='taskList']/li")));
//        wait.until(ExpectedConditions.elementToBeClickable(deleteBtn)).click();
//    }
//
//    public void calculateTotal() {
//        System.out.println("Calculating Total Duration...");
//        driver.findElement(calcBtn).click();
//    }
//
//    public String getTotal() {
//        return driver.findElement(By.id("totalDuration")).getAttribute("value");
//    }
//}

//package pages;
//
//import org.openqa.selenium.*;
//import org.openqa.selenium.support.ui.*;
//import dataDriven.ExcelUtils;
//
//public class ToDoPage {
//
//    WebDriver driver;
//    WebDriverWait wait;
//
//    public ToDoPage(WebDriver driver, WebDriverWait wait) {
//        this.driver = driver;
//        this.wait = wait;
//    }
//
//    By taskInput = By.id("taskInput");
//    By addBtn = By.id("addBtn");
//    By calcBtn = By.id("calcBtn");
//
//    By editBtn = By.xpath("(//i[contains(@class,'fa-edit')])[1]");
//    By completeBtn = By.xpath("(//i[contains(@class,'fa-check')])[1]");
//    By deleteBtn = By.xpath("(//i[contains(@class,'fa-trash')])[1]");
//
//    // ✅ NEW LOCATORS
//    By routineCheckbox = By.id("routineInput");
//    By countdown = By.id("countdownInfo");
//
//    public void enterTask(String name) {
//        System.out.println("Entering Task: " + name);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(taskInput)).clear();
//        driver.findElement(taskInput).sendKeys(name);
//    }
//
//    public void setDate() {
//        ((JavascriptExecutor) driver)
//                .executeScript("document.getElementById('dateInput').value='2026-05-10'");
//    }
//
//    public void setTime() {
//        ((JavascriptExecutor) driver)
//                .executeScript("document.getElementById('startTimeInput').value='10:00'");
//    }
//
//    public void setDuration(String h, String m, String s) {
//
//        driver.findElement(By.id("hoursInput")).clear();
//        driver.findElement(By.id("minutesInput")).clear();
//        driver.findElement(By.id("secondsInput")).clear();
//
//        driver.findElement(By.id("hoursInput")).sendKeys(h);
//        driver.findElement(By.id("minutesInput")).sendKeys(m);
//        driver.findElement(By.id("secondsInput")).sendKeys(s);
//    }
//
//    public void selectPriority(String value) {
//        new Select(driver.findElement(By.id("priorityInput")))
//                .selectByVisibleText(value);
//    }
//
//    // ✅ ✅ NEW METHOD (POM FIX)
//    public void selectRoutineIfNeeded(String taskName) {
//
//        if (taskName.equalsIgnoreCase("travel")) {
//
//            System.out.println("✅ Selecting Routine for: " + taskName);
//
//            WebElement checkbox = driver.findElement(routineCheckbox);
//
//            if (!checkbox.isSelected()) {
//                checkbox.click();
//            }
//        }
//    }
//
//    public void clickAdd() {
//        driver.findElement(addBtn).click();
//    }
//
//    public void clickEdit() {
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='taskList']/li")));
//        wait.until(ExpectedConditions.elementToBeClickable(editBtn)).click();
//    }
//
//    public void clickComplete() {
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='taskList']/li")));
//        wait.until(ExpectedConditions.elementToBeClickable(completeBtn)).click();
//    }
//
//    public void clickDelete() {
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='taskList']/li")));
//        wait.until(ExpectedConditions.elementToBeClickable(deleteBtn)).click();
//    }
//
//    public void calculateTotal() {
//        driver.findElement(calcBtn).click();
//    }
//
//    public String getTotal() {
//        return driver.findElement(By.id("totalDuration")).getAttribute("value");
//    }
//
//    // ✅ MOVED FROM STEP (POM FIX)
//    public String getCountdown() {
//        return driver.findElement(countdown).getText();
//    }
//
//    // ✅ ✅ MAIN LOGIC MOVED HERE
//    public void createTasksFromExcel() {
//
//        int rows = ExcelUtils.getRowCount();
//
//        for (int i = 1; i <= rows; i++) {
//
//            String name = ExcelUtils.getData(i, 0);
//            String h = ExcelUtils.getData(i, 1);
//            String m = ExcelUtils.getData(i, 2);
//            String s = ExcelUtils.getData(i, 3);
//            String priority = ExcelUtils.getData(i, 4);
//
//            if (name == null || name.trim().isEmpty()) continue;
//
//            System.out.println("➡ Creating Task: " + name);
//
//            enterTask(name);
//            setDate();
//            setTime();
//            setDuration(h, m, s);
//            selectPriority(priority);
//
//            selectRoutineIfNeeded(name); 
//
//            clickAdd();
//        }
//    }
//}


package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

import utils.ExcelUtils;

public class ToDoPage {

    WebDriver driver;
    WebDriverWait wait;

    public ToDoPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;

        // ✅ IMPORTANT
        PageFactory.initElements(driver, this);
    }

    // ✅ ELEMENTS

    @FindBy(id = "taskInput")
    WebElement taskInput;

    @FindBy(id = "addBtn")
    WebElement addBtn;

    @FindBy(id = "calcBtn")
    WebElement calcBtn;

    @FindBy(xpath = "(//i[contains(@class,'fa-edit')])[1]")
    WebElement editBtn;

    @FindBy(xpath = "(//i[contains(@class,'fa-check')])[1]")
    WebElement completeBtn;

    @FindBy(xpath = "(//i[contains(@class,'fa-trash')])[1]")
    WebElement deleteBtn;

    @FindBy(id = "priorityInput")
    WebElement priorityDropdown;

    @FindBy(id = "routineInput")
    WebElement routineCheckbox;

    @FindBy(id = "totalDuration")
    WebElement totalDuration;

    @FindBy(id = "countdownInfo")
    WebElement countdown;
    
   
    @FindBy(id="hoursInput")
    WebElement hoursInput;
    @FindBy(id="minutesInput")
    WebElement minutesInput;
    @FindBy(id="secondsInput")
    WebElement secondsInput;
    
    
    
    // ✅ ACTIONS
    public void slow() {
        try { 
        	Thread.sleep(1200); 
        } catch (Exception e) {}
    }

    public void enterTask(String name) {
        System.out.println("Entering Task: " + name);
        wait.until(ExpectedConditions.visibilityOf(taskInput)).clear();
        taskInput.sendKeys(name);
        slow();
    }

    public void setDate() {
        ((JavascriptExecutor) driver)
                .executeScript("document.getElementById('dateInput').value='2026-05-10'");
        slow();
    }

    public void setTime() {
        ((JavascriptExecutor) driver)
                .executeScript("document.getElementById('startTimeInput').value='10:00'");
        slow();
    }

    public void setDuration(String h, String m, String s) {
//        driver.findElement(By.id("hoursInput")).sendKeys(h);
//        driver.findElement(By.id("minutesInput")).sendKeys(m);
//        driver.findElement(By.id("secondsInput")).sendKeys(s);
    	
    	
    	hoursInput.sendKeys(h);
    	minutesInput.sendKeys(m);
    	secondsInput.sendKeys(s);
        slow();
    }

    public void selectPriority(String value) {
        new Select(priorityDropdown).selectByVisibleText(value);
        slow();
    }

    public void selectRoutineIfNeeded(String taskName) {
        if (taskName.equalsIgnoreCase("travel")) {
            System.out.println("Selecting Routine Task");

            if (!routineCheckbox.isSelected()) {
                routineCheckbox.click();
            }
        }
        slow();
    }

    public void clickAdd() {
        addBtn.click();
        slow();
    }

    public void clickEdit() {
        wait.until(ExpectedConditions.visibilityOf(editBtn)).click();
        slow();
    }

    public void clickComplete() {
        wait.until(ExpectedConditions.visibilityOf(completeBtn)).click();
        slow();
    }

    public void clickDelete() {
        wait.until(ExpectedConditions.visibilityOf(deleteBtn)).click();
        slow();
    }

    public void calculateTotal() {
        calcBtn.click();
        slow();
    }

    public String getTotal() {
        return totalDuration.getAttribute("value");
        
    }

    public String getCountdown() {
        return countdown.getText();
        
    }

    // ✅ MAIN FLOW (DATA DRIVEN)

    public void createTasksFromExcel() {

        int rows = ExcelUtils.getRowCount();

        for (int i = 1; i <= rows; i++) {

            String name = ExcelUtils.getData(i, 0);
            String h = ExcelUtils.getData(i, 1);
            String m = ExcelUtils.getData(i, 2);
            String s = ExcelUtils.getData(i, 3);
            String priority = ExcelUtils.getData(i, 4);

            if (name == null || name.trim().isEmpty()) continue;

            System.out.println("Creating Task: " + name);

            enterTask(name);
            setDate();
            setTime();
            setDuration(h, m, s);
            selectPriority(priority);
            selectRoutineIfNeeded(name);
            clickAdd();
        }
    }
    
    

}

