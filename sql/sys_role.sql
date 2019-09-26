CREATE TABLE `sys_role` (
`sys_role_id`  bigint(20) NOT NULL,
`role_name` varchar(255)CHARACTER
SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
`last_update_by` int(11)NULL DEFAULT NULL,
`last_update_time` datetime NULL DEFAULT NULL,
PRIMARY KEY(`sys_role_id`)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET=utf8mb4 COLLATE=utf8mb4_general_ci
ROW_FORMAT=DYNAMIC;

