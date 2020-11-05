package com.unero.login.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Account (
    var email: String = "",
    var password: String = ""
): Parcelable
