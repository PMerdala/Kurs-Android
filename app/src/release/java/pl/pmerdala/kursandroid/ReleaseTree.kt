package pl.pmerdala.kursandroid

import android.util.Log
import com.crashlytics.android.Crashlytics
import timber.log.Timber

class ReleaseTree : Timber.Tree() {

    companion object {
        private const val MAX_LOG_LENGTH = 4000
        private const val UNKNOWN_TAG = "UNKNOWN_TAG"
    }

    override fun isLoggable(tag: String?, priority: Int): Boolean =
        !(priority == Log.VERBOSE || priority == Log.DEBUG || priority == Log.INFO)

    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        if (!isLoggable(tag, priority)) {
            return
        }
        if (priority == Log.ERROR && t != null) {
            Crashlytics.logException(t)
        }
        if (message.length < MAX_LOG_LENGTH) {
            logTo(priority, tag, message)
            return
        }
        //Split by line, then ensure each line can fit into Log's maximum length.

        var i = 0
        val length = message.length
        while (i < length) {
            var newline = message.indexOf('\n', i)
            newline = if (newline != -1) newline else length
            do {
                val end = Math.min(newline, i + MAX_LOG_LENGTH)
                val part = message.substring(i, end)
                logTo(priority, tag, part)
                i = end
            } while (i < newline)
            i++
        }
    }

    private fun logTo(priority: Int, tag: String?, message: String) {
        logToLogcat(priority, tag, message)
        logToCrashlyics(priority, tag, message)
    }

    private fun logToLogcat(priority: Int, tag: String?, message: String) {
        if (priority == Log.ASSERT) {
            Log.wtf(tag ?: UNKNOWN_TAG, message)
        } else {
            Log.println(priority, tag ?: UNKNOWN_TAG, message)
        }
    }

    private fun logToCrashlyics(priority: Int, tag: String?, message: String) {
        if(priority == Log.ERROR){
            Crashlytics.log(priority,tag?: UNKNOWN_TAG,message)
        }
    }

}