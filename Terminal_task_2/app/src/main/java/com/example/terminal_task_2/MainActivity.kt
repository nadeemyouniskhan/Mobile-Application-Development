package com.example.terminal_task_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.example.terminal_task_2.databinding.ActivityMainBinding
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

        private val movieList = ArrayList<Model>()

        private lateinit var Adapter: Adapter
        override fun onCreate(savedInstanceState: Bundle?) {
            lateinit var binding: ActivityMainBinding

            super.onCreate(savedInstanceState)
            binding=ActivityMainBinding.inflate(layoutInflater)
            val view=binding.root
            setContentView(view)

            title = "KotlinApp"
       //     val recyclerView: RecyclerView = findViewById(R.id.RecyclerView)
            Adapter = Adapter(movieList)
            val layoutManager = LinearLayoutManager(applicationContext)
                binding.RecyclerView.layoutManager = layoutManager
                binding.RecyclerView.itemAnimator = DefaultItemAnimator()
                binding.RecyclerView.adapter = Adapter



            // volley

            val queue= Volley.newRequestQueue(this)

            val url = "https://run.mocky.io/v3/cc1eb953-b35f-49b0-b20e-e43232921464"

            val jsonObjectRequest = JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                Response.Listener { response ->

                    for (i in 0 until response.length){
                        JSONObject student = response.getJSONObject(i)
                       val title = student.getString("title")
                        val product= Student.getString("product")
                        val quantity = student.getString("quantity")
                        movieList.add(title,product,quantity)
                    }

                },
                Response.ErrorListener { error ->

                    Log.d("Cant manage request", error.toString())

                })
            // Add JsonRequest to the RequestQueue
            queue.add(jsonObjectRequest)
        }

        }

       // volley


    }
}