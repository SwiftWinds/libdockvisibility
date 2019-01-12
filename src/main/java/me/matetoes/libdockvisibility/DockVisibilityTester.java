package me.matetoes.libdockvisibility;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

public class DockVisibilityTester extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/test.fxml"));
        primaryStage.setTitle("Testing");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void handleHide() {

    }
}

class TrayTest extends Application {

    private boolean firstTime;
    private TrayIcon trayIcon;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        createTrayIcon(stage);
        firstTime = true;
        Platform.setImplicitExit(false);
        Scene scene = new Scene(new Group(), 800, 600);
        stage.setScene(scene);
        stage.show();

    }

    private void createTrayIcon(final Stage stage) {
        if (SystemTray.isSupported()) {
            // get the SystemTray instance
            SystemTray tray = SystemTray.getSystemTray();
            // load an image
            java.awt.Image image = null;
            try {
                URL url = new URL("http://www.digitalphotoartistry.com/rose1.jpg");
                image = ImageIO.read(url);
            } catch (IOException ex) {
                ex.printStackTrace();
            }


            stage.setOnCloseRequest(t -> hide(stage));
            // create a action listener to listen for default action executed on the tray icon
            final ActionListener closeListener = e -> System.exit(0);

            ActionListener showListener = e -> Platform.runLater(stage::show);
            // create a popup menu
            PopupMenu popup = new PopupMenu();

            MenuItem showItem = new MenuItem("Show");
            showItem.addActionListener(showListener);
            popup.add(showItem);

            MenuItem closeItem = new MenuItem("Close");
            closeItem.addActionListener(closeListener);
            popup.add(closeItem);
            /// ... add other items
            // construct a TrayIcon
            assert image != null;
            trayIcon = new TrayIcon(image, "Title", popup);
            // set the TrayIcon properties
            trayIcon.addActionListener(showListener);
            // ...
            // add the tray image
            try {
                tray.add(trayIcon);
            } catch (AWTException e) {
                e.printStackTrace();
            }
            // ...
        }
    }

    private void showProgramIsMinimizedMsg() {
        if (firstTime) {
            trayIcon.displayMessage("Some message.",
                    "Some other message.",
                    TrayIcon.MessageType.INFO);
            firstTime = false;
        }
    }

    private void hide(final Stage stage) {
        Platform.runLater(() -> {
            if (SystemTray.isSupported()) {
                stage.hide();
                showProgramIsMinimizedMsg();
            } else {
                System.exit(0);
            }
        });
    }
}
