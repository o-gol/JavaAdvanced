package ru.yandex.olejkai.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import ru.yandex.olejkai.connections.Connectivity;
import ru.yandex.olejkai.connections.JDBCConnect;
import ru.yandex.olejkai.model.People;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Configuration
@ComponentScan("ru.yandex.olejkai")
@EnableWebMvc
public class SpringMVCConfig implements WebMvcConfigurer {
    private final ApplicationContext context;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/css/**","/js/**")
                .addResourceLocations("/WEB-INF/views/my_view/css/","/WEB-INF/views/my_view/js/");

    }

    @Autowired
    public SpringMVCConfig(ApplicationContext context){
        this.context=context;
    }



    @Bean
    public SpringResourceTemplateResolver templateResolver(){
        SpringResourceTemplateResolver templateResolver=new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(context);
        templateResolver.setPrefix("/WEB-INF/");
        templateResolver.setSuffix(".html");
        templateResolver.setCharacterEncoding("UTF-8");
        templateResolver.setCacheable(false);
        return templateResolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine(){
        SpringTemplateEngine templateEngine=new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        templateEngine.setEnableSpringELCompiler(true);
        return templateEngine;
    }

    @Bean
    public ThymeleafViewResolver thymeleafViewResolver(){
        ThymeleafViewResolver thymeleafViewResolver=new ThymeleafViewResolver();
        thymeleafViewResolver.setTemplateEngine(templateEngine());
        thymeleafViewResolver.setOrder(1);
        thymeleafViewResolver.setViewNames(new String[]{"*"});
        thymeleafViewResolver.setCharacterEncoding("UTF-8");
        thymeleafViewResolver.setContentType("text/html; charset=UTF-8");
        return thymeleafViewResolver;

    }

    @Bean
    public Connectivity thisDbJDBCConnect(){
        return new JDBCConnect("jdbc:postgresql://localhost:5432/first_db",
                "postgres",
                "pa44w0rd",
                "org.postgresql.Driver");
    }

    
    @Bean
    public List<People> thisDbListConnect(){
        final List<People> peopleList = new ArrayList();

        {
            peopleList.add(new People(0,"Tim", "Tyrri", 23, "ret5@tut.fd"));
            peopleList.add(new People(0,"Typ", "Dibby", 54, "ser5@ttre.tr"));
            peopleList.add(new People(0,"Jack", "Ruret", 25, "yet@iyttut.mer"));
            peopleList.add(new People(0,"Pick", "Mamy", 23, "34yfhui@tyui.zz"));
        }
        return peopleList;
    }




    /*@Bean
    public Logger logger(){
        Logger log4j=Logger.getLogger("logger");

        //Log to Console as STDOUT
        log4j.
        log4j.appender.stdout=org.apache.log4j.ConsoleAppender
        log4j.appender.stdout.Target=System.out
        log4j.appender.stdout.layout=org.apache.log4j.PatternLayout
        log4j.appender.stdout.layout.ConversionPattern=%d{yyyy-MM-dd HH:mm:ss} %-5p %c %3x - %m%n
//Log to file FILE
        log4j.appender.file=org.apache.log4j.DailyRollingFileAppender
        log4j.appender.file.File=logfile.log
        log4j.appender.file.DatePattern='.'yyyy-MM-dd
        log4j.appender.file.append=true
        log4j.appender.file.layout=org.apache.log4j.PatternLayout
        log4j.appender.file.layout.ConversionPattern=%d{yyyy-MM-dd HH:mm:ss} %-5p %c %3x - %m%n

//Root Logger
        log4j.rootLogger=INFO, stdout, file
        return log4j;
    }*/



    /*@Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(templateEngine());
        resolver.setCharacterEncoding("UTF-8");
        registry.viewResolver(resolver);
    }*/

}












/*
package ru.yandex.olejkai.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
*/

/*

@Configuration
@ComponentScan("ru.yandex.olejkai")
@EnableWebMvc
public class SpringMVCConfig implements WebMvcConfigurer {

    private final ApplicationContext applicationContext;

    @Autowired
    public SpringMVCConfig(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(applicationContext);
        templateResolver.setPrefix("/WEB-INF/views/");
        templateResolver.setSuffix(".html");
        return templateResolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        templateEngine.setEnableSpringELCompiler(true);
        return templateEngine;
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(templateEngine());
        registry.viewResolver(resolver);
    }
}*/
