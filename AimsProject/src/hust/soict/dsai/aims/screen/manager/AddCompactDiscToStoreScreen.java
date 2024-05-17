package AimsProject.src.hust.soict.dsai.aims.screen.manager;

import AimsProject.src.hust.soict.dsai.aims.media.CompactDisc;
import AimsProject.src.hust.soict.dsai.aims.media.Track;
import AimsProject.src.hust.soict.dsai.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {

    private JTextField directorField;
    private JTextField artistField;
//    private ArrayList<Track> tracks;
    public AddCompactDiscToStoreScreen() {
        super();
    }
    @Override
    protected JPanel createCenter() {
        center = super.createCenter();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,0,0,0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addSpecificFields(gbc);
        return center;
    }

    @Override
    protected void onSave() {
        CompactDisc cd =new CompactDisc();
        cd.setId(Integer.parseInt(idField.getText()));
        cd.setTitle(titleField.getText());
        cd.setCategory(categoryField.getText());
        cd.setCost(Float.parseFloat(costField.getText()));
        cd.setArtist(artistField.getText());
        cd.setDirector(directorField.getText());

        StoreSingleton.getInstance().addMedia(cd);
    }

    @Override
    protected void addSpecificFields(GridBagConstraints gbc) {
        JLabel directorLabel = new JLabel("Director:");
        directorField = new JTextField(20);

        gbc.gridx = 0;
        gbc.gridy = 4;
        center.add(directorLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        center.add(directorField, gbc);

        JLabel artistLabel = new JLabel("Artist:");
        artistField = new JTextField(20);

        gbc.gridx = 0;
        gbc.gridy = 5;
        center.add(artistLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        center.add(artistField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        center.add(saveButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        center.add(cancelButton, gbc);

        setTitle("Add CD To Store");
        setSize(480, 480);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
