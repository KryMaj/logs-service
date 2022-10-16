package pl.niepracuj.logsservice.configuration;



import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.Properties;


@Configuration
@PropertySource("classpath:application.properties")
public class DatabaseConfiguration {

    @Value("${datasource.url}")
    private String url;

    @Value("${datasource.username}")
    private String username;

    @Value("${datasource.password}")
    private String password;

    @Value("${jpa.properties.hibernate.dialect}")
    private String dialect;

    @Value("${jpa.hibernate.ddl-auto}")
    private String mode;

    @Value("${packages.to.scan}")
    private String packages;

    @Value("${liquibase.change-log}")
    private String changelog;

    @Bean
    public DataSource getDateSource(){
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setUrl(url);
        driverManagerDataSource.setPassword(password);
        driverManagerDataSource.setUsername(username);
        return driverManagerDataSource;
    }


    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(getDateSource());
        entityManagerFactoryBean.setPackagesToScan(packages);
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setJpaProperties(getHibernateProperties());
        return entityManagerFactoryBean;
    }

    @Bean
    public SpringLiquibase liquibase(){
        SpringLiquibase springLiquibase = new SpringLiquibase();
        springLiquibase.setChangeLog(changelog);
        springLiquibase.setDataSource(getDateSource());
        return springLiquibase;
    }
    private Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", mode);
        properties.setProperty("hibernate.dialect", dialect);
        return properties;
    }
}