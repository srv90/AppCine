-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 06-11-2019 a las 02:27:49
-- Versión del servidor: 10.1.40-MariaDB
-- Versión de PHP: 7.1.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `appcine`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `banners`
--

CREATE TABLE `banners` (
  `id` int(11) NOT NULL,
  `titulo` varchar(250) NOT NULL,
  `fecha` date NOT NULL,
  `archivo` varchar(250) NOT NULL,
  `estatus` enum('Activo','Inactivo') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `banners`
--

INSERT INTO `banners` (`id`, `titulo`, `fecha`, `archivo`, `estatus`) VALUES
(9, 'Joker', '2019-10-13', 'jokerbanner.jpg', 'Activo'),
(10, 'Ad Astra: hacia las estrellas', '2019-10-13', 'adastrabanner (1).jpg', 'Activo'),
(12, 'Rambo: la última misión', '2019-10-13', 'rambobanner (1).jpg', 'Activo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalles`
--

CREATE TABLE `detalles` (
  `id` int(11) NOT NULL,
  `director` varchar(100) DEFAULT NULL,
  `actores` varchar(255) DEFAULT NULL,
  `sinopsis` text,
  `trailer` varchar(255) DEFAULT NULL COMMENT 'URL del video en Youtube\n'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `detalles`
--

INSERT INTO `detalles` (`id`, `director`, `actores`, `sinopsis`, `trailer`) VALUES
(13, ' James Gray', 'Brad Pitt, Tommy Lee Jones, Ruth Negga, Donald Sutherland', 'Roy McBride es un ingeniero que perdió a su padre en una misión sin retorno a Neptuno para encontrar signos de inteligencia extraterrestre. 20 años después, emprenderá su propio viaje a través del sistema solar para tratar de encontrarlo de nuevo y resolver los misterios del porqué esa primera misión fracasó.', 'https://www.youtube.com/embed/3tg-vs1KZEU'),
(29, 'Adrian Grunberg', 'Sylvester Stallone&#8206;', 'John Rambo está en horas bajas y viviendo en un rancho en Arizona, pero cuando recibe la noticia de que su nieta ha desaparecido, tras haber cruzado la frontera a México para ir a una fiesta, Rambo decide ir en su búsqueda.', 'https://www.youtube.com/embed/Hs0-GP0GnjA'),
(30, 'Todd Phillips', 'Joaquin Phoenix, Robert De Niro', 'La pasión de Arthur Fleck, un hombre ignorado por la sociedad, es hacer reír a la gente. Sin embargo, una serie de trágicos sucesos harán que su visión del mundo se distorsione considerablemente convirtiéndolo en un brillante criminal', 'https://www.youtube.com/embed/IfB65qjLbwc'),
(31, 'Andrés Muschietti', 'Jessica Chastain. James McAvoy. Bill Hader. Isaiah Mustafa. Jay Ryan. ', 'En el misterioso pueblo de Derry, un malvado payaso llamado Pennywise vuelve 27 años después para atormentar a los ya adultos miembros del Club de los Perdedores, que ahora están más alejados unos de otros.', ' https://www.youtube.com/embed/woh3bk8DXVo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `horarios`
--

CREATE TABLE `horarios` (
  `id` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `hora` time NOT NULL,
  `sala` varchar(100) NOT NULL,
  `precio` double NOT NULL DEFAULT '0',
  `idPelicula` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `noticias`
--

CREATE TABLE `noticias` (
  `id` int(11) NOT NULL,
  `titulo` varchar(250) NOT NULL,
  `fecha` date NOT NULL,
  `detalle` text NOT NULL,
  `estatus` enum('Activa','Inactiva') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `noticias`
--

INSERT INTO `noticias` (`id`, `titulo`, `fecha`, `detalle`, `estatus`) VALUES
(1, '\'El Camino: Una película de Breaking Bad\'', '2019-10-13', '<p><span style=\"color: #333333; font-family: \'Source Sans Pro\', -apple-system, BlinkMacSystemFont, \'Segoe UI\', Roboto, Oxygen, Ubuntu, Cantarell, \'Open Sans\', \'Helvetica Neue\', sans-serif; font-size: 20px;\">Este viernes 11 de octubre lleg&oacute; a&nbsp;</span><span style=\"font-weight: bold; color: #333333; font-family: \'Source Sans Pro\', -apple-system, BlinkMacSystemFont, \'Segoe UI\', Roboto, Oxygen, Ubuntu, Cantarell, \'Open Sans\', \'Helvetica Neue\', sans-serif; font-size: 20px;\">Netflix</span><span style=\"color: #333333; font-family: \'Source Sans Pro\', -apple-system, BlinkMacSystemFont, \'Segoe UI\', Roboto, Oxygen, Ubuntu, Cantarell, \'Open Sans\', \'Helvetica Neue\', sans-serif; font-size: 20px;\">&nbsp;</span><a style=\"color: #307064; font-family: \'Source Sans Pro\', -apple-system, BlinkMacSystemFont, \'Segoe UI\', Roboto, Oxygen, Ubuntu, Cantarell, \'Open Sans\', \'Helvetica Neue\', sans-serif; font-size: 20px;\" href=\"https://www.espinof.com/criticas/camino-pelicula-breaking-bad-secuela-netflix-epilogo-que-jesse-pinkman-merecia\">\'El Camino: Una pel&iacute;cula de Breaking Bad\'</a><span style=\"color: #333333; font-family: \'Source Sans Pro\', -apple-system, BlinkMacSystemFont, \'Segoe UI\', Roboto, Oxygen, Ubuntu, Cantarell, \'Open Sans\', \'Helvetica Neue\', sans-serif; font-size: 20px;\">, la esperada secuela de&nbsp;</span><a style=\"color: #307064; font-family: \'Source Sans Pro\', -apple-system, BlinkMacSystemFont, \'Segoe UI\', Roboto, Oxygen, Ubuntu, Cantarell, \'Open Sans\', \'Helvetica Neue\', sans-serif; font-size: 20px;\" href=\"https://www.espinof.com/tag/breaking-bad\">la serie</a><span style=\"color: #333333; font-family: \'Source Sans Pro\', -apple-system, BlinkMacSystemFont, \'Segoe UI\', Roboto, Oxygen, Ubuntu, Cantarell, \'Open Sans\', \'Helvetica Neue\', sans-serif; font-size: 20px;\">&nbsp;protagonizada por&nbsp;</span><span style=\"font-weight: bold; color: #333333; font-family: \'Source Sans Pro\', -apple-system, BlinkMacSystemFont, \'Segoe UI\', Roboto, Oxygen, Ubuntu, Cantarell, \'Open Sans\', \'Helvetica Neue\', sans-serif; font-size: 20px;\">Bryan Cranston</span><span style=\"color: #333333; font-family: \'Source Sans Pro\', -apple-system, BlinkMacSystemFont, \'Segoe UI\', Roboto, Oxygen, Ubuntu, Cantarell, \'Open Sans\', \'Helvetica Neue\', sans-serif; font-size: 20px;\">. En esta ocasi&oacute;n todo giraba alrededor de Jesse Pinkman, el personaje que&nbsp;</span><span style=\"font-weight: bold; color: #333333; font-family: \'Source Sans Pro\', -apple-system, BlinkMacSystemFont, \'Segoe UI\', Roboto, Oxygen, Ubuntu, Cantarell, \'Open Sans\', \'Helvetica Neue\', sans-serif; font-size: 20px;\">Aaron Paul</span><span style=\"color: #333333; font-family: \'Source Sans Pro\', -apple-system, BlinkMacSystemFont, \'Segoe UI\', Roboto, Oxygen, Ubuntu, Cantarell, \'Open Sans\', \'Helvetica Neue\', sans-serif; font-size: 20px;\">&nbsp;interpret&oacute; de 2008 a 2013.</span></p>', 'Activa'),
(2, 'Jared Padalecki (\'Sobrenatural\') será el nuevo \'Walker, Texas Ranger\' para CW, en el reboot de la serie', '2019-10-13', '<p><span style=\"color: #111111; font-family: \'Noto Sans\', sans-serif; font-size: 17.6px;\">Tras el final de \'Sobrenatural\', Mark Pedowitz, CEO de la cadena CW, descubri&oacute; que Padalecki estaba interesado en trabajar cerca de su ciudad de nacimiento, y \'Walker, Texas Ranger\' se presentaba como una oportunidad perfecta.&nbsp;</span><span style=\"-webkit-tap-highlight-color: rgba(0, 0, 0, 0); font-weight: bold; color: #111111; font-family: \'Noto Sans\', sans-serif; font-size: 17.6px;\">La gran relaci&oacute;n que un&iacute;a a Pedowitz con Padalecki, hizo que la cadena hiciese una gran puja para hacerse con los derechos de este reboot.</span><span style=\"color: #111111; font-family: \'Noto Sans\', sans-serif; font-size: 17.6px;\">&nbsp;Algo a lo que la cadena est&aacute; muy acostumbrada tras otros remakes/reboots como \'</span><a style=\"-webkit-tap-highlight-color: rgba(0, 0, 0, 0); margin: 0px; padding: 0px; border: 0px; font-variant-numeric: inherit; font-variant-east-asian: inherit; font-stretch: inherit; font-size: 17.6px; line-height: inherit; font-family: \'Noto Sans\', sans-serif; vertical-align: baseline; outline: 0px; text-decoration-line: none; color: #799716;\" href=\"https://www.ecartelera.com/series/charmed-2018/\">Embrujadas</a><span style=\"color: #111111; font-family: \'Noto Sans\', sans-serif; font-size: 17.6px;\">\' o \'</span><a style=\"-webkit-tap-highlight-color: rgba(0, 0, 0, 0); margin: 0px; padding: 0px; border: 0px; font-variant-numeric: inherit; font-variant-east-asian: inherit; font-stretch: inherit; font-size: 17.6px; line-height: inherit; font-family: \'Noto Sans\', sans-serif; vertical-align: baseline; outline: 0px; text-decoration-line: none; color: #799716;\" href=\"https://www.ecartelera.com/series/dynasty/\">Dinast&iacute;a</a><span style=\"color: #111111; font-family: \'Noto Sans\', sans-serif; font-size: 17.6px;\">\'.</span></p>', 'Activa'),
(4, 'Gal  Gadot va a por su Oscar: producirá y protagonizará la historia de Irena Sendler, una heroína del holocausto judío', '2019-10-13', '<p style=\"-webkit-tap-highlight-color: rgba(0, 0, 0, 0); margin: 0px 0px 0.95em; padding: 0px; border: 0px; font-variant-numeric: inherit; font-variant-east-asian: inherit; font-stretch: inherit; font-size: 17.6px; line-height: inherit; font-family: \'Noto Sans\', sans-serif; vertical-align: baseline; outline: 0px; color: #111111;\">La actriz que comenz&oacute; a destacar entre el p&uacute;blico con su aparici&oacute;n en la saga de \'<a style=\"-webkit-tap-highlight-color: rgba(0, 0, 0, 0); margin: 0px; padding: 0px; border: 0px; font: inherit; vertical-align: baseline; outline: 0px; text-decoration-line: none; color: #799716;\" href=\"https://www.ecartelera.com/sagas/fast-and-furious/\">Fast &amp; Furious</a>\', y que deslumbr&oacute; al mundo dando vida a Wonder Woman en el primer gran &eacute;xito del cine de superh&eacute;roes protagonizado por una mujer, prepara un proyecto que huele mucho a Oscar 2021.<span style=\"-webkit-tap-highlight-color: rgba(0, 0, 0, 0); font-weight: bold;\">&nbsp;Seg&uacute;n informa&nbsp;<a style=\"-webkit-tap-highlight-color: rgba(0, 0, 0, 0); margin: 0px; padding: 0px; border: 0px; font: inherit; vertical-align: baseline; outline: 0px; text-decoration-line: none; color: #799716;\" href=\"https://deadline.com/2019/10/gal-gadot-pilot-wave-jaron-varsano-irena-sendler-warner-bros-1202758158/\" target=\"_blank\" rel=\"noopener noreferrer\">Deadline</a>,&nbsp;<a style=\"-webkit-tap-highlight-color: rgba(0, 0, 0, 0); margin: 0px; padding: 0px; border: 0px; font: inherit; vertical-align: baseline; outline: 0px; text-decoration-line: none; color: #799716;\" href=\"https://www.ecartelera.com/personas/gal-gadot/\">Gal Gadot</a>&nbsp;prepara llevar la vida de Irena Sendler a la gran pantalla.</span></p>\r\n<p>&nbsp;</p>\r\n<p style=\"-webkit-tap-highlight-color: rgba(0, 0, 0, 0); margin: 0px 0px 0.95em; padding: 0px; border: 0px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-variant-numeric: inherit; font-variant-east-asian: inherit; font-weight: 400; font-stretch: inherit; font-size: 17.6px; line-height: inherit; font-family: \'Noto Sans\', sans-serif; vertical-align: baseline; outline: 0px; text-decoration: none; text-align: left; color: #111111; letter-spacing: normal; orphans: 2; text-indent: 0px; text-transform: none; white-space: normal; widows: 2; word-spacing: 0px; -webkit-text-stroke-width: 0px; background-color: #ffffff;\"><strong style=\"-webkit-tap-highlight-color: rgba(0, 0, 0, 0); font-weight: bold;\">La int&eacute;rprete producir&aacute; y protagonizar&aacute; la cinta basada en la vida de la hero&iacute;na polaca que salv&oacute; la vida de miles de ni&ntilde;os jud&iacute;os durante el holocausto.</strong>&nbsp;La producci&oacute;n correr&aacute; a cargo de Warner Bros y Pilot Wave, productora creada por Gadot y su esposo Jaron Varsano. Por &uacute;ltimo, del libreto se encargar&aacute; la guionista Justine Juel Gillmer, adaptando el material escrito por Sendler durante la segunda guerra mundial.</p>', 'Activa');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `peliculas`
--

CREATE TABLE `peliculas` (
  `id` int(11) NOT NULL,
  `titulo` varchar(150) NOT NULL,
  `duracion` int(11) NOT NULL,
  `clasificacion` varchar(150) NOT NULL,
  `genero` varchar(45) NOT NULL,
  `imagen` varchar(200) DEFAULT NULL,
  `fechaEstreno` date NOT NULL,
  `estatus` enum('Activa','Inactiva') NOT NULL DEFAULT 'Activa',
  `idDetalle` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `peliculas`
--

INSERT INTO `peliculas` (`id`, `titulo`, `duracion`, `clasificacion`, `genero`, `imagen`, `fechaEstreno`, `estatus`, `idDetalle`) VALUES
(9, 'Ad Astra: hacia las estrellas', 124, 'ATP', 'Ciencia Ficcion', 'adastra.jpg', '2019-09-19', 'Activa', 13),
(12, 'Rambo: la última misión', 120, '+16', 'Accion', 'rambo.jpeg', '2019-10-10', 'Activa', 29),
(13, 'Guasón', 130, '+18', 'Drama', 'guason_poster.jpg', '2019-10-03', 'Activa', 30),
(14, 'It 2', 169, '+16', 'Terror', 'it2.jpg', '2019-09-05', 'Activa', 31);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `perfiles`
--

CREATE TABLE `perfiles` (
  `id` int(11) NOT NULL,
  `cuenta` varchar(100) NOT NULL,
  `perfil` varchar(70) NOT NULL,
  `idUsuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `perfiles`
--

INSERT INTO `perfiles` (`id`, `cuenta`, `perfil`, `idUsuario`) VALUES
(1, 'juan', 'GERENTE', 1),
(2, 'laura', 'EDITOR', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `cuenta` varchar(100) NOT NULL,
  `pwd` varchar(100) NOT NULL,
  `activo` tinyint(1) NOT NULL,
  `email` varchar(100) NOT NULL,
  `telefono` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `cuenta`, `pwd`, `activo`, `email`, `telefono`) VALUES
(1, 'juan', '$2a$10$0Vx00yKFzgTAr/5TDs.8RuNdYE/ZDGmQHFHSocjNYX1VC7L.I179m', 1, 'juan@gmail.com', '4812 5773'),
(2, 'laura', '$2a$10$C5hyOCua8QtOiqBEpDsrOu9pjuZRrsk22ClEOxaGuMtKQObot2gzu', 1, 'laura@yahoo.com.ar', '4876 1234');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `banners`
--
ALTER TABLE `banners`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `detalles`
--
ALTER TABLE `detalles`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `horarios`
--
ALTER TABLE `horarios`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_Horarios_Peliculas1_idx` (`idPelicula`);

--
-- Indices de la tabla `noticias`
--
ALTER TABLE `noticias`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `peliculas`
--
ALTER TABLE `peliculas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_Peliculas_Detalles1_idx` (`idDetalle`);

--
-- Indices de la tabla `perfiles`
--
ALTER TABLE `perfiles`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `cuenta_perfil_UNIQUE` (`cuenta`),
  ADD KEY `fk_usperf` (`idUsuario`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `cuenta_UNIQUE` (`cuenta`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `banners`
--
ALTER TABLE `banners`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `detalles`
--
ALTER TABLE `detalles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT de la tabla `horarios`
--
ALTER TABLE `horarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `noticias`
--
ALTER TABLE `noticias`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `peliculas`
--
ALTER TABLE `peliculas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de la tabla `perfiles`
--
ALTER TABLE `perfiles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `horarios`
--
ALTER TABLE `horarios`
  ADD CONSTRAINT `fk_Horarios_Peliculas1` FOREIGN KEY (`idPelicula`) REFERENCES `peliculas` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Filtros para la tabla `peliculas`
--
ALTER TABLE `peliculas`
  ADD CONSTRAINT `fk_Peliculas_Detalles1` FOREIGN KEY (`idDetalle`) REFERENCES `detalles` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `perfiles`
--
ALTER TABLE `perfiles`
  ADD CONSTRAINT `fk_usperf` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
