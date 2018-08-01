package com.tingyun.service.nosql;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.List;

public interface MongoDBService {

    public void createCollection(String str);
    public MongoCollection getCollection(String str);
    public void insertMany(String collectionStr,List<Document> documents);
    public MongoCursor<Document> find(String collectionStr);
    public UpdateResult updateMany(String collectionStr, Bson filters, Bson document);
    public DeleteResult deleteOne(String collectionStr, Bson filters);
    public DeleteResult deleteMany(String collectionStr,Bson filters);

}
