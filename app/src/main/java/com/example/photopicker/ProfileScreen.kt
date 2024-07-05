package com.example.photopicker

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun ProfileScreen(){
    Column(
        modifier = Modifier.fillMaxSize()
            .background(Color.Gray)
        ,
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var selectedItemUri by remember {
            mutableStateOf<Uri?>(null)
        }

        val photoPicker= rememberLauncherForActivityResult(
            contract = ActivityResultContracts.PickVisualMedia()
        ){
            selectedItemUri=it
        }

       AsyncImage(model = selectedItemUri ?: R.drawable.profile,
           contentDescription = "",
           modifier = Modifier
               .clickable {
                   photoPicker.launch(
                       PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                   )
               }
               .size(120.dp)
               .clip(CircleShape),
           contentScale = ContentScale.Crop
       )
        Spacer(modifier = Modifier.height(80.dp))

        OutlinedTextField(value = "Gokul", onValueChange ={} )

        Spacer(modifier = Modifier.height(30.dp))

        OutlinedTextField(value = "gokul@gmail.com", onValueChange ={} )

        Spacer(modifier = Modifier.height(30.dp))

        OutlinedTextField(value = "7449134595", onValueChange ={} )

        Spacer(modifier = Modifier.height(30.dp))
    }
}