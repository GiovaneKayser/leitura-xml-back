package com.desafio.desafio.usecase;

import com.desafio.desafio.domain.Agentes;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

public class CarregarArquivo {
    public ResponseEntity executar(MultipartFile file){
        try {
        InputStream inputStream = file.getInputStream();

        JAXBContext jaxbContext = JAXBContext.newInstance(Agentes.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        Agentes seuModeloXml = (Agentes) unmarshaller.unmarshal(inputStream);

        return new ResponseEntity<>("Arquivo XML carregado com sucesso", HttpStatus.OK);
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Falha ao carregar o arquivo XML", HttpStatus.BAD_REQUEST);
        }
    }
}
