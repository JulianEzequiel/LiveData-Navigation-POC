package com.utilities.money.livedatanavigation.navigation.observer

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProviders
import com.utilities.money.livedatanavigation.navigation.BasicAppRouter

inline fun Fragment.getBasicAppRouter(): BasicAppRouter {
    return ViewModelProviders
        .of(this.requireActivity(), null)
        .get(BasicAppRouter::class.java)
}

inline fun FragmentActivity.getBasicAppRouter(): BasicAppRouter {
    return ViewModelProviders
        .of(this, null)
        .get(BasicAppRouter::class.java)
}