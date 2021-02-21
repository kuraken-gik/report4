package jp.ac.uryukyu.ie.e205722;

public class LivingThing {
    private String name;
    private int hitPoint;
    private int attack;
    private boolean dead;

    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     * 
     * @param name     名前
     * @param hitPoint HP
     * @param attack   攻撃力
     */
    public LivingThing(String name, int hitPoint, int attack) {
        this.name = name;
        this.hitPoint = hitPoint;
        this.attack = attack;
        dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, hitPoint, attack);
    }

    /**
     * フィールドnameのgetterメソッド。
     */
    public String getName() {
        return this.name;
    }

    /**
     * フィールドhitPointのgetterメソッド。
     */
    public int getHitPoint() {
        return this.hitPoint;
    }

    /**
     * フィールドdeadのgetterメソッド。
     */
    public boolean getDead() {
        return this.dead;
    }

    /**
     * opponentへ攻撃するメソッド。 attackに応じて乱数でダメージを算出し、opponent.wounded()によりダメージ処理を実行。
     * 
     * @param opponent 攻撃対象
     */
    public void attack(LivingThing opponent) {
        if (hitPoint > 0) {
            int damage = (int) (Math.random() * attack);
            System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, opponent.getName(), damage);
            opponent.wounded(damage);
        } else {
        }
        ;
    }

    /**
     * 自身へ攻撃されたときのダメージ処理をするメソッド。 指定されたダメージを hitPoint から引き、死亡判定を行う。
     * 
     * @param damage 受けたダメージ
     */
    public void wounded(int damage) {
        hitPoint -= damage;
        if (hitPoint < 0) {
            dead = true;
        }
    }

}
