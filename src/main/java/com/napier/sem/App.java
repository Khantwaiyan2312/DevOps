package com.napier.sem;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class App {
    public static void main(String[] args) {
        // Change hostname/port depending on environment:
        // - "localhost:27000" for local dev
        // - "mongo-dbserver:27017" for Docker Compose or containerized setup
        String mongoUri = "mongodb://mongo-dbserver:27017";

        try (MongoClient mongoClient = MongoClients.create(mongoUri)) {
            // Get a database - will be created if it doesn't exist
            MongoDatabase database = mongoClient.getDatabase("mydb");

            // Get a collection from the database
            MongoCollection<Document> collection = database.getCollection("test");

            // Create a document to store
            Document doc = new Document("name", "Kevin Sim")
                    .append("class", "Software Engineering Methods")
                    .append("year", "2021")
                    .append("result", new Document("CW", 95).append("EX", 85));

            // Add document to collection
            collection.insertOne(doc);

            // Check document in collection
            Document myDoc = collection.find().first();
            if (myDoc != null) {
                System.out.println("Inserted document: " + myDoc.toJson());
            } else {
                System.out.println("No document found!");
            }
        }
    }
}
