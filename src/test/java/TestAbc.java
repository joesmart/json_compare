import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: ZouYanjian
 * Date: 12-5-5
 * Time: 下午1:00
 * To change this template use File | Settings | File Templates.
 */
public class TestAbc {
    @Test
    public void shouldReturnFalseInPreconditonsTest(){
        String s = "abc1";
        Assert.assertThat("adfadsf",s, IsEqual.equalTo("abc1"));
    }
}

