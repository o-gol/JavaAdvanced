package ru.yandex.olejkai.javaXmlConf.objects;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MusicConfig {
    @Bean
    public Music getClassic1(){
        return new ClassicMusic("Bethov-LalAlA");
    }
    @Bean
    public Music getClassic2(){
        return new ClassicMusic("Glinka-zazazaz");
    }
    @Bean
    public Music getClassic3(){
        return new ClassicMusic("Procofiev-Varsh");
    }
    @Bean
    public Music getRack1(){
        return new RackMusic("Linkin Park-My hart");
    }
    @Bean
    public Music getRack2(){
        return new RackMusic("Slipknot-AAAAAAAAAA");
    }
    @Bean
    public Music getRack3(){
        return new RackMusic("SOAD-Arials");
    }

}
