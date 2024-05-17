package AimsProject.src.hust.soict.dsai.aims.screen.manager;
import AimsProject.src.hust.soict.dsai.aims.store.Store;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

public abstract class AddItemToStoreScreen extends JFrame {
    protected JTextField titleField;
    protected JTextField idField;
    protected JTextField categoryField;
    protected JTextField costField;
    protected JButton saveButton;
    protected JButton cancelButton;

    JPanel center = new JPanel();
    JPanel north = new JPanel();

    public AddItemToStoreScreen() {

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

    }

    protected JPanel createNorth()
    {
//        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        return north;
    }
    protected JPanel createCenter()
    {
//        JPanel center = new JPanel();
        center.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,0,0,0);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel titleLabel = new JLabel("Title:");
        titleField = new JTextField(20);

        JLabel idLabel = new JLabel("ID:");
        idField = new JTextField(20);

        JLabel categoryLabel = new JLabel("Category:");
        categoryField = new JTextField(20);

        JLabel costLabel = new JLabel("Cost($):");
        costField = new JTextField(20);

        saveButton = new JButton("Save");
        cancelButton = new JButton("Cancel");

        gbc.gridx = 0;
        gbc.gridy = 0;
        center.add(titleLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        center.add(titleField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        center.add(idLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        center.add(idField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        center.add(categoryLabel,gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        center.add(categoryField,gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        center.add(costLabel,gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        center.add(costField,gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        center.add(saveButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        center.add(cancelButton, gbc);

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onSave();
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame currentFrame = ScreenControllerSingleton.getInstance().sms;
                ScreenControllerSingleton.getInstance().switchScreen(currentFrame);
            }
        });
        return center;
    }

    protected JMenuBar createMenuBar()
    {
        JMenu menu = new JMenu("Options");

        JMenuItem storeMenuItem = new JMenuItem("View store");
        menu.add(storeMenuItem);

        JMenu smUpdateStore = new JMenu("Update Store");
        JMenuItem bookMenuItem = new JMenuItem("Add Book");
        JMenuItem cdMenuItem = new JMenuItem("Add CD");
        JMenuItem dvdMenuItem = new JMenuItem("Add DVD");

        smUpdateStore.add(bookMenuItem);
        smUpdateStore.add(cdMenuItem);
        smUpdateStore.add(dvdMenuItem);
        bookMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame currentFrame = ScreenControllerSingleton.getInstance().book;
                ScreenControllerSingleton.getInstance().switchScreen(currentFrame);
            }
        });
        storeMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame currentFrame = ScreenControllerSingleton.getInstance().sms;
                ScreenControllerSingleton.getInstance().switchScreen(currentFrame);
            }
        });
        cdMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame currentFrame = ScreenControllerSingleton.getInstance().cd;
                ScreenControllerSingleton.getInstance().switchScreen(currentFrame);
            }
        });
        dvdMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame currentFrame = ScreenControllerSingleton.getInstance().dvd;
                ScreenControllerSingleton.getInstance().switchScreen(currentFrame);
            }
        });

        menu.add(smUpdateStore);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    protected abstract void onSave();
    protected abstract void addSpecificFields(GridBagConstraints gbc);
}
