package by.htp.selen.Exeption;

import java.io.IOException;

/**
 * Created by user on 26.03.17.
 */
public class ScreenshotException extends IOException {
    private static final long serialVersionUID = -2223342345234423223L;

    public ScreenshotException(String message) {
        super(message);
    }
}
