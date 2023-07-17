import org.gradle.api.Project

object AppSignIn {
    object Debug {
        val storeFile = "src/debug/signin.keystore"
        val storePassword = "afxtimesheet"
        val keyAlias = "androiddebugkey"
        val keyPassword = "afxtimesheet"
    }
    object Release {
        val storeFile = "src/release/signin.keystore"
        val storePassword = "afxtimesheet"
        val keyAlias = "androidreleasekey"
        val keyPassword = "afxtimesheet"
    }
}