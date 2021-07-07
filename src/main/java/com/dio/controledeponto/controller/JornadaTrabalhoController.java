package com.dio.controledeponto.controller;

import com.dio.controledeponto.model.JornadaTrabalho;
import com.dio.controledeponto.service.JornadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jornada")
public class JornadaTrabalhoController {

    @Autowired
    JornadaService jornadaService;

    @PostMapping
    public JornadaTrabalho createJornada(@RequestBody JornadaTrabalho jornadaTrabalho){
        return jornadaService.save(jornadaTrabalho);
    }
    @GetMapping
    public List<JornadaTrabalho> findAll(){
        return jornadaService.findAll();
    }
    @GetMapping("/{idJornada}")
    public ResponseEntity<JornadaTrabalho> getJornadaById(@PathVariable("idJornada") Long idJornada) throws Exception {
        return ResponseEntity.ok(jornadaService.getById(idJornada).orElseThrow(() -> new Exception("Jornada não Encontrada")));
    }
    @PutMapping
    public JornadaTrabalho update(@RequestBody JornadaTrabalho jornadaTrabalho){
        return jornadaService.update(jornadaTrabalho);
    }
    @DeleteMapping(value = "/{idJornada}")
    public ResponseEntity<JornadaTrabalho> delete(@PathVariable Long idJornada) {

            jornadaService.delete(idJornada);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
