import java.util.*;

public class Album {
    private String name = "";
    private Song song1 = null, song2 = null, song3 = null, song4 = null;
    private int totalTime=0;
    private final int MAX_TIME = 720; //12 minutes

    public String getName() {
        return name;
    } //gets the name of the album

    public void setName(String inputName) {
        name = inputName;
    } //sets the name of the album

    public void addSong(Scanner input) {
        boolean u = false;
        int n = getNumberSongs();
        if (song1 != null && song2 != null && song3 != null && song4 != null) {
            System.out.println("you cannot add more than 4 songs, please delete before adding another");
            return;
        }
        System.out.println("please enter the name of your song:");
        input.nextLine();
        String name = input.nextLine().strip();
        System.out.println("please enter the name of your artist:");
        String artist = input.nextLine().strip();
        System.out.println("please enter the duration of the song in seconds:");
        int duration = input.nextInt();
        totalTime += duration;
        if(totalTime>MAX_TIME){
            System.out.println("the total duration of song time within the album is to big which means this song cant be added");
            return;
        }
        System.out.println("please enter the genre of the song:");
        input.nextLine();
        String genre = input.nextLine().strip();
        while(!u){
            if(genre.equalsIgnoreCase("rock")|| genre.equalsIgnoreCase("pop") || genre.equalsIgnoreCase("hip-hop") || genre.equalsIgnoreCase("bossa nova")) u = true;
            else{
                System.out.println("genre can only be rock, pop, hip-hop or bossa nova, please enter the genre of the song:");
                genre = input.nextLine();
            }
        }
        if(song1!=null){
            if(name.equals(song1.getName()) && artist.equals(song1.getArtist()) && genre.equals(song1.getGenre()) && duration==song1.getDuration()){
                System.out.println("that song already exists so it cannot be added.");
                return;
            }
        }
        if(song2!=null){
            if(name.equals(song2.getName()) && artist.equals(song2.getArtist()) && genre.equals(song2.getGenre()) && duration==song2.getDuration()){
                System.out.println("that song already exists so it cannot be added.");
                return;
            }
        }
        if(song3!=null){
            if(name.equals(song3.getName()) && artist.equals(song3.getArtist()) && genre.equals(song3.getGenre()) && duration==song3.getDuration()){
                System.out.println("that song already exists so it cannot be added.");
                return;
            }
        }
        if(song4!=null){
            if(name.equals(song4.getName()) && artist.equals(song4.getArtist()) && genre.equals(song4.getGenre()) && duration==song4.getDuration()){
                System.out.println("that song already exists so it cannot be added.");
                return;
            }
        }
        if (song1 == null) {
            song1 = new Song();
            song1.setInfo(name, artist, duration, genre);
        } else if (song2 == null) {
            song2 = new Song();
            song2.setInfo(name, artist, duration, genre);
        } else if (song3 == null) {
            song3 = new Song();
            song3.setInfo(name, artist, duration, genre);
        } else if (song4 == null) {
            song4 = new Song();
            song4.setInfo(name, artist, duration, genre);
        }

    } //used in the new song function in SongCollection

    public int getNumberSongs() {
        int n=0;
        if(song1 != null){
            n += 1;
        } if(song2 != null){
            n += 1;
        } if(song3 != null){
            n += 1;
        } if(song4 != null){
            n += 1;
        }
        return n;
    } //gets the number of songs that are in a album

    public String list() {
        String returnS=null;
        if (song1 != null || song2 != null || song3 != null || song4 != null)  {
            if(song1 != null) {
                returnS = "\n Song name: " + song1.getName() + "\n Song Artist: " + song1.getArtist() + "\n Song Duration: " + song1.getDuration() + "\n Song Genre: " + song1.getGenre();
            }
            if(song2 != null) {
                returnS += "\n Song name: " + song2.getName() + "\n Song Artist: " + song2.getArtist() + "\n Song Duration: " + song2.getDuration() + "\n Song Genre: " + song2.getGenre();
            }
            if(song3 != null) {
                returnS += "\n Song name: " + song3.getName() + "\n Song Artist: " + song3.getArtist() + "\n Song Duration: " + song3.getDuration() + "\n Song Genre: " + song3.getGenre();
            }
            if(song4 != null) {
                returnS += "\n Song name: " + song4.getName() + "\n Song Artist: " + song4.getArtist() + "\n Song Duration: " + song4.getDuration() + "\n Song Genre: " + song4.getGenre();
            }
            return returnS;
        }
        else return("there is no songs in this album");
    } //returns the list of songs for the function listSongs in SongCollection

    public String underDuration(int x){
        String return2="";
        if(song1 != null){
            if(song1.getDuration()<x){
                return2 += song1.getName();
            }
        }
        if(song2 != null){
            if(song2.getDuration()<x){
                return2 += "\n" +song2.getName();
            }
        }
        if(song3 != null){
            if(song3.getDuration()<x){
                return2 += "\n" +song3.getName();
            }
        }
        if(song4 != null){
            if(song4.getDuration()<x){
                return2 += "\n" +song4.getName();
            }
        }
        return return2;
    } //checks what songs are under the duration and returns a string of them for the function listUnder in SongCollection

    public String listGenre(String g){
        String genre="";
        if(song1 != null){
            if(song1.getGenre().equals(g)){
                genre += song1.getName();
            }
        }
        if(song2 != null){
            if(song2.getGenre().equals(g)){
                genre += "\n" +song2.getName();
            }
        }
        if(song3 != null){
            if(song3.getGenre().equals(g)){
                genre += "\n" +song3.getName();
            }
        }
        if(song4 != null){
            if(song4.getGenre().equals(g)){
                genre += "\n" +song4.getName();
            }
        }
        return genre;
    }

    public void deleteSong(String c, String v){
        if(song1!=null){
            if(song1.getName().equals(c) && song1.getArtist().equals(v)){
                int duration = song1.getDuration();
                totalTime -= duration;
                System.out.println(song1.getName()+ " by " +song1.getArtist()+ " was deleted");
                song1=null;
            }
        }
        if(song2!=null){
            if(song2.getName().equals(c) && song2.getArtist().equals(v)){
                int duration = song2.getDuration();
                totalTime -= duration;
                System.out.println(song1.getName()+ " by " +song1.getArtist()+ " was deleted");
                song2 = null;
            }
        }
        if(song3!=null){
            if(song3.getName().equals(c) && song3.getArtist().equals(v)){
                int duration = song3.getDuration();
                totalTime -= duration;
                System.out.println(song3.getName()+ " was deleted");
                song3 = null;
            }
        }
        if(song4!=null){
            if(song4.getName().equals(c) && song4.getArtist().equals(v)){
                int duration = song4.getDuration();
                totalTime -= duration;
                System.out.println(song4.getName()+ " was deleted");
                song4 = null;
            }
        }
    }

    public boolean checkSongExists(String c, String v){
        boolean u = false;
        if(song1!=null){
            if(song1.getName().equals(c) && song1.getArtist().equals(v)){
                 u = true;
            }
        } if(song2!=null){
            if(song2.getName().equals(c) && song2.getArtist().equals(v)){
                u = true;
            }
        } if(song3!=null){
            if(song3.getName().equals(c) && song3.getArtist().equals(v)){
                u = true;
            }
        } if(song4!=null){
            if(song4.getName().equals(c) && song4.getArtist().equals(v)){
                u = true;
            }
        }
        return u;
    }

    public boolean checkAllSong(){
        if(song1 == null && song2 == null && song3 == null && song4 == null){
            return false;
        }
        return true;
    }
}


