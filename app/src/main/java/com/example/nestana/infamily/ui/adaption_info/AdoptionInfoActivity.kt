package com.example.nestana.infamily.ui.adaption_info

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.example.nestana.infamily.R
import com.example.nestana.infamily.ui.adaption_info.adopt.AdoptFragment
import com.example.nestana.infamily.ui.adaption_info.foster.FosterFragment
import com.example.nestana.infamily.ui.adaption_info.guardian.GuardianshipFragment
import kotlinx.android.synthetic.main.activity_adoption_info.*


class AdoptionInfoActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adoption_info)
        init()
    }
    private fun init() {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(GuardianshipFragment(), getString(R.string.guardianship))
        adapter.addFragment(AdoptFragment(), getString(R.string.adoption))
        adapter.addFragment(FosterFragment(), getString(R.string.foster))
        tabanim_viewpager.adapter = adapter
        tabanim_tabs.setupWithViewPager(tabanim_viewpager)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        if (item!!.itemId==android.R.id.home){
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}