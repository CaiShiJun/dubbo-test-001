package com.tingyun.controller;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import com.tingyun.service.nosql.MongoDBService;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
//@RequestMapping()
public class MongoDBController {

    @Autowired
    private MongoDBService mongoDBService;

    @RequestMapping("/mongoDBTest")
    @ResponseBody
    public String mongoDBTest(){

        UUID uuid = UUID.randomUUID();
        String collectionName = uuid.toString();

        //创建集合
        mongoDBService.createCollection(collectionName);

        //插入文档
        List<Document> documentList = new ArrayList<Document>();
        Document document = new Document("title", "MongoDB").
                append("description", "database").
                append("likes", 100).
                append("by", "Fly");
        documentList.add(document);
        for (int i = 0; i < 10; i++) {
            documentList.add(new Document(UUID.randomUUID().toString(), UUID.randomUUID().toString()));
        }
        mongoDBService.insertMany(collectionName, documentList);

        //检索所有文档
        MongoCursor<Document> mongoCursor = mongoDBService.find(collectionName);
        int docCount = 0;
        if (mongoCursor.hasNext()) {
            docCount++;
        }
        System.out.println(docCount);

        //更新文档
        UpdateResult updateResult = mongoDBService.updateMany(collectionName, Filters.eq("likes", 100), new Document("$set", new Document("likes", 200)));
        System.out.println(updateResult);

        //获取集合
        MongoCollection mongoCollection = mongoDBService.getCollection(collectionName);
        System.out.println(mongoCollection.count());

        //删除符合条件的第一个文档
        DeleteResult deleteResult = mongoDBService.deleteOne(collectionName, Filters.eq("likes", 200));
        System.out.println(deleteResult);

        //删除所有符合条件的文档
        deleteResult = mongoDBService.deleteMany(collectionName, Filters.ne("likes", 200));
        System.out.println(deleteResult);

        return "mongoDBTest"+"success";
    }

}
