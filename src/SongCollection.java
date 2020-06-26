//Class: SongCollection
//class used to represent SongCollection. has all SongCollection instances and methods
// Abigail Hall
//C3324598

import java.io.*;
import java.util.Scanner;

public class SongCollection {
    private final Album[] album = new Album[4];
    private boolean t=true, file=true;
    private int numAlbum = 0;
    private final String FILE_NAME = "ReginaCollection";

    private void run() {
        System.out.println("\n\nbefore we start, there are a few things to note: "); //Gives message to the user
        System.out.println("the input is not case sensitive nor does it matter if spaces are put before or after the input");
        System.out.println("there is sorting implemented to sort the album names and songs in alphabetical order ");

        Scanner console = new Scanner(System.in); //Forms the console that is used throughout the code

        while(t) {
            System.out.println("would you like to use an external file? type yes or no");
            String ch = console.nextLine(); //takes the users input; either yes or no for file use

            if (ch.equalsIgnoreCase("yes")) { //checks if the string ch is equal to yes
                t = false; //t is used for the while loop, it determines if the user inputted either yes or no
                file = true; //declares the boolean variable file true if they typed yes
                ReadFile(console); //calls the method ReadFile, passes console
            } else if (ch.equalsIgnoreCase("no")) { //checks if the user inputted no
                System.out.println("all good, continue-"); //displays message
                t = false;
                file = false; //declares the boolean variable file false if they typed no
            } else {
                System.out.println("that wasn't yes or no!");
                t = true;
            }
        }
        while(true) { //this while loop makes sure the messages are constantly asked until the user decides the exit
            //displays multipule messages to the user and asks them to pick one
            System.out.println("\nthe following is a list of all the tasks you can complete, please type the corrosponding number to the task you would like to complete");
            System.out.println("(1) create a album");
            System.out.println("(2) enter a new song into a album");
            System.out.println("(3) list of all songs");
            System.out.println("(4) list of all albums");
            System.out.println("(5) list of all songs under a certain time");
            System.out.println("(6) list of all songs from a certain genre");
            System.out.println("(7) delete a album");
            System.out.println("(8) delete a song from a album");
            System.out.println("(9) if you want to list a song with a particular name");
            System.out.println("(10) exit");
            int choice = console.nextInt(); //takes the choice of the user

            switch (choice) { //creates a switch statement for this choice
                case 1: {
                    makeAlbum(console, ""); //calls the method makeAlbum
                    break;
                }
                case 2: {
                    newSong(console,"","","","", ""); //calls the method newSong
                    break;
                }
                case 3: {
                    if (numAlbum == 0) { //checks if no albums exist, ie. the numAlbum counter is zero, displays message if this is the case
                        System.out.println("there are no albums to list the songs for");
                        break;
                    }
                    listSongs(console); //calls the method listSongs
                    break;
                }
                case 4: {
                    if (numAlbum == 0) { //checks if no albums exist, ie. the numAlbum counter is zero, displays message if this is the case
                        System.out.println("there are no albums to list");
                        break;
                    }
                    listAlbums(); //calls the method listAlbums
                    break;
                }
                case 5: {
                    if (numAlbum == 0) { //checks if all the albums are null, if so displays a message
                        System.out.println("there are no songs yet");
                        break;
                    }
                    listUnder(console); //calls the method listUnder
                    break;
                }
                case 6: {
                    if (numAlbum == 0) { //checks if no albums exist, ie. the numAlbum counter is zero, displays message if this is the case
                        System.out.println("there are no songs yet");
                        break;
                    }
                    listGenre(console); //calls the method listGenre
                    break;
                }
                case 7: {
                    if (numAlbum == 0) { //checks if no albums exist, ie. the numAlbum counter is zero, displays message if this is the case
                        System.out.println("there are no albums to delete");
                        break;
                    }
                    deleteAlbum(console); //calls the method deleteAlbum
                    break;
                }
                case 8: {
                    if (numAlbum == 0){
                        System.out.println("there are no songs to delete");
                        break;
                    }
                    deleteSong(console);
                    break;
                }
                case 9: {
                    String x = listOneSong(console); //declares a string x which is assigned the value returned by the listOneSong method
                    if(x.equalsIgnoreCase("")){ //checks if the string x is equal to " " which is what it was initialised. if this is the case, there are no songs of the inputted name
                        System.out.println("There are no songs of this name");
                    }
                    else {
                        System.out.println(x); //if that message wasn't displayed, it means there was a song with the given name from listOneSong, it is then printed
                    }
                    break;
                }
                case 10: {
                    System.out.println("You exited!");
                    return;
                }
                default: {
                    System.out.println("incorrect input, please enter 1,2,3,4,5,6,7,8 or 9 next time\n"); //default is used if hte user inputs a number that isn't in the switch case
                    break;
                }
            }
        }
    }
    public static void main(String[] args) {
        SongCollection sg = new SongCollection(); //creates a new instance of SongCollection class
        sg.run(); //runs the SongCollection.run() method within song collection
    }

