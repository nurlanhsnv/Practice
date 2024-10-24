data class TicketPurchase(val ticket: Ticket, val buyDecision: String) {
    fun getTicketDetails(): String {
        return ticket.toString()
    }
}