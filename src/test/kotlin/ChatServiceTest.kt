import org.junit.Assert.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import kotlin.test.Test

class ChatServiceTest {

    @Test
    fun addUserToData() {
        val nick2 = User(
            id = 2,
            nickName = "nick2",
            emptyList(),
            emptyList()
        )
        val chatService = ChatService()

        val result = chatService.addUserToData(nick2)

        assertTrue(result)
    }

    @Test
    fun addUserToData_False() {

        val nick2 = User(
            id = 2,
            nickName = "nick2",
            emptyList(),
            emptyList()
        )
        val nick3 = User(
            id = 2,
            nickName = "nick2",
            emptyList(),
            emptyList()
        )
        val chatService = ChatService()

        chatService.addUserToData(nick2)
        val result = chatService.addUserToData(nick3)

        assertFalse(result)
    }

    @Test
    fun addMessage() {
        val time: LocalDateTime = LocalDateTime.now()
        val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("DD-MM-YYYY HH:MM:SS")
        val formatted: String = time.format(formatter)
        val chatService = ChatService()
        val nick1 = User(
            id = 1,
            nickName = "nick1",
            emptyList(),
            emptyList()
        )
        val nick2 = User(
            id = 2,
            nickName = "nick2",
            emptyList(),
            emptyList()
        )
        val message1 = Message(
            dateTime = formatted,
            text = "first",
            senderId = 1,
            recipientId = 2
        )

        chatService.addUserToData(nick1)
        chatService.addUserToData(nick2)
        val result = chatService.addMessage(message1)

        assertEquals(result, 1)
    }

    @Test
    fun addMessage_SecondChat() {
        val time: LocalDateTime = LocalDateTime.now()
        val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("DD-MM-YYYY HH:MM:SS")
        val formatted: String = time.format(formatter)
        val chatService = ChatService()
        val nick1 = User(
            id = 1,
            nickName = "nick1",
            emptyList(),
            emptyList()
        )
        val nick2 = User(
            id = 2,
            nickName = "nick2",
            emptyList(),
            emptyList()
        )
        val nick3 = User(
            id = 3,
            nickName = "nick3",
            emptyList(),
            emptyList()
        )
        val message1 = Message(
            dateTime = formatted,
            text = "first",
            senderId = 1,
            recipientId = 2
        )
        val message3 = Message(
            dateTime = formatted,
            text = "third",
            senderId = 1,
            recipientId = 3
        )

        chatService.addUserToData(nick1)
        chatService.addUserToData(nick2)
        chatService.addUserToData(nick3)
        chatService.addMessage(message1)
        val result = chatService.addMessage(message3)

        assertEquals(result, 2)
    }

    @Test
    fun deleteMessage_True() {

        val time: LocalDateTime = LocalDateTime.now()
        val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")
        val formatted: String = time.format(formatter)
        val chatService = ChatService()
        val nick1 = User(
            id = 1,
            nickName = "nick1",
            emptyList(),
            emptyList()
        )
        val nick2 = User(
            id = 2,
            nickName = "nick2",
            emptyList(),
            emptyList()
        )
        val message1 = Message(
            id = 1,
            dateTime = formatted,
            text = "first",
            senderId = 1,
            recipientId = 2
        )

        chatService.addUserToData(nick1)
        chatService.addUserToData(nick2)
        chatService.addMessage(message1)
        val result = chatService.deleteMessage(1)

        assertTrue(result)
    }

    @Test
    fun deleteMessage_False() {
        val time: LocalDateTime = LocalDateTime.now()
        val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")
        val formatted: String = time.format(formatter)
        val chatService = ChatService()
        val nick1 = User(
            id = 1,
            nickName = "nick1",
            emptyList(),
            emptyList()
        )
        val nick2 = User(
            id = 2,
            nickName = "nick2",
            emptyList(),
            emptyList()
        )
        val message1 = Message(
            id = 1,
            dateTime = formatted,
            text = "first",
            senderId = 1,
            recipientId = 2
        )

        chatService.addUserToData(nick1)
        chatService.addUserToData(nick2)
        chatService.addMessage(message1)
        val result = chatService.deleteMessage(5)

        assertFalse(result)
    }

    @Test
    fun deleteChatById_True() {
        val time: LocalDateTime = LocalDateTime.now()
        val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")
        val formatted: String = time.format(formatter)
        val chatService = ChatService()
        val nick1 = User(
            id = 1,
            nickName = "nick1",
            emptyList(),
            emptyList()
        )
        val nick2 = User(
            id = 2,
            nickName = "nick2",
            emptyList(),
            emptyList()
        )
        val message1 = Message(
            dateTime = formatted,
            text = "first",
            senderId = 1,
            recipientId = 2
        )

        chatService.addUserToData(nick1)
        chatService.addUserToData(nick2)
        chatService.addMessage(message1)
        val chatKey = listOf(1, 2)
        val result = chatService.deleteChatById(chatKey)

        assertTrue(result)
    }

