package parcial2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class SedeOlimpica {

	private Set<Complejo> complejos;
	private String nombre;
	private Map<String, String> mapaDeComplejos;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public SedeOlimpica(String nombre) {
		this.nombre = nombre;
		this.complejos = new TreeSet<Complejo>();
		this.mapaDeComplejos = new HashMap<String, String>();

	}

	public Boolean crearComplejoSim(String nombreCom, Integer i, Integer id) {
		ComplejoSim comp = new ComplejoSim(nombreCom, i, id);
		return this.complejos.add(comp);
	}

	public Boolean crearComplejoPoli(String nombreCom, Integer i, String ubicacion, Integer id)
			throws IndicadorAreaException {
		ComplejoPoli comp = new ComplejoPoli(nombreCom, i, ubicacion, id);

		if (this.complejos.add(comp)) {
			return true;
		} else {

			new IndicadorAreaException("El poli ya existe");

		}
		return false;
	}

	public Complejo getComplejoOlim(Integer id) {

		for (Complejo complejo : this.complejos) {
			if (complejo.getId().equals(id)) {
				return complejo;
			}
		}

		return null;
	}

	public Map<String, String> obtenerMapaDelComplejo(Integer id) {

		Complejo complejo = getComplejoOlim(id);

		if (complejo instanceof ComplejoPoli) {
			this.mapaDeComplejos.put(complejo.getNombre(), ((ComplejoPoli) complejo).getUbicacion());
		}

		return this.mapaDeComplejos;
	}

}
