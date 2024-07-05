package com.example.photopicker

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun ProfileScreen(){
    Column(
        modifier = Modifier.fillMaxSize()
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
    }
}