package com.example.motionlayoutcrl

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.helper.widget.Carousel
import androidx.core.content.ContextCompat
import androidx.core.view.children
import com.example.motionlayoutcrl.databinding.ActivityMainBinding
import com.example.motionlayoutcrl.model.FoodModel
import com.google.android.material.card.MaterialCardView


class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private var data = ArrayList<FoodModel>()
    lateinit var foodDummyData: ArrayList<FoodModel>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        foodDummyData = arrayListOf(
            FoodModel(
                "Salmon Salad",
                "One of the easiest equations for a wholesome meal is vegetables + salmon. Both are packed with nutrients like protein, healthy fats, and fiber that just make you feel good with every single bite, and this simple recipe is proof",
                "80cal",
                "4.5 rating",
//                ResourcesCompat.getDrawable(resources, R.drawable.img_salmon_salad, null)
                        ContextCompat.getDrawable(this, R.drawable.img_salmon_salad)
            ),
            FoodModel(
                "BBQ Chicken Breast",
                "BBQ chicken, whether cooked on the grill or baked in the oven, is one of those dinners nobody at the table will complain about.Unless it’s dry and overcooked. But that is NOT this recipe. It’s a basic anyone can easily master, so that they too can claim their BBQ chicken is the best on the block.",
                "90cal",
                "4.5 rating",
                ContextCompat.getDrawable(this, R.drawable.img_chicken)

            ),
            FoodModel(
                "Steamed Chicken and Rice",
                "Steaming is an ideal method for cooking boneless chicken breasts and small whole birds such as Cornish hens. It retains the flavor, tenderness and moisture through the use of steam. It is a healthy method of cooking because no additional fat is used.",
                "80cal",
                "4.5 rating",
                ContextCompat.getDrawable(this, R.drawable.steamed_chicken_and_rice)

            ),
            FoodModel(
                "Caesar Salad",
                "A green salad of romaine lettuce and croutons dressed with lemon juice (or lime juice), olive oil, egg, Worcestershire sauce, anchovies, garlic, Dijon mustard, Parmesan cheese, and black pepper.",
                "70cal",
                "4.5 rating",
                ContextCompat.getDrawable(this, R.drawable.caesar_salad)

            ),
            FoodModel(
                "Wholesome Meal",
                "One of the easiest equations for a wholesome meal is vegetables + salmon. Both are packed with nutrients like protein, healthy fats, and fiber that just make you feel good with every single bite, and this simple recipe is proof",
                "80cal",
                "4.5 rating",
                ContextCompat.getDrawable(this, R.drawable.wholesome_meal)
            )
        )
        setupCarousel()
    }

    private fun setupCarousel() {
        val carousel = binding.carouselMenu ?: return
        val numImages = foodDummyData.size

        carousel.setAdapter(object : Carousel.Adapter {
            override fun count(): Int {
                return numImages
            }

            override fun populate(view: View?, index: Int) {
                val item = foodDummyData[index]

                if (view is MaterialCardView){
                    view.setBackgroundDrawable(item.imgId)

                }
//                if (view is MaterialCardView) {
//                    val imageView: MaterialCardView = view as MaterialCardView
//                    imageView.setBackgroundDrawable(item.imgId)
//
//                } else if (view is TextView) {
//                    val textView = view
//                    textView.text = item.title
//                    when(textView.id){
//
//                    }
//                    textView.setBackgroundColor(colors.get(index))
//                }

//                Log.d("imageLIst", "populate:${index}  ")
//                Log.d("imageLIst", "populate:${item.title}  ")
//                Log.d("imageLIst", "populate:${item.imgId}  ")
//
                binding.titleMenu.text = item.title
                binding.tvDescription.text = item.description
                binding.tvRate.text = item.rate
                binding.tvCalories.text = item.calories



            }

            override fun onNewItem(index: Int) {
            }

        })
    }
}

