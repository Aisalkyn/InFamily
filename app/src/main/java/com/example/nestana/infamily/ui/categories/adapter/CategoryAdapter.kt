package com.example.nestana.infamily.ui.categories.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.nestana.infamily.R
import com.example.nestana.infamily.model.Category
import kotlinx.android.synthetic.main.item_category.view.*

class CategoryAdapter(var mCategoryList: List<Category>,
                      val mListener: OnItemClickListener) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>(){


    interface OnItemClickListener {
        fun onItemClick(category: Category)
    }


    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder!!.bindGood(mCategoryList[position], mListener)
    }

    fun setList(list: List<Category>) {
        mCategoryList = list
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent!!.context).inflate(R.layout.item_category, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return mCategoryList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindGood(category: Category, listener: OnItemClickListener) {
            itemView.tvCategoryTitle.text = category.title
            bindImage(itemView.ivCategoryImage, category.imageURL)
            bindImage(itemView.ivCategoryIcon, category.iconURL)

            itemView.setOnClickListener {
                listener.onItemClick(category)
            }
        }



        fun bindImage(view: ImageView, uri: String?){
            Glide.with(itemView.context)
                    .load(uri)
                    .centerCrop()
                    .into(view)
        }
    }
}