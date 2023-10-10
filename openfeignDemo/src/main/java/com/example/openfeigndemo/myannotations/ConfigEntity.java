package com.example.openfeigndemo.myannotations;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @BelongsProject: openfeignDemo
 * @BelongsPackage: com.example.openfeigndemo.myannotations
 * @Author: gepengjun
 * @CreateTime: 2023-09-01  21:19
 * @Description: TODO
 * @Version: 1.0
 */
@Component
@Data
@ConfigurationProperties(prefix = "")
public class ConfigEntity {
    private Map<String, Map<String, String>> strategymap;
}
