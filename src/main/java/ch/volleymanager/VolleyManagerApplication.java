package ch.volleymanager;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@SpringBootApplication
public class VolleyManagerApplication {

    @Autowired
    private Environment env;

    public static void main(String[] args) {
        SpringApplication.run(VolleyManagerApplication.class, args);
    }

    @PostConstruct
    public void afterInit() {
        boolean hasDevProfile = Arrays.asList(env.getActiveProfiles()).contains("dev");
        boolean hasH2Database = Arrays.asList(env.getActiveProfiles()).contains("h2");
        String applicationName = env.getProperty("spring.application.name");
        String appServerUrl = env.getProperty("app.server.url");
        String openApiInfo="";
        String h2ConsoleInfo="";
        if (hasDevProfile) {
            openApiInfo = appServerUrl + "/v3/api-docs\n" +
                    appServerUrl + "/v3/api-docs.yaml -> yaml file is downloaded -> https://editor.swagger.io/\n" +
                    appServerUrl + "/swagger-ui.html \n";
        }
        if (hasH2Database) {
            h2ConsoleInfo= appServerUrl+ "/h2-console  " + "" +
                    "-> mit Generic H2 (Embedded), org.h2.Driver, jdbc:h2:mem:testdb und sa \n";
        }
        System.out.println("\n\nApplication [" + applicationName + "] - Enter in Browser:\nhttp://localhost:8080 \n" +
                openApiInfo +
                h2ConsoleInfo + "\n" +
                "Active Profiles: " + Arrays.toString(env.getActiveProfiles()) + "\n\n");
    }

    @Bean
    public OpenAPI customOpenAPI(@Value("${springdoc.version}") String appVersion, @Value("${app.server.url}") String contextPath) {
        return new OpenAPI()
                .addServersItem(new Server().url(contextPath))
                .components(new Components())
                .info(new Info().title("API for Todo App").version(appVersion)
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }


    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200", "http://resmarti.synology.me:4200", "http://192.168.178.24:4200"));
        corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
                "Accept", "Authorization", "Origin, Accept", "X-Requested-With",
                "Access-Control-Request-Method", "Access-Control-Request-Headers"));
        corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "",
                "Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
        corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(urlBasedCorsConfigurationSource);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }


}
