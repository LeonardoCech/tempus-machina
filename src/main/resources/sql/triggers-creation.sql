
delimiter //

drop trigger if exists `new-profile`;
create trigger `new-profile`
before insert on `profile`
for each row
begin
    set new.last_password_update = ROUND(UNIX_TIMESTAMP(NOW(3)) * 1000);
    set new.created_at = ROUND(UNIX_TIMESTAMP(NOW(3)) * 1000);
    set new.updated_at = ROUND(UNIX_TIMESTAMP(NOW(3)) * 1000);
end;

drop trigger if exists `new-media`;
create trigger `new-media`
before insert on `media`
for each row
begin
    set new.created_at = ROUND(UNIX_TIMESTAMP(NOW(3)) * 1000);
    set new.updated_at = ROUND(UNIX_TIMESTAMP(NOW(3)) * 1000);
end;

drop trigger if exists `new-review`;
create trigger `new-review`
before insert on `review`
for each row
begin
    set new.created_at = ROUND(UNIX_TIMESTAMP(NOW(3)) * 1000);
    set new.updated_at = ROUND(UNIX_TIMESTAMP(NOW(3)) * 1000);
end;

//