package es.back.odontologia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.back.odontologia.entity.Inventario;

public interface InventarioRepository  extends JpaRepository<Inventario, Long>{

//	@Query("SELECT COUNT(v) FROM Venta v WHERE v.folio LIKE :folio")
//    int contarVentasPorFolio(@Param("folio") String folio);
	
}
