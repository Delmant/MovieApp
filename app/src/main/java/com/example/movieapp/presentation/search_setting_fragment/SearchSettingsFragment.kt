package com.example.movieapp.presentation.search_setting_fragment

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.NumberPicker
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.movieapp.R
import com.example.movieapp.databinding.FragmentSearchSettingBinding
import com.example.movieapp.presentation.MovieApp
import com.example.movieapp.presentation.ViewModelFactory
import com.example.movieapp.presentation.search_settings_detail_fragment.SearchSettingsDetailFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import java.util.Calendar
import javax.inject.Inject


class SearchSettingsFragment : Fragment() {

    private var _binding: FragmentSearchSettingBinding? = null
    private val binding: FragmentSearchSettingBinding
        get() = _binding ?: throw RuntimeException("")

    val coroutineScope = CoroutineScope(Dispatchers.IO)

    private var searchSettingsViewModel: SearchSettingsViewModel? = null

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val component by lazy {
        (requireActivity().application as MovieApp).component
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        component.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchSettingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.appBar.text.text = "Поиск лучших фильмов"
        binding.appBar.ivBack.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
        binding.appBar.tvReset.setOnClickListener {
            Toast.makeText(requireContext(), "Сброс", Toast.LENGTH_LONG).show()
        }
        binding.sliderRating.addOnChangeListener { slider, value, fromUser ->
            val toText = value.toString().split(".")[0]
            binding.tvRatingChoose.text = if (toText == "0") "неважно" else "от $toText"
        }

        binding.tvGenreChoose.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .add(
                    R.id.fragment_container,
                    SearchSettingsDetailFragment.newInstance(GENRE_ARGUMENT)
                )
                .addToBackStack(null).commit()
        }
        binding.tvCountryChoose.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .add(
                    R.id.fragment_container,
                    SearchSettingsDetailFragment.newInstance(COUNTRY_ARGUMENT)
                )
                .addToBackStack(null).commit()
        }
        binding.tvYearChoose.setOnClickListener {

            val view = LayoutInflater.from(requireContext()).inflate(R.layout.number_picker, null)

            val fromPicker = view.findViewById<NumberPicker>(R.id.from_picker)
            val toPicker = view.findViewById<NumberPicker>(R.id.to_picker)



            val currentYear = Calendar.getInstance().get(Calendar.YEAR)
            val minYear = 1900
            val maxYear = 2023

            fromPicker.minValue = minYear
            fromPicker.maxValue = maxYear
            fromPicker.value = currentYear

            toPicker.minValue = minYear
            toPicker.maxValue = maxYear
            toPicker.value = currentYear

            fromPicker.setOnValueChangedListener { picker, oldVal, newVal ->
                if(newVal >= toPicker.value) {
                    toPicker.value = newVal
                    toPicker.maxValue = newVal
                }
            }

            toPicker.setOnValueChangedListener { picker, oldVal, newVal ->
                fromPicker.maxValue = newVal
            }


            val dialog = AlertDialog.Builder(requireContext())
                .setTitle("Год")
                .setView(view)
                .setPositiveButton("Выбрать") { dialogInterface: DialogInterface, i: Int ->
                }
                .setNegativeButton("Отмена", null)
                .create()
            dialog.show()
        }
    }

    companion object {

        private const val GENRE_ARGUMENT = "genres.name"
        private const val COUNTRY_ARGUMENT = "countries.name"

        fun newInstance(): SearchSettingsFragment {
            return SearchSettingsFragment()
        }
    }
}