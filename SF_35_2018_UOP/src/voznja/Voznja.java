package voznja;

import java.util.Date;

import osobe.Musterija;
import osobe.Vozac;

public class Voznja {
	
	private long id;
	private Date datum_porudzbine;
	private String adresa_polaska;
	private String adresa_destinacije;
	private Musterija musterija;
	private Vozac vozac;
	private double predjeni_km;
	private double trajanje_voznje;
	private StatusVoznje status_voznje;
	
	public Voznja(long id, Date datum_porudzbine, String adresa_polaska, String adresa_destinacije, Musterija musterija,
			Vozac vozac, double predjeni_km, double trajanje_voznje, StatusVoznje status_voznje) {
		super();
		this.id = id;
		this.datum_porudzbine = datum_porudzbine;
		this.adresa_polaska = adresa_polaska;
		this.adresa_destinacije = adresa_destinacije;
		this.musterija = musterija;
		this.vozac = vozac;
		this.predjeni_km = predjeni_km;
		this.trajanje_voznje = trajanje_voznje;
		this.status_voznje = status_voznje;
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public Date getDatum_porudzbine() {
		return datum_porudzbine;
	}
	
	public void setDatum_porudzbine(Date datum_porudzbine) {
		this.datum_porudzbine = datum_porudzbine;
	}
	public String getAdresa_polaska() {
		return adresa_polaska;
	}
	
	public void setAdresa_polaska(String adresa_polaska) {
		this.adresa_polaska = adresa_polaska;
	}
	
	public String getAdresa_destinacije() {
		return adresa_destinacije;
	}
	
	public void setAdresa_destinacije(String adresa_destinacije) {
		this.adresa_destinacije = adresa_destinacije;
	}
	
	
	public Musterija getMusterija() {
		return musterija;
	}
	
	public void setMusterija(Musterija musterija) {
		this.musterija = musterija;
	}
	
	public Vozac getVozac() {
		return vozac;
	}
	
	public void setVozac(Vozac vozac) {
		this.vozac = vozac;
	}
	
	public double getPredjeni_km() {
		return predjeni_km;
	}
	
	public void setPredjeni_km(double predjeni_km) {
		this.predjeni_km = predjeni_km;
	}
	
	public double getTrajanje_voznje() {
		return trajanje_voznje;
	}
	
	public void setTrajanje_voznje(double trajanje_voznje) {
		this.trajanje_voznje = trajanje_voznje;
	}
	
	public StatusVoznje getStatus_voznje() {
		return status_voznje;
	}
	
	public void setStatus_voznje(StatusVoznje status_voznje) {
		this.status_voznje = status_voznje;
	}
	
	
}

