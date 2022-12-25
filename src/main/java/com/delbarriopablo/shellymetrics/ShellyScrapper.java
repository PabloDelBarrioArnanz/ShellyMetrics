package com.delbarriopablo.shellymetrics;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class ShellyScrapper {

    private static final String URL = "http://192.168.1.202/status";

    private static final RestTemplate TEMPLATE = new RestTemplateBuilder()
            .setConnectTimeout(Duration.ofSeconds(2))
            .setReadTimeout(Duration.ofSeconds(4))
            .build();

    private final MetricsDefinition metricsDefinition;

    @Scheduled(fixedDelay = 60000) //Every min waiting before execution
    private void refreshData() {
        ShellyMetricsResponse metrics = TEMPLATE.getForObject(URL, ShellyMetricsResponse.class);

        Optional.ofNullable(metrics)
                .map(ShellyMetricsResponse::getEmeters)
                .filter(emeters -> emeters.size() == 2)
                .ifPresentOrElse(emeters -> {
                    metricsDefinition.setMetricEmeter1(emeters.get(0));
                    metricsDefinition.setMetricEmeter2(emeters.get(1));
                }, () -> log.warn("Shelly response incomplete!"));
    }

}
