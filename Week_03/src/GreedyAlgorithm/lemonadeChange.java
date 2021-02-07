package GreedyAlgorithm;

/**
 * 860. 柠檬水找零
 * 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。
 *
 * 顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
 *
 * 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
 *
 * 注意，一开始你手头没有任何零钱。
 *
 * 如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
 */
public class lemonadeChange {
    public static void main(String[] args) {
        System.out.println(lemonadeChange(new int[]{5,5,10}));
    }

    /**
     * 官方题解，循环数组，遇到有5的。就持有5面钞票+1，遇到10元的。需要找零，所以5元-1张，10元+1张
     * 剩下的就是20的，两种弃坑 持有 5 元和 10元的，直接分别找一张
     * 持有3张以上5元的，可以一次性找3张5元的
     * @param bills
     * @return
     */
    public static boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;

        for (int bill : bills){
            if (bill==5){
                five++;
            }else if (bill==10){
                if (five==0){
                    return false;
                }
                ten++;
                five--;
            }else {
                //说明能给20找零
                if (five>0 && ten>0){
                    five--;
                    ten--;
                }else if (five>=3){
                    five-=3;
                }else {
                    return false;
                }
            }
        }
        return true;
    }

    //错误 思想误区
    public static boolean lemonadeChangeOne(int[] bills) {
        boolean isSale = false;
        //如果长度大于0 或者 第一位元素大于5 说明没有零钱，返回false
        if (bills.length==0 || bills[0]>5){
            return isSale;
        }
        _lemonadeChange(0,bills,isSale,bills[0]);
        return isSale;
    }

    private static void _lemonadeChange(int level, int[] bills, boolean isSale, int money) {
        if (level==bills.length-1){
            return;
        }

        if (bills[level+1]-money>0){
            //说明能找开，返回true
            isSale = true;
        }

        _lemonadeChange(level+1,bills,isSale,bills[level]);
    }
}
