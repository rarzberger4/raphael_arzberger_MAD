package com.example.lectureexamples.screens

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.lectureexamples.models.Movie
import com.example.lectureexamples.models.getMovies
import com.example.lectureexamples.navigation.Navigation

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DetailScreen(navController: NavController, movieId: String?) {
    var expanded by remember { mutableStateOf(false) }

    var movies = getMovies()
    var movie = movies?.find { it.id == movieId }

    Scaffold(
        topBar = {
            TopAppBar {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp),
                    horizontalArrangement = Arrangement.Start
                ) {
                    IconButton(
                        modifier = Modifier.size(24.dp),
                        onClick = { navController.popBackStack() },
                    ) {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowLeft,
                            contentDescription = "DropdownMenu",
                        )
                    }
                    Text(text = "   Details")
                }
            }
        }
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            shape = RoundedCornerShape(corner = CornerSize(15.dp)),
            elevation = 5.dp
        ) {
            Column {
                Box(
                    modifier = Modifier
                        .height(150.dp)
                        .fillMaxWidth()
                ) {
                    if (movie != null) {
                        AsyncImage(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(movie.images[0])
                                .crossfade(true)
                                .build(),
                            contentDescription = "lol",
                            contentScale = ContentScale.Crop
                        )
                    }

                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(10.dp),
                        contentAlignment = Alignment.TopEnd
                    ) {
                        Icon(
                            tint = MaterialTheme.colors.secondary,
                            imageVector = Icons.Default.FavoriteBorder,
                            contentDescription = "Add to favorites"
                        )
                    }
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    if (movie != null) {
                        Text(movie.title, style = MaterialTheme.typography.h6)
                        IconButton(
                            modifier = Modifier.size(24.dp),
                            onClick = {
                                expanded = !expanded
                            },
                        ) {
                            if (expanded) {
                                Icon(
                                    imageVector = Icons.Default.KeyboardArrowUp,
                                    contentDescription = ("Show details")
                                )
                            } else {
                                Icon(
                                    imageVector = Icons.Default.KeyboardArrowDown,
                                    contentDescription = ("Show details")
                                )
                            }
                        }
                    }
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    if (expanded) {
                        Column() {


                            if (movie != null) {
                                Text("Title: ${movie.title}")
                            }
                            if (movie != null) {
                                Text("Year: ${movie.year}")
                            }
                            if (movie != null) {
                                Text("Rating: ${movie.rating}")
                            }
                            if (movie != null) {
                                Text("Genre: ${movie.genre}")
                            }
                            if (movie != null) {
                                Text("Director: ${movie.director}")
                            }

                            //DetailScreen(navController = rememberNavController(), movieId = movie.id)


                            LazyColumn {
                                if (movie != null) {
                                    items(movie.images.chunked(2)) { imagePair ->
                                        Row(Modifier.fillMaxWidth()) {
                                            imagePair.forEach { imageUrl ->
                                                AsyncImage(
                                                    model = ImageRequest.Builder(LocalContext.current)
                                                        .data(imageUrl)
                                                        .crossfade(true)
                                                        .build(),
                                                    contentDescription = "lol",
                                                    contentScale = ContentScale.Crop,
                                                    modifier = Modifier
                                                        .weight(1f)
                                                        .padding(8.dp)
                                                )
                                            }
                                        }
                                    }
                                }
                            }

                        }
                    }

                }

            }
        }

    }
}

    










