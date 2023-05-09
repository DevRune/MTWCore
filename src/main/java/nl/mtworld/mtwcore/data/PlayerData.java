package nl.mtworld.mtwcore.data;

import nl.mtworld.mtwcore.MTWCore;
import org.bson.Document;

import java.util.UUID;

public class PlayerData {

    MTWCore mtwCore;
    String uuids;
    UUID uuid;

    public PlayerData(MTWCore mtwCore, String id){
        this.mtwCore = mtwCore;
        this.uuids = id;
        this.uuid = UUID.fromString(id);
        Document document = new Document("UUID", id);
        Document found = (Document) mtwCore.getMongoDBManager().getPlayerData().find(document).first();
    }

    public void save(){
        Document playerdoc = new Document("UUID", uuids);
        Document newdoc = new Document("UUID", uuids);
        mtwCore.getMongoDBManager().getPlayerData().findOneAndReplace(playerdoc, newdoc);
    }


}
