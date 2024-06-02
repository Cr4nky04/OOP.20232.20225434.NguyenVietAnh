package AimsProject.src.hust.soict.dsai.aims.screen.customer.controller;

import AimsProject.src.hust.soict.dsai.aims.cart.Cart;
import AimsProject.src.hust.soict.dsai.aims.exception.PlayerException;
import AimsProject.src.hust.soict.dsai.aims.media.Disc;
import AimsProject.src.hust.soict.dsai.aims.media.Media;
import AimsProject.src.hust.soict.dsai.aims.media.Playable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import javax.naming.LimitExceededException;

public class ItemController {
    private Media media;
    private Cart cart;

    public ItemController(Cart cart)
    {
        this.cart = cart;
    }
    @FXML
    private Button btnAddToCart;

    @FXML
    private Button btnPlay;

    @FXML
    private Label lblCost;

    @FXML
    private Label lblTitle;

    @FXML
    void btnAddToCartClicked(ActionEvent event) throws LimitExceededException {
        cart.addMedia(media);
    }

    @FXML
    void btnPlayClicked(ActionEvent event) throws PlayerException {
        if(this.media instanceof Disc)
        {
            Disc disc = (Disc) this.media;
            disc.play();
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Playing Media");
        alert.setHeaderText(null);
        alert.setContentText("You are playing " + media.getTitle());
        alert.showAndWait();
    }

    public void setData(Media media)
    {
        this.media = media;
        lblTitle.setText(media.getTitle());
        lblCost.setText(media.getCost() + "$");
        if(media instanceof Playable){
            btnPlay.setVisible(true);
        }
        else
        {
            btnPlay.setVisible(false);
            HBox.setMargin(btnAddToCart, new Insets(0,0,0,60));
        }
    }

}
