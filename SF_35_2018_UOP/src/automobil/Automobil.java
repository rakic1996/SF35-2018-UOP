package automobil;

public class Automobil {
	
	private int id;
	private String model;
	private String proizvodjac;
	private int godProizvodnje;
	private String registracija;
	private String brVozila;
	private VrstaAutomobila vrstaAutomobila;


   	public Automobil() {
   		this.model = "";
   		this.proizvodjac = "";
   		this.registracija = "";
   		this.brVozila = "";
   		//this.vrstaAutomobila = "";

   		
   	}

	public Automobil(int id, String model, String poizvodjac, int godProizvodnje, String registracija, String brVozila,
			VrstaAutomobila vrstaAutomobila) {
		super();
		this.id = id;
		this.model = model;
		this.proizvodjac = poizvodjac;
		this.godProizvodnje = godProizvodnje;
		this.registracija = registracija;
		this.brVozila = brVozila;
		this.vrstaAutomobila = vrstaAutomobila;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getGodProizvodnje() {
		return godProizvodnje;
	}

	public void setGodProizvodnje(int godProizvodnje) {
		this.godProizvodnje = godProizvodnje;
	}

	public VrstaAutomobila getVrstaAutomobila() {
		return vrstaAutomobila;
	}

	public void setVrstaAutomobila(VrstaAutomobila vrstaAutomobila) {
		this.vrstaAutomobila = vrstaAutomobila;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getProizvodjac() {
		return proizvodjac;
	}

	public void setProizvodjac(String proizvodjac) {
		this.proizvodjac = proizvodjac;
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

	@Override
	public String toString() {
		return  id + "\n" + "Model:" + model + "\n" + "Proizvodjac:" + proizvodjac + "\n" +  "Godina proizvodnje: "
				+ godProizvodnje + "\n" +  "Registarska oznaka: " + registracija + "\n" + "Broj vozila: " + brVozila + "\n" + "Vrsta automobila: "
				+ vrstaAutomobila + "\n";
	}
	
}
