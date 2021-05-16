package com.prakriti.ecommerceapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// specifying primary constructor
    // put var keyword before parameter to pass it to func in class
class RVAdapter(var context: Context, var arrayList: ArrayList<EProduct>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
// adapters bind data to views

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        // called when a new item needs to be created in recycling manner
            // context is used to access references/resources etc from a certain activity
        var productView = LayoutInflater.from(context).inflate(R.layout.rv_row, parent, false) // already attached item to rv
        return ProductViewHolder(productView)

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        // displays data at specified position
        // downcast holder param to specific view holder for this project
        (holder as ProductViewHolder).initializeUI(arrayList[position].getID(), arrayList[position].getName(),
                arrayList[position].getPrice(), arrayList[position].getImage())
    }

    override fun getItemCount(): Int {
        // no of items in list
        return arrayList.size
    }

    // view holder class
    inner class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        // create references to initialize components inside rv_row layout file
        var txt_rvProductID = view.findViewById<TextView>(R.id.txt_rvProductID)
        var txt_rvProductName = view.findViewById<TextView>(R.id.txt_rvProductName)
        var txt_rvProductPrice = view.findViewById<TextView>(R.id.txt_rvProductPrice)
        var img_rvProduct = view.findViewById<ImageView>(R.id.img_rvProduct)

        fun initializeUI(pid:Int, pname:String, pprice:Int, pimage: Int) {
            txt_rvProductID.text = pid.toString()
            txt_rvProductName.text = pname
            txt_rvProductPrice.text = pprice.toString()
            img_rvProduct.setImageResource(pimage)
        }

    }

}