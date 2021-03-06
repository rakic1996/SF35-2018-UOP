package osobe;

public abstract class Korisnik  {
	
	private String korIme;
	private String lozinka;
	private String ime;
	private String prezime;
	private String jmbg;
	private String adresa;
	private Pol pol;
	private String brTelefona;
	private boolean obrisan; 
	private Uloga uloga;
	
	public Korisnik() {
		this.korIme = "";
		this.lozinka = "";
		this.ime = "";
		this.prezime = "";
		this.jmbg = "";
		this.adresa = "";
		this.pol = Pol.MUSKI;
		this.brTelefona = "";
		this.obrisan = false;
	}
	
 	public Korisnik(String korIme, String lozinka, String ime, String prezime, String jmbg, String adresa, Pol pol, String brTelefona, boolean obrisan, Uloga uloga) {
		super();
		this.korIme = korIme;
		this.lozinka = lozinka;
		this.ime = ime;
		this.prezime = prezime;
		this.jmbg = jmbg;
		this.adresa = adresa;
		this.pol = pol;
		this.brTelefona = brTelefona;
		this.obrisan = obrisan;
		this.uloga = uloga;
 	}

	public String getKorIme() {
		return korIme;
	}

	public void setKorIme(String korIme) {
		this.korIme = korIme;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public Pol getPol() {
		return pol;
	}

	public void setPol(Pol pol) {
		this.pol = pol;
	}
	
	public String getBrTelefona() {
		return brTelefona;
	}

	public void setBrTelefona(String brTelefona) {
		this.brTelefona = brTelefona;
	}
		
	public boolean isObrisan() {
		return obrisan;
	}

	public void setObrisan(boolean obrisan) {
		this.obrisan = obrisan;
	}
	
	public Uloga getUloga() {
		return uloga;
	}

	public void setUloga(Uloga uloga) {
		this.uloga = uloga;
	}

	@Override
	public String toString() {
		return "Korisnicko ime:  " + korIme + "\n" + "Lozinka:" + lozinka + "\n" 
				+ "Ime:" + ime + "Prezime:" + prezime + "\n" 
				+ "Jmbg: " + jmbg + "\n" + "Adresa: " + adresa + "Pol:" + pol + "\n"
				+ "Broj telefona: " + "Obrisan" + obrisan + "\n";
	}
	
}
