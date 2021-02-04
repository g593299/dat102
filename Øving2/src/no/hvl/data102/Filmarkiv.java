package no.hvl.data102;

import java.util.Arrays;

import no.hvl.data102.Film.Sjanger;
import no.hvl.data102.adt.FilmarkivADT;

public class Filmarkiv implements FilmarkivADT {

	private Film[] filmer;
	private int antall;

	public Filmarkiv(int antall) {
		filmer = new Film[antall];
		this.antall = 0;

	}

	@Override
	public Film[] hentFilmtab() {

		return filmer;
	}

	@Override
	public void leggTilFilm(Film nyFilm) {

		if (filmer.length == antall) {
			utvidKapasitet();
		}

		filmer[antall] = nyFilm;
		antall++;

	}

	private void utvidKapasitet() {// eks. utvide 10%
		Film[] hjelpetabell = new Film[(int) Math.ceil(1.1 * filmer.length)];
		for (int i = 0; i < filmer.length; i++) {
			hjelpetabell[i] = filmer[i];
		}
		filmer = hjelpetabell;
	}

	@Override
	public boolean slettFilm(int filmnr) {
		boolean slettet = false;
		for (int i = 0; i < antall; i++) {
			if (filmer[i].getFilmnummer() == filmnr) {
				filmer[i] = null;
				antall--;
				slettet = true;
			}
		}
		return slettet;
	}

	@Override
	public Film[] søkTittel(String delstreng) {

		Film[] resultat = new Film[antall + 1];

		for (int i = 0; i < antall; i++) {
			if (filmer[i].getTittel().contains(delstreng)) {
				resultat[i] = filmer[i];
			}
		}
		return resultat;

	}

	@Override
	public Film[] søkProdusent(String delstreng) {
		Film[] resultat = new Film[antall + 1];

		for (int i = 0; i < antall; i++) {
			if (filmer[i].getProdusent().contains(delstreng)) {
				resultat[i] = filmer[i];
			}
		}
		return resultat;
	}

	@Override
	public int antall(Sjanger sjanger) {
		int antall = 0;

		for (int i = 0; i < filmer.length; i++) {
			if (filmer[i].getSjanger() == sjanger) {
				antall++;
			}
		}

		return antall;

	}

	@Override
	public int antall() {
		return antall;
	}

	@Override
	public String toString() {
		return "Filmarkiv [Filmer=" + Arrays.toString(filmer) + ", antall filmer=" + antall + "]";
	}
	
	
	public int antallSjanger(Sjanger sjanger) {
		int antallSjanger = 0;
		for (int i = 0; i < antall; i++) {
			if (filmer[i].getSjanger() == sjanger) {
				antallSjanger++;
			}
		}
		return antallSjanger;
	}

}
