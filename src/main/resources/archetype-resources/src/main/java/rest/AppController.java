#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.rest;

import ${package}.model.${firstModel};
import ${package}.dto.${firstModel}Response;
import ${package}.services.${firstModel}Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;
import static java.util.Collections.emptyList;

@RestController
@RequestMapping("${apiPrefix}")
@Slf4j
public class AppController {

    private final ${firstModel}Service service;

    @Autowired
    public AppController(${firstModel}Service service) {
        this.service = service;
    }

    @GetMapping("")
    public List<${firstModel}Response> get${firstModel}s() {
        log.info("get${firstModel}s");
        return emptyList();
    }

}
