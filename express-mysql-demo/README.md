# express-mysql-demo

A demo for [HIROBA](https://github.com/LinSijie/HIROBA)

## TODO

~~1. Make a complete error code and msg system.~~
2. Comments
3. Posts

## Database

### User List

id, name, class, email

**MySQL Table**:

```sql
CREATE TABLE users(`id` INT UNSIGNED,
                   `username` VARCHAR(256) NOT NULL,
                   `password` VARCHAR(256) NOT NULL,
                   `class` VARCHAR(256) NOT NULL,
                   `email` VARCHAR(256) NOT NULL,
                   `createDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                   `updateDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                   PRIMARY KEY(`id`)
                   )ENGINE=InnoDB DEFAULT CHARSET=utf8;
```

### Post List

id, title, content, status, users, date

users: a list of user id

**MySQL Table**:

```sql
CREATE TABLE posts(`id` INT UNSIGNED,
                   `title` VARCHAR(256) NOT NULL,
                   `content` TEXT,
                   `status` VARCHAR(256) NOT NULL,
                   `users` TEXT,
                   `createDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                   `updateDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                   PRIMARY KEY(`id`)
                   )ENGINE=InnoDB DEFAULT CHARSET=utf8;
```

### Comment List

id, pid, content, from_uid, to_uid, date

pid: post id
uid: user id

**MySQL Table**:

```sql
CREATE TABLE comments(`id` INT UNSIGNED,
                      `content` TEXT,
                      `postId` INT UNSIGNED NOT NULL,
                      `fromUid` INT UNSIGNED NOT NULL,
                      `toUid` INT UNSIGNED NOT NULL,
                      `createDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                      `updateDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                      PRIMARY KEY(`id`)
                      )ENGINE=InnoDB DEFAULT CHARSET=utf8;
```

## Login and Signup

Use session and cookie to save the user info.
