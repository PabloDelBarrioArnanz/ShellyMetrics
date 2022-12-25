package com.delbarriopablo.shellymetrics;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShellyMetricsResponse {

    public List<Emeter> emeters;

    @Data
    public static class Emeter {
        public Double power;
        public Double reactive;
        public Double voltage;
        public Double total;
        @JsonProperty("total_returned")
        public Double totalReturned;
    }

}