    //makes a new album
    private void makeAlbum(Scanner y, String name1) {    //this method takes parameters of the scanner and name1. this name1 is the name of tha album.
        //name1 is " " if the album is made from user input NOT from the file or name1 is the name of the album if it is from the file.

        //FILE
        if(file){
            album[numAlbum] = new Album(); //creates a new album at the index of numAlbum of album declared at the top of the file.
            album[numAlbum].setName(name1); //sets the name of the album at index numAlbum of album[4]
            numAlbum++; //increuments the number of albums
            System.out.println("Album: " +name1+ " was added"); //creates message for the user
            return;
        }
        //NOT FILE
        if (numAlbum < 4) { //having this if statement allows the user to only enter the name of an album if there is avaliable space
            System.out.println("please enter the name of your album:");
            y.nextLine(); //gets rid of the /n
            name1 = y.nextLine().strip(); //this is where name1 is redeclared to be the album name rather than " ".

            if (checkAlbumExist(name1)) {
                album[numAlbum] = new Album();//creates a new album at the index of numAlbum of album declared at the top of the file.
                album[numAlbum].setName(name1); //sets the name of the album at index numAlbum of album[4]
                numAlbum++; //incretments the number of albums
                System.out.println("Album: " +name1+ " was added");
            } else {
                System.out.println("that album already exists"); //error message
            }
        } else {
            System.out.println("there is no avaliable space"); //error message
        }
        sortingModel(); //calls the sorting model to sort the album names everytime one is made.
    }

    // adds a new song into an album
    private void newSong(Scanner y, String albumName1, String name1, String artist1, String duration1, String genre1) {

        //this method took parameters of albumName1, name1, artist1, duration1, genre1 and scanner y.
        // if from file, the parameters are the required strings.
        //if from user input, the parameters are all " " (other than scanner) and are redeclared.
        boolean valid = false;
        boolean u = false;

        //FILE
        if(file){
            duration1 = duration1.trim();
            int duration2 = Integer.parseInt(duration1);
            for (int i = 0; i < numAlbum; i++) {
                if(album[i].getName().equalsIgnoreCase(albumName1)){
                    System.out.println(album[i].addSong(name1,artist1,duration2,genre1));
                }
            }
            return;
        }
        //NOT FILE
        if (numAlbum == 0) { //this statement checks if none of the albums exist, and if so displays the error message
            System.out.println("there are no albums to add songs into");
            return;
        }
        //this section is listing all the songs with the same name inputted and then asks the user if they want to continue
        String nameList = listOneSong(y);
        if(!nameList.equalsIgnoreCase("")) {
            System.out.println(nameList);
            System.out.println("Would you like to continue? Type yes or no");
            String choice = y.nextLine();
            if(choice.equalsIgnoreCase("no")){
                    return;
            }
        }
        System.out.println("Please type the name of the album you want to add a song into");
        String albumName = y.nextLine().strip(); //scans the next entered line, strips white space and assigns it to the string albumName
        System.out.println("please enter the name of your song:");
        String name = y.nextLine().strip();
        System.out.println("please enter the name of your artist:");
        String artist = y.nextLine().strip();
        System.out.println("please enter the duration of the song in seconds:");
        int duration = y.nextInt();
        System.out.println("please enter the genre of the song:");
        y.nextLine();
        String genre = y.nextLine().strip();
        while(!u){ //u is boolean and is initialised to false. If the genre is rock, pop, hip-hop or bossa nova u is then set to true. the else statement re-asks for the genre again
            if(genre.equalsIgnoreCase("rock")|| genre.equalsIgnoreCase("pop") || genre.equalsIgnoreCase("hip-hop") || genre.equalsIgnoreCase("bossa nova")) u = true;
            else{
                System.out.println("genre can only be rock, pop, hip-hop or bossa nova, please enter the genre of the song:");
                genre = y.nextLine();
            }
        }
        for (int i = 0; i < numAlbum; i++) {
            if(album[i].getName().equalsIgnoreCase(albumName)){
                valid = true;
                System.out.println(album[i].addSong(name,artist,duration,genre));
            }
        }
        if (!valid) { //valid is boolean and is initalised to false, if the album name entered is a valid album name then the message below won't be displayed
            System.out.println("you didnt enter a valid album option so this song cant be added");
        }
    }
    //lists all the songs
    private void listSongs(Scanner y) {
        System.out.println("what album would you like to list all the songs for?");
        for (int i = 0; i < numAlbum; i++) {
            System.out.println("Press " +i+ " for all the songs in " +album[i].getName());
        }
        int choice2 = y.nextInt();
        if(album[choice2] != null){
            if(album[choice2].list().equalsIgnoreCase("")){
                System.out.println("There are no songs in this album");
            }
            System.out.println(album[choice2].list());
        }else System.out.println("that wasn't a valid album so it cannot be listed");
    }

