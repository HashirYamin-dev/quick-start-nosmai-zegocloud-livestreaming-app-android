package com.nosmai.quickstart.zegocloud

/**
 * All the keys this demo needs. Replace the values below with your own.
 *
 * - Nosmai license key: from your Nosmai dashboard. It is tied to the app's
 *   application ID, so `applicationId` in app/build.gradle.kts must match the one
 *   the key was created for.
 * - ZEGOCLOUD AppID / AppSign: from https://console.zegocloud.com (your project's
 *   "Basic Information"). The project must use AppSign authentication.
 * - Room ID: any name. The host and the audience must use the same one.
 */
object DemoConfig {
    const val NOSMAI_LICENSE_KEY = "YOUR_NOSMAI_LICENSE_KEY"
    const val ZEGO_APP_ID = 0L
    const val ZEGO_APP_SIGN = "YOUR_ZEGO_APP_SIGN"
    const val ZEGO_ROOM_ID = "demo-room"

    /** The host publishes one stream with this ID; the audience plays it. */
    const val STREAM_ID = ZEGO_ROOM_ID + "_host"

    /** Returns a human readable reason when a key is still missing, or null when all are set. */
    fun problem(): String? = when {
        NOSMAI_LICENSE_KEY.isBlank() || NOSMAI_LICENSE_KEY.startsWith("YOUR_") ->
            "Set NOSMAI_LICENSE_KEY in DemoConfig.kt."
        ZEGO_APP_ID == 0L -> "Set ZEGO_APP_ID in DemoConfig.kt."
        ZEGO_APP_SIGN.length != 64 -> "Set your 64-character ZEGO_APP_SIGN in DemoConfig.kt."
        ZEGO_ROOM_ID.isBlank() -> "Set ZEGO_ROOM_ID in DemoConfig.kt."
        else -> null
    }
}
