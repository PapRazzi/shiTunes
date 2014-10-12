import com.mpatric.mp3agic.ID3v1;
import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.Mp3File;
import java.io.IOException;

/**
 * Song class represents a song object
 *
 * @author shiTunes inc.
 */
public class Song {

    private String filePath;
    private String artist;
    private String title;
    private String album;
    private String year;
    private String genre;

    /**
     * Song constructor takes the song file path and utilizes the
     * mp3agic library to grab the song information from it's ID3v1
     * or ID3v2 tag
     *
     * @param filePath the absolute path to the song file
     */
    public Song(String filePath) {
        this.filePath = filePath;
        try {
            Mp3File mp3file = new Mp3File(filePath);
            if (mp3file.hasId3v1Tag()) {
                ID3v1 id3v1Tag = mp3file.getId3v1Tag();
                this.artist = id3v1Tag.getArtist().replace("'", "''");
                this.title = id3v1Tag.getTitle().replace("'", "''");
                this.album = id3v1Tag.getAlbum().replace("'", "''");
                this.year = id3v1Tag.getYear().replace("'", "''");
                this.genre = id3v1Tag.getGenreDescription().replace("'", "''");
            } else if (mp3file.hasId3v2Tag()) {
                ID3v2 id3v2Tag = mp3file.getId3v2Tag();
                this.artist = id3v2Tag.getArtist().replace("'", "''");
                this.title = id3v2Tag.getTitle().replace("'", "''");
                this.album = id3v2Tag.getAlbum().replace("'", "''");
                this.year = id3v2Tag.getYear().replace("'", "''");
                this.genre = id3v2Tag.getGenreDescription().replace("'", "''");
            }
        } catch (IOException ioe) {
            System.out.println("IOException occurred");
        } catch (Exception e) {
            System.out.println("An exception occurred while getting Song tag information");
        }
    }

    /**
     * Returns the Song file path
     *
     * @return the Song file path
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * Returns the Song artist
     *
     * @return the Song artist
     */
    public String getArtist() {
        return artist;
    }

    /**
     * Returns the Song title
     *
     * @return the Song title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns the Song album
     *
     * @return the Song album
     */
    public String getAlbum() {
        return album;
    }

    /**
     * Returns the Song year
     *
     * @return the Song year
     */
    public String getYear() {
        return year;
    }

    /**
     * Returns the Song genre
     *
     * @return the Song genre
     */
    public String getGenre() {
        return genre;
    }
}