    //lists all the albums
    private void listAlbums() {
        System.out.println("the following is a list of all albums and songs");

        for (int i = 0; i < numAlbum; i++) {
            System.out.println("Album name: " + album[i].getName());
            System.out.println(album[i].listName());
        }
    }

    //lists all the songs under a certian time that is inputted by the user
    private void listUnder(Scanner y) {
        float under;
        System.out.println("what duration must the songs be under in minutes? The minutes should be a whole number or decimal");
        under = y.nextFloat();
        System.out.println("all the songs under this time are: ");
        for (int i = 0; i < numAlbum; i++) {
            System.out.println(album[i].underDuration(under));
        }
    }

    //lists all the songs from a specific genre specified by the user
    private void listGenre(Scanner y) {
        String genre;
        boolean u = false;
        boolean check = checkSongInAll(); //calls the method checkSongInAll that returns a boolean and stores it in check which is of type boolean
        if (check) return; //if check is true, it means there are no songs in any of the albums the method returns and stops running.
        System.out.println("please enter the genre you would like to list all the songs for ");
        y.nextLine();
        genre = y.nextLine();
        while (!u) {  //u is boolean and is initialised to false. If the genre entered by the user is rock, pop, hip-hop or bossa nova, u is then set to true. the else statement re-asks for the genre again
            if (genre.equalsIgnoreCase("rock") || genre.equalsIgnoreCase("pop") || genre.equalsIgnoreCase("hip-hop") || genre.equalsIgnoreCase("bossa nova")) {
                u = true;
            } else {
                System.out.println("genre can only be rock, pop, hip-hop or bossa nova, please enter the genre of the song:");
                genre = y.nextLine();
            }
        }
        for (int i = 0; i < numAlbum; i++) {
            System.out.println("All the songs of this genre from album " +album[i].getName()+ " is:\n" +album[i].listGenre(genre));
        }
    }

    //deletes an album
    private void deleteAlbum(Scanner y) {
        String choice;
        boolean u = false;
        System.out.println("please enter the name of the album you would like to delete, the options are the following: ");
        for(int i=0; i < numAlbum; i++){
            System.out.println(album[i].getName());
        }
        if(album[0] == null){
            System.out.println("there is no albums to list you must make a album before deleting it");
            return;
        }else{
            y.nextLine();
            choice = y.nextLine().strip();
        }
        for(int i=0; i < numAlbum; i++){
            if(album[i].getName().equalsIgnoreCase(choice)){
                System.out.println(album[i].getName() + " was deleted");
                u = true;
                for(int j = i; j < numAlbum-1; j++){ //this shifts all the albums down a space, filling in the space the album was deleted
                    album[j] = album[j+1];
                }
                numAlbum--;
            }
        }
        if (!u) { // is boolean u is false at the end of this method, the following error message is displayed
            System.out.println("that album name doesnt exist");
        }

    }

