CREATE DATABASE `stuff`;

USE `stuff`;

DROP TABLE IF EXISTS `departments`;

CREATE TABLE `departments`(
                              `id` INT(10) NOT NULL AUTO_INCREMENT COMMENT '部门id',
                              `department_name` VARCHAR(10) NOT NULL COMMENT '部门名称',
                              KEY `id`(`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `departments`(`id`, `department_name`) VALUES
                                                       (101, '教学部'),
                                                       (102, '市场部'),
                                                       (103, '教研部'),
                                                       (104, '运营部'),
                                                       (105, '后勤部');

SELECT * FROM departments;

DROP TABLE IF EXISTS `employees`;

CREATE TABLE `employees`(
                            `id` INT(10) NOT NULL AUTO_INCREMENT COMMENT '员工id',
                            `last_name` VARCHAR(10) NOT NULL COMMENT '名字',
                            `email` VARCHAR(50) NOT NULL COMMENT '邮箱',
                            `gender` INT(10) NOT NULL COMMENT '性别',
                            `department` INT(10) NOT NULL COMMENT '部门id',
                            `birth` VARCHAR(10) NOT NULL COMMENT '生日',
                            KEY `id`(`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `employees`(`id`, `last_name`, `email`, `gender`, `department`, `birth`) VALUES
                                                                                         (1, 'A', '123@mail.com', 1, 101, '2000/1/1'),
                                                                                         (2, 'B', '123@mail.com', 0, 102, '2000/1/1'),
                                                                                         (3, 'C', '123@mail.com', 1, 103, '2000/1/1'),
                                                                                         (4, 'D', '123@mail.com', 0, 104, '2000/1/1'),
                                                                                         (5, 'E', '123@mail.com', 1, 105, '2000/1/1');

SELECT * FROM employees;