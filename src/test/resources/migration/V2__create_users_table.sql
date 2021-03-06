--CREATE TABLE users (id 11(int), uuid varchar(36), account_id int(11));

CREATE TABLE users (
  id int(11) NOT NULL auto_increment,
  email varchar(255) default NULL,
  username varchar(255) default NULL,
  crypted_password varchar(255) default NULL,
  password_salt varchar(255) default NULL,
  persistence_token varchar(255) default NULL,
  is_unknown_user tinyint(1) default '0',
  is_deactivated tinyint(1) default '0',
  is_admin tinyint(1) default '0',
  perishable_token varchar(255) NOT NULL default '',
  created_at datetime default today,
  updated_at datetime default today,
  account_id int(11) default NULL,
  addin_downloaded_at datetime default NULL,
  addin_first_time_used_at datetime default NULL,
  created_decks_count int(11) default '0',
  decks_count int(11) default '0',
  addin_last_time_used_at datetime default NULL,
  invitees_count int(11) default '0',
  inviter_id int(11) default NULL,
  account_admin tinyint(1) default '0',
  password_set tinyint(1) default '1',
  daily_digest_enabled tinyint(1) default '1',
  phone_number varchar(255) default NULL,
  start_trial_on_validation tinyint(1) default '0',
  company_name varchar(255) default NULL,
  guest tinyint(1) default '0',
  promo_code varchar(255) default NULL,
  validated_at datetime default NULL,
  sugar_sync_at datetime default NULL,
  sugar_sync tinyint(1) default '0',
  activity_feed_level varchar(255) default '',
  status varchar(255) default NULL,
  is_enterprise_admin tinyint(1) default '0',
  account_inviter_id int(11) default NULL,
  inbox_folder_id int(11) default NULL,
  root_folder_id int(11) default NULL,
  utm_source varchar(255) default NULL,
  utm_content varchar(255) default NULL,
  migrated tinyint(1) default '1',
  migration_job_id int(11) default NULL,
  outbox_folder_id int(11) default NULL,
  job_title varchar(255) default NULL,
  uuid varchar(36) default NULL,
  socket_token varchar(255) default NULL,
  contact_me int(11) default NULL,
  uses_sso tinyint(1) default NULL,
  onboarding_at datetime default NULL,
  first_name varchar(255) default NULL,
  last_name varchar(255) default NULL,
  last_activity_at datetime default NULL,
  failed_login_count int(11) default '0'
)
