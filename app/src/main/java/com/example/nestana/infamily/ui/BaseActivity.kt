@file:Suppress("DEPRECATION")

package com.example.nestana.infamily.ui

import android.support.v7.app.AppCompatActivity
import android.view.KeyEvent
import android.view.MenuItem

open class BaseActivity : AppCompatActivity() {


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home)
            onBackPressed()
        return super.onOptionsItemSelected(item)
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            onBackPressed()
            return true
        }
        return super.onKeyDown(keyCode, event)
    }
}