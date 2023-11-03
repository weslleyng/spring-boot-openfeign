package dev.weslley.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Estado(@JsonProperty(value = "CodigoUf") String codigoUf, @JsonProperty(value = "Nome") String nome) {
}
