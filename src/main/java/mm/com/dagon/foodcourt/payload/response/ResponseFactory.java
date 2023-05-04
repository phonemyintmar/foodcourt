package mm.com.dagon.foodcourt.payload.response;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ResponseFactory {

    public static ResponseEntity<?> onSuccessWithMessage(Object result, String code, String message) {
        // for now just make the code string
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setResult(result);
        baseResponse.setCode(code);
        baseResponse.setMessage(message);
        baseResponse.setResponseAt(LocalDateTime.now());
        return ResponseEntity.ok(baseResponse);
    }

    public static ResponseEntity<?> onSuccessDefault(Object result) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setResult(result);
        baseResponse.setCode("000");
        baseResponse.setMessage("The action is successful");
        baseResponse.setResponseAt(LocalDateTime.now());
        return ResponseEntity.ok(baseResponse);
    }

    public static ResponseEntity<?> onFailDefault() {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setResponseAt(LocalDateTime.now());
        baseResponse.setCode("199");
        baseResponse.setMessage("The action has failed");
        baseResponse.setResult(null);
        return ResponseEntity.badRequest().body(baseResponse);
    }

    public static ResponseEntity<?> onFailWithMessage(String code, String message) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setResponseAt(LocalDateTime.now());
        baseResponse.setCode(code);
        baseResponse.setMessage(message);
        baseResponse.setResult(null);
        return ResponseEntity.badRequest().body(baseResponse);

    }
}
