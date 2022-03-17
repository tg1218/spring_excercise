package excercise.core;

import excercise.core.discount.DiscountPolicy;
import excercise.core.discount.FixDiscountPolicy;
import excercise.core.discount.RateDiscountPolicy;
import excercise.core.member.MemberRepository;
import excercise.core.member.MemberService;
import excercise.core.member.MemberServiceImpl;
import excercise.core.member.MemoryMemberRepository;
import excercise.core.order.OrderService;
import excercise.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

}
