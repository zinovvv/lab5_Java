import java.util.ArrayList;
import java.util.Scanner;

public class Playlist {
    private String title;
    private int numTracks;
    private int numAlbums;
    private ArrayList<Track> tracks;
    private ArrayList<Album> albums;

    public Playlist(String title, int numTracks, int numAlbums) {
        this.title = title;
        this.numTracks = numTracks;
        this.numAlbums = numAlbums;
    }

    public Playlist(Playlist other){
        this.title = other.title;
        this.numTracks = other.numTracks;
        this.tracks = other.tracks;
        this.numAlbums = other.numAlbums;
        this.albums = other.albums;
    }

    public Playlist(){}

    public void addTrack(Track track) {
        tracks.add(track);
    }

    public void setTracks(ArrayList<Track> newTracks) {
        tracks = newTracks;
    }

    public void printTracks() {
        for (Track track : tracks) {
            track.OutputTrack();
            System.out.println();
        }
    }

    public void deleteTrack() {
        Scanner scanner = new Scanner(System.in);
        while (true){
            try{
            System.out.println("Введите номер трека, который хотите удалить:");
            int number = scanner.nextInt();
            if (number < 1 || number > tracks.size()){
                throw new IndexOutOfBoundsException("Некорректный номер трека");
            }
            this.tracks.remove(number - 1);
            break;
            }
            catch (IndexOutOfBoundsException e) {
                System.err.println("Ошибка удаления трека: " + e.getMessage());
            }
        }
    }

    public void addAlbum(Album album) {
        albums.add(album);
    }

    public void setAlbums(ArrayList<Album> newAlbums) {
        albums = newAlbums;
    }

    public void printAlbums() {
        for (Album album : albums) {
            album.outputAlbum();
            System.out.println();
        }
    }

    public void deleteAlbum() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Введите номер альбома, котоырй хотите удалить: ");
                int number = scanner.nextInt();
                if (number < 1 || number > albums.size()){
                    throw new IndexOutOfBoundsException("Некорректный номер альбома");
                }
                albums.remove(number - 1);
                break;
            }
            catch (IndexOutOfBoundsException e) {
                System.err.println("Ошибка удаления альбома: " + e.getMessage());
            }
        }
    }
}