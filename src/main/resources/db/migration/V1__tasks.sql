create table tasks (
  id identity not null,
  username varchar (255) not null,
  desc varchar (255) not null,
  lastUpdated varchar (255),
  isDone boolean DEFAULT FALSE not null
);

INSERT INTO tasks (
    id,
    username,
    desc,
    lastUpdated
)
VALUES
    (
        1,
        'test',
        'Learn Spring MVC',
        '2021-11-14 00:00:00'
    ),
     (
        2,
        'test',
        'Learn Struts',
        '2021-11-14 00:00:00'
    ),
    (
        3,
        'test',
        'Learn Hibernate',
        '2021-11-14 00:00:00'
    ); 