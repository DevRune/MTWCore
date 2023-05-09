package nl.mtworld.mtwcore.data.mongodb;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import nl.mtworld.mtwcore.MTWCore;
import org.bson.Document;

public class MongoDBManager {

    private MTWCore mtwCore;

    public MongoDBManager(MTWCore mtwCore){
        this.mtwCore = mtwCore;
    }

    MongoClient mongoClient;
    MongoDatabase mongoDatabase;
    MongoCollection<Document> playerData;

    public void connect(){
        mongoClient = MongoClients.create(mtwCore.getConfig().getString("mongodb.connection"));
        mongoDatabase = mongoClient.getDatabase("minetopiaworld");
        playerData = mongoDatabase.getCollection("player_data");
    }

    public MongoCollection<Document> getPlayerData() {
        return playerData;
    }

}
