package life_photo.recommend.controller;

import life_photo.recommend.service.PoseService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

@RestController
@RequestMapping("/randomPose")
public class RandomPoseController {

    private final PoseService poseService;

    @Autowired
    public RandomPoseController(PoseService poseService) {
        this.poseService = poseService;
    }

    @GetMapping(
            produces = MediaType.IMAGE_JPEG_VALUE
    )
    public @ResponseBody byte[] getImageWithMediaType() throws IOException {
        InputStream in = getClass().getResourceAsStream("/pose/"+poseService.randomPose()+".jpg");
        return IOUtils.toByteArray(in);
    }
}