    //deletes a song
    private void deleteSong(Scanner y) {
        String name;
        String artist;
        int duration;
        boolean al = false;
        System.out.println("the following is a list of all songs in each album: \n");
        for(int i=0; i < numAlbum; i++){
            System.out.println("all the songs in the album '" + album[i].getName() + "' are: \n" + album[i].list());
        }

        if (checkSongInAll()) {
            System.out.println(" which means there are no songs to delete");
            return;
        }
        System.out.println("\nplease enter the name of the album that has the song you want to delete");
        y.nextLine();
        String album_name = y.nextLine();
        if (checkAlbumExist(album_name)) { //calls the function checkAlbumExist. if it returns true it means there are no albums that match the album name entered by the user
            System.out.println("that album doesnt exist so a song cannot be deleted from it");
            return;
        }
        System.out.println("please enter the name of the song: ");
        name = y.nextLine().strip();
        System.out.println("please enter the name of the artist: ");
        artist = y.nextLine().strip();
        System.out.println("please enter the duration of the song in seconds: ");
        duration = y.nextInt();

        for(int i=0; i < numAlbum; i++){
            if(album[i].getName().equalsIgnoreCase(album_name)){
                if(album[i].checkSongExists(name, artist, duration)){
                    al = true;
                    System.out.println(album[i].deleteSong(name, artist, duration));
                }
            }
        }
        //if the album, song name and artist name matched the stored information al was set to true so this error message wouldn't be displayed
        if (!al) System.out.println("that song does not exist so it cant be deleted. ");

    }
    //lists all the songs with the same name and is also used to display to the user all the songs with the same name, called by newSong
    //this method is used twice, for two different purposes
    private String listOneSong(Scanner x){
        String list = "";
        System.out.println("Please enter the name of the song: ");
        x.nextLine();
        String name = x.nextLine().strip();
        for(int i=0; i < numAlbum; i++){
            if(!album[i].list2(name).equalsIgnoreCase("")){
                list += "There is already song(s) with this name already its details are below \n Album name: " +album[i].getName()+ album[i].list2(name);
            }
        }
        return list;
    }

    //checks if the album name entered by the user exists. returns a boolean
    private boolean checkAlbumExist(String x) { //this method checks if the album exists by checking the inputted album name with the stored album name
        for(int i=0; i < numAlbum; i++){
            if(album[i].getName().equalsIgnoreCase(x)){
                return false;
            }
        }
        return true;
    }

    // this method checks if there are any songs within any of the albums.
    private boolean checkSongInAll() {
        boolean u = false, v = false, k = false;
        if (album[0] != null) {
            u = album[0].checkAllSong(); //calls the method checkAllSong
        }
        if (album[1] != null) {
            v = album[1].checkAllSong();
        }
        if (album[2] != null) {
            k = album[2].checkAllSong();
        }
        if (album[3] != null) {
            k = album[3].checkAllSong();
        }
        if (!u && !v && !k) { //if checkAllSong is false for every album then the following error message is displayed
            System.out.print("there are no songs within any of the albums so what you want cannot be displayed");
            return true;
        }
        return false;
    }

    //this is the method that reads from the file
    public void ReadFile(Scanner scan) {
        File info = new File(FILE_NAME);
        Scanner reader;
        String albumName = "", name="", artist = "", genre= "", duration="";

        {
            try {
                reader = new Scanner(info);
                        while(reader.hasNextLine()) { //checks if the txt file has next line
                                String line = reader.nextLine(); //reads the next line and passes the value to line
                                if(line.contains("Album")){ //if the line contains the string "Album"
                                    albumName = line.substring(6); //that line is then passed to albumName but the line contained Album so the substring(6) skips Album by only assigning after the 6th bite
                                    makeAlbum(scan, albumName); //calls the function makeAlbum while passing the scanner and album name
                                }
                                if(line.contains("Name")){
                                    name = line.substring(5);

                                }
                                if(line.contains("Artist")){
                                    artist = line.substring(7);
                                }
                                if(line.contains("Duration")){
                                    duration = line.substring(9);
                                }
                                if(line.contains("Genre")){
                                    genre = line.substring(6);
                                    newSong(scan, albumName, name, artist, duration, genre);
                                }
                            }
                        file = false;
            } catch (FileNotFoundException e) { //catches the file not found exception and prints the error message
                System.out.println("there was an error with the file");
                file = false;
            }
        }
    }
    //sorts the albums into alphabetical order
    private void sortingModel(){
        Album temp;
        for(int count = 0; count < 5; count++){
            for (int j = 0; j < numAlbum - 1; j++) {
                if (album[j].getName().compareToIgnoreCase(album[j + 1].getName()) > 0) {
                    temp = album[j];
                    album[j] = album[j + 1];
                    album[j + 1] = temp;
                }
            }
        }
    }
}

