--Inserscion de empleados
INSERT INTO colaborador.empleado VALUES ('usuario1', 'password1', 'Juan Pérez', 1);
INSERT INTO colaborador.empleado VALUES ('usuario2', 'password2', 'María García', 1);
INSERT INTO colaborador.empleado VALUES ('usuario3', 'password3', 'Pedro Hernández', 1);
INSERT INTO colaborador.planilla VALUES('usuario1','S0001');
INSERT INTO colaborador.planilla VALUES('usuario2','S0001');
INSERT INTO colaborador.planilla VALUES('usuario3','S0001');

INSERT INTO colaborador.empleado VALUES ('usuario4', 'password4', 'Ana López', 1);
INSERT INTO colaborador.empleado VALUES ('usuario5', 'password5', 'Jorge Fernández', 1);
INSERT INTO colaborador.empleado VALUES ('usuario6', 'password6', 'Carla Gómez', 1);
INSERT INTO colaborador.planilla VALUES('usuario4','S0002');
INSERT INTO colaborador.planilla VALUES('usuario5','S0002');
INSERT INTO colaborador.planilla VALUES('usuario6','S0002');


INSERT INTO colaborador.empleado VALUES ('usuario7', 'password7', 'Ricardo Martínez', 1);
INSERT INTO colaborador.empleado VALUES ('usuario8', 'password8', 'Sofía Rodríguez', 1);
INSERT INTO colaborador.empleado VALUES ('usuario9', 'password9', 'Alejandro Pérez', 1);
INSERT INTO colaborador.planilla VALUES('usuario7','S0003');
INSERT INTO colaborador.planilla VALUES('usuario8','S0003');
INSERT INTO colaborador.planilla VALUES('usuario9','S0003');

INSERT INTO colaborador.empleado VALUES ('usuario10', 'password10', 'Juan ALberto', 2);
INSERT INTO colaborador.empleado VALUES ('usuario11', 'password11', 'Lucia García', 2);
INSERT INTO colaborador.empleado VALUES ('usuario12', 'password12', 'Ana López', 2);
INSERT INTO colaborador.planilla VALUES('usuario10','S0001');
INSERT INTO colaborador.planilla VALUES('usuario11','S0002');
INSERT INTO colaborador.planilla VALUES('usuario12','S0003');


INSERT INTO colaborador.empleado VALUES ('usuario13', 'password13', 'Pedro Martínez', 3);
INSERT INTO colaborador.empleado VALUES ('usuario14', 'password14', 'Laura Ruiz', 3);
INSERT INTO colaborador.empleado VALUES ('usuario15', 'password15', 'Carlos González', 3);
INSERT INTO colaborador.empleado VALUES ('usuario16', 'password16', 'Sofía Hernández', 3);

INSERT INTO colaborador.empleado VALUES ('usuario17', 'password17', 'Lucas Sánchez', 4);

-- Productos de electrodomésticos

