package pkgCore;

import java.util.ArrayList;
import java.util.Collections;
import pkgEnum.eRank;
import pkgEnum.eSuit;
import java.util.stream.Collectors;
import java.util.List;
import pkgException.DeckException;

public class Deck {

	private ArrayList<Card> cardsInDeck = new ArrayList<Card>();

	public Deck() {
		for (eSuit eSuit : eSuit.values()) {
			for (eRank eRank : eRank.values()) {
				cardsInDeck.add(new Card(eSuit, eRank));
			}
		}
		Collections.shuffle(cardsInDeck);
	}

	public Card Draw() throws DeckException {
		if(cardsInDeck.size() == 0) {
			throw new DeckException(null);
		}
		return cardsInDeck.remove(0);
	}
	
	//TODO: Write an overloaded Draw method to Draw a card of a given eSuit
	public Card Draw(eSuit eSuit) {
		for (Card c: this.cardsInDeck) {
			if(c.geteSuit() == eSuit) {
				cardsInDeck.remove(c);
				return c;
			}
		}
		return null;
	}
	//TODO: Write an overloaded Draw method to Draw a card of a given eRank
	public Card Draw(eRank eRank) {
		for (Card c: this.cardsInDeck) {
			if(c.geteRank() == eRank) {
				cardsInDeck.remove(c);
				return c;
			}
		}
		return null;
	}
	//TODO: Write a method that will return the number of a given eSuit left in the deck.
	public int CardCount(eSuit eSuit) {
		List<Card> result = cardsInDeck.stream()
				.filter(c -> c.geteSuit() == eSuit)
				.collect(Collectors.toList());
		final int number = result.size();
		return number;
	}
//	TODO: Write a method that will return the number of a given eRank left in the deck.
	public int CardCount(eRank eRank) {
		List<Card> result = cardsInDeck.stream()
				.filter(c -> c.geteRank() == eRank)
				.collect(Collectors.toList());
		final int count = result.size();
		return count;
	}
	
	//TODO: Write a method that will return 0 or 1 if a given card is left in the deck.
	public int FindCard(Card c) {
		for (Card a: cardsInDeck) {
			if(a == c) {
				return 1;
		}
		}
		return 0;	
	}
}
