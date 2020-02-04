package com.utilities.money.livedatanavigation.wizard1

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.utilities.money.livedatanavigation.R
import com.utilities.money.livedatanavigation.navigation.BasicAppRouter

class FragmentHost : Fragment() {

    lateinit var basicAppRouter: BasicAppRouter

    lateinit var fragmentChildWizard1Events: FragmentChildWizard1Events

    lateinit var basicAppRouterReferenceText : TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_wizard_1_host_layout, container, false)

        this.bindObservers()

        this.bindViews(view)
        this.fillViews()

        this.initWizard()

        return view
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        this.basicAppRouter =
            ViewModelProviders.of(this.requireActivity()).get(BasicAppRouter::class.java)
        this.fragmentChildWizard1Events =
            ViewModelProviders.of(this).get(FragmentChildWizard1Events::class.java)
    }

    override fun onResume() {
        super.onResume()

        this.basicAppRouter.changeActionBarTitle("Wizard 1")
    }

    private fun bindObservers() {
        this.fragmentChildWizard1Events.sendEvent.observe(this, Observer {
            Toast.makeText(this.context, "Event Received in FragmentHost", Toast.LENGTH_SHORT)
                .show()
        })
    }

    private fun bindViews(view: View) {
        this.basicAppRouterReferenceText = view.findViewById(R.id.references_text)
    }

    private fun fillViews() {
        this.basicAppRouterReferenceText.text = "BasicAppRouter: ${basicAppRouter}\n" +
                "FragmentChildWizard1Events: ${fragmentChildWizard1Events}"
    }

    private fun initWizard() {
        val fragment = FragmentChildWizard1()
        val transaction = this.childFragmentManager.beginTransaction()
        transaction.replace(R.id.wizard_1_container, fragment)
        transaction.commit()
    }


}