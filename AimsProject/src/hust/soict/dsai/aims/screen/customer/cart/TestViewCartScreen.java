package AimsProject.src.hust.soict.dsai.aims.screen.customer.cart;

import AimsProject.src.hust.soict.dsai.aims.cart.Cart;
import AimsProject.src.hust.soict.dsai.aims.media.DigitalVideoDisc;
import AimsProject.src.hust.soict.dsai.aims.screen.customer.controller.CartController;
import AimsProject.src.hust.soict.dsai.aims.screen.customer.controller.ViewStoreController;
import AimsProject.src.hust.soict.dsai.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.naming.LimitExceededException;

public class TestViewCartScreen extends Application {
    private static Cart cart;
    private static Store store;
    @Override
    public void start(Stage stage) throws Exception {
        final String STORE_FXML_FILE_PATH = "../view/Cart.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
        CartController cartController = new CartController(store,cart);
        fxmlLoader.setController(cartController);
        Parent root = fxmlLoader.load();

        stage.setTitle("Cart");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void main(String[] args) throws LimitExceededException {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1711,"The Lion King", "Animation",19.95f,87,"Roger Allers");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(1833,"Star Wars", "Science Fiction", 24.95f, 87, "George Lucas");
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        cart = new Cart();
        store = new Store();
        cart.addMedia(dvd1);
        cart.addMedia(dvd1);
        cart.addMedia(dvd1);
        cart.addMedia(dvd2);
        cart.addMedia(dvd3);
        store.addMedia(dvd1);
        store.addMedia(dvd1);
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        launch(args);
    }

}
