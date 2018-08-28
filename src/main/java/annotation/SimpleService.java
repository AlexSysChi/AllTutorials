package annotation;

@Service(name = "simple")
public class SimpleService {
    @Init
    public void initService() {
        System.out.println("SimpleService: initService method");
    }
    public void notInitMethod() {
        System.out.println("SimpleService: notInitMethod method");
    }
}
