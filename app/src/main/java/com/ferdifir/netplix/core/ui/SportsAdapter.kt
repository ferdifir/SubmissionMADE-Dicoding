package com.ferdifir.netplix.core.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ferdifir.netplix.core.domain.model.Sport
import com.ferdifir.netplix.databinding.ItemCardListBinding

class SportsAdapter : RecyclerView.Adapter<SportsAdapter.MovieViewHolder>() {

    private var listData = ArrayList<Sport>()
    var onItemClick: ((Sport) -> Unit)? = null

    fun setData(newListData: List<Sport>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemCardListBinding =
            ItemCardListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(itemCardListBinding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(listData[position])
    }

    override fun getItemCount(): Int = listData.size

    inner class MovieViewHolder(private val binding: ItemCardListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(sport: Sport) {
            with(binding) {
                tvItemTitle.text = sport.strSport
                tvItemSubtitle.text = sport.strFormat

                Glide.with(itemView.context)
                    .load(sport.strSportThumb)
                    .into(ivItemImage)
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listData[adapterPosition])
            }
        }
    }
}