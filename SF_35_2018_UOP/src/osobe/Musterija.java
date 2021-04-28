package osobe;

public class Musterija extends Korisnik {	


	private int id;
	

	public Musterija() {
		super();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	
	


	public Musterija(String korIme, String lozinka, String ime, String prezime, String jmbg, String adresa, Pol pol, int id) {
		super(korIme, lozinka, ime, prezime, jmbg, adresa, pol);
		this.id = id;
	}


	@Override
	public String toString() {
		return "Musterija id: " + id + "\n" + "Korisnicko ime: " + getKorIme() + "\n" + "Lozinka: " + getLozinka() + "\n" + "Ime: "
				+ getIme() + "\n" + "Prezime: " + getPrezime() + "\n" + "Jmbg: " + getJmbg() + "\n" + "Adresa: "
				+ getAdresa() + "\n" + ", Pol: " + getPol() + "\n" + ", toString()=" + super.toString() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() +"\n";
	}
	
}
