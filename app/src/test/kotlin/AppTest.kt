import org.junit.jupiter.api.Test
import org.skrause.returnAString

class AppTest {
    @Test
    fun checkIfPlaygroundIsWorking(){
        // Act
        val sut = returnAString()

        // Assert
        assert(sut.contains("working"))
        assert(sut.contains("Playground"))
        assert(sut.contains("success"))
    }
}