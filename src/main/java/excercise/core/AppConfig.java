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
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

}
