package dev.olaore.blendmodes

import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val radioList by lazy {
        listOf(
            radio_clear, radio_darken, radio_destination, radio_destination_atop, radio_destination_in,
            radio_destination_out, radio_destination_over, radio_lighten, radio_multiply, radio_overlay,
            radio_screen, radio_source, radio_source_atop, radio_source_in, radio_source_out,
            radio_source_over, radio_add, radio_xor
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listener: CompoundButton.OnCheckedChangeListener = CompoundButton.OnCheckedChangeListener { button, isChecked ->
            if (!isChecked) {
                return@OnCheckedChangeListener
            }
            when(button.id) {
                R.id.radio_clear -> if (isChecked) {
                    draw_porter_duff_view.mode = PorterDuff.Mode.CLEAR
                    text_porter_duff.text = "CLEAR"
                }
                R.id.radio_darken -> if (isChecked) {
                    draw_porter_duff_view.mode = PorterDuff.Mode.DARKEN
                    text_porter_duff.text = "Darken"
                }
                R.id.radio_destination -> if (isChecked) {
                    draw_porter_duff_view.mode = PorterDuff.Mode.DST
                    text_porter_duff.text = "Destination"
                }
                R.id.radio_destination_atop -> if (isChecked) {
                    draw_porter_duff_view.mode = PorterDuff.Mode.DST_ATOP
                    text_porter_duff.text = "Destination Atop"
                }
                R.id.radio_destination_in -> if (isChecked) {
                    draw_porter_duff_view.mode = PorterDuff.Mode.DST_IN
                    text_porter_duff.text = "Destination In"
                }
                R.id.radio_destination_out -> if (isChecked) {
                    draw_porter_duff_view.mode = PorterDuff.Mode.DST_OUT
                    text_porter_duff.text = "Destination Out"
                }
                R.id.radio_destination_over -> if (isChecked) {
                    draw_porter_duff_view.mode = PorterDuff.Mode.DST_OVER
                    text_porter_duff.text = "Destination Over"
                }
                R.id.radio_lighten -> if (isChecked) {
                    draw_porter_duff_view.mode = PorterDuff.Mode.LIGHTEN
                    text_porter_duff.text = "Lighten"
                }
                R.id.radio_multiply -> if (isChecked) {
                    draw_porter_duff_view.mode = PorterDuff.Mode.MULTIPLY
                    text_porter_duff.text = "Multiply"
                }
                R.id.radio_overlay -> if (isChecked) {
                    draw_porter_duff_view.mode = PorterDuff.Mode.OVERLAY
                    text_porter_duff.text = "Overlay"
                }
                R.id.radio_screen -> if (isChecked) {
                    draw_porter_duff_view.mode = PorterDuff.Mode.SCREEN
                    text_porter_duff.text = "Screen"
                }
                R.id.radio_source -> if (isChecked) {
                    draw_porter_duff_view.mode = PorterDuff.Mode.SRC
                    text_porter_duff.text = "Source"
                }
                R.id.radio_source_atop -> if (isChecked) {
                    draw_porter_duff_view.mode = PorterDuff.Mode.SRC_ATOP
                    text_porter_duff.text = "Source Atop"
                }
                R.id.radio_source_in -> if (isChecked) {
                    draw_porter_duff_view.mode = PorterDuff.Mode.SRC_IN
                    text_porter_duff.text = "Source In"
                }
                R.id.radio_source_out -> if (isChecked) {
                    draw_porter_duff_view.mode = PorterDuff.Mode.SRC_OUT
                    text_porter_duff.text = "Source OUt"
                }
                R.id.radio_source_over -> if (isChecked) {
                    draw_porter_duff_view.mode = PorterDuff.Mode.SRC_OVER
                    text_porter_duff.text = "Source Over"
                }
                R.id.radio_add -> if (isChecked) {
                    draw_porter_duff_view.mode = PorterDuff.Mode.ADD
                    text_porter_duff.text = "ADD"
                }
                R.id.radio_xor -> if (isChecked) {
                    draw_porter_duff_view.mode = PorterDuff.Mode.XOR
                    text_porter_duff.text = "XOR"
                }
            }
        }

        radioList.forEach {
            it.setOnCheckedChangeListener(listener)
        }

    }
}
