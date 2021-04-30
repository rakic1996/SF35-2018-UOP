package osobe;

import automobil.Automobil;

public class Vozac extends Korisnik {
	
	private long id;
	private double plata;
	private String clanska_karta;
	private Automobil automobil;
	
	public Vozac() {
		super();
	}

	
	public Vozac(String korIme, String lozinka, String ime, String prezime, String jmbg, String adresa, Pol pol,
			long id, double plata, String clanska_karta, Automobil automobil) {
		super(korIme, lozinka, ime, prezime, jmbg, adresa, pol);
		this.id = id;
		this.plata = plata;
		this.clanska_karta = clanska_karta;
		this.automobil = automobil;
		
	}

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getPlata() {
		return plata;
	}

	public void setPlata(double plata) {
		this.plata = plata;
	}

	public String getClanska_karta() {
		return clanska_karta;
	}

	public void setClanska_karta(String clanska_karta) {
		this.clanska_karta = clanska_karta;
	}

	public Automobil getAutomobil() {
		return automobil;
	}

	public void setAutomobil(Automobil automobil) {
		this.automobil = automobil;
	}


	@Override
	public String toString() {
		return  "\n" + "Vozac: " + id + "\n" + "Plata: " + plata + "\n" + "Clanska karta broj: " + clanska_karta + "\n" + "Automobil: " + automobil +"\n" 
				+ "Koisnicko ime: " + getKorIme() + "\n" + "Lozinka: " + getLozinka() + "\n" + "Ime: " + getIme() + "\n" 
				+ "Prezime: " + getPrezime() + "\n" + "Jmbg: " + getJmbg() + "\n" + "Adresa: " + getAdresa() + "\n" 
				+ "Pol: " + getPol() + "\n";
	}

}	


//  + "toString" + super.toString() + "s getClass()="
//		+ getClass() + "\n" + " hashCode()=" + hashCode() + "\n";