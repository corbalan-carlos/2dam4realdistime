DROP TABLE IF EXISTS venta;
DROP TABLE IF EXISTS vivienda;
DROP TABLE IF EXISTS comercial;

CREATE TABLE `comercial` (
  `dni` varchar(9) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `apellidos` varchar(60) NOT NULL
);
ALTER TABLE `comercial` ADD PRIMARY KEY (`dni`);
INSERT INTO `comercial` (`dni`, `nombre`, `apellidos`) VALUES
('11111111A', 'Carlos', 'Pérez García'),
('22222222B', 'Cristina', 'López Fernández'),
('33333333C', 'Nicolás', 'Gómez Ortuño'),
('44444444D', 'Carmelo', 'Pérez López');


CREATE TABLE `vivienda` (
  `id` int(11) NOT NULL,
  `direccion` varchar(70) NOT NULL,
  `habitaciones` int(11) NOT NULL,
  `bagnos` int(11) NOT NULL,
  `m2` double NOT NULL,
  `precio` double NOT NULL
) ;

ALTER TABLE `vivienda` ADD PRIMARY KEY (`id`);
INSERT INTO `vivienda` (`id`, `direccion`, `habitaciones`, `bagnos`, `m2`, `precio`) VALUES
(1, 'C/ Cartagena, 4, 3º A, Murcia', 2, 1, 100, 100999),
(2, 'Gran Vía, 5, 6º C, Murcia', 3, 2, 200, 300000),
(3, 'Av. Marqués de Rozalejo, 44, Los Alcázares', 4, 3, 60, 59999),
(4, 'Paseo Alfonso X, 55, 5ºB, Cartagena', 3, 1, 150, 350000),
(5, 'C/ Saavedra Fajardo, 23, 5ºC, Murcia', 2, 2, 55, 120000),
(6, 'C/ San Miguel, 8, 1ºD, Aljucer', 2, 2, 120, 30000),
(7, 'C/ General Martínez, 12, 4ºA, Cartagena', 3, 2, 100, 150000),
(8, 'C/ Pintor Miguel Ángel, 43, Bajo, Murcia', 4, 2, 152, 320000),
(9, 'C/ Simón García, 45, 1ºA, Murcia', 3, 2, 120, 128999),
(10, 'C/ Miguel de Unamuno, 12, 6ºC, Patiño', 3, 2, 90, 180000),
(11, 'Plaza Circular, 16, 3ºS, La Aljorra', 2, 1, 55, 39000),
(12, 'Plaza de España, 21, 1ºS, La Unión', 1, 1, 40, 45000),
(13, 'C/ del Carmen, 91, 2ºD, Cartagena', 1, 1, 35, 100000),
(14, 'C/ Maravillas, 17, 3ºB, La Manga', 2, 1, 60, 50500),
(15, 'Plaza del Ayuntamiento, 15, Bajo, Cartagena', 3, 2, 90, 200000);
ALTER TABLE `vivienda` MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;


CREATE TABLE `venta` (
  `vivienda` int(11) NOT NULL,
  `comercial` varchar(9) NOT NULL,
  `fecha` date NOT NULL
) ;

INSERT INTO `venta` (`vivienda`, `comercial`, `fecha`) VALUES
(2, '11111111A', '2022-02-01'),
(4, '33333333C', '2022-01-05'),
(5, '22222222B', '2022-03-01'),
(7, '11111111A', '2022-02-15'),
(9, '22222222B', '2022-01-13'),
(10, '22222222B', '2022-02-18'),
(15, '11111111A', '2022-03-09');
ALTER TABLE `venta`
  ADD CONSTRAINT `fk_venta_comercial` FOREIGN KEY (`comercial`) REFERENCES `comercial` (`dni`),
  ADD CONSTRAINT `fk_venta_vivienda` FOREIGN KEY (`vivienda`) REFERENCES `vivienda` (`id`);

ALTER TABLE `venta`
  ADD PRIMARY KEY (`vivienda`,`comercial`),
  ADD KEY `fk_venta_comercial` (`comercial`);



