package dev.weslley.feign;

import dev.weslley.model.Estado;
import dev.weslley.model.ResponseData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "estadosCidadesService", url = "https://raw.githubusercontent.com/weslleyng/Estados-Cidades-IBGE/master/json/")
public interface EstadosCidadesService {


    @GetMapping(value = "estados.json")
    ResponseData<Estado> getEstados();


}
