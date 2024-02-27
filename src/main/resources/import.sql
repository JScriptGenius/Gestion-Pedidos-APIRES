
INSERT INTO tbl_clientes (id_cliente, nombre, email) VALUES (1, 'Cliente 1', 'cliente1@example.com');
INSERT INTO tbl_clientes (id_cliente, nombre, email) VALUES (2, 'Cliente 2', 'cliente2@example.com');
INSERT INTO tbl_clientes (id_cliente, nombre, email) VALUES (3, 'Cliente 3', 'cliente3@example.com');


INSERT INTO tbl_pedidos (id_pedido, numero_pedido, id_cliente) VALUES (1, 'P001', 1);
INSERT INTO tbl_pedidos (id_pedido, numero_pedido, id_cliente) VALUES (2, 'P002', 1);
INSERT INTO tbl_pedidos (id_pedido, numero_pedido, id_cliente) VALUES (3, 'P003', 3);


INSERT INTO tbl_productos (id_producto, nombre, precio) VALUES (1, 'Producto 1', 100.00);
INSERT INTO tbl_productos (id_producto, nombre, precio) VALUES (2, 'Producto 2', 50.00);
INSERT INTO tbl_productos (id_producto, nombre, precio) VALUES (3, 'Producto 3', 150.00);
INSERT INTO tbl_productos (id_producto, nombre, precio) VALUES (4, 'Producto 4', 200.00);


INSERT INTO tbl_detalles_pedido (id_detalle_pedido, id_pedido, id_producto, cantidad, precio_unitario) VALUES (1, 1, 1, 2, 100.00);
INSERT INTO tbl_detalles_pedido (id_detalle_pedido, id_pedido, id_producto, cantidad, precio_unitario) VALUES (2, 1, 2, 1, 50.00);
INSERT INTO tbl_detalles_pedido (id_detalle_pedido, id_pedido, id_producto, cantidad, precio_unitario) VALUES (3, 2, 3, 1, 150.00);
INSERT INTO tbl_detalles_pedido (id_detalle_pedido, id_pedido, id_producto, cantidad, precio_unitario) VALUES (4, 2, 4, 3, 200.00);
INSERT INTO tbl_detalles_pedido (id_detalle_pedido, id_pedido, id_producto, cantidad, precio_unitario) VALUES (5, 3, 1, 3, 100.00);
INSERT INTO tbl_detalles_pedido (id_detalle_pedido, id_pedido, id_producto, cantidad, precio_unitario) VALUES (6, 3, 2, 2, 50.00);

