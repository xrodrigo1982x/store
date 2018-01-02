package com.github.xrodrigo1982x.myapplication.adapter

import android.app.Activity
import android.databinding.DataBindingUtil
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.github.xrodrigo1982x.myapplication.R
import com.github.xrodrigo1982x.myapplication.databinding.ProductItemBinding
import com.github.xrodrigo1982x.myapplication.model.Product

class ProductAdapter(val ctx : Activity, val products : MutableList<Product>) : BaseAdapter(){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val binding = DataBindingUtil.inflate<ProductItemBinding>(ctx.layoutInflater, R.layout.product_item, parent, false)
        val product = products[position]
        binding.product = product
        binding.image.setImageResource(ctx.resources.getIdentifier("_" + product.image, "drawable", ctx.packageName))
        return binding.root
    }

    override fun getItem(position: Int) = products.get(position)

    override fun getItemId(position: Int) = position.toLong()

    override fun getCount() = products.size

}