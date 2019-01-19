package me.matetoes.libdockvisibility;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

public class DockVisibilityTester extends Application {

    @FXML
    public javafx.scene.control.Button hideButton;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/test.fxml"));
        primaryStage.setTitle("Testing");
        primaryStage.setScene(new Scene(root, 300, 275));
        Platform.setImplicitExit(false);
        createTrayIcon(primaryStage);
        primaryStage.show();
    }

    private void createTrayIcon(final Stage stage) {
        if (SystemTray.isSupported()) {
            SystemTray tray = SystemTray.getSystemTray(); // get the SystemTray instance

            Image icon = null;
            try { // load an image
                URL url = new URL("http://www.digitalphotoartistry.com/rose1.jpg");
                icon = ImageIO.read(url);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            stage.setOnCloseRequest(e -> hide(stage)); //hide instead of close

            // to be added on "show" MenuItem and trayIcon itself
            ActionListener showListener = e -> show(stage);

            PopupMenu popup = new PopupMenu(); // create a popup menu

            MenuItem showItem = new MenuItem("Show");
            showItem.addActionListener(showListener);

            MenuItem closeItem = new MenuItem("Close");
            closeItem.addActionListener(e -> System.exit(0));

            popup.add(showItem);
            popup.addSeparator();
            popup.add(closeItem);

            assert icon != null;
            TrayIcon trayIcon = new TrayIcon(icon, "Test", popup); // construct a TrayIcon
            trayIcon.setImageAutoSize(true);
            trayIcon.addActionListener(showListener);

            try { // add the tray image
                tray.add(trayIcon);
            } catch (AWTException e) {
                e.printStackTrace();
            }
        }
    }

    private void hide(final Stage stage) {
        Platform.runLater(() -> {
            if (SystemTray.isSupported()) {
                stage.hide();
                DockVisibility.INSTANCE.hide();
            } else {
                System.exit(0);
            }
        });
    }

    private void show(final Stage stage) {
        Platform.runLater(() -> {
            stage.show();
            stage.toFront();
            DockVisibility.INSTANCE.show();
        });
    }

    public void handleHide() {
        Stage stage = (Stage) hideButton.getScene().getWindow();
        hide(stage);
    }
}

