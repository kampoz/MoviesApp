package com.kamil.moviesapp.data.repository

import com.google.gson.Gson
import com.kamil.moviesapp.data.network.response.ApiResponse
import com.kamil.moviesapp.data.network.response.Category
import com.kamil.moviesapp.data.network.response.VideoItem
import com.kamil.moviesapp.model.RecyclerData

private const val BASE_IMAGE_URL = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/"

class MoviesRepository {

    fun getMovies() : ArrayList<RecyclerData>{
        val gson = Gson()
        val response = gson.fromJson(mediaJson, ApiResponse::class.java)

        val category: Category = response.categories[0]
        val videos: ArrayList<VideoItem> = category.videos

        return getRecyclerDaoList(videos, category)
    }

    // for tests those functions should be public of course
    private fun videoToDao(videoItem: VideoItem, category: Category): RecyclerData {
        return RecyclerData(
            title = videoItem.title,
            category = category.name,
            thumb = BASE_IMAGE_URL + videoItem.thumb
        )
    }

    private fun getRecyclerDaoList(videoItems: ArrayList<VideoItem>, category: Category): ArrayList<RecyclerData> {
        val recyclerItems = ArrayList<RecyclerData>()
        for (video in videoItems) {
            recyclerItems.add(videoToDao(video, category))
        }
        return recyclerItems
    }

