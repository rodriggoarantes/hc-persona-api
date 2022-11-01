package com.ras.persona.config.context

open class ContextStore(
    var tenantId: String = "",
    var clientId: String = "",
    var userId: String = ""
) {
    fun clear() {
        this.tenantId = ""
        this.clientId = ""
        this.userId = ""
    }
}