package entry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication // same as @Configuration+@EnableAutoConfiguration+@ComponentScan
@EnableSwagger2 // 启动swagger注解
public class Application implements EmbeddedServletContainerCustomizer{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(Application.class, args);
	}
	
	@Override
	public void customize(ConfigurableEmbeddedServletContainer container) {
		container.setPort(8088);
	}

}