    private var mediaJson : String  = "{ \"categories\" : [ { \"name\" : \"Movies\",\n" +
            "        \"videos\" : [\n" +
            "        { \"description\" : \"Big Buck Bunny tells the story of a giant rabbit with a heart bigger than himself. When one sunny day three rodents rudely harass him, something snaps... and the rabbit ain't no bunny anymore! In the typical cartoon tradition he prepares the nasty rodents a comical revenge.\\n\\nLicensed under the Creative Commons Attribution license\\nhttp://www.bigbuckbunny.org\",\n" +
            "            \"sources\" : [ \"http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4\" ],\n" +
            "            \"subtitle\" : \"By Blender Foundation\",\n" +
            "            \"thumb\" : \"images/BigBuckBunny.jpg\",\n" +
            "            \"title\" : \"Big Buck Bunny\"\n" +
            "        },\n" +
            "        { \"description\" : \"The first Blender Open Movie from 2006\",\n" +
            "            \"sources\" : [ \"http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4\" ],\n" +
            "            \"subtitle\" : \"By Blender Foundation\",\n" +
            "            \"thumb\" : \"images/ElephantsDream.jpg\",\n" +
            "            \"title\" : \"Elephant Dream\"\n" +
            "        },\n" +
            "        { \"description\" : \"HBO GO now works with Chromecast -- the easiest way to enjoy online video on your TV. For when you want to settle into your Iron Throne to watch the latest episodes. For \$35.\\nLearn how to use Chromecast with HBO GO and more at google.com/chromecast.\",\n" +
            "            \"sources\" : [ \"http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4\" ],\n" +
            "            \"subtitle\" : \"By Google\",\n" +
            "            \"thumb\" : \"images/ForBiggerBlazes.jpg\",\n" +
            "            \"title\" : \"For Bigger Blazes\"\n" +
            "        },\n" +
            "        { \"description\" : \"Introducing Chromecast. The easiest way to enjoy online video and music on your TV—for when Batman's escapes aren't quite big enough. For \$35. Learn how to use Chromecast with Google Play Movies and more at google.com/chromecast.\",\n" +
            "            \"sources\" : [ \"http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerEscapes.mp4\" ],\n" +
            "            \"subtitle\" : \"By Google\",\n" +
            "            \"thumb\" : \"images/ForBiggerEscapes.jpg\",\n" +
            "            \"title\" : \"For Bigger Escape\"\n" +
            "        },\n" +
            "        { \"description\" : \"Introducing Chromecast. The easiest way to enjoy online video and music on your TV. For \$35.  Find out more at google.com/chromecast.\",\n" +
            "            \"sources\" : [ \"http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerFun.mp4\" ],\n" +
            "            \"subtitle\" : \"By Google\",\n" +
            "            \"thumb\" : \"images/ForBiggerFun.jpg\",\n" +
            "            \"title\" : \"For Bigger Fun\"\n" +
            "        },\n" +
            "        { \"description\" : \"Introducing Chromecast. The easiest way to enjoy online video and music on your TV—for the times that call for bigger joyrides. For \$35. Learn how to use Chromecast with YouTube and more at google.com/chromecast.\",\n" +
            "            \"sources\" : [ \"http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerJoyrides.mp4\" ],\n" +
            "            \"subtitle\" : \"By Google\",\n" +
            "            \"thumb\" : \"images/ForBiggerJoyrides.jpg\",\n" +
            "            \"title\" : \"For Bigger Joyrides\"\n" +
            "        },\n" +
            "        { \"description\" :\"Introducing Chromecast. The easiest way to enjoy online video and music on your TV—for when you want to make Buster's big meltdowns even bigger. For \$35. Learn how to use Chromecast with Netflix and more at google.com/chromecast.\",\n" +
            "            \"sources\" : [ \"http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerMeltdowns.mp4\" ],\n" +
            "            \"subtitle\" : \"By Google\",\n" +
            "            \"thumb\" : \"images/ForBiggerMeltdowns.jpg\",\n" +
            "            \"title\" : \"For Bigger Meltdowns\"\n" +
            "        },\n" +
            "        { \"description\" : \"Sintel is an independently produced short film, initiated by the Blender Foundation as a means to further improve and validate the free/open source 3D creation suite Blender. With initial funding provided by 1000s of donations via the internet community, it has again proven to be a viable development model for both open 3D technology as for independent animation film.\\nThis 15 minute film has been realized in the studio of the Amsterdam Blender Institute, by an international team of artists and developers. In addition to that, several crucial technical and creative targets have been realized online, by developers and artists and teams all over the world.\\nwww.sintel.org\",\n" +
            "            \"sources\" : [ \"http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/Sintel.mp4\" ],\n" +
            "            \"subtitle\" : \"By Blender Foundation\",\n" +
            "            \"thumb\" : \"images/Sintel.jpg\",\n" +
            "            \"title\" : \"Sintel\"\n" +
            "        },\n" +
            "        { \"description\" : \"Smoking Tire takes the all-new Subaru Outback to the highest point we can find in hopes our customer-appreciation Balloon Launch will get some free T-shirts into the hands of our viewers.\",\n" +
            "            \"sources\" : [ \"http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/SubaruOutbackOnStreetAndDirt.mp4\" ],\n" +
            "            \"subtitle\" : \"By Garage419\",\n" +
            "            \"thumb\" : \"images/SubaruOutbackOnStreetAndDirt.jpg\",\n" +
            "            \"title\" : \"Subaru Outback On Street And Dirt\"\n" +
            "        },\n" +
            "        { \"description\" : \"Tears of Steel was realized with crowd-funding by users of the open source 3D creation tool Blender. Target was to improve and test a complete open and free pipeline for visual effects in film - and to make a compelling sci-fi film in Amsterdam, the Netherlands.  The film itself, and all raw material used for making it, have been released under the Creatieve Commons 3.0 Attribution license. Visit the tearsofsteel.org website to find out more about this, or to purchase the 4-DVD box with a lot of extras.  (CC) Blender Foundation - http://www.tearsofsteel.org\",\n" +
            "            \"sources\" : [ \"http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/TearsOfSteel.mp4\" ],\n" +
            "            \"subtitle\" : \"By Blender Foundation\",\n" +
            "            \"thumb\" : \"images/TearsOfSteel.jpg\",\n" +
            "            \"title\" : \"Tears of Steel\"\n" +
            "        },\n" +
            "        { \"description\" : \"The Smoking Tire heads out to Adams Motorsports Park in Riverside, CA to test the most requested car of 2010, the Volkswagen GTI. Will it beat the Mazdaspeed3's standard-setting lap time? Watch and see...\",\n" +
            "            \"sources\" : [ \"http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/VolkswagenGTIReview.mp4\" ],\n" +
            "            \"subtitle\" : \"By Garage419\",\n" +
            "            \"thumb\" : \"images/VolkswagenGTIReview.jpg\",\n" +
            "            \"title\" : \"Volkswagen GTI Review\"\n" +
            "        },\n" +
            "        { \"description\" : \"The Smoking Tire is going on the 2010 Bullrun Live Rally in a 2011 Shelby GT500, and posting a video from the road every single day! The only place to watch them is by subscribing to The Smoking Tire or watching at BlackMagicShine.com\",\n" +
            "            \"sources\" : [ \"http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/WeAreGoingOnBullrun.mp4\" ],\n" +
            "            \"subtitle\" : \"By Garage419\",\n" +
            "            \"thumb\" : \"images/WeAreGoingOnBullrun.jpg\",\n" +
            "            \"title\" : \"We Are Going On Bullrun\"\n" +
            "        },\n" +
            "        { \"description\" : \"The Smoking Tire meets up with Chris and Jorge from CarsForAGrand.com to see just how far \$1,000 can go when looking for a car.The Smoking Tire meets up with Chris and Jorge from CarsForAGrand.com to see just how far \$1,000 can go when looking for a car.\",\n" +
            "            \"sources\" : [ \"http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/WhatCarCanYouGetForAGrand.mp4\" ],\n" +
            "            \"subtitle\" : \"By Garage419\",\n" +
            "            \"thumb\" : \"images/WhatCarCanYouGetForAGrand.jpg\",\n" +
            "            \"title\" : \"What care can you get for a grand?\"\n" +
            "        }\n" +
            "        ]}]}"
}