package AimsProject.src.hust.soict.dsai.aims.screen.manager;

import AimsProject.src.hust.soict.dsai.aims.store.Store;

import javax.swing.*;

public class ScreenControllerSingleton {

    protected StoreManagerScreen sms ;
    protected AddBookToStoreScreen book ;
    protected AddCompactDiscToStoreScreen cd ;
    protected AddDigitalVideoDiscToStoreScreen dvd ;
    private JFrame[] frames ;
    JFrame currentFrame;

    private static ScreenControllerSingleton instance ;
    public static ScreenControllerSingleton getInstance() {
        if (instance == null) {
            instance = new ScreenControllerSingleton();
        }
        return instance;
    }

    public ScreenControllerSingleton()
    {

    }

    public void onStart()
    {
        sms = new StoreManagerScreen();
        book = new AddBookToStoreScreen();
        cd = new AddCompactDiscToStoreScreen();
        dvd = new AddDigitalVideoDiscToStoreScreen();

        frames = new JFrame[]{sms, book, cd, dvd};

        currentFrame = sms;
        showScreen();
    }
    public void switchScreen(JFrame currentFrame)
    {
        this.currentFrame = currentFrame;
        showScreen();
    }

    private void showScreen()
    {
        this.currentFrame.setVisible(true);
        for(JFrame frame : frames)
        {
            if(frame != this.currentFrame)
            {
                frame.setVisible(false);
            }
        }
    }
}
