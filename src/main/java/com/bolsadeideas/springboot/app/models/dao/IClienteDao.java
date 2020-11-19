package com.bolsadeideas.springboot.app.models.dao;

import com.bolsadeideas.springboot.app.models.entity.Factura;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.bolsadeideas.springboot.app.models.entity.Cliente;

public interface IClienteDao extends PagingAndSortingRepository<Cliente, Long>{
    //Recordar que el 1 despues de where significa el parametro id que le estamos pasando
    //si tubuese dos parametros el siguiente parametro seria el 2
    @Query("select c from Cliente c left join fetch c.facturas f where c.id=?1")
    public Cliente fetchByIdWithFacturas(Long id);
}
