package AimsProject.src.hust.soict.dsai.aims.screen.manager;

import AimsProject.src.hust.soict.dsai.aims.media.Media;
import AimsProject.src.hust.soict.dsai.aims.store.Store;

public class StoreSingleton {
    protected Store store = new Store();
    private static StoreSingleton instance ;
    public static StoreSingleton getInstance() {
        if (instance == null) {
            instance = new StoreSingleton();
        }
        return instance;
    }
    public StoreSingleton()
    {

    }
    protected void addMedia(Media media)
    {
        this.store.addMedia(media);
    }
    protected Store getStore()
    {
        return this.store;
    }

}
