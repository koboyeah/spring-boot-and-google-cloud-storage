package com.koboyeah.testgcs

import com.google.auth.oauth2.GoogleCredentials
import com.google.cloud.storage.Acl
import com.google.cloud.storage.BlobInfo
import com.google.cloud.storage.StorageOptions
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.io.FileInputStream
import java.util.*


@RestController
class TestController {

    @RequestMapping("/")
    fun index(): String {
        return "Greetings from Spring Boot!"
    }

    @PostMapping("/test/upload_file")
    fun testUploadFile(@RequestParam("file") file: MultipartFile): String? {
        try{
            var credentials = GoogleCredentials.fromStream(FileInputStream("YOUR_CREDEBTIAL_PATH"))
            val storage = StorageOptions.newBuilder().setCredentials(credentials).build().service
            val bucketName = "YOUR_BUCKET_NAME"
            var fileName = file.originalFilename
            storage.create(BlobInfo.newBuilder(bucketName, fileName)
                    .setAcl(ArrayList<Acl>(Arrays.asList(Acl.of(Acl.User.ofAllUsers(), Acl.Role.OWNER))))
                    .build(), file.inputStream)
            return "File was upload"
        }catch (e: Exception){
            return e.toString()
        }
    }
}