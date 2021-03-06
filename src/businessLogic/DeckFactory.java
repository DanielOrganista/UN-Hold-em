/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogic;

import static businessLogic.DealingAssistant.shuffleDeck;
import data.Card;
import data.DealingDeck;
import data.Hand;

/**
 *
 * @author One Poker
 */
public class DeckFactory {

    public static DealingDeck createDealingDeck(String deckType) {
        if (deckType.equalsIgnoreCase("DEALINGDECK")) {
            DealingDeck dealingDeck = new DealingDeck("array");
            for (int i = 0; i < 52; i++) {
                dealingDeck.addCard(new Card(i));
            }
            shuffleDeck(dealingDeck);
            return dealingDeck;
        } else {
            return new DealingDeck(deckType);
        }
    }

    public static Hand createHand(String handType) {
        if (handType.equalsIgnoreCase("ROYAL")) {
            int suit = GameEngine.RND.nextInt(4);
            Hand royal = new Hand("Royal Flush");
            royal.addCard(new Card(10, suit));
            royal.addCard(new Card(11, suit));
            royal.addCard(new Card(12, suit));
            royal.addCard(new Card(13, suit));
            royal.addCard(new Card(14, suit));
            return royal;
        } else if (handType.equals("nullLinked")) {
            Hand linked = new Hand("linked");
            for (int i = 0; i < 5; i++) {
                linked.addCard(new Card(5, 3));
            }
            return linked;
        } else {
            return new Hand(handType);
        }
    }

    public static Hand cloneHand(Hand hand) {
        //System.out.println(hand.getCards().getClass().toString());
        Hand clone = new Hand("linked");
        clone.setRank(hand.getRank());
        clone.setRankName(hand.getRankName());
        clone.addAll(hand);
        return clone;
    }

    public static Hand createKicker(Hand merge, Hand bestHand) {
        merge.getCards().removeAll(bestHand.getCards());
        return merge;
    }

}
