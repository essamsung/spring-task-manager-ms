CREATE TABLE IF NOT EXISTS `task` (
  `id` VARCHAR(36) PRIMARY KEY,
  `title` varchar(100) NOT NULL,
  `author` varchar(100) NOT NULL,
  `description` varchar(255),
  `status` varchar(100) DEFAULT 'pending',
  `project` varchar(100) NOT NULL,
  `created_at` DATETIME NOT NULL,
  `updated_at` DATETIME DEFAULT NULL
);