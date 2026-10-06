interface Camera {
    void takePhoto();
}

interface VideoRecorder {
    void recordVideo();
}

class AndroidCamera implements Camera {
    public void takePhoto() {
        System.out.println("Android phone: Photo taken");
    }
}

class AndroidVideoRecorder implements VideoRecorder {
    public void recordVideo() {
        System.out.println("Android phone: Video recorded");
    }
}

class IPhoneCamera implements Camera {
    public void takePhoto() {
        System.out.println("iPhone: Photo taken");
    }
}

class IPhoneVideoRecorder implements VideoRecorder {
    public void recordVideo() {
        System.out.println("iPhone: Video recorded");
    }
}

interface MobileFactory {
    Camera createCamera();
    VideoRecorder createVideoRecorder();
}

class AndroidFactory implements MobileFactory {
    public Camera createCamera() {
        return new AndroidCamera();
    }

    public VideoRecorder createVideoRecorder() {
        return new AndroidVideoRecorder();
    }
}

class IPhoneFactory implements MobileFactory {
    public Camera createCamera() {
        return new IPhoneCamera();
    }

    public VideoRecorder createVideoRecorder() {
        return new IPhoneVideoRecorder();
    }
}

public class Q3 {
    public static void main(String[] args) {

        MobileFactory android = new AndroidFactory();
        Camera androidCamera = android.createCamera();
        VideoRecorder androidVideo = android.createVideoRecorder();
        androidCamera.takePhoto();
        androidVideo.recordVideo();

        System.out.println();

        MobileFactory iphone = new IPhoneFactory();
        Camera iphoneCamera = iphone.createCamera();
        VideoRecorder iphoneVideo = iphone.createVideoRecorder();
        iphoneCamera.takePhoto();
        iphoneVideo.recordVideo();
    }
}
