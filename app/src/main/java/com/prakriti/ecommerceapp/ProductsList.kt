package com.prakriti.ecommerceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_products_list.*

class ProductsList : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products_list)

        var myProductsList = ArrayList<EProduct>()
        // add items ot arraylist
        myProductsList.add(EProduct(1, "iPhone", 30000, R.drawable.iphone))
        myProductsList.add(EProduct(2, "iMac", 22000, R.drawable.imac))
        myProductsList.add(EProduct(3, "iPad", 35000, R.drawable.ipad))
        myProductsList.add(EProduct(4, "iPod Nano", 17800, R.drawable.ipodnano))
        myProductsList.add(EProduct(5, "iPod Shuffle", 18000, R.drawable.ipodshuffle))
        myProductsList.add(EProduct(6, "iPod Touch", 20500, R.drawable.ipodtouch))
        myProductsList.add(EProduct(7, "MacBook Air", 32000, R.drawable.macbookair))
        myProductsList.add(EProduct(8, "MacBook Pro", 35000, R.drawable.macbookpro))
        myProductsList.add(EProduct(9, "Mac Pro", 29500, R.drawable.macpro))
        myProductsList.add(EProduct(10, "PS4", 28000, R.drawable.ps4))
        myProductsList.add(EProduct(11, "PS4 Pro", 31500, R.drawable.ps4pro))
        myProductsList.add(EProduct(12, "XBox One S", 27500, R.drawable.xboxones))
        myProductsList.add(EProduct(13, "XBox One X", 31250, R.drawable.xboxonex))
        myProductsList.add(EProduct(14, "AppleTV", 34700, R.drawable.appletv))
        myProductsList.add(EProduct(15, "Apple Watch", 24750, R.drawable.applewatch))

        var productAdapter = RVAdapter(this@ProductsList, myProductsList)
            // from layout file
        rv_productList.layoutManager = LinearLayoutManager(this@ProductsList) // vertical view
        rv_productList.adapter = productAdapter
    }
}