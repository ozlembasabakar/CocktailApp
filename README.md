# CocktailApp
This project was created with the goal of learning about architecture. Built entirely with Jetpack Compose and Kotlin. 🏗️

## Architecture

### 🎨 UI

The **UI layer**, also known as the *presentation layer*, is the top layer in the Android application architecture that handles the user interface of an app. It consists of views and other UI components that display the data and interact with the user.

The UI layer also has a *crucial role in communicating with the other layers of the Android architecture*. It receives data from the domain layer and formats it for display in the user interface, and sends user input and interactions back to the domain layer for processing.

In Android application architecture, a ViewModel is a class that stores and manages UI-related data in a lifecycle-conscious way. It acts as a *state holder for the UI data*, such as data that needs to be displayed on the screen or data that the user has inputted and survives configuration changes, such as screen rotations that can cause the activity or fragment to be destroyed and recreated.

The *importance of ViewModel as a state holder* in Android application architecture is that it allows for **separation of concerns** and better organization of code. By separating UI-related data and business logic from the UI layer and managing them in a separate ViewModel class, the code becomes more modular and easier to test.

The following happens in this layer:

In the UI layer, the **HomeScreen** is *responsible for displaying the data to the user*. The **HomeScreenViewModel** *serves as the mediator* between the **HomeScreen and the Domain and Data layers**. It holds the **HomeScreenViewState** which *represents the current state of the UI*.

When the user interacts with the **HomeScreen**, the **HomeScreenViewModel** receives this interaction and communicates with the Domain Layer. 

The **HomeScreenViewModel** receives data and updates the **HomeScreenViewState** accordingly. 

Finally, the **HomeScreen** observes the **HomeScreenViewState** and updates the UI to display the fetched data to the user.

![UILayer](https://user-images.githubusercontent.com/53402156/233972032-4789c212-da23-41fd-9569-9672359ad542.png)

### 🧠 Domain

The **Domain Layer** is an essential part of the Android application architecture, which *represents the business logic* of the application. The Domain Layer contains the use cases or business logic that is used to manipulate the data in the application. It *acts as a mediator between the UI and the Data layer* and ensures that the application's business rules and policies are correctly enforced.

The importance of the Domain Layer lies in its ability to decouple the business logic from the rest of the application, making it easy to maintain and test. 

The following happens in this layer:

In the MVVM architecture of an Android application, the Domain Layer is responsible for business logic and use cases. In this case, we have the **GetRandomCocktailUseCase** which is *responsible for retrieving a random cocktail*. This class is part of the Domain Layer.

The **GetRandomCocktailUseCase** interacts with the Data Layer to retrieve the cocktail data. 

Once the **GetRandomCocktailUseCase** successfully retrieves the cocktail data from Data Layer, it returns it to the **HomeScreenViewModel**. The **HomeScreenViewModel** then processes the data and exposes it to the **HomeScreen via the HomeScreenViewState**.

![DomainLayer](https://user-images.githubusercontent.com/53402156/233972028-2e41ba56-94b1-497d-a627-29fab78b4fb4.png)

### 📈 Data

The **Data Layer** in Android application architecture is responsible for *managing the data of the application*. It consists of *data sources* and *repositories*, which are used to fetch, store, and manage the data used by the application.

The importance of the **Data Layer** lies in the fact that it *provides a centralized and consistent way of managing the data* used by the application. By separating the Data Layer from the other layers of the application, it allows for easier testing, maintenance, and scalability of the application.

**Data sources** in the data layer can be of two types: *local* and *remote*. Local data sources typically include databases, shared preferences, and files, while remote data sources include APIs, web services, and cloud-based storage. The data layer uses these sources to fetch data and provides them to the upper layers of the application.

**Repositories** are the *bridge between the data sources and the upper layers of the application*. They provide a single point of entry for the application to access the data layer. The repositories handle the logic of fetching and storing data from the data sources and provide a clean interface to the upper layers of the application.

The following happens in this layer:

The **CocktailLocalDataSource** and **CocktailRemoteDataSource** are responsible for *saving and fetching data* from the local and remote data sources respectively. The **CocktailRepository** acts as a *bridge between the data sources and the Domain Layer*.

When the **GetRandomCocktailUseCase** is executed, it requests the data from the **CocktailRepository**. The **CocktailRepository** first fetches data from the remote data source. After successfully fetching the data, saves it to the database.

Then, the **GetRandomCocktailUseCas**e receives the data from the repository and processes it according to the business logic of the use case. Finally, the processed data is sent to the **UI Layer**, and the UI is updated accordingly.

![DataLayer](https://user-images.githubusercontent.com/53402156/233972023-09761613-081c-4a12-a394-be62ed4e1cbd.png)

## Firebase

Using Firebase Crashlytics, Firebase Performance, and Firebase Cloud Messaging together helps develop high-quality, stable and performant application.

### 💥 Crashlytics  

**Crashlytics** is a tool that helps *find and fix app crashes and errors in real-time*. It provides detailed information about the crashes, such as the device model and OS version, and helps prioritize which issues to fix first based on their impact on users. 

### :rocket: Performance 

**Performance** is a tool that *helps measure and improve the speed and efficiency of the apps*.It allows to *monitor app performance in real-time*, create custom metrics, and track specific features or functions within the app. 

### :envelope_with_arrow: Cloud Messaging (Push Notifications) 

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
    
## Screenshots
    
**Debug mode:**

![applogo_debug](https://user-images.githubusercontent.com/53402156/233143955-19dc470d-7ba1-482d-b018-21025e888f84.png)

![CocktailAppMainScreen_debug](https://user-images.githubusercontent.com/53402156/233143254-6dc182dc-b6fb-4f38-9828-c76c699e6bf1.png)
![CocktailAppDetailScreen_debug](https://user-images.githubusercontent.com/53402156/233143260-82f32c3a-6ea5-4af9-93d9-5728ce6ff9a7.png)

**Release mode:**

![applogo_release](https://user-images.githubusercontent.com/53402156/233143949-3221feeb-65b3-4092-b8eb-0e32c91e6724.png)

![CocktailAppMainScreen_release](https://user-images.githubusercontent.com/53402156/233143263-a4910dd3-7042-48ad-91aa-40b7c45901f5.png)
![CocktailAppDetailScreen_release](https://user-images.githubusercontent.com/53402156/233143265-8caa9f8f-1645-46eb-affc-3fe284a71468.png)

