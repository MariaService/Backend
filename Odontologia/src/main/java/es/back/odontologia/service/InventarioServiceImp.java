package es.back.odontologia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.back.odontologia.entity.Inventario;
import es.back.odontologia.entity.Venta;
import es.back.odontologia.repository.InventarioRepository;
import es.back.odontologia.repository.VentaRepository;
@Service 
public class InventarioServiceImp  implements InventarioService  {

	@Autowired
	private InventarioRepository  inventarioRepository;

	@Override
	public Inventario saveVenta(Inventario inv) {
		// TODO Auto-generated method stub
		return inventarioRepository.save(inv);
	}

	@Override
	public int countVentaPorfolio(String folio) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	

}
