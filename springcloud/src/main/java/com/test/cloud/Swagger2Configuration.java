package com.test.cloud;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * https://www.jianshu.com/p/c79f6a14f6c9
 * https://www.pianshen.com/article/9281159372/
 * 访问http://localhost:7080/swagger-ui.html
 * @author shenfl
 */
@Configuration
@EnableSwagger2
public class Swagger2Configuration {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.test.cloud")) // 扫描RestController注解的接口
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("java技术")
                .description("测试spring cloud项目")
//                .termsOfServiceUrl("/")
                .version("1.0")
                .contact(new Contact("沈飞龙", "", "821617119@qq.com"))
                .build();
    }

}