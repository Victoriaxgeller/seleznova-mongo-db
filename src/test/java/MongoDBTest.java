import org.example.dao.Post;
import org.example.event.InsertDocument;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collection;
import java.util.List;


public class MongoDBTest extends BaseDBTest {

    //TODO add annotations, steps, logic, api calls

    @Test
    public void checkDocumentIsInserted() {
        Post expectedPost = testDataGeneration.generatePost();
        String testId = expectedPost.getId();

        insertDocument.insertDocument(expectedPost);

        List<Post> postList = (List<Post>) queryDocument.getDocumentByFieldBaValue(Post.class, "_id", testId);
        Assert.assertTrue(postList.get(0).equals(expectedPost));
    }

    @Test
    public void checkManyDocumentIsInserted() {
        insertDocument.insertDocuments(testDataGeneration.generateListOfPosts(2));
    }

    @Test
    public void checkArticleIsInserted() {
        insertDocument.insertDocument(testDataGeneration.generateArticle());
    }

    @Test
    public void checkManyArticlesIsInserted() {
        insertDocument.insertDocuments(testDataGeneration.generateListOfArticles(2));
    }

    @Test
    public void checkQueryDocumentById() {
        String testId = "a02c49df-a2cb-4fb8-817e-6cacfdd05b7d";
        List<Post> postList = (List<Post>) queryDocument.getDocumentByFieldBaValue(Post.class, "_id", testId);
        Assert.assertEquals(postList.get(0).getId(), testId);
    }
}
