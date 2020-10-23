import com.company.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {


    @Test
    public  void test(){

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookService= context.getBean("BookServiceImpl", BookService.class);
        System.out.println(bookService.queryAllBook());
    }
}
