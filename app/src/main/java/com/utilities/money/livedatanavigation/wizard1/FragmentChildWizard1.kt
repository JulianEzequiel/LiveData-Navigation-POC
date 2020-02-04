package com.utilities.money.livedatanavigation.wizard1

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.utilities.money.livedatanavigation.R
import com.utilities.money.livedatanavigation.navigation.BasicAppRouter
import com.utilities.money.livedatanavigation.navigation.event.SingleLiveEvent
import com.utilities.money.livedatanavigation.navigation.observer.getBasicAppRouter
import com.utilities.money.livedatanavigation.navigation.observer.getEventAccesorFrom
import com.utilities.money.livedatanavigation.navigation.observer.getEventAccesorFromParent

class FragmentChildWizard1Events : ViewModel() {

    val sendEvent = SingleLiveEvent<Any>()

}

class FragmentChildWizard1 : Fragment() {

    lateinit var basicAppRouter: BasicAppRouter

    lateinit var ownEvents: FragmentChildWizard1Events

    lateinit var basicAppRouterReferenceText : TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_child_wizard_1_layout, container, false)

        this.bindViewListeners(view)

        this.bindViews(view)
        this.fillViews()

        return view
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        this.basicAppRouter = this.getBasicAppRouter()
        this.ownEvents = this.getEventAccesorFromParent()
    }

    private fun bindViewListeners(view: View) {
        view.findViewById<Button>(R.id.show_event_button)?.setOnClickListener {
            this.ownEvents.sendEvent.call()
        }
    }

    private fun bindViews(view: View) {
        this.basicAppRouterReferenceText = view.findViewById(R.id.references_text)
    }

    private fun fillViews() {
        this.basicAppRouterReferenceText.text = "BasicAppRouter: ${basicAppRouter}\n" +
                "FragmentChildWizard1Events: ${ownEvents}"
    }

}