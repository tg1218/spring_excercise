package excercise.core.discount;

import excercise.core.annotation.MainDiscountPolicy;
import excercise.core.member.Grade;
import excercise.core.member.Member;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy{
    private static final int DISCOUNT_PERCENT = 10;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP) {
            return (price * DISCOUNT_PERCENT) / 100;
        }
        return 0;
    }
}
