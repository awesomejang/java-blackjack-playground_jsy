package nextstep.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * [x] 게임에 참여할 사람 리스트 받는 안내
 */
public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public void pringGetPlayers(){
        System.out.println(Constant.ANNOUNCE_GET_PLAYER_LIST);
    }

    /**
     * 이름, 배팅금액을 받아 게이머를 초기화 한다.
     * @return
     */
    public List<Gamer> initPlayers() {
        List<Gamer> players = new ArrayList<>();

        System.out.println(Constant.ANNOUNCE_GET_PLAYER_LIST);
        String[] playersNames = getPlayersNames();

        for (String playerName : playersNames) {
            int playerBet = getPlayersBet(playerName);
            players.add(new Gamer(playerName, playerBet));
        }
        return players;
    }

    /**
     * 문자열을 입력받아 ','기준으로 분할하여 문자열 배열을 리턴한다.
     * @return
     */
    public String[] getPlayersNames(){
        String stringInput = getStringInput();
        return splitPlayerNames(stringInput);
    }

    /**
     * 플레이어 이름 받아서 배팅정보 요구
     * 입력값(배팅액) 리턴
     * @param playerName
     * @return
     */
    public int getPlayersBet(String playerName) {
        System.out.println(String.format(Constant.ANNOUNCE_GET_PLATER_BET, playerName));
        return getNumberInput();
    }

    public String getStringInput() {
        return scanner.next();
    }

    public int getNumberInput() {
        return scanner.nextInt();
    }

    private String[] splitPlayerNames(String playerNames) {
        return playerNames.split(Constant.SPLIT_MARK_PLAYERS_NAME);
    }

    /**
     * 최초 카드 draw 메세지
     */
    public void printFirstDraw(List<Gamer> gamers) {
        StringJoiner playerNames = new StringJoiner(Constant.SPLIT_MARK_PLAYERS_NAME);
        gamers.forEach(gamer -> playerNames.add(gamer.getName()));

        System.out.println(String.format(Constant.ANNOUNCE_INIT_GAME, playerNames.toString()));
    }

    /**
     * 추가적인 카드 받는 여부를 입력받고 결과를 리턴한다.
     * @param gamer
     * @return String(y,n)
     */
    public boolean isReceiveExtraCard(Gamer gamer) {
        System.out.println(String.format(Constant.ANNOUNCE_RECEIVE_EXTRA_CARD, gamer.getName()));
        String choice = this.getStringInput();

        System.out.println(choice);
        return isReceiveExtraCard(choice);
    }

    /**
     * 게이머의 현재 카드상태를 리턴한다.
     * @param gamer
     */
    public void printGamerCardState(Gamer gamer) {
        System.out.println(String.format(Constant.ANNOUNCE_INIT_CARD_STATS, gamer.getName(), gamer.showCards()));
    }

    private boolean isReceiveExtraCard(String choice) {
        boolean result = false;
        if(Constant.CONTINUE_RECEIVE_CARD.equals(choice)) {
            result = true;
        }
        return result;
    }
}
