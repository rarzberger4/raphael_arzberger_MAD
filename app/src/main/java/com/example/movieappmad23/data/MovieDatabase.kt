package com.example.movieappmad23.data
//
//import android.content.Context
//import androidx.room.Database
//import androidx.room.Room
//import androidx.room.RoomDatabase
//import androidx.room.TypeConverters
//import com.example.movieappmad23.models.Movie
//
//@Database(
//    entities = [Movie::class],
//    version = 1,
//    exportSchema = false
//)
//@TypeConverters(CustomConverters::class)
//abstract class MovieDatabase : RoomDatabase() {
//
//    abstract fun MovieDao(): MovieDao
//
//    companion object {
//        @Volatile
//        private var INSTANCE: MovieDatabase? = null
//
//        fun getDatabase(context: Context): MovieDatabase {
//            return INSTANCE ?: synchronized(this) {
//                val instance = Room.databaseBuilder(
//                    context.applicationContext,
//                    MovieDatabase::class.java,
//                    "movie_database"
//                )
//                    .addCallback(MovieDatabaseCallback(context))
//                    .build()
//                INSTANCE = instance
//                instance
//            }
//        }
//    }
//}