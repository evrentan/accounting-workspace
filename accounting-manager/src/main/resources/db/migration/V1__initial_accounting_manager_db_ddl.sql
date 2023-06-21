create table if not exists accounting
(
    id                 uuid primary key default gen_random_uuid(),
    first_name          varchar(100),
    last_name          varchar(100),
    email              varchar(100),
    amount             numeric(10, 2),
    product_name       varchar(100),
    bill_no            varchar(100),
    is_active          boolean          default true,
    bill_date          timestamptz
);

comment on table accounting is 'Stores accounting information';
comment on column accounting.id is 'Unique identifier for the accounting item. Type is uuid';
comment on column accounting.first_name is 'First Name of the accountant. Type is varchar(100)';
comment on column accounting.last_name is 'Last Name of the accountant. Type is varchar(100)';
comment on column accounting.email is 'Email of the accountant. Type is varchar(100)';
comment on column accounting.amount is 'Amount of the bill. Type is numeric(10,2)';
comment on column accounting.product_name is 'Product Name. Type is varchar(100)';
comment on column accounting.bill_no is 'Bill No. Type is varchar(100)';
comment on column accounting.is_active is 'Indicates whether the accounting item is active or not. Type is boolean and default is true';
comment on column accounting.bill_date is 'Date of the bill. Type is timestamp with time zone';