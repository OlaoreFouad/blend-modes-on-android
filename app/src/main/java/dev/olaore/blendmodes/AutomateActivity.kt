package dev.olaore.blendmodes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_automate.*

class AutomateActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_automate)
    }

    override fun onPause() {
        super.onPause()
        dragon_cloud_animate_porter_duff_view.stop()
        angel_cloud_animate_porter_duff_view.stop()
    }

}
