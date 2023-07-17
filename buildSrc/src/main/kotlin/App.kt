import dependencies.*
import org.gradle.api.JavaVersion
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.api.invocation.Gradle

object App {
	const val namespace = "my.trinity.test"
	const val minSdk = 26
	const val targetSdk = 33
	const val compileSdk = 33
	
	fun appVersionCode(gradle: Gradle): Int {
		val isRelease = gradle.startParameter.taskRequests.toString()
			.contains("release", true)
		println("Check build type for version code isRelease = $isRelease")
		val versionCode = if (isRelease) AppVersion.releaseVersionCode(minSdk)
		else AppVersion.buildVersionCode
		println("Generated version code $versionCode")
		return versionCode
	}
	
	val versionName: String
		get() = AppVersion.versionName
	const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
	val javaVersion = JavaVersion.VERSION_17
	const val jvmTarget = "17"
}

fun DependencyHandler.appLibraries() {
	core()
	daggerHilt()
	mapStruct()
	viewModel()
	navGraph()
	widgets()
	paging()
	dataLib()
	di()
}

private fun DependencyHandler.dataLib() {
	room()
	retrofit()
	okhttp()
	moshi()
}

private fun DependencyHandler.di() {
	daggerHilt()
}

fun namespace(module: String) = "${App.namespace}.$module"