package osobe;

public class Dispecer extends Korisnik {

	private int id;
	private double plata;
	private String telefonska_linija;
	private Odeljenje odeljenje;
	
	
	
	public Dispecer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Dispecer(String korIme, String lozinka, String ime, String prezime, String jmbg, String adresa, Pol pol,
			int id, double plata, String telefonska_linija, Odeljenje odeljenje) {
		super(korIme, lozinka, ime, prezime, jmbg, adresa, pol);
		this.id = id;
		this.plata = plata;
		this.telefonska_linija = telefonska_linija;
		this.odeljenje = odeljenje;
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		return "Dispecer id:" + id +  "\n" + "Plata:" + plata + "\n" + "Telefonska_linija:" + telefonska_linija + "\n" + "Odeljenje:" + "\n"
				+ odeljenje + "Korisnicko ime:" + "\n" + getKorIme() + "Lozinka:" + "\n" +  getLozinka() + "Ime:" + "\n"
				+ getIme() + "Prezime:" + "\n" + getPrezime() + "\n" + "Jmbg:" + "\n" + getJmbg() + "Adresa:" + "\n"
				+ getAdresa() + "Pol:" + "\n" + getPol() + " toString()=" + super.toString() + "s getClass()="
				+ getClass() + " hashCode()=" + hashCode() + "]";
	}

	
//	//OVO POGLEDAJ DA LI JE DOBRO U TAXI_SLUZBA.JAVA KOD DISPECERI LOGIN ISOBRISAN
//	public boolean isObrisan() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//	
//	
}


