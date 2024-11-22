package com.helpline.config

import com.helpline.network.forum.User

data class Session (
    var token: String = "",
    var loggedUser: User? = null
)
