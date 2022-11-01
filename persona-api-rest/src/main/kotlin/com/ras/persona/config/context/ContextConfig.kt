package com.ras.persona.config.context

import org.springframework.aop.framework.ProxyFactoryBean
import org.springframework.aop.target.ThreadLocalTargetSource
import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.context.annotation.Scope
import javax.servlet.Filter


@Configuration
class ContextConfig {

    @Bean(name = ["contextStore"])
    @Scope(scopeName = "prototype")
    fun contextStore(): ContextStore {
        return ContextStore()
    }

    @Bean
    fun contextFilter(): Filter {
        return ContextFilter(contextStore())
    }

    @Bean
    fun contextFilterRegistration(): FilterRegistrationBean<Filter> {
        val filterRegistration = FilterRegistrationBean<Filter>()
        filterRegistration.filter = contextFilter()
        filterRegistration.urlPatterns = listOf("/*")
        filterRegistration.setName("Context Store Filter")
        filterRegistration.order = 1
        return filterRegistration
    }

    @Bean(destroyMethod = "destroy")
    fun threadLocalTenantStore(): ThreadLocalTargetSource {
        val localTargetSource = ThreadLocalTargetSource()
        localTargetSource.targetBeanName = "contextStore"
        return localTargetSource
    }

    @Primary
    @Bean(name = ["proxiedThreadLocalTargetSource"])
    fun proxiedThreadLocalTargetSource(threadLocalTargetSource: ThreadLocalTargetSource): ProxyFactoryBean {
        val result = ProxyFactoryBean()
        result.targetSource = threadLocalTargetSource
        return result
    }


}