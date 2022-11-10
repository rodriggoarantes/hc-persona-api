package com.ras.persona.config.context

import javax.servlet.Filter
import javax.servlet.FilterChain
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.http.HttpServletRequest

class ContextFilter(private val contextStore: ContextStore): Filter {

    override fun doFilter(request: ServletRequest?, response: ServletResponse?, chain: FilterChain?) {
        val httpServletRequest: HttpServletRequest = request as HttpServletRequest

        val uid: String = httpServletRequest.getHeader("uid") ?:  "UID_NOT_FOUND"
        val clientId: String = httpServletRequest.getHeader("clientId") ?: "CLIENTID_NOT_FOUND"

        try {
            this.contextStore.userId = uid
            this.contextStore.clientId = clientId

            chain!!.doFilter(request, response)
        } finally {
            this.contextStore.clear()
        }
    }
}
