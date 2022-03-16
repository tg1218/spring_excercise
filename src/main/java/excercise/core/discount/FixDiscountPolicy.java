package excercise.core.discount;

import excercise.core.member.Grade;
import excercise.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {
    private static final int DISCOUNT_FIX = 1000;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP) {
            return DISCOUNT_FIX;
        }
        return 0;
    }
}
