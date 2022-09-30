// CIS2168 Data Structures, 003, Nina Perone, tul44843@temple.edu
// Assign2, VideoGame class
// Description: creates videoGame objects, contains getters, setters, instance variables, 
// toString, compareTo, and equals methods

package assign2_template;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class VideoGame implements Comparable<VideoGame> {

    //2.2.1 Entity Class - VideoGame
    
    private static final int DEFAULT_NUMBER_OF_PLATFORMS = 5;    

    //data fields
    private String title;
    private String developer;     //lead developer 
    private String platforms[];
    private LocalDate releaseDate;

    
    // toString to print all variables of video game object
    @Override
    public String toString() {
 
    	DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("M/d/yyyy");
        
        return "Title: " + title + ", Developer: " + developer + ", Platforms: " + Arrays.toString(platforms) + 
        		", Release Date: " + dateFormatter.format(releaseDate);
    }

    
    // comparing two VideoGame objects based only on title
    @Override
    public boolean equals(Object otherObject) {
    	
    	if(title.equals(((VideoGame) otherObject).getTitle())) {
    		
    		return true;
    	}
        
        return false;
    }  
    
    
    //******The following code don't need to be changed.*****//
    
    //You don't need to change this method.
    //This method is used in addVideoGameIn.
 // returns 0 is names the same, positive integer if it follows other name, negative integer if proceeds other name
    @Override 
    public int compareTo(VideoGame other) {
        return this.title.compareTo(other.title);
    }   
    
    //no-argument constructor
    public VideoGame() {
        platforms = new String[DEFAULT_NUMBER_OF_PLATFORMS];
    }    
    
    //constructor taking in values for all data fields
    public VideoGame(String title, String developer, String[] platforms, LocalDate releaseDate) {
        this.title = title;
        this.developer = developer;
        this.platforms = platforms;
        this.releaseDate = releaseDate;
    }

    //getters
    public String getTitle() {
        return title;
    }

    public String getDeveloper() {
        return developer;
    }

    public String[] getPlatforms() {
        return platforms;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    //setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public void setPlatforms(String[] platforms) {
        this.platforms = platforms;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }    
}
