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
        String return1="";
        if(numSong == 5){

        }
        if (song[0] != null && song[1] != null && song[2] != null && song[3] != null && song[4] != null) { //makes sure you don't add more than 4 songs
            return1 += "you cannot add more than 5 songs, please delete before adding another";
            return return1;
        }
        totalTime += duration1; //adds the songs duration to the totalTime which is the variable keeping up of the total duration of all the songs
        if(totalTime>MAX_TIME){ //makes sure that the total time of the songs doesn't exceed the mex time of 720 seconds.
            return1 += "the total duration of song time within the album is to big which means this song cant be added";
            totalTime -=duration1;
            return return1;
        }
        if(song[0]!=null){
            if(name1.equals(song[0].getName()) && artist1.equals(song[0].getArtist()) && duration1==song[0].getDuration()){
                //makes sure the input from the user of name, artist and duration doesn't match an already existing song
                return1 = "that song already exists so it cannot be added.";
                return return1;
            }
        }
        if(song[1]!=null){
            if(name1.equals(song[1].getName()) && artist1.equals(song[1].getArtist()) && duration1==song[1].getDuration()){
                return1 += "that song already exists so it cannot be added.";
                return return1;
            }
        }
        if(song[2]!=null){
            if(name1.equals(song[2].getName()) && artist1.equals(song[2].getArtist()) && duration1==song[2].getDuration()){
                return1 += "that song already exists so it cannot be added.";
                return return1;
            }
        }
        if(song[3]!=null){
            if(name1.equals(song[3].getName()) && artist1.equals(song[3].getArtist()) && duration1==song[3].getDuration()){
                return1 += "that song already exists so it cannot be added.";
                return return1;
            }
        }
        if(song[4]!=null){
            if(name1.equals(song[4].getName()) && artist1.equals(song[4].getArtist()) && duration1==song[4].getDuration()){
                return1 += "that song already exists so it cannot be added.";
                return return1;
            }
        }
        //if it made it to this point it means that there are no songs that match what the user has inputted and there are less than 4 songs,
        // so the song can be created
        if (song[0] == null) {
            song[0] = new Song();
            song[0].setInfo(name1, artist1, duration1, genre1); //calls the function set info and passes parameters; name1, artist1, duration1 and genre1
            return1 += song[0].getName() +" was added";
        } else if (song[1] == null) {
            song[1] = new Song();
            song[1].setInfo(name1, artist1, duration1, genre1);
            return1 += song[1].getName() +" was added";
        } else if (song[2] == null) {
            song[2] = new Song();
            song[2].setInfo(name1, artist1, duration1, genre1);
            return1 += song[2].getName() +" was added";
        } else if (song[3] == null) {
            song[3] = new Song();
            song[3].setInfo(name1, artist1, duration1, genre1);
            return1 += song[3].getName() +" was added";
        } else if (song[4] == null) {
            song[4] = new Song();
            song[4].setInfo(name1, artist1, duration1, genre1);
            return1 += song[4].getName() +" was added";
        }
        return return1;
    }

    //returns the list of songs within an album as a string
    public String list() {
        String returnS=null;
        if (song[0] != null || song[1] != null || song[2] != null || song[3] != null || song[4] != null)  { //checks that at least one song is not null within the album
            if(song[0] != null) {
                returnS = "\n Song name: " + song[0].getName() + "\n Song Artist: " + song[0].getArtist() + "\n Song Duration: " + song[0].getDuration() + "\n Song Genre: " + song[0].getGenre();
            }
            if(song[1] != null) {
                returnS += "\n\n Song name: " + song[1].getName() + "\n Song Artist: " + song[1].getArtist() + "\n Song Duration: " + song[1].getDuration() + "\n Song Genre: " + song[1].getGenre();
            }
            if(song[2] != null) {
                returnS += "\n\n Song name: " + song[2].getName() + "\n Song Artist: " + song[2].getArtist() + "\n Song Duration: " + song[2].getDuration() + "\n Song Genre: " + song[2].getGenre();
            }
            if(song[3] != null) {
                returnS += "\n\n Song name: " + song[3].getName() + "\n Song Artist: " + song[3].getArtist() + "\n Song Duration: " + song[3].getDuration() + "\n Song Genre: " + song[3].getGenre();
            }
            if(song[4] != null) {
                returnS += "\n\n Song name: " + song[4].getName() + "\n Song Artist: " + song[4].getArtist() + "\n Song Duration: " + song[4].getDuration() + "\n Song Genre: " + song[4].getGenre();
            }
            return returnS;
        }
        else return("there is no songs in this album"); //returns this error message if there are no songs
    }

    //checks what songs are under the duration und; returns the list of songs as a String
    public String underDuration(float und){
        String return2="";
        und = und*60; //turns the input into seconds
        if(song[0] != null){
            if(song[0].getDuration()<und){ //gets the duration of song 1 and checks if it is less than the inputted duration
                return2 += song[0].getName(); //adds the song name to the string that is to be returned so it can be displayed to the user
            }
        }
        if(song[1] != null){
            if(song[1].getDuration()<und){
                return2 += "\n" +song[1].getName();
            }
        }
        if(song[2] != null){
            if(song[2].getDuration()<und){
                return2 += "\n" +song[2].getName();
            }
        }
        if(song[3] != null){
            if(song[3].getDuration()<und){
                return2 += "\n" +song[3].getName();
            }
        }
        if(song[4] != null){
            if(song[4].getDuration()<und){
                return2 += "\n" +song[4].getName();
            }
        }
        return return2;
    }

    //returns a list of all the songs of a certain genre; this genre is passed to the method as String g
    public String listGenre(String g){
        String genre="";
        if(song[0] != null){
            if(song[0].getGenre().equals(g)){ //checks if the genre of song 1 is the same as the user input
                genre += song[0].getName(); //adds the song name to the string that is to be returned since it is of the same genre of the user input
            }
        }
        if(song[1] != null){
            if(song[1].getGenre().equals(g)){
                genre += "\n" +song[1].getName();
            }
        }
        if(song[2] != null){
            if(song[2].getGenre().equals(g)){
                genre += "\n" +song[2].getName();
            }
        }
        if(song[3] != null){
            if(song[3].getGenre().equals(g)){
                genre += "\n" +song[3].getName();
            }
        }
        if(song[4] != null){
            if(song[4].getGenre().equals(g)){
                genre += "\n" +song[4].getName();
            }
        }
        return genre;
    }

    //takes parameters of name1 and artist1 which are two strings representing the name and artist of the song.
    // This method returns a string to display to the user whilst also setting a song to null that matches the name and artist
    public String deleteSong(String name1, String artist1, int duration1){
        String return1="";
        if(song[0]!=null){
            if(song[0].getName().equalsIgnoreCase(name1) && song[0].getArtist().equalsIgnoreCase(artist1) && song[0].getDuration()==(duration1)){ //checks that this song exists ie. name and artist are the same for one of the songs
                int duration = song[0].getDuration(); //since this song does exist, the duration is then retrieved
                totalTime -= duration; //since we are deleting the song, the duration of the song must be deducted from the total time
                return1 += song[0].getName()+ " by " +song[0].getArtist()+ " was deleted"; //adds to the string return1 which is to be returned to the user to display the message that a particular song was deleted
                song[0]=null; //deletes the song
            }
        }
        if(song[1]!=null){
            if(song[1].getName().equals(name1) && song[1].getArtist().equals(artist1) && song[1].getDuration()==duration1){
                int duration = song[1].getDuration();
                totalTime -= duration;
                return1 += song[1].getName()+ " by " +song[1].getArtist()+ " was deleted";
                song[1] = null;
            }
        }
        if(song[2]!=null){
            if(song[2].getName().equalsIgnoreCase(name1) && song[2].getArtist().equalsIgnoreCase(artist1) && song[2].getDuration()==duration1){
                int duration = song[2].getDuration();
                totalTime -= duration;
                return1 += song[2].getName()+ " was deleted";
                song[2] = null;
            }
        }
        if(song[3]!=null){
            if(song[3].getName().equalsIgnoreCase(name1) && song[3].getArtist().equalsIgnoreCase(artist1) && song[3].getDuration()==duration1){
                int duration = song[3].getDuration();
                totalTime -= duration;
                return1 += song[3].getName()+ " was deleted";
                song[3] = null;
            }
        }
        if(song[4]!=null){
            if(song[4].getName().equalsIgnoreCase(name1) && song[4].getArtist().equalsIgnoreCase(artist1) && song[4].getDuration()==duration1){
                int duration = song[4].getDuration();
                totalTime -= duration;
                return1 += song[4].getName()+ " was deleted";
                song[4] = null;
            }
        }
        return return1;
    }

    //checks if a song exists. Returns boolean true if a song matches the given Strings name1 and artist1 which are the name and artist respectively.
    public boolean checkSongExists(String name1, String artist1, int duration1){
        boolean u = false;
        if(song[0]!=null){
            if(song[0].getName().equalsIgnoreCase(name1) && song[0].getArtist().equalsIgnoreCase(artist1) && song[0].getDuration()==duration1){ //checks if the given name and artist match an already existing song within the album
                 u = true; //boolean is set to true if the if statement is true
            }
        } if(song[1]!=null){
            if(song[1].getName().equalsIgnoreCase(name1) && song[1].getArtist().equalsIgnoreCase(artist1) && song[1].getDuration()==duration1){
                u = true;
            }
        } if(song[2]!=null){
            if(song[2].getName().equalsIgnoreCase(name1) && song[2].getArtist().equalsIgnoreCase(artist1) && song[2].getDuration()== duration1){
                u = true;
            }
        } if(song[3]!=null){
            if(song[3].getName().equalsIgnoreCase(name1) && song[3].getArtist().equalsIgnoreCase(artist1) && song[3].getDuration()== duration1){
                u = true;
            }
        } if(song[4]!=null){
            if(song[4].getName().equalsIgnoreCase(name1) && song[4].getArtist().equalsIgnoreCase(artist1) && song[4].getDuration()== duration1){
                u = true;
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


