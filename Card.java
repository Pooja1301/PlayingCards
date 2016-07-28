package classWork.playingCards.PlayingCards;

public class Card {

    public final static int SPADES = 0;
    public final static int HEARTS = 1;
    public final static int DIAMONDS = 2;
    public final static int CLUBS = 3;
    public final static int JOKER = 4;

    public final static int ACE = 1;
    public final static int JACK = 11;
    public final static int QUEEN = 12;
    public final static int KING = 13;

    private final int suit;
    private final int pip;

    public Card() {
        suit = JOKER;
        pip = 1;
    }

    public Card(int pip, int suit) {
        if (suit != SPADES && suit != HEARTS && suit != DIAMONDS &&
                suit != CLUBS && suit != JOKER)
            throw new IllegalArgumentException("Illegal playing card suit");
        if (suit != JOKER && (pip < 1 || pip > 13))
            throw new IllegalArgumentException("Illegal playing card value");
        this.pip = pip;
        this.suit = suit;
    }

    public int getSuit() {
        return suit;
    }

    public int getPip() {
        return pip;
    }

    public String getColor() {
        if(this.getSuit() == 1 || this.getSuit() == 2)
            return "Red";
        else if(this.getSuit() == 0 || this.getSuit() == 3)
            return "Black";
        return "No color";
    }

    public String getSuitAsString() {
        switch ( suit ) {
            case SPADES:   return "Spades";
            case HEARTS:   return "Hearts";
            case DIAMONDS: return "Diamonds";
            case CLUBS:    return "Clubs";
            default:       return "Joker";
        }
    }

    public String getValueAsString() {
        if (suit == JOKER)
            return "" + pip;
        else {
            switch ( pip ) {
                case 1:   return "Ace";
                case 2:   return "2";
                case 3:   return "3";
                case 4:   return "4";
                case 5:   return "5";
                case 6:   return "6";
                case 7:   return "7";
                case 8:   return "8";
                case 9:   return "9";
                case 10:  return "10";
                case 11:  return "Jack";
                case 12:  return "Queen";
                default:  return "King";
            }
        }
    }

    public String toString() {
        if (suit == JOKER) {
            if (pip == 1)
                return "Joker";
            else
                return "Joker #" + pip;
        }
        else
            return getValueAsString() + " of " + getSuitAsString();
    }

    public boolean isNext(Card card){
        if(this.getPip() > card.getPip())
            return true;
        return false;
    }
}
