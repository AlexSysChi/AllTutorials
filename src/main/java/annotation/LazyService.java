package annotation;

@Service(name = "lazy")
public class LazyService {
    @Init
    public void lazyInit() throws Exception {
        System.out.printf("LazyService: lazyInit method");
    }
}
