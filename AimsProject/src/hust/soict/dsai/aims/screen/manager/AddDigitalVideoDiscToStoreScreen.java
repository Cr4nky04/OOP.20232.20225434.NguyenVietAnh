package AimsProject.src.hust.soict.dsai.aims.screen.manager;

import AimsProject.src.hust.soict.dsai.aims.media.CompactDisc;
import AimsProject.src.hust.soict.dsai.aims.media.DigitalVideoDisc;
import AimsProject.src.hust.soict.dsai.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField directorField;
    private JTextField lengthField;

    public AddDigitalVideoDiscToStoreScreen() {
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
        DigitalVideoDisc dvd =new DigitalVideoDisc();
        dvd.setId(Integer.parseInt(idField.getText()));
        dvd.setTitle(titleField.getText());
        dvd.setCategory(categoryField.getText());
        dvd.setCost(Float.parseFloat(costField.getText()));
        dvd.setDirector(directorField.getText());
        dvd.setLength(Integer.parseInt(lengthField.getText()));

        StoreSingleton.getInstance().addMedia(dvd);
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

        JLabel lengthLabel = new JLabel("Length:");
        lengthField = new JTextField(20);

        gbc.gridx = 0;
        gbc.gridy = 5;
        center.add(lengthLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        center.add(lengthField, gbc);

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

        setTitle("Add DVD To Store");
        setSize(480, 480);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
