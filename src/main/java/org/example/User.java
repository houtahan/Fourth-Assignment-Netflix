package org.example;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import static org.example.NetflixService.getTvShows;
import static org.example.NetflixService.tvShows;

class User {
    /*
    * The user should contain username password.
    * The user should contain an ArrayList of favorite shows and watch history.
    * FUNCTION: the user should have a function to watch a show and add it to watch history.
    *  *** NOTE: All search functions in user are for searching in favorite shows ***
    */
    private String username;
    private String password;
    ArrayList<TVShow> faveShows = new ArrayList();
    ArrayList<TVShow> watchHistory = new ArrayList();
    public User(String username, String password, ArrayList<String> faveShows, ArrayList<String> watchHistory){
        this.username = username;
        this.password = password;
    }

    public String getUsername(){
        return username;
    }
    //
    public void setUsername(){
        this.username = username;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(){
        this.password = password;
    }
    public ArrayList<TVShow> getFaveShows(){
        return faveShows;
    }
    public ArrayList<TVShow> setFaveShows(){
        this.faveShows = faveShows;
        return faveShows;
    }
    public ArrayList<TVShow> getWatchHistory(){
        return watchHistory;
    }
    public ArrayList<TVShow> setWatchHistory(){
        this.watchHistory = watchHistory;
        return watchHistory;
    }
    public ArrayList<TVShow> searchByTitle(String title, User user) {
        // Implement search by title in favorite shows logic here
        ArrayList<TVShow> foundTVShow = new ArrayList();
        Scanner sc = new Scanner(System.in);
        for (TVShow tvShow : this.faveShows){
            if (tvShow.getTitle().equals(title)){
                System.out.println("This show is in your favorites list");
                System.out.println("Would you like to watch this show again?");
                System.out.println("Press 1 for YES and 2 for NO");
                int choice;
                choice = sc.nextInt();
                if (choice == 1){
                    System.out.println("Enjoy!");
                }
                if (choice == 2){
                    Main.userMenu(user.getUsername(), user.getPassword());
                }
                if (choice > 3){
                    System.out.println("This option does not exist!");
                }
            }
        }
        return null;
    }
    public ArrayList<TVShow> searchByGenre(String genre, User user) {
        // Implement search by genre in favorite shows  logic here
        ArrayList<TVShow> foundTVShow = new ArrayList();
        for (TVShow tvShow : faveShows){
            if (tvShow.getGenre().equals(genre)){
                foundTVShow.add(tvShow);
            }
        }
        return foundTVShow;
    }
    public ArrayList<TVShow> searchByReleaseYear(int year, User user) {
        // Implement search by release year in favorite shows logic here
        ArrayList<TVShow> foundTVShow = new ArrayList();
        for (TVShow tvShow : this.faveShows){
            if (tvShow.getReleaseYear() == year){
                foundTVShow.add(tvShow);
            }
        }
        return foundTVShow;
    }
    public void addToFavorites(TVShow show, User user) {
        // Implement add to favorites logic here
        this.faveShows.add(show);
    }
    public void addToWatchHistory(TVShow show, User user){
        // Implement add to watch history logic here
        this.watchHistory.add(show);
    }
    public ArrayList<TVShow> viewFavorites() {
        // Implement view favorites logic here
        return this.faveShows;
    }
    public ArrayList<TVShow> viewWatchHistory() {
        return this.watchHistory;
    }
    // The next method randomly recommends a TV show
    public static TVShow getRecommendations(User user) {
        // Implement get recommendations logic here
        Scanner sc = new Scanner(System.in);
        for (TVShow tvshows : getTvShows()) {
            Random rand = new Random();
            TVShow randomShow = getTvShows().get(rand.nextInt(tvShows.size()));
            System.out.print(randomShow);
            System.out.println("Would you like to watch this show?");
            System.out.println("Press 1 for Yes and 2 for NO");
            int choice = sc.nextInt();
            if (choice == 1){
                System.out.println("Enjoy!");
            }
            if (choice == 2){
                Main.userMenu(user.getUsername(), user.getPassword());
            }
            if (choice > 2){
                System.out.println("This option does not exist!");
            }
        }
        return null;
    }
}
