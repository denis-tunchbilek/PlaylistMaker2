package com.example.playlistmaker2

import android.icu.text.SimpleDateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import java.util.Locale

class SongViewHolder(parent: ViewGroup) :
    RecyclerView.ViewHolder(LayoutInflater.from(parent.context)
    .inflate(R.layout.song_inf, parent, false)) {
    private val songName: TextView = itemView.findViewById(R.id.songName)
    private val picture: ImageView = itemView.findViewById(R.id.songPicture)
    private val artistName: TextView = itemView.findViewById(R.id.artistName)
    private val songTime: TextView = itemView.findViewById(R.id.songTime)
    fun bind(item: Song) {
        songName.text = item.trackName
        artistName.text = item.artistName
        songTime.text = SimpleDateFormat("mm:ss", Locale.getDefault()).format(item.trackTime.toLong())
        Glide.with(itemView)
            .load(item.artworkUrl100)
            .placeholder(R.drawable.place_holder)
            .fitCenter()
            .transform(RoundedCorners(itemView.resources.getDimensionPixelSize(R.dimen.pictureSongRadius)))
            .into(picture)
    }
}