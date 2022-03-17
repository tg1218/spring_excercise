package excercise.core.discount;

import excercise.core.member.Grade;
import excercise.core.member.Member;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



class RateDiscountPolicyTest {

    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP의 경우, 10%할인 테스트")
    void vipDiscountTest() {
        //given
        Member member = new Member(1L, "memberVIP", Grade.VIP);
        //when
        int price = rateDiscountPolicy.discount(member, 10000);

        //then
        assertThat(price).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP 아닐경우, 10%할인 안되는 테스트")
    void notVipDiscountTest() {
        //given
        Member member = new Member(2L, "memberVIP", Grade.BASIC);
        //when
        int price = rateDiscountPolicy.discount(member, 10000);

        //then
        assertThat(price).isEqualTo(0);
    }
}