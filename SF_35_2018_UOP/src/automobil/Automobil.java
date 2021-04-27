package automobil;

public class Automobil {
	
	private String model;
	private String poizvodjac;
	private int godProizvodnje;
	private String registracija;
	private String brVozila;
	private VrstaAutomobila vrstaAutomobila;


   	public Automobil() {
   		this.model = "";
   		this.poizvodjac = "";
   		this.registracija = "";
   		this.brVozila = "";
   		
   	}

	public Automobil(String model, String poizvodjac, String godProizvodnje, String registracija, String brVozila,
			String vrstaA) {
		super();
		this.model = model;
		this.poizvodjac = poizvodjac;
		this.registracija = registracija;
		this.brVozila = brVozila;
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
}
