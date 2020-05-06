import java.util.*;

public class SongCollection {
    private Album album1 = null, album2 = null, album3 = null;
    private int choice2;
    private String name1;
    private boolean n=true;

    private void run() {
        System.out.println("before we start, there are a few things to note: ");
        System.out.println("the input is not case sensitive nor does it matter if spaces are put before or after the input");
        while(n) {
            Scanner console = new Scanner(System.in);
            System.out.println("\nthe following is a list of all the tasks you can complete, please type the corrosponding number to the take you would like to complete");
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
                    if (album1 == null && album2 == null && album3 == null) {
                        System.out.println("there are no albums to list the songs for");
                        break;
                    }
                    listSongs(console);
                    break;
                }
                case 4: {
                    if (album1 == null && album2 == null && album3 == null) {
                        System.out.println("there are no albums to list");
                        break;
                    }
                    listAlbums();
                    break;
                }
                case 5: {
                    if (album1 == null && album2 == null && album3 == null) {
                        System.out.println("there are no songs yet");
                        break;
                    }
                    listUnder(console);
                    break;
                }
                case 6: {
                    if (album1 == null && album2 == null && album3 == null) {
                        System.out.println("there are no songs yet");
                        break;
                    }
                    listGenre(console);
                    break;
                }
                case 7: {
                    if (album1 == null && album2 == null && album3 == null) {
                        System.out.println("there are no albums to delete");
                        break;
                    }
                    deleteAlbum(console);
                    break;
                }
                case 8: {
                    if (album1 == null && album2 == null && album3 == null) {
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
        SongCollection sg = new SongCollection();
        sg.run();
    }

    private void makeAlbum(Scanner y) {
        if (album1 == null || album2 == null || album3 == null) {
            System.out.println("please enter the name of your album:");
            y.nextLine();
            name1 = y.nextLine().strip();

            if (!checkAlbumExist(name1)) {
                if (album1 == null) {
                    album1 = new Album();
                    album1.setName(name1);
                    System.out.println("Name: " + album1.getName());
                } else if (album2 == null) {
                    album2 = new Album();
                    album2.setName(name1);
                    System.out.println("Name: " + album2.getName());
                } else if (album3 == null) {
                    album3 = new Album();
                    album3.setName(name1);
                    System.out.println("Name: " + album3.getName());
                }
            } else {
                System.out.println("that album already exists");
            }
        } else {
            System.out.println("there is no avaliable space");
        }
    }
    //adds an album; DONE gives error if album already exists, if there is not enough room

    private void newSong(Scanner y) {
        boolean valid = false;
        boolean u = false;
        if (album1 == null && album2 == null && album3 == null) {
            System.out.println("there are no albums to add songs into");
            return;
        }
        System.out.println("Please type the name of the album you want to add a song into, the following are the options: ");
        if (album1 != null)
            System.out.println(album1.getName());
        if (album2 != null)
            System.out.println(album2.getName());
        if (album3 != null)
            System.out.println(album3.getName());

        y.nextLine();
        String albumName = y.nextLine().strip();
        System.out.println("please enter the name of your song:");
        String name = y.nextLine().strip();
        System.out.println("please enter the name of your artist:");
        String artist = y.nextLine().strip();
        System.out.println("please enter the duration of the song in seconds:");
        int duration = y.nextInt();
        System.out.println("please enter the genre of the song:");
        y.nextLine();
        String genre = y.nextLine().strip();
        while(!u){
            if(genre.equalsIgnoreCase("rock")|| genre.equalsIgnoreCase("pop") || genre.equalsIgnoreCase("hip-hop") || genre.equalsIgnoreCase("bossa nova")) u = true;
            else{
                System.out.println("genre can only be rock, pop, hip-hop or bossa nova, please enter the genre of the song:");
                genre = y.nextLine();
            }
        }
        if (album1 != null) {
            if (album1.getName().equalsIgnoreCase(albumName)) {
                valid = true;
                System.out.println(album1.addSong(name, artist, duration, genre));
            }
        } if (album2 != null) {
            if (album2.getName().equalsIgnoreCase(albumName)) {
                valid = true;
                System.out.println(album2.addSong(name, artist, duration, genre));
            }
        } if (album3 != null) {
            if (album3.getName().equalsIgnoreCase(albumName)) {
                valid = true;
                System.out.println(album3.addSong(name, artist, duration, genre));
            }
        }
        if (!valid) {
            System.out.println("you didnt enter a valid album option so this song cant be added");
        }
    }
    //adds a new song to a album; DONE doesnt add a song if the album doesnt exist or is full, exceed time limit, if song already exists

    private void listSongs(Scanner y) {
        if (album1 == null && album2 == null && album3 == null) {
            System.out.println("there are no existing albums so the songs cannot be listed");
            return;
        }
        System.out.println("what album would you like to list all the songs for?");
        if (album1 != null) System.out.println("Press (1) for all the songs in " + album1.getName());
        if (album2 != null) System.out.println("Press (2) for all the songs in " + album2.getName());
        if (album3 != null) System.out.println("Press (3) for all the songs in " + album3.getName());
        choice2 = y.nextInt();
        switch (choice2) {
            case 1: {
                if (album1 != null) {
                    System.out.println(album1.list());
                } else System.out.println("that wasn't a valid album so it cannot be listed");

                break;
            }
            case 2: {
                if (album2 != null) {
                    System.out.println(album2.list());
                } else System.out.println("that wasn't a valid album so it cannot be listed");

                break;
            }
            case 3: {
                if (album3 != null) {
                    System.out.println(album3.list());
                } else System.out.println("that wasn't a valid album so it cannot be listed");

                break;
            }
            default:
                System.out.println("that wasn't a valid album so it cannot be listed");
        }
    }
    //lists all the songs

    private void listAlbums() {
        System.out.println("the following is a list of all albums and songs");

        if (album1 != null) {
            System.out.print("Album name: " + album1.getName());
            System.out.println(album1.listName());
        }
        if (album2 != null) {
            System.out.print("\nAlbum name: " + album2.getName());
            System.out.println(album2.listName());
        }
        if (album3 != null) {
            System.out.print("\nAlbum name: " + album3.getName());
            System.out.println(album3.listName());
        }

    }
    //lists all the albums

    private void listUnder(Scanner y) {
        float under;
        boolean check = checkSongInAll();
        if (check) return;
        System.out.println("what duration must the songs be under in seconds?");
        under = y.nextFloat();
        System.out.println("all the songs under this time are: ");
        if (album1 != null) {
            System.out.print(album1.underDuration(under));
        }
        if (album2 != null) {
            System.out.print("\n" + album2.underDuration(under));
        }
        if (album3 != null) {
            System.out.print("\n" + album3.underDuration(under));
        }

    }
    //lists all the songs under a certian time that is inputted by the user; TO DO dont list if albums/songs is zero

    private void listGenre(Scanner y) {
        String genre;
        boolean u = false;
        boolean check = checkSongInAll();
        if (check) return;
        System.out.println("please enter the genre you would like to list all the songs for ");
        y.nextLine();
        genre = y.nextLine();
        while (!u) {
            if (genre.equalsIgnoreCase("rock") || genre.equalsIgnoreCase("pop") || genre.equalsIgnoreCase("hip-hop") || genre.equalsIgnoreCase("bossa nova")) {
                u = true;
            } else {
                System.out.println("genre can only be rock, pop, hip-hop or bossa nova, please enter the genre of the song:");
                genre = y.nextLine();
            }
        }
        System.out.println("all the songs of this genre are: ");

        if (album1 != null) {
            System.out.print(album1.listGenre(genre));
        }
        if (album2 != null) {
            System.out.print("\n" + album2.listGenre(genre));
        }
        if (album3 != null) {
            System.out.print("\n" + album3.listGenre(genre));
        }
    }
    //lists all the songs from a specific genre specified by the user; TO DO dont list if albums/songs is zero

    private void deleteAlbum(Scanner y) {
        String choice = "";
        boolean u = false;
        System.out.println("please enter the name of the album you would like to delete, the options are the following: ");
        if (album1 != null || album2 != null || album3 != null) {
            if (album1 != null) System.out.println(album1.getName());
            if (album2 != null) System.out.println(album2.getName());
            if (album3 != null) System.out.println(album3.getName());
            y.nextLine();
            choice = y.nextLine().strip();
        } else {
            System.out.println("there is no albums to list you must make a album before deleting it");
            u = true;
        }
        if (album1 != null) {
            if (album1.getName().equalsIgnoreCase(choice)) {
                System.out.println(album1.getName() + " was deleted");
                album1 = null;
                u = true;
            }
        }
        if (album2 != null) {
            if (album2.getName().equalsIgnoreCase(choice)) {
                System.out.println(album2.getName() + " was deleted");
                album2 = null;
                u = true;
            }
        }
        if (album3 != null) {
            if (album3.getName().equalsIgnoreCase(choice)) {
                System.out.println(album3.getName() + " was deleted");
                album3 = null;
                u = true;
            }
        }
        if (!u) {
            System.out.println("that album name doesnt exist");
        }

    }
    //deletes an album; DONE delete an album that does not exist

    private void deleteSong(Scanner y) {
        String choice;
        String artist;
        boolean al = false;
        int n = 0;
        if (album1 == null) n++;
        if (album2 == null) n++;
        if (album3 == null) n++;
        System.out.println("the following is a list of all the songs in each album: \n");
        if (album1 != null) {
            System.out.println("all the songs in the album '" + album1.getName() + "' are: \n" + album1.list());
            if (!album1.checkAllSong()) {
                n += 1;
            }
        }
        if (album2 != null) {
            System.out.println("all the songs in the album '" + album2.getName() + "' are: \n" + album2.list());
            if (!album2.checkAllSong()) {
                n += 1;
            }
        }
        if (album3 != null) {
            System.out.println("all the songs in album '" + album3.getName() + "' are:\n " + album3.list());
            if (!album3.checkAllSong()) {
                n += 1;
            }
        }
        if (n == 3) {
            System.out.println("\nWhich means there are no songs to delete");
            return;
        }
        System.out.println("\nplease enter the name of the album that has the song you want to delete");
        String album_name = y.next();
        if (!checkAlbumExist(album_name)) {
            System.out.println("that album doesnt exist so a song cannot be deleted from it");
            return;
        }
        System.out.println("please enter the name of the song: ");
        choice = y.next();
        System.out.println("please enter the name of the artist: ");
        artist = y.next();

        if (album1 != null) {
            if (album1.getName().equalsIgnoreCase(album_name)) {
                if (album1.checkSongExists(choice, artist)) {
                    al = true;
                    System.out.println(album1.deleteSong(choice, artist));
                }
            }
        }
        if (album2 != null) {
            if (album2.getName().equalsIgnoreCase(album_name)) {
                if (album2.checkSongExists(choice, artist)) {
                    al = true;
                    System.out.println(album2.deleteSong(choice, artist));
                }
            }
        }
        if (album3 != null) {
            if (album3.getName().equalsIgnoreCase(album_name)) {
                if (album3.checkSongExists(choice, artist)) {
                    al = true;
                    System.out.println(album3.deleteSong(choice, artist));
                }
            }
        }
        if (!al) System.out.println("that song does not exist so it cant be deleted. ");

    }
    //deletes a song; DONE delete a song that does not exist

    private Boolean checkAlbumExist(String x) {
        if (album1 != null) {
            if (album1.getName().equalsIgnoreCase(x)) {
                return true;
            }
        }
        if (album2 != null) {
            if (album2.getName().equalsIgnoreCase(x)) {
                return true;
            }
        }
        if (album3 != null) {
            if (album3.getName().equalsIgnoreCase(x)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkSongInAll() {
        boolean u = false, v = false, k = false;
        if (album1 != null) {
            u = album1.checkAllSong();
        }
        if (album2 != null) {
            v = album2.checkAllSong();
        }
        if (album3 != null) {
            k = album3.checkAllSong();
        }
        if (!u && !v && !k) {
            System.out.println("there are no songs within any of the albums so what you want cannot be displayed");
            return true;
        }
        return false;
    }
}