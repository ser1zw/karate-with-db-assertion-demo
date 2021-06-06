package demo;

import com.example.demo.DemoApplication;
import com.intuit.karate.junit5.Karate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import javax.sql.DataSource;
import org.assertj.db.type.Table;

import static org.assertj.db.api.Assertions.assertThat;

@SpringBootTest(classes = DemoApplication.class)
public class DemoTestRunner {
    private static DataSource dataSource;

    @Autowired
    private void setDataSource(DataSource dataSource) {
        DemoTestRunner.dataSource = dataSource;
    }

    @Karate.Test
    Karate testAll() {
        return Karate.run().relativeTo(getClass());
    }

    public static void assertTable(String expectedMessage) {
        var table = new Table(dataSource, "messages");
        assertThat(table).hasNumberOfRows(1)
            .row(0)
            .column("message").value().isEqualTo(expectedMessage);
    }
}
