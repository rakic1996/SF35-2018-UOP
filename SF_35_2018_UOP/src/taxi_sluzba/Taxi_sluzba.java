package taxi_sluzba;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import osobe.Dispecer;
import osobe.Musterija;
import osobe.Odeljenje;
import osobe.Pol;
import osobe.Vozac;

public class Taxi_sluzba {
	
	private long id;
	private int pib;
	private String naziv;
	private String adresa;
	private int cena_start;
	private int cena_km;
	
	private ArrayList<Dispecer> dispeceri;
	private ArrayList<Musterija> musterije;
	private ArrayList<Vozac> vozaci;
	
	
	public Taxi_sluzba() {
		
		this.dispeceri= new ArrayList<Dispecer>();
		this.musterije = new ArrayList<Musterija>();
		this.vozaci = new ArrayList<Vozac>();
	}
	
	


	public Taxi_sluzba(long id, int pib, String naziv, String adresa, int cena_start, int cena_km) {
		super();
		this.id = id;
		this.pib = pib;
		this.naziv = naziv;
		this.adresa = adresa;
		this.cena_start = cena_start;
		this.cena_km = cena_km;
		this.dispeceri= new ArrayList<Dispecer>();
		this.musterije = new ArrayList<Musterija>();
		this.vozaci = new ArrayList<Vozac>();
	
	}
	
	
	public void dodajDispecera(Dispecer dispecer) {
		this.dispeceri.add(dispecer);
	}
	

	public void cuvanjeDispecera(String imeFajla) {
		try {
			File file = new File("src/fajlovi/" + imeFajla);
			String content = "";
			for (Dispecer dispecer : dispeceri) {
				content += dispecer.getKorIme() + "|" + dispecer.getLozinka() + "|"
						+ dispecer.getIme() + "|" + dispecer.getPrezime() + "|"
						+ dispecer.getPol() + "|" + dispecer.getId() + "|"
						+ dispecer.getPlata() + "|" + dispecer.getTelefonska_linija() + "|" + dispecer.getOdeljenje()+ "|" + dispecer.getAdresa() + "|" + dispecer.getJmbg() + "\n";
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(content);
			writer.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja dispecera.");
		}
	}
		

	public void ucitajDispecere(String imeFajla) {
		try {
			File file = new File("src/fajlovi/" + imeFajla);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] split = line.split("\\|");
				String korIme = split[0];
				String lozinka = split[1];
				String ime = split[2];
				String prezime = split[3];
				String polString = split[4];
				Pol pol = Pol.valueOf(polString);
				String idString = split[5];
				int id = Integer.parseInt(idString);
				double plata = Double.parseDouble(split[6]);
				String telefonska_linija = split[7];
				String odeljenjeString = split[8];
				Odeljenje odeljenje = Odeljenje.valueOf(odeljenjeString);
				String adresa = split[9];
				String jmbg = split[10];
				Dispecer dispecer = new Dispecer(korIme, lozinka, ime, prezime,
						jmbg, adresa, pol, id, plata, telefonska_linija, odeljenje);
				this.dispeceri.add(dispecer);
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja podataka o knjigama");
			e.printStackTrace();
		}
	


////////////////////////////////////////////////////////////////////
		
		
//		public void dodajMusteriju(Musterija musterija) {
//			this.musterije.add(musterija);
//		}
//		
//
//		public void cuvanjeDispecera(String imeFajla) {
//			try {
//				File file = new File("src/fajlovi/" + imeFajla);
//				String content = "";
//				for (Dispecer dispecer : dispeceri) {
//					content += dispecer.getKorIme() + "|" + dispecer.getLozinka() + "|"
//							+ dispecer.getIme() + "|" + dispecer.getPrezime() + "|"
//							+ dispecer.getPol() + "|" + dispecer.getId() + "|"
//							+ dispecer.getPlata() + "|" + dispecer.getTelefonska_linija() + "|" + dispecer.getOdeljenje()+ "|" + dispecer.getAdresa() + "|" + dispecer.getJmbg() + "\n";
//				}
//				BufferedWriter writer = new BufferedWriter(new FileWriter(file));
//				writer.write(content);
//				writer.close();
//			} catch (IOException e) {
//				System.out.println("Greska prilikom snimanja dispecera.");
//			}
//		}
//			
//
//		public void ucitajDispecere(String imeFajla) {
//			try {
//				File file = new File("src/fajlovi/" + imeFajla);
//				BufferedReader reader = new BufferedReader(new FileReader(file));
//				String line;
//				while ((line = reader.readLine()) != null) {
//					String[] split = line.split("\\|");
//					String korIme = split[0];
//					String lozinka = split[1];
//					String ime = split[2];
//					String prezime = split[3];
//					String polString = split[4];
//					Pol pol = Pol.valueOf(polString);
//					String idString = split[5];
//					int id = Integer.parseInt(idString);
//					double plata = Double.parseDouble(split[6]);
//					String telefonska_linija = split[7];
//					String odeljenjeString = split[8];
//					Odeljenje odeljenje = Odeljenje.valueOf(odeljenjeString);
//					String adresa = split[9];
//					String jmbg = split[10];
//					Dispecer dispecer = new Dispecer(korIme, lozinka, ime, prezime,
//							jmbg, adresa, pol, id, plata, telefonska_linija, odeljenje);
//					this.dispeceri.add(dispecer);
//				}
//				reader.close();
//			} catch (IOException e) {
//				System.out.println("Greska prilikom snimanja podataka o knjigama");
//				e.printStackTrace();
//			}
//		
//	
//	
//	
//		
//		
		
		
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public int getPib() {
		return pib;
		
	}


	public void setPib(int pib) {
		this.pib = pib;
	}


	public String getNaziv() {
		return naziv;
	}


	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getAdresa() {
		return adresa;
	}




	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}




