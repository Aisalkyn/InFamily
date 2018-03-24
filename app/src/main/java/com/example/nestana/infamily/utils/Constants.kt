package com.baktiyar.android.jardamberem.utils

import android.content.Context
import android.database.Cursor
import android.net.ConnectivityManager
import android.net.Uri
import android.provider.MediaStore


/**
 * Created by admin on 08.03.2018.
 */
class Constants {
    companion object {
        val CAMERA = 1
        val GALLERY = 2

        fun getRealPathFromURI(context: Context, contentUri: Uri): String {
            var cursor: Cursor? = null
            try {
                val proj = arrayOf(MediaStore.Images.Media.DATA)
                cursor = context.contentResolver.query(contentUri, proj, null, null, null)
                val column_index = cursor!!.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
                cursor.moveToFirst()
                return cursor.getString(column_index)
            } finally {
                if (cursor != null) {
                    cursor.close()
                }
            }
        }


    }

    fun isNetworkConnected(): Boolean {
        var context: Context? = null
        val cm = context!!.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = cm.activeNetworkInfo ?: return false
        return activeNetwork.isConnectedOrConnecting
    }



}