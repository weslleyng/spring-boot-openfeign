package dev.weslley.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.codec.Decoder;
import feign.codec.Encoder;
import java.util.Collections;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

@Configuration
public class FeignConfig {

    @Bean
    public Decoder feignDecoder() {
        var jacksonConverter = new MappingJackson2HttpMessageConverter(customObjectMapper());
        jacksonConverter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        HttpMessageConverters httpMessageConverters = new HttpMessageConverters(jacksonConverter);
        ObjectFactory<HttpMessageConverters> objectFactory = () -> httpMessageConverters;
        return new ResponseEntityDecoder(new SpringDecoder(objectFactory));
    }

    @Bean
    public Encoder feignEncoder() {
        var jacksonConverter = new MappingJackson2HttpMessageConverter(customObjectMapper());
        jacksonConverter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        HttpMessageConverters httpMessageConverters = new HttpMessageConverters(jacksonConverter);
        ObjectFactory<HttpMessageConverters> objectFactory = () -> httpMessageConverters;
        return new SpringEncoder(objectFactory);
    }

    public ObjectMapper customObjectMapper() {
        var objectMapper = new ObjectMapper();

        //Customize as much as you want
        return objectMapper;
    }
}
