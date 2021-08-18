package maquinasDeCafe.ApYp;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MaquinaEstafadoraTest {

	MaquinaDeCafe maquina;

	@Before
	public void setup() {
		maquina = new MaquinaEstafadora();
	}

	@Test
	public void queDevuelveUnVasoAlServir() {
		VasoDeCafe vaso = maquina.servirCafe();
		Assert.assertNotNull(vaso);
	}

	@Test
	public void quePuedeServirUnCafe() {
		Assert.assertTrue(maquina.puedeServir());
	}

	@Test
	public void queElPrimerVasoEstaLlenoYElSiguienteVacio() {
		Assert.assertTrue(maquina.servirCafe().estaLleno());
		Assert.assertFalse(maquina.servirCafe().estaLleno());
		Assert.assertTrue(maquina.servirCafe().estaLleno());
		Assert.assertFalse(maquina.servirCafe().estaLleno());

	}

	@Test
	public void queSeAgotaElCafe() {
		for (int i = 0; i < 200; i++) {
			maquina.servirCafe();
		}
		Assert.assertFalse(maquina.puedeServir());
	}

	@Test
	public void queNoSeAgotaElCafe() {

		VasoDeCafe vaso = null;
		for (int i = 0; i < 199; i++) {
			vaso = maquina.servirCafe();
		}
		Assert.assertTrue(vaso.estaLleno());

	}

	@Test
	public void queLuegoDeAgotarElCafeSirveVasoVacio() {
		for (int i = 0; i < 200; i++) {
			maquina.servirCafe();
		}
		VasoDeCafe vaso = maquina.servirCafe();
		Assert.assertFalse(vaso.estaLleno());
	}

}
