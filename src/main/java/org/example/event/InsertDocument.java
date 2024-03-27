package org.example.event;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.example.dao.common.CommonDAO;

import java.util.List;

import static org.example.db.client.MongoClientProvider.*;

public class InsertDocument {
    private MongoDatabase mongoDatabase;

    public InsertDocument() {
        this.mongoDatabase = getDataBase();
    }

    public void insertDocument(CommonDAO commonDAO) {
        System.out.println(commonDAO.getClassName() + " - " + CommonDAO.class + " - " + commonDAO);
        insert(commonDAO.getClassName(), CommonDAO.class, commonDAO);
        System.out.println("Insert " + commonDAO.getClassName() + " Successful!");
    }

    public void insertDocuments(List<? extends CommonDAO> commonDAOs) {
        insertMany(commonDAOs.get(0).getClassName(), CommonDAO.class, commonDAOs);
        System.out.println("Insert many " + commonDAOs.get(0).getClassName() + " Successful!");
    }

    private <T> void insert(String collectionName, Class<T> classType, T document) {
        MongoCollection<T> collection = mongoDatabase.getCollection(collectionName, classType);
        collection.insertOne(document);
    }

    private <T> void insertMany(String collectionName, Class<T> classType, List<? extends T> documents) {
        MongoCollection<T> collection = mongoDatabase.getCollection(collectionName, classType);
        collection.insertMany(documents);
    }

}
