package pkgException;


import pkgCore.Deck;

public class DeckException extends Exception {

	private Deck d = new Deck();

	public DeckException(Deck d) {
		super();
		this.d = d;
	}

	protected Deck getD() {
		return d;
	}
	
	
}
