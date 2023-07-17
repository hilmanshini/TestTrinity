import java.util.Calendar
import java.util.Locale

object AppVersion {
	
	private const val MAJOR = 0
	private const val MINOR = 0
	private const val PATCH = 1
	
	val versionName: String
		get() = "$MAJOR.$MINOR.$PATCH"
	
	//for tesing purpose
	val buildVersionCode: Int
		get() {
			val calendar: Calendar = Calendar.getInstance(Locale.ENGLISH)
			val month = (calendar.get(Calendar.MONTH) + 1) * 1_000_000
			val day = calendar.get(Calendar.DAY_OF_MONTH) * 10_000
			val hour = calendar.get(Calendar.HOUR_OF_DAY) * 100
			val minute = calendar.get(Calendar.MINUTE)
			return month + day + hour + minute
		}
	
	fun releaseVersionCode(sdkVersion: Int): Int {
		val estimate = 2_000_000_000
		val sdk = sdkVersion * 1_000_000
		val major = MAJOR * 10_000
		val minor = MINOR * 100
		return estimate + sdk + major + minor + PATCH
	}
}