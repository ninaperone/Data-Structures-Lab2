// CIS2168 Data Structures, 003, Nina Perone, tul44843@temple.edu
// Assign2, ManageVideoGame class
// Description: contains main method and methods for each user choice

package assign2_template;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class ManageVideoGames {

    public static void main(String[] args) {
        
        //2.2.2 Application Class - ManageVideoGames
                
        //create an empty list of VideoGames
    	List<VideoGame> games = new LinkedList<>();
    	
    	
    	boolean loop = true;
    	System.out.println("**** Welcome to Video Game Management Tool! ****");
      
        while(loop) {
	    	//1. display menu
	    	displayMenu();
	    	
	        //2. get user choice
	    	int selection = getUserChoice();
	    	
	        //3. take action based on user choice 
	    	if(selection == 1) {
	    		games = addNewGame(games);
	    	}
	    	else if(selection == 2) {
	    		games = removeGame(games);
	    	}
	    	else if(selection == 3) {
	    		for(int i = 0; i < games.size(); i++) {
	    			System.out.println(games.get(i));
	    		}
	    	}
	    	else if(selection == 4) {
	    		System.out.println(latestDate(games));
	    	}
	    	else if(selection == 5) {
	    		games = addNewGameAlph(games);
	    		System.out.println(games);
	    	}
	    	else {
	    		break;
	    	}
    	
        //4. loop through steps 1, 2, 3 above until user quits
        }
        System.out.println("\nGoodbye!");

    }

    
    //method to display menu
    public static void displayMenu() {
    	System.out.println();
    	System.out.println("-----Menu----");
    	System.out.println("1. Add a new game");
    	System.out.println("2. Remove an existing game");
    	System.out.println("3. Display the games in the order they were inserted");
    	System.out.println("4. Find games with latest release");
    	System.out.println("5. Add a new game in the alphabetical order of games");
    	System.out.println("6. Exit");
    	System.out.println();
          
        
    }    
    
    //method to get user choice 
    public static int getUserChoice() { 
    	Scanner scanner = new Scanner(System.in);
    	int selection = 0;
    	while(selection < 1 || selection > 6) {
    		System.out.print("Enter a number to make your selection: ");
    		selection = scanner.nextInt();
    	}
    	System.out.println();
    	
        return selection;
    }    
    
    
    //method to get user input, create and return a video game
    public static VideoGame getNewGame() {  
    	Scanner scanner = new Scanner(System.in);
    	System.out.print("Enter the game title: ");
    	String title = scanner.nextLine();
    	System.out.print("Enter the lead developer: ");
    	String developer = scanner.nextLine();
    	System.out.print("Enter the number of platforms: ");
    	int numPlat = scanner.nextInt();
    	scanner.nextLine();
    	String[] platforms = new String[numPlat];
    	for(int i = 0; i < numPlat; i++) {
    		System.out.print("Enter the platform: ");
    		String newPlat = scanner.nextLine();
    		platforms[i] = newPlat;
    	}
    	System.out.print("Enter release month #: ");
    	int month = scanner.nextInt();
    	System.out.print("Enter release day: ");
    	int day = scanner.nextInt();
    	System.out.print("Enter release year: ");
    	int year = scanner.nextInt();
    	LocalDate gameDate = LocalDate.of(year, month, day);
    	
    	VideoGame newGame = new VideoGame(title, developer, platforms, gameDate);
    	
        return newGame;
    }     
    
    //method to add a video game without maintaining sorted order
    public static List<VideoGame> addNewGame(List<VideoGame> listGames) {
    	VideoGame newGame = getNewGame();
    	listGames.add(newGame);
    	return listGames;
    	
    }

    //method to remove a game based on user input
    public static List<VideoGame> removeGame(List<VideoGame> listGames) {
    	Scanner scanner = new Scanner(System.in);
    	System.out.print("Enter the game title: ");
    	String title = scanner.nextLine();
    	VideoGame game = new VideoGame(title, null, null, null);

    	for(int i = 0; i < listGames.size(); i++) {
    		if(listGames.get(i).equals(game)) {
    			listGames.remove(listGames.get(i));
    			break;
    		}
    	}
    	
    	return listGames;
    	
    }

    //method to find the game with latest release date
    public static VideoGame latestDate(List<VideoGame> listGames) {
    	VideoGame newest = listGames.get(0);
    	
    	for(int i = 1; i < listGames.size(); i++) {
    		
    		if(listGames.get(i).getReleaseDate().isAfter(newest.getReleaseDate())) {
    			newest = listGames.get(i);
    		}
    	}

    	return newest;
    	
    }

    
    
    //OPTIONAL BONUS:
    //  method to add a video game in alphabetical order of game titles
    public static List<VideoGame> addNewGameAlph(List<VideoGame> listGames) {
    	VideoGame newGame = getNewGame();
    	
    	VideoGame firstGame = listGames.get(0);
    	
    	// create new sorted list
    	List<VideoGame> sortedListGames = new LinkedList<>();
    	sortedListGames.add(firstGame);
    	
    	// iterate through old list
    	for(int i = 1; i < listGames.size(); i++) {
    		boolean added = false;
    		
    		// iterate through sorted games to find where to add each old game
    		for(int j = 0; j < i; j++) {
    			if(listGames.get(i).compareTo(sortedListGames.get(j)) < 0 ) {
        			sortedListGames.add(j, listGames.get(i));
        			added = true;
        		}
    			
    		}
    		
    		// add game at end if not in middle of list
    		if(!added) {
    			sortedListGames.add(listGames.get(i));
    		}
    		
    	}
    	
    	// iterate through sorted list to find where to add new
    	boolean added = false;
    	for(int i = 0; i < sortedListGames.size(); i++) {
    		if(newGame.compareTo(sortedListGames.get(i)) < 0) {
    			sortedListGames.add(i, newGame);
    			added = true;
    			break;
    		}
    	}
    	if(!added) {
			sortedListGames.add(newGame);
		}
    	
    	
    	return sortedListGames;
    	
    }
}
