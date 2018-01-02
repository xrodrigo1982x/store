package com.github.xrodrigo1982x.myapplication.activity

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.github.xrodrigo1982x.myapplication.R
import com.github.xrodrigo1982x.myapplication.databinding.ProductActivityBinding
import com.github.xrodrigo1982x.myapplication.model.Product

class ProductActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : ProductActivityBinding = DataBindingUtil.setContentView(this, R.layout.product_activity)
        val product = intent.extras.get("product") as Product
        binding.product = product
        binding.image.setImageResource(this.resources.getIdentifier("_" + product.image, "drawable", this.packageName))
    }
}
