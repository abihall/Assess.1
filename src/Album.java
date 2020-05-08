//Class: Album
//class used to represent album. has all album instances and methods
// Abigail Hall
//C3324598

public class Album {
    private String name = null;
    private Song song1 = null, song2 = null, song3 = null, song4 = null;
    private int totalTime=0;
    private final int MAX_TIME = 720; //12 minutes

    public String getName() {
        return name;
    } //gets the name of the album; returns a string

    public void setName(String inputName) {
        name = inputName;
    } //sets the name of the album

    //adds a song and returns a string to print to the user displaying either error messages, success messages or information
    public String addSong(String name1, String artist1, int duration1, String genre1) {
        String return1="";
        if (song1 != null && song2 != null && song3 != null && song4 != null) { //makes sure you don't add more than 4 songs
            return1 += "you cannot add more than 4 songs, please delete before adding another";
            return return1;
        }
        totalTime += duration1; //adds the songs duration to the totalTime which is the variable keeping up of the total duration of all the songs
        if(totalTime>MAX_TIME){ //makes sure that the total time of the songs doesn't exceed the mex time of 720 seconds.
            return1 += "the total duration of song time within the album is to big which means this song cant be added";
            return return1;
        }
        if(song1!=null){
            if(name1.equals(song1.getName()) && artist1.equals(song1.getArtist()) && duration1==song1.getDuration()){
                //makes sure the input from the user of name, artist and duration doesn't match an already existing song
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
        //if it made it to this point it means that there are no songs that match what the user has inputted and there are less than 4 songs,
        // so the song can be created
        if (song1 == null) {
            song1 = new Song();
            song1.setInfo(name1, artist1, duration1, genre1); //calls the function set info and passes parameters; name1, artist1, duration1 and genre1
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
    }

    //returns the list of songs within an album as a string
    public String list() {
        String returnS=null;
        if (song1 != null || song2 != null || song3 != null || song4 != null)  { //checks that at least one song is not null within the album
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
        else return("there is no songs in this album"); //returns this error message if there are no songs
    }

    //checks what songs are under the duration und; returns the list of songs as a String
    public String underDuration(float und){
        String return2="";
        und = und*60; //turns the input into seconds
        if(song1 != null){
            if(song1.getDuration()<und){ //gets the duration of song 1 and checks if it is less than the inputted duration
                return2 += song1.getName(); //adds the song name to the string that is to be returned so it can be displayed to the user
            }
        }
        if(song2 != null){
            if(song2.getDuration()<und){
                return2 += "\n" +song2.getName();
            }
        }
        if(song3 != null){
            if(song3.getDuration()<und){
                return2 += "\n" +song3.getName();
            }
        }
        if(song4 != null){
            if(song4.getDuration()<und){
                return2 += "\n" +song4.getName();
            }
        }
        return return2;
    }

    //returns a list of all the songs of a certain genre; this genre is passed to the method as String g
    public String listGenre(String g){
        String genre="";
        if(song1 != null){
            if(song1.getGenre().equals(g)){ //checks if the genre of song 1 is the same as the user input
                genre += song1.getName(); //adds the song name to the string that is to be returned since it is of the same genre of the user input
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

    //takes parameters of name1 and artist1 which are two strings representing the name and artist of the song.
    // This method returns a string to display to the user whilst also setting a song to null that matches the name and artist
    public String deleteSong(String name1, String artist1, int duration1){
        String return1="";
        if(song1!=null){
            if(song1.getName().equalsIgnoreCase(name1) && song1.getArtist().equalsIgnoreCase(artist1) && song1.getDuration()==(duration1)){ //checks that this song exists ie. name and artist are the same for one of the songs
                int duration = song1.getDuration(); //since this song does exist, the duration is then retrieved
                totalTime -= duration; //since we are deleting the song, the duration of the song must be deducted from the total time
                return1 += song1.getName()+ " by " +song1.getArtist()+ " was deleted"; //adds to the string return1 which is to be returned to the user to display the message that a particular song was deleted
                song1=null; //deletes the song
            }
        }
        if(song2!=null){
            if(song2.getName().equals(name1) && song2.getArtist().equals(artist1) && song2.getDuration()==duration1){
                int duration = song2.getDuration();
                totalTime -= duration;
                return1 += song1.getName()+ " by " +song1.getArtist()+ " was deleted";
                song2 = null;
            }
        }
        if(song3!=null){
            if(song3.getName().equalsIgnoreCase(name1) && song3.getArtist().equalsIgnoreCase(artist1) && song3.getDuration()==duration1){
                int duration = song3.getDuration();
                totalTime -= duration;
                return1 += song3.getName()+ " was deleted";
                song3 = null;
            }
        }
        if(song4!=null){
            if(song4.getName().equalsIgnoreCase(name1) && song4.getArtist().equalsIgnoreCase(artist1) && song4.getDuration()==duration1){
                int duration = song4.getDuration();
                totalTime -= duration;
                return1 += song4.getName()+ " was deleted";
                song4 = null;
            }
        }
        return return1;
    }

    //checks if a song exists. Returns boolean true if a song matches the given Strings name1 and artist1 which are the name and artist respectively.
    public boolean checkSongExists(String name1, String artist1, int duration1){
        boolean u = false;
        if(song1!=null){
            if(song1.getName().equalsIgnoreCase(name1) && song1.getArtist().equalsIgnoreCase(artist1) && song1.getDuration()==duration1){ //checks if the given name and artist match an already existing song within the album
                 u = true; //boolean is set to true if the if statement is true
            }
        } if(song2!=null){
            if(song2.getName().equalsIgnoreCase(name1) && song2.getArtist().equalsIgnoreCase(artist1) && song2.getDuration()==duration1){
                u = true;
            }
        } if(song3!=null){
            if(song3.getName().equalsIgnoreCase(name1) && song3.getArtist().equalsIgnoreCase(artist1) && song3.getDuration()== duration1){
                u = true;
            }
        } if(song4!=null){
            if(song4.getName().equalsIgnoreCase(name1) && song4.getArtist().equalsIgnoreCase(artist1) && song4.getDuration()== duration1){
                u = true;
            }
        }
        return u;
    }

    //returns a boolean which shows if there is any avaliable space
    public boolean checkAllSong(){ //returns boolean which shows that there are any songs within an album
        return song1 != null || song2 != null || song3 != null || song4 != null;
    }

    //Returns a string that has a list of all the songs within an album
    public String listName(){
        String return1="";
        if(song1 != null) return1 += "\n Song name: " + song1.getName();
        if(song2 != null) return1 += "\n Song name: " + song2.getName();
        if(song3 != null) return1 += "\n Song name: " + song3.getName();
        if(song4 != null) return1 += "\n Song name: " + song4.getName();
        return return1;
    }

}


