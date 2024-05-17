package AimsProject.src.hust.soict.dsai.aims.screen.manager;

import AimsProject.src.hust.soict.dsai.aims.media.Book;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    private JTextField authorField;
    private JTextField isbnField;



    public AddBookToStoreScreen() {
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
        Book book = new Book();
        book.setId(Integer.parseInt(idField.getText()));
        book.setTitle(titleField.getText());
        book.setCategory(categoryField.getText());
        book.setCost(Float.parseFloat(costField.getText()));
        StoreSingleton.getInstance().addMedia(book);
    }

    @Override
    protected void addSpecificFields(GridBagConstraints gbc) {
        JLabel authorLabel = new JLabel("Author:");
        authorField = new JTextField(20);

        gbc.gridx = 0;
        gbc.gridy = 4;
        center.add(authorLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        center.add(authorField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        center.add(saveButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        center.add(cancelButton, gbc);

        setTitle("Add Book To Store");
        setSize(480, 480);
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
