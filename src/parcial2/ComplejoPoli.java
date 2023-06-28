package parcial2;

public class ComplejoPoli extends Complejo {

	private String ubicacion;

	public ComplejoPoli(String nombreCom, Integer i, String ubicacion, Integer id) {
		super(nombreCom, i, id);
		this.ubicacion = ubicacion;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

}
