--CREATE TABLE folders (id 11(int), uuid varchar(36), account_id int(11));

CREATE TABLE `folders` (
  `id` int(11) NOT NULL auto_increment,
  `creator_id` int(11) default NULL,
  `name` varchar(255) default NULL,
  `created_at` datetime default today,
  `updated_at` datetime default today,
  `password` varchar(255) default NULL,
  `is_deleted` tinyint(1) default '0',
  `ancestry` varchar(255) default NULL,
  `description` text,
  `expires_at` datetime default NULL,
  `notify_owner` tinyint(1) default '1',
  `sent` tinyint(1) default '0',
  `expired` tinyint(1) default '0',
  `access_token` varchar(16) default NULL,
  `desc_pairs` text,
  `updated_by_id` int(11) default NULL,
  `status` varchar(255) default 'finished',
  `uuid` varchar(255) default NULL,
  `owner_id` int(11) default NULL,
  `group` tinyint(1) default '0',
  `group_uuid` varchar(36) default NULL
)
