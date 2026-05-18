//package tests;
//
//import base.Base;
//import dataDriven.ExcelUtils;
//import pages.ToDoPage;
//
//import org.openqa.selenium.By;
//import org.testng.Assert;
//import org.testng.annotations.*;
//
//public class ToDoTest extends Base {
//
//	ToDoPage page;
//
//	@BeforeClass
//	public void start() {
//		setup();
//		page = new ToDoPage(driver, wait);
//	}
//
//	// =========================
//	// CREATE TASKS
//	// =========================
////    @Test(priority = 1)
////    public void createTasks() {
////
////        String[] tasks = {"Meeting", "Workout", "Study"};
////
////        for (int i = 0; i < tasks.length; i++) {
////
////            page.enterTask(tasks[i]);
////            page.setDate();
////            page.setTime();
////            page.setDuration();
////            page.selectPriority("High");
////            page.clickAdd();
////
////            pause(2000);
////        }
////    }
//	public void createTasksFromExcel() {
//		int rows = ExcelUtils.getRowCount();
//
//		for (int i = 1; i <= rows; i++) {
//			String name = ExcelUtils.getData(i, 0);
//			String hours = ExcelUtils.getData(i, 1);
//			String minutes = ExcelUtils.getData(i, 2);
//			String seconds = ExcelUtils.getData(i, 3);
//			String priority = ExcelUtils.getData(i, 4);
//
//			// Enter task
//			page.enterTask(name);
//			page.setDate();
//			page.setTime();
//
//			// Duration
//			driver.findElement(By.id("hoursInput")).clear();
//			driver.findElement(By.id("minutesInput")).clear();
//			driver.findElement(By.id("secondsInput")).clear();
//
//			driver.findElement(By.id("hoursInput")).sendKeys(hours);
//			driver.findElement(By.id("minutesInput")).sendKeys(minutes);
//			driver.findElement(By.id("secondsInput")).sendKeys(seconds);
//
//			page.selectPriority(priority);
//			page.clickAdd();
//
//			pause(2500);
//
//			System.out.println("Task Created Successfully");
//		}
//	}
//
//	// =========================
//	// EDIT + UPDATE
//	// =========================
//	@Test(priority = 2)
//	public void updateTask() {
//
//		Assert.assertTrue(driver.findElements(By.xpath("//ul[@id='taskList']/li")).size() > 0,
//				"❌ No task found to perform action");
//
//		page.clickEdit();
//		pause(2000);
//
//		page.enterTask("Updated Meeting");
//		page.selectPriority("Medium");
//		page.clickAdd();
//
//		pause(2000);
//	}
//
//	// =========================
//	// COMPLETE
//	// =========================
//	@Test(priority = 3)
//	public void completeTask() {
//
//		Assert.assertTrue(driver.findElements(By.xpath("//ul[@id='taskList']/li")).size() > 0,
//				"❌ No task found to perform action");
//
//		page.clickComplete();
//		pause(2000);
//	}
//
//	// =========================
//	// VALIDATE TOTAL
//	// =========================
//	@Test(priority = 4)
//	public void validateTotal() {
//
//		page.calculateTotal();
//		pause(1500);
//
//		String total = page.getTotal();
//
//		Assert.assertNotNull(total, "Total duration not generated");
//	}
//
//	// =========================
//	// DELETE
//	// =========================
//	@Test(priority = 5)
//	public void deleteTask() {
//
//		Assert.assertTrue(driver.findElements(By.xpath("//ul[@id='taskList']/li")).size() > 0,
//				"❌ No task found to perform action");
//
//		page.clickDelete();
//		pause(2000);
//	}
//
//	@AfterClass
//	public void end() {
//		tearDown();
//	}
//}

package tests;

import base.Base;
import dataDriven.ExcelUtils;
import pages.ToDoPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class ToDoTest extends Base {

    ToDoPage page;

    @BeforeClass
    public void start() {
        setup();
        page = new ToDoPage(driver, wait);
    }

    // ✅ CREATE TASKS FROM EXCEL
    @Test(priority = 1)
    public void createTasksFromExcel() {

        System.out.println("\n===== STEP 1: CREATING TASKS FROM EXCEL =====\n");
        
        System.out.println("==========================================Rows Count : " + ExcelUtils.getRowCount());

        int rows = ExcelUtils.getRowCount();

        for (int i = 1; i <= rows; i++) {

            System.out.println("Creating Task Row: " + i);

            String name = ExcelUtils.getData(i, 0);
            String hours = ExcelUtils.getData(i, 1);
            String minutes = ExcelUtils.getData(i, 2);
            String seconds = ExcelUtils.getData(i, 3);
            String priority = ExcelUtils.getData(i, 4);

            page.enterTask(name);
            pause(1000);

            page.setDate();
            pause(1000);

            page.setTime();
            pause(1000);

            page.setDuration(hours, minutes, seconds);
            pause(1000);

            page.selectPriority(priority);
            pause(1000);

            page.clickAdd();
            pause(3000);
        }

        List<WebElement> tasks = driver.findElements(By.xpath("//ul[@id='taskList']/li"));

        System.out.println("📌 Total Tasks Created: " + tasks.size());

        Assert.assertTrue(tasks.size() > 0, "Task creation failed");
    }

    // ✅ UPDATE
    @Test(priority = 2)
    public void updateTask() {

        System.out.println("\n===== STEP 2: UPDATING TASK =====\n");

        List<WebElement> tasks = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(
                        By.xpath("//ul[@id='taskList']/li")));

        Assert.assertTrue(tasks.size() > 0, "No task before update");

        page.clickEdit();
        pause(2000);

        page.enterTask("Updated Meeting");
        pause(1000);

        page.selectPriority("Medium");
        pause(1000);

        page.clickAdd();
        pause(3000);

        System.out.println("Task Updated Successfully");
    }

    // ✅ COMPLETE
    @Test(priority = 3)
    public void completeTask() {

        System.out.println("\n===== STEP 3: COMPLETE TASK =====\n");

        List<WebElement> tasks = driver.findElements(By.xpath("//ul[@id='taskList']/li"));
        Assert.assertTrue(tasks.size() > 0, "❌ No task for completion");

        page.clickComplete();
        pause(3000);
    }

    // ✅ TOTAL
    @Test(priority = 4)
    public void validateTotal() {

        System.out.println("\n===== STEP 4: TOTAL DURATION =====\n");

        page.calculateTotal();
        pause(2000);

        String total = page.getTotal();

        System.out.println("Total Duration: " + total);

        Assert.assertNotNull(total);
    }

    // ✅ DELETE
    @Test(priority = 5)
    public void deleteTask() {

        System.out.println("\n===== STEP 5: DELETE TASK =====\n");

        List<WebElement> tasks = driver.findElements(By.xpath("//ul[@id='taskList']/li"));
        Assert.assertTrue(tasks.size() > 0, "❌ No task for delete");
       

        page.clickDelete();
        pause(3000);

        System.out.println("Task Deleted Successfully");
    }

    @AfterClass
    public void end() {
        tearDown();
    }
}
