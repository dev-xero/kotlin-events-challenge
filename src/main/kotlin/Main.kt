enum class DayPart {
    Morning,
    Afternoon,
    Evening
}

data class Event (
    val title: String,
    val description: String? = null,  // the '?' in T? indicates that it could be null
    val daypart: DayPart,
    val duration: Int
)

val Event.durationOfEvent: String
    get() = if (duration < 60) "short" else "long"

fun main() {
    val events = mutableListOf<Event>(
        Event(
            title = "Eat breakfast",
            description = "Eat something",
            daypart = DayPart.Morning,
            duration = 15
        ),

        Event(
            title = "Study Kotlin",
            description = "Commit to studying Kotlin at least 30 minutes a day",
            daypart = DayPart.Evening,
            duration = 30
        ),

        Event(
            title = "Watch latest DevBytes video",
            description = "",
            daypart = DayPart.Afternoon,
            duration = 10
        )
    )

    val shortEvents = events.filter {
        it.duration < 60
    }.size

    val eventSummary = events.groupBy {
        it.daypart
    }

    val lastEvent = events.last().title

    events.forEach {
        println("EVENT: ${it.title} — Duration: ${it.duration} • Daypart: ${it.daypart.toString()}")
    }

    println("\nYou have $shortEvents short events")

    println("\nYour Event Summary")
    eventSummary.forEach {(daypart, events) ->
        println("$daypart: ${events.size}")
    }

    println("\nYour Last Event")
    println(lastEvent)

    println("\nDuration of the Last Event")
    println(events.last().durationOfEvent)
}