package com.sjht.cloud.entrance.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * ***************************************************
 * @ClassName SwaggerConfig
 * @Description swagger配置文件
 * @Author maojianyun
 * @Date 2019/11/30 23:25
 * @Version V1.0
 * ****************************************************
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo()).globalOperationParameters(setHeaderToken())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("重庆数聚汇通信息技术有限公司")
                .description("描述:入学申请接口").contact(new Contact("maojianyun", "", ""))
                .termsOfServiceUrl("http://www.ehualu.com/")
                .version("1.0.0").license("重庆数聚汇通信息技术有限公司")
                .build();
    }

    @SuppressWarnings("unused")
    private List<Parameter> setHeaderToken() {
        ParameterBuilder tokenPar = new ParameterBuilder();
        ParameterBuilder tokenPar2 = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();
        tokenPar.name("Authorization").description("Authorization").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        tokenPar2.name("uid").description("uid").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        pars.add(tokenPar.build());
        pars.add(tokenPar2.build());
        return pars;
    }
}