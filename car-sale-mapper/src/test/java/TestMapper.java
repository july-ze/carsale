import com.hzit.mapper.AdminLogMapper;
import com.hzit.mapper.SaleMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestMapper {

    @Autowired
    AdminLogMapper dao;
    @Autowired
    SaleMapper saleMapper;


    @Test
    public void testGetAll() {
        System.out.println(dao.selectByPrimaryKey(1));

    }
    @Test
    public void test01() {
        System.out.println(saleMapper.selectByCompanyId(1));
    }
}