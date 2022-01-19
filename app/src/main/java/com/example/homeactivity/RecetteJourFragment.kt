package com.example.homeactivity

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.homeactivity.placeholder.PlaceholderContent
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import org.json.JSONArray
import org.json.JSONObject
import org.json.JSONException
import android.util.Log
import android.util.Log.DEBUG
import android.util.TypedValue
import android.widget.EditText


/**
 * A fragment representing a list of Items.
 */

class RecetteJourFragment : Fragment() {

    private var columnCount = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }

        var queryResult = ConnectAPI()
        val recetteInfo = findViewById(R.id.content) as TextView
        //val textView = findViewById<TextView>(R.id.textView2)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_recette_jour_list, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
                adapter = MyItemRecyclerViewAdapter(PlaceholderContent.ITEMS)
            }
        }
        return view
    }

    fun ConnectAPI() : Int{
        var url = URL("https://api.spoonacular.com/recipes/complexSearch?query=lunch&number=2")
        var connection = url.openConnection() as HttpURLConnection
        connection.requestMethod = "POST"
        val `in` = connection.inputStream
        val reader = InputStreamReader(`in`)
        var data = reader.read()
        return data
    }
    /*
        val  jArray : JSONArray = JSONArray(data)
        for (i in 0 until jArray.length()) {
            try {
                val oneObject: JSONObject = jArray.getJSONObject(i)
                // Pulling items from the array
                val oneObjectsItem = oneObject.getString("STRINGNAMEinTHEarray")
                val oneObjectsItem2 = oneObject.getString("anotherSTRINGNAMEINtheARRAY")
            } catch (e: JSONException) {
                // Oops
            }
        }
*/


    }
    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
            RecetteJourFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }
}