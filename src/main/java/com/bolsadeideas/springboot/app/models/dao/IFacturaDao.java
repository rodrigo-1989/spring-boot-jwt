package com.bolsadeideas.springboot.app.models.dao;

import com.bolsadeideas.springboot.app.models.entity.Factura;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IFacturaDao extends CrudRepository<Factura,Long> {
    //El siguiente metodo es para hacer una sola consulta mediate todas
    //las relaciones echas con Query

    @Query ("select f from Factura f join fetch f.cliente c  join fetch f.items l join fetch l.producto where f.id=?1")
    public Factura fetchByIdWithClienteWithItemFacturaWithProducto(Long id);
}
