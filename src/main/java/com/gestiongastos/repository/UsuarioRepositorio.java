package com.gestiongastos.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gestiongastos.models.Gasto;
import com.gestiongastos.models.Ingreso;
import com.gestiongastos.models.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, UUID> {

	@Query("SELECT g, cs.usuarioCategoria.categoria, cs.subcategoria FROM Gasto g JOIN g.categoriaSubcategoria cs WHERE cs.usuarioCategoria.usuario.idUsuario = :idUsuario")
	List<Object[]> listarGastosPorUsuario(@Param("idUsuario") UUID idUsuario);

	@Query("SELECT cs.subcategoria, cs.usuarioCategoria.categoria FROM CategoriaSubcategoria cs WHERE cs.usuarioCategoria.usuario.idUsuario = :idUsuario")
	List<Object[]> obtenerSubcategoriasCategoriasPorUsuario(@Param("idUsuario") UUID idUsuario);

	@Query("SELECT g FROM Gasto g JOIN g.categoriaSubcategoria cs WHERE cs.usuarioCategoria.usuario.idUsuario = :idUsuario AND g.fecha BETWEEN :fechaInicio AND :fechaFin")
	List<Gasto> obtenerGastosPorUsuarioYFecha(@Param("idUsuario") UUID idUsuario,
			@Param("fechaInicio") LocalDate fechaInicio, @Param("fechaFin") LocalDate fechaFin);

	@Query("SELECT i FROM Ingreso i WHERE i.usuario.idUsuario = :idUsuario")
	List<Ingreso> obtenerIngresosPorUsuario(@Param("idUsuario") UUID idUsuario);
	/*

	 @Query("SELECT CONCAT(MONTH(g.fecha), '-', YEAR(g.fecha)), " +
	           "       SUM(g.monto), " +
	           "       SUM(i.valor), " +
	           "       SUM(i.valor) - SUM(g.monto), " +
	           "       (SUM(g.monto) / SUM(i.valor)) * 100 " +
	           "FROM Gasto g " +
	           "JOIN g.categoriaSubcategoria cs " +
	           "LEFT JOIN Ingreso i ON MONTH(g.fecha) = MONTH(i.fecha) AND YEAR(g.fecha) = YEAR(i.fecha) " +
	           "WHERE cs.usuarioCategoria.usuario.idUsuario = :idUsuario " +
	           "AND i.usuario.idUsuario = :idUsuario " +
	           "GROUP BY CONCAT(MONTH(g.fecha), '-', YEAR(g.fecha))")
	List<Object[]> generarInformeMensual(@Param("idUsuario") UUID idUsuario);
	*/
	
	@Query("SELECT CONCAT(m.mes, '-', m.anio), " +
		       "       COALESCE(SUM(g.monto), 0), " +
		       "       COALESCE(SUM(i.valor), 0), " +
		       "       COALESCE(SUM(i.valor), 0) - COALESCE(SUM(g.monto), 0), " +
		       "       CASE WHEN COALESCE(SUM(i.valor), 0) = 0 THEN 0 ELSE (COALESCE(SUM(g.monto), 0) / COALESCE(SUM(i.valor), 0)) * 100 END " +
		       "FROM (SELECT DISTINCT MONTH(g.fecha) AS mes, YEAR(g.fecha) AS anio " +
		       "      FROM Gasto g " +
		       "      JOIN g.categoriaSubcategoria cs " +
		       "      WHERE cs.usuarioCategoria.usuario.idUsuario = :idUsuario " +
		       "      UNION " +
		       "      SELECT DISTINCT MONTH(i.fecha) AS mes, YEAR(i.fecha) AS anio " +
		       "      FROM Ingreso i " +
		       "      WHERE i.usuario.idUsuario = :idUsuario) AS m " +
		       "LEFT JOIN Gasto g ON MONTH(g.fecha) = m.mes AND YEAR(g.fecha) = m.anio " +
		       "LEFT JOIN Ingreso i ON MONTH(i.fecha) = m.mes AND YEAR(i.fecha) = m.anio AND i.usuario.idUsuario = :idUsuario " +
		       "GROUP BY CONCAT(m.mes, '-', m.anio)")
		List<Object[]> generarInformeMensual(@Param("idUsuario") UUID idUsuario);


}
