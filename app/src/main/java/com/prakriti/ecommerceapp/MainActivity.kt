package com.prakriti.ecommerceapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray

class MainActivity : AppCompatActivity() {

    // using SharedPreferences
    // private var sharedP: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        var prodName = edtProductName.text.toString();
//        btnAdd.setOnClickListener {
//            sharedP = getSharedPreferences("addData", Context.MODE_PRIVATE) // pass unique key and access mod of database
//            // Editor writes data to SharedPreferences
//            var myEditor = sharedP?.edit()
//            myEditor?.putString("product_name", prodName)
//            myEditor?.commit()
//                // put ? for optional vars
//            Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show()
//        }
//        btnGetProduct.setOnClickListener {
//            txtProduct.text = sharedP?.getString("addData", "NO DATA")
//        }


        // displaying php code results on android device screen
        // use lambda expressions
        btnGetProdInfo.setOnClickListener {
            var id = edtProdId.text.toString()
            // var to hold url to retrieve data from
            val productIdUrl = "http://192.168.174.31/ECommerce/presentJson.php?id=" + id

            // from Volley library create request queue
            var requestQ: RequestQueue = Volley.newRequestQueue(this@MainActivity)
            // create var to fetch data
            val prodInfoRequest = JsonObjectRequest(Request.Method.GET, productIdUrl, null,
                Response.Listener {
                    response -> gridProdInfo.visibility = View.VISIBLE
                    txt_prodId.text = id
                    txt_prodName.text = response.getString("name")
                    txt_prodPrice.text = response.getInt("price").toString() // int type to be converted
                },
                Response.ErrorListener {
                    error -> txt_prodId.text = ""
                    txt_prodName.text = ""
                    txt_prodPrice.text = ""
                    Toast.makeText(this@MainActivity, R.string.error_occured, Toast.LENGTH_LONG).show()
                    error.printStackTrace()
                })
            requestQ.add(prodInfoRequest)
        }

        btnGetAllProd.setOnClickListener {
            startActivity(Intent(this@MainActivity, ProductsList::class.java))

/*            val allProductsUrl = "http://192.168.174.31/ECommerce/presentJsonArray.php"
            // to hold json objs
            var allProductsName = ""
            var allProductsPrice = ""
            var allProductsId = ""
            var requestQ: RequestQueue = Volley.newRequestQueue(this@MainActivity)
            // get array
            val jsonArrayRequest = JsonArrayRequest(Request.Method.GET, allProductsUrl, null,
                Response.Listener { response ->
                    gridProdInfo.visibility = View.VISIBLE
                    // iterate over array of objs
                    for (productIndex in 0.until(response.length())) { // does not include last value
                        allProductsId = allProductsId + response.getJSONObject(productIndex).getInt("id") + "\n"
                        allProductsName = allProductsName + response.getJSONObject(productIndex).getString("name") + "\n"
                        allProductsPrice = allProductsPrice + response.getJSONObject(productIndex).getInt("price") + "\n"
                    }
                    txt_prodId.text = allProductsId
                    txt_prodName.text = allProductsName
                    txt_prodPrice.text = allProductsPrice
                },
                Response.ErrorListener { error ->
                    txt_prodId.text = ""
                    txt_prodName.text = ""
                    txt_prodPrice.text = ""
                    Toast.makeText(this@MainActivity, R.string.error_occured, Toast.LENGTH_LONG).show()
                    error.printStackTrace()
                })
            requestQ.add(jsonArrayRequest)
*/
        }

        val imageUrl = "http://192.168.174.31/image1.png"
        // using external Picasso library
        Picasso.get().load(imageUrl).into(imgFromServer)
    }
}