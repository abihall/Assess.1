//Abigail Hall
//C3324598

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

    public String addSong(String name1, String artist1, int duration1, String genre1) {
        String return1="";
        if (song1 != null && song2 != null && song3 != null && song4 != null) {
            return1 += "you cannot add more than 4 songs, please delete before adding another";
            return return1;
        }
        totalTime += duration1;
        if(totalTime>MAX_TIME){
            return1 += "the total duration of song time within the album is to big which means this song cant be added";
            return return1;
        }
        if(song1!=null){
            if(name1.equals(song1.getName()) && artist1.equals(song1.getArtist()) && duration1==song1.getDuration()){
                return1 = "that song already exists so it cannot be added.";
                return return1;
            }
        }
        if(song2!=null){
            if(name1.equals(song2.getName()) && artist1.equals(song2.getArtist()) && duration1==song2.getDuration()){
                return1 += "that song already exists so it cannot be added.";
                return return1;
            }
        }
        if(song3!=null){
            if(name1.equals(song3.getName()) && artist1.equals(song3.getArtist()) && duration1==song3.getDuration()){
                return1 += "that song already exists so it cannot be added.";
                return return1;
            }
        }
        if(song4!=null){
            if(name1.equals(song4.getName()) && artist1.equals(song4.getArtist()) && duration1==song4.getDuration()){
                return1 += "that song already exists so it cannot be added.";
                return return1;
            }
        }
        if (song1 == null) {
            song1 = new Song();
            song1.setInfo(name1, artist1, duration1, genre1);
            return1 += song1.getName() +" was added";
        } else if (song2 == null) {
            song2 = new Song();
            song2.setInfo(name1, artist1, duration1, genre1);
            return1 += song2.getName() +" was added";
        } else if (song3 == null) {
            song3 = new Song();
            song3.setInfo(name1, artist1, duration1, genre1);
            return1 += song3.getName() +" was added";
        } else if (song4 == null) {
            song4 = new Song();
            song4.setInfo(name1, artist1, duration1, genre1);
            return1 += song4.getName() +" was added";
        }
        return return1;
    } //used in the new song function in SongCollectio
    //gets the number of songs that are in a album

    public String list() {
        String returnS=null;
        if (song1 != null || song2 != null || song3 != null || song4 != null)  {
            if(song1 != null) {
                returnS = "\n Song name: " + song1.getName() + "\n Song Artist: " + song1.getArtist() + "\n Song Duration: " + song1.getDuration() + "\n Song Genre: " + song1.getGenre();
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
        else return("there is no songs in this album");
    }
    //returns the list of songs for the function listSongs in SongCollection

    public String underDuration(float x){
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
    }
    //checks what songs are under the duration and returns a string of them for the function listUnder in SongCollection

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

    public String deleteSong(String c, String v){
        String return1="";
        if(song1!=null){
            if(song1.getName().equals(c) && song1.getArtist().equals(v)){
                int duration = song1.getDuration();
                totalTime -= duration;
                return1 += song1.getName()+ " by " +song1.getArtist()+ " was deleted";
                song1=null;
            }
        }
        if(song2!=null){
            if(song2.getName().equals(c) && song2.getArtist().equals(v)){
                int duration = song2.getDuration();
                totalTime -= duration;
                return1 += song1.getName()+ " by " +song1.getArtist()+ " was deleted";
                song2 = null;
            }
        }
        if(song3!=null){
            if(song3.getName().equals(c) && song3.getArtist().equals(v)){
                int duration = song3.getDuration();
                totalTime -= duration;
                return1 += song3.getName()+ " was deleted";
                song3 = null;
            }
        }
        if(song4!=null){
            if(song4.getName().equals(c) && song4.getArtist().equals(v)){
                int duration = song4.getDuration();
                totalTime -= duration;
                return1 += song4.getName()+ " was deleted";
                song4 = null;
            }
        }
        return return1;
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
        return song1 != null || song2 != null || song3 != null || song4 != null;
    }
    public String listName(){
        String return1="";
        if(song1 != null) return1 += "\n Song name: " + song1.getName();
        if(song2 != null) return1 += "\n Song name: " + song2.getName();
        if(song3 != null) return1 += "\n Song name: " + song3.getName();
        if(song4 != null) return1 += "\n Song name: " + song4.getName();
        return return1;
    }

}


