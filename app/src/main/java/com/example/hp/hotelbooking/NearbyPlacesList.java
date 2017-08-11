package com.example.hp.hotelbooking

import android.os.AsyncTask
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast

import com.example.hp.hotelbooking.data.HotelAPIResponse
import com.example.hp.hotelbooking.data.Result
import com.google.gson.Gson

import org.json.JSONException

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL

/**
 * Created by kunai on 3/8/17.
 */

class NearbyPlacesList : AppCompatActivity() {

    internal val API_KEY = "AIzaSyD0vwXNlmIu_O4lAyCOB8imnnl3olpaVN8"
    internal var ma = MainActivity()
    private var lat: Double = 0.toDouble()
    private var lang: Double = 0.toDouble()
    private var recyclerView: RecyclerView? = null
    private var mAdapter: nearbyAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.nearby)

        lat = ma.getLats()
        lang = ma.getLongs()
        Toast.makeText(this, "" + lat, Toast.LENGTH_SHORT).show()
        val g = googlePlaces()
        g.execute()
    }

    @Throws(JSONException::class)
    private fun parseGoogleParse(response: String): List<Result> {
        val resultArrayList: List<Result>
        val gson = Gson()
        val hotelAPIResponse = gson.fromJson<HotelAPIResponse>(response, HotelAPIResponse::class.java!!)
        resultArrayList = hotelAPIResponse.results
        return resultArrayList
    }

    protected inner class googlePlaces : AsyncTask<Void, Void, String>() {

        internal var url: String


        internal var inputString: String? = null

        override fun doInBackground(vararg params: Void): String? {
            val ba: StringBuilder
            val httpconn: HttpURLConnection
            url = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=22.72,75.83&type=hotel&radius=400&key=AIzaSyD0vwXNlmIu_O4lAyCOB8imnnl3olpaVN8"
            val sb = StringBuffer()
            try {

                val urlconn = URL(url)
                httpconn = urlconn.openConnection() as HttpURLConnection
                httpconn.requestMethod = "GET"
                httpconn.connect()

                return readStream(httpconn.inputStream)

            } catch (e: MalformedURLException) {
                e.printStackTrace()
            } catch (e: IOException) {
                e.printStackTrace()
            }

            //            HttpClient httpClient = new DefaultHttpClient();
            //            HttpGet get = new HttpGet(url);

            return null

        }

        // Converting InputStream to String

        private fun readStream(`in`: InputStream): String {
            var reader: BufferedReader? = null
            val response = StringBuffer()
            try {
                reader = BufferedReader(InputStreamReader(`in`))
                var line: String
                while ((line = reader.readLine()) != null) {
                    response.append(line)
                }
            } catch (e: IOException) {
                e.printStackTrace()
            } finally {
                if (reader != null) {
                    try {
                        reader.close()
                    } catch (e: IOException) {
                        e.printStackTrace()
                    }

                }
            }
            return response.toString()
        }

        override fun onPostExecute(result: String?) {
            if (result == null) {
                Toast.makeText(applicationContext, "No Results Found", Toast.LENGTH_SHORT).show()
            } else {
                try {
                    // venues = parseGoogleParse(result);
                    recyclerView = findViewById(R.id.recyclerView) as RecyclerView
                    val mLayoutManager = LinearLayoutManager(applicationContext)

                    mAdapter = nearbyAdapter(parseGoogleParse(result))

                    recyclerView!!.layoutManager = mLayoutManager
                    recyclerView!!.adapter = mAdapter
                } catch (e: JSONException) {
                    e.printStackTrace()
                }

            }
        }
    }
}