    @Test
    fun deleteChatById_False() {
        val time: LocalDateTime = LocalDateTime.now()
        val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("DD-MM-YYYY HH:MM:SS")
        val formatted: String = time.format(formatter)
        val chatService = ChatService()
        val nick1 = User(
            id = 1,
            nickName = "nick1",
            emptyList(),
            emptyList()
        )
        val nick2 = User(
            id = 2,
            nickName = "nick2",
            emptyList(),
            emptyList()
        )
        val message1 = Message(
            dateTime = formatted,
            text = "first",
            senderId = 1,
            recipientId = 2
        )

        chatService.addUserToData(nick1)
        chatService.addUserToData(nick2)
        chatService.addMessage(message1)
        val chatKey = listOf(5, 2)
        val result = chatService.deleteChatById(chatKey)

        assertFalse(result)
    }

    @Test
    fun editingMessage_True() {
        val time: LocalDateTime = LocalDateTime.now()
        val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("DD-MM-YYYY HH:MM:SS")
        val formatted: String = time.format(formatter)
        val chatService = ChatService()
        val nick1 = User(
            id = 1,
            nickName = "nick1",
            emptyList(),
            emptyList()
        )
        val nick2 = User(
            id = 2,
            nickName = "nick2",
            emptyList(),
            emptyList()
        )
        val message1 = Message(
            dateTime = formatted,
            text = "first",
            senderId = 1,
            recipientId = 2
        )
        val updatedMessage = Message(
            id = 1,
            dateTime = formatted,
            text = "Updated",
            senderId = 1,
            recipientId = 2
        )

        chatService.addUserToData(nick1)
        chatService.addUserToData(nick2)
        chatService.addMessage(message1)
        val result = chatService.editingMessage(updatedMessage)

        assertTrue(result)
    }

    @Test
    fun editingMessage_False() {
        val time: LocalDateTime = LocalDateTime.now()
        val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("DD-MM-YYYY HH:MM:SS")
        val formatted: String = time.format(formatter)
        val chatService = ChatService()
        val nick1 = User(
            id = 1,
            nickName = "nick1",
            emptyList(),
            emptyList()
        )
        val nick2 = User(
            id = 2,
            nickName = "nick2",
            emptyList(),
            emptyList()
        )
        val message1 = Message(
            dateTime = formatted,
            text = "first",
            senderId = 1,
            recipientId = 2
        )
        val updatedMessage = Message(
            id = 5,
            dateTime = formatted,
            text = "Updated",
            senderId = 1,
            recipientId = 2
        )

        chatService.addUserToData(nick1)
        chatService.addUserToData(nick2)
        chatService.addMessage(message1)
        val result = chatService.editingMessage(updatedMessage)

        assertFalse(result)
    }

    @Test
    fun getChatList() {
        val time: LocalDateTime = LocalDateTime.now()
        val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("DD-MM-YYYY HH:MM:SS")
        val formatted: String = time.format(formatter)
        val chatService = ChatService()
        val nick1 = User(
            id = 1,
            nickName = "nick1",
            emptyList(),
            emptyList()
        )
        val nick2 = User(
            id = 2,
            nickName = "nick2",
            emptyList(),
            emptyList()
        )
        val message1 = Message(
            id = 1,
            dateTime = formatted,
            text = "first",
            senderId = 1,
            recipientId = 2
        )

        chatService.addUserToData(nick1)
        chatService.addUserToData(nick2)
        chatService.addMessage(message1)
        val result = chatService.getChatList()

        assertEquals(result, mutableMapOf(Pair((1), mutableListOf(message1))))
    }

    @Test
    fun getMessagesFromChat() {
        val time: LocalDateTime = LocalDateTime.now()
        val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("DD-MM-YYYY HH:MM:SS")
        val formatted: String = time.format(formatter)
        val chatService = ChatService()
        val nick1 = User(
            id = 1,
            nickName = "nick1",
            emptyList(),
            emptyList()
        )
        val nick2 = User(
            id = 2,
            nickName = "nick2",
            emptyList(),
            emptyList()
        )
        val message1 = Message(
            id = 1,
            dateTime = formatted,
            text = "first",
            senderId = 1,
            recipientId = 2
        )

        chatService.addUserToData(nick1)
        chatService.addUserToData(nick2)
        chatService.addMessage(message1)
        val result = chatService.getMessagesFromChat(listOf(1, 2), 1, 1)

        assertEquals(result, listOf(message1))
    }

    @Test
    fun getUnreadChats() {
        val time: LocalDateTime = LocalDateTime.now()
        val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("DD-MM-YYYY HH:MM:SS")
        val formatted: String = time.format(formatter)
        val chatService = ChatService()
        val nick1 = User(
            id = 1,
            nickName = "nick1",
            emptyList(),
            emptyList()
        )
        val nick3 = User(
            id = 3,
            nickName = "nick3",
            emptyList(),
            emptyList()
        )
        val message8 = Message(
            dateTime = formatted,
            text = "eighth",
            senderId = 2,
            recipientId = 3
        )

        // act
        chatService.addUserToData(nick1)
        chatService.addUserToData(nick3)
        chatService.addMessage(message8)
        val result = chatService.getUnreadChats(3)

        assertTrue(result.size == 1)
    }
}