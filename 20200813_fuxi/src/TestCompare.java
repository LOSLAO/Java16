import java.util.Comparator;

class Card implements Comparable<Card> {
    public String rank;
    public String suit;

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public boolean equals(Object obj) {
        //1.看看this和obj身份是否相同
        if (this == obj) {
            return true;
        }
        //2.如果obj为null。一定不相等
        if (obj == null) {
            return false;
        }
        //3.obi类型能否强转成Card
        if (!(obj instanceof Card)) {
            return false;
        }
        //4.类型转换，把参数转换成Card类型
        Card other = (Card) obj;
        //5.真正进行按照指定规则比较
        return this.rank.equals(other.rank) && this.suit.equals(other.suit);
    }

    @Override
    public int compareTo(Card o) {
        // this, o
        // this < o, 返回 < 0
        // this > o, 返回 > 0
        // this 和 o 相等, 返回 0
        // 定义比较规则: 扑克牌的点数来进行比较
        int rank1 = this.convertRank();
        int rank2 = o.convertRank();
        // 升序排序
        // return rank1 - rank2;
        // 降序排序
        return rank2 - rank1;
    }

    public int convertRank() {
        // 把 String 类型的 rank 转成 int 值.
        // 2 - 10 => 2 - 10
        // J => 11
        // Q => 12
        // K => 13
        // A => 14
        if ("A".equals(rank)) {
            return 14;
        }
        if ("K".equals(rank)) {
            return 13;
        }
        if ("Q".equals(rank)) {
            return 12;
        }
        if ("J".equals(rank)) {
            return 11;
        }
        return Integer.parseInt(rank);
    }
}

class CardComparator implements Comparator<Card> {
    @Override
    public int compare(Card o1, Card o2) {
        if (o1 == o2) {
            return 0;
        }
        if (o1 == null) {
            return -1;
        }
        if (o2 == null) {
            return 1;
        }
        int rank1 = o1.convertRank();
        int rank2 = o2.convertRank();
        return rank1 - rank2;

    }
}
public class TestCompare {
    public static void main(String[] args) {
        Card p = new Card("3", "♠");
        Card q = new Card("A", "♠");
        Card o = p;

        Comparator<Card> comparator = new CardComparator();

        System.out.println(comparator.compare(p, q));
        System.out.println(comparator.compare(p, o));

//        System.out.println(p.compareTo(q));
//        System.out.println(p.compareTo(o));
//        System.out.println(p == o);
//        System.out.println(p == q);
//
//        System.out.println(p.equals(o));
//        System.out.println(p.equals(q));
    }
}
