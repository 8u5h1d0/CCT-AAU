---
tags:
  - "#CCT2"
  - OO
  - Java
  - Programming
Topic: Data streams | Input and output streams | Designing and working with streams | Example cases with network sockets (UDP and TCP) | Events and event listeners
Semester: CCT2
Course: Objektorienteret analyse, design og implementering + Java
Litterature:
  - Oracle - Docs - IO
  - Tutorialspoint - Java Networking
  - Oracle - Docs - Events
  - Oracle - Docs - Events - Rules
Created: 18-03-2026
---
- - -
# Lesson: Basic I/O

This lesson covers the Java platform classes used for basic I/O. It first focuses on _I/O Streams_, a powerful concept that greatly simplifies I/O operations. The lesson also looks at serialization, which lets a program write whole objects out to streams and read them back again. Then the lesson looks at file I/O and file system operations, including random access files.

Most of the classes covered in the `I/O Streams` section are in the `java.io` package. Most of the classes covered in the `File I/O` section are in the `java.nio.file` package.

## [I/O Streams](https://docs.oracle.com/javase/tutorial/essential/io/streams.html)

- [Byte Streams](https://docs.oracle.com/javase/tutorial/essential/io/bytestreams.html) handle I/O of raw binary data.
- [Character Streams](https://docs.oracle.com/javase/tutorial/essential/io/charstreams.html) handle I/O of character data, automatically handling translation to and from the local character set.
- [Buffered Streams](https://docs.oracle.com/javase/tutorial/essential/io/buffers.html) optimize input and output by reducing the number of calls to the native API.
- [Scanning and Formatting](https://docs.oracle.com/javase/tutorial/essential/io/scanfor.html) allows a program to read and write formatted text.
- [I/O from the Command Line](https://docs.oracle.com/javase/tutorial/essential/io/cl.html) describes the Standard Streams and the Console object.
- [Data Streams](https://docs.oracle.com/javase/tutorial/essential/io/datastreams.html) handle binary I/O of primitive data type and `String` values.
- [Object Streams](https://docs.oracle.com/javase/tutorial/essential/io/objectstreams.html) handle binary I/O of objects.

## [File I/O (Featuring NIO.2)](https://docs.oracle.com/javase/tutorial/essential/io/fileio.html)

- [What is a Path?](https://docs.oracle.com/javase/tutorial/essential/io/path.html) examines the concept of a path on a file system.
- [The Path Class](https://docs.oracle.com/javase/tutorial/essential/io/pathClass.html) introduces the cornerstone class of the `java.nio.file` package.
- [Path Operations](https://docs.oracle.com/javase/tutorial/essential/io/pathOps.html) looks at methods in the `Path` class that deal with syntactic operations.
- [File Operations](https://docs.oracle.com/javase/tutorial/essential/io/fileOps.html) introduces concepts common to many of the file I/O methods.
- [Checking a File or Directory](https://docs.oracle.com/javase/tutorial/essential/io/check.html) shows how to check a file's existence and its level of accessibility.
- [Deleting a File or Directory](https://docs.oracle.com/javase/tutorial/essential/io/delete.html).
- [Copying a File or Directory](https://docs.oracle.com/javase/tutorial/essential/io/copy.html).
- [Moving a File or Directory](https://docs.oracle.com/javase/tutorial/essential/io/move.html).
- [Managing Metadata](https://docs.oracle.com/javase/tutorial/essential/io/fileAttr.html) explains how to read and set file attributes.
- [Reading, Writing and Creating Files](https://docs.oracle.com/javase/tutorial/essential/io/file.html) shows the stream and channel methods for reading and writing files.
- [Random Access Files](https://docs.oracle.com/javase/tutorial/essential/io/rafs.html) shows how to read or write files in a non-sequentially manner.
- [Creating and Reading Directories](https://docs.oracle.com/javase/tutorial/essential/io/dirs.html) covers API specific to directories, such as how to list a directory's contents.
- [Links, Symbolic or Otherwise](https://docs.oracle.com/javase/tutorial/essential/io/links.html) covers issues specific to symbolic and hard links.
- [Walking the File Tree](https://docs.oracle.com/javase/tutorial/essential/io/walk.html) demonstrates how to recursively visit each file and directory in a file tree.
- [Finding Files](https://docs.oracle.com/javase/tutorial/essential/io/find.html) shows how to search for files using pattern matching.
- [Watching a Directory for Changes](https://docs.oracle.com/javase/tutorial/essential/io/notification.html) shows how to use the watch service to detect files that are added, removed or updated in one or more directories.
- [Other Useful Methods](https://docs.oracle.com/javase/tutorial/essential/io/misc.html) covers important API that didn't fit elsewhere in the lesson.
- [Legacy File I/O Code](https://docs.oracle.com/javase/tutorial/essential/io/legacy.html) shows how to leverage `Path` functionality if you have older code using the `java.io.File` class. A table mapping `java.io.File` API to `java.nio.file` API is provided.

## [Summary](https://docs.oracle.com/javase/tutorial/essential/io/summary.html)

A summary of the key points covered in this trail.
# Java - Networking
## Java Networking

**Java networking** (or, **Java network programming**) refers to writing programs that execute across multiple devices (computers), in which the devices are all connected to each other using a network.

## Advantages of Java Networking

- Creating server-client applications
- Implementing networking protocols
- Implement socket programming
- Creating web services

## Package Used in Networking

The java.net package of the J2SE APIs contains a collection of classes and interfaces that provide the low-level communication details, allowing you to write programs that focus on solving the problem at hand.

The java.net package provides support for the two common network protocols −

- [**TCP**](https://www.tutorialspoint.com/data_communication_computer_network/transmission_control_protocol.htm) − TCP stands for Transmission Control Protocol, which allows for reliable communication between two applications. TCP is typically used over the Internet Protocol, which is referred to as TCP/IP.
    
- [**UDP**](https://www.tutorialspoint.com/data_communication_computer_network/user_datagram_protocol.htm) − UDP stands for User Datagram Protocol, a connection-less protocol that allows for packets of data to be transmitted between applications.
    

This chapter gives a good understanding on the following two subjects −

- **Socket Programming** − This is the most widely used concept in Networking and it has been explained in very detail.
    
- **URL Processing** − This would be covered separately. Click here to learn about [URL Processing](https://www.tutorialspoint.com/java/java_url_processing.htm) in Java language.
    

## Socket Programming in Java Networking

Sockets provide the communication mechanism between two computers using TCP. A client program creates a socket on its end of the communication and attempts to connect that socket to a server.

When the connection is made, the server creates a socket object on its end of the communication. The client and the server can now communicate by writing to and reading from the socket.

The [java.net.Socket class](https://www.tutorialspoint.com/java/java-socket.htm) represents a socket, and the java.net.ServerSocket class provides a mechanism for the server program to listen for clients and establish connections with them.

The following steps occur when establishing a TCP connection between two computers using sockets −

- The server instantiates a ServerSocket object, denoting which port number communication is to occur on.
    
- The server invokes the accept() method of the ServerSocket class. This method waits until a client connects to the server on the given port.
    
- After the server is waiting, a client instantiates a Socket object, specifying the server name and the port number to connect to.
    
- The constructor of the Socket class attempts to connect the client to the specified server and the port number. If communication is established, the client now has a Socket object capable of communicating with the server.
    
- On the server side, the accept() method returns a reference to a new socket on the server that is connected to the client's socket.
    

After the connections are established, communication can occur using I/O streams. Each socket has both an OutputStream and an InputStream. The client's OutputStream is connected to the server's InputStream, and the client's InputStream is connected to the server's OutputStream.

TCP is a two-way communication protocol, hence data can be sent across both streams at the same time. Following are the useful classes providing complete set of methods to implement sockets.

### ServerSocket Class Constructors

The **java.net.ServerSocket** class is used by server applications to obtain a port and listen for client requests.

The ServerSocket class has four constructors −

|Sr.No.|Method & Description|
|---|---|
|1|**public ServerSocket(int port) throws IOException**<br><br>Attempts to create a server socket bound to the specified port. An exception occurs if the port is already bound by another application.|
|2|**public ServerSocket(int port, int backlog) throws IOException**<br><br>Similar to the previous constructor, the backlog parameter specifies how many incoming clients to store in a wait queue.|
|3|**public ServerSocket(int port, int backlog, InetAddress address) throws IOException**<br><br>Similar to the previous constructor, the InetAddress parameter specifies the local IP address to bind to. The InetAddress is used for servers that may have multiple IP addresses, allowing the server to specify which of its IP addresses to accept client requests on.|
|4|**public ServerSocket() throws IOException**<br><br>Creates an unbound server socket. When using this constructor, use the bind() method when you are ready to bind the server socket.|

If the ServerSocket constructor does not throw an exception, it means that your application has successfully bound to the specified port and is ready for client requests.

### ServerSocket Class Methods

Following are some of the common methods of the ServerSocket class −

|Sr.No.|Method & Description|
|---|---|
|1|**public int getLocalPort()**<br><br>Returns the port that the server socket is listening on. This method is useful if you passed in 0 as the port number in a constructor and let the server find a port for you.|
|2|**public Socket accept() throws IOException**<br><br>Waits for an incoming client. This method blocks until either a client connects to the server on the specified port or the socket times out, assuming that the time-out value has been set using the setSoTimeout() method. Otherwise, this method blocks indefinitely.|
|3|**public void [setSoTimeout(int timeout)](https://www.tutorialspoint.com/java/java-socket-setsotimeout.htm)**<br><br>Sets the time-out value for how long the server socket waits for a client during the accept().|
|4|**public void [bind(SocketAddress host, int backlog)](https://www.tutorialspoint.com/java/java-socket-bind.htm)**<br><br>Binds the socket to the specified server and port in the SocketAddress object. Use this method if you have instantiated the ServerSocket using the no-argument constructor.|

When the ServerSocket invokes accept(), the method does not return until a client connects. After a client does connect, the ServerSocket creates a new Socket on an unspecified port and returns a reference to this new Socket. A TCP connection now exists between the client and the server, and communication can begin.

### Socket Class Constructors

The **java.net.Socket** class represents the socket that both the client and the server use to communicate with each other. The client obtains a Socket object by instantiating one, whereas the server obtains a Socket object from the return value of the accept() method.

The Socket class has five constructors that a client uses to connect to a server −

|Sr.No.|Method & Description|
|---|---|
|1|**public Socket(String host, int port) throws UnknownHostException, IOException.**<br><br>This method attempts to connect to the specified server at the specified port. If this constructor does not throw an exception, the connection is successful and the client is connected to the server.|
|2|**public Socket(InetAddress host, int port) throws IOException**<br><br>This method is identical to the previous constructor, except that the host is denoted by an InetAddress object.|
|3|**public Socket(String host, int port, InetAddress localAddress, int localPort) throws IOException.**<br><br>Connects to the specified host and port, creating a socket on the local host at the specified address and port.|
|4|**public Socket(InetAddress host, int port, InetAddress localAddress, int localPort) throws IOException.**<br><br>This method is identical to the previous constructor, except that the host is denoted by an InetAddress object instead of a String.|
|5|**public Socket()**<br><br>Creates an unconnected socket. Use the connect() method to connect this socket to a server.|

When the Socket constructor returns, it does not simply instantiate a Socket object but it actually attempts to connect to the specified server and port.

### Socket Class Methods

Some methods of interest in the Socket class are listed here. Notice that both the client and the server have a Socket object, so these methods can be invoked by both the client and the server.

|Sr.No.|Method & Description|
|---|---|
|1|**public void connect(SocketAddress host, int timeout) throws IOException**<br><br>This method connects the socket to the specified host. This method is needed only when you instantiate the Socket using the no-argument constructor.|
|2|**public InetAddress getInetAddress()**<br><br>This method returns the address of the other computer that this socket is connected to.|
|3|**public int getPort()**<br><br>Returns the port the socket is bound to on the remote machine.|
|4|**public int [getLocalPort()](https://www.tutorialspoint.com/java/java-socket-getlocaladdress.htm)**<br><br>Returns the port the socket is bound to on the local machine.|
|5|**public SocketAddress getRemoteSocketAddress()**<br><br>Returns the address of the remote socket.|
|6|**public InputStream getInputStream() throws IOException**<br><br>Returns the input stream of the socket. The input stream is connected to the output stream of the remote socket.|
|7|**public OutputStream getOutputStream() throws IOException**<br><br>Returns the output stream of the socket. The output stream is connected to the input stream of the remote socket.|
|8|**public void close() throws IOException**<br><br>Closes the socket, which makes this Socket object no longer capable of connecting again to any server.|

### InetAddress Class Methods

This class represents an Internet Protocol (IP) address. Here are following usefull methods which you would need while doing socket programming −

|Sr.No.|Method & Description|
|---|---|
|1|**static InetAddress getByAddress(byte[] addr)**<br><br>Returns an InetAddress object given the raw IP address.|
|2|**static InetAddress getByAddress(String host, byte[] addr)**<br><br>Creates an InetAddress based on the provided host name and IP address.|
|3|**static InetAddress getByName(String host)**<br><br>Determines the IP address of a host, given the host's name.|
|4|**String getHostAddress()**<br><br>Returns the IP address string in textual presentation.|
|5|**String getHostName()**<br><br>Gets the host name for this IP address.|
|6|**static InetAddress InetAddress getLocalHost()**<br><br>Returns the local host.|
|7|**String toString()**<br><br>Converts this IP address to a String.|

## Example of Java Networking

### Implementing Socket Client in Java

The following GreetingClient is a client program that connects to a server by using a socket and sends a greeting, and then waits for a response.

#### Example: Socket Client

// File Name GreetingClient.java
import java.net.*;
import java.io.*;

public class GreetingClient {

   public static void main(String [] args) {
      String serverName = args[0];
      int port = Integer.parseInt(args[1]);
      try {
         System.out.println("Connecting to " + serverName + " on port " + port);
         Socket client = new Socket(serverName, port);
         
         System.out.println("Just connected to " + client.getRemoteSocketAddress());
         OutputStream outToServer = client.getOutputStream();
         DataOutputStream out = new DataOutputStream(outToServer);
         
         out.writeUTF("Hello from " + client.getLocalSocketAddress());
         InputStream inFromServer = client.getInputStream();
         DataInputStream in = new DataInputStream(inFromServer);
         
         System.out.println("Server says " + in.readUTF());
         client.close();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}

### Implementing Socket Server in Java

The following GreetingServer program is an example of a server application that uses the Socket class to listen for clients on a port number specified by a command-line argument −

#### Example: Socket Server

// File Name GreetingServer.java
import java.net.*;
import java.io.*;

public class GreetingServer extends Thread {
   private ServerSocket serverSocket;
   
   public GreetingServer(int port) throws IOException {
      serverSocket = new ServerSocket(port);
      serverSocket.setSoTimeout(10000);
   }

   public void run() {
      while(true) {
         try {
            System.out.println("Waiting for client on port " + 
               serverSocket.getLocalPort() + "...");
            Socket server = serverSocket.accept();
            
            System.out.println("Just connected to " + server.getRemoteSocketAddress());
            DataInputStream in = new DataInputStream(server.getInputStream());
            
            System.out.println(in.readUTF());
            DataOutputStream out = new DataOutputStream(server.getOutputStream());
            out.writeUTF("Thank you for connecting to " + server.getLocalSocketAddress()
               + "\nGoodbye!");
            server.close();
            
         } catch (SocketTimeoutException s) {
            System.out.println("Socket timed out!");
            break;
         } catch (IOException e) {
            e.printStackTrace();
            break;
         }
      }
   }
   
   public static void main(String [] args) {
      int port = Integer.parseInt(args[0]);
      try {
         Thread t = new GreetingServer(port);
         t.start();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}

Compile the client and the server and then start the server as follows −

$ java GreetingServer 6066
Waiting for client on port 6066...

Check the client program as follows −

**Output**

$ java GreetingClient localhost 6066
Connecting to localhost on port 6066
Just connected to localhost/127.0.0.1:6066
Server says Thank you for connecting to /127.0.0.1:6066
Goodbye!
# iting Event Listeners: Examples

The [table](https://docs.oracle.com/javase/tutorial/uiswing/examples/events/index.html#table) that follows lists every example in the Writing Event Listeners lesson, with links to required files and to where each example is discussed. The first column of the table has links to JNLP files that let you run the examples using Java™ Web Start.

---

**NOTE:** Release 7.0 is required to run all applets and Java Web Start examples. Most examples will run on an earlier release but you must compile and run them locally.

---

To run an example using Java Web Start, click the _[Launch]_ link in the first column of the [table](https://docs.oracle.com/javase/tutorial/uiswing/examples/events/index.html#table). The first time you run an example, there will be a delay while Java Web Start downloads the JAR file containing the class files for this lesson's examples. Afterward, the examples should execute more quickly.

## Compiling and Running the Examples Locally

The second column in the table below has links to zip files for each demo that you can open and run in the NetBeans IDE. Refer to [Running Tutorial Examples in NetBeans IDE](https://docs.oracle.com/javase/tutorial/information/examples.html) for more information.

|Example|Zip File  <br>_(contains all files necessary for the example plus NetBeans IDE project metadata)_|Source Files _(first file has the main method, except for examples that run only as applets)_|Image & Other Files|Where Described|
|---|---|---|---|---|
|Beeper [_[Launch]_](https://docs.oracle.com/javase/tutorialJWS/samples/uiswing/BeeperProject/Beeper.jnlp)|[Beeper Project](https://docs.oracle.com/javase/tutorial/uiswing/examples/zipfiles/events-BeeperProject.zip)|[`Beeper.java`](https://docs.oracle.com/javase/tutorial/uiswing/examples/events/BeeperProject/src/events/Beeper.java)||[Some Simple Event-Handling Examples](https://docs.oracle.com/javase/tutorial/uiswing/events/intro.html)|
|ComponentEventDemo [_[Launch]_](https://docs.oracle.com/javase/tutorialJWS/samples/uiswing/ComponentEventDemoProject/ComponentEventDemo.jnlp)|[Component Event Demo Project](https://docs.oracle.com/javase/tutorial/uiswing/examples/zipfiles/events-ComponentEventDemoProject.zip)|[`ComponentEventDemo.java`](https://docs.oracle.com/javase/tutorial/uiswing/examples/events/ComponentEventDemoProject/src/events/ComponentEventDemo.java)||[How to Write a Component Listener](https://docs.oracle.com/javase/tutorial/uiswing/events/componentlistener.html)|
|ContainerEventDemo [_[Launch]_](https://docs.oracle.com/javase/tutorialJWS/samples/uiswing/ContainerEventDemoProject/ContainerEventDemo.jnlp)|[Container Event Demo Project](https://docs.oracle.com/javase/tutorial/uiswing/examples/zipfiles/events-ContainerEventDemoProject.zip)|[`ContainerEventDemo.java`](https://docs.oracle.com/javase/tutorial/uiswing/examples/events/ContainerEventDemoProject/src/events/ContainerEventDemo.java)||[How to Write a Container Listener](https://docs.oracle.com/javase/tutorial/uiswing/events/containerlistener.html)|
|DocumentEventDemo [_[Launch]_](https://docs.oracle.com/javase/tutorialJWS/samples/uiswing/DocumentEventDemoProject/DocumentEventDemo.jnlp)|[Document Event Demo Project](https://docs.oracle.com/javase/tutorial/uiswing/examples/zipfiles/events-DocumentEventDemoProject.zip)|[`DocumentEventDemo.java`](https://docs.oracle.com/javase/tutorial/uiswing/examples/events/DocumentEventDemoProject/src/events/DocumentEventDemo.java)||[How to Write a Document Listener](https://docs.oracle.com/javase/tutorial/uiswing/events/documentlistener.html)|
|FocusEventDemo [_[Launch]_](https://docs.oracle.com/javase/tutorialJWS/samples/uiswing/FocusEventDemoProject/FocusEventDemo.jnlp)|[Focus Event Demo Project](https://docs.oracle.com/javase/tutorial/uiswing/examples/zipfiles/events-FocusEventDemoProject.zip)|[`FocusEventDemo.java`](https://docs.oracle.com/javase/tutorial/uiswing/examples/events/FocusEventDemoProject/src/events/FocusEventDemo.java)||[How to Write a Focus Listener](https://docs.oracle.com/javase/tutorial/uiswing/events/focuslistener.html)|
|InternalFrameEventDemo [_[Launch]_](https://docs.oracle.com/javase/tutorialJWS/samples/uiswing/InternalFrameEventDemoProject/InternalFrameEventDemo.jnlp)|[Internal Frame Event Demo Project](https://docs.oracle.com/javase/tutorial/uiswing/examples/zipfiles/events-InternalFrameEventDemoProject.zip)|[`InternalFrameEventDemo.java`](https://docs.oracle.com/javase/tutorial/uiswing/examples/events/InternalFrameEventDemoProject/src/events/InternalFrameEventDemo.java)||[How to Write an Internal Frame Listener](https://docs.oracle.com/javase/tutorial/uiswing/events/internalframelistener.html)|
|KeyEventDemo [_[Launch]_](https://docs.oracle.com/javase/tutorialJWS/samples/uiswing/KeyEventDemoProject/KeyEventDemo.jnlp)|[Key Event Demo Project](https://docs.oracle.com/javase/tutorial/uiswing/examples/zipfiles/events-KeyEventDemoProject.zip)|[`KeyEventDemo.java`](https://docs.oracle.com/javase/tutorial/uiswing/examples/events/KeyEventDemoProject/src/events/KeyEventDemo.java)||[How to Write a Key Listener](https://docs.oracle.com/javase/tutorial/uiswing/events/keylistener.html)|
|ListDataEventDemo [_[Launch]_](https://docs.oracle.com/javase/tutorialJWS/samples/uiswing/ListDataEventDemoProject/ListDataEventDemo.jnlp)|[List Data Event Demo Project](https://docs.oracle.com/javase/tutorial/uiswing/examples/zipfiles/events-ListDataEventDemoProject.zip)|[`ListDataEventDemo.java`](https://docs.oracle.com/javase/tutorial/uiswing/examples/events/ListDataEventDemoProject/src/events/ListDataEventDemo.java)|[`jlfgr-1_0.jar`](http://www.oracle.com/technetwork/java/index-138612.html)|[How to Write a List Data Listener](https://docs.oracle.com/javase/tutorial/uiswing/events/listdatalistener.html)|
|ListSelectionDemo [_[Launch]_](https://docs.oracle.com/javase/tutorialJWS/samples/uiswing/ListSelectionDemoProject/ListSelectionDemo.jnlp)|[List Selection Demo Project](https://docs.oracle.com/javase/tutorial/uiswing/examples/zipfiles/events-ListSelectionDemoProject.zip)|[`ListSelectionDemo.java`](https://docs.oracle.com/javase/tutorial/uiswing/examples/events/ListSelectionDemoProject/src/events/ListSelectionDemo.java)||[How to Write a List Selection Listener](https://docs.oracle.com/javase/tutorial/uiswing/events/listselectionlistener.html)|
|TableListSelectionDemo [_[Launch]_](https://docs.oracle.com/javase/tutorialJWS/samples/uiswing/TableListSelectionDemoProject/TableListSelectionDemo.jnlp)|[Table List Selection Demo Project](https://docs.oracle.com/javase/tutorial/uiswing/examples/zipfiles/events-TableListSelectionDemoProject.zip)|[`TableListSelectionDemo.java`](https://docs.oracle.com/javase/tutorial/uiswing/examples/events/TableListSelectionDemoProject/src/events/TableListSelectionDemo.java)||[How to Write a List Selection Listener](https://docs.oracle.com/javase/tutorial/uiswing/events/listselectionlistener.html)|
|MouseEventDemo [_[Launch]_](https://docs.oracle.com/javase/tutorialJWS/samples/uiswing/MouseEventDemoProject/MouseEventDemo.jnlp)|[Mouse Event Demo Project](https://docs.oracle.com/javase/tutorial/uiswing/examples/zipfiles/events-MouseEventDemoProject.zip)|[`MouseEventDemo.java`](https://docs.oracle.com/javase/tutorial/uiswing/examples/events/MouseEventDemoProject/src/events/MouseEventDemo.java)  <br>   [`BlankArea.java`](https://docs.oracle.com/javase/tutorial/uiswing/examples/events/MouseEventDemoProject/src/events/BlankArea.java)||[How to Write a Mouse Listener](https://docs.oracle.com/javase/tutorial/uiswing/events/mouselistener.html)|
|MouseMotionEventDemo [_[Launch]_](https://docs.oracle.com/javase/tutorialJWS/samples/uiswing/MouseMotionEventDemoProject/MouseMotionEventDemo.jnlp)|[Mouse Motion Event Demo Project](https://docs.oracle.com/javase/tutorial/uiswing/examples/zipfiles/events-MouseMotionEventDemoProject.zip)|[`MouseMotionEventDemo.java`](https://docs.oracle.com/javase/tutorial/uiswing/examples/events/MouseMotionEventDemoProject/src/events/MouseMotionEventDemo.java)  <br>   [`BlankArea.java`](https://docs.oracle.com/javase/tutorial/uiswing/examples/events/MouseMotionEventDemoProject/src/events/BlankArea.java)||[How to Write a Mouse-Motion Listener](https://docs.oracle.com/javase/tutorial/uiswing/events/mousemotionlistener.html)|
|MouseWheelEventDemo [_[Launch]_](https://docs.oracle.com/javase/tutorialJWS/samples/uiswing/MouseWheelEventDemoProject/MouseWheelEventDemo.jnlp)|[Mouse Wheel Event Demo Project](https://docs.oracle.com/javase/tutorial/uiswing/examples/zipfiles/events-MouseWheelEventDemoProject.zip)|[`MouseWheelEventDemo.java`](https://docs.oracle.com/javase/tutorial/uiswing/examples/events/MouseWheelEventDemoProject/src/events/MouseWheelEventDemo.java)||[How to Write a Mouse-Wheel Listener](https://docs.oracle.com/javase/tutorial/uiswing/events/mousewheellistener.html)|
|MultiListener [_[Launch]_](https://docs.oracle.com/javase/tutorialJWS/samples/uiswing/MultiListenerProject/MultiListener.jnlp)|[MultiListener Project](https://docs.oracle.com/javase/tutorial/uiswing/examples/zipfiles/events-MultiListenerProject.zip)|[`MultiListener.java`](https://docs.oracle.com/javase/tutorial/uiswing/examples/events/MultiListenerProject/src/events/MultiListener.java)||[Some Simple Event-Handling Examples](https://docs.oracle.com/javase/tutorial/uiswing/events/intro.html)|
|TreeExpandEventDemo [_[Launch]_](https://docs.oracle.com/javase/tutorialJWS/samples/uiswing/TreeExpandEventDemoProject/TreeExpandEventDemo.jnlp)|[Tree Expand Event Demo Project](https://docs.oracle.com/javase/tutorial/uiswing/examples/zipfiles/events-TreeExpandEventDemoProject.zip)|[`TreeExpandEventDemo.java`](https://docs.oracle.com/javase/tutorial/uiswing/examples/events/TreeExpandEventDemoProject/src/events/TreeExpandEventDemo.java)||[How to Write a Tree Expansion Listener](https://docs.oracle.com/javase/tutorial/uiswing/events/treeexpansionlistener.html)|
|TreeExpandEventDemo2 [_[Launch]_](https://docs.oracle.com/javase/tutorialJWS/samples/uiswing/TreeExpandEventDemo2Project/TreeExpandEventDemo2.jnlp)|[Tree Expand Event 2 Demo Project](https://docs.oracle.com/javase/tutorial/uiswing/examples/zipfiles/events-TreeExpandEventDemo2Project.zip)|[`TreeExpandEventDemo2.java`](https://docs.oracle.com/javase/tutorial/uiswing/examples/events/TreeExpandEventDemo2Project/src/events/TreeExpandEventDemo2.java)||[How to Write a Tree Will Expand Listener](https://docs.oracle.com/javase/tutorial/uiswing/events/treewillexpandlistener.html)|
|WindowEventDemo [_[Launch]_](https://docs.oracle.com/javase/tutorialJWS/samples/uiswing/WindowEventDemoProject/WindowEventDemo.jnlp)|[Window Event Demo Project](https://docs.oracle.com/javase/tutorial/uiswing/examples/zipfiles/events-WindowEventDemoProject.zip)|[`WindowEventDemo.java`](https://docs.oracle.com/javase/tutorial/uiswing/examples/events/WindowEventDemoProject/src/events/WindowEventDemo.java)||[How to Write Window Listeners](https://docs.oracle.com/javase/tutorial/uiswing/events/windowlistener.html)|

[« Previous](https://docs.oracle.com/javase/tutorial/uiswing/examples/layout/index.html) • [Trail](https://docs.oracle.com/javase/tutorial/uiswing/TOC.html) • [Next »](https://docs.oracle.com/javase/tutorial/uiswing/examples/painting/index.html)
# General Information about Writing Event Listeners

This section discusses several design considerations to keep in mind when implementing event handlers in your application. We then introduce you to event objects small objects that describe each event. In particular, we talk about `EventObject`, the superclass for all AWT and Swing events. Next, we introduce the concepts of low-level events and semantic events, recommending that you prefer semantic events when possible. The remainder of this section discusses implementation techniques you might use in some event listeners or see in event listeners created by other people or by GUI builders.

- [Design Considerations](https://docs.oracle.com/javase/tutorial/uiswing/events/generalrules.html#design)
- [Getting Event Information: Event Objects](https://docs.oracle.com/javase/tutorial/uiswing/events/generalrules.html#eventobjects)
- [Concepts: Low-Level Events and Semantic Events](https://docs.oracle.com/javase/tutorial/uiswing/events/generalrules.html#twokinds)
- [Event Adapters](https://docs.oracle.com/javase/tutorial/uiswing/events/generalrules.html#eventAdapters)
- [Inner Classes and Anonymous Inner Classes](https://docs.oracle.com/javase/tutorial/uiswing/events/generalrules.html#innerClasses)
- [The EventHandler Class](https://docs.oracle.com/javase/tutorial/uiswing/events/generalrules.html#eventHandlers)

## Design Considerations

The most important rule to keep in mind about event listeners is that they should execute very quickly. Because all drawing and event-listening methods are executed in the same thread, a slow event-listener method can make the program seem unresponsive and slow to repaint itself. If you need to perform some lengthy operation as the result of an event, do it by starting up another thread (or somehow sending a request to another thread) to perform the operation. For help on using threads, see [Concurrency in Swing](https://docs.oracle.com/javase/tutorial/uiswing/concurrency/index.html).

You have many choices on how to implement an event listener. We can not recommend a specific approach because one solution would not suit all situations. However, we can give you some hints and show you some techniques that you might see, even if you do not use the same solution in your program.

For example, you might choose to implement separate classes for different kinds of event listeners. This can be an easy architecture to maintain, but many classes can also mean reduced performance.

When designing your program, you might want to implement your event listeners in a class that is not public, but somewhere more hidden. A private implementation is a more secure implementation.

If you have a very specific kind of simple event listener, you might be able to avoid creating a class at all by using the `EventHandler` class.

## Getting Event Information: Event Objects

Every event-listener method has a single argument an object that inherits from the [`EventObject`](https://docs.oracle.com/javase/8/docs/api/java/util/EventObject.html) class. Although the argument always descends from `EventObject`, its type is generally specified more precisely. For example, the argument for methods that handle mouse events is an instance of `MouseEvent`, where `MouseEvent` is an indirect subclass of `EventObject`.

The `EventObject` class defines one very useful method:

**`Object getSource()`**

Returns the object that fired the event.

Note that the `getSource` method returns an `Object`. Event classes sometimes define methods similar to `getSource`, but that have more restricted return types. For example, the `ComponentEvent` class defines a `getComponent` method that just like `getSource` returns the object that fired the event. The difference is that `getComponent` always returns a `Component`. Each how-to page for event listeners mentions whether you should use `getSource` or another method to get the event source.

Often, an event class defines methods that return information about the event. For example, you can query a `MouseEvent` object for information about where the event occurred, how many clicks the user made, which modifier keys were pressed, and so on.

## Concepts: Low-Level Events and Semantic Events

Events can be divided into two groups: _low-level_ events and _semantic_ events. Low-level events represent window-system occurrences or low-level input. Everything else is a semantic event.

Examples of low-level events include mouse and key events both of which result directly from user input. Examples of semantic events include action and item events. A semantic event might be triggered by user input; for example, a button customarily fires an action event when the user clicks it, and a text field fires an action event when the user presses _Enter_. However, some semantic events are not triggered by low-level events, at all. For example, a table-model event might be fired when a table model receives new data from a database.

Whenever possible, you should listen for semantic events rather than low-level events. That way, you can make your code as robust and portable as possible. For example, listening for action events on buttons, rather than mouse events, means that the button will react appropriately when the user tries to activate the button using a keyboard alternative or a look-and-feel-specific gesture. When dealing with a compound component such as a combo box, it is imperative that you stick to semantic events, since you have no reliable way of registering listeners on all the look-and-feel-specific components that might be used to form the compound component.

## Event Adapters

Some listener interfaces contain more than one method. For example, the `MouseListener` interface contains five methods: `mousePressed`, `mouseReleased`, `mouseEntered`, `mouseExited`, and `mouseClicked`. Even if you care only about mouse clicks, if your class directly implements `MouseListener`, then you must implement all five `MouseListener` methods. Methods for those events you do not care about can have empty bodies. Here is an example:

//An example that implements a listener interface directly.
public class MyClass implements MouseListener {
    ...
        someObject.addMouseListener(this);
    ...
    /* Empty method definition. */
    public void mousePressed(MouseEvent e) {
    }

    /* Empty method definition. */
    public void mouseReleased(MouseEvent e) {
    }

    /* Empty method definition. */
    public void mouseEntered(MouseEvent e) {
    }

    /* Empty method definition. */
    public void mouseExited(MouseEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
        _...//Event listener implementation goes here..._
    }
}

The resulting collection of empty method bodies can make code harder to read and maintain. To help you avoid implementing empty method bodies, the API generally includes an _adapter_ class for each listener interface with more than one method. (The [Listener API Table](https://docs.oracle.com/javase/tutorial/uiswing/events/api.html) lists all the listeners and their adapters.) For example, the `MouseAdapter` class implements the `MouseListener` interface. An adapter class implements empty versions of all its interface's methods.

To use an adapter, you create a subclass of it and override only the methods of interest, rather than directly implementing all methods of the listener interface. Here is an example of modifying the preceding code to extend `MouseAdapter`. By extending `MouseAdapter`, it inherits empty definitions of all five of the methods that `MouseListener` contains.

/*
 * An example of extending an adapter class instead of
 * directly implementing a listener interface.
 */
public class MyClass extends MouseAdapter {
    ... 
        someObject.addMouseListener(this);
    ... 
    public void mouseClicked(MouseEvent e) {
        _...//Event listener implementation goes here..._
    }
}

## Inner Classes and Anonymous Inner Classes

What if you want to use an adapter class, but do not want your public class to inherit from an adapter class? For example, suppose you write an applet, and you want your `Applet` subclass to contain some code to handle mouse events. Since the Java language does not permit multiple inheritance, your class cannot extend both the `Applet` and `MouseAdapter` classes. A solution is to define an _inner class_ a class inside of your `Applet` subclass that extends the `MouseAdapter` class.

Inner classes can also be useful for event listeners that implement one or more interfaces directly.

//An example of using an inner class.
public class MyClass extends Applet {
    ...
        someObject.addMouseListener(new MyAdapter());
    ...
    class MyAdapter extends MouseAdapter {
        public void mouseClicked(MouseEvent e) {
            _...//Event listener implementation goes here..._
        }
    }
}

---

**Performance note:** 

When considering whether to use an inner class, keep in mind that application startup time and memory footprint are typically directly proportional to the number of classes you load. The more classes you create, the longer your program takes to start up and the more memory it will take. As an application developer you have to balance this with other design constraints you may have. We are not suggesting you turn your application into a single monolithic class in hopes of cutting down startup time and memory footprint this would lead to unnecessary headaches and maintenance burdens.

---

You can create an inner class without specifying a name this is known as an _anonymous inner class_. While it might look strange at first glance, anonymous inner classes can make your code easier to read because the class is defined where it is referenced. However, you need to weigh the convenience against possible performance implications of increasing the number of classes.

Here is an example of using an anonymous inner class:

//An example of using an anonymous inner class.
public class MyClass extends Applet {
    ...
        someObject.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                _...//Event listener implementation goes here..._
            }
        });
    ...
    }
}

---

**Note:** 

One drawback of anonymous inner classes is that they can not be seen by the long-term persistence mechanism. For more information see the API documentation for the [JavaBeans™ package](https://docs.oracle.com/javase/8/docs/api/java/beans/package-summary.html#package_description) and the [Bean Persistence](https://docs.oracle.com/javase/tutorial/javabeans/advanced/persistence.html) lesson in the [JavaBeans](https://docs.oracle.com/javase/tutorial/javabeans/) trail.

---

Inner classes work even if your event listener needs access to private instance variables from the enclosing class. As long as you do not declare an inner class to be `static`, an inner class can refer to instance variables and methods just as if its code is in the containing class. To make a local variable available to an inner class, just save a copy of the variable as a `final` local variable.

To refer to the enclosing instance, you can use `_EnclosingClass_.this`. For more information about inner classes, see [Nested Classes](https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html).

## The EventHandler Class

An [`EventHandler`](https://docs.oracle.com/javase/8/docs/api/java/beans/EventHandler.html) class supports dynamic generation of simple, one-statement event listeners. Although `EventHandler` is only useful for a certain type of extremely simple event listeners, it is worth mentioning for two reasons. It is useful for:

- Making an event listener that persistence can see and yet does not clog up your own classes with event listener interfaces and methods.
- Not adding to the number of classes defined in an application this can help performance.

Creating an `EventHandler` by hand is difficult. An `EventHandler` must be carefully constructed. If you make a mistake, you would not be notified at compile time it will throw an obscure exception at runtime. For this reason, `EventHandler`s are best created by a GUI builder. `EventHandler`s should be carefully documented. Otherwise you run the risk of producing hard-to-read code.

The `EventHandler` class is intended to be used by interactive tools, such as application builders, that allow developers to make connections between beans. Typically connections are made from a user interface bean (the event source) to an application logic bean (the target). The most effective connections of this kind isolate the application logic from the user interface. For example, the `EventHandler` for a connection from a JCheckBox to a method that accepts a boolean value can deal with extracting the state of the check box and passing it directly to the method so that the method is isolated from the user interface layer.

Inner classes are another, more general way to handle events from user interfaces. The `EventHandler` class handles only a subset of what is possible using inner classes. However, `EventHandler` works better with the long-term persistence scheme than inner classes. Also, using `EventHandler` in large applications in which the same interface is implemented many times can reduce the disk and memory footprint of the application.

Examples of Using `EventHandler` The simplest use of `EventHandler` is to install a listener that calls a method on the target object with no arguments. In the following example we create an ActionListener that invokes the toFront method on an instance of `javax.swing.JFrame`.

    myButton.addActionListener(
        (ActionListener)EventHandler.create(ActionListener.class, frame, "toFront"));

When myButton is pressed, the statement frame.toFront() will be executed. One could get the same effect, with some additional compile-time type safety, by defining a new implementation of the ActionListener interface and adding an instance of it to the button:

    //Equivalent code using an inner class instead of `EventHandler`.
    myButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            frame.toFront();
        }
    });

The next simplest use of `EventHandler` is to extract a property value from the first argument of the method in the listener interface (typically an event object) and use it to set the value of a property in the target object. In the following example we create an ActionListener that sets the nextFocusableComponent property of the target (myButton) object to the value of the "source" property of the event.

    EventHandler.create(ActionListener.class, myButton, "nextFocusableComponent", "source")

This would correspond to the following inner class implementation:

    //Equivalent code using an inner class instead of `EventHandler`.
    new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            myButton.setNextFocusableComponent((Component)e.getSource()); 
        }
    }

It is also possible to create an `EventHandler` that just passes the incoming event object to the target's action. If the fourth `EventHandler.create` argument is an empty string, then the event is just passed along:

    EventHandler.create(ActionListener.class, target, "doActionEvent", "")

This would correspond to the following inner class implementation:

    //Equivalent code using an inner class instead of `EventHandler`.
    new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            target.doActionEvent(e);
        }
    }

Probably the most common use of `EventHandler` is to extract a property value from the source of the event object and set this value as the value of a property of the target object. In the following example we create an ActionListener that sets the "label" property of the target object to the value of the "text" property of the source (the value of the "source" property) of the event.

    EventHandler.create(ActionListener.class, myButton, "label", "source.text")

This would correspond to the following inner class implementation:

    //Equivalent code using an inner class instead of `EventHandler`.
    new ActionListener {
        public void actionPerformed(ActionEvent e) {
            myButton.setLabel(((JTextField)e.getSource()).getText()); 
        }
    }