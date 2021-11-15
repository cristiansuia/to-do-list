create table users (
  id identity not null,
  username varchar (255) not null,
  pwd varchar (255) not null,
);

INSERT INTO users (
    id,
    username,
    pwd
)
VALUES
    (
        1,
        'test',
        'pwd123'
    ),
     (
        2,
        'test1',
        'pwd1234'
    ),
    (
        3,
        'test2',
        'pwd1235'
    );