INSERT INTO mercancia.producto
VALUES 
('P0001', 'Lavadora de carga frontal', 'Samsung', 749.99, 'Lavadora de ropa con capacidad de carga frontal de 10 kg.'),
('P0002', 'Refrigerador con congelador superior', 'LG', 599.99, 'Refrigerador con capacidad de almacenamiento de 500 litros y congelador superior.'),
('P0003', 'Horno microondas', 'Panasonic', 149.99, 'Horno microondas de 1000 vatios de potencia y capacidad de 25 litros.'),
('P0004', 'Licuadora de alta velocidad', 'Vitamix', 599.99, 'Licuadora con motor de alta velocidad de 2 caballos de fuerza y cuchillas de acero inoxidable.'),
('P0005', 'Aspiradora inalámbrica', 'Dyson', 399.99, 'Aspiradora inalámbrica con potencia de succión de 150 AW y batería recargable.'),
('P0006', 'Cafetera programable', 'Cuisinart', 99.99, 'Cafetera con capacidad para 12 tazas y función de programación de 24 horas.'),
('P0007', 'Freidora de aire', 'Ninja', 149.99, 'Freidora de aire con capacidad de 4 cuartos y pantalla táctil.'),
('P0008', 'Tostadora de 4 rebanadas', 'KitchenAid', 79.99, 'Tostadora de 4 rebanadas con configuraciones de tostado personalizadas.'),
('P0009', 'Robot de cocina', 'Ninja', 199.99, 'Robot de cocina con capacidad de 6.5 cuartos y múltiples opciones de cocción.'),
('P0010', 'Batidora de mano', 'Braun', 49.99, 'Batidora de mano con múltiples velocidades y accesorios intercambiables.'),
('P0011', 'Lavaplatos compacto', 'Whirlpool', 399.99, 'Lavaplatos compacto con capacidad de 8 cubiertos y múltiples configuraciones de lavado.'),
('P0012', 'Robot aspirador', 'iRobot', 299.99, 'Robot aspirador con navegación inteligente y capacidad de programación.'),
('P0013', 'Plancha de vapor', 'Rowenta', 99.99, 'Plancha de vapor con potencia de 1800 vatios y función de vapor vertical.'),
('P0014', 'Máquina de café espresso', 'DeLonghi', 499.99, 'Máquina de café espresso con sistema de leche automático y pantalla táctil.'),
('P0015', 'Procesador de alimentos', 'Cuisinart', 149.99, 'Procesador de alimentos con capacidad de 11 tazas y múltiples discos de corte.'),
('P0016', 'Parrilla eléctrica', 'George Foreman', 59.99, 'Parrilla eléctrica con capacidad de cocinar 4 porciones a la vez y bandeja de goteo removible.'),
('P0017', 'Licuadora de inmersión', 'Breville', 79.99, 'Licuadora de inmersión con múltiples velocidades y accesorios intercambiables.'),
('P0018', 'Hervidor eléctrico', 'Krups', 39.99, 'Hervidor eléctrico con capacidad de 1.7 litros y función de apagado automático.'),
('P0019', 'Máquina de hacer pan', 'Zojirushi', 249.99, 'Máquina de hacer pan con múltiples configuraciones de horneado y capacidad de hacer pan sin gluten.'),
('P0020', 'Freidora de aceite', 'T-fal', 89.99, 'Freidora de aceite con capacidad de 3.5 litros y función de temporizador.'),
('P0021', 'Refrigerador Side by Side', 'LG', 999.99, 'Capacidad de 600 litros, dispensador de agua y hielo en la puerta.'),
('P0022', 'Lavadora con secadora integrada', 'Samsung', 799.99, 'Capacidad de 10 kg, función de secado y tecnología EcoBubble.'),
('P0023', 'Horno de microondas', 'Panasonic', 149.99, 'Capacidad de 1.2 pies cúbicos, función de descongelado y sensor de cocción.'),
('P0024', 'Aspiradora inalámbrica', 'Dyson', 399.99, 'Sin cable, con tecnología Cyclone y capacidad de 0.5 litros.'),
('P0025', 'Licuadora de alta potencia', 'Ninja', 129.99, 'Motor de 1000 vatios, capacidad de 72 onzas y tecnología Auto-iQ.'),
('P0026', 'Cafetera de goteo', 'Hamilton Beach', 59.99, 'Capacidad para 12 tazas, función de programación y apagado automático.'),
('P0027', 'Plancha a vapor', 'Rowenta', 89.99, 'Potencia de 1800 vatios, capacidad de 350 ml y función de apagado automático.'),
('P0028', 'Batidora de mano', 'KitchenAid', 99.99, '5 velocidades, accesorios intercambiables y motor de corriente continua.'),
('P0029', 'Horno tostador', 'Black+Decker', 79.99, 'Capacidad de 4 rebanadas de pan o una pizza de 9 pulgadas, con función de convección y timer de 30 minutos.'),
('P0030', 'Purificador de aire', 'Blueair', 249.99, 'Filtro HEPA, capacidad para habitaciones grandes y bajo consumo de energía.'),
('P0031', 'Lavadora automática', 'LG', 699.99, 'Capacidad de 10 kg y 12 programas de lavado'),
('P0032', 'Refrigerador', 'Samsung', 899.99, 'Doble puerta y dispensador de agua y hielo'),
('P0033', 'Horno eléctrico', 'Whirlpool', 349.99, 'Capacidad de 50 litros y convección'),
('P0034', 'Aspiradora sin bolsa', 'Dyson', 499.99, 'Potente succión y filtro HEPA'),
('P0035', 'Cafetera automática', 'Nespresso', 199.99, 'Compatible con cápsulas y espumador de leche'),
('P0036', 'Microondas con grill', 'Panasonic', 129.99, 'Capacidad de 20 litros y potencia de 1000W'),
('P0037', 'Licuadora de alta potencia', 'Oster', 159.99, 'Motor de 1200W y vaso de vidrio resistente'),
('P0038', 'Batidora de mano', 'KitchenAid', 89.99, 'Varillas de acero inoxidable y 5 velocidades'),
('P0039', 'Plancha de vapor', 'Rowenta', 69.99, 'Potencia de 2400W y suela de cerámica'),
('P0040', 'Secadora de ropa', 'Bosch', 799.99, 'Capacidad de 8 kg y bomba de calor'),
('P0041', 'Televisor 4K', 'Sony', 1299.99, 'Pantalla de 65 pulgadas y tecnología HDR'),
('P0042', 'Lavaplatos', 'Miele', 1499.99, 'Capacidad de 14 cubiertos y eficiencia energética A+++'),
('P0043', 'Robot aspirador', 'iRobot', 699.99, 'Programable con app y navegación láser'),
('P0044', 'Freidora sin aceite', 'Philips', 179.99, 'Capacidad de 1.2 kg y tecnología Rapid Air'),
('P0045', 'Batidora de vaso', 'Moulinex', 79.99, 'Jarra de cristal y 6 cuchillas de acero inoxidable'),
('P0046', 'Plancha de cabello', 'GHD', 199.99, 'Tecnología cerámica y temperatura ajustable'),
('P0047', 'Ventilador de torre', 'Dyson', 399.99, 'Oscilación de 350 grados y control remoto'),
('P0048', 'Calefactor eléctrico', 'DeLonghi', 119.99, 'Termostato ajustable y función de ventilación'),
('P0049', 'Tostadora automática', 'Breville', 99.99, 'Ranuras extra anchas y 6 niveles de tostado'),
('P0050', 'Exprimidor de cítricos', 'Taurus', 39.99, 'Cono doble para diferentes tamaños de frutas')
('P0051', 'Cafetera espresso', 'DeLonghi', 399.99, 'Caldera de acero inoxidable y espumador de leche'),
('P0052', 'Licuadora', 'Oster', 139.99, 'Jarra de vidrio y 2 velocidades'),
('P0053', 'Horno de convección', 'Black and Decker', 179.99, 'Capacidad de 22 litros y temperatura ajustable'),
('P0054', 'Afeitadora eléctrica', 'Philips', 179.99, 'Cabezales flexibles y uso en húmedo y seco'),
('P0055', 'Hervidor eléctrico', 'Russell Hobbs', 49.99, 'Capacidad de 1.7 litros y apagado automático'),
('P0056', 'Aspiradora de mano', 'Dirt Devil', 59.99, 'Conexión al encendedor del coche y cepillo para tapicería'),
('P0057', 'Báscula de cocina', 'Taylor', 29.99, 'Capacidad de 5 kg y pantalla LCD'),
('P0058', 'Ventilador de mesa', 'Rowenta', 59.99, 'Diámetro de 30 cm y 3 velocidades'),
('P0059', 'Microondas', 'Panasonic', 229.99, 'Capacidad de 1.3 pies cúbicos y 10 niveles de potencia'),
('P0060', 'Plancha de ropa', 'Rowenta', 89.99, 'Vapor vertical y suela de cerámica'),
('P0061', 'Licuadora de alta velocidad', 'Oster', 149.99, '6 cuchillas de acero inoxidable y 8 velocidades'),
('P0062', 'Aspiradora sin bolsa', 'Dyson', 349.99, 'Tecnología Radial Root Cyclone y filtro HEPA'),
('P0063', 'Batidora de mano', 'KitchenAid', 99.99, '5 velocidades y accesorios para batir y mezclar'),
('P0064', 'Lavavajillas integrable', 'Bosch', 799.99, '14 servicios, 6 programas y sistema AquaStop'),
('P0065', 'Microondas con grill', 'Samsung', 199.99, '20 litros de capacidad y 6 niveles de potencia'),
('P0066', 'Cocina de inducción', 'Whirlpool', 1299.99, '5 zonas de cocción, horno multifunción y limpieza pirolítica'),
('P0067', 'Nevera americana', 'LG', 2499.99, 'Dispensador de agua y hielo, 601 litros de capacidad'),
('P0068', 'Robot de cocina', 'Moulinex', 399.99, '12 programas, báscula integrada y libro de recetas'),
('P0069', 'Plancha de vapor', 'Rowenta', 89.99, 'Potencia de 3000W y suela Microsteam 400'),
('P0070', 'Aire acondicionado portátil', 'Hisense', 449.99, 'Capacidad de refrigeración de 12.000 BTU y temporizador programable');

