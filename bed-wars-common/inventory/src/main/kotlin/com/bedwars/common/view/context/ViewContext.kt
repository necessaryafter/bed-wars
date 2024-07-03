package com.bedwars.common.view.context

import com.bedwars.common.view.View

data class ViewContext(
    private val playerName: String,
    private val properties: Map<String, Any> = mutableMapOf(),

    var activeView: View?,
    var previousView: View?
)