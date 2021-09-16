CREATE TABLE `transacoes` (
  `id` int PRIMARY KEY,
  `ticker` varchar(255),
  `data` date,
  `preco` decimal,
  `quantidade` int,
  `tipo` varchar(255)
);

ALTER TABLE 'transacoes' MODIFY COLUMN 'id' INT  auto_increment;

ALTER TABLE `transacoes` MODIFY COLUMN `id` INT PRIMARY KEY AUTO_INCREMENT;


