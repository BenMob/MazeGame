package version1.gameUtil.data.dataRepository;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import version1.gameUtil.data.models.PlayerRecord;
import version1.gameUtil.settings.GameMode;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataStore implements DataStore_IF{

    String FILE_LOCATION = "JSON/records.json";

    private PlayerRecord currentPlayerRecord;

    private static DataStore dsInstance;

    private final List<PlayerRecord> recordsAsList;

    private final Map<String,PlayerRecord> recordsAsHashMap;

    private DataStore() {
        recordsAsList = new ArrayList<>();
        recordsAsHashMap = new HashMap<>();
    }

    /**
     * Return the Database for
     * @return database instance
     */
    public static DataStore_IF getDSInstance() {
        if(dsInstance == null) dsInstance = new DataStore();
        return dsInstance;
    }

    /**
     * Reads user data from the json file
     */
    private void readData() {
        /*
         * To parse the JSON string into Java objects
         */
        JSONParser parser = new JSONParser();

        try(FileReader dataReader = new FileReader(FILE_LOCATION)){
             JSONArray records = (JSONArray) parser.parse(dataReader);

             for(Object record: records){

                 /*
                  * Create a Player record JSOn Object
                  */
                 JSONObject playerRecordJsonObject = (JSONObject) record;

                 /*
                  * Extract player's username and scores
                  */
                 String username = (String)playerRecordJsonObject.get("username");
                 JSONObject scores = (JSONObject)playerRecordJsonObject.get("scores");

                 /*
                  * Creates a player record from the JSON Object
                  */
                 PlayerRecord playerRecord = new PlayerRecord(username);
                 playerRecord.setHighestScore(Integer.parseInt((String)scores.get("easy")), GameMode.EASY);
                 playerRecord.setHighestScore(Integer.parseInt((String)scores.get("medium")), GameMode.MEDIUM);
                 playerRecord.setHighestScore(Integer.parseInt((String)scores.get("hard")), GameMode.HARD);

                 /*
                  * Adds the player record to the HashMap
                  */
                 recordsAsHashMap.put(playerRecord.getUsername(), playerRecord);
             }

        } catch (FileNotFoundException fileNotFoundException){
            // Do Nothing
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * Writes the data in the Json File
     * TODO: Refactor this method and give it a single resrponsablity of writing the data
     */
    private void writeData() {

        /*
         * The JSON array to store player records tha are extracted from the HashMap
         */
        JSONArray recordsJSONArray = new JSONArray();

        /*
         * Convert the data from HashMap to JSONArray
         */
        for(String username: recordsAsHashMap.keySet()) {

            /*
             * Getting the player record object
             */
            PlayerRecord playerRecord = recordsAsHashMap.get(username);

            /*
             * Builds a player scores JSON Objct
             */
            JSONObject scoresJSON = new JSONObject();
            scoresJSON.put("easy", playerRecord.getHighestScores().get(GameMode.EASY).toString());
            scoresJSON.put("medium", playerRecord.getHighestScores().get(GameMode.MEDIUM).toString());
            scoresJSON.put("hard", playerRecord.getHighestScores().get(GameMode.MEDIUM).toString());

            /*
             * Builds a Player record Json Object
             */
            JSONObject playerRecordJSON = new JSONObject();
            playerRecordJSON.put("scores", scoresJSON);
            playerRecordJSON.put("username", username);


            /*
             * Append the player record to the records JSON array
             */
            recordsJSONArray.add(playerRecordJSON);
        }

        /*
         * Write the json Array to a file for persistance
         */
        try(FileWriter file = new FileWriter(FILE_LOCATION)){
            if(recordsJSONArray.size() > 0){
                file.write(recordsJSONArray.toJSONString());
                file.flush();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    /*
     * Given a username, check if we have a record on them
     * @param username
     * @return
     */
    private boolean recordExist(String username) {
        return (recordsAsHashMap.get(username) != null);
    }

    /**
     * Tries to log the user in
     *
     * @param username : a username
     * @return boolean
     */
    @Override
    public boolean login(String username) {
        readData();
        if(recordExist(username)){
            currentPlayerRecord = recordsAsHashMap.get(username);
            return true;
        }
        return false;
    }

    /**
     * Tries to register a user
     *
     * @param username : a username
     * @return boolean
     */
    @Override
    public boolean register(String username) {

        /*
         * Makes sure this username doesn't already exist and that it
         * is at leas 2 characters long
         */
        if(recordExist(username) || username.length() <= 2){
            return false;
        }

        /*
         * Add the currnet user records
         */
        recordsAsHashMap.put(username, new PlayerRecord(username));

        /*
         * Writes the updated records on a records file
         */
        writeData();

        return true;
    }

    /**
     * Queries the currently logged in player
     *
     * @return PlayerRecord
     */
    @Override
    public PlayerRecord QueryPlayerRecord() {
        return currentPlayerRecord;
    }

    /**
     * Queries all the players and return them in a list
     *
     * @return RecordList
     */
    @Override
    public List<PlayerRecord> QueryRecordsAsList() {
        return recordsAsList;
    }

    /**
     *  Questies all the players and returns them in a Hashmap
     * @return recordsAsHashMap
     */
    @Override
    public Map<String, PlayerRecord> QueryRecordsAsMap() {
        return recordsAsHashMap;
    }
}
