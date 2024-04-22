--perfiles
insert into perfiles(codperfil,nombmperfil)values(1,'usuario');
--municipio
insert into municipio(codi_municipio,nomb_municipio)values(1,'Bogota');
--categoria
insert into categoria(num_categoria ,nomb_categoria, descripcion)values(uuid_generate_v4(),'Hogar', 'Gastos asociados al hogar');
insert into categoria(num_categoria ,nomb_categoria, descripcion)values(uuid_generate_v4(),'Vehículo', 'Gastos asociados al carro');
--subcategoria
insert into subcategoria(num_subcategoria ,nomb_subcategoria, descripcion)values(uuid_generate_v4(),'Servicios públicos', 'Gastos asociados a servicios públicos');
--Empresa
insert into empresa(cod_empresa, nomb_empresa)values(uuid_generate_v4(),'VANTI');
--tipo_ingreso
insert into tipo_ingreso(id_tipo_ingreso, nomb_tipo_ingreso)values(uuid_generate_v4(),'SALARIO');