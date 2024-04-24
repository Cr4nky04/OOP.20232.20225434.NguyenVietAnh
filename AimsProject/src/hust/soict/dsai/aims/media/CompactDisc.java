package AimsProject.src.hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc {
    private String artist;
    private ArrayList<Track> tracks;

    public String getArtist() {
        return artist;
    }

    public CompactDisc(int id, String title, String category, int length, String director, String artist, ArrayList<Track> tracks) {
        super(id, title, category, length, director);
        this.artist = artist;
        this.tracks = tracks;
    }

    public CompactDisc(int id, String title, String category, float cost, int length, String director, ArrayList<Track> tracks) {
        super(id, title, category, cost, length, director);
        this.tracks = tracks;
    }

    public CompactDisc(int id, String title, String category, int length, String director, String artist) {
        super(id, title, category, length, director);
        this.artist = artist;
    }

    public CompactDisc(int id, String title, String category, float cost, int length, String director, String artist, ArrayList<Track> tracks) {
        super(id, title, category, cost, length, director);
        this.artist = artist;
        this.tracks = tracks;
    }

    public CompactDisc(int id, String title, String category, int length, String director, ArrayList<Track> tracks) {
        super(id, title, category, length, director);
        this.tracks = tracks;
    }
    public void addTrack(Track track)
    {
        if(!this.tracks.contains(track))
        {
            this.tracks.add(track);
        }
        else
        {
            System.out.println("This track is aldready in the list of track");
        }
    }
    public void removeTrack(Track track)
    {
        if(this.tracks.contains(track))
        {
            this.tracks.remove(track);
        }
        else
        {
            System.out.println("This track has not been added to the list of track");
        }
    }
    public int getLength()
    {
        int sum_of_length = 0;
        for(Track track : this.tracks)
        {
            sum_of_length += track.getLength();
        }
        return sum_of_length;
    }
    public void play() {
        for(Track track : this.tracks)
        {
            track.play();
        }
    }
}
