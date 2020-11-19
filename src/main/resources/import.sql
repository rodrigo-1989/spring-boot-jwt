INSERT INTO clientes ( nombre, apellido, email, create_at, foto ) VALUES ( 'Julio', 'Lopez', 'julio@bolsadeideas.com', '2020-09-10', '' );
INSERT INTO clientes ( nombre, apellido, email, create_at, foto ) VALUES ( 'Leonel', 'Guzman', 'leonel@bolsadeideas.com', '2020-09-10', '' );
INSERT INTO clientes ( nombre, apellido, email, create_at, foto ) VALUES ( 'Erick', 'Lopez', 'julio@bolsadeideas.com', '2020-09-10', '' );
INSERT INTO clientes ( nombre, apellido, email, create_at, foto ) VALUES ( 'Julio', 'Lopez', 'julio@bolsadeideas.com', '2020-09-10', '' );
INSERT INTO clientes ( nombre, apellido, email, create_at, foto ) VALUES ( 'Leonel', 'Guzman', 'leonel@bolsadeideas.com', '2020-09-10', '' );
INSERT INTO clientes ( nombre, apellido, email, create_at, foto ) VALUES ( 'Erick', 'Lopez', 'julio@bolsadeideas.com', '2020-09-10', '' );
INSERT INTO clientes ( nombre, apellido, email, create_at, foto ) VALUES ( 'Julio', 'Lopez', 'julio@bolsadeideas.com', '2020-09-10', '' );
INSERT INTO clientes ( nombre, apellido, email, create_at, foto ) VALUES ( 'Leonel', 'Guzman', 'leonel@bolsadeideas.com', '2020-09-10', '' );
INSERT INTO clientes ( nombre, apellido, email, create_at, foto ) VALUES ( 'Erick', 'Lopez', 'julio@bolsadeideas.com', '2020-09-10', '' );
INSERT INTO clientes ( nombre, apellido, email, create_at, foto ) VALUES ( 'Julio', 'Lopez', 'julio@bolsadeideas.com', '2020-09-10', '' );
INSERT INTO clientes ( nombre, apellido, email, create_at, foto ) VALUES ( 'Leonel', 'Guzman', 'leonel@bolsadeideas.com', '2020-09-10', '' );
INSERT INTO clientes ( nombre, apellido, email, create_at, foto ) VALUES ( 'Erick', 'Lopez', 'julio@bolsadeideas.com', '2020-09-10', '' );
INSERT INTO clientes ( nombre, apellido, email, create_at, foto ) VALUES ( 'Julio', 'Lopez', 'julio@bolsadeideas.com', '2020-09-10', '' );
INSERT INTO clientes ( nombre, apellido, email, create_at, foto ) VALUES ( 'Leonel', 'Guzman', 'leonel@bolsadeideas.com', '2020-09-10', '' );
INSERT INTO clientes ( nombre, apellido, email, create_at, foto ) VALUES ( 'Erick', 'Lopez', 'julio@bolsadeideas.com', '2020-09-10', '' );
INSERT INTO clientes ( nombre, apellido, email, create_at, foto ) VALUES ( 'Julio', 'Lopez', 'julio@bolsadeideas.com', '2020-09-10', '' );
INSERT INTO clientes ( nombre, apellido, email, create_at, foto ) VALUES ( 'Leonel', 'Guzman', 'leonel@bolsadeideas.com', '2020-09-10', '' );
INSERT INTO clientes ( nombre, apellido, email, create_at, foto ) VALUES ( 'Erick', 'Lopez', 'julio@bolsadeideas.com', '2020-09-10', '' );
INSERT INTO clientes ( nombre, apellido, email, create_at, foto ) VALUES ( 'Julio', 'Lopez', 'julio@bolsadeideas.com', '2020-09-10', '' );
INSERT INTO clientes ( nombre, apellido, email, create_at, foto ) VALUES ( 'Leonel', 'Guzman', 'leonel@bolsadeideas.com', '2020-09-10', '' );
INSERT INTO clientes ( nombre, apellido, email, create_at, foto ) VALUES ( 'Erick', 'Lopez', 'julio@bolsadeideas.com', '2020-09-10', '' );
INSERT INTO clientes ( nombre, apellido, email, create_at, foto ) VALUES ( 'Julio', 'Lopez', 'julio@bolsadeideas.com', '2020-09-10', '' );
INSERT INTO clientes ( nombre, apellido, email, create_at, foto ) VALUES ( 'Leonel', 'Guzman', 'leonel@bolsadeideas.com', '2020-09-10', '' );
INSERT INTO clientes ( nombre, apellido, email, create_at, foto ) VALUES ( 'Erick', 'Lopez', 'julio@bolsadeideas.com', '2020-09-10', '' );
INSERT INTO clientes ( nombre, apellido, email, create_at, foto ) VALUES ( 'Julio', 'Lopez', 'julio@bolsadeideas.com', '2020-09-10', '' );
INSERT INTO clientes ( nombre, apellido, email, create_at, foto ) VALUES ( 'Leonel', 'Guzman', 'leonel@bolsadeideas.com', '2020-09-10', '' );
INSERT INTO clientes ( nombre, apellido, email, create_at, foto ) VALUES ( 'Erick', 'Lopez', 'julio@bolsadeideas.com', '2020-09-10', '' );

