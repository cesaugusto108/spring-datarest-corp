DROP TABLE IF EXISTS `users`;
DROP TABLE IF EXISTS `authorities`;

CREATE TABLE `users` (
	`username` varchar(50) PRIMARY KEY NOT NULL UNIQUE,
	`password` varchar(50) NOT NULL,
	`enabled` tinyint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `authorities` (
	`username` varchar (50) NOT NULL,
	`authority` varchar (50) NOT NULL,

	UNIQUE KEY `authorities_idx_1` (`username`, `authority`),

	CONSTRAINT `authorities_ibfk_1`
	FOREIGN KEY (`username`)
	REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;