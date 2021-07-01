package blackjack;

import java.util.*;

public class Blackjack implements BlackjackEngine {
	private int account;
	private int bet;
	private Random randomGenerator;
	private int numberOfDecks;
	private ArrayList<Card> deck;
	private ArrayList<Card> player;
	private ArrayList<Card> dealer;
	private int gamestatus;

	/**
	 * Constructor you must provide. Initializes the player's account to 200 and the
	 * initial bet to 5. Feel free to initialize any other fields. Keep in mind that
	 * the constructor does not define the deck(s) of cards.
	 * 
	 * @param randomGenerator
	 * @param numberOfDecks
	 */
	public Blackjack(Random randomGenerator, int numberOfDecks) {
		account = 200;
		bet = 5;
		this.randomGenerator = randomGenerator;
		this.numberOfDecks = numberOfDecks;
		deck = new ArrayList<Card>();
	}

	public int getNumberOfDecks() {
		return numberOfDecks;
	}

	public void createAndShuffleGameDeck() {
		deck = new ArrayList<Card>();
		for (int i = 0; i < numberOfDecks; i++) {
			deck.addAll(createdeck());
		}
		Collections.shuffle(deck, randomGenerator);
	}

	public Card[] getGameDeck() {
		Card[] cardDeck = new Card[deck.size()];
		return this.deck.toArray(cardDeck);
	}

	public void deal() {
		createAndShuffleGameDeck();
		player = new ArrayList<Card>();
		dealer = new ArrayList<Card>();
		player.add(deck.get(0));
		deck.remove(0);
		Card card = deck.get(0);
		card.setFaceDown();
		dealer.add(card);
		deck.remove(0);
		player.add(deck.get(0));
		deck.remove(0);
		dealer.add(deck.get(0));
		deck.remove(0);
		this.account = this.account - this.bet;
		this.gamestatus = BlackjackEngine.GAME_IN_PROGRESS;
	}

	public Card[] getDealerCards() {
		Card[] array1 = new Card[dealer.size()];
		return dealer.toArray(array1);

	}

	public int[] getDealerCardsTotal() {
		int sum = 0;
		int sum2;
		int num;
		for (int i = 0; i < dealer.size(); i++) {
			sum = sum + dealer.get(i).getValue().getIntValue();
		}
		sum2 = sum + 10;
		num = numOfAce(dealer);
		if (num == 0) {
			if (sum <= 21) {
				int[] score = { sum };
				return score;
			} else {
				return null;
			}
		} else {
			if (sum > 21) {
				return null;
			} else if (sum <= 21 && sum2 > 21) {
				int[] score = { sum };
				return score;
			} else if (sum <= 21 && sum2 <= 21) {
				int[] score = { sum, sum2 };
				return score;
			}
		}
		return null;

	}

	public int getDealerCardsEvaluation() {
		return evaluate(getDealerCardsTotal(), dealer);
	}

	public Card[] getPlayerCards() {
		Card[] array1 = new Card[player.size()];
		return player.toArray(array1);
	}

	public int[] getPlayerCardsTotal() {
		int sum = 0;
		int sum2;
		int num;
		for (int i = 0; i < player.size(); i++) {
			sum = sum + player.get(i).getValue().getIntValue();
		}
		sum2 = sum + 10;
		num = numOfAce(player);
		if (num == 0) {
			if (sum <= 21) {
				int[] score = { sum };
				return score;
			} else {
				return null;
			}
		} else {
			if (sum > 21) {
				return null;
			} else if (sum <= 21 && sum2 > 21) {
				int[] score = { sum };
				return score;
			} else if (sum <= 21 && sum2 <= 21) {
				int[] score = { sum, sum2 };
				return score;
			}
		}
		return null;

	}

	public int getPlayerCardsEvaluation() {
		return evaluate(getPlayerCardsTotal(), player);
	}

	public void playerHit() {
		int result;
		player.add(deck.get(0));
		deck.remove(0);
		result = getPlayerCardsEvaluation();
		if (result == BlackjackEngine.BUST) {
			this.gamestatus = BlackjackEngine.DEALER_WON;
		} else {
			this.gamestatus = BlackjackEngine.GAME_IN_PROGRESS;
		}

	}

	public void playerStand() {
		// Card c = dealer.get(0);
		// c.setFaceUp();
		// dealer.remove(0);
		// dealer.add(0, c);
		dealer.get(0).setFaceUp();
		int[] dealerscore = getDealerCardsTotal();
		int[] playerscore = getPlayerCardsTotal();
		while (dealerscore != null && dealerscore[dealerscore.length - 1] < 16) {
			dealer.add(deck.get(0));
			deck.remove(0);
			dealerscore = getDealerCardsTotal();
		}
		dealerscore = getDealerCardsTotal();
		if (dealerscore == null) {
			this.gamestatus = BlackjackEngine.PLAYER_WON;
			account += 2 * bet;
		} else {
			if (dealerscore[dealerscore.length - 1] < playerscore[playerscore.length - 1]) {
				this.gamestatus = BlackjackEngine.PLAYER_WON;
				account += 2 * bet;
			} else if (dealerscore[dealerscore.length - 1] == playerscore[playerscore.length - 1]) {
				this.gamestatus = BlackjackEngine.DRAW;
				account += bet;
			} else if (dealerscore[dealerscore.length - 1] > playerscore[playerscore.length - 1]) {
				this.gamestatus = BlackjackEngine.DEALER_WON;
			}
		}

	}

	public int getGameStatus() {
		return this.gamestatus;
	}

	public void setBetAmount(int amount) {
		this.bet = amount;
	}

	public int getBetAmount() {
		return this.bet;
	}

	public void setAccountAmount(int amount) {
		this.account = amount;
	}

	public int getAccountAmount() {
		return this.account;
	}

	private ArrayList<Card> createdeck() {
		ArrayList<Card> deckOfCards = new ArrayList<Card>();
		for (CardSuit cardsuit : CardSuit.values()) {
			for (CardValue value : CardValue.values()) {
				deckOfCards.add(new Card(value, cardsuit));
			}
		}
		return deckOfCards;
	}

	private int numOfAce(ArrayList<Card> card1) {
		int count = 0;
		for (int i = 0; i < card1.size(); i++) {
			if (card1.get(i).getValue() == CardValue.Ace) {
				count += 1;
			}
		}
		return count;
	}

	private int evaluate(int[] score, ArrayList<Card> hand) {
		if (score == null) {
			return BlackjackEngine.BUST;
		} else if (score.length == 2) {
			if (score[1] == 21) {
				if (hand.size() == 2) {
					return BlackjackEngine.BLACKJACK;
				} else {
					return BlackjackEngine.HAS_21;
				}
			}
		} else {
			if (score[0] == 21) {
				return BlackjackEngine.HAS_21;
			}
		}
		return BlackjackEngine.LESS_THAN_21;
	}
	/* Feel Free to add any private methods you might need */
}
