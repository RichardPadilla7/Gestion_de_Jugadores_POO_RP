-- BASE DE DATOS DE POO
-- Richard Padilla
create database Registros;
use Registros;

create table Usuarios(
id_usuario int auto_increment primary key,
usuario varchar(50) not null,
contrasenia varchar(50) not null
);

create table jugadores(
id_jugador int auto_increment primary key,
nombre varchar(50) not null,
posicion varchar(50) not null,
equipo varchar(50) not null,
edad int not null
);

insert into Usuarios(usuario, contrasenia) 
values ('richard','richard123'),
		('alex','alex321'),
        ('daniela','dani456'),
        ('sapito','sapo666');
        
select * from 	Usuarios;
select * from Jugadores;



