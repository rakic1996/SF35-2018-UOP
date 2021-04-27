package osobe;

public class Korisnik {
	
	private String korIme;
	private String lozinka;
	private String ime;
	private String prezime;
	private String jmbg;
	private String adresa;
	private Pol pol;
	
	public Korisnik() {
		
	}
	
 	public Korisnik(String korIme, String lozinka, String ime, String prezime, String jmbg, String adresa, Pol pol) {
		super();
		this.korIme = korIme;
		this.lozinka = lozinka;
		this.ime = ime;
		this.prezime = prezime;
		this.jmbg = jmbg;
		this.adresa = adresa;
		this.pol = pol;
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

	@Override
	public String toString() {
		return "Korisnik [korIme=" + korIme + ", lozinka=" + lozinka + ", ime=" + ime + ", prezime=" + prezime
				+ ", jmbg=" + jmbg + ", adresa=" + adresa + ", pol=" + pol + "]";
	}
	
}