--Stock sucursal Central
INSERT INTO mercancia.stock VALUES ('P0001', 'S0001', 5);
INSERT INTO mercancia.stock VALUES ('P0002', 'S0001', 2);
INSERT INTO mercancia.stock VALUES ('P0003', 'S0001', 9);
INSERT INTO mercancia.stock VALUES ('P0004', 'S0001', 6);
INSERT INTO mercancia.stock VALUES ('P0005', 'S0001', 8);
INSERT INTO mercancia.stock VALUES ('P0006', 'S0001', 3);
INSERT INTO mercancia.stock VALUES ('P0007', 'S0001', 1);
INSERT INTO mercancia.stock VALUES ('P0008', 'S0001', 4);
INSERT INTO mercancia.stock VALUES ('P0009', 'S0001', 7);
INSERT INTO mercancia.stock VALUES ('P0010', 'S0001', 10);
INSERT INTO mercancia.stock VALUES ('P0011', 'S0001', 2);
INSERT INTO mercancia.stock VALUES ('P0012', 'S0001', 7);
INSERT INTO mercancia.stock VALUES ('P0013', 'S0001', 3);
INSERT INTO mercancia.stock VALUES ('P0014', 'S0001', 10);
INSERT INTO mercancia.stock VALUES ('P0015', 'S0001', 1);
INSERT INTO mercancia.stock VALUES ('P0016', 'S0001', 8);
INSERT INTO mercancia.stock VALUES ('P0017', 'S0001', 5);
INSERT INTO mercancia.stock VALUES ('P0018', 'S0001', 6);
INSERT INTO mercancia.stock VALUES ('P0019', 'S0001', 3);
INSERT INTO mercancia.stock VALUES ('P0020', 'S0001', 4);
INSERT INTO mercancia.stock VALUES ('P0021', 'S0001', 7);
INSERT INTO mercancia.stock VALUES ('P0022', 'S0001', 5);
INSERT INTO mercancia.stock VALUES ('P0023', 'S0001', 1);
INSERT INTO mercancia.stock VALUES ('P0024', 'S0001', 9);
INSERT INTO mercancia.stock VALUES ('P0025', 'S0001', 6);
INSERT INTO mercancia.stock VALUES ('P0026', 'S0001', 4);
INSERT INTO mercancia.stock VALUES ('P0027', 'S0001', 8);
INSERT INTO mercancia.stock VALUES ('P0028', 'S0001', 2);
INSERT INTO mercancia.stock VALUES ('P0029', 'S0001', 1);
INSERT INTO mercancia.stock VALUES ('P0030', 'S0001', 3);

