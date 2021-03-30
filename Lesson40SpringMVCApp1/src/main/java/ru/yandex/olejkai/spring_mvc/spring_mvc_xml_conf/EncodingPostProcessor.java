package ru.yandex.olejkai.spring_mvc.spring_mvc_xml_conf;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;

import java.nio.charset.Charset;
import java.util.Arrays;

public class EncodingPostProcessor implements BeanPostProcessor {
    /*public Object postProcessBeforeInitialization(Object bean, String name)
            throws BeansException {
        if (bean instanceof AnnotationMethodHandlerAdapter) {
            HttpMessageConverter<?>[] convs = ((AnnotationMethodHandlerAdapter) bean).getMessageConverters();
            for (HttpMessageConverter<?> conv: convs) {
                if (conv instanceof StringHttpMessageConverter) {
                    ((StringHttpMessageConverter) conv).setSupportedMediaTypes(
                            Arrays.asList(new MediaType("text", "html",
                                    Charset.forName("UTF-8"))));
                }
            }
        }
        return bean;
    }*/

    public Object postProcessAfterInitialization(Object bean, String name)
            throws BeansException {
        return bean;
    }
}