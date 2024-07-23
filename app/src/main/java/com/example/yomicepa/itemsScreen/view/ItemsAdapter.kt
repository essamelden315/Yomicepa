package com.example.yomicepa.itemsScreen.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.yomicepa.databinding.ItemCardBinding
import com.example.yomicepa.models.Item



class ItemsAdapter (private val items: List<Item>): RecyclerView.Adapter<ItemsAdapter.ItemHolder>(){
    private lateinit var cardItemBinding: ItemCardBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ItemHolder {
        cardItemBinding = ItemCardBinding.inflate( LayoutInflater.from(parent.context),parent,false)
        return ItemHolder(cardItemBinding)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        var item = items[position]
        holder.cardBinding.ndc.text = item.ndc
        holder.cardBinding.description.text = item.description
        holder.cardBinding.manufacturer.text = item.manufacturer
        holder.cardBinding.fullQuantity.text = item.fullQuantity.toString()
        holder.cardBinding.partialQuantity.text = item.partialQuantity.toString()
        holder.cardBinding.expirationDate.text =item.expirationDate
        holder.cardBinding.lotNumber.text=item.lotNumber
    }

    override fun getItemCount(): Int {
        return items.size
    }
    class ItemHolder(val cardBinding: ItemCardBinding) : RecyclerView.ViewHolder(cardBinding.root)
}

