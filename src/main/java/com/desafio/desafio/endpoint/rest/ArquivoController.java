package com.desafio.desafio.endpoint.rest;

import com.desafio.desafio.usecase.CarregarArquivo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class ArquivoController {

    private CarregarArquivo carregarArquivo;
    @PostMapping("/upload-xml")
    public ResponseEntity uploadXmlFile(@RequestParam("file") MultipartFile file) {
        return carregarArquivo.executar(file);
    }

}
