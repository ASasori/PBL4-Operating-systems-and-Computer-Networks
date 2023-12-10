/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package screensharingapp;

/**
 *
 * @author Nguyen
 */
import com.teamdev.jxbrowser.browser.Browser;
import com.teamdev.jxbrowser.engine.Engine;
import com.teamdev.jxbrowser.engine.EngineOptions;
import static com.teamdev.jxbrowser.engine.RenderingMode.HARDWARE_ACCELERATED;
import com.teamdev.jxbrowser.view.swing.BrowserView;

import javax.swing.*;
import java.awt.*;

public class ReceiverApp {

    public static void main(String[] args) {
        String licenseKey = "1BNDHFSC1G8AX56FJPV07GRDA3Q97C0KLZF4R5GIX0K30WUBBNW4LLIIG1EX7QO32OKO1N";

        // Uncomment the following lines to set the license key
        EngineOptions options = EngineOptions.newBuilder(HARDWARE_ACCELERATED).licenseKey(licenseKey).build();
        Engine engine = Engine.newInstance(options);
        Browser browser = engine.newBrowser();

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Receiver App");
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setSize(800, 600);

            BrowserView browserView = BrowserView.newInstance(browser);
            frame.add(browserView, BorderLayout.CENTER);

            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

            browser.navigation().loadUrlAndWait("http://localhost:3000/receiver");
        });
    }
}
