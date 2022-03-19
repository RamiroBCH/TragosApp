package com.g.tragosapp.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.g.tragosapp.base.BaseViewHolder
import com.g.tragosapp.data.model.Drink
import com.g.tragosapp.databinding.TragosRowBinding

class MainAdapter(
    private val context: Context, private val tragosList: List<Drink>,
    private val itemClickListener: OnTragoClickListener) :
    RecyclerView.Adapter<BaseViewHolder<*>>() {

    interface OnTragoClickListener {
        fun onTragoClick(drink: Drink)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBinding = TragosRowBinding.inflate(LayoutInflater.from(context), parent, false)

        val holder = MainViewHolder(itemBinding)

        return holder
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when (holder) {
            is MainViewHolder -> holder.bind(tragosList[position], position)
        }
    }

    override fun getItemCount(): Int {
        return tragosList.size
    }

    inner class MainViewHolder(val binding: TragosRowBinding) :
        BaseViewHolder<Drink>(binding.root) {
        override fun bind(item: Drink, position: Int) = with(binding) {
            Glide.with(context).load(item.strDrinkThumb).centerCrop().into(imgTrago)
            txtTitulo.text = item.strDrink
            txtDescripcion.text = item.strInstructions
            itemView.setOnClickListener { itemClickListener.onTragoClick(item) }
        }
    }

}