package AimsProject.src.hust.soict.dsai.aims.media;

public class Track implements Playable {
    private String title;
    private int length;

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }
    public void play() {
        System.out.println("Playing track: "+this.getTitle());
        System.out.println("Track length: "+this.getLength());
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Track))
        {
            return false;
        }
        Track track2 = (Track) obj;
        return this.getTitle().equals(track2.getTitle()) && (this.getLength()==track2.getLength());
    }
}
