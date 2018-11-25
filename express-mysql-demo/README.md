# express-mysql-demo

A demo for Hiroba

## TODO

1. Make a complete error code and msg system.

## Database

### User List

id, name, class, email

### Post List

id, title, content, status, users, date

### Comment List

id, pid, content, from_uid, to_uid, date

pid: post id
uid: user id

## Login and Signup

Use session and cookie to save the user info.
