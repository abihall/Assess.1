//Class: SongCollection
//class used to represent SongCollection. has all SongCollection instances and methods
// Abigail Hall
//C3324598

import java.util.*;

public class SongCollection {
    private Album[] album = new Album[4];
    private int choice2;
    private String name1;
    private boolean n=true;

    private void run() {
        System.out.println("\n\nbefore we start, there are a few things to note: ");
        System.out.println("the input is not case sensitive nor does it matter if spaces are put before or after the input");

        while(n) { //this while loop makes sure the messages are constantly asked until the user decides the exit
            Scanner console = new Scanner(System.in);
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
            System.out.println("(9) exit");
            int choice = console.nextInt(); //takes the choice of the user

            switch (choice) { //creates a switch statement for this choice
                case 1: {
                    makeAlbum(console); //calls the method makeAlbum
                    break;
                }
                case 2: {
                    newSong(console); //calls the method newSong
                    break;
                }
                case 3: {
                    if (album[0] == null && album[1] == null && album[2] == null && album[3] == null) { //checks if all the albums are null, if so displays a message
                        System.out.println("there are no albums to list the songs for");
                        break;
                    }
                    listSongs(console);
                    break;
                }
                case 4: {
                    if (album[0] == null && album[1] == null && album[2] == null && album[3] == null) { //checks if all the albums are null, if so displays a message
                        System.out.println("there are no albums to list");
                        break;
                    }
                    listAlbums();
                    break;
                }
                case 5: {
                    if (album[0] == null && album[1] == null && album[2] == null && album[3] == null) { //checks if all the albums are null, if so displays a message
                        System.out.println("there are no songs yet");
                        break;
                    }
                    listUnder(console);
                    break;
                }
                case 6: {
                    if (album[0] == null && album[1] == null && album[2] == null && album[3] == null) { //checks if all the albums are null, if so displays a message
                        System.out.println("there are no songs yet");
                        break;
                    }
                    listGenre(console);
                    break;
                }
                case 7: {
                    if (album[0] == null && album[1] == null && album[2] == null && album[3] == null) { //checks if all the albums are null, if so displays a message
                        System.out.println("there are no albums to delete");
                        break;
                    }
                    deleteAlbum(console);
                    break;
                }
                case 8: {
                    if (album[0] == null && album[1] == null && album[2] == null && album[3] == null){ //checks if all the albums are null, if so displays a message
                        System.out.println("there are no songs to delete");
                        break;
                    }
                    deleteSong(console);
                    break;
                }
                case 9: {
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
    private void makeAlbum(Scanner y) {    //adds an album
        if (album[0] == null || album[1] == null || album[2] == null || album[3] == null) { //having this if statement allows the user to only enter the name of an album if there is avaliable space
            System.out.println("please enter the name of your album:");
            y.nextLine(); //gets rid of the /n
            name1 = y.nextLine().strip(); //strips the white space before and after

            if (checkAlbumExist(name1)) { //makes sure that an album of that name doesnt already exists by calling checkAlbumExist
                if (album[0] == null) { //checks that the album doesn't already exist
                    album[0] = new Album(); //makes a new album called album1 of type Album
                    album[0].setName(name1); //sets the name of album
                    System.out.println("Name: " + album[0].getName());
                } else if (album[1] == null) {
                    album[1] = new Album();
                    album[1].setName(name1);
                    System.out.println("Name: " + album[1].getName());
                } else if (album[2] == null) {
                    album[2] = new Album();
                    album[2].setName(name1);
                    System.out.println("Name: " + album[2].getName());
                } else if (album[3] == null){
                    album[3] = new Album();
                    album[3].setName(name1);
                    System.out.println("Name: " +album[3].getName());
                }
            } else {
                System.out.println("that album already exists");
            }
        } else {
            System.out.println("there is no avaliable space");
        }
    }

    // adds a new song into an album specified by the user. it allows the user to set the name,artist,duration and genre
    private void newSong(Scanner y) { //adds a new song to a album
        boolean valid = false;
        boolean u = false;
        if (album[0] == null && album[1] == null && album[2] == null && album[3] == null) { //this statement checks if none of the albums exist, and if so displays the error message
            System.out.println("there are no albums to add songs into");
            return;
        }
        System.out.println("Please type the name of the album you want to add a song into, the following are the options: ");
        if (album[0] != null) //displays all the album names
            System.out.println(album[0].getName());
        if (album[1] != null)
            System.out.println(album[1].getName());
        if (album[2] != null)
            System.out.println(album[2].getName());
        if(album[3] != null)
            System.out.println(album[3].getName());
        y.nextLine();
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
        if (album[0] != null) {
            if (album[0].getName().equalsIgnoreCase(albumName)) { //checks if the album name inputted is equal to the album name already stored
                valid = true;
                System.out.println(album[0].addSong(name, artist, duration, genre)); //calls the method addSong taking inputs of name, artist, duration and genre
            }
        } if (album[1] != null) {
            if (album[1].getName().equalsIgnoreCase(albumName)) {
                valid = true;
                System.out.println(album[1].addSong(name, artist, duration, genre));
            }
        } if (album[2] != null) {
            if (album[2].getName().equalsIgnoreCase(albumName)) {
                valid = true;
                System.out.println(album[4].addSong(name, artist, duration, genre));
            }
        }if (album[3] != null) {
            if (album[3].getName().equalsIgnoreCase(albumName)) {
                valid = true;
                System.out.println(album[3].addSong(name, artist, duration, genre));
            }
        }
        if (!valid) { //valid is boolean and is initalised to false, if the album name entered is a valid album name then the message below won't be displayed
            System.out.println("you didnt enter a valid album option so this song cant be added");
        }
    }

    //lists all the songs
    private void listSongs(Scanner y) {
        System.out.println("what album would you like to list all the songs for?");
        if (album[0] != null) System.out.println("Press (1) for all the songs in " + album[0].getName());
        if (album[1] != null) System.out.println("Press (2) for all the songs in " + album[1].getName());
        if (album[2] != null) System.out.println("Press (3) for all the songs in " + album[2].getName());
        if (album[3] != null) System.out.println("Press (4) for all the songs in " + album[3].getName());
        choice2 = y.nextInt();
        switch (choice2) { //switch choice of the integer pressed associated to the album names
            case 1: {
                if (album[0] != null) { //first checks if album1 is null so there is no null point exception
                    System.out.println(album[0].list()); //lists the songs in album1 including all the descriptions (duration, artist etc)
                } else System.out.println("that wasn't a valid album so it cannot be listed"); //displays an error message when they ask for the songs from an album that don't exist

                break;
            }
            case 2: {
                if (album[1] != null) {
                    System.out.println(album[1].list());
                } else System.out.println("that wasn't a valid album so it cannot be listed");

                break;
            }
            case 3: {
                if (album[2] != null) {
                    System.out.println(album[2].list());
                } else System.out.println("that wasn't a valid album so it cannot be listed");

                break;
            }
            case 4:{
                if (album[3] != null) {
                    System.out.println(album[3].list());
                } else System.out.println("that wasn't a valid album so it cannot be listed");

                break;
            }

            default:
                System.out.println("that wasn't a valid album so it cannot be listed"); //if they don't enter 1,2 or 3 it displays an error message
        }
    }

    //lists all the albums
    private void listAlbums() {
        System.out.println("the following is a list of all albums and songs");

        if (album[0] != null) {
            System.out.print("Album name: " + album[0].getName());
            System.out.println(album[0].listName());
        }
        if (album[1] != null) {
            System.out.print("\nAlbum name: " + album[1].getName());
            System.out.println(album[1].listName());
        }
        if (album[2] != null) {
            System.out.print("\nAlbum name: " + album[2].getName());
            System.out.println(album[2].listName());
        }
        if (album[3] != null) {
            System.out.print("\nAlbum name: " + album[3].getName());
            System.out.println(album[3].listName());
        }

    }

    //lists all the songs under a certian time that is inputted by the user
    private void listUnder(Scanner y) {
        float under;
        boolean check = checkSongInAll();
        if (check) return;
        System.out.println("what duration must the songs be under in minutes? The minutes should be a whole number or decimal");
        under = y.nextFloat();
        System.out.println("all the songs under this time are: ");
        if (album[0] != null) {
            System.out.print(album[0].underDuration(under));
        }
        if (album[1] != null) {
            System.out.print("\n" + album[1].underDuration(under));
        }
        if (album[2] != null) {
            System.out.print("\n" + album[2].underDuration(under));
        }
        if (album[3] != null) {
            System.out.print("\n" + album[3].underDuration(under));
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
        System.out.println("all the songs of this genre are: ");

        if (album[0] != null) { //first checks if the album1 is null so a nullpointexception cannot occur
            System.out.print(album[0].listGenre(genre));
        }
        if (album[1] != null) {
            System.out.print("\n" + album[1].listGenre(genre));
        }
        if (album[2] != null) {
            System.out.print("\n" + album[2].listGenre(genre));
        }
        if (album[3] != null) {
            System.out.print("\n" + album[3].listGenre(genre));
        }
    }

    //deletes an album
    private void deleteAlbum(Scanner y) {
        String choice;
        boolean u = false;
        System.out.println("please enter the name of the album you would like to delete, the options are the following: ");
        if (album[0] != null || album[1] != null || album[2] != null || album[3] != null) { //checks if there is any albums to list before trying to list them
            if (album[0] != null) System.out.println(album[0].getName());
            if (album[1] != null) System.out.println(album[1].getName());
            if (album[2] != null) System.out.println(album[2].getName());
            if (album[3] != null) System.out.println(album[3].getName());
            y.nextLine();
            choice = y.nextLine().strip();
        } else { //this else statement allows for an error message to be displayed when there are no albums to delete
            System.out.println("there is no albums to list you must make a album before deleting it");
            return;
        }
        if (album[0] != null) {
            if (album[0].getName().equalsIgnoreCase(choice)) { //checks if the album name stored is the same as what the user inputted
                System.out.println(album[0].getName() + " was deleted"); //displays a message sating that the album was deleted
                album[0] = null; //this 'deletes' the album by setting it to null
                u = true; //this sets the boolean u to true which will stop a error message form displaying later.
            }
        }
        if (album[1] != null) {
            if (album[1].getName().equalsIgnoreCase(choice)) {
                System.out.println(album[1].getName() + " was deleted");
                album[1] = null;
                u = true;
            }
        }
        if (album[2] != null) {
            if (album[2].getName().equalsIgnoreCase(choice)) {
                System.out.println(album[2].getName() + " was deleted");
                album[2] = null;
                u = true;
            }
        }
        if (album[3] != null) {
            if (album[3].getName().equalsIgnoreCase(choice)) {
                System.out.println(album[3].getName() + " was deleted");
                album[3] = null;
                u = true;
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
        int n = 0;
        if (album[0] == null) n++; //if an album doesn't exist it incruments n by 1
        if (album[1] == null) n++;
        if (album[2] == null) n++;
        if (album[3] == null) n++;
        System.out.println("the following is a list of all the songs in each album: \n");
        if (album[0] != null) {
            System.out.println("all the songs in the album '" + album[0].getName() + "' are: \n" + album[0].list()); //displays to the user all the album names and the songs within them
            if (!album[0].checkAllSong()) { //boolean false means there are no songs within album1 meaning n is incrumented by 1
                n += 1;
            }
        }
        if (album[1] != null) {
            System.out.println("all the songs in the album '" + album[1].getName() + "' are: \n" + album[1].list());
            if (!album[1].checkAllSong()) {
                n += 1;
            }
        }
        if (album[2] != null) {
            System.out.println("all the songs in album '" + album[2].getName() + "' are:\n " + album[2].list());
            if (!album[2].checkAllSong()) {
                n += 1;
            }
        }
        if (album[3] != null) {
            System.out.println("all the songs in the album '" + album[3].getName() + "' are: \n" + album[3].list());
            if (!album[3].checkAllSong()) {
                n += 1;
            }
        }
        if (n == 4) { //if n was incrumented 3 times the following error message is displayed. If n was incrumented 3 times it means there are no songs within any of the albums or no albums
            System.out.println("\nWhich means there are no songs to delete");
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

        if (album[0] != null) {
            if (album[0].getName().equalsIgnoreCase(album_name)) { //checks if the album name entered matches any of the current album names
                if (album[0].checkSongExists(name, artist, duration)) { //calls the method checkSongExists and passes two strings name and artist
                    al = true;
                    System.out.println(album[0].deleteSong(name, artist, duration)); //calls the function deleteSong
                }
            }
        }
        if (album[1] != null) {
            if (album[1].getName().equalsIgnoreCase(album_name)) {
                if (album[1].checkSongExists(name, artist, duration)) {
                    al = true;
                    System.out.println(album[1].deleteSong(name, artist, duration));
                }
            }
        }
        if (album[2] != null) {
            if (album[2].getName().equalsIgnoreCase(album_name)) {
                if (album[2].checkSongExists(name, artist, duration)) {
                    al = true;
                    System.out.println(album[2].deleteSong(name, artist, duration));
                }
            }
        }
        if (album[3] != null) {
            if (album[3].getName().equalsIgnoreCase(album_name)) {
                if (album[3].checkSongExists(name, artist, duration)) {
                    al = true;
                    System.out.println(album[3].deleteSong(name, artist, duration));
                }
            }
        }
        //if the album, song name and artist name matched the stored information al was set to true so this error message wouldn't be displayed
        if (!al) System.out.println("that song does not exist so it cant be deleted. ");

    }

    //checks if the album name entered by the user exists. returns a boolean
    private boolean checkAlbumExist(String x) { //this method checks if the album exists by checking the inputted album name with the stored album name
        if (album[0] != null) {
            if (album[0].getName().equalsIgnoreCase(x)) {
                return false;
            }
        }
        if (album[1] != null) {
            if (album[1].getName().equalsIgnoreCase(x)) {
                return false;
            }
        }
        if (album[2] != null) {
            if(album[2].getName().equalsIgnoreCase(x)){
                return false;
            }
        }
        if (album[3] != null) {
            if(album[3].getName().equalsIgnoreCase(x)){
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
            System.out.println("there are no songs within any of the albums so what you want cannot be displayed");
            return true;
        }
        return false;
    }
}
