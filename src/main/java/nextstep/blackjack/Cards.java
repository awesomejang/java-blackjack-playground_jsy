package nextstep.blackjack;

import java.util.List;

public class Cards {
    private List<Card> cards;

    public Cards(List<Card> cards) {
        this.cards = cards;
    }

    public List<Card> getCards() {
        return cards;
    }

    public Card getCard(int index) {
        return this.cards.get(index);
    }

    public int getCardSize() {
        return this.cards.size();
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public void removeCard(Card card) {
        cards.remove(card);
    }
}