
package com.example.kenfetingspiderjob.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Config {
    @Getter
    @Value("${my.jdbc.driver}")
    private String JDBC_DRIVER;

    @Getter
    @Value("${my.db.url}")
    private String DB_URL;

    @Getter
    @Value("${my.db.username}")
    private String USER;

    @Getter
    @Value("${my.db.password}")
    private String PASS;

    @Getter
    @Value("${my.download.start.date}")
    private String START_DATE;

    @Getter
    @Value("${my.download.end.date}")
    private String END_DATE;
}
