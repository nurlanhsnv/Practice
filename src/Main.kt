
fun main() {
    val purchasedTickets = mutableListOf<TicketPurchase>()
    while (true) {
        println("Welcome to the Ticket App!")
        println("Do you want to buy a Regular, VIP, or Student ticket?")
        println("Regular--> r")
        println("VIP--> v")
        println("Student--> s")
        val ticketType = readLine()
        if (ticketType == "r" || ticketType == "v" || ticketType == "s") {
            println("Select a movie:")
            TicketManager.movies.forEachIndexed { index, movie ->
                println("$index. $movie")
            }
            val movieIndex = readLine()?.toIntOrNull()
            if (movieIndex != null && movieIndex in 0 until TicketManager.movies.size) {
                println("Available time:")
                println("28.05.2024    6PM  ---> 1")
                val firsttime = "28.05.2024    6PM"
                println("29.05.2024    4PM  ---> 2")
                val secondtime = "29.05.2024    4PM"
                println("30.05.2024    8PM  ---> 3")
                val thirdtime = "30.05.2024    8PM"
                val showTime = readLine()
                var shtime = "date"
                if (showTime == "1") {
                    shtime = firsttime
                } else if (showTime == "2") {
                    shtime = secondtime
                } else if (showTime == "3") {
                    shtime = thirdtime
                } else {
                    println("Invalid show time, please select again.")
                    continue
                }
                val ticketPurchase = TicketManager.buyTicket(ticketType ?: "", movieIndex, shtime)
                if (ticketPurchase != null) {
                    println("Ticket Details:")
                    println(ticketPurchase.getTicketDetails())
                    ticketPurchase.ticket.printDetails()
                    println("Do you want to buy this ticket? (yes/no)")
                    val buyDecision = readLine()
                    if (buyDecision.equals("yes", ignoreCase = true)) {
                        purchasedTickets.add(ticketPurchase.copy(buyDecision = "yes"))
                        println("Ticket purchased successfully. Enjoy the movie!")
                        break
                    } else {
                        purchasedTickets.add(ticketPurchase.copy(buyDecision = "no"))
                        println("Ticket not purchased.")
                    }
                } else {
                    println("Invalid ticket type or movie selection.")
                }
            } else {
                println("Invalid movie selection, please choose a valid movie index.")
            }
        } else {
            println("Please choose r, v, or s")
        }
    }
}
