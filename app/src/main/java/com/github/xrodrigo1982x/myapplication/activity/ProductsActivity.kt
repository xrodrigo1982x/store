package com.github.xrodrigo1982x.myapplication.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import com.github.javafaker.Faker
import com.github.xrodrigo1982x.myapplication.R
import com.github.xrodrigo1982x.myapplication.adapter.ProductAdapter
import com.github.xrodrigo1982x.myapplication.model.Product
import com.mcxiaoke.koi.ext.startActivity
import kotlinx.android.synthetic.main.activity_products.*

class ProductsActivity : AppCompatActivity() {

    var products:MutableList<Product>? = mutableListOf()
    var adapter : ProductAdapter? = null
    val faker = Faker()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        createList()

        adapter = ProductAdapter(this, products!!)
        productList.adapter = adapter

        productList.setOnItemClickListener{ parent, view, position, id ->
            val bundle = Bundle()
            bundle.putSerializable("product", products?.get(position))
            startActivity<ProductActivity>(bundle)
        }

    }

    private fun createList() {
        for (i in 0..6) {
            val element = Product()
            element.image = i
            element.name = faker.commerce().productName()
            element.description = faker.lorem().paragraph()
            element.code = faker.code().asin()
            element.price = faker.number().randomDouble(2, 10, 100)
            element.rating = faker.number().numberBetween(0, 10)
            products?.add(element)
        }
    }
}
