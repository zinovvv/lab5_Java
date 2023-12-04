import java.util.ArrayList;
import java.util.Scanner;

public class Artist {
    private String name;
    private int numAlbums;
    private ArrayList<Album> albums;

    public Artist(String name, int numAlbums){
        this.name = name;
        this.numAlbums = numAlbums;
    }

    public Artist(Artist other){
        this.name = other.name;
        this.numAlbums = other.numAlbums;
        this.albums = other.albums;
    }

    public Artist(){}

    public void setAlbums(ArrayList<Album> albums){
        this.albums = albums;
    }

    public void PrintAlbums(){
        for (Album album : albums) {
            album.outputAlbum();
        }
    }

    public void deleteAlbum(){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Введите номер альбома, который хотите удалить:");
                int number = scanner.nextInt();

                if (number < 1 || number > albums.size()) {
                    throw new IndexOutOfBoundsException("Некорректный номер альбома");
                }

                albums.remove(number - 1);
                break;
            } catch (IndexOutOfBoundsException e) {
                System.err.println("Ошибка удаления альбома: " + e.getMessage());
            }
        }
    }

    public ArrayList<Album> getAlbums(){
        return albums;
    }
}