--Stock sucursal Norte
INSERT INTO mercancia.stock VALUES ('P0031', 'S0002', 5);
INSERT INTO mercancia.stock VALUES ('P0032', 'S0002', 3);
INSERT INTO mercancia.stock VALUES ('P0033', 'S0002', 7);
INSERT INTO mercancia.stock VALUES ('P0034', 'S0002', 1);
INSERT INTO mercancia.stock VALUES ('P0035', 'S0002', 8);
INSERT INTO mercancia.stock VALUES ('P0036', 'S0002', 2);
INSERT INTO mercancia.stock VALUES ('P0037', 'S0002', 10);
INSERT INTO mercancia.stock VALUES ('P0038', 'S0002', 4);
INSERT INTO mercancia.stock VALUES ('P0039', 'S0002', 6);
INSERT INTO mercancia.stock VALUES ('P0040', 'S0002', 9);
INSERT INTO mercancia.stock VALUES ('P0041', 'S0002', 5);
INSERT INTO mercancia.stock VALUES ('P0042', 'S0002', 3);
INSERT INTO mercancia.stock VALUES ('P0043', 'S0002', 7);
INSERT INTO mercancia.stock VALUES ('P0044', 'S0002', 1);
INSERT INTO mercancia.stock VALUES ('P0045', 'S0002', 8);
INSERT INTO mercancia.stock VALUES ('P0046', 'S0002', 2);
INSERT INTO mercancia.stock VALUES ('P0047', 'S0002', 10);
INSERT INTO mercancia.stock VALUES ('P0048', 'S0002', 4);
INSERT INTO mercancia.stock VALUES ('P0049', 'S0002', 6);
INSERT INTO mercancia.stock VALUES ('P0050', 'S0002', 9);
INSERT INTO mercancia.stock VALUES ('P0051', 'S0002', 5);
INSERT INTO mercancia.stock VALUES ('P0052', 'S0002', 3);
INSERT INTO mercancia.stock VALUES ('P0053', 'S0002', 7);
INSERT INTO mercancia.stock VALUES ('P0054', 'S0002', 1);
INSERT INTO mercancia.stock VALUES ('P0055', 'S0002', 8);

