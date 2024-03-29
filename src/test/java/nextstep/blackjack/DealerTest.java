package nextstep.blackjack;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DealerTest {
    Dealer dealer = new Dealer();

    @Test
    @DisplayName("딜러는 카드의 총 합이 16이상이면 더 이상 카드를 받을 수 없다.")
    void receiveCardTest() {
        //Dealer dealer = new Dealer();
        dealer.receiveCard(new Card(Card.Pattern.CLOVER, Card.Denomination.JACK));
        dealer.receiveCard(new Card(Card.Pattern.CLOVER, Card.Denomination.SEVEN));
        dealer.receiveCard(new Card(Card.Pattern.CLOVER, Card.Denomination.ACE));

        Assertions.assertThat(dealer.openCards().getCardSize()).isEqualTo(2);
    }

    @Test
    @DisplayName("카드의 총합이 16이상일 경우 카드를 받을 수 없습니다.")
    void isReceiveCardTest() {
        dealer.receiveCard(new Card(Card.Pattern.CLOVER, Card.Denomination.JACK));
        dealer.receiveCard(new Card(Card.Pattern.CLOVER, Card.Denomination.FIVE));
        Assertions.assertThat(dealer.isReceiveCard()).isTrue();

        dealer.receiveCard(new Card(Card.Pattern.CLOVER, Card.Denomination.FIVE));
        Assertions.assertThat(dealer.isReceiveCard()).isFalse();
    }


}
