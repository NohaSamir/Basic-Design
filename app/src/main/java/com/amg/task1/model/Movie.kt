package com.amg.task1.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Movie(
    val poster: String,
    val title: String,
    val tagline: String,
    val backdrop: String,
    val story: String,
) : Parcelable


fun getDummyMoviesList1(): List<Movie> {
    return mutableListOf(
        Movie(
            "/iZf0KyrE25z1sage4SYFLCCrMi9.jpg",
            "1917",
            "Time is the enemy.",
            "/cqa3sa4c4jevgnEJwq3CMF8UfTG.jpg",
            "At the height of the First World War, two young British soldiers must cross enemy territory and deliver a message that will stop a deadly attack on hundreds of soldiers."
        ), // 530915
        Movie(
            "/9E2y5Q7WlCVNEhP5GiVTjhEhx1o.jpg",
            "It",
            "Your fears are unleashed.",
            "/tcheoA2nPATCm2vvXw2hVQoaEFD.jpg",
            "In a small town in Maine, seven children known as The Losers Club come face to face with life problems, bullies and a monster that takes the shape of a clown called Pennywise."
        ), // 346364
        Movie(
            "/udDclJoHjfjb8Ekgsd4FDteOkCU.jpg",
            "Joker",
            "Put on a happy face.",
            "/n6bUvigpRFqSwmPp1m2YADdbRBc.jpg",
            "During the 1980s, a failed stand-up comedian is driven insane and turns to a life of crime and chaos in Gotham City while becoming an infamous psychopathic crime figure."
        ) // 475557
    )
}

fun getDummyMoviesList2(): List<Movie> {
    return mutableListOf(
        Movie(
            "/c9XxwwhPHdaImA2f1WEfEsbhaFB.jpg",
            "Jurassic World: Fallen Kingdom",
            "The park is gone.",
            "/3s9O5af2xWKWR5JzP2iJZpZeQQg.jpg",
            "Three years after the demise of Jurassic World, a volcanic eruption threatens the remaining dinosaurs on the isla Nublar, so Claire Dearing, the former park manager, recruits Owen Grady to help prevent the extinction of the dinosaurs once again."
        ), // 351286
        Movie(
            "/xRWht48C2V8XNfzvPehyClOvDni.jpg",
            "Alita: Battle Angel",
            "An angel falls. A warrior rises.",
            "/8RKBHHRqOMOLh5qW3sS6TSFTd8h.jpg",
            "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past."
        ), // 399579
        Movie(
            "/q719jXXEzOoYaps6babgKnONONX.jpg",
            "Your Name.",
            "When a connection forms.",
            "/mMtUybQ6hL24FXo0F3Z4j2KG7kZ.jpg",
            "High schoolers Mitsuha and Taki are complete strangers living separate lives. But one night, they suddenly switch places. Mitsuha wakes up in Taki’s body, and he in hers. This bizarre occurrence continues to happen randomly, and the two must adjust their lives around each other."
        )// 372058
    )
}