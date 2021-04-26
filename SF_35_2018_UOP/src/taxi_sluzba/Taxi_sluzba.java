package taxi_sluzba;

import java.util.ArrayList;


import osobe.Dispeceri;
import osobe.Musterije;
import osobe.Vozaci;

public class Taxi_sluzba {
	
	public int pib;
	public String naziv;
	public String adresa;
	public int cena_start;
	public int cena_km;
	
	private ArrayList<Dispeceri> dispeceri;
	private ArrayList<Musterije> musterije;
	private ArrayList<Vozaci> vozaci;
	
	
	public Taxi_sluzba() {
		
		this.dispeceri= new ArrayList<Dispeceri>();
		this.musterije = new ArrayList<Musterije>();
		this.vozaci = new ArrayList<Vozaci>();
	}
	
	public ArrayList<Dispeceri> getDispeceri() {
		return dispeceri;
	}
	
	public void dodajDispecere(Dispeceri dispeceri) {
		this.dispeceri.add(dispeceri);
	}
	
	public void obrisiDispecere(Dispeceri dispeceri) {
		this.dispeceri.remove(dispeceri);
	}
	
	public Dispeceri nadjiDispecera(String korIme) {
		for(Dispeceri dispecer : dispeceri) {
			if(dispeceri).getKorIme().equals(korIme)) {
				return dispecer;
			}
		}
		return null;
	}
	public Dispeceri login(String korIme, String lozinka) {
		for(Dispeceri dispecer : dispeceri) {
			if(dispecer.getKorIme().equalsIgnoreCase(korIme) &&
					dispecer.getLozinka().equals(lozinka) && !dispecer.isObrisan()) {
				return dispecer;
			}
		}
		return null;
	}
	
	public ArrayList<Musterije> getMusterije() {
		return musterije; 
	}
	
	public void dodajMusteriju(Musterije musterije) {
		this.musterije.add(musterije);
	}
	
	public void obrisiMusteriju(Musterije musterije) {
		this.musterije.remove(musterije);
	}
	
	public void 
	
	
	
	

}
