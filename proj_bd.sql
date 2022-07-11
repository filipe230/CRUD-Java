-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 26-Jan-2022 às 19:47
-- Versão do servidor: 10.4.22-MariaDB
-- versão do PHP: 7.3.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `proj_bd`
--
CREATE DATABASE IF NOT EXISTS `proj_bd` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `proj_bd`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `aposta`
--

CREATE TABLE `aposta` (
  `cod` int(11) NOT NULL,
  `esporte` varchar(10) DEFAULT NULL,
  `partida` varchar(100) DEFAULT NULL,
  `mercado` varchar(50) DEFAULT NULL,
  `valor` float DEFAULT NULL,
  `odd` float DEFAULT NULL,
  `lucro` float DEFAULT NULL,
  `acerto` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `aposta`
--

INSERT INTO `aposta` (`cod`, `esporte`, `partida`, `mercado`, `valor`, `odd`, `lucro`, `acerto`) VALUES
(6, 'Futebol', 'Brasil vs Argentina', 'Vitória - Brasil', 10, 1.8, 8, 1),
(7, 'Futsal', 'Argentina vs Brasil', 'Número de escanteios - +5', 10, 1.3, 3, 1),
(8, 'Futsal', 'Flamengo vs Flumengo', 'Vitória - Flamengo', 10, 1.2, 2, 1),
(9, 'Futsal', 'Brasil vs Argentina', 'Vitória - Brasil', 10, 1.8, -10, 0),
(10, 'Futsal', 'Brasil vs Alemanha', 'Vitória - Brasil', 10, 1.3, -10, 0);

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--

CREATE TABLE `cliente` (
  `id` int(11) NOT NULL,
  `nome` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL,
  `email` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL,
  `telefone` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL,
  `endereco` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL,
  `cpf` varchar(14) COLLATE utf8mb4_bin DEFAULT NULL,
  `senha` varchar(20) COLLATE utf8mb4_bin NOT NULL,
  `usuario` varchar(20) COLLATE utf8mb4_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Extraindo dados da tabela `cliente`
--

INSERT INTO `cliente` (`id`, `nome`, `email`, `telefone`, `endereco`, `cpf`, `senha`, `usuario`) VALUES
(1, 'Wesley', 'wesley@outlook.com', '+55 (66) 98484-6684', 'Rua Bahia, nº 100, Centro', '123.876.111-02', 'admin', 'wesley123'),
(2, 'Cleon', 'cleon@gmail.com', '+55 (64) 98181-1212', 'Avenida Góias, nº 999, Centro', '978.846.222-99', '123', 'cleon'),
(4, 'Teste', '', '', '', '', 'teste', 'teste'),
(5, 'Admin', '', '', '', '', '123', 'admin');

-- --------------------------------------------------------

--
-- Estrutura da tabela `docente`
--

CREATE TABLE `docente` (
  `id` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `idade` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `docente`
--

INSERT INTO `docente` (`id`, `nome`, `idade`) VALUES
(1, 'Cleon', 30),
(2, 'Wesley', 43),
(7, 'Wesley', 43);

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `aposta`
--
ALTER TABLE `aposta`
  ADD PRIMARY KEY (`cod`);

--
-- Índices para tabela `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `docente`
--
ALTER TABLE `docente`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `aposta`
--
ALTER TABLE `aposta`
  MODIFY `cod` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT de tabela `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de tabela `docente`
--
ALTER TABLE `docente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
