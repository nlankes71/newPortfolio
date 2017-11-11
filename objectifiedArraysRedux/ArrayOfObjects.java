package objectifiedArraysRedux;

import java.util.Scanner;

/**
 * This program allows the user to create a playlist of songs
 * and then listen to that playlist.
 * @author nicolas.lankes
 */
public class ArrayOfObjects {
    
    static int enteredResponse;
    private static Songs[] playlists;
    static boolean continueLoop = true;
    static int responseEntered;
    
    public static void main(String[] args) throws InterruptedException {
        System.out.println("********************");
        System.out.println("Initializing...");
        System.out.println("********************");
        while(continueLoop){
        systemNotification();
        Scanner scan = new Scanner(System.in);
        int userResponse = scan.nextInt();
        responseEntered = userResponse;
        taskSelector();
        } //end while
    } //end method main
    
    public static void systemNotification() throws InterruptedException {
        
        Thread.sleep(1000);
        System.out.println("********************");
        System.out.println("Available options...");
        System.out.println("1. Create Playlist");
        System.out.println("2. Listen to your playlist");
        System.out.println("-1: Exit out of program");
        System.out.println("********************");
        
    }//end method systemNotification
    
    public static void createPlaylist(){
        
        System.out.println("How many songs would you like to have?");
        Scanner scan = new Scanner(System.in);
        int userResponse = scan.nextInt();
        enteredResponse = userResponse;
        Songs[] playlist = new Songs[userResponse];
        playlists = playlist;
        for(int i = 0; i <= (userResponse - 1); i += 1){
            System.out.println("What is the name of song " + (i+=1) + "?");
            Scanner a = new Scanner(System.in);
            String response = a.next();
            Songs songi = new Songs();
            songi.setSongName(response);
            System.out.println("Who is the song by?");
            Scanner b = new Scanner(System.in);
            String secondResponse = b.next();
            songi.setArtistName(secondResponse);
            playlist[i] = songi;
        } //end for
        
    } //end method createPlaylist
    
    public static void listenMusic() throws InterruptedException {
        
        for(int i = 0; i <= (enteredResponse - 1); i += 1){
            Songs accessedSong = playlists[i];
            System.out.println("********************");
            System.out.println("Now playing: " + accessedSong.getSongName() + " by " + accessedSong.getArtistName());
            System.out.println("********************");
            Thread.sleep(2000);
        }
        
    } //end method listenMusic
    
    public static void taskSelector() throws InterruptedException {
        switch (responseEntered){
            case 1:
            {
                createPlaylist();
                break;
            } //end case 1
            case 2:
            {
                listenMusic();
                break;
            } //end case 3
            case -1:
            {
                System.out.println("********************");
                System.out.println("Exiting Program...");
                System.out.println("********************");
                continueLoop = false;
                System.exit(0);
                break;
            } //end case -1
            default:
            {
                break;
            }
        } //end switch
    }
    
}
