package com.shuchenysh.monowallet.extension

import android.util.Patterns

fun String?.isEmailValid() = !this.isNullOrBlank() && Patterns.EMAIL_ADDRESS.matcher(this).matches()

fun String?.isEmailInvalid() = !this.isEmailValid()

