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

	@Query("SELECT g, cs.usuarioCategoria.categoria, cs.subcategoria FROM Gasto g JOIN g.categoriaSubcategoria cs WHERE cs.usuarioCategoria.usuario.idUsuario = :idUsuario "
			+ "AND YEAR(g.fecha) = :year AND MONTH(g.fecha) = :month")
	List<Object[]> obtenerGastosPorUsuarioYMes(@Param("idUsuario") UUID idUsuario, @Param("year") int year,  @Param("month") int month);

	@Query("SELECT i FROM Ingreso i WHERE i.usuario.idUsuario = :idUsuario")
	List<Ingreso> obtenerIngresosPorUsuario(@Param("idUsuario") UUID idUsuario);
	
	@Query("SELECT i FROM Ingreso i WHERE i.usuario.idUsuario = :idUsuario AND YEAR(i.fecha) = :year AND MONTH(i.fecha) = :month")
	List<Ingreso> obtenerIngresosPorUsuarioMes(@Param("idUsuario") UUID idUsuario, @Param("year") int year,  @Param("month") int month);

	@Query("SELECT CONCAT(m.mes, '-', m.anio), " +
		       "       COALESCE(gastos.total, 0), " +
		       "       COALESCE(ingresos.total, 0), " +
		       "       COALESCE(ingresos.total, 0) - COALESCE(gastos.total, 0), " +
		       "       CASE WHEN COALESCE(ingresos.total, 0) = 0 THEN 0 ELSE (COALESCE(gastos.total, 0) / COALESCE(ingresos.total, 0)) * 100 END " +
		       "FROM (SELECT DISTINCT MONTH(g.fecha) AS mes, YEAR(g.fecha) AS anio " +
		       "      FROM Gasto g " +
		       "      JOIN g.categoriaSubcategoria cs " +
		       "      WHERE cs.usuarioCategoria.usuario.idUsuario = :idUsuario " +
		       "      UNION " +
		       "      SELECT DISTINCT MONTH(i.fecha) AS mes, YEAR(i.fecha) AS anio " +
		       "      FROM Ingreso i " +
		       "      WHERE i.usuario.idUsuario = :idUsuario) AS m " +
		       "LEFT JOIN (SELECT MONTH(g.fecha) AS mes, YEAR(g.fecha) AS anio, SUM(g.monto) AS total " +
		       "           FROM Gasto g " +
		       "           JOIN g.categoriaSubcategoria cs " +
		       "           WHERE cs.usuarioCategoria.usuario.idUsuario = :idUsuario " +
		       "           GROUP BY MONTH(g.fecha), YEAR(g.fecha)) AS gastos " +
		       "ON m.mes = gastos.mes AND m.anio = gastos.anio " +
		       "LEFT JOIN (SELECT MONTH(i.fecha) AS mes, YEAR(i.fecha) AS anio, SUM(i.valor) AS total " +
		       "           FROM Ingreso i " +
		       "           WHERE i.usuario.idUsuario = :idUsuario " +
		       "           GROUP BY MONTH(i.fecha), YEAR(i.fecha)) AS ingresos " +
		       "ON m.mes = ingresos.mes AND m.anio = ingresos.anio")
	List<Object[]> generarInformeMensual(@Param("idUsuario") UUID idUsuario);
		
	@Query("SELECT (SELECT COALESCE(SUM(g.monto), 0) " +
		       "        FROM Gasto g " +
		       "        JOIN g.categoriaSubcategoria cs " +
		       "        WHERE cs.usuarioCategoria.usuario.idUsuario = :idUsuario), " +
		       "       (SELECT COALESCE(SUM(i.valor), 0) " +
		       "        FROM Ingreso i " +
		       "        WHERE i.usuario.idUsuario = :idUsuario), " +
		       "       ((SELECT COALESCE(SUM(i.valor), 0) " +
		       "         FROM Ingreso i " +
		       "         WHERE i.usuario.idUsuario = :idUsuario) - " +
		       "        (SELECT COALESCE(SUM(g.monto), 0) " +
		       "         FROM Gasto g " +
		       "         JOIN g.categoriaSubcategoria cs " +
		       "         WHERE cs.usuarioCategoria.usuario.idUsuario = :idUsuario)), " +
		       "       CASE " +
		       "           WHEN (SELECT COALESCE(SUM(i.valor), 0) " +
		       "                 FROM Ingreso i " +
		       "                 WHERE i.usuario.idUsuario = :idUsuario) = 0 " +
		       "               THEN 0 " +
		       "           ELSE " +
		       "               ((SELECT COALESCE(SUM(g.monto), 0) " +
		       "                 FROM Gasto g " +
		       "                 JOIN g.categoriaSubcategoria cs " +
		       "                 WHERE cs.usuarioCategoria.usuario.idUsuario = :idUsuario) / " +
		       "                (SELECT COALESCE(SUM(i.valor), 0) " +
		       "                 FROM Ingreso i " +
		       "                 WHERE i.usuario.idUsuario = :idUsuario)) * 100 " +
		       "       END")
		Object[] generarInformeTotal(@Param("idUsuario") UUID idUsuario);

}
