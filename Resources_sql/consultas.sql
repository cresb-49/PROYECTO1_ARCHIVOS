select p.id,p.valor,d.cantidad,d.venta from comercio.descripcion as d inner join comercio.venta as v on d.venta = v.id inner join consumidor.cliente as c on c.nit = v.cliente inner join mercancia.producto as p on d.producto = p.id;

select SUM(p.valor * d.cantidad) as costo,d.venta from comercio.descripcion as d inner join comercio.venta as v on d.venta = v.id inner join consumidor.cliente as c on c.nit = v.cliente inner join mercancia.producto as p on d.producto = p.id group by d.venta;

select SUM(p.valor * d.cantidad *(1 - v.descuento)) as costo,v.id,v.fecha from comercio.descripcion as d inner join comercio.venta as v on d.venta = v.id inner join consumidor.cliente as c on c.nit = v.cliente inner join mercancia.producto as p on d.producto = p.id where c.nit ='1234567' group by v.id order by v.fecha desc limit 1;


--Top 5 productos más vendidos por sucursal
select p.id,p.nombre,p.marca,p.valor,sum(d.cantidad) as cantidad from comercio.venta as v inner join comercio.descripcion as d on v.id = d.venta inner join mercancia.producto as p on p.id = d.producto where v.sucursal = 'S0001' group by p.id order by cantidad desc limit 5;

--Top 5 productos con más ingresos por sucursal.
select p.id,p.nombre,p.marca, sum(p.valor*(1-v.descuento)*d.cantidad) as ganancia from comercio.venta as v inner join comercio.descripcion as d on v.id = d.venta inner join mercancia.producto as p on p.id = d.producto where v.sucursal = 'S0001' group by p.id order by ganancia desc limit 5;