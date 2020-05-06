//Abigail Hall
//C3324598

public class Song {

   private String name=null, artist=null, genre=null;
   private int duration=0;

    public void setName(String inputName) {
        name = inputName;
    }
    public String getName() {
        return name;
    }
    public void setArtist(String inputArtist){
       artist = inputArtist;
    }
    public String getArtist(){
       return artist;
    }
    public void setGenre(String inputGenre){
       genre = inputGenre;
    }
    public String getGenre(){
        return genre;
    }
    public void setDuration(int inputDuration) {
        duration = inputDuration;
    }
    public int getDuration(){
        return duration;
    }
    public void setInfo(String name, String artist, int duration, String genre){
        setName(name);
        setArtist(artist);
        setDuration(duration);
        setGenre(genre);
    }
}
