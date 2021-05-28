package voznja;

import java.time.LocalDateTime;

import osobe.Musterija;
import osobe.Vozac;

public class Voznja {
	
	private int id;
	private LocalDateTime datum_porudzbine;
	private String adresa_polaska;
	private String adresa_destinacije;
	private Musterija musterija;
	private Vozac vozac;
	private double predjeni_km;
	private double trajanje_voznje;
	private StatusVoznje status_voznje;
	private boolean obrisan;
	
	public Voznja(int id, LocalDateTime datum_porudzbine, String adresa_polaska, String adresa_destinacije, Musterija musterija,
			Vozac vozac, double predjeni_km, double trajanje_voznje, StatusVoznje status_voznje, boolean obrisan) {
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
		this.obrisan = obrisan;
	}

	public long getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getDatum_porudzbine() {
		return datum_porudzbine;
	}
	
	public void setDatum_porudzbine(LocalDateTime datum_porudzbine) {
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
	
	public boolean isObrisan() {
		return obrisan;
	}

	public void setObrisan(boolean obrisan) {
		this.obrisan = obrisan;
	}

	@Override
	public String toString() {
		return  "Id: " + id + "\n" + "Datum i vreme porudzbine: " + datum_porudzbine + "\n" + "Adresa polaska: " + adresa_polaska
				+ "\n" + "Adresa destinacije: " + adresa_destinacije + "\n" +  "Musterija= " + musterija + "\n" + "Vozac: " + vozac
				+ "\n" + "Predjeni kilometri: " + predjeni_km + "\n" +  "Trajanje voznje: " + trajanje_voznje + "\n" + "Status voznje: "
				+ status_voznje + "\n" + "Obrisan" + obrisan + "|";
	}
}

