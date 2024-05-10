# Threads
## Overview:
This Java program demonstrates the usage of synchronization to control access to shared resources among multiple threads. It consists of two classes: Synch and CallMe, which illustrate the synchronization mechanism in a multithreaded environment.

### Components:
- Synch Class:
The main method resides in this class, which initializes instances of the Caller class and starts their threads.
It also handles thread synchronization using the join method to ensure the completion of all threads before exiting.
- Caller Class:
This class implements the Runnable interface and represents the callers that invoke the call method of the CallMe class.
Each Caller instance is associated with a specific message (msg) and the CallMe object it invokes.
Threads for each caller are created and started within this class.
- CallMe Class:
This class defines the method call, which is invoked by the callers (Caller instances).
The call method is synchronized, ensuring that only one thread can execute it at a time. This prevents concurrent access and potential data corruption.
