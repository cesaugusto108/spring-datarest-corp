DROP TABLE IF EXISTS `roles`;
DROP TABLE IF EXISTS `personnel`;

CREATE TABLE `personnel` (
	`employee` varchar(50) PRIMARY KEY NOT NULL UNIQUE,
	`pword` char(68) NOT NULL,
	`active` tinyint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `roles` (
	`employee` varchar (50) NOT NULL,
	`role` varchar (50) NOT NULL,

	UNIQUE KEY `roles_idx_1` (`employee`, `role`),

	CONSTRAINT `roles_ibfk_1`
	FOREIGN KEY (`employee`)
	REFERENCES `personnel` (`employee`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;