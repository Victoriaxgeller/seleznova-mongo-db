package org.example.db.client;


import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;


public class MongoClientProvider {
    private final static String DBNAME = "test";

    private final static MongoClient mongoClient = connect();

    public static MongoClient getMongoClientInstance() {
        return mongoClient;
    }

    private static MongoClient connect() {
        ConnectionString connectionString = new ConnectionString("mongodb://" + "localhost" + ":" + 27017);

        CodecRegistry pojoCodecRegistry = CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build());
        CodecRegistry codecRegistry = CodecRegistries.fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);

        MongoClientSettings clientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .codecRegistry(codecRegistry)
                .build();
        return MongoClients.create(clientSettings);
    }

    public static MongoDatabase getDataBase() {
        return mongoClient.getDatabase(DBNAME);
    }

}
