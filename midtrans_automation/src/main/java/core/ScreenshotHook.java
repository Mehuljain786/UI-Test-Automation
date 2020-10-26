package core;


import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;
import core.Params;
import core.WebDriverHelper;
import cucumber.api.Scenario;
import org.openqa.selenium.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import java.awt.image.BufferedImage;
import java.util.Map;

public class ScreenshotHook{

    private static final Logger LOG = LoggerFactory.getLogger(ScreenshotHook.class);

    public static void embedScreenshot(Scenario scenario) {
        try {
            Map<String, Object> screenShots = ScreenshotHelper.getScreenShotsForCurrentTest();
            for (Map.Entry<String, Object> screenShot : screenShots.entrySet()) {
                scenario.write(screenShot.getKey());
                scenario.embed((byte[]) screenShot.getValue(), "image/png");
            }

            ScreenshotHelper.tidyUpAfterTestRun();
            scenario.write(WebDriverHelper.getWebDriver().getCurrentUrl());
            byte[] screenShot;
            if(Params.BROWSER.equals("firefox")){
                screenShot = ((TakesScreenshot) WebDriverHelper.getWebDriver()).getScreenshotAs(OutputType.BYTES);
            }else{
                Screenshot shoot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(WebDriverHelper.getWebDriver());
                BufferedImage image = shoot.getImage();
                screenShot = ScreenshotHelper.imageToByteArray(image);
            }
            scenario.embed(screenShot, "image/png");

        } catch (WebDriverException | ClassCastException wde) {
            LOG.error(wde.getMessage());
        } finally {
            WebDriverHelper.getWebDriver().switchTo().defaultContent();
        }
    }


    public static void stepScreenshot(String path, String step) {

        try {
            Shutterbug.shootPage(WebDriverHelper.getWebDriver(), ScrollStrategy.BOTH_DIRECTIONS,500,true)
              .withName(step)
              .save(path);


        } catch (WebDriverException | ClassCastException wde) {
            LOG.error(wde.getMessage());
        }catch (Exception e){
            LOG.error("Failed to capture screenshot: "+e.getMessage());
        } finally {
            WebDriverHelper.getWebDriver().switchTo().defaultContent();
        }
    }

    public static void stepScreenshotFocusedPart(String path, String step) {

        try {
            Shutterbug.shootPage(WebDriverHelper.getWebDriver())
                    .withName(step)
                    .save(path);


        } catch (WebDriverException | ClassCastException wde) {
            LOG.error(wde.getMessage());
        }catch (Exception e){
            LOG.error("Failed to capture screenshot: "+e.getMessage());
        } finally {
            WebDriverHelper.getWebDriver().switchTo().defaultContent();
        }
    }

}
