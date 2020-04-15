import java.util.*;

public class SongCollection {
    private Album album1=null, album2=null, album3=null;
    private int end1 = 0, choice2;
    private String name1;
    private void run() {
        do {
            Scanner console = new Scanner(System.in);
            System.out.println("(1) create a album");
            System.out.println("(2) enter a new song into a album");
            System.out.println("(3) list of all songs");
            System.out.println("(4) list of all albums");
            System.out.println("(5) list of all songs under a certain time");
            System.out.println("(6) list of all songs from a certain genre");
            System.out.println("(7) delete a album");
            System.out.println("(8) delete a song from a album");
            System.out.println("(9) exit");
            int choice = console.nextInt();

            switch (choice) {
                case 1: {
                   makeAlbum(console);
                    break;
                }
                case 2: {
                    newSong(console);
                    break;
                }
                case 3: {
                    listSongs(console);
                    break;
                }
                case 4: {
                    listAlbums();
                    break;
                }
                case 5: {
                    listUnder(console);
                    break;
                }
                case 6: {
                    listGenre(console);
                    break;
                }
                case 7: {
                    deleteAlbum(console);
                    break;
                }
                case 8: {
                    deleteSong(console);
                    break;
                }
                case 9: {
                    System.out.println("You exited!");
                    return;
                }
                default: {
                    System.out.println("incorrect input, please start again and enter 1,2,3,4,5,6,7,8 or 9.\n"); //default is used if hte user inputs a number that isn't in the switch case
                    break;
                }
            }
            System.out.println("\n do you want to continue editing your albums? (1) yes, (0) no");
            end1 = console.nextInt();
        } while (end1 != 0);

    }

    public static void main(String[] args) {
        SongCollection sg = new SongCollection();
        sg.run();
    }

    public void makeAlbum(Scanner y){
        if(album1==null || album2==null || album3==null){
            System.out.println("please enter the name of your album:");
            y.nextLine();
            name1 = y.nextLine();

            if(!checkAlbumExist(name1)){
                if(album1==null){
                    album1 = new Album();
                    album1.setName(name1);
                    System.out.println("Name: " + album1.getName());
                }
                else if(album2==null){
                    album2 = new Album();
                    album2.setName(name1);
                    System.out.println("Name: " + album2.getName());
                }
                else if(album3==null){
                    album3 = new Album();
                    album3.setName(name1);
                    System.out.println("Name: " + album3.getName());
                }
            }
            else {
                System.out.println("that album already exists");
            }
        }
        else {
            System.out.println("there is no avaliable space");
        }
    } //adds an album; DONE gives error if album already exists, if there is not enough room

    public void newSong(Scanner y){
        if(album1==null && album2==null && album3==null){
            System.out.println("there are no albums to add songs into");
            return;
        }
        System.out.println("what album would you like to add a song into?");
        if(album1!=null)
            System.out.println("Press (1) to add a song to " + album1.getName());
        if(album2!=null)
            System.out.println("Press (2) to add song to " + album2.getName());
        if(album3!=null)
            System.out.println("Press (3) to add song to " + album3.getName());

        choice2 = y.nextInt();
            switch (choice2) {
                case 1: {
                        if (album1 != null) {
                        int n = album1.getNumberSongs();
                        if (n == 4) {
                            System.out.println("you cannot add more than 4 songs, please delete before adding another");
                        } else {
                            album1.addSong(y);
                        }
                    } else{
                        System.out.println("you didnt choose a valid option");
                    }
                    break;
                }
                case 2: {
                    if (album2 != null) {
                        int n = album2.getNumberSongs();
                        if (n == 4) {
                            System.out.println("you cannot add more than 4 songs, please delete before adding another");
                        } else {
                            album2.addSong(y);
                        }
                    } else{
                        System.out.println("you didnt choose a valid option");
                    }
                    break;
                }
                case 3: {
                    if (album3 != null) {
                        int n = album3.getNumberSongs();
                        if (n == 4) {
                            System.out.println("you cannot add more than 4 songs, please delete before adding another");
                        } else {
                            album3.addSong(y);
                        }
                    } else{
                        System.out.println("you didnt choose a valid option");
                    }
                    break;
                }
                default: {
                    System.out.println("you didn't choose a valid option");
                    break;
                }
            }
    } //adds a new song to a album; DONE doesnt add a song if the album doesnt exist or is full, exceed time limit, if song already exists

    public void listSongs(Scanner y){
        boolean u;
      //  if(album1==null && album2==null && album3==null){
      //      System.out.println("there are no existing albums so the songs cannot be listed");
     //       return;
     //   }
        System.out.println("what album would you like to list all the songs for?");
        if(album1!=null) System.out.println("Press (1) for all the songs in " + album1.getName());
        if(album2!=null) System.out.println("Press (2) for all the songs in " + album2.getName());
        if(album3!=null) System.out.println("Press (3) for all the songs in " + album3.getName());
        choice2 = y.nextInt();
        switch (choice2) {
            case 1: {
                if (album1 != null) {
                    u = album1.checkSong();
                    if(!u){
                        System.out.println("there is no songs within this album so the songs cannot be listed");
                    }
                    System.out.println(album1.list());
                }
                else System.out.println("that wasn't a valid album so it cannot be listed");

                break;
            }
            case 2: {
                if (album2 != null) {
                    u = album2.checkSong();
                    if(!u){
                        System.out.println("there is no songs within this album so the songs cannot be listed");
                    }
                    System.out.println(album2.list());
                }
                else System.out.println("that wasn't a valid album so it cannot be listed");

                break;
            }
            case 3: {
                if (album3 != null){
                    u = album3.checkSong();
                    if(!u){
                        System.out.println("there is no songs within this album so the songs cannot be listed");
                    }
                    System.out.println(album3.list());
                }
                else System.out.println("that wasn't a valid album so it cannot be listed");

                break;
            }
            default: System.out.println("that wasn't a valid album so it cannot be listed");
        }
    } //lists all the songs

