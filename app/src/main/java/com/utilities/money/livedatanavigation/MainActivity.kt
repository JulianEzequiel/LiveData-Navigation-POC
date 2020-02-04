package com.utilities.money.livedatanavigation

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.utilities.money.livedatanavigation.navigation.BasicAppRouter
import com.utilities.money.livedatanavigation.wizard1.FragmentHost
import com.utilities.money.livedatanavigation.wizard2.ActivityHost

class MainActivity : AppCompatActivity() {

    lateinit var basicAppRouter: BasicAppRouter

    lateinit var basicAppRouterReferenceText : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.bindObservers()
        this.bindViewListeners()

        this.bindViews()
        this.fillViews()
    }

    private fun bindObservers() {
        this.basicAppRouter = ViewModelProviders.of(this).get(BasicAppRouter::class.java)

        this.basicAppRouter.actionBarTitle.observe(this, Observer {
            this.supportActionBar?.title = it
        })
    }

    private fun bindViewListeners() {
        this.findViewById<Button>(R.id.go_to_wizard1_button).setOnClickListener {
            val fragment = FragmentHost()
            val transaction = this.supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, fragment)
            transaction.commit()
        }

        this.findViewById<Button>(R.id.go_to_wizard2_button).setOnClickListener {
            this.startActivity(Intent(this, ActivityHost::class.java))
        }
    }

    private fun bindViews() {
        this.basicAppRouterReferenceText = this.findViewById(R.id.references_text)
    }

    private fun fillViews() {
        this.basicAppRouterReferenceText.text = "BasicAppRouter: ${basicAppRouter}"
    }

}
