package osobe;

public class Dispecer extends Korisnik {

	private double plata;
	private String telefonska_linija;
	private Odeljenje odeljenje;
	
	public Dispecer() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Dispecer(String korIme, String lozinka, String ime, String prezime, String jmbg, String adresa, Pol pol, String brTelefona, boolean obrisan,
			double plata, String telefonska_linija, Odeljenje odeljenje, Uloga uloga) {
		super(korIme, lozinka, ime, prezime, jmbg, adresa, pol, brTelefona, obrisan, uloga);
		this.plata = plata;
		this.telefonska_linija = telefonska_linija;
		this.odeljenje = odeljenje;
	}

	public double getPlata() {
		return plata;
	}
	
	public void setPlata(double plata) {
		this.plata = plata;
	}
	
	public String getTelefonska_linija() {
		return telefonska_linija;
	}
	
	public void setTelefonska_linija(String telefonska_linija) {
		this.telefonska_linija = telefonska_linija;
	}
	
	public Odeljenje getOdeljenje() {
		return odeljenje;
	}
	
	public void setOdeljenje(Odeljenje odeljenje) {
		this.odeljenje = odeljenje;
	}

	@Override
	public String toString() {
		return  "\n" + "Plata:" + plata + "\n" + "Telefonska_linija:" + telefonska_linija + "\n" + "Odeljenje:"
				+ odeljenje + "\n" + "Korisnicko ime:" + getKorIme() + "\n" + "Lozinka:"  +  getLozinka() + "\n" + "Ime:"
				+ getIme() + "\n" +"Prezime:" + getPrezime() + "\n" + "Jmbg:" + getJmbg() + "\n" + "Adresa:" 
				+ getAdresa() + "\n" + "Pol: " +  getPol() + "\n" + getBrTelefona() + "\n";

	}
}

