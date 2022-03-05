package com.suitandrank;

public class Card2 {

	public int suit, rank;

	public Card2() {
		this.suit = 0;
		this.rank = 0;
	}

	public Card2(int suit, int rank) {
		this.suit = suit;
		this.rank = rank;
	}

	public String printCard(Card2 c) {
		String[] suits = { "Clubs", "Diamonds", "Hearts", "Spades" };
		String[] ranks = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };

		return ranks[c.rank] + " of " + suits[c.suit];
	}

	public static int compareCards(Card2 c1, Card2 c2) {
		int s1 = ((c1.rank + 11) % 13) * 13 + c1.suit;
		int s2 = ((c2.rank + 11) % 13) * 13 + c2.suit;
		if (s1 > s2)
			return -1;
		if (s2 > s1)
			return 1;
		return 0;
	}

	public int compareTo(Card2 that) {
		if (this.suit > that.suit)
			return 1;
		if (this.suit < that.suit)
			return -1;

		int thisRank = (this.rank + 11) % 13;
		int thatRank = (that.rank + 11) % 13;

		if (thisRank > thatRank)
			return 1;
		if (thisRank < thatRank)
			return -1;
		return 0;
	}

	public boolean equals(Card2 that) {
		return (this.suit == that.suit && this.rank == that.rank);
	}

	public static int findCard(Card2[] deck, Card2 card) {
		for (int i = 0; i < deck.length; i++) {
			if (deck[i].equals(card))
				return i;
		}
		return -1;
	}

	public static int findBisect(Card2[] deck, Card2 card, int low, int high) {
		System.out.println(low + ", " + high);

		if (high < low)
			return -1;

		int mid = (high + low) / 2;
		int comp = deck[mid].compareTo(card);

		if (comp == 0) {
			return mid;
		} else if (comp > 0) {
			return findBisect(deck, card, low, mid - 1);
		} else {
			return findBisect(deck, card, mid + 1, high);
		}
	}

	public static void main(String[] args) {
		Card2[] deck = new Card2[52];

		int index = 0;
		for (int suit = 0; suit <= 3; suit++) {
			for (int rank = 1; rank <= 13; rank++) {
				deck[index] = new Card2(suit, rank);
				index++;
			}
		}
		Card2 card1 = new Card2(1, 11);
		System.out.println(findBisect(deck, card1, 0, 51));
	}
}
