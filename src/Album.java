//Class: Album
//class used to represent album. has all album instances and methods
// Abigail Hall
//C3324598

public class Album {
    private String name = null;
    private Song[] song = new Song[5];
    private int totalTime=0;
    private final int MAX_TIME = 720; //12 minutes
    private int numSong = 0;

    public String getName() {
        return name;
    } //gets the name of the album; returns a string

    public void setName(String inputName) {
        name = inputName;
    } //sets the name of the album

    //adds a song and returns a string to print to the user displaying either error messages, success messages or information
    public String addSong(String name1, String artist1, int duration1, String genre1) {
        String return1 = "";
        if (numSong == 5) {
            return1 += "you cannot add more than 5 songs, please delete before adding another";
            return return1;
        }
        totalTime += duration1; //adds the songs duration to the totalTime which is the variable keeping up of the total duration of all the songs
        if (totalTime >= MAX_TIME) { //makes sure that the total time of the songs doesn't exceed the mex time of 720 seconds.
            return1 += "the total duration of song time within the album is to big which means this song cant be added";
            totalTime -= duration1;
            return return1;
        }
        for (int i = 0; i < numSong; i++) {
            if (name1.equalsIgnoreCase(song[i].getName()) && artist1.equalsIgnoreCase(song[i].getArtist()) && duration1 == song[i].getDuration()) {
                return1 = "that song already exists so it cannot be added.";
                return return1;
            }
        }
        song[numSong] = new Song();
        song[numSong].setInfo(name1, artist1, duration1, genre1);
        return1 += song[numSong].getName() + " was added";
        numSong++;
        sortingModel();
        return return1;

        //if it made it to this point it means that there are no songs that match what the user has inputted and there are less than 4 songs,
        // so the song can be created
    }
    private void sortingModel(){
        Song temp;
        for(int j=0; j < numSong-1 ; j++){
            if(song[j].getName().compareToIgnoreCase(song[j+1].getName())>0){
                temp = song[j];
                song[j] = song[j +1];
                song[j+1]=temp;
            }
        }
    }


    //returns the list of songs within an album as a string
    public String list() {
        String returnS= "";
        if (numSong != 5)  { //checks that at least one song is not null within the album
            for(int i=0; i < numSong; i++){
                returnS += "\n Song name: " +song[i].getName() + "\n Song Artist: " + song[i].getArtist() + "\n Song Duration: " + song[i].getDuration() + "\n Song Genre: " + song[i].getGenre();
            }
            return returnS;
        }
        else return("there is no songs in this album"); //returns this error message if there are no songs
    }
    public String list2(String name1) {
        String return1 = "";
        for(int i=0; i < numSong; i++){
            if(name1.equalsIgnoreCase(song[i].getName())){
                return1 += "\n Song name: " +song[i].getName() + "\n Song Artist: " + song[i].getArtist() + "\n Song Duration: " + song[i].getDuration() + "\n Song Genre: " + song[i].getGenre();
            }
        }
        return return1;
    }

    //checks what songs are under the duration und; returns the list of songs as a String
    public String underDuration(float und){
        String return2 = "";
        und = und*60; //turns the input into seconds
        for(int i=0; i < numSong; i++) {
            if (song[i].getDuration() < und) {
                return2 += song[i].getName() + " ";
            }
        }
        return return2;
    }

    //returns a list of all the songs of a certain genre; this genre is passed to the method as String g
    public String listGenre(String g){
        String genre="";
        for(int i=0; i < numSong; i++){
            if(song[i].getGenre().equals(g)){
                genre += song[i].getName();
            }
        }
        if(genre.equals("")){
            return("there are no songs of this genre");
        }
        return genre;
    }

    //takes parameters of name1 and artist1 which are two strings representing the name and artist of the song.
    // This method returns a string to display to the user whilst also setting a song to null that matches the name and artist
    public String deleteSong(String name1, String artist1, int duration1){
        String return1="";
        for(int i=0; i < numSong; i++){
            if(song[i].getName().equalsIgnoreCase(name1) && song[i].getArtist().equalsIgnoreCase(artist1) && song[i].getDuration() == duration1){
                int duration = song[i].getDuration();
                totalTime -= duration;
                return1 += song[i].getName() + " by " +song[i].getArtist()+ " was deleted";
                for(int j=i; j < numSong-1; j++){
                    song[j] = song[j+1];
                }
                numSong--;
            }
        }
        return return1;
    }

    //checks if a song exists. Returns boolean true if a song matches the given Strings name1 and artist1 which are the name and artist respectively.
    public boolean checkSongExists(String name1, String artist1, int duration1){
        boolean u = false;
        for(int i=0; i < numSong; i++){
            if (song[i].getName().equalsIgnoreCase(name1) && song[i].getArtist().equalsIgnoreCase(artist1) && song[i].getDuration() == duration1) { //checks if the given name and artist match an already existing song within the album
                u = true; //boolean is set to true if the if statement is true
                break;
            }
        }
        return u;
    }

    //returns a boolean which shows if there is any avaliable space
    public boolean checkAllSong(){ //returns boolean which shows that there are any songs within an album
        return song[0] != null || song[1] != null || song[2] != null || song[3] != null || song[4] != null;
    }

    //Returns a string that has a list of all the songs within an album
    public String listName(){
        String return1="";
        if(song[0] != null) return1 += "\n Song name: " + song[0].getName();
        if(song[1] != null) return1 += "\n Song name: " + song[1].getName();
        if(song[2] != null) return1 += "\n Song name: " + song[2].getName();
        if(song[3] != null) return1 += "\n Song name: " + song[3].getName();
        if(song[4] != null) return1 += "\n Song name: " + song[4].getName();
        return return1;
    }

}


