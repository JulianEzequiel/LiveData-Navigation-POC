# LiveData-Navigation-POC
Proof of Concept of Navigation with ViewModel and LiveData in an Android App.

# Introduction
The first approach was to navigate throw the App with Interfaces. These interfaces were implemented by Activities or Fragments, depending on the situation. It seems nice, but then we encounter a Problem: App killed by OS.
When the App is killed by the OS, the references/dependencies are lost and need to be re-injected. To do this, you have to override onAttach or onAttachFragment events and inject them manually. But, what happen if you forgot to override those methods? Well, crashes. We need a solution that fixes this problem and, at the same time, force the developers to handle this situations.

# Proposal
We come to this solution, where those interfaces are migrated to ViewModel's and LiveData's (using SingleLiveEvent) to represent the Navigation-Events. Doing this, we delegate the storage and supply of dependencies to the ViewModel API. This is not the best solution, but it's a solution that works.
