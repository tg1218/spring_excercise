package excercise.core.beanfind;

import excercise.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBeans() {
        for (String beanDefinitionName : ac.getBeanDefinitionNames()) {
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("bean = " + beanDefinitionName + ", object = " + bean);
        }
    }

    @Test
    @DisplayName("Application Bean 출력하기")
    void findApplicationBeans() {
        for (String beanDefinitionName : ac.getBeanDefinitionNames()) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("bean = " + beanDefinitionName + ", object = " + bean);
            }
        }
    }
}
