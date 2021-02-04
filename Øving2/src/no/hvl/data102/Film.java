package no.hvl.data102;

public class Film {
	public enum Sjanger {
		ACTION, DRAMA, HISTORY, SCIFI;

		public static Sjanger finnSjanger(String navn) {
			Sjanger sjang = null;
			for (Sjanger sj : Sjanger.values()) {
				if (sj.toString().equals(navn.toUpperCase())) {
					sjang = sj;
					break;
				}

			}
			return sjang;

		}

	}

	
	public int getFilmnummer() {
		return filmnummer;
	}

	public void setFilmnummer(int filmnummer) {
		this.filmnummer = filmnummer;
	}

	public String getProdusent() {
		return produsent;
	}

	public void setProdusent(String produsent) {
		this.produsent = produsent;
	}

	public String getTittel() {
		return tittel;
	}

	public void setTittel(String tittel) {
		this.tittel = tittel;
	}

	public int get�r() {
		return �r;
	}

	public void set�r(int �r) {
		this.�r = �r;
	}

	public String getSelskap() {
		return selskap;
	}

	public void setSelskap(String selskap) {
		this.selskap = selskap;
	}

	public Sjanger getSjanger() {
		return sjanger;
	}

	public void setSjanger(Sjanger sjanger) {
		this.sjanger = sjanger;
	}
	private int filmnummer;
	private String produsent;
	private String tittel;
	private int �r;
	private String selskap;
	private Sjanger sjanger;

	public Film() {
		this.filmnummer = 0;
		this.produsent = null;
		this.tittel = null;
		this.�r = 0;
		this.selskap = null;
		this.sjanger = null;
		
		
		

	}

	public Film(int filmnummer, String produsent, String tittel, int �r, Sjanger sjanger, String selskap) {
		this.filmnummer = filmnummer;
		this.produsent = produsent;
		this.tittel = tittel;
		this.�r = �r;
		this.sjanger = sjanger;
		this.selskap = selskap;
		
	}

	@Override
	public String toString() {
		return "Film [filmnummer=" + filmnummer + ", produsent=" + produsent + ", tittel=" + tittel + ", �r=" + �r
				+ ", selskap=" + selskap + ", sjanger=" + sjanger + "]";
	}
	
	
	
	
	
	
	

}