--Stock sucursal Sur
INSERT INTO mercancia.stock VALUES ('P0056', 'S0003', 1);
INSERT INTO mercancia.stock VALUES ('P0057', 'S0003', 5);
INSERT INTO mercancia.stock VALUES ('P0058', 'S0003', 8);
INSERT INTO mercancia.stock VALUES ('P0059', 'S0003', 3);
INSERT INTO mercancia.stock VALUES ('P0060', 'S0003', 6);
INSERT INTO mercancia.stock VALUES ('P0061', 'S0003', 2);
INSERT INTO mercancia.stock VALUES ('P0062', 'S0003', 9);
INSERT INTO mercancia.stock VALUES ('P0063', 'S0003', 4);
INSERT INTO mercancia.stock VALUES ('P0064', 'S0003', 7);
INSERT INTO mercancia.stock VALUES ('P0065', 'S0003', 10);
INSERT INTO mercancia.stock VALUES ('P0066', 'S0003', 1);
INSERT INTO mercancia.stock VALUES ('P0067', 'S0003', 5);
INSERT INTO mercancia.stock VALUES ('P0068', 'S0003', 8);
INSERT INTO mercancia.stock VALUES ('P0069', 'S0003', 3);
INSERT INTO mercancia.stock VALUES ('P0070', 'S0003', 6);

--Productos de bodega
INSERT INTO mercancia.bodega VALUES ('P0001', 5);
INSERT INTO mercancia.bodega VALUES ('P0003', 7);
INSERT INTO mercancia.bodega VALUES ('P0005', 9);
INSERT INTO mercancia.bodega VALUES ('P0007', 11);
INSERT INTO mercancia.bodega VALUES ('P0009', 13);
INSERT INTO mercancia.bodega VALUES ('P0011', 15);
INSERT INTO mercancia.bodega VALUES ('P0013', 5);
INSERT INTO mercancia.bodega VALUES ('P0015', 7);
INSERT INTO mercancia.bodega VALUES ('P0017', 9);
INSERT INTO mercancia.bodega VALUES ('P0019', 11);
INSERT INTO mercancia.bodega VALUES ('P0021', 13);
INSERT INTO mercancia.bodega VALUES ('P0023', 15);
INSERT INTO mercancia.bodega VALUES ('P0025', 5);
INSERT INTO mercancia.bodega VALUES ('P0027', 7);
INSERT INTO mercancia.bodega VALUES ('P0029', 9);
INSERT INTO mercancia.bodega VALUES ('P0031', 11);
INSERT INTO mercancia.bodega VALUES ('P0033', 13);
INSERT INTO mercancia.bodega VALUES ('P0035', 15);
INSERT INTO mercancia.bodega VALUES ('P0037', 5);
INSERT INTO mercancia.bodega VALUES ('P0039', 7);
INSERT INTO mercancia.bodega VALUES ('P0041', 9);
INSERT INTO mercancia.bodega VALUES ('P0043', 11);
INSERT INTO mercancia.bodega VALUES ('P0045', 13);
INSERT INTO mercancia.bodega VALUES ('P0047', 15);
INSERT INTO mercancia.bodega VALUES ('P0049', 5);
INSERT INTO mercancia.bodega VALUES ('P0051', 7);
INSERT INTO mercancia.bodega VALUES ('P0053', 9);
INSERT INTO mercancia.bodega VALUES ('P0055', 11);
INSERT INTO mercancia.bodega VALUES ('P0057', 13);
INSERT INTO mercancia.bodega VALUES ('P0059', 15);