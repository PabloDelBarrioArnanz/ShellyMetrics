package com.delbarriopablo.shellymetrics;

import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;


@Component
public class MetricsDefinition {

    private final ShellyMetricsResponse.Emeter emeter1 = new ShellyMetricsResponse.Emeter();
    private final ShellyMetricsResponse.Emeter emeter2 = new ShellyMetricsResponse.Emeter();

    public MetricsDefinition(MeterRegistry registry) {
        Gauge.builder("shelly.emiter_1.power", emeter1, ShellyMetricsResponse.Emeter::getPower)
                .register(registry);
        Gauge.builder("shelly.emiter_1.reactive", emeter1, ShellyMetricsResponse.Emeter::getReactive)
                .register(registry);
        Gauge.builder("shelly.emiter_1.voltage", emeter1, ShellyMetricsResponse.Emeter::getVoltage)
                .register(registry);
        Gauge.builder("shelly.emiter_1.total", emeter1, ShellyMetricsResponse.Emeter::getTotal)
                .register(registry);
        Gauge.builder("shelly.emiter_1.totalReturned", emeter1, ShellyMetricsResponse.Emeter::getTotalReturned)
                .register(registry);

        Gauge.builder("shelly.emiter_2.power", emeter2, ShellyMetricsResponse.Emeter::getPower)
                .register(registry);
        Gauge.builder("shelly.emiter_2.reactive", emeter2, ShellyMetricsResponse.Emeter::getReactive)
                .register(registry);
        Gauge.builder("shelly.emiter_2.voltage", emeter2, ShellyMetricsResponse.Emeter::getVoltage)
                .register(registry);
        Gauge.builder("shelly.emiter_2.total", emeter2, ShellyMetricsResponse.Emeter::getTotal)
                .register(registry);
        Gauge.builder("shelly.emiter_2.totalReturned", emeter2, ShellyMetricsResponse.Emeter::getTotalReturned)
                .register(registry);
    }

    public void setMetricEmeter1(ShellyMetricsResponse.Emeter emeter) {
        this.emeter1.power = emeter.power;
        this.emeter1.reactive = emeter.reactive;
        this.emeter1.voltage = emeter.voltage;
        this.emeter1.total = emeter.total;
        this.emeter1.totalReturned = emeter.totalReturned;
    }
    public void setMetricEmeter2(ShellyMetricsResponse.Emeter emeter) {
        this.emeter2.power = emeter.power;
        this.emeter2.reactive = emeter.reactive;
        this.emeter2.voltage = emeter.voltage;
        this.emeter2.total = emeter.total;
        this.emeter2.totalReturned = emeter.totalReturned;
    }
}
