package jp.ac.uryukyu.ie.e175756;

public class Enemy extends LivingThings {
    /*String name;
    int hitPoint;
    int attack;
    boolean dead;*/

    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     *
     * @param name      モンスター名
     * @param maximumHP モンスターのHP
     * @param attack    モンスターの攻撃力
     */
    public Enemy(String name, int maximumHP, int attack) {
        super(name, maximumHP, attack);
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, maximumHP, attack);
    }
    public void wounded(int damage){
        setHitPoint(getHitPoint() -damage);
        if( getHitPoint() <= 0 ) {
            setDead(true);
            System.out.printf("モンスター%sは倒れた。\n", getName());
        }
    }
    public void attack(LivingThings opponent){
        if( isDead() == false ) {
            int damage = (int) (Math.random() * getAttack());
            if(damage == 0){
                System.out.printf("%sの攻撃！,,,だが、%sは攻撃を回避した！\n", getName(), opponent.getName());
            }else if(getRandom() < 30){
                damage *= 2;
                System.out.printf("%sの攻撃！痛恨の一撃！！%sに%dのダメージを与えた！！\n", getName(), opponent.getName(), damage);
            }else{
                System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", getName(), opponent.getName(), damage);
            }
            opponent.wounded(damage);
        }
    }
}
