# Java-EE-simple-constructor
Base of project, for quick creation. It consists from client and server parts.

Client sends `string` message and `long` id, and gets the `string` and `object`as answers.

String message is just a string:
```java
MessageChanger messageChanger = new MessageChanger();
String serverMess = messageChanger.changeMessages("Hi, I am a client !");
```

And Object in this case is `ExampleDto` and consists of two fields: 
```java
   private long id;
    private String name;
```

It sends by `RESTful Api`:

```java
    @GET("message")
    Call<String> changeMessages(@Query("message") String message);

    @GET("dto")
    Call<ExampleDto> getExampleDto(@Query("id") long id);
```

And the result is:

```
=========================
+++++++++ Success !+++++++++
Get String from Server

 - client message: Hi, I am a client !
 - server answer: Hi, client, I am a Server !

++++++++++++++++++++++++++++
Get Object from Server: 
id : 1
name : Example Dto
=========================
``` 

It uses:
- `okhttp3`
- `retrofit`
