import org.junit.jupiter.api.Test
import org.skrause.returnString

class AppTest {
    @Test
    fun checkIfPlaygroundIsWorking(){
        // Act
        val sut = returnString()

        // Assert
        assert(sut.contains("working"))
        assert(sut.contains("Playground"))
        assert(sut.contains("success"))
    }
}