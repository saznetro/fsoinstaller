package com.fsoinstaller.common;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.assertj.swing.annotation.GUITest;
import org.assertj.swing.core.EmergencyAbortListener;
import org.assertj.swing.core.MouseButton;
import org.assertj.swing.core.matcher.JButtonMatcher;
import org.assertj.swing.core.matcher.JLabelMatcher;
import org.assertj.swing.finder.WindowFinder;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.image.ScreenshotTaker;
import org.assertj.swing.launcher.ApplicationLauncher;
import org.assertj.swing.testng.testcase.AssertJSwingTestngTestCase;
import org.testng.annotations.Test;

import com.fsoinstaller.main.Configuration;
import com.fsoinstaller.main.FreeSpaceOpenInstaller;

public class FreeSpaceOpenInstallerTest  extends AssertJSwingTestngTestCase{
	private static final String GUI_SCREENSHOT_OUTPUT_DIR = "target/test-output/";
    private EmergencyAbortListener listener;
 
    @Override
    public void onSetUp() {
        File testoutput = new File(GUI_SCREENSHOT_OUTPUT_DIR);
        if (!testoutput.exists()) {
            testoutput.mkdir();
        }
        listener = EmergencyAbortListener.registerInToolkit();

    }

    @Test(groups = { "gui", "function" })
    @GUITest
    public void testGameStartEndWithWallHit() throws InterruptedException {
        ScreenshotTaker screenshot = new ScreenshotTaker();
        DateFormat df = new SimpleDateFormat("yy_MM_dd_HH_mm_ss");
        ApplicationLauncher.application(FreeSpaceOpenInstaller.class).start();
        Configuration.getInstance().getApplicationTitle();
        FrameFixture mainFrame = WindowFinder.findFrame("InstallerGUI").withTimeout(5 * 1000)
                .using(robot());
    }

    @Override
    public void onTearDown() {
        ScreenshotTaker screenshot = new ScreenshotTaker();
        DateFormat df = new SimpleDateFormat("yy_MM_dd_HH_mm_ss");
        screenshot.saveImage(screenshot.takeDesktopScreenshot(),
                GUI_SCREENSHOT_OUTPUT_DIR + "onTearDown_screen" + df.format(new Date()) + ".png");
        listener.unregister();
    }
}
