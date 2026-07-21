-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 21/07/2026 às 03:12
-- Versão do servidor: 10.4.32-MariaDB
-- Versão do PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `pokedex`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `pokemon`
--

CREATE TABLE `pokemon` (
  `id` int(11) NOT NULL,
  `numero_pokedex` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `tipo` varchar(100) NOT NULL,
  `altura` double NOT NULL,
  `peso` double NOT NULL,
  `descricao` text DEFAULT NULL,
  `imagem` text DEFAULT NULL,
  `criado_em` timestamp NOT NULL DEFAULT current_timestamp(),
  `hp` int(11) DEFAULT NULL,
  `ataque` int(11) DEFAULT NULL,
  `defesa` int(11) DEFAULT NULL,
  `ataque_especial` int(11) DEFAULT NULL,
  `defesa_especial` int(11) DEFAULT NULL,
  `velocidade` int(11) DEFAULT NULL,
  `habilidades` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `pokemon`
--

INSERT INTO `pokemon` (`id`, `numero_pokedex`, `nome`, `tipo`, `altura`, `peso`, `descricao`, `imagem`, `criado_em`, `hp`, `ataque`, `defesa`, `ataque_especial`, `defesa_especial`, `velocidade`, `habilidades`) VALUES
(92, 25, 'pikachu', 'Elétrico', 4, 60, 'Quando vários desses POKéMON se reúnem, sua eletricidade pode aumentar e causar tempestades com raios.', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/25.png', '2026-07-20 15:48:59', 35, 55, 40, 50, 50, 90, 'estático'),
(93, 1, 'bulbassauro', 'Grama', 7, 69, 'Uma estranha semente foi plantada nas suas costas ao nascer. ', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png', '2026-07-20 15:49:09', 45, 49, 49, 65, 65, 45, 'crescer demais'),
(95, 3, 'venusauro', 'Grama', 20, 1000, 'A planta floresce quando absorve energia solar. ', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/3.png', '2026-07-20 15:49:37', 80, 82, 83, 100, 100, 80, 'crescer demais'),
(96, 6, 'charizard', 'Fogo', 17, 905, 'Diz-se que o fogo de Charizard queima mais se ele tiver passado por duras batalhas.', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/6.png', '2026-07-20 15:50:16', 78, 84, 78, 109, 85, 100, 'chama');

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `pokemon`
--
ALTER TABLE `pokemon`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `numero_pokedex` (`numero_pokedex`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `pokemon`
--
ALTER TABLE `pokemon`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=97;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
