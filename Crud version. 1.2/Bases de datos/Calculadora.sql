Drop database if exists calculadora;
Create database calculadora;

use calculadora;

Create table calcu(
id int  not null,
Num1 int not null,
Num2 int not null, 
operacion varchar(10) not null,
resultado int not null
);

