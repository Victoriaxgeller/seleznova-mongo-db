package org.example.event;

import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import org.bson.conversions.Bson;
import org.example.dao.Post;
import org.example.dao.common.CommonDAO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.example.db.client.MongoClientProvider.getDataBase;

public class QueryDocument {

    private MongoDatabase mongoDatabase;

    public QueryDocument() {
        this.mongoDatabase = getDataBase();
    }

    public Collection<? extends CommonDAO> getDocumentByFieldBaValue(Class<? extends CommonDAO> classType, String field, String value) {
        Bson query = Filters.eq(field, value);
        List postList = find(classType.getSimpleName(), classType, query);
        postList.forEach(post -> System.out.println(post.toString()));
        return postList;
    }

    private <T> List<T> findAll(String collectionName, Class<T> classType) {
        MongoCollection<T> collection = mongoDatabase.getCollection(collectionName, classType);
        FindIterable<T> findResult = collection.find();
        return convert(findResult);
    }

    private <T> List<T> find(String collectionName, Class<T> classType, Bson query) {
        MongoCollection<T> collection = mongoDatabase.getCollection(collectionName, classType);
        FindIterable<T> findResult = collection.find(query);
        return convert(findResult);
    }

    private <T> List<T> convert(FindIterable<T> findIterable) {
        List<T> documents = new ArrayList<>();
        MongoCursor<T> cursor = findIterable.cursor();
        while (cursor.hasNext())
            documents.add(cursor.next());

        return documents;
    }

}
