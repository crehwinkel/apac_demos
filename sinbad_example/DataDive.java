// Jar file needs to be added to classpath
import core.data.*;

public class DataDive 
{
    // Found link by Googling world football json data
    // https://github.com/lsv/fifa-worldcup-2018
    // public static String url = "https://raw.githubusercontent.com/lsv/fifa-worldcup-2018/master/data.json";
    // Found Volcano link by Googling free volcano json data
    public static String url = "https://data.humdata.org/dataset/a60ac839-920d-435a-bf7d-25855602699d/resource/7234d067-2d74-449a-9c61-22ae6d98d928/download/volcano.json";
    public static DataSource ds = DataSource.connect(url);
    
    public static void main(String[] args){
        ds.load();
        testSource();
        //fetchFirstNoClass();
        //fetchFirst();
        Volcano[] volcanos = fetchAll(); 
        //for (Volcano volcano: volcanos)
            //System.out.println(volcano.getCountry() + " (" + volcano.getRegion() + "):  " + volcano.getName());
        // this is the part where you can do whatever else you want to do with the data  
        
        
        
        // Ria's questions - how many volcanos in the US?  where are they?  
        int us_count = 0;
        int ak_count = 0;
        int hi_count = 0;
        int western_count = 0;
        for (Volcano volcano: volcanos){
            if (volcano.getCountry().equals("United States"))
                us_count++;
            if (volcano.getRegion().equals("Alaska"))
                ak_count++;
            if (volcano.getRegion().contains("Hawaii"))
                hi_count++;  
        }        
        System.out.println("US count is: " + us_count); 
        System.out.println("AK count is: " + ak_count); 
        System.out.println("HI count is: " + hi_count);        
            
       
                  
    }   
    
    /**
     * Displays the JSON structure for available data if link is valid.
     */
    public static void testSource(){
        ds.printUsageString();  
    } 
    
    /**
     * Fetches first item in list before Team class is made
     */
    public static void fetchFirstNoClass(){
        System.out.println("Volcano Info.");
        System.out.printf("Volcano Name: %s\nVolcano Country: %s",
        ds.fetchString("features/properties/Country"),
        ds.fetchString("features/properties/V_Name"));
    } 
    
    /**
     * Fetches first item in list after Team class is made
     */
    public static void fetchFirst(){
        Volcano vol = ds.fetch("Volcano", "features/properties/Country", "features/properties/V_Name");
        System.out.println(vol.getCountry() + ": " + vol.getName()); 
    } 
    
    
    /**
     * Fetches all teams 
     */
    public static Volcano[] fetchAll(){
        Volcano[] volcanos = ds.fetchArray("Volcano",  "features/properties/Country", "features/properties/V_Name", "features/properties/Region");  
        return volcanos;    
    } 
}