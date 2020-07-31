package dev.olaore.blendmodes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_root.*

class RootActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_root)

        button_draw_porter_duff.setOnClickListener {
            startActivity(Intent(this@RootActivity, MainActivity::class.java))
        }

        button_animate_porter_duff.setOnClickListener {
            startActivity(Intent(this@RootActivity, AutomateActivity::class.java))
        }

    }
}
