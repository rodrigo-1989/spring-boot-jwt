package com.bolsadeideas.springboot.app.controllers;

import com.bolsadeideas.springboot.app.models.service.IClienteService;
import com.bolsadeideas.springboot.app.view.xml.ClienteList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteRestController {
    @Autowired
    private IClienteService clienteService;
    //Este metodo es el encargado de mandar a todos los clientes en formato JSON
    @GetMapping(value = "/listar")
    public  ClienteList listar() {
            //EN la siguiente instancia se crea una lista apartir de la clase ClienteList
        //Con el echo de obtener tanto formato JSON como formato xml siempre especificando en la url
        //http://localhost:8080/api/clientes/listar?format=json <----   listar?format=xml
        return new ClienteList(clienteService.findAll());
    }
}
