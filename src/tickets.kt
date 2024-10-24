abstract class Ticket(private val movieName: String, private val showTime: String, private val price: Double) {
    abstract fun printDetails()

    fun getMovieName(): String {
        return movieName
    }

    fun getShowTime(): String {
        return showTime
    }

    fun getPrice(): Double {
        return price
    }
}
class RegularTicket(movieName: String, showTime: String) : Ticket(movieName, showTime, 10.0), TicketType {
    override val type: String = "Regular"

    override fun printDetails() {
        println("Movie: ${getMovieName()}, Show Time: ${getShowTime()}, Type: $type, Price: ${getPrice()}$")
    }
}

class VIPTicket(movieName: String, showTime: String) : Ticket(movieName, showTime, 20.0), TicketType {
    override val type: String = "VIP"

    override fun printDetails() {
        println("Movie: ${getMovieName()}, Show Time: ${getShowTime()}, Type: $type, Price: ${getPrice()}$")
    }
}

class StudentTicket(movieName: String, showTime: String) : Ticket(movieName, showTime, 8.0), TicketType {
    override val type: String = "Student"

    override fun printDetails() {
        println("Movie: ${getMovieName()}, Show Time: ${getShowTime()}, Type: $type, Price: ${getPrice()}$")
    }
}

class TicketManager {
    companion object {
        val movies: List<String> = listOf(
            "Kung fu Panda 4",
            "The silent voice",
            "Demon slayer : Mugen train",
            "Your name"
        )

        fun buyTicket(ticketType: String, movieIndex: Int, showTime: String): TicketPurchase? {
            val selectedMovie = movies.getOrNull(movieIndex)
            return when (ticketType.toLowerCase()) {
                "r" -> selectedMovie?.let { TicketPurchase(RegularTicket(it, showTime), "") }
                "v" -> selectedMovie?.let { TicketPurchase(VIPTicket(it, showTime), "") }
                "s" -> selectedMovie?.let { TicketPurchase(StudentTicket(it, showTime), "") }
                else -> null
            }
        }
    }
}







