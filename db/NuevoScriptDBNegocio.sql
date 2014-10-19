/*
Created		13/10/2014
Modified	15/10/2014
Project		AppNegocio
Model		ModeloNuevoNegocio - Archivo MySQL Workbench
Company		---
Author		Luca Giordano
Version		0.1
Database	MySQL 5.6.17
*/




drop table IF EXISTS Proveedores;
drop table IF EXISTS Detalles;
drop table IF EXISTS Compras;
drop table IF EXISTS Productos;




Create table Productos (
	IdProducto Int UNSIGNED NOT NULL AUTO_INCREMENT,
	Producto Varchar(200) NOT NULL,
	Stock Int NOT NULL,
	Precio Float(5,2),
	IdProveedor Int UNSIGNED NOT NULL,
 Primary Key (IdProducto)) ENGINE = InnoDB
AUTO_INCREMENT = 0;

Create table Compras (
	IdCompra Int UNSIGNED NOT NULL AUTO_INCREMENT,
	Fecha Date,
 Primary Key (IdCompra)) ENGINE = InnoDB
AUTO_INCREMENT = 0;

Create table Detalles (
	IdDetalle Int UNSIGNED NOT NULL AUTO_INCREMENT,
	IdProducto Int UNSIGNED NOT NULL,
	IdCompra Int UNSIGNED NOT NULL,
	Total Float(7,2),
	Cantidad Int,
 Primary Key (IdDetalle),
 Foreign Key (IdProducto)
 	References Productos (IdProducto)
  	ON DELETE cascade ON UPDATE cascade,
 Foreign Key  (IdCompra)
	References Compras(IdCompra)
	ON DELETE cascade ON UPDATE cascade
 ) ENGINE = InnoDB AUTO_INCREMENT = 0;

Create table Proveedores (
	IdProveedor Int UNSIGNED NOT NULL AUTO_INCREMENT,
	Proveedor Varchar(200),
	Telefono Varchar(15),
	Mail Varchar(200),
	UNIQUE (Proveedor),
 Primary Key (IdProveedor)
) ENGINE = InnoDB AUTO_INCREMENT = 0;
