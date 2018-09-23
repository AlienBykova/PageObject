package listeners;

import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;
import static utils.ScreenshotUtil.getScreenshot;

public class TestListener extends RunListener {

    @Override
    public void testFailure(Failure failure) {
        getScreenshot();
    }

}
