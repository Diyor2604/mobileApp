import com.example.myapp.utils.CredentialsManager
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class CredentialsManagerTest {

    @Test
    fun testRegisterNewAccount() {
        val email = "new@te.st"
        val password = "password123"

        val result = CredentialsManager.registerU(email, password)
        assertTrue(result)
    }

    @Test
    fun testRegisterExistingAccount() {
        val email = "test@te.st"
        val password = "1234"

        val result = CredentialsManager.registerU(email, password)
        assertFalse(result)
    }
    @Test
    fun existing_email() {
        CredentialsManager.registerU("existing@user.com", "password123")
        val result = CredentialsManager.registerU("existing@user.com", "anotherPassword")
        assertFalse(result)
    }
    fun successfullReg() {
        CredentialsManager.registerU("test@user.com", "securePass")
        assertTrue(CredentialsManager.validateCredentials("test@user.com", "securePass"))
    }

}
