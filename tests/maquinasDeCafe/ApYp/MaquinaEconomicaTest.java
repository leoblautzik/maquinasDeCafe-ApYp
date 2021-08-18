package maquinasDeCafe.ApYp;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MaquinaEconomicaTest {
	MaquinaDeCafe maquina;

	@Before
	public void setup() {
		maquina = new MaquinaEconomica();
	}

	@Test
	public void queDevuelveUnVasoAlServir() {
		VasoDeCafe vaso = maquina.servirCafe();
		Assert.assertNotNull(vaso);
	}

	@Test
	public void quePuedeServirUnCafe() {
		maquina.servirCafe();
		Assert.assertTrue(maquina.puedeServir());
	}

	@Test
	public void queNoRestaAntesDelTercero() {
		maquina.servirCafe();
		maquina.servirCafe();
		assertEquals(1000, maquina.getGramosDeCafe());
	}

	@Test
	public void queRestaDespuesDelTercero() {
		maquina.servirCafe();
		maquina.servirCafe();
		maquina.servirCafe();
		assertEquals(1000 - 10, maquina.getGramosDeCafe());
	}

	@Test
	public void queNoSeAgotaElCafe() {
		for (int i = 0; i < 299; i++) {
			maquina.servirCafe();
		}
		Assert.assertTrue(maquina.puedeServir());
	}

	@Test
	public void queSeAgotaElCafe() {
		for (int i = 0; i < 300; i++) {
			maquina.servirCafe();
		}
		Assert.assertFalse(maquina.puedeServir());
	}

	@Test
	public void queLuegoDeAgotarElCafeSirveVasoVacio() {
		for (int i = 0; i < 300; i++) {
			maquina.servirCafe();
		}
		VasoDeCafe vaso = maquina.servirCafe();
		Assert.assertFalse(vaso.estaLleno());
	}

}
