import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class IPReflector {

    @GetMapping("/")
    public String getPublicIp() {
        String url = "https://api.ipify.org?format=text";
        RestTemplate restTemplate = new RestTemplate();
        String ip = restTemplate.getForObject(url, String.class);
        return "Your public IP address is: " + ip;
    }
}