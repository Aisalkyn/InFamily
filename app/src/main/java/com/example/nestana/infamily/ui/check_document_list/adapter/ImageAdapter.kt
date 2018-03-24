package com.example.nestana.infamily.ui.check_document_list.adapter

/**
 * Created by admin on 25.03.2018.
 */

import android.content.Context
import android.os.Parcelable
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.nestana.infamily.R
import kotlinx.android.synthetic.main.item_image.view.*
import java.util.*


class ImageAdapter(
        private val context: Context,
        private val imagePaths: ArrayList<String>?) : PagerAdapter(){

    private var inflater: LayoutInflater


    init {
        inflater = LayoutInflater.from(context)
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun getCount(): Int {
        return imagePaths!!.size
    }

    override fun getItemPosition(`object`: Any?): Int {
        return PagerAdapter.POSITION_NONE
    }

    override fun instantiateItem(view: ViewGroup, position: Int): Any {
        val imageLayout = inflater.inflate(R.layout.item_image, view, false)!!
        val imageView = imageLayout.findViewById<ImageView>(R.id.ivImageDocument)
        Glide
                .with(context)
                .load(imagePaths!!.get(position))
                .asBitmap()
                .into(imageView)

        view.addView(imageLayout)
        return imageLayout
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun restoreState(state: Parcelable?, loader: ClassLoader?) {}

    override fun saveState(): Parcelable? {
        return null
    }


}


