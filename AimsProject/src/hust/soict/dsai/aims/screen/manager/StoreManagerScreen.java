package AimsProject.src.hust.soict.dsai.aims.screen.manager;

import AimsProject.src.hust.soict.dsai.aims.media.CompactDisc;
import AimsProject.src.hust.soict.dsai.aims.media.DigitalVideoDisc;
import AimsProject.src.hust.soict.dsai.aims.media.Media;
import AimsProject.src.hust.soict.dsai.aims.media.Playable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StoreManagerScreen extends JFrame{

//    ArrayList<Media> mediaInStore = store.getItemsInStore();
    JPanel center = new JPanel();
    JPanel north = new JPanel();

    public StoreManagerScreen()
    {
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setTitle("Store");
        setSize(1024, 768);
        setLocationRelativeTo(null);
    }


    JPanel createNorth()
    {
//        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }
    JPanel createCenter()
    {
//        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3,3,2,2));
        return center;
    }
    JMenuBar createMenuBar()
    {
        JMenu menu = new JMenu("Options");

        menu.add(new JMenuItem("View store"));

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
    JPanel createHeader()
    {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(),Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        header.add(Box.createRigidArea(new Dimension(10,10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(Box.createRigidArea(new Dimension(10,10)));

        return header;
    }
    public void showStore()
    {
        ArrayList<Media> mediaInStore = StoreSingleton.getInstance().getStore().getItemsInStore();
        int count = 0;
        center.removeAll();
        for(Media media : mediaInStore)
        {
            if(count>=9)
            {
                break;
            }
            MediaStore cell = new MediaStore(media);
            center.add(cell);
            count++;
        }
    }
    @Override
    public void setVisible(boolean condition)
    {
        showStore();
        super.setVisible(condition);
    }

    public class MediaStore extends JPanel
    {
        private Media media;
        public MediaStore(Media media)
        {
            this.media = media;
            this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

            JLabel title = new JLabel(media.getTitle());
            title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 15));
            title.setAlignmentX(CENTER_ALIGNMENT);

            JLabel cost = new JLabel(""+media.getCost()+" $");
            cost.setAlignmentX(CENTER_ALIGNMENT);

            JPanel container = new JPanel();
            container.setLayout(new FlowLayout(FlowLayout.CENTER));

            if(media instanceof Playable)
            {
                JButton playButton = new JButton("Play");
                container.add(playButton);
                playButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        onPressPlay();
                    }
                });
            }

            this.add(Box.createVerticalGlue());
            this.add(title);
            this.add(cost);
            this.add(Box.createVerticalGlue());
            this.add(container);

            this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        }
        private void onPressPlay() {
            JDialog playDialog = new JDialog();
            playDialog.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.fill = GridBagConstraints.HORIZONTAL;

            String type = new String();
            if(media instanceof DigitalVideoDisc)
            {
                type = "Type: DVD";
            }
            else if (media instanceof CompactDisc) {
                type = "Type: CD";
            }

            JLabel titleLabel = new JLabel("Title: " + media.getTitle());
            JLabel typeLabel = new JLabel(type);
            JLabel playLabel = new JLabel("You are playing a disc");

            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.CENTER;
            playDialog.add(playLabel,gbc);

            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.anchor = GridBagConstraints.CENTER;
            playDialog.add(typeLabel,gbc);

            gbc.gridx = 0;
            gbc.gridy = 2;
            gbc.anchor = GridBagConstraints.CENTER;
            playDialog.add(titleLabel,gbc);

            playDialog.setTitle("Playing");
            playDialog.setSize(300,300);
            playDialog.setLocationRelativeTo(center);
            playDialog.setVisible(true);
        }
    }


}
