package ast;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.filter.HttpPutFormContentFilter;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication(
//       关闭数据库配置
        exclude = {
                DataSourceAutoConfiguration.class,
                DataSourceTransactionManagerAutoConfiguration.class,
                HibernateJpaAutoConfiguration.class})
@EnableTransactionManagement
@EnableScheduling
@EnableSwagger2
@Slf4j
public class CalendarApplication {
    public static void main(String[] args) {
        SpringApplication.run(CalendarApplication.class, args);
    }

    @Bean
    public HttpPutFormContentFilter httpPutFormContentFilter() {
        return new HttpPutFormContentFilter();
    }
}
