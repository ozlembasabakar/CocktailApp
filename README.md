# CocktailApp
This project was created with the goal of learning about architecture. Built entirely with Jetpack Compose and Kotlin. 🏗️

# Firebase

Using Firebase Crashlytics, Firebase Performance, and Firebase Cloud Messaging together helps develop high-quality, stable and performant application.

## 💥 Crashlytics  

**Crashlytics** is a tool that helps *find and fix app crashes and errors in real-time*. It provides detailed information about the crashes, such as the device model and OS version, and helps prioritize which issues to fix first based on their impact on users. 

## :rocket: Performance 

**Performance** is a tool that *helps measure and improve the speed and efficiency of the apps*.It allows to *monitor app performance in real-time*, create custom metrics, and track specific features or functions within the app. 

## :envelope_with_arrow: Cloud Messaging (Push Notifications) 

**Cloud Messaging** is a tool that allows to _send push notifications to the app users_. Push notifications are messages that pop up on a user's device, even when the app is not open. They can be used to inform users about new content, updates, promotions, and other important information.

Using **Cloud Messaging** can help improve user engagement by keeping users informed and engaged with the application. 

Steps:

**1.** Create a class that extends FirebaseMessagingService and override the onMessageReceived() method to handle incoming messages.
```
class FirebaseMessagingService : FirebaseMessagingService() {

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        // Handle incoming messages
    }
}
```

**2.** Register the FirebaseMessagingService in the AndroidManifest.xml file by adding the following code inside the <application> tag
```
<service
     android:name=".FirebaseMessagingService"
     android:directBootAware="true"
     android:exported="false">
     <intent-filter>
          <action android:name="com.google.firebase.MESSAGING_EVENT"/>
     </intent-filter>
</service>
  ```

