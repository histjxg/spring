package org.springframework.orm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.orm.aspect.PerformanceTraceAspect;
import org.springframework.orm.service.Fly;
import org.springframework.orm.service.impl.FlyImpl;

// 配置类
@Configuration
// 启用AOP
@EnableAspectJAutoProxy
public class AspectConfigure {

    /**
     * 实现接口的目标对象
     * @return
     */
    @Bean
    public Fly fly() {
        return new FlyImpl();
    }

    /**
     * 切面
     * @return
     */
    @Bean
    public PerformanceTraceAspect performanceTraceAspect() {
        return new PerformanceTraceAspect();
    }

}