	public int getCena_start() {
		return cena_start;
	}




	public void setCena_start(int cena_start) {
		this.cena_start = cena_start;
	}




	public int getCena_km() {
		return cena_km;
	}




	public void setCena_km(int cena_km) {
		this.cena_km = cena_km;
	}




	public void setDispeceri(ArrayList<Dispecer> dispeceri) {
		this.dispeceri = dispeceri;
	}




	public void setMusterije(ArrayList<Musterija> musterije) {
		this.musterije = musterije;
	}




	public void setVozaci(ArrayList<Vozac> vozaci) {
		this.vozaci = vozaci;
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
	
//	public Dispecer nadjiDispecera(String korIme) {
//		for(Dispecer dispecer : dispeceri) {
//			if(dispeceri).getKorIme().equals(korIme)) {
//				return dispecer;
//			}
//		}
//		return null;
//	}
//	public Dispecer login(String korIme, String lozinka) {
//		for(Dispecer dispecer : dispeceri) {
//			if(dispecer.getKorIme().equalsIgnoreCase(korIme) &&
//					dispecer.getLozinka().equals(lozinka) && !dispecer.isObrisan()) {
//				return dispecer;
//			}
//		}
//		return null;
//	}

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


	public void obrisiVozaca(Vozac vozac) {
		this.vozaci.remove(vozac);
	}

	public void ucitajDispecera(String DISPECER_FAJL) {
		// TODO Auto-generated method stub
		
	}

	public void ucitajVozaca(String VOZAC_FAJL) {
		// TODO Auto-generated method stub
		
	}

	
	



	@Override
	public String toString() {
		return "Taxi_sluzba [id=" + id + ", pib=" + pib + ", naziv=" + naziv + ", adresa=" + adresa + ", cena_start="
				+ cena_start + ", cena_km=" + cena_km + ", dispeceri=" + dispeceri + ", musterije=" + musterije
				+ ", vozaci=" + vozaci + "]";
	}



		
}