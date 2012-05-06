import com.alibaba.fastjson.JSON;
import com.google.common.base.Stopwatch;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.joe.smart.Blog;
import com.joe.smart.User;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ZouYanjian
 * Date: 12-5-5
 * Time: 下午4:03
 * To change this template use File | Settings | File Templates.
 */
public class JsonTest {

    private User user = new User();
    private Stopwatch stopwatch = new Stopwatch();
    private Gson gson = new Gson();

    @Test
    public void shouldUserObjectConvertToJsonStringSuccessful() throws IOException {

        //Range range = Ranges.range(1, BoundType.CLOSED,10,BoundType.CLOSED);

        for (int i = 0; i < 20; i++) {
            createUser();
            System.out.println();
            fastJsonConvert();
            System.out.println();
            gsonConvert();
            System.out.println();
            jacksonConvert();
            System.out.println();
            jsonicConvert();
            System.out.println("--------------------------------------------------------------");
        }

    }

    private void gsonConvert() {
        stopwatch.reset();
        stopwatch.start();
        //Gson gson = new GsonBuilder().setPrettyPrinting().create();
       // Gson gson = new Gson();
        String gsonString = gson.toJson(user);
        stopwatch.stop();
        //System.out.println(gsonString);
        System.out.println("gson convert to json:" + stopwatch);
        System.out.println("gson string size:" + gsonString.length());

        stopwatch.reset();
        stopwatch.start();
        user = gson.fromJson(gsonString, User.class);
        stopwatch.stop();
        System.out.println("gson from json string to object" + " - " + stopwatch);
    }

    private void fastJsonConvert() {
        stopwatch.start();
//        String fastJsonString = JSON.toJSONString(user, SerializerFeature.WriteClassName);
        String fastJsonString = JSON.toJSONString(user);
        stopwatch.stop();
        //System.out.println(fastJsonString);
        System.out.println("fastjson convert to json:" + stopwatch);
        System.out.println("fastJson string size:" + fastJsonString.length());

        stopwatch.reset();
        stopwatch.start();
//        user = (User) JSON.parse(fastJsonString, Feature.SortFeidFastMatch);
        user = JSON.parseObject(fastJsonString, User.class);
        stopwatch.stop();
        System.out.println("fastjson from json string to object" + " - " + stopwatch);

    }

    private void jacksonConvert() throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        stopwatch.reset();
        stopwatch.start();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(outputStream, user);
        stopwatch.stop();
        System.out.println("jackson convert to json:" + stopwatch);
        outputStream.flush();
        String jackSonString = outputStream.toString();
        //System.out.println("JackSon string:" + jackSonString);
        System.out.println("jackSon size:" + jackSonString.length());

        stopwatch.reset();
        stopwatch.start();
        user = mapper.readValue(jackSonString, User.class);
        stopwatch.stop();
        System.out.println("jackson from json string to object" + " - " + stopwatch);
    }

    private void jsonicConvert() {
        stopwatch.reset();
        stopwatch.start();
        String jsonicString = net.arnx.jsonic.JSON.encode(user);
        stopwatch.stop();
        System.out.println("jsonic convert to json:" + stopwatch);
        // System.out.println("jsonic string:" + jsonicString);
        System.out.println("jsonic size:" + jsonicString.length());

        stopwatch.reset();
        stopwatch.start();
        user = net.arnx.jsonic.JSON.decode(jsonicString, User.class);
        stopwatch.stop();
        System.out.println("jsonic from json string to object" + " - " + stopwatch);

    }

    private void createUser() throws MalformedURLException {
        user.setAge(10);
        user.setBlogUrl(new URL("http://www.google.com"));
        user.setName("adfa");
        user.setBornDate(new Date(System.currentTimeMillis()));
        user.setBlogs(createBlogs());
    }

    private List<Blog> createBlogs() {
        List<Blog> blogs = Lists.newArrayList();
        Blog blog = new Blog();
        blog.setName("测试测试测试");
        blog.setContent("阿萨德发的发的发的发的发的是发送的法师打发的法师打发地方"+new Date()+System.currentTimeMillis());
        blog.setPublishDate(new Date());
        blogs.add(blog);

        blog = new Blog();
        blog.setName("测试测8试测试");
        blog.setContent("阿萨德发的发的发的7发的发的是发送的法师打发的法师打发地方"+new Date()+System.currentTimeMillis());
        blog.setPublishDate(new Date());
        blogs.add(blog);

        blog = new Blog();
        blog.setName("测试测试测5试");
        blog.setContent("阿萨德发4的发的发的发的发的是发送的法师打发的法师打发地方"+new Date()+System.currentTimeMillis());
        blog.setPublishDate(new Date());
        blogs.add(blog);

        blog = new Blog();
        blog.setName("测试测试6测试");
        blog.setContent("阿萨德发的发4的发的发的发的是发送的5法师打发的法师打发地方"+new Date()+System.currentTimeMillis());
        blog.setPublishDate(new Date());
        blogs.add(blog);
        return blogs;
    }
}
