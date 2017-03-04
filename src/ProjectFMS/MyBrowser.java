package ProjectFMS;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class MyBrowser extends Application {

    private String url = "https://accounts.google.com";

    @Override
    public void start(Stage stage) throws Exception {
        WebView webview = new WebView();
        webview.getEngine().load(url);
        webview.setPrefSize(1800, 1000);
        stage.setScene(new Scene(webview));
        stage.show();
        stage.close();

    }
}