/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sharingapp;

/**
 *
 * @author Nguyen
 */
/*
 * Copyright 2000-2022 TeamDev.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


import com.teamdev.jxbrowser.browser.Browser;
import com.teamdev.jxbrowser.engine.Engine;
import com.teamdev.jxbrowser.engine.EngineOptions;
import static com.teamdev.jxbrowser.engine.RenderingMode.HARDWARE_ACCELERATED;
import com.teamdev.jxbrowser.view.swing.BrowserView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


/**
 * An application that receives a screen sharing stream and shows it.
 */
public final class Receiver {

    public static void main(String[] args) {
         String licenseKey = "1BNDHFSC1G8AX56FJPV07GRDA3Q97C0KLZF4R5GIX0K30WUBBNW4LLIIG1EX7QO32OKO1N";

        // Uncomment the following lines to set the license key
        EngineOptions options = EngineOptions.newBuilder(HARDWARE_ACCELERATED).licenseKey(licenseKey).build();
        Engine engine = Engine.newInstance(options);
       // Engine engine = Engine.newInstance(HARDWARE_ACCELERATED);
        Browser browser = engine.newBrowser();

        initUI(browser);
        navigateToLocalhost(browser);
    }

    private static void navigateToLocalhost(Browser browser) {
        String port = System.getProperty("3000");
        String url = String.format("http://localhost:%s/receiver", port);
        browser.navigation().loadUrlAndWait(url);
    }

    private static void initUI(Browser browser) {
        JFrame frame = new JFrame("Receiver");
        BrowserView view = BrowserView.newInstance(browser);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                browser.engine().close();
            }
        });
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(700, 500);
        frame.add(view, BorderLayout.CENTER);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
