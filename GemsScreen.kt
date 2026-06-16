package com.example.gymsaround

import android.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextDirection.Companion.Content
import androidx.compose.ui.unit.dp

@Composable
fun GymsScreen() {
  Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
    listOfGyms.forEach {
      GemItem(it)
    }
  }
}

@Composable
fun GemItem(gym: Gym) {
  Card(elevation = CardDefaults.cardElevation(defaultElevation = 4.dp), modifier = Modifier
    .padding(8.dp).background(Color.Yellow )) {
    Row(verticalAlignment = Alignment.CenterVertically) {
      GymIcon(Icons.Filled.Place,  Modifier.weight(0.15f).padding(8.dp))
      GymDetails(gym,Modifier.weight(0.85f))

    }


  }
}

@Composable
fun GymIcon(vector: ImageVector, modifier: Modifier) {
  Image(
    imageVector = vector,
    contentDescription = "gym icon",
    modifier = modifier,
    colorFilter = ColorFilter.tint(Color.DarkGray)
  )
}

@Composable
fun GymDetails(gym:Gym,modifier: Modifier) {
  Column(modifier = modifier) {
    Text(
      text =gym.name,
      style = MaterialTheme.typography.titleLarge,
      color = Color(0xFFBB86FC)
    )
    CompositionLocalProvider(LocalContentColor provides LocalContentColor.current.copy(alpha = 0.6f)) {
      Text(gym.place)
    }


  }
}

