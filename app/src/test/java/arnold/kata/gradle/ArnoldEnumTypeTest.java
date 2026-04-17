package arnold.kata.gradle;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class ArnoldEnumTypeTest {

	public static String[] planetas;

	@BeforeClass
	public static void CreacionArrayPlanetasSetup() {
		planetas = new String[8];
		int planetasIncluidos = 0;
		for (Planetas planeta : Planetas.values()) {
			planetas[planeta.ordinal()] = planeta.name(); /* ordinal() devuelve el index del planeta */
			planetasIncluidos += 1;
		}
		assertThat(planetasIncluidos).isEqualTo(Planetas.values().length);
		assertThat(planetas).doesNotContainNull(); /* values() devuelve en un array todos los planetas */
	}

	@Test
	public void PlanetaConstructorTest() {
		// me aseguro de que los metodos de la api
		// de los Enum Types se comportan como espero
		Planetas planeta = Planetas.MERCURIO;
		assertThat(planeta).isInstanceOf(Planetas.class);
		assertThat(planeta.ordinal()).isZero();
		assertThat(planeta.name()).isEqualToIgnoringCase("MERCURIO");
		assertThat(Planetas.valueOf(planeta.name())).isEqualTo(Planetas.MERCURIO);
		assertThat(planeta.compareTo(Planetas.MERCURIO)).isZero();
		assertThat(planeta.toString()).isEqualToIgnoringCase("MERCURIO");
		assertThat(planeta.equals(Planetas.MERCURIO)).isTrue();
		assertThat(Planetas.values()[0]).isEqualTo(planeta);
	}

	@Test
	public void PlanetaGetMasaTest() {
		Planetas planeta = Planetas.MERCURIO;
		assertThat(planeta.getMasa()).isEqualTo(3.303e+23);
	}

	@Test
	public void PlanetaGetRadioTest() {
		Planetas planeta = Planetas.MERCURIO;
		assertThat(planeta.getRadio()).isEqualTo(2.4397e+6);
	}

	@Test
	public void PlanetaNamesIteratorTest() {
		for (Planetas planeta : Planetas.values()) {
			assertThat(planeta.name()).isIn(planetas);
		}
	}

	@Test
	public void PesoSuperficieMercurioTest() {
		Planetas planeta = Planetas.MERCURIO;
		double pesoHumano = 175;
		assertEquals(66.107583, planeta.pesoPersonaSuperficie(pesoHumano), 0.001);
	}

	@Test
	public void ArrayPlanetasTerrestresTest() {

		String[] planetasTerrestres = new String[4];
		int planetasIncluidos = 0;

		for (int i = Planetas.MERCURIO.ordinal(); i < Planetas.JUPITER.ordinal(); i++) {
			planetasTerrestres[i] = Planetas.values()[i].name();
			planetasIncluidos += 1;
		}
		assertThat(planetasIncluidos).isEqualTo(4);
		assertThat(planetas).doesNotContainNull();

		for (Planetas planeta : Planetas.getPlanetasTerrestres()) {
			assertThat(planeta.name()).isIn(planetasTerrestres);
		}
	}

	@Test
	public void ArrayGigantesGaseosos() {

		String[] gigantesGaseosos = new String[4];
		int planetasIncluidos = 0;

		byte index = 0;
		for (int i = Planetas.JUPITER.ordinal(); i <= Planetas.NEPTUNO.ordinal(); i++) {
			gigantesGaseosos[index] = Planetas.values()[i].name();
			planetasIncluidos += 1;
			index += 1;
		}
		assertThat(planetasIncluidos).isEqualTo(4);
		assertThat(planetas).doesNotContainNull();

		for (Planetas planeta : Planetas.getGigantesGaseosos()) {
			assertThat(planeta.name()).isIn(gigantesGaseosos);
		}
	}
}