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
                    MakeAlbum(console);
                    break;
                }
                case 2: {
                    NewSong(console);
                    break;
                }
                case 3: {
                    ListSongs(console);
                    break;
                }
                case 4: {
                    ListAlbums(console);
                    break;
                }
                case 5: {
                    ListUnder(console);
                    break;
                }
                case 6: {
                    ListGenre(console);
                    break;
                }
                case 7: {
                    DeleteAlbum(console);
                    break;
                }
                case 8: {
                    DeleteSong(console);
                    break;
                }
                case 9: {
                    System.out.println("You exited!");
                    return;
                }
                default: {
                    System.out.println("incorrect input, please start again and enter 1,2,3,4,5 or 6.\n"); //default is used if hte user inputs a number that isn't in the switch case
                    break;
                }
            }
            System.out.println("do you want to continue editing your albums? (1) yes, (0) no");
            end1 = console.nextInt();
        } while (end1 != 0);

    }

    public static void main(String[] args) {
        SongCollection sg = new SongCollection();
        sg.run();
    }

    public void MakeAlbum(Scanner y){
        if(album1==null || album2==null || album3==null){
        System.out.println("please enter the name of your album:");
        name1 = y.next();
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
        else{
            System.out.println("there is no avaliable space");
        }
    }

    public void NewSong(Scanner y){
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
    }

    public void ListSongs(Scanner y){
        System.out.println("what album would you like to list all the songs for?");
        if(album1!=null)
            System.out.println("Press (1) for all the songs in " + album1.getName());
        if(album2!=null)
            System.out.println("Press (2) for all the songs in " + album2.getName());
        if(album3!=null)
            System.out.println("Press (3) for all the songs in " + album3.getName());

        choice2 = y.nextInt();
        switch (choice2) {
            case 1: {
                if (album1 != null) {
                    System.out.println(album1.list());
                }
            }
            case 2: {
                if (album2 != null) {
                    System.out.println(album2.list());
                }
            }
            case 3: {
                if (album3 != null){
                    System.out.println(album3.list());
                }
            }
            default: System.out.println("that wasn't a valid album so it cannot be listed");
        }
    }

    public void ListAlbums(Scanner y){
        System.out.println("the following is a list of all albums and songs");
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

    }

    public void ListUnder(Scanner y){
            int under;
            System.out.println("what duration must the songs be under in whole minutes?");
            under = y.nextInt();
            System.out.println("all the songs under this time are: ");
            System.out.println(album1.underDuration(under)+ "" +album2.underDuration(under)+ "" +album3.underDuration(under));


    }

    public void ListGenre(Scanner y){

    }

    public void DeleteAlbum(Scanner y){

    }

    public void DeleteSong(Scanner y){

    }
}