    public void listAlbums(){
        System.out.println("the following is a list of all albums and songs");
        if(album1==null && album2==null && album3==null){
            System.out.println("there are no albums to list");
        }
        if(album1!=null) {
            System.out.println("Album name: " + album1.getName());
            System.out.println(album1.list());
        }
        if(album2!=null){
            System.out.println("Album name: " + album2.getName());
            System.out.println(album1.list());
        }
        if(album3!=null){
            System.out.println("Album name: " + album3.getName());
            System.out.println(album1.list());
        }

    } //lists all the albums

    public void listUnder(Scanner y){
            int under;
            System.out.println("what duration must the songs be under in whole minutes?");
            under = y.nextInt();
            System.out.println("all the songs under this time are: ");
            if(album1 != null){
                    System.out.print(album1.underDuration(under));
            }
            if(album2 != null){
                    System.out.print("\n" +album2.underDuration(under));
            }
            if(album3 != null){
                    System.out.print("\n" +album3.underDuration(under));
            }

    } //lists all the songs under a certian time that is inputted by the user; TO DO dont list if albums/songs is zero

    public void listGenre(Scanner y){
        String genre;
        boolean u = false;
        System.out.println("please enter the genre you would like to list all the songs for ");
        genre = y.next();
        while(!u){
            if(genre.equalsIgnoreCase("rock")|| genre.equalsIgnoreCase("pop") || genre.equalsIgnoreCase("hip-hop") || genre.equalsIgnoreCase("bossa nova")){
                u = true;
            }
            else{
                System.out.println("genre can only be rock, pop, hip-hop or bossa nova, please enter the genre of the song:");
                genre = y.next();
            }
        }
        System.out.println("all the songs of this genre are: ");
        if(album1==null && album2 == null && album3 == null){
            System.out.println("there are no albums so the songs of the genre cannot be displayed ");
        }
        if(album1 != null){
            System.out.print(album1.listGenre(genre));
        }
        if(album2 != null){
            System.out.print("\n" +album2.listGenre(genre));
        }
        if(album3 != null){
            System.out.print("\n" +album3.listGenre(genre));
        }
        if(album3!=null && album2!=null && album1!= null && album1.listGenre(genre).equals("") && album2.listGenre(genre).equals("") && album3.listGenre(genre).equals("")){
            System.out.println("there are no songs to display within any of the albums");
        }
    } //lists all the songs from a specific genre specified by the user; TO DO dont list if albums/songs is zero

    public void deleteAlbum(Scanner y){
        String choice="";
        boolean u = false;
            System.out.println("please enter the name of the album you would like to delete, the options are the following: ");
            if(album1!=null || album2!=null || album3!=null){
                if(album1!=null) System.out.println(album1.getName());
                if(album2!=null) System.out.println(album2.getName());
                if(album3!=null) System.out.println(album3.getName());

                choice = y.next();
            } else{
                System.out.println("there is no albums to list you must make a album before deleting it");
                u = true;
            }
        if(album1!=null){
            if(album1.getName().equals(choice)){
                System.out.println(album1.getName()+ " was deleted");
                album1=null;
                u = true;
            }
        }
        if(album2!=null){
            if(album2.getName().equals(choice)){
                System.out.println(album2.getName()+ " was deleted");
                album2 = null;
                u = true;
            }
        }
        if(album3!=null){
            if(album3.getName().equals(choice)){
                System.out.println(album3.getName()+ " was deleted");
                album3 = null;
                u = true;
            }
        }
        if(!u) {
            System.out.println("that album name doesnt exist");
        }

    } //deletes an album; DONE delete an album that does not exist

    public void deleteSong(Scanner y){
        String choice;
        System.out.println("please enter the song name that you would like to delete, the options are: ");
        if (album1 != null) System.out.println("all the songs in"+album1.getName()+ " are" +album1.list());
        if (album2 != null) System.out.println("all the songs in" +album2.getName()+ " are" +album2.list());
        if (album3 != null) System.out.println("all the songs in" +album3.getName()+ " are" +album3.list());
        else System.out.println("there are no songs to delete");
        choice = y.next();

        if (album1 != null) {
            if (album1.checkSongExists(choice)) {
                album1.deleteSong(choice);
            }
        }
        if (album2 != null) {
            if(album2.checkSongExists(choice)){
                album2.deleteSong(choice);
            }
        }
        if (album3 != null) {
            if(album3.checkSongExists(choice)){
                album3.deleteSong(choice);
            }
        }
        } //deletes a song; DONE delete a song that does not exist

    public Boolean checkAlbumExist(String x){
        if(album1 != null){
            if(album1.getName().equals(x)){
                return true;
            }
        }
        if(album2 != null){
            if(album2.getName().equals(x)){
                return true;
            }
        }
        if(album3 != null){
            if(album3.getName().equals(x)) {
                return true;
            }
        }
        return false;
    }
}