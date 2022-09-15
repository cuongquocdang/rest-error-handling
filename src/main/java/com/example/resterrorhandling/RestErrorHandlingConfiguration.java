package com.example.resterrorhandling;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.toMap;

@Configuration
@ConditionalOnProperty(prefix = "rest-error-handling", name = "enabled", havingValue = "true")
@RequiredArgsConstructor
public class RestErrorHandlingConfiguration {

    private final RestErrorHandlingProperties restErrorHandlingProperties;
    private final ObjectMapper objectMapper;

    @Bean
    @SneakyThrows
    public Map<String, ErrorInfoDefinition> restErrorHandlingProperties() {
        var jsonFile = new ClassPathResource(restErrorHandlingProperties.getRestErrorHandlingFileName()).getFile();
        var errors = List.of(objectMapper.readValue(jsonFile, ErrorInfoDefinition[].class));
        return errors.stream()
                .collect(toMap(ErrorInfoDefinition::getCodeDefinition, Function.identity()));
    }
}
