package parcial2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Evento {
	private String fecha;
	private Integer duracion;
	private Integer nroParticipantes;
	private Integer idEvento;
	private Set<Comisario> comisarios;

	public Evento(String fecha, Integer duracion, Integer nroParticipantes, Integer idEvento) {
		this.fecha = fecha;
		this.duracion = duracion;
		this.nroParticipantes = nroParticipantes;
		this.idEvento = idEvento;
		this.comisarios = new TreeSet<Comisario>();
	}

	public Boolean agregarComisario(Comisario comisario) throws ComisarioException {

		if (this.comisarios.add(comisario)) {
			return true;
		} else {
			new ComisarioException("comisario ya existe");
		}
		return false;

	}

	public Integer promedioDeEdadComisariosSegunTipo(Tipo observador) {
		Integer promedio = 0;
		Integer edad = 0;
		Integer cantiComisarios = 0;
		for (Comisario comisario : this.comisarios) {
			if (comisario.getTipo().equals(observador)) {
				edad += comisario.getEdad();
				cantiComisarios++;
			}

		}
		promedio = edad / cantiComisarios;
		return promedio;
	}

	public List<Comisario> listaDeComisariosSegunTipo(Tipo juez) {
		List<Comisario> listaComisario = new ArrayList<Comisario>();
		for (Comisario comisario : this.comisarios) {
			if (comisario.getTipo().equals(juez)) {
				listaComisario.add(comisario);
			}

		}
		return listaComisario;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Integer getDuracion() {
		return duracion;
	}

	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}

	public Integer getNroParticipantes() {
		return nroParticipantes;
	}

	public void setNroParticipantes(Integer nroParticipantes) {
		this.nroParticipantes = nroParticipantes;
	}

	public Integer getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(Integer idEvento) {
		this.idEvento = idEvento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idEvento);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Evento other = (Evento) obj;
		return Objects.equals(idEvento, other.idEvento);
	}

}
