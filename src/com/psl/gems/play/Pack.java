package com.psl.gems.play;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pack {
    private List<Card> cards;

    public Pack() {
        cards = new ArrayList<Card>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(rank, suit));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card getTopCard() {
        return cards.remove(0);
    }

    public Card getRandomCard() {
        int index = (int) (Math.random() * cards.size());
        return cards.remove(index);
    }

    public int getSize() {
        return cards.size();
    }

    public void reset(boolean ascending) {
        if (ascending) {
            Collections.sort(cards, new CardComparator());
        } else {
            Collections.sort(cards, Collections.reverseOrder(new CardComparator()));
        }
    }

    public List<Card> getCards() {
        return cards;
    }

    public String toJson() {
        StringBuilder json = new StringBuilder("[\n");
        for (Card card : cards) {
            json.append("{ \"SUIT\": \"" + card.getSuit() + "\", \"RANK\": \"" + card.getRank() + "\" },\n");
        }
        json.deleteCharAt(json.length() - 2);
        json.append("]");
        return json.toString();
    }

    private class CardComparator implements java.util.Comparator<Card> {
        @Override
        public int compare(Card card1, Card card2) {
            if (card1.getSuit() == card2.getSuit()) {
                return card1.getRank().compareTo(card2.getRank());
            } else {
                return card1.getSuit().compareTo(card2.getSuit());
            }
        }
    }
}