/*Tabla productos*/
INSERT INTO productos (nombre, precio, create_at ) VALUES ('Panasonic Pantalla LCD', 259990,NOW());
INSERT INTO productos (nombre, precio, create_at ) VALUES ('Sony Camara digital DSC-W320B', 123490,NOW());
INSERT INTO productos (nombre, precio, create_at ) VALUES ('Apple ipod Shuffle', 1499990,NOW());
INSERT INTO productos (nombre, precio, create_at ) VALUES ('Sony Notebook Z110', 37990,NOW());
INSERT INTO productos (nombre, precio, create_at ) VALUES ('Hewlett Packard Multifucional F2280', 69990,NOW());
INSERT INTO productos (nombre, precio, create_at ) VALUES ('Bianchi Bicicleta Aro 26', 799990,NOW());
INSERT INTO productos (nombre, precio, create_at ) VALUES ('Mica Comoda 5 cajones', 299990,NOW());
/*Tablas facturas*/
INSERT INTO facturas (descripcion, observacion,cliente_id, create_at ) VALUES ('Factura equipos de oficina', null, 1 ,NOW());
INSERT INTO facturas_items ( cantidad, factura_id, producto_id ) VALUES (1, 1, 1);
INSERT INTO facturas_items ( cantidad, factura_id, producto_id ) VALUES (2, 1, 4);
INSERT INTO facturas_items ( cantidad, factura_id, producto_id ) VALUES (1, 1, 5);
INSERT INTO facturas_items ( cantidad, factura_id, producto_id ) VALUES (1, 1, 7);

INSERT INTO facturas (descripcion, observacion,cliente_id, create_at ) VALUES ('Factura bicicleta', 'Alguna nota importante!', 1 ,NOW());
INSERT INTO facturas_items ( cantidad, factura_id, producto_id ) VALUES (3, 2, 6);

INSERT INTO users (username, password, enabled) VALUES ('julio','$2a$10$rzL45cn94rhG.Phn6j8PIe/gDeSeQis4htfHzl0vnJI8pqZ.QbkIC',1);
INSERT INTO users (username, password, enabled) VALUES ('admin','$2a$10$54/hPpqgNWwJwq4oESp1weZ49hvlAPdLllDuth0idevE1o9/fB7ji',1);

INSERT INTO authorities (user_id, authority) VALUES (1,'ROLE_USER');
INSERT INTO authorities (user_id, authority) VALUES (2,'ROLE_USER');
INSERT INTO authorities (user_id, authority) VALUES (2,'ROLE_ADMIN');




