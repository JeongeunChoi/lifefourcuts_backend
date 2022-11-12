package life_photo.recommend.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class PoseService {

    public String randomPose(){
        Random random = new Random();
        String fileNum = String.valueOf(random.nextInt(15)+1);
        return fileNum;
    }
}
