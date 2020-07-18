package com.tapriBrewCafe.dashboard.config;

import java.io.IOException;
import javax.sql.DataSource;

import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.yandex.qatools.embed.postgresql.EmbeddedPostgres;
import ru.yandex.qatools.embed.postgresql.config.AbstractPostgresConfig;
import ru.yandex.qatools.embed.postgresql.config.PostgresConfig;
import ru.yandex.qatools.embed.postgresql.distribution.Version;

import static ru.yandex.qatools.embed.postgresql.util.SocketUtil.findFreePort;

@Configuration
public class EmbeddedPostgresConfig {

    private static final String LOCALHOST = "localhost";
    private static final String DB_NAME = "embeddedDb";

    @Bean
    public EmbeddedPostgres embeddedPostgres() throws IOException {
        EmbeddedPostgres postgres = new EmbeddedPostgres(Version.Main.V9_6);
        postgres.start(LOCALHOST, findFreePort(), DB_NAME, "username", "password");
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            stopPostgres(postgres);
        }));
        return postgres;
    }

    @Bean
    public DataSource dataSource(EmbeddedPostgres embeddedPostgres) {
        PGSimpleDataSource ds = new PGSimpleDataSource();
        PostgresConfig postgresConfig = embeddedPostgres.getConfig().get();
        AbstractPostgresConfig.Credentials credentials = postgresConfig.credentials();
        ds.setServerName(LOCALHOST);
        ds.setPortNumber(postgresConfig.net().port());
        ds.setDatabaseName(DB_NAME);
        ds.setUser(credentials.username());
        ds.setPassword(credentials.password());
        return ds;
    }

    private void stopPostgres(EmbeddedPostgres embeddedPostgres) {
        embeddedPostgres.getProcess().ifPresent(p -> {
            if (p.isProcessRunning()) {
                embeddedPostgres.stop();
            }
        });
    }
}
