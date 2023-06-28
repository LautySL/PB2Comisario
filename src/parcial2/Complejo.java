package parcial2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Complejo implements Comparable<Complejo> {

	private String nombre;
	private Integer area;
	private Integer id;
	private List<Evento> eventos;

	public Complejo(String nombre, Integer area, Integer id) {
		this.nombre = nombre;
		this.area = area;
		this.id = id;
		this.eventos = new ArrayList<Evento>();
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
		Complejo other = (Complejo) obj;
		return Objects.equals(id, other.id);
	}

	public Boolean crearEvento(String fecha, Integer duracion, Integer nroParticipantes, Integer idEvento) {

		Evento evento = new Evento(fecha, duracion, nroParticipantes, idEvento);
		return this.eventos.add(evento);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getArea() {
		return area;
	}

	public void setArea(Integer area) {
		this.area = area;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Evento buscarEvento(Integer idEvento) {
		for (Evento evento : this.eventos) {
			if (evento.getIdEvento().equals(idEvento)) {
				return evento;
			}
		}

		return null;
	}

	public Integer totalDeParticipantesDeLosEvent() {
		Integer promedio = 0;
		Integer participantes = 0;
		Integer cantEventos = 0;

		for (Evento evento : this.eventos) {
			participantes += evento.getNroParticipantes();
			participantes++;
		}

		promedio = participantes / cantEventos;

		return promedio;
	}

	@Override
	public int compareTo(Complejo o) {
		return this.getId().compareTo(o.getId());
	}

}
