package com.ras.persona.config.context

import javax.servlet.Filter
import javax.servlet.FilterChain
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.http.HttpServletRequest

class ContextFilter(private val contextStore: ContextStore): Filter {

    override fun doFilter(request: ServletRequest?, response: ServletResponse?, chain: FilterChain?) {
        val httpServletRequest: HttpServletRequest = request as HttpServletRequest

        // val tenantId: String = httpServletRequest.getHeader("TENANT_ID")

        try {
            this.contextStore.tenantId = "TenantIdContext"
            this.contextStore.userId = "AdminContext"
            this.contextStore.clientId = "ClientIdContext"

            chain!!.doFilter(request, response)
        } finally {
            this.contextStore.clear()
        }
    }
}