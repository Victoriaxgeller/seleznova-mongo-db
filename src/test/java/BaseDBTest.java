import data.TestDataGeneration;
import org.example.event.InsertDocument;
import org.example.event.QueryDocument;
import org.testng.annotations.BeforeClass;

public class BaseDBTest {

    protected TestDataGeneration testDataGeneration;
    protected InsertDocument insertDocument;
    protected QueryDocument queryDocument;

    @BeforeClass
    public void setup() {
        testDataGeneration = new TestDataGeneration();
        insertDocument = new InsertDocument();
        queryDocument = new QueryDocument();

    }

}
