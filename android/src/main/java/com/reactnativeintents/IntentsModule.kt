package com.reactnativeintents

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import com.facebook.react.bridge.Promise
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import com.facebook.react.bridge.WritableMap
import com.facebook.react.bridge.Arguments


class IntentsModule(reactContext: ReactApplicationContext) : ReactContextBaseJavaModule(reactContext) {

  override fun getName(): String {
      return "Intents"
  }

  // Example method
  // See https://facebook.github.io/react-native/docs/native-modules-android
  @ReactMethod
  fun getExtras(promise: Promise) {
    try {
      val intent: Intent = reactApplicationContext.currentActivity!!.intent
      val extras: Bundle? = intent.extras
      val map: WritableMap = Arguments.fromBundle(extras)
      promise.resolve(map)
    } catch (e: java.lang.Exception) {
      promise.reject("E_INTENT_ERROR", "No intent extras specified.")
    }
  }

  @ReactMethod
  fun send(app: String, promise: Promise) {
    try {
      val activity: Activity? = reactApplicationContext.currentActivity
      val pm: PackageManager = reactApplicationContext.packageManager;
      val intent = pm.getLaunchIntentForPackage(app)
      activity?.startActivity(intent)
      promise.resolve(true);
    } catch (e: java.lang.Exception) {
      promise.reject("E_INTENT_ERROR", "No app found to handle intent.")
    }
  }

}
