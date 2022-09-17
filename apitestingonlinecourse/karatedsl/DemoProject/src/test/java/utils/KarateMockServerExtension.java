package utils;

import com.intuit.karate.core.MockServer;
import com.intuit.karate.core.MockServer.Builder;
import com.intuit.karate.resource.ResourceUtils;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.Extension;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Map;

@SuppressWarnings("unused")
public class KarateMockServerExtension implements Extension, BeforeAllCallback, AfterAllCallback {

    private static final Logger logger = LoggerFactory.getLogger(KarateMockServerExtension.class);

    private final Builder mockServerBuilder;

    private MockServer mockServer;

    public KarateMockServerExtension(Builder mockServerBuilder) {
        this.mockServerBuilder = mockServerBuilder;
    }

    /**
     * Create a mock server. The <code>relativePath</code> must be relative to the <code>relativeClass</code>.
     * @param relativeClass starting point to look up the feature file.
     * @param relativePath relative path to the mock feature file. The file suffix (most likely <code>.feature</code>) is required.
     * @return
     */
    public static KarateMockServerExtension create(Class<?> relativeClass, String relativePath) {
        final File mockFile = ResourceUtils.getFileRelativeTo(relativeClass, relativePath);
        return new KarateMockServerExtension(MockServer.feature(mockFile));
    }

    /**
     * Create mock server using an absolute path to the mock feature file.
     * Relative path isn't supported. Use {@link KarateMockServerExtension#create(Class, String)} instead.
     *
     * @param featurePath absolute path or `classpath:` prefixed path to the feature file. Relative path isn't supported
     * @return
     */
    public static KarateMockServerExtension create(String featurePath) {
        return new KarateMockServerExtension(MockServer.feature(featurePath));
    }

    public Builder httpPort(int value) {

        return mockServerBuilder.http(value);
    }

    public Builder httpsPort(int value) {

        return mockServerBuilder.https(value);
    }

    public Builder certFile(File value) {

        return mockServerBuilder.certFile(value);
    }

    public Builder keyFile(File value) {

        return mockServerBuilder.keyFile(value);
    }

    public Builder args(Map<String, Object> value) {

        return mockServerBuilder.args(value);
    }

    public Builder arg(String name, Object value) {

        return mockServerBuilder.arg(name, value);
    }

    public int getPort() {

        if (mockServer != null) {
            return mockServer.getPort();
        }
        throw new IllegalStateException("Mock server not started yet!");
    }

    @Override public void beforeAll(ExtensionContext context) throws Exception {
        mockServer = mockServerBuilder.build();
        logger.info("Karate mock server started on port:{}", getPort());
    }

    @Override public void afterAll(ExtensionContext context) throws Exception {
        if (mockServer != null) {
            mockServer.stop();
            logger.info("Karate mock server stopped!");
        }
    }
}
