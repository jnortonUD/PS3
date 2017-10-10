package pkgCore;
import pkgEnum.eRank;
import pkgEnum.eSuit;
import pkgException.DeckException;

import static org.junit.Assert.*;
import org.junit.Test;

public class DeckTest {
	

	@Test(expected = DeckException.class)
	public void TestEmptyDeck() throws DeckException {
//		TODO: Build a deck, draw until you get a DeckException
		Deck z = new Deck();
		
		for(int i=52;i>=0;i--) {
			z.Draw();		
		}	
	}

	@Test
	public void TestDrawSuit() {
		//TODO: Build a deck, test the Draw(eSuit) method
		Deck a = new Deck();
		
		assertTrue(a.Draw(eSuit.HEARTS).geteSuit().toString().equals("HEARTS"));
		assertTrue(a.Draw(eSuit.CLUBS).geteSuit().toString().equals("CLUBS"));
		assertFalse(a.Draw(eSuit.HEARTS).geteSuit().toString().equals("DIAMONDS"));
	}
	
	@Test
	public void TestDrawRank() {
		//TODO: Build a deck, test the Draw(eRank) method
		Deck b = new Deck();
		
		assertEquals(b.Draw(eRank.SEVEN).geteRank().getiRankNbr(),7);
		assertEquals(b.Draw(eRank.KING).geteRank().getiRankNbr(),13);
		assertNotEquals(b.Draw(eRank.FOUR).geteRank().getiRankNbr(),8);
	}
	
	public void TestDeckRankCount() {
		//TODO: Build a deck, test the DeckRankCount method
		Deck c = new Deck();
		
		assertEquals(c.CardCount(eRank.FIVE),4);
		assertNotEquals(c.CardCount(eRank.ACE),3);
	}
	
	public void TestDeckSuitCount() {
		//TODO: Build a deck, test the DeckSuitCount method
		Deck d = new Deck();
		
		assertEquals(d.CardCount(eSuit.CLUBS),13);
		assertNotEquals(d.CardCount(eSuit.SPADES),6);
	}

}
