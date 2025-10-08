package es.back.odontologia.service;

import es.back.odontologia.entity.Inventario;

public interface InventarioService {

	
	Inventario saveVenta( Inventario inv);
	
	int countVentaPorfolio(String folio);
}
