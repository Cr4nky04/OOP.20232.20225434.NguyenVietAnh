package AimsProject.src.hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {
    @Override
    public int compare(Media media1, Media media2) {
        int costComparison = Double.compare(media2.getCost(), media1.getCost());
        if (costComparison != 0) {
            // If costs are different, sort by cost in descending order
            return costComparison;
        } else {
            // If costs are the same, sort by title
            return media1.getTitle().compareTo(media2.getTitle());
        }
    }
}
