package com.example.fitnessdashboard.common

import java.text.DecimalFormat


val Int.formatWithCommas: String
    get() = DecimalFormat("#,###").format(this)
