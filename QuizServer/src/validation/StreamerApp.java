/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validation;

/**
 *
 * @author Nguyen
 */
import com.teamdev.jxbrowser.browser.Browser;
import com.teamdev.jxbrowser.browser.callback.StartCaptureSessionCallback;
import com.teamdev.jxbrowser.browser.event.CaptureSessionStarted;
import com.teamdev.jxbrowser.capture.AudioCaptureMode;
import com.teamdev.jxbrowser.capture.CaptureSession;
import com.teamdev.jxbrowser.capture.CaptureSource;
import com.teamdev.jxbrowser.capture.CaptureSources;
import com.teamdev.jxbrowser.engine.Engine;
import com.teamdev.jxbrowser.engine.EngineOptions;
import static com.teamdev.jxbrowser.engine.RenderingMode.HARDWARE_ACCELERATED;
import com.teamdev.jxbrowser.view.swing.BrowserView;

import javax.swing.*;
import java.awt.*;

public class StreamerApp {

    private static CaptureSession captureSession;

    public static void main(String[] args) {
         String licenseKey = "1BNDHFSC1G8AX56FJPV07GRDA3Q97C0KLZF4R5GIX0K30WUBBNW4LLIIG1EX7QO32OKO1N";

        // Uncomment the following lines to set the license key
        EngineOptions options = EngineOptions.newBuilder(HARDWARE_ACCELERATED).licenseKey(licenseKey).build();
        Engine engine = Engine.newInstance(options);
        Browser browser = engine.newBrowser();

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Streamer App");
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setSize(800, 600);

            BrowserView browserView = BrowserView.newInstance(browser);
            frame.add(browserView, BorderLayout.CENTER);

            JButton startSharingButton = new JButton("Share your screen");
            startSharingButton.addActionListener(e -> {
                browser.mainFrame().ifPresent(mainFrame ->
                        mainFrame.executeJavaScript("startScreenSharing()")
                );
            });

            JButton stopSharingButton = new JButton("Stop sharing");
            stopSharingButton.addActionListener(e -> {
                if (captureSession != null) {
                    captureSession.stop();
                }
            });

            JPanel buttonPanel = new JPanel();
            buttonPanel.add(startSharingButton);
            buttonPanel.add(stopSharingButton);

            frame.add(buttonPanel, BorderLayout.SOUTH);

            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

            browser.navigation().loadUrlAndWait("http://localhost:3000/streamer");

            browser.set(StartCaptureSessionCallback.class, (params, tell) -> {
                CaptureSources sources = params.sources();
                CaptureSource screen = sources.screens().get(0);
                tell.selectSource(screen, AudioCaptureMode.CAPTURE);
            });

            browser.on(CaptureSessionStarted.class, event -> captureSession = event.capture());
        });
    }
}
