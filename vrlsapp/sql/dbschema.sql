drop table if exists vrls_customer_profile_data;
drop table if exists vrls_customer_preferences ;
drop table if exists vrls_listings ;
drop table if exists vrls_listing_images ;
drop table if exists vrls_partners ;
drop table if exists vrls_xref_state_province ;
drop table if exists vrls_xref_country ;
drop table if exists vrls_xref_preferences ;
drop table if exists vrls_xref_listing_type ;
drop table if exists vrls_xref_listing_offer_type ;

drop table if exists vrls_xref_region ;
drop table if exists vrls_xref_listing_status ;

create table vrls_customer_profile_data
(
     cust_id                  bigint unsigned not null
       auto_increment primary key
   , cust_login               varchar(20) not null
   , cust_password_hash       varchar(255) not null
   , cust_first_name          varchar(25) not null
   , cust_middle_name         varchar(25) not null
   , cust_last_name           varchar(25) not null
   , cust_address1            varchar(100) not null
   , cust_address2            varchar(100)
   , cust_city                varchar(100)
   , cust_state_province_code char(2) not null
       references vrls_xref_state_province(state_province_code)
   , cust_postal_code         char(10) not null
   , cust_country_code        char(2) not null
       references vrls_xref_country(country_code)
   , cust_email_address       varchar(100) not null
   , cust_phone               varchar(20) not null
   , cust_level               tinyint not null default 0
   , referring_partner_id     bigint unsigned not null
   , cust_last_visited        date not null default 0
   , date_entered             date not null default 0
   , date_last_modified       date not null default 0
);

alter table vrls_customer_profile_data
add unique(cust_login);

create table vrls_customer_preferences
(
     cust_id                  bigint unsigned not null
       references vrls_customer_profile_data(cust_id)
   , preference_code          smallint not null
       references vrls_xref_preferences(preference_code)
   , preference_value         varchar(25) not null
   , preference_weight        tinyint not null
);

create table vrls_listings
(
     listing_id               bigint unsigned not null
       auto_increment primary key
   , listing_title            varchar(25) not null
   , listing_desc             varchar(255) not null
   , listing_type_code        smallint not null
       references vrls_xref_listing_type(listing_type_code)
   , listing_region           varchar(50) not null
       references vrls_xref_region(region_name)
   , listing_offer_type_code  smallint not null
       references vrls_xref_listing_offer_type(listing_offer_type_code)
   , listing_num_bedrooms     tinyint not null
   , listing_num_bathrooms    tinyint not null
   , listing_monthly_payment  decimal(7,2) not null
   , listing_purchase_price   decimal(10,2) not null
   , referring_partner_id     bigint unsigned not null
   , listing_status_code      smallint not null
       references vrls_xref_listing_status(listing_status_code)
   , listing_status_eff_date  date not null
   , date_entered             date not null
   , date_last_modified       date not null
);

create table vrls_listing_images
(
     listing_id               bigint unsigned not null
       references vrls_listings(listing_id)
   , listing_image_name       varchar(20) not null
   , listing_image_desc       varchar(255) not null
   , listing_image_url        varchar(100) not null
   , listing_thumb_url        varchar(100)
   , is_primary_image         char(1) not null
);

create table vrls_partners
(
     partner_id               bigint unsigned not null
       auto_increment primary key
   , partner_name             varchar(25) not null
   , partner_desc             varchar(255) not null
   , partner_contact_name     varchar(50) not null
   , partner_address1         varchar(25) not null
   , partner_address2         varchar(25)
   , partner_state_province_code char(2) not null
       references vrls_xref_state_province(state_province_code)
   , partner_postal_code      char(10) not null
   , partner_country_code     char(2) not null
       references vrls_xref_country(country_code)
   , partner_contact_email    varchar(50) not null
   , partner_contact_phone    varchar(50) not null
   , partner_code             varchar(25) not null
   , partner_prefix           varchar(50) not null
);

alter table vrls_partners add unique(partner_code);
alter table vrls_partners add unique(partner_prefix);

create table vrls_xref_state_province
(
     state_province_code      varchar(2) not null
       primary key
   , state_province_name      varchar(25) not null
);

create table vrls_xref_country
(
     country_code             varchar(2) not null
       primary key
   , country_name             varchar(40) not null
);

create table vrls_xref_preferences
(
     preference_code          smallint not null
       auto_increment primary key
   , preference_name          varchar(25) not null
   , preference_desc          varchar(255) not null
);

create table vrls_xref_listing_type
(
     listing_type_code        smallint not null
       auto_increment primary key
   , listing_type_name        varchar(25) not null
   , listing_type_desc        varchar(255) not null
);

create table vrls_xref_listing_offer_type
(
     listing_offer_type_code  smallint not null
       auto_increment primary key
   , listing_offer_type_name  varchar(25) not null
   , listing_offer_type_desc  varchar(255) not null
);

create table vrls_xref_region
(
     region_name              varchar(25) not null
       primary key
);

create table vrls_xref_listing_status
(
     listing_status_code      smallint not null
       auto_increment primary key
   , listing_status_name      varchar(25) not null
   , listing_status_desc      varchar(255) not null
);
