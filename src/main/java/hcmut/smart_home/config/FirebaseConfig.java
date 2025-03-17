package hcmut.smart_home.config;

import java.io.FileInputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

@Configuration
public class FirebaseConfig {

    @Bean
    public FirebaseApp initializeFirebase(@Value("${firebase.url}") String databaseUrl) throws IOException {
        if (!FirebaseApp.getApps().isEmpty()) {
            FirebaseApp.getInstance().delete(); 
        }

        FileInputStream serviceAccount =
                new FileInputStream("src/main/resources/firebase/firebase-service-account.json");

        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl(databaseUrl) 
                .build();

        FirebaseApp.initializeApp(options);
        
        return FirebaseApp.getInstance();
    }

    @Bean
	public Firestore firestore(final FirebaseApp firebaseApp) {
		return FirestoreClient.getFirestore(firebaseApp);
	}
}
