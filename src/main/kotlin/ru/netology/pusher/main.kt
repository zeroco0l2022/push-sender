package ru.netology.pusher

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import java.io.FileInputStream


fun main() {
    val options = FirebaseOptions.builder()
        .setCredentials(GoogleCredentials.fromStream(FileInputStream("fcm.json")))
        .build()

    FirebaseApp.initializeApp(options)

    val messageError = Message.builder()
        .putData("action", "11111")
        .putData("content", """{
              "postId": 3,
              "postAuthor": "Netology",
              "content": "Диджитал давно стал частью нашей жизни: мы общаемся в социальных сетях и мессенджерах, заказываем еду, такси и оплачиваем счета через приложения."
              }""".trimIndent())
        .setToken(token)
        .build()

        val message = Message.builder()
            .putData("action", "LIKE")
            .putData("content", """{
              "userId": 1,
              "userName": "Vasiliy",
              "postId": 2,
              "postAuthor": "Netology"
            }""".trimIndent())
            .setToken(token)
            .build()

        val messagePost = Message.builder()
            .putData("action", "NEW_POST")
            .putData("content", """{
              "postId": 3,
              "postAuthor": "Netology",
              "content": "Диджитал давно стал частью нашей жизни: мы общаемся в социальных сетях и мессенджерах, заказываем еду, такси и оплачиваем счета через приложения."
              }""".trimIndent())
            .setToken(token)
            .build()

    FirebaseMessaging.getInstance().send(messageError)
    FirebaseMessaging.getInstance().send(message)
    FirebaseMessaging.getInstance().send(messagePost)
}
