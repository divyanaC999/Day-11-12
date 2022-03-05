package com.deckofcard;

public class CardMain {

	public static void main(String[] args) {
		DeckOfCard deckOfCard = new DeckOfCard();
		deckOfCard.shuffle();
		System.out.println("---------------After Shuffle-----------");
		deckOfCard.print();

		deckOfCard.distribute();

		deckOfCard.printDistributedCards();
	}
}
