import java.util.*;

public class Album {
    private String name = "";
    private Song song1 = null, song2 = null, song3 = null, song4 = null;
    private int totalTime, end = 0, n = 0;
    private final int MAX_TIME = 720; //12 minutes

    public Album() {

    }

    public String getName() {
        return name;
    }

    public void setName(String inputName) {
        name = inputName;
    }

    public void addSong(Scanner x) {
        if (song1 == null || song2 == null || song3 == null || song4 == null) {
            System.out.println("please enter the name of your song:");
            String name = x.next();
            System.out.println("please enter the name of your artist:");
            String artist = x.next();
            System.out.println("please enter the duration of the song:");
            int duration = x.nextInt();
            System.out.println("please enter the genre of the song:");
            String genre = x.next();
            if (song1 == null) {
                song1 = new Song();
                song1.setName(name);
                song1.setArtist(artist);
                song1.setDuration(duration);
                song1.setGenre(genre);
            } else if (song2 == null) {
                song2 = new Song();
                song2.setName(name);
                song2.setArtist(artist);
                song2.setDuration(duration);
                song2.setGenre(genre);
            } else if (song3 == null) {
                song3 = new Song();
                song3.setName(name);
                song3.setArtist(artist);
                song3.setDuration(duration);
                song3.setGenre(genre);
            } else if (song4 == null) {
                song4 = new Song();
                song4.setName(name);
                song4.setArtist(artist);
                song4.setDuration(duration);
                song4.setArtist(genre);
            }
        } else {
            System.out.println("there is no avaliable space");
        }
    }

    public int getNumberSongs() {
        if (song1 != null && song2 != null && song3 != null && song4 != null) {
            n = n + 4;
        }
        return n;
    }

    public String list() {
        String returnS=null;
        if (song1 != null || song2 != null || song3 != null || song4 != null)  {
            if(song1 != null) {
                returnS = "\n\nSong name: " + song1.getName() + "\n Song Artist: " + song1.getArtist() + "\n Song Duration: " + song1.getDuration() + "\n Song Genre: " + song1.getGenre();
            }
            if(song2 != null) {
                returnS += "\n\n Song name: " + song2.getName() + "\n Song Artist: " + song2.getArtist() + "\n Song Duration: " + song2.getDuration() + "\n Song Genre: " + song2.getGenre();
            }
            if(song3 != null) {
                returnS += "\n\n Song name: " + song3.getName() + "\n Song Artist: " + song3.getArtist() + "\n Song Duration: " + song3.getDuration() + "\n Song Genre: " + song3.getGenre();
            }
            if(song4 != null) {
                returnS += "\n\n Song name: " + song4.getName() + "\n Song Artist: " + song4.getArtist() + "\n Song Duration: " + song4.getDuration() + "\n Song Genre: " + song4.getGenre();
            }
            return returnS;
        }
        else return null;
    }
    public String underDuration(int x){
        String return2=null;
        if(song1.getDuration()<x){
            return2 += "\n" +song1.getName();
        }
        if(song2.getDuration()<x){
            return2 += "\n" +song2.getName();
        }
        if(song3.getDuration()<x){
            return2 += "\n" +song3.getName();
        }
        if(song3.getDuration()<x){
            return2 += "\n" +song4.getName();
        }
        return return2;
    }
}


