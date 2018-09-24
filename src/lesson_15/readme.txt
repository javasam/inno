Разработать слой DAO для приложения (доработать то, что делали на занятии, или собственный),
в котором будут получаться данные для двух pojo-классов. При этом одно из полей одного класса
должно иметь тип другого класса. Соответственно, при попытке оперировать такой сущностью через
dao возникает необходимость вызывать методы второго dao.

DataBase PostgreSQL Heroku:
Host: ec2-54-227-243-210.compute-1.amazonaws.com
Database: d71g7a9arrmne3
User: zzeeduuxqgwooz
Port: 5432
Password: 284b20acb93f40399f7c9871470e58e5aabc572a1694483cfde436a0ba040a67
Please set:
sslFactory: org.postgresql.ssl.NonValidatingFactory
and
ssl: true
in Advanced tab