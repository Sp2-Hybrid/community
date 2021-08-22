package com.songpeng.community;

import com.songpeng.community.dao.DiscussPostMapper;
import com.songpeng.community.dao.UserMapper;
import com.songpeng.community.entity.DiscussPost;
import com.songpeng.community.entity.Page;
import com.songpeng.community.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.ui.Model;

import java.util.*;

@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MapperTest {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DiscussPostMapper discussPostMapper;

    // @Test
    public void testSelectUser(){
        User user = userMapper.selectById(101);
        System.out.println(user);
    }

    // @Test
    public void testInsertUser(){
        User user = new User();
        user.setUsername("songpeng");
        user.setSalt("abd");
        user.setPassword("123456");
        user.setEmail("1171891648@qq.com");
        user.setHeaderUrl("http://www.nowcoder.com/101.png");
        user.setCreateTime(new Date());
        user.setStatus(1);
        user.setType(2);

        int rows = userMapper.insertUser(user);
        System.out.println(rows);
        System.out.println(user.getId());
    }

    // @Test
    public void updateUser(){
        int i = userMapper.updateStatus(150, 3);
        System.out.println(i);

        int i1 = userMapper.updateHeader(150, "http://www.nowcoder.com/102.png");
        System.out.println(i1);

        int zhouhang = userMapper.updatePassword(150, "zhouhang");
        System.out.println(zhouhang);
    }

    // @Test
    public void testSelectPosts(){
        List<DiscussPost> list = discussPostMapper.selectDiscussPosts(101, 0, 10);
        for (DiscussPost discussPost : list) {
            System.out.println(discussPost);
        }

        int rows = discussPostMapper.selectDiscussPostRows(101);
        System.out.println(rows);
    }

    // @Test
    public void getIndexPage() {
        // 方法调用钱,SpringMVC会自动实例化Model和Page,并将Page注入Model.
        // 所以,在thymeleaf中可以直接访问Page对象中的数据.

        List<DiscussPost> list = this.discussPostMapper.selectDiscussPosts(0, 0, 5);
        List<Map<String, Object>> discussPosts = new ArrayList<>();
        if (list != null) {
            for (DiscussPost post : list) {
                Map<String, Object> map = new HashMap<>();
                map.put("post", post);
                User user = this.userMapper.selectById(post.getUserId());
                map.put("user", user);
                discussPosts.add(map);
            }
        }
        for (Map<String, Object> discussPost : discussPosts) {
            System.out.println(discussPost);
        }
    }
}
