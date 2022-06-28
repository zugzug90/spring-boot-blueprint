#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.yandex.qatools.embed.postgresql.EmbeddedPostgres;

import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;

import static ru.yandex.qatools.embed.postgresql.distribution.Version.Main.V9_6;

@Slf4j
public class EmbeddedPostgresInitializer implements ApplicationContextInitializer<GenericApplicationContext>, DisposableBean {

    private EmbeddedPostgres postgres;

    @Override
    public void initialize(GenericApplicationContext applicationContext) {
        postgres = new EmbeddedPostgres(V9_6);
        try {
            String url = postgres.start();
            log.info("DataSource URL: {}", url);
            TestPropertyValues values = TestPropertyValues.of(
                    "spring.test.database.replace=none",
                    "spring.datasource.url=" + url,
                    "spring.datasource.driver-class-name=org.postgresql.Driver");


            //SimpleDriverDataSource dataSource = new SimpleDriverDataSource(Driver, url);


            values.applyTo(applicationContext);

            DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
            dataSourceBuilder.driverClassName("org.postgresql.Driver");
            dataSourceBuilder.url(url);
            DataSource dataSource = dataSourceBuilder.build();

            applicationContext.registerBean(EmbeddedPostgres.class, () -> postgres);
            applicationContext.registerBean(DataSource.class, () -> dataSource);
            applicationContext.registerBean(JdbcTemplate.class, () -> new JdbcTemplate(dataSource));
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void applySchema() throws IOException, URISyntaxException, InterruptedException {
        File path = Paths.get(ClassLoader.getSystemResource("init.db.sh").toURI()).toFile();
        String shellScriptPath = path.getAbsolutePath();

        ProcessBuilder processBuilder = new ProcessBuilder("sh", "-c", "/bin/sh " + shellScriptPath);
        processBuilder.directory(new File(path.getParent()));
        Process process = processBuilder.start();
        process.waitFor();
        System.out.println(IOUtils.toString(process.getErrorStream()));

        System.out.println("----------------------------------------------");
    }

    @Override
    public void destroy() throws Exception {
        postgres.close();
    }
}
