package parcial2;

import java.util.Objects;

public class Comisario implements Comparable <Comisario> {

	Tipo tipo;
	private String nombre;
	Integer edad;
	Integer id;
	public Comisario(Tipo tipo, String nombre, Integer edad, Integer id) {
		this.tipo = tipo;
		this.nombre = nombre;
		this.edad = edad;
		this.id = id;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comisario other = (Comisario) obj;
		return Objects.equals(id, other.id);
	}



	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}



	@Override
	public int compareTo(Comisario o) {
		// TODO Auto-generated method stub
		return this.getId().compareTo(o.getId());
	}
	
	
	
}
