package com.gabrielhd.fitnessapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gabrielhd.fitnessapp.callback.stepsCallback
import com.gabrielhd.fitnessapp.databinding.ActivityMainBinding
import com.gabrielhd.fitnessapp.helper.GeneralHelper
import com.gabrielhd.fitnessapp.service.StepDetectorService

class MainActivity : AppCompatActivity(), stepsCallback {

    private lateinit var binding: ActivityMainBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = Intent(this, StepDetectorService::class.java)
        startService(intent)

        StepDetectorService.subscribe.register(this)
    }

    override fun subscribeSteps(steps: Int) {
        binding.TVSTEPS.text = steps.toString()
        binding.TVCALORIES.text = GeneralHelper.getCalories(steps)
        binding.TVDISTANCE.text = GeneralHelper.getDistanceCovered(steps)
    }
}