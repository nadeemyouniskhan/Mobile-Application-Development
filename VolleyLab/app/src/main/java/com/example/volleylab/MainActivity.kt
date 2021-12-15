package com.example.volleylab
import android.graphics.Bitmap
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.ImageRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val stringbtn:Button=findViewById(R.id.btn1)
        stringbtn.setOnClickListener({
            Request_String()
        })

        val Json_object:Button=findViewById(R.id.btn2)
        Json_object.setOnClickListener({
            Request_Json()
        })

        val imagebtn:Button=findViewById(R.id.btn3)
        imagebtn.setOnClickListener({
            Request_Image()
        })

        val addParam:Button=findViewById(R.id.btn4)
        addParam.setOnClickListener({
            Add_Post_parameter()
        })
    }




    /*  1 Request String format */
    private fun Request_String() {

        val view:TextView=findViewById(R.id.txtView)

        val queue= Volley.newRequestQueue(this)

        val url = "https://run.mocky.io/v3/8e7cb297-d1a8-45d7-b51c-19c750c75c2b"
        val stringRequest = StringRequest(
            Request.Method.GET,
            url,
            Response.Listener<String> { response ->
                view.isVisible = true
                view.text = response

            },
            Response.ErrorListener { error ->
                view.text = "Can't load request"

                Log.d("Cant manage request", error.toString())

            })
        // Add StringRequest to the RequestQueue
        queue.add(stringRequest)
    }

    /*  2 Request Json format  */
    private fun Request_Json() {
        val view:TextView=findViewById(R.id.txtView)

        val queue= Volley.newRequestQueue(this)

        val url = "https://run.mocky.io/v3/9c06f03b-bb73-4fc9-9262-ed23e7ef2f4e"

        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET,
            url,
            null,
            Response.Listener<JSONObject> { response ->
                view.isVisible = true
                view.text = response.toString()

            },
            Response.ErrorListener { error ->
                view.text = "Can't load request"

                Log.d("Cant manage request", error.toString())

            })
        // Add JsonRequest to the RequestQueue
        queue.add(jsonObjectRequest)
    }

    /*  3  Request Image   */
    private fun Request_Image() {
        val image:ImageView=findViewById(R.id.Viewimage)
        val queue= Volley.newRequestQueue(this)
        val mImageURLString="https://cdn.pixabay.com/photo/2018/01/14/23/12/nature-3082832_960_720.jpg"
        val imageRequest = ImageRequest(
            mImageURLString, // Image URL
            Response.Listener<Bitmap> { response ->
                image.setImageBitmap(response)

            },
            250, // Image width
            250, // Image height
            ImageView.ScaleType.CENTER_CROP, // Image scale type
            Bitmap.Config.RGB_565, //Image decode configuration
            Response.ErrorListener() { // Error listener
                Response.ErrorListener { error ->

                    Toast.makeText(this,"Can't manage request",Toast.LENGTH_LONG).show()
                    Log.d("Cant manage request", error.toString())

                }
            }
        );
        // Add ImageRequest to the RequestQueue
        queue.add(imageRequest)
    }

    /*  4 Adding Post Paramters  */
    private fun Add_Post_parameter() {
        val view:TextView=findViewById(R.id.txtView)
        val queue= Volley.newRequestQueue(this)
        val url = "https://run.mocky.io/v3/cc1eb953-b35f-49b0-b20e-e43232921464"

        val params = HashMap<String,String>()
        params["name"] = "Muhammad Nadeem"
        params["Gender"] = "Male"
        params["Reg_No"] = "FA18-BSE-074"
        params["Class"] = "BSE-7B"

        val jsonObject = JSONObject(params as Map<*, *>)


        val PostParam = JsonObjectRequest(
            Request.Method.POST,
            url,
            jsonObject,
            Response.Listener { response ->
                view.text = "Response: $response"

            },
            Response.ErrorListener{error->
                // Error in request
                view.text = "Volley error: $error"

            })

        queue.add(PostParam)
    }

}