The ManCityActivityApp is a 4 activity application that parses data from an xml and populates textViews and imageViews across all the activities.

The first Activity is a RecycleView with a custom row layout activity that is set via an adapter
On the first page , the user can scroll and click on each player's image and that will load the second activity.

The second Activity is called activity_player and it is a FrameLayout that lets the data that is deserialized from the first activity
to be displayed on top of an image that is given a certain opacity to allow the text to have a better contrast.

The third Activity is loaded when the user clicks on the details button on the second activity.The activity functions in a similar way
to the previous activity,but instead of actually displaying an image , the image is only given a light blue background.

The fourth Activity is a WebView component that displays a web page according to the the url that is deserialized from the third activity.

Technical contributions:
- I used a SparseArray instead of declaring 7-8 textView objects in the player_activity,because wanted to use their object integer key to store them in memory.
A SparseArray is a specialized container class in Java that is designed to be more memory-efficient than a regular HashMap when dealing with integer keys.

In a SparseArray, the keys are always integers, and the values can be any Java object. It works by storing only the indexes and values that are actually present in the array,
rather than allocating memory for every possible index,which can be wasteful if the array is sparse.


Design constributions:
-I used a FrameLayout that allowed me to add text on top of an image in the player_activity.
-I also added a background color to each player imageView to give the application a nicer contrast.This was achieved by downloading webp files 
and converting them to either jpg/png format.

FrameLayout is a layout manager in Java that positions its child views at the top-left corner of its container.
Each child view is placed on top of the previous child view by default, giving the impression of a stack of views.