package com.example.myproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment

class RecipeListFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_recipe_list, container, false)
        val listView = view.findViewById<ListView>(R.id.recipeListView)
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, RecipeData.recipes.map { it.name })
        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->
            val selectedRecipe = RecipeData.recipes[position]
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, RecipeDetailFragment.newInstance(selectedRecipe.name, selectedRecipe.instructions))
                .addToBackStack(null)
                .commit()
        }

        return view
    }
}



