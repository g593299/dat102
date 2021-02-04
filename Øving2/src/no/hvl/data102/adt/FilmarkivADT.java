package no.hvl.data102.adt;
import no.hvl.data102.*;
import no.hvl.data102.Film.Sjanger;


public interface FilmarkivADT {
	
	
	
	/**
	 * Returnere en tabell av filmer
	 * @return
	 */
	Film[] hentFilmtab();
	
	/**
	 * Legge til ny film
	 * @param nyFilm
	 */
	
	void leggTilFilm(Film nyFilm);
	
	/**
	 * Sletter film om den eksisterer
	 * @param filmnr
	 * @return
	 */

	boolean slettFilm(int filmnr);
	
	/**
	 * Søker etter film med gitt delstreng
	 * @param delstreng
	 * @return
	 */
	
	Film[] søkTittel(String delstreng);
	
	/**
	 * Søker etter produsent gitt delstreng
	 * @param delstreng
	 * @return
	 */
	
	Film[] søkProdusent(String delstreng);
	
	/**
	 * Returnerer antall filmer med gitt sjenger.
	 * @param sjanger
	 * @return
	 */
	
	int antall(Sjanger sjanger);
	
	/**
	 * Returnerer antall filmer.
	 * @return
	 */
	
	int antall();

	
	
	
	
	
	

}
