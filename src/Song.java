public class Song {

   private String name, artist, genre;
   private int duration;

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
}
