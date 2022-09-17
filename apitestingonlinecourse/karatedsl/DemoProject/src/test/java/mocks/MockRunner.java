package mocks;
import utils.KarateMockServerExtension;
import com.intuit.karate.junit5.Karate;
import org.junit.jupiter.api.extension.RegisterExtension;
public class MockRunner {
    @RegisterExtension
    static KarateMockServerExtension mockServerRule = KarateMockServerExtension
            .create(MockRunner.class, "MockDemo.feature");

    @Karate.Test
    Karate testDemoMockServer() {

        return Karate.run("TestMocks")
                .systemProperty("mock_server_port", String.valueOf(mockServerRule.getPort()))
                .relativeTo(getClass());
    }
}
