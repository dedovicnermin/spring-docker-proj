package com.dedo.devproj;

import org.springframework.context.annotation.Configuration;
import org.testcontainers.containers.PostgreSQLContainer;


public class NermPostgresqlContainer extends PostgreSQLContainer<NermPostgresqlContainer> {
    private static String IMAGE_VERSION = "postgres:latest";
    private static NermPostgresqlContainer container;

    private NermPostgresqlContainer() {
        super(IMAGE_VERSION);
    }

    public static NermPostgresqlContainer getInstance() {
        if (container==null) {
            container = new NermPostgresqlContainer();
        }
        return container;
    }

    @Override
    public void start() {
        super.start();
        System.setProperty("DB_URL", container.getJdbcUrl());
        System.setProperty("DB_USERNAME", container.getUsername());
        System.setProperty("DB_PASSWORD", container.getPassword());
    }

    @Override
    public void stop() {
        // do nothing, JVM handles shut down
    }
}
