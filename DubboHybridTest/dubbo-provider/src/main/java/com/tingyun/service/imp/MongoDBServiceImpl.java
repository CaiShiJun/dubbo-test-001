package com.tingyun.service.imp;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import com.tingyun.service.nosql.MongoDBService;
import com.tingyun.util.ConnectionUtil;
import org.bson.BsonDocument;
import org.bson.BsonString;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.List;

public class MongoDBServiceImpl implements MongoDBService {

    private MongoDatabase mongoDatabase;

    public MongoDBServiceImpl(){
        MongoClient mongoClient = ConnectionUtil.getMongoClient();
        // 连接到数据库
        mongoDatabase = mongoClient.getDatabase("mycol");
    }

    //创建集合
    public void createCollection(String str){
        mongoDatabase.createCollection(str);
    }

    //获取集合
    public MongoCollection getCollection(String str){
       return mongoDatabase.getCollection(str);
    }

    //插入文档
    public void insertMany(String collectionStr,List<Document> documents){
        MongoCollection<Document> collection = mongoDatabase.getCollection(collectionStr);
        collection.insertMany(documents);
    }

    //检索所有文档
    public MongoCursor<Document> find(String collectionStr){
        MongoCollection<Document> collection = mongoDatabase.getCollection(collectionStr);
        FindIterable<Document> findIterable = collection.find();
        MongoCursor<Document> mongoCursor = findIterable.iterator();
        return mongoCursor;
    }

    //更新文档
    public UpdateResult updateMany(String collectionStr, Bson filters, Bson document){
        MongoCollection<Document> collection = mongoDatabase.getCollection(collectionStr);
        //更新文档
        return collection.updateMany(filters, document);
    }

    //删除符合条件的第一个文档
    public DeleteResult deleteOne(String collectionStr, Bson filters){
        MongoCollection<Document> collection = mongoDatabase.getCollection(collectionStr);
        return collection.deleteOne(filters);
    }

    //删除所有符合条件的文档
    public DeleteResult deleteMany(String collectionStr,Bson filters){
        MongoCollection<Document> collection = mongoDatabase.getCollection(collectionStr);
        return collection.deleteMany(filters);
    }
}
