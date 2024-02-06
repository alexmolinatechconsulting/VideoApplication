package com

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.authentication.LoginActivity
import com.video.VideoFragment
import com.videoapplication.R
import com.videoapplication.databinding.FragmentVideoBinding

class VideoApplicationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_application)

        val toolbar = findViewById<Toolbar>(R.id.main_toolbar)
        setSupportActionBar(toolbar)

        toolbar.showOverflowMenu()

        getSupportFragmentManager()
            .beginTransaction()
            .add(
                R.id.frame_layout,
                VideoFragment()//FragmentVideoBinding.inflate(R.layout.fragment_video)
            )
            .addToBackStack(null)
            .commit()

}

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_dropdown, menu)
        return super.onPrepareOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)

        if(item.itemId == R.id.logout_menu_option){
            val auth = VideoApplication.instance.container!!.auth
            auth.signOut()

            startActivity(Intent(this@VideoApplicationActivity, LoginActivity::class.java))
            finish()
        }

        return true
    }
}