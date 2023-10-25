package gamers.inc.game_review;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;

import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.FirebaseApp;

import com.google.firebase.FirebaseOptions;
import com.google.cloud.firestore.Firestore;

import com.google.cloud.firestore.FirestoreOptions;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class BusinessLayer {

    public static Firestore init() throws IOException {
        FirestoreOptions firestoreOptions =
                FirestoreOptions.getDefaultInstance().toBuilder()
                        .setProjectId("gamereview-bd4c3")
                        .setCredentials(GoogleCredentials.getApplicationDefault())
                        .build();
        return firestoreOptions.getService();
    }

    public void addReview(Map<String, Object> review) throws IOException, ExecutionException, InterruptedException {
        Firestore db = init();
        DocumentReference docRef = db.collection("reviews").document();

        ApiFuture<WriteResult> result = docRef.set(review);

        System.out.println("Update time : " + result.get().getUpdateTime());
    }
}

