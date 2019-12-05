package br.com.lucasromagnoli.prbrsj.rest.controller;

import br.com.lucasromagnoli.prbrsj.domain.support.PrbrsjPropertiesSupport;
import br.com.lucasromagnoli.prbrsj.rest.constants.ControllerMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ControllerMapping.PATH_ROOT_USER)
public class UserRestController {
    @Autowired
    private PrbrsjPropertiesSupport prbrsjPropertiesSupport;

    @GetMapping()
    @PreAuthorize("hasAuthority('ROLE_ADMIN') and #oauth2.hasScope('read')")
    public ResponseEntity index() {
        prbrsjPropertiesSupport.getProperty("teste.nome");
        return ResponseEntity.ok("UserRestController --> index() --> ok()");
    }

}
