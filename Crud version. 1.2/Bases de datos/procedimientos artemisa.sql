delimiter //
create procedure artemisa.sp_ReporteVentas()
begin
	select 		 v.idventa
				,c.doccliente
				,c.nombrecliente
				,c.apellidocliente
				,v.fechaventa
				,v.valortotal
				,p.nombreproducto
				,cg.categoriaproducto
				,dv.cantidadProducto
				,dv.valorproducto
				,dv.iva
	from 		ventas v
	inner join  detalleventas dv
	on 			v.idventa = dv.idventa
	inner join 	cliente c
	on 			v.idcliente = c.idcliente
	inner join	producto p
	on 			dv.idproducto = p.idproducto
	inner join 	categoria cg
	on 			p.idcategoriaproducto= cg.idcategoriaproducto;
end
//delimiter ;

call artemisa.sp_ReporteVentas();

delimiter //
create procedure artemisa.sp_ReporteAlquileres()
begin
	
	select 		 v.idalquiler
				,c.doccliente
				,c.nombrecliente
				,c.apellidocliente
				,v.fechaalquiler
				,v.valortotal
				,p.nombreproducto
				,cg.categoriaproducto
				,dv.valoralquiler
				,dv.iva
	from 		alquiler v
	inner join  detallealquiler dv
	on 			v.idalquiler = dv.idalquiler
	inner join 	cliente c
	on 			v.idcliente = c.idcliente
	inner join	producto p
	on 			dv.idproducto = p.idproducto
	inner join 	categoria cg
	on 			p.idcategoriaproducto= cg.idcategoriaproducto;

end
//delimiter ;

call artemisa.sp_ReporteAlquileres();

delimiter //
create procedure artemisa.sp_ReporteVisitas()
begin
	
	select 		 v.idvisita
				,v.estadovisita
				,dv.desctipo as TipoAlquiler
				,c.doccliente
				,c.nombrecliente
				,c.apellidocliente
				,p.nombreproducto
				,cg.categoriaproducto
	from 		visitas v
	inner join  tipoventaalquiler dv
	on 			v.idtipoventaalquiler = dv.idtipoventaalquiler
	inner join 	cliente c
	on 			v.idcliente = c.idcliente
	inner join	producto p
	on 			v.idproducto = p.idproducto
	inner join 	categoria cg
	on 			p.idcategoriaproducto= cg.idcategoriaproducto;

end
//delimiter ;

call artemisa.sp_ReporteVisitas();

delimiter //
create procedure artemisa.sp_ReporteVentasPorProducto(nomproducto varchar(100))
begin
	select 		 v.idventa
				,c.doccliente
				,c.nombrecliente
				,c.apellidocliente
				,v.fechaventa
				,v.valortotal
				,p.nombreproducto
				,cg.categoriaproducto
				,dv.cantidadProducto
				,dv.valorproducto
				,dv.iva
	from 		ventas v
	inner join  detalleventas dv
	on 			v.idventa = dv.idventa
	inner join 	cliente c
	on 			v.idcliente = c.idcliente
	inner join	producto p
	on 			dv.idproducto = p.idproducto
	inner join 	categoria cg
	on 			p.idcategoriaproducto= cg.idcategoriaproducto
    where 		p.nombreProducto like concat('%',nomproducto,'%') ;
    
end
//delimiter ;


call artemisa.sp_ReporteVentasPorProducto('traje');


delimiter //
create procedure artemisa.sp_ReporteAlquileresPorProducto(nomproducto varchar(100))
begin
	
	select 		 v.idalquiler
				,c.doccliente
				,c.nombrecliente
				,c.apellidocliente
				,v.fechaalquiler
				,v.valortotal
				,p.nombreproducto
				,cg.categoriaproducto
				,dv.valoralquiler
				,dv.iva
	from 		alquiler v
	inner join  detallealquiler dv
	on 			v.idalquiler = dv.idalquiler
	inner join 	cliente c
	on 			v.idcliente = c.idcliente
	inner join	producto p
	on 			dv.idproducto = p.idproducto
	inner join 	categoria cg
	on 			p.idcategoriaproducto= cg.idcategoriaproducto
	where 		p.nombreProducto like concat('%',nomproducto,'%') ;
end
//delimiter ;

call artemisa.sp_ReporteAlquileresPorProducto('traje');


delimiter //
create procedure artemisa.sp_ReporteVisitasPorMes(Anio int, Mes int)
begin
	
	select 		 v.idvisita
				,v.estadovisita
                ,v.fechaVisita
				,dv.desctipo as TipoAlquiler
				,c.doccliente
				,c.nombrecliente
				,c.apellidocliente
				,p.nombreproducto
				,cg.categoriaproducto
	from 		visitas v
	inner join  tipoventaalquiler dv
	on 			v.idtipoventaalquiler = dv.idtipoventaalquiler
	inner join 	cliente c
	on 			v.idcliente = c.idcliente
	inner join	producto p
	on 			v.idproducto = p.idproducto
	inner join 	categoria cg
	on 			p.idcategoriaproducto= cg.idcategoriaproducto
    where 		extract(year from v.fechaVisita) = Anio
    and			extract(month from v.fechaVisita) = Mes;

end
//delimiter ;

call artemisa.sp_ReporteVisitasPorMes(2022,8);