package br.com.mariorusso.agenda.empresa.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mariorusso.agenda.empresa.entity.EmpressaEntity;

@RequestMapping
@RestController
public class EmpressaController {
    @GetMapping
    public ResponseEntity<EmpressaEntity> listar() {
        EmpressaEntity empressa = new EmpressaEntity("empressa", "empressa", "rua 10- ", "eletrica");
        return ResponseEntity.status(200).body(empressa);
    }
}
