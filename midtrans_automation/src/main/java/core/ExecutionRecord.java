package core;

import com.google.common.base.CaseFormat;
import core.Params;
import core.WebDriverHelper;
import core.ScreenshotHook;
import cucumber.api.Scenario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExecutionRecord {
    private static final Logger LOG = LoggerFactory.getLogger(ExecutionRecord.class);
    private FileWriter fWriter;
    private BufferedWriter writer;
    private static int stepCount = 0;
    private static String browser;
    String path;



    public ExecutionRecord(String path){
        createDirectory(new File("./target/screenshots/"));
        this.path = path;
        createDirectory(new File(path));
        initScenarioRecord();
    }

    public BufferedWriter getWriter(){
        return this.writer;
    }

    private void createDirectory(File theDir){
        if (!theDir.exists()) {
            try {
                theDir.mkdir();
            } catch (Exception e) {
                LOG.error("Error while creating directory: " + theDir);
            }
        }
    }

    private void initScenarioRecord(){
        try {
            stepCount++;
            this.fWriter = new FileWriter(this.path+"/result.html");
            this.writer = new BufferedWriter(fWriter);
            this.writer.write("<html>");
            this.writer.newLine();
            this.writer.write("<head></head>");
            this.writer.newLine();
            this.writer.write("<body>");
            this.writer.newLine();
        } catch (Exception e) {
            LOG.error("Error while writing the file");
        }
    }

    public void closeScenarioRecord(Scenario scenario, String estimatedTime){
        try {
            stepCount = 0;
            this.writer.write("</body>");
            this.writer.newLine();
            this.writer.write("</html>");
            this.writer.close();
            this.fWriter.close();
            writeTempHTMLReport(scenario, estimatedTime);
        } catch (Exception e) {
            LOG.error("Error while closing the file");
        }
    }

    public void stepRecord(String step) {
        try {
            step = Integer.toString(stepCount)+"_"+step;
            String file = step + ".png";
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
           // ScreenshotHook.stepScreenshot(this.path + "/" + file);
            ScreenshotHook.stepScreenshot(this.path, step);
            writer.write("<h1>Step: " + step + "</h1>");
            writer.newLine();
            writer.write("<p>"+ "Page Name -> " + WebDriverHelper.getWebDriver().getTitle()+"</p>");
            writer.newLine();
            writer.write("<p>"+ "Current URL -> " + WebDriverHelper.getWebDriver().getCurrentUrl()+"</p>");
            writer.write("<p>"+ new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date())+"</p>");
            writer.newLine();
            writer.write("<img src=\"" + file + "\" alt=\"" + path + "\" width=\"1000\" height=\"1400\" >");
            writer.newLine();
            stepCount++;
        }catch(IOException e){
            LOG.error("Error while wrting the step record");
        }
    }

    public void stepRecordAndScreenshot(String step) {
        try {
            step = Integer.toString(stepCount)+"_"+step;
            String file = step + ".png";
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // ScreenshotHook.stepScreenshot(this.path + "/" + file);
            ScreenshotHook.stepScreenshotFocusedPart(this.path, step);
            writer.write("<h1>Step: " + step + "</h1>");
            writer.newLine();
            writer.write("<p>"+ "Page Name -> " + WebDriverHelper.getWebDriver().getTitle()+"</p>");
            writer.newLine();
            writer.write("<p>"+ "Current URL -> " + WebDriverHelper.getWebDriver().getCurrentUrl()+"</p>");
            writer.write("<p>"+ new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date())+"</p>");
            writer.newLine();
            writer.write("<img src=\"" + file + "\" alt=\"" + path + "\" width=\"900\" height=\"500\" >");
            writer.newLine();
            stepCount++;
        }catch(IOException e){
            LOG.error("Error while wrting the step record");
        }
    }

    private void writeTempHTMLReport(Scenario scenario, String estimatedTime){
        String name = scenario.getName();
        String color = (scenario.isFailed()) ? "#DF3A01":"#04B431";
        String status = scenario.getStatus();
        String capability = scenario.getId();
        capability = capability.substring(0,capability.indexOf(";")).toUpperCase();


       // setTestCaseCount(status);
        status = CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, status);
        try {
            this.fWriter = new FileWriter(this.path+"/temp.html");
            this.writer = new BufferedWriter(fWriter);
            this.writer.write("<tr>");
            this.writer.write("<td>");
            this.writer.write("<a href=\""+name+"/result.html\">"+name+"</a>");
            this.writer.write("</td>");
            this.writer.write("<td bgcolor=\""+color+"\"><font color='white'>"+status+"</font></td>");
            this.writer.write("<td bgcolor='#DFFFFF'>"+estimatedTime+"</td>");
            this.writer.write("<td bgcolor='#DFFFFF'>"+capability+"</td>");
            this.writer.write("</tr>");
            this.writer.close();
            this.fWriter.close();
        }catch(Exception e){
            LOG.error("Error while writing the temp file");
        }

    }



    public  void setTestResults(Scenario scenario) {
       // setTestCaseCount(scenario.getStatus());
        String status = scenario.getStatus();

         int totalTestcase =0;
         int passTestcase = 0;
         int failTestcase = 0;
         int ignoreTestcase = 0;
         browser = Params.BROWSER;


        totalTestcase++;
        switch (status) {
            case ("passed"):
                passTestcase++;
                break;
            case ("failed"):
                failTestcase++;
                break;
            default:
                ignoreTestcase++;
                break;
        }

        try {
            System.out.println("PATH................" +this.path+"/"+"Result.txt");
            this.fWriter = new FileWriter(this.path+"/"+"xyz.txt");
            this.writer = new BufferedWriter(fWriter);
            this.writer.write(totalTestcase+ ",");
            this.writer.write(passTestcase+ ",");
            this.writer.write(failTestcase+ ",");
            this.writer.write(ignoreTestcase+ ",");
            this.writer.write(browser+",");

            this.writer.close();
            this.fWriter.close();
        }catch(Exception e){
            LOG.error("Error while writing the temp file");
        }
    }
}

