--CREATE TABLE decks (id 11(int), uuid varchar(36), account_id int(11));

CREATE TABLE `decks` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(255) default NULL,
  `created_by` int(11) default NULL,
  `updated_by_id` int(11) default NULL,
  `version` int(11) default NULL,
  `uuid` varchar(255) default NULL,
  `created_at` datetime default today,
  `updated_at` datetime default today,
  `account_id` int(11) default NULL,
  `is_deactivated` tinyint(1) default '0',
  `is_published` tinyint(1) default '0',
  `notify_owner` tinyint(1) default '1',
  `processed` tinyint(1) default NULL,
  `folder_id` int(11) default NULL,
  `access_token` varchar(16) default NULL,
  `comments_count` int(11) NOT NULL default '0'
)
