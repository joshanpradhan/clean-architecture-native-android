package com.example.news.presentation.meal_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.coroutineScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.news.databinding.FragmentMealDetailsBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class MealDetailsFragment : Fragment() {
    private var _binding: FragmentMealDetailsBinding? = null
    private val binding: FragmentMealDetailsBinding get() = _binding!!
    private val viewModel: MealDetailsViewModel by viewModels()
    private val args: MealDetailsFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMealDetailsBinding.inflate(inflater, container, false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        args.mealId?.let { mealId ->
            viewModel.getMealDetails(mealId)
        }
        lifecycle.coroutineScope.launchWhenCreated {
            viewModel.mealDetails.collect { result ->
                if (result.isLoading) {
                }
                if (result.error.isNotBlank()) {
                    Toast.makeText(requireContext(), result.error, Toast.LENGTH_SHORT).show()
                }
                result.data?.let {
                    binding.mealDetails = it
                }
            }
        }
        binding.detailsBackArrow.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}