package com.turacican.cookbook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout.Directions
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.turacican.cookbook.R.id.action_listFragment_to_cookFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    //Menuyu activity'e burada bağlıyoruz / ekliyoruz
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.yemek_ekle, menu)

        return super.onCreateOptionsMenu(menu)
    }

    //Menuden bir şey seçilirse yapılacak action'ları burada belirtiriz
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        try {

            if(item.itemId == R.id.menu_YemekEkle){
                val navController = findNavController(R.id.fragmentContainerView)
                navController.navigate(R.id.action_listFragment_to_cookFragment)

                return true
            }

        } catch (e: Exception) {
            Toast.makeText(this, "Hata! ${e.message}", Toast.LENGTH_LONG).show()
        }
        finally {
            return super.onOptionsItemSelected(item)
        }
    }

}