package com.utilities.money.livedatanavigation.navigation.observer

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders

@JvmOverloads
inline fun <reified T : ViewModel>
        Fragment.getEventAccesorFromParent(factory: ViewModelProvider.Factory? = null): T {
    this.parentFragment?.let {
        return ViewModelProviders
            .of(it, factory)
            .get(T::class.java)
    }
    this.activity?.let {
        return ViewModelProviders
            .of(it, factory)
            .get(T::class.java)
    }
    throw IllegalStateException()
}

@JvmOverloads
inline fun <reified T : ViewModel>
        Fragment.getEventAccesorFrom(
    fragment: Fragment,
    factory: ViewModelProvider.Factory? = null
): T {
    return ViewModelProviders
        .of(fragment, factory)
        .get(T::class.java)
}

@JvmOverloads
inline fun <reified T : ViewModel>
        Fragment.getEventAccesorFrom(
    activity: FragmentActivity,
    factory: ViewModelProvider.Factory? = null
): T {
    return ViewModelProviders
        .of(activity, factory)
        .get(T::class.java)
}

@JvmOverloads
inline fun <reified T : ViewModel>
        FragmentActivity.getEventAccesor(factory: ViewModelProvider.Factory? = null): T {
    return ViewModelProviders
        .of(this, factory)
        .get(T::class.java)
}
