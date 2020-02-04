package com.utilities.money.livedatanavigation.wizard2

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.utilities.money.livedatanavigation.R
import com.utilities.money.livedatanavigation.navigation.BasicAppRouter

class ActivityHost : AppCompatActivity() {

    lateinit var basicAppRouter: BasicAppRouter

    lateinit var fragmentChildWizard2Events: FragmentChildWizard2Events

    lateinit var basicAppRouterReferenceText : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wizard_2_layout)

        this.bindObservers()

        this.bindViews()
        this.fillViews()

        this.initWizard()
    }

    override fun onResume() {
        super.onResume()

        this.basicAppRouter.changeActionBarTitle("Wizard 2")
    }

    private fun bindObservers() {
        this.basicAppRouter = ViewModelProviders.of(this).get(BasicAppRouter::class.java)
        this.basicAppRouter.actionBarTitle.observe(this, Observer {
            this.supportActionBar?.title = it
        })

        this.fragmentChildWizard2Events = ViewModelProviders.of(this).get(FragmentChildWizard2Events::class.java)
        this.fragmentChildWizard2Events.sendEvent.observe(this, Observer {
            Toast.makeText(this, "Event Received in ActivityHost", Toast.LENGTH_SHORT).show()
        })
    }

    private fun bindViews() {
        this.basicAppRouterReferenceText = this.findViewById(R.id.references_text)
    }

    private fun fillViews() {
        this.basicAppRouterReferenceText.text = "BasicAppRouter: ${basicAppRouter}\n" +
                "FragmentChildWizard2Events: ${fragmentChildWizard2Events}"
    }

    private fun initWizard() {
        val fragment = FragmentChildWizard2()
        val transaction = this.supportFragmentManager.beginTransaction()
        transaction.replace(R.id.wizard_2_container, fragment)
        transaction.commit()
    }

}