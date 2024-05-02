package com.example.myproject

import android.os.Bundle
import android.text.Html
import android.text.Spanned
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class RecipeDetailFragment : Fragment() {

    companion object {
        private const val ARG_NAME = "recipeName"
        private const val ARG_INSTRUCTIONS = "recipeInstructions"

        fun newInstance(name: String, instructions: String): RecipeDetailFragment {
            val fragment = RecipeDetailFragment()
            val args = Bundle()
            args.putString(ARG_NAME, name)
            args.putString(ARG_INSTRUCTIONS, instructions)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_recipe_detail, container, false)
        val recipeNameTextView = view.findViewById<TextView>(R.id.recipeNameTextView)
        val recipeInstructionsTextView = view.findViewById<TextView>(R.id.recipeInstructionsTextView)

        val name = arguments?.getString(ARG_NAME)
        val instructions = arguments?.getString(ARG_INSTRUCTIONS)

        recipeNameTextView.text = name
        recipeInstructionsTextView.text = formatInstructions(instructions ?: "")

        return view
    }

    private fun formatInstructions(instructions: String): Spanned {
        val formattedInstructions = instructions.split("\n").joinToString("<br/>") { "• $it" }
        return Html.fromHtml(formattedInstructions, Html.FROM_HTML_MODE_LEGACY)
    }
}
