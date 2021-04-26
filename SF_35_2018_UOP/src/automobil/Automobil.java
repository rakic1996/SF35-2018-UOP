package automobil;

public class Automobil {
	
	private String model;
	private String poizvodjac;
	private String godProizvodnje;
	private String registracija;
	private String brVozila;
	private String vrstaA;
}

   	public Automobil() {
   		this.model = "";
   		this.poizvodjac = "";
   		this.godProizvodnje = "";
   		this.registracija = "";
   		this.brVozila = "";
   		this.vrstaA = "";
   		
   	}

	public Automobil(String model, String poizvodjac, String godProizvodnje, String registracija, String brVozila,
			String vrstaA) {
		super();
		this.model = model;
		this.poizvodjac = poizvodjac;
		this.godProizvodnje = godProizvodnje;
		this.registracija = registracija;
		this.brVozila = brVozila;
		this.vrstaA = vrstaA;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getPoizvodjac() {
		return poizvodjac;
	}

	public void setPoizvodjac(String poizvodjac) {
		this.poizvodjac = poizvodjac;
	}

	public String getGodProizvodnje() {
		return godProizvodnje;
	}

	public void setGodProizvodnje(String godProizvodnje) {
		this.godProizvodnje = godProizvodnje;
	}

	public String getRegistracija() {
		return registracija;
	}

	public void setRegistracija(String registracija) {
		this.registracija = registracija;
	}

	public String getBrVozila() {
		return brVozila;
	}

	public void setBrVozila(String brVozila) {
		this.brVozila = brVozila;
	}

	public String getVrstaA() {
		return vrstaA;
	}

	public void setVrstaA(String vrstaA) {
		this.vrstaA = vrstaA;
	}

	@Override
	public String toString() {
		return "Automobil [model=" + model + ", poizvodjac=" + poizvodjac + ", godProizvodnje=" + godProizvodnje
				+ ", registracija=" + registracija + ", brVozila=" + brVozila + ", vrstaA=" + vrstaA + "]";
	}
   	
	
   	
}
