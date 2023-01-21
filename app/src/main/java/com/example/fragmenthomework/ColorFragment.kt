package com.example.fragmenthomework

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

@Suppress("DEPRECATION")
class ColorFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return layoutInflater.inflate((R.layout.fragment_color), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<View>(R.id.color_view)
            .setBackgroundColor(getColor(arguments?.getString(KEY_COLOR)))
    }

    companion object {
        private const val KEY_COLOR = "KEY_IMAGE"

        fun newInstance(color: String): ColorFragment {
            val fragment = ColorFragment()
            val args = Bundle()
            args.putString(KEY_COLOR, color)
            fragment.arguments = args
            return fragment
        }

    }

    private fun getColor(color: String?): Int {
        return when (color) {
            "Желтый" -> {
                resources.getColor(R.color.yellow)
            }
            "Зеленый" -> {
                resources.getColor(R.color.green)
            }
            "Черный" -> {
                resources.getColor(R.color.black)
            }
            "Красный" -> {
                resources.getColor(R.color.red)
            }
            "Синий" -> {
                resources.getColor(R.color.blue)
            }
            "Белый" -> {
                resources.getColor(R.color.white)
            }
            "Фиолетовый" -> {
                resources.getColor(R.color.purple)
            }
            else -> {
                resources.getColor(R.color.grey)
            }
        }
    }
}