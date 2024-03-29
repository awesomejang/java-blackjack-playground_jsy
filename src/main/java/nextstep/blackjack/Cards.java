package nextstep.blackjack;

import java.util.ArrayList;
import java.util.Stack;

public class Cards {
    private Stack<Card> cards = new Stack<>();

    public Cards() {
    }
    public Cards(Stack<Card> cards) {
        this.cards = cards;
    }

    public Stack<Card> getCards() {
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

    /**
     * 보유하고 있는 카드의 점수합계를 리턴한다.
     * @return int
     */
    public int getpointSum() {
        int sum = 0;
        for (Card card : cards) {
            sum += card.getPoint();
        }
        return sum;
    }
}
