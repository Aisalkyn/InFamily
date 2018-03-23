package com.example.nestana.infamily.ui.articles.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.nestana.infamily.R
import com.example.nestana.infamily.model.Article
import kotlinx.android.synthetic.main.item_article.view.*

/**
 * Created by admin on 24.03.2018.
 */
class ArticleAdapter(var mArticleList: List<Article>,
                     val mListener: OnItemClickListener) : RecyclerView.Adapter<ArticleAdapter.ViewHolder>(){


    interface OnItemClickListener {
        fun onItemClick(article: Article)
    }


    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder!!.bindGood(mArticleList[position], mListener)
    }

    fun setList(list: List<Article>) {
        mArticleList = list
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent!!.context).inflate(R.layout.item_article, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return mArticleList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindGood(article: Article, listener: OnItemClickListener) {
            itemView.tvArticleTitle.text = article.title

            Glide.with(itemView.context)
                    .load(article.image)
                    .centerCrop()
                    .into(itemView.ivArticleImage)

            itemView.setOnClickListener {
                listener.onItemClick(article)
            }
        }
    }
}