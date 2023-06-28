package parcial2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class testOlimpiadas {

	@Test
	public void queSePuedaCrearUnComplejoSimpleEnUnaSedeOlimpica() {

		String nombre = "Cualquiera";
		SedeOlimpica sedeOlim = new SedeOlimpica(nombre);

		String nombreCom = "pepito";

		Integer id = 41;
		assertTrue(sedeOlim.crearComplejoSim(nombreCom, 728, id));

	}

	@Test
	public void queSePuedaCrearUnComplejoPolideportivoConUnAreaEnUnaSedeOlimpica() throws IndicadorAreaException {
		String nombre = "Cualquiera";
		SedeOlimpica sedeOlim = new SedeOlimpica(nombre);

		String nombreCom = "pepito";
		String ubicacion = "Centro";
		Integer id = 41;

		assertTrue(sedeOlim.crearComplejoPoli(nombreCom, 728, ubicacion, id));

	}

	@Test
	public void queSePuedaCrearUnComplejoPolideportivoConUnAreaYUnEventoEnUnaSedeOlimpica()
			throws IndicadorAreaException {
		String nombre = "Cualquiera";
		SedeOlimpica sedeOlim = new SedeOlimpica(nombre);

		String nombreCom = "pepito";
		String ubicacion = "Centro";
		Integer id = 41;

		assertTrue(sedeOlim.crearComplejoPoli(nombreCom, 728, ubicacion, id));

		String fecha = "07/07/2022";
		Integer duracion = 35;
		Integer nroParticipantes = 204;

		Integer idEvento = 2;

		assertTrue(sedeOlim.getComplejoOlim(id).crearEvento(fecha, duracion, nroParticipantes, idEvento));

	}

	@Test(expected = IndicadorAreaException.class)
	public void queAlAgregarUnAreaAUnPolideportivoConIndicadorYaExistenteLanceUnaExcepcionIndicadorAreaException()
			throws IndicadorAreaException {
		String nombre = "Cualquiera";
		SedeOlimpica sedeOlim = new SedeOlimpica(nombre);

		String nombreCom = "pepito";
		String ubicacion = "Centro";
		Integer id = 41;

		sedeOlim.crearComplejoPoli(nombreCom, 728, ubicacion, id);
		sedeOlim.crearComplejoPoli(nombreCom, 728, ubicacion, id);

	}

	@Test(expected = ComisarioException.class)
	public void queAlAgregarUnComisarioJuezExistenteLanceUnaExcepcionComisarioException()
			throws ComisarioException, IndicadorAreaException {
		String nombre = "Cualquiera";
		SedeOlimpica sedeOlim = new SedeOlimpica(nombre);

		String nombreCom = "pepito";
		String ubicacion = "Centro";
		Integer id = 41;

		sedeOlim.crearComplejoPoli(nombreCom, 728, ubicacion, id);

		String fecha = "07/07/2022";
		Integer duracion = 35;
		Integer nroParticipantes = 204;
		String nombreComisario = "juan";
		Integer edad = 51;
		Integer idEvento = 2;

		Comisario comisario = new Comisario(Tipo.JUEZ, nombreComisario, edad, 250);

		sedeOlim.getComplejoOlim(id).crearEvento(fecha, duracion, nroParticipantes, idEvento);
		sedeOlim.getComplejoOlim(id).buscarEvento(idEvento).agregarComisario(comisario);

		sedeOlim.getComplejoOlim(id).buscarEvento(idEvento).agregarComisario(comisario);

	}

	@Test
	public void queSePuedaCalcularElTotalDeParticipantesDeLosEventosDeUnComplejoSimple() {

		String nombre = "Cualquiera";
		SedeOlimpica sedeOlim = new SedeOlimpica(nombre);

		String nombreCom = "pepito";
		Integer id = 41;

		sedeOlim.crearComplejoSim(nombreCom, 728, id);
		sedeOlim.getComplejoOlim(id);

		String fecha = "07/07/2022";
		Integer duracion = 35;
		Integer nroParticipantes = 204;

		sedeOlim.getComplejoOlim(id).crearEvento(fecha, duracion, nroParticipantes, 78);
		sedeOlim.getComplejoOlim(id).crearEvento(fecha, duracion, nroParticipantes, 29);
		sedeOlim.getComplejoOlim(id).crearEvento(fecha, duracion, nroParticipantes, 3);
		sedeOlim.getComplejoOlim(id).crearEvento(fecha, duracion, nroParticipantes, 41);

		Integer resultado = nroParticipantes * 4;

		assertEquals(sedeOlim.getComplejoOlim(id).totalDeParticipantesDeLosEvent(), resultado);

	}

	@Test
	public void queSePuedaCalcularElPromedioDeEdadDeLosComisariosObservadoresDeUnEventoEspecifico()
			throws ComisarioException, IndicadorAreaException {

		String nombre = "Cualquiera";
		SedeOlimpica sedeOlim = new SedeOlimpica(nombre);

		String nombreCom = "pepito";
		String ubicacion = "Centro";
		Integer id = 41;

		sedeOlim.crearComplejoPoli(nombreCom, 728, ubicacion, id);

		String fecha = "07/07/2022";
		Integer duracion = 35;
		Integer nroParticipantes = 204;
		String nombreComisario = "juan";
		Integer edad = 51;
		Integer idEvento = 2;

		Comisario comisario = new Comisario(Tipo.OBSERVADOR, nombreComisario, edad, 250);
		Comisario comisario2 = new Comisario(Tipo.OBSERVADOR, nombreComisario, 36, 250);
		Comisario comisario3 = new Comisario(Tipo.OBSERVADOR, nombreComisario, 60, 250);
		Comisario comisario4 = new Comisario(Tipo.OBSERVADOR, nombreComisario, 45, 250);

		sedeOlim.getComplejoOlim(id).crearEvento(fecha, duracion, nroParticipantes, idEvento);

		sedeOlim.getComplejoOlim(id).buscarEvento(idEvento).agregarComisario(comisario);
		sedeOlim.getComplejoOlim(id).buscarEvento(idEvento).agregarComisario(comisario2);
		sedeOlim.getComplejoOlim(id).buscarEvento(idEvento).agregarComisario(comisario3);
		sedeOlim.getComplejoOlim(id).buscarEvento(idEvento).agregarComisario(comisario4);

		Integer resultadoBuscado = (51 + 36 + 60 + 45) / 4;

		Integer resultado = sedeOlim.getComplejoOlim(id).buscarEvento(idEvento)
				.promedioDeEdadComisariosSegunTipo(Tipo.OBSERVADOR);

		assertEquals(resultado, resultadoBuscado);

	}

	@Test
	public void queSePuedaObtenerUnaListaDeComisariosJuecesDeUnEventoEspecificoSinRepeticiones()
			throws ComisarioException, IndicadorAreaException {
		String nombre = "Cualquiera";
		SedeOlimpica sedeOlim = new SedeOlimpica(nombre);

		String nombreCom = "pepito";
		String ubicacion = "Centro";
		Integer id = 41;

		sedeOlim.crearComplejoPoli(nombreCom, 728, ubicacion, id);

		String fecha = "07/07/2022";
		Integer duracion = 35;
		Integer nroParticipantes = 204;
		String nombreComisario = "juan";
		Integer edad = 51;
		Integer idEvento = 2;

		Comisario comisario = new Comisario(Tipo.JUEZ, nombreComisario, edad, 250);
		Comisario comisario2 = new Comisario(Tipo.OBSERVADOR, nombreComisario, 36, 250);
		Comisario comisario3 = new Comisario(Tipo.JUEZ, nombreComisario, 60, 250);
		Comisario comisario4 = new Comisario(Tipo.JUEZ, nombreComisario, 45, 250);

		sedeOlim.getComplejoOlim(id).crearEvento(fecha, duracion, nroParticipantes, idEvento);

		sedeOlim.getComplejoOlim(id).buscarEvento(idEvento).agregarComisario(comisario);
		sedeOlim.getComplejoOlim(id).buscarEvento(idEvento).agregarComisario(comisario2);
		sedeOlim.getComplejoOlim(id).buscarEvento(idEvento).agregarComisario(comisario3);
		sedeOlim.getComplejoOlim(id).buscarEvento(idEvento).agregarComisario(comisario4);

		assertNotNull(sedeOlim.getComplejoOlim(id).buscarEvento(idEvento).listaDeComisariosSegunTipo(Tipo.JUEZ));

	}

	@Test
	public void queSePuedaObtenerUnMapaDeUnComplejoPolideportivoConNombreDeComplejoYUbicacion()
			throws IndicadorAreaException {

		String nombre = "Cualquiera";
		SedeOlimpica sedeOlim = new SedeOlimpica(nombre);

		String nombreCom = "pepito";
		String ubicacion = "Centro";
		Integer id = 41;

		sedeOlim.crearComplejoPoli(nombreCom, 728, ubicacion, id);

		assertNotNull(sedeOlim.obtenerMapaDelComplejo(id));

	}

}
