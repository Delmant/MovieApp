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
import androidx.lifecycle.ViewModelProvider
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
        searchSettingsViewModel =
            ViewModelProvider(this, viewModelFactory)[SearchSettingsViewModel::class.java]
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
        setupSlider()
        setupGenreButtonLaunchChoose()
        setupCountryButtonLaunchChoose()
        setupYearChoose()
        setupSaveButton()
    }

    private fun setupSlider() {
        binding.sliderRating.addOnChangeListener { slider, value, fromUser ->
            val toText = value.toString().split(".")[0]
            binding.tvRatingChoose.text = if (toText == "0") "неважно" else "от $toText"
            searchSettingsViewModel?.saveSearchSettings(
                RATING_KEY_WORD,
                binding.sliderRating.value.toString()
            )
        }
    }
    private fun setupGenreButtonLaunchChoose() {
        binding.tvGenreChoose.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .add(
                    R.id.fragment_container,
                    SearchSettingsDetailFragment.newInstance(GENRE_ARGUMENT)
                )
                .addToBackStack(null).commit()
        }
    }

    private fun setupCountryButtonLaunchChoose() {
        binding.tvCountryChoose.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .add(
                    R.id.fragment_container,
                    SearchSettingsDetailFragment.newInstance(COUNTRY_ARGUMENT)
                )
                .addToBackStack(null).commit()
        }
    }

    private fun setupYearChoose() {
        binding.tvYearChoose.setOnClickListener {

            val view = LayoutInflater.from(requireContext()).inflate(R.layout.number_picker, null)
            val fromPicker = view.findViewById<NumberPicker>(R.id.from_picker)
            val toPicker = view.findViewById<NumberPicker>(R.id.to_picker)

            val currentYear = Calendar.getInstance().get(Calendar.YEAR)

            setupPicker(fromPicker, currentYear)
            setupPicker(toPicker, currentYear)
            pickerChangedListener(fromPicker, toPicker)
            setupDialog(fromPicker, toPicker)
        }
    }

    private fun setupDialog(fromPicker: NumberPicker, toPicker: NumberPicker) {
        val dialog = AlertDialog.Builder(requireContext())
            .setTitle("Год")
            .setView(view)
            .setPositiveButton("Выбрать") { dialogInterface: DialogInterface, i: Int ->
                val result = "${fromPicker.value} / ${toPicker.value}"
                searchSettingsViewModel?.saveSearchSettings(YEAR_KEY_WORD, result)
            }
            .setNegativeButton("Отмена", null)
            .create()
        dialog.show()
    }

    private fun pickerChangedListener(fromPicker: NumberPicker, toPicker: NumberPicker) {
        fromPicker.setOnValueChangedListener { _, _, newVal ->
            if (newVal >= toPicker.value) {
                toPicker.value = newVal
                toPicker.maxValue = newVal
            }
        }

        toPicker.setOnValueChangedListener { _, _, newVal ->
            fromPicker.maxValue = newVal
        }
    }

    private fun setupPicker(numberPicker: NumberPicker, currentYear: Int) {
        numberPicker.value = currentYear
        numberPicker.minValue = MIN_YEAR_PARAM
        numberPicker.maxValue = MAX_YEAR_PARAM
    }

    private fun setupSaveButton() {
        binding.btnPlayTrailer.setOnClickListener {
            searchSettingsViewModel?.getSearchSettings()
        }
    }

    companion object {

        private const val GENRE_ARGUMENT = "genres.name"
        private const val COUNTRY_ARGUMENT = "countries.name"

        private const val YEAR_KEY_WORD = "year"
        private const val RATING_KEY_WORD = "rating"

        private const val MIN_YEAR_PARAM = 1900
        private const val MAX_YEAR_PARAM = 2023

        fun newInstance(): SearchSettingsFragment {
            return SearchSettingsFragment()
        }
    }
}