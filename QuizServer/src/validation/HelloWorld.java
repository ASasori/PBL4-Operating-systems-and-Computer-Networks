package validation;

import static com.teamdev.jxbrowser.engine.RenderingMode.HARDWARE_ACCELERATED;

import com.teamdev.jxbrowser.browser.Browser;
import com.teamdev.jxbrowser.engine.Engine;
import com.teamdev.jxbrowser.engine.EngineOptions;  // Add this import
import com.teamdev.jxbrowser.view.swing.BrowserView;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class HelloWorld {

    public static void main(String[] args) {
        String licenseKey = "1BNDHFSC1G8AX56FJPV07GRDA3Q97C0KLZF4R5GIX0K30WUBBNW4LLIIG1EX7QO32OKO1N";

        // Uncomment the following lines to set the license key
        EngineOptions options = EngineOptions.newBuilder(HARDWARE_ACCELERATED).licenseKey(licenseKey).build();
        Engine engine = Engine.newInstance(options);

        // Creating and running Chromium engine.
        Browser browser = engine.newBrowser();

        SwingUtilities.invokeLater(() -> {
            // Creating Swing component for rendering web content
            // loaded in the given Browser instance.
            BrowserView view = BrowserView.newInstance(browser);

            // Creating and displaying Swing app frame.
            JFrame frame = new JFrame("Hello World");
            // Close Engine and close the app window.
            frame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    engine.close();
                }
            });
            frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            JTextField addressBar = new JTextField("https://id.zing.vn/");
            addressBar.addActionListener(e ->
                    browser.navigation().loadUrl(addressBar.getText()));
            frame.add(addressBar, BorderLayout.NORTH);
            frame.add(view, BorderLayout.CENTER);
            frame.setSize(800, 500);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

            browser.navigation().loadUrl(addressBar.getText());
        });
    }
}
