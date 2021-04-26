package taxi_sluzba;

import java.util.ArrayList;

import osobe.Dispecer;
import osobe.Musterija;
import osobe.Vozac;

public class Taxi_sluzba {
	
	public int pib;
	public String naziv;
	public String adresa;
	public int cena_start;
	public int cena_km;
	
	private ArrayList<Dispecer> dispeceri;
	private ArrayList<Musterija> musterije;
	private ArrayList<Vozac> vozaci;
	private Vozac vozac;
	
	
	public Taxi_sluzba() {
		
		this.dispeceri= new ArrayList<Dispecer>();
		this.musterije = new ArrayList<Musterija>();
		this.vozaci = new ArrayList<Vozac>();
	}
	
	public ArrayList<Dispecer> getDispeceri() {
		return dispeceri;
	}
	
	public void dodajDispecere(Dispecer dispeceri) {
		this.dispeceri.add(dispeceri);
	}
	
	public void obrisiDispecere(Dispecer dispeceri) {
		this.dispeceri.remove(dispeceri);
	}
	
	public Dispecer nadjiDispecera(String korIme) {
		for(Dispecer dispecer : dispeceri) {
			if(dispeceri).getKorIme().equals(korIme)) {
				return dispecer;
			}
		}
		return null;
	}
	public Dispecer login(String korIme, String lozinka) {
		for(Dispecer dispecer : dispeceri) {
			if(dispecer.getKorIme().equalsIgnoreCase(korIme) &&
					dispecer.getLozinka().equals(lozinka) && !dispecer.isObrisan()) {
				return dispecer;
			}
		}
		return null;
	}

	public ArrayList<Musterija> getMusterije() {
		return musterije;
	}

	public void dodajMusteriju(Musterija musterije) {
		this.musterije.add(musterije);
	}

	public void obrisiMusteriju(Musterija musterije) {
		this.musterije.remove(musterije);
	}

	public ArrayList<Vozac> getVozaci() {
		return vozaci;
	}

	public void dodajVozaca(Vozac vozaci) {
		this.vozaci.add(vozac);
	}

	public void obrisiVozaca(Vozac vozac) {
		this.vozaci.remove(vozac);
	}

	public void ucitajDispecera(String DISPECER_FAJL) {
		// TODO Auto-generated method stub
		
	}

	public void ucitajVozaca(String VOZAC_FAJL) {
		// TODO Auto-generated method stub
		
	}

	

	
	

	
	


	


		
	}
	

	
	
	

}
