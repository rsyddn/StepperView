package com.example.stepperview

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson

class CitizenshipActivity : AppCompatActivity() {
    private var filteredCountry: ArrayList<Country> = arrayListOf()

    companion object {
        const val EXTRA_RESULT = "extra_result_value"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_citizenship)

        val tvWni: TextView = findViewById(R.id.tv_wni)
        val countryString: String = this.getJsonFromRaw(R.raw.country_data)
        val rvCountry: RecyclerView = findViewById(R.id.rv_city)
        val svCitizenship: SearchView = findViewById(R.id.sv_citizenship)


        val countryList = Gson().fromJson(countryString, Array<Country>::class.java).toList()
        filteredCountry.addAll(countryList)

        val cListAdapter = CitizenshipListAdapter(filteredCountry, onClickListener = { country ->
            Toast.makeText(this, "Country Selected: ${country.name}", Toast.LENGTH_SHORT).show()
            val intent = Intent()
            intent.putExtra(CameraActivity.EXTRA_RESULT, country.name)
            setResult(RESULT_OK, intent)
            finish()
        })
        rvCountry.setHasFixedSize(true)

        rvCountry.apply {
            rvCountry.layoutManager = LinearLayoutManager(this@CitizenshipActivity)
            rvCountry.adapter = cListAdapter
        }

        tvWni.setOnClickListener {
            Toast.makeText(this, "Country Selected: Indonesia", Toast.LENGTH_SHORT).show()
            val intent = Intent()
            intent.putExtra(CameraActivity.EXTRA_RESULT, "Indonesia")
            setResult(RESULT_OK, intent)
            finish()
        }

        svCitizenship.setIconifiedByDefault(false)
        svCitizenship.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                val searchText = newText!!.lowercase()
                if (searchText.isNotEmpty()) {
                    filteredCountry.clear()
                    countryList.forEach { data ->
                        if (data.name!!.lowercase().contains(searchText)) {
                            filteredCountry.add(data)
                        }
                    }
                    rvCountry.adapter!!.notifyDataSetChanged()
                } else {
                    filteredCountry.clear()
                    filteredCountry.addAll(countryList)
                    rvCountry.adapter!!.notifyDataSetChanged()
                }
                return false
            }

        })
